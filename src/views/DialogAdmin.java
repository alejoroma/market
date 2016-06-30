package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Action;
import controller.Controller;
import models.entity.Product;
import models.entity.TypeProduct;

public class DialogAdmin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static String[] HEAD = {"Id", "Name", "Type of Person", "Type of Product", "Value", "Actions"};
	private DefaultTableModel tableModel;
	private JTable tableProductList;
	private JLabel lbPage;
	private JComboBox<TypeProduct> typeCategory;

	public DialogAdmin(Controller controller) {
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(pantalla.width, pantalla.height);
		setTitle("Flea Market");
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel pnlFondo = new JPanel();
		pnlFondo.setOpaque(false);
		pnlFondo.setLayout(null);
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBackground(Color.decode("#333333"));
		pnlHeader.setBounds(200, 0, getWidth()-200, 35);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setBorder(null);
		btnAdmin.setIcon(new ImageIcon(getClass().getResource("/imgs/admin.png")));
		btnAdmin.setContentAreaFilled(false);
		btnAdmin.setBounds(pnlHeader.getWidth()-240, 5, 100, 30);
		pnlHeader.add(btnAdmin);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon(getClass().getResource("/imgs/salir.png")));
		btnLogout.setBounds(pnlHeader.getWidth()-130, 5, 100, 30);
		btnLogout.setBorder(null);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.addActionListener(controller);
		btnLogout.setActionCommand(Action.LOGOUT.name());
		btnLogout.setContentAreaFilled(false);
		pnlHeader.add(btnLogout);
		
		pnlFondo.add(pnlHeader);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setOpaque(false);
		pnlButtons.setLayout(null);
		pnlButtons.setBounds(210, 50, getWidth(), 120);
		pnlFondo.add(pnlButtons);
		
		JButton btnAdd = new JButton(new ImageIcon(getClass().getResource("/imgs/add.png")));
		btnAdd.setBounds(0, 50, 120, 35);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorder(null);
		btnAdd.addActionListener(controller);
		btnAdd.setActionCommand(Action.SHOW_DIALOD_ADD.name());
		pnlButtons.add(btnAdd);
		
		JLabel lbFilterForType = new JLabel("filtrar por:");
		lbFilterForType.setBounds(320, 60, 80, 50);
		pnlButtons.add(lbFilterForType);
		
		typeCategory = new JComboBox<TypeProduct>(TypeProduct.values());
		typeCategory.setBounds(390, 70, 100, 28);
		pnlButtons.add(typeCategory);
		
		JTextField txtSearch = new JTextField("Search");
		txtSearch.setBounds(490, 70, 300, 30);
		pnlButtons.add(txtSearch);
		
		JButton btnSearch = new JButton(new ImageIcon(getClass().getResource("/imgs/search.png")));
		btnSearch.setBounds(783, 60, 45, 45);
		btnSearch.setBorder(null);
		btnSearch.setContentAreaFilled(false);
		btnSearch.addActionListener(controller);
		btnSearch.setActionCommand(Action.FILTER_FOR_TYPE_PRODUCT.name());
		pnlButtons.add(btnSearch);
	
		JLabel lbProducts = new JLabel("Products  ");
		lbProducts.setOpaque(true);
		lbProducts.setForeground(Color.BLACK);
		lbProducts.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		lbProducts.setHorizontalAlignment(SwingConstants.RIGHT);
		lbProducts.setBounds(0, 10, pnlButtons.getWidth()-240, 30);
		pnlButtons.add(lbProducts);
		
		JPanel pnlMenu = new JPanel();	
		//pnlMenu.setOpaque(false);
		pnlMenu.setBackground(Color.decode("#333333"));
		pnlMenu.setLayout(null);
		pnlMenu.setBounds(0, 0, 200, getHeight());
		
		JLabel lbLogo = new JLabel(new ImageIcon(getClass().getResource("/imgs/logo.png")));
		lbLogo.setBounds(0, 5, 200, 105);
		pnlMenu.add(lbLogo);
		
		JLabel lbProduct = new JLabel("   Products   ");
		lbProduct.setIcon(new ImageIcon(getClass().getResource("/imgs/products.png")));
		lbProduct.setOpaque(true);
		lbProduct.setFont(new Font("'proxima_nova','Helvetica Neue',Helvetica,Arial,sans-serif", Font.BOLD, 14));
		lbProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lbProduct.setBounds(0, 140, 200, 50);
		lbProduct.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lbProduct.setForeground(Color.decode("#121314"));
		lbProduct.setBackground(Color.decode("#a3a3a3"));
		pnlMenu.add(lbProduct);
		
		pnlFondo.add(pnlMenu);
		
		
		JPanel pnlTable = new JPanel();
		pnlTable.setBounds(210, 170, getWidth()-240, getHeight()-345);
		pnlTable.setBackground(Color.WHITE);
		pnlTable.setLayout(new GridLayout(1, 1));
		add(pnlTable, BorderLayout.CENTER);
		
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(HEAD);
		tableProductList = new JTable(tableModel);
		tableProductList.setRowHeight(40);
		pnlTable.add(tableProductList);
		
		TableRender model = new TableRender();
		CellEditor cellEditor = new CellEditor(controller);
		model.setHorizontalAlignment(SwingConstants.CENTER);
		
		tableProductList.setDefaultRenderer(Object.class, model);
		tableProductList.setDefaultEditor(Object.class, cellEditor);
		tableProductList.getTableHeader().setBackground(Color.WHITE);
		
		JScrollPane scroll = new JScrollPane(tableProductList);
		scroll.setBounds(210, 170, getWidth()-240, getHeight()-345);
		scroll.setBackground(Color.WHITE);
		pnlTable.add(scroll);
		
		pnlFondo.add(pnlTable);
		
		JPanel pnlPage = new JPanel();
		pnlPage.setOpaque(false);
		pnlPage.setBackground(Color.WHITE);
		pnlPage.setBounds(210, getHeight()-140, getWidth()-240, 55);
		
		JButton btnFirst = new JButton(new ImageIcon(getClass().getResource("/imgs/primero.png")));
		btnFirst.setContentAreaFilled(false);
		btnFirst.setBorder(null);
		pnlPage.add(btnFirst);
		
		JButton btnPreview = new JButton(new ImageIcon(getClass().getResource("/imgs/anterior.png")));
		btnPreview.setContentAreaFilled(false);
		btnPreview.setBorder(null);
		btnPreview.addActionListener(controller);
		btnPreview.setActionCommand(Action.PAGE_PREVIEW.name());
		pnlPage.add(btnPreview);
		
		lbPage = new JLabel(" 1 ");
		lbPage.setBackground(Color.WHITE);
		pnlPage.add(lbPage);
		
		JButton btnNext = new JButton(new ImageIcon(getClass().getResource("/imgs/siguiente.png")));
		btnNext.setContentAreaFilled(false);
		btnNext.setBorder(null);
		btnNext.addActionListener(controller);
		btnNext.setActionCommand(Action.PAGE_NEXT.name());
		pnlPage.add(btnNext);
		
		JButton btnLastest = new JButton(new ImageIcon(getClass().getResource("/imgs/ultimo.png")));
		btnLastest.setContentAreaFilled(false);
		btnLastest.setBorder(null);
		pnlPage.add(btnLastest);
		
		pnlFondo.add(pnlPage);
		
		add(pnlFondo, BorderLayout.CENTER);
	}

	public void addPage(int pageActual, int pageTotal) {
		this.lbPage.setText("" + pageActual + " de " + pageTotal );
	}
	
	public void addToTable(Object[] product) {
			tableModel.addRow(product);
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public int getProduct() {
		System.out.println(tableProductList.getSelectedRow());
		return Integer.parseInt(tableModel.getValueAt(tableProductList.getSelectedRow(), 0).toString());
	}
	
	public void removeRow() {
		tableModel.removeRow(tableProductList.getSelectedRow());
		tableModel.fireTableStructureChanged();
	}
	
	public void removePage() {
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}
	
	public void deleteAllItems(){
		tableProductList.removeAll();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			for (int j = 0; j < tableModel.getRowCount(); j++) {
				tableModel.removeRow(j);
			}
		}
	}
	
	public void filterForCategory(ArrayList<Product> productListForCategory, Object[] actions){
		deleteAllItems();
		for (Product product : productListForCategory) {
			addToTable(product.getAdminProduct(actions));
			System.out.println("agrego");
		}
		revalidate();
	}
	
	public TypeProduct getTypeCategorySelected(){
		return (TypeProduct) typeCategory.getSelectedItem();
	}

	public int logout() {
		return 0;
	}
}