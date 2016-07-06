package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import controller.Action;
import controller.Controller;
import models.entity.Product;
import models.entity.TypePerson;
import models.entity.TypeProduct;

public class WindowAdmin extends JFrame {
	
	private static final String FILE_IMG_VIEW_REPORT = "/imgs/binoculares.png";
	private static final String FILE_IMG_FINISH_PAGE = "/imgs/ultimo.png";
	private static final String FILE_IMG_NEXT_PAGE = "/imgs/siguiente.png";
	private static final String FILE_IMG_PREVIEW_PAGE = "/imgs/anterior.png";
	private static final String FILE_IMG_FIRST_PAGE = "/imgs/primero.png";
	private static final String FILE_IMG_PRODUCTS = "/imgs/products.png";
	private static final String FILE_IMG_LOGO = "/imgs/logo.png";
	private static final String FILE_IMG_SEARCH = "/imgs/search.png";
	private static final String FILE_IMG_ADD_NEW = "/imgs/addNew.png";
	private static final String FILE_EXIT = "/imgs/salir.png";
	private static final String FILE_ADMIN = "/imgs/admin.png";
	private static final String FILE_ICON = "/imgs/icon.png";
	private static final String FILE_IMG_PRINT = "/imgs/impresora.png";
	private static final long serialVersionUID = 1L;
	private static String[] HEAD = {"Id", "Name", "Type of Person", "Type of Product", "Value", "Actions"};
	private DefaultTableModel tableModel;
	private JTable tableProductList;
	private JLabel lbPage;
	private JComboBox<TypeProduct> typeCategory;
	private JRadioButton jrMen, jrWomen, jrMenAndWomen;
	private int page;

	public WindowAdmin(Controller controller) {
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(pantalla.width, pantalla.height);
		setTitle("Flea Market");
		setIconImage(new ImageIcon(getClass().getResource(FILE_ICON)).getImage());
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
		btnAdmin.setIcon(new ImageIcon(getClass().getResource(FILE_ADMIN)));
		btnAdmin.setContentAreaFilled(false);
		btnAdmin.setBounds(pnlHeader.getWidth()-240, 5, 100, 30);
		pnlHeader.add(btnAdmin);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon(getClass().getResource(FILE_EXIT)));
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
		
		JLabel lbProducts = new JLabel("Products  ");
		lbProducts.setOpaque(true);
		lbProducts.setForeground(Color.BLACK);
		lbProducts.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		lbProducts.setHorizontalAlignment(SwingConstants.RIGHT);
		lbProducts.setBounds(0, 10, pnlButtons.getWidth()-240, 30);
		pnlButtons.add(lbProducts);
		
		JButton btnAdd = new JButton(new ImageIcon(getClass().getResource(FILE_IMG_ADD_NEW)));
		btnAdd.setBounds(0, 50, 120, 35);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorder(null);
		btnAdd.addActionListener(controller);
		btnAdd.setActionCommand(Action.SHOW_DIALOD_ADD.name());
		pnlButtons.add(btnAdd);
		
		JLabel lbFilterForType = new JLabel("Filter for type:");
		lbFilterForType.setBounds(300, 60, 80, 50);
		pnlButtons.add(lbFilterForType);
		
		typeCategory = new JComboBox<TypeProduct>(TypeProduct.values());
		typeCategory.setBounds(390, 70, 100, 28);
		pnlButtons.add(typeCategory);
		
		jrMen = new  JRadioButton("Men");
		jrMen.setBounds(500, 60, 50, 50);
		pnlButtons.add(jrMen);
		
		jrWomen = new  JRadioButton("Women");
		jrWomen.setBounds(560, 60, 80, 50);
		pnlButtons.add(jrWomen);
		
		jrMenAndWomen = new  JRadioButton("Men and Women");
		jrMenAndWomen.setBounds(640, 60, 120, 50);
		pnlButtons.add(jrMenAndWomen);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(jrMen);
	    group.add(jrWomen);
	    group.add(jrMenAndWomen);
		
		JButton btnSearch = new JButton(new ImageIcon(getClass().getResource(FILE_IMG_SEARCH)));
		btnSearch.setBounds(760, 60, 45, 45);
		btnSearch.setBorder(null);
		btnSearch.setContentAreaFilled(false);
		btnSearch.addActionListener(controller);
		btnSearch.setActionCommand(Action.FILTER_FOR_TYPE_PRODUCT.name());
		pnlButtons.add(btnSearch);
		
		JButton btnViewAll = new JButton("View All");
		btnViewAll.setBackground(Color.decode("#2b82ad"));
		btnViewAll.setBounds(820, 65, 80, 35);
		btnViewAll.addActionListener(controller);
		btnViewAll.setActionCommand(Action.VIEW_ALL.name());
		pnlButtons.add(btnViewAll);
		
		JButton btnViewReport = new JButton(new ImageIcon(getClass().getResource(FILE_IMG_VIEW_REPORT)));
		btnViewReport.setBorder(null);
		btnViewReport.setContentAreaFilled(false);
		btnViewReport.addActionListener(controller);
		btnViewReport.setActionCommand(Action.SHOW_REPORT.name());
		btnViewReport.setToolTipText("View report");
		btnViewReport.setBounds(pnlButtons.getWidth()-350, 60, 40, 45);
		pnlButtons.add(btnViewReport);
	
		JButton btnPrint = new JButton(new ImageIcon(getClass().getResource(FILE_IMG_PRINT)));
		btnPrint.setBorder(null);
		btnPrint.addActionListener(controller);
		btnPrint.setActionCommand(Action.PRINT.name());
		btnPrint.setContentAreaFilled(false);
		btnPrint.setToolTipText("Print");
		btnPrint.setBounds(pnlButtons.getWidth()-300, 60, 40, 45);
		
		pnlButtons.add(btnPrint);
		
		JPanel pnlMenu = new JPanel();	
		pnlMenu.setBackground(Color.decode("#333333"));
		pnlMenu.setLayout(null);
		pnlMenu.setBounds(0, 0, 200, getHeight());
		
		JLabel lbLogo = new JLabel(new ImageIcon(getClass().getResource(FILE_IMG_LOGO)));
		lbLogo.setBounds(0, 5, 200, 105);
		pnlMenu.add(lbLogo);
		
		JLabel lbProduct = new JLabel("   Products   ");
		lbProduct.setIcon(new ImageIcon(getClass().getResource(FILE_IMG_PRODUCTS)));
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
		
		TableColumnModel columnModel =  tableProductList.getColumnModel();
		columnModel.getColumn(0).setMinWidth(100);
		columnModel.getColumn(1).setMaxWidth(100);
		columnModel.getColumn(4).setMaxWidth(100);
		
		pnlFondo.add(pnlTable);
		
		JPanel pnlPage = new JPanel();
		pnlPage.setOpaque(false);
		pnlPage.setBackground(Color.WHITE);
		pnlPage.setBounds(210, getHeight()-140, getWidth()-240, 55);
		
		JButton btnFirst = new JButton(new ImageIcon(getClass().getResource(FILE_IMG_FIRST_PAGE)));
		btnFirst.setContentAreaFilled(false);
		btnFirst.setBorder(null);
		pnlPage.add(btnFirst);
		
		JButton btnPreview = new JButton(new ImageIcon(getClass().getResource(FILE_IMG_PREVIEW_PAGE)));
		btnPreview.setContentAreaFilled(false);
		btnPreview.setBorder(null);
		btnPreview.addActionListener(controller);
		btnPreview.setActionCommand(Action.PAGE_PREVIEW_ADMIN.name());
		pnlPage.add(btnPreview);
		
		lbPage = new JLabel();
		lbPage.setBackground(Color.WHITE);
		pnlPage.add(lbPage);
		
		JButton btnNext = new JButton(new ImageIcon(getClass().getResource(FILE_IMG_NEXT_PAGE)));
		btnNext.setContentAreaFilled(false);
		btnNext.setBorder(null);
		btnNext.addActionListener(controller);
		btnNext.setActionCommand(Action.PAGE_NEXT_ADMIN.name());
		pnlPage.add(btnNext);
		
		JButton btnLastest = new JButton(new ImageIcon(getClass().getResource(FILE_IMG_FINISH_PAGE)));
		btnLastest.setContentAreaFilled(false);
		btnLastest.setBorder(null);
		pnlPage.add(btnLastest);
		
		pnlFondo.add(pnlPage);
		
		add(pnlFondo, BorderLayout.CENTER);
	}

	public void addPage(int pageActual, int pageTotal) {
		this.lbPage.setText("" + pageActual + " de " + pageTotal );
	}
	
	public void addToTable(ArrayList<Product> produtos, Controller controller) {
		for (int i = produtos.size() - 1; i >= 0; i--) {
			Object[] entrada = produtos.get(i).getAdminProduct(new PanelActionAdmin(controller));
			tableModel.addRow(entrada);
			tableModel.fireTableStructureChanged();
		}
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public int obtenerIDProductoSelecionado() {
		return Integer.parseInt(tableModel.getValueAt(tableProductList.getSelectedRow(), 0).toString());
	}
	
	public void paguinaActual(int paginaActual, int totalPaginas){
		page = paginaActual;
		lbPage.setText(paginaActual + "/" + totalPaginas);
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
	
//	public void filterForCategory(ArrayList<Product> productListForCategory, Controller controller){
//		removePage();
//		for (Product product : productListForCategory) {
//			addToTable(product.getAdminProduct(new PanelActionAdmin(controller)));
//		}
//		revalidate();
//	}
	
	public TypeProduct getTypeCategorySelected(){
		return (TypeProduct) typeCategory.getSelectedItem();
	}
	
	public int getPage() {
		return page;
	}

	public TypePerson getTypePersonSelected(){
		if (jrMen.isSelected()) {
			return  TypePerson.MEN;
		}
		if (jrWomen.isSelected()) {
			return TypePerson.WOMEN;
		}
		return TypePerson.MEN_AND_WOMEN;
	}
	
	public void imprimirFile(){
		try {
			MessageFormat headerFormat = new MessageFormat("page {0}");
			MessageFormat fooFormat = new MessageFormat("-{0}-");
			tableProductList.print(JTable.PrintMode.FIT_WIDTH,headerFormat,fooFormat);
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public int  logout(){
		 UIManager UI=new UIManager();
		 UI.put("OptionPane.background", Color.white);
		 UI.put("Panel.background", Color.white);
	    JButton button1= new JButton("Cancelar");
	    button1.setBackground(Color.decode("#2980B9"));
	    button1.setFont(new Font("Arial Black", Font.PLAIN, 12));
	    button1.setForeground(Color.WHITE);
	    
	    JButton button2= new JButton("Aceptar");
	    button2.setBackground(Color.decode("#52BE80"));
	    button2.setFont(new Font("Arial Black", Font.PLAIN, 12));
	    button2.setForeground(Color.WHITE);
	   
	    button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = getOptionPane((JComponent)e.getSource());
                pane.setValue(JOptionPane.OK_OPTION);
            }
        });
	    
	    button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = getOptionPane((JComponent)e.getSource());
                pane.setValue(JOptionPane.CANCEL_OPTION);
            }
        });
	    
	    JOptionPane myOptionPane = new JOptionPane("Esta seguro que desea salir?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION,  new ImageIcon("src/imgs/png/logout.png"),new Object [] { button1, button2},button2);
	    JDialog myDialog = myOptionPane.createDialog(null, "Logout");
	     myDialog.setModal(true);
	     myDialog.setVisible(true);
	     Object result = myOptionPane.getValue();
	     return Integer.parseInt(result +"");	
	}	
	
	protected static JOptionPane getOptionPane(JComponent parent) {
	    JOptionPane pane;
	    if (!(parent instanceof JOptionPane)) {
	        pane = getOptionPane((JComponent) parent.getParent());
	    } else {
	        pane = (JOptionPane) parent;
	    }
	    return pane;
	}
	
   @SuppressWarnings("unused")
private static void inactivateOption(Container container, String text) {
      Component[] comps = container.getComponents();
      for (Component comp : comps) {
         if (comp instanceof AbstractButton) {
            AbstractButton btn = (AbstractButton) comp;
            if (btn.getActionCommand().equals(text)) {
               btn.setEnabled(false);
               return;
            }
         } else if (comp instanceof Container) {
            inactivateOption((Container) comp, text);
         }
      }
   }
}