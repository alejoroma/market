package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

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
		pnlHeader.setBackground(Color.BLACK);
		pnlHeader.setBounds(0, 0, getWidth(), 35);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setBorder(null);
		btnAdmin.setIcon(new ImageIcon(getClass().getResource("/imgs/admin.png")));
		btnAdmin.setContentAreaFilled(false);
		btnAdmin.setBounds(getWidth()-260, 5, 190, 30);
		pnlHeader.add(btnAdmin);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBorder(null);
		btnLogout.setIcon(new ImageIcon(getClass().getResource("/imgs/salir.png")));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.addActionListener(controller);
		btnLogout.setActionCommand(Action.LOGOUT.name());
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBounds(getWidth()-170, 5, 180, 30);
		pnlHeader.add(btnLogout);
		
		pnlFondo.add(pnlHeader);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setOpaque(false);
		pnlButtons.setLayout(null);
		//pnlButtons.setBorder(BorderFactory.createTitledBorder("panel botones"));
		pnlButtons.setBounds(210, 50, getWidth(), 120);
		pnlFondo.add(pnlButtons);
		
		JButton btnAdd = new JButton("Add Product");
		btnAdd.setBounds(0, 50, 120, 35);
		btnAdd.setBackground(Color.decode("#067ab4"));
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
		pnlButtons.add(btnSearch);
	
		JLabel lbProducts = new JLabel("  Products");
		lbProducts.setOpaque(true);
		lbProducts.setForeground(Color.BLACK);
		//lbProducts.setBackground(Color.decode("#a5acaf"));
		lbProducts.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lbProducts.setBounds(0, 10, pnlButtons.getWidth()-240, 30);
		pnlButtons.add(lbProducts);
		
		JPanel pnlMenu = new JPanel();	
		pnlMenu.setOpaque(false);
		pnlMenu.setLayout(null);
		pnlMenu.setBounds(0, 50, 200, getHeight());
		
		JLabel lbLogo = new JLabel(new ImageIcon(getClass().getResource("/imgs/logo.png")));
		lbLogo.setBounds(0, 5, 200, 105);
		pnlMenu.add(lbLogo);
		
		JLabel lbProduct = new JLabel("Products");
		lbProduct.setOpaque(true);
		lbProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lbProduct.setBounds(0, 120, 200, 50);
		lbProduct.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lbProduct.setForeground(Color.WHITE);
		lbProduct.setBackground(Color.BLACK);
		pnlMenu.add(lbProduct);
		
		pnlFondo.add(pnlMenu);
		
		
		JPanel pnlTable = new JPanel();
		pnlTable.setBorder(BorderFactory.createTitledBorder("PANEL TABLA"));
		pnlTable.setBounds(210, 170, getWidth()-240, getHeight()-300);
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
		scroll.setBounds(210, 170, getWidth()-240, getHeight()-300);
		scroll.setBackground(Color.WHITE);
		pnlTable.add(scroll);
		
		pnlFondo.add(pnlTable);
		
		JPanel pnlPage = new JPanel();
		pnlPage.setBackground(Color.WHITE);
		pnlPage.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(pnlPage, BorderLayout.SOUTH);
		
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
		
		add(pnlFondo, BorderLayout.CENTER);
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