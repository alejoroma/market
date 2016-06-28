package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.Action;
import controller.Controller;

public class DialogAdmin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static String[] HEAD = {"Id", "Name", "Type of Person", "Type of Product", "Value", "Actions"};
	private DefaultTableModel tableModel;
	private JTable tableProductList;
	private JButton btnAdd;
	private JLabel lbPage;

	public DialogAdmin(Controller controller) {
		setTitle("Crud-Product 1.0");
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		
		JPanel pnlTable = new JPanel();
		pnlTable.setBackground(Color.WHITE);
		pnlTable.setLayout(new GridLayout(1, 1));
		add(pnlTable, BorderLayout.CENTER);
		
		JPanel pnlAction = new JPanel();
		pnlAction.setBackground(Color.WHITE);
		pnlAction.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(pnlAction, BorderLayout.NORTH);
		
		JPanel pnlPage = new JPanel();
		pnlPage.setBackground(Color.WHITE);
		pnlPage.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(pnlPage, BorderLayout.SOUTH);
		
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
		scroll.setBackground(Color.WHITE);
		add(scroll);
		
		btnAdd = new JButton("Add Product");
		btnAdd.setBackground(Color.decode("#2E64FE"));
		btnAdd.addActionListener(controller);
		btnAdd.setActionCommand(Action.SHOW_DIALOD_ADD.name());
		pnlAction.add(btnAdd);
		
		JButton btnFirst = new JButton("<");
		btnFirst.setBackground(Color.decode("#FE9A2E"));
		pnlPage.add(btnFirst);
		JButton btnPreview = new JButton(new ImageIcon(getClass().getResource("/imgs/anterior.png")));
		btnPreview.setBackground(Color.decode("#FE9A2E"));
		btnPreview.addActionListener(controller);
		btnPreview.setActionCommand(Action.PAGE_PREVIEW.name());
		pnlPage.add(btnPreview);
		lbPage = new JLabel("1");
		lbPage.setBackground(Color.WHITE);
		pnlPage.add(lbPage);
		JButton btnNext = new JButton(new ImageIcon(getClass().getResource("/imgs/siguiente.png")));
		btnNext.setBackground(Color.decode("#FE9A2E"));
		btnNext.addActionListener(controller);
		btnNext.setActionCommand(Action.PAGE_NEXT.name());
		pnlPage.add(btnNext);
		JButton btnLastest = new JButton(">");
		btnLastest.setBackground(Color.decode("#FE9A2E"));
		pnlPage.add(btnLastest);
	}

	public void addPage(int page) {
		this.lbPage.setText("" + page);
	}
	
	public void addToTable(Object[] product) {
			tableModel.addRow(product);
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public int getProduct() {
		return Integer.parseInt(tableModel.getValueAt(tableProductList.getSelectedRow(), 0).toString());
	}
	
	public void removeRow() {
		tableModel.removeRow(tableProductList.getSelectedRow());
	}
	
	public void removePage() {
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}
	
	public static void main(String[] args) {
		new DialogAdmin(null);
	}
	/*
	 *  crear una ventana de usuario y administrador
	 *  en admin colocar lo basico en la tabla y colocar los detalles con lo q falta en la tabla
	 *  mostrar los primeros 10 productos al ingresar, los errores es un text area, iconos
	 *  hacer lo de elimnar, editar, detalles  
	 *  en usuario hacer filtro
	 */
}