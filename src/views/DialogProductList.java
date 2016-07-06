package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Action;
import controller.Controller;

public class DialogProductList extends JDialog{

	private static final long serialVersionUID = 1L;
	private static final String FILE_IMG_ICON = "/imgs/icon.png";
	private DefaultTableModel tableModel;
	private JTable productList;
	private static String[] HEAD = {"Image", "Date", "Name", "Value", "Action"};
	private double valueAbsolute;
	private JPanel pnlResult;
	private int numberProduct = 1;

	public DialogProductList(Controller controller) {
		setSize(500, 500);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon(getClass().getResource(FILE_IMG_ICON)).getImage());
		
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(HEAD);
		productList = new JTable(tableModel);
		productList.setRowHeight(50);
		productList.setGridColor(Color.WHITE);
		
		TableRender model = new TableRender();
		model.setHorizontalAlignment(SwingConstants.CENTER);
		
		productList.setDefaultRenderer(Object.class, model);
		productList.setDefaultEditor(Object.class, new CellEditorProduct(controller));
		productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(productList, BorderLayout.CENTER);
		
		JScrollPane scroll = new JScrollPane(productList);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.getViewport().setBackground(Color.WHITE);
		scroll.setBackground(Color.WHITE);
		scroll.setOpaque(true);	
		
		add(scroll, BorderLayout.CENTER);
		 pnlResult = new JPanel();
		 pnlResult.setLayout(new FlowLayout(FlowLayout.CENTER));
	}

	public void addProduct(Controller controller, String image, String date, String name, double value) {
		JLabel lbImage = new JLabel();
		lbImage.setHorizontalAlignment(SwingConstants.LEFT);
		Image img = new ImageIcon(image).getImage().getScaledInstance(80, -1, java.awt.Image.SCALE_AREA_AVERAGING);
		lbImage.setIcon(new ImageIcon(img));
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBackground(Color.decode("#49a942"));
		btnBuy.addActionListener(controller);
		btnBuy.setActionCommand(Action.BUY_PRODUCT.name());
		
		Object[] element = {lbImage,date, name, value, btnBuy};
		getValueAbsolute(controller, (valueAbsolute += value));
		tableModel.addRow(element);
	}
	
	public void getValueAbsolute(Controller controller, double value) {
		pnlResult.removeAll();
		JLabel lbValueAbsolute = new JLabel("Number of products:  " + numberProduct + "  Value Absolute : " + value);
		pnlResult.add(lbValueAbsolute);
		
		JButton btnBuyAll = new JButton("Buy All");
		btnBuyAll.setBackground(Color.decode("#c1d82f"));
		btnBuyAll.addActionListener(controller);
		btnBuyAll.setActionCommand(Action.BUY_ALL.name());
		pnlResult.add(btnBuyAll);
		add(pnlResult, BorderLayout.SOUTH);
		pnlResult.updateUI();
	}
	
	public double getValueAbsoluteUpdate() {
		double value = 0.0;
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			value += (double)tableModel.getValueAt(i, 3);
		}
		return value;
	}
	
	public void buyProduct() {
		tableModel.removeRow(productList.getSelectedRow());
		tableModel.fireTableStructureChanged();
	}
	
	public void buyAllProducts() {
			for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
				tableModel.removeRow(i);
			}
	}
	
	public int getNumberProduct(){
		return numberProduct;
	}
}