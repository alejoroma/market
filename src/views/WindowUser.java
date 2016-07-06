package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.entity.Product;
import models.entity.TypePerson;
import models.entity.TypeProduct;
import controller.Action;
import controller.Controller;

public class WindowUser extends JFrame {

	private static final String FILE_IMG_SHOPING = "/imgs/shoping.png";
	private static final String FILE_IMG_CAR = "/imgs/car.png";
	private static final String FILE_IMG_ICON = "/imgs/icon.png";
	private static final String FILE_EXIT = "/imgs/salir.png";
	private static final String FILE_ADMIN = "/imgs/admin.png";
	private static final String FILE_IMG_LOGO = "/imgs/logo.png";
	private static final long serialVersionUID = 1L;
	private JLabel lbPage;
	private JTextField txtValueFilter;
	private JPanel pnlProducts;
	public static Controller controller;

	public WindowUser(Controller controller) {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(pantalla.width, pantalla.height);
		setTitle("Flea Market");
		setIconImage(new ImageIcon(getClass().getResource(FILE_IMG_ICON)).getImage());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel pnlFondo = new JPanel();
		pnlFondo.setOpaque(false);
		pnlFondo.setLayout(null);
        
        JPanel pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBackground(Color.decode("#d7d7d8"));
		pnlHeader.setBounds(200, 0, pantalla.width-200, 35);
		
		JButton btnUser = new JButton("User");
		btnUser.setForeground(Color.BLACK);
		btnUser.setBorder(null);
		btnUser.setIcon(new ImageIcon(getClass().getResource(FILE_ADMIN)));
		btnUser.setContentAreaFilled(false);
		btnUser.setBounds(pnlHeader.getWidth()-190, 5, 100, 30);
		pnlHeader.add(btnUser);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon(getClass().getResource(FILE_EXIT)));
		btnLogout.setBounds(pnlHeader.getWidth()-98, 5, 100, 30);
		btnLogout.setBorder(null);
		btnLogout.setForeground(Color.BLACK);
		btnLogout.addActionListener(controller);
		btnLogout.setActionCommand(Action.LOGOUT.name());
		btnLogout.setContentAreaFilled(false);
		pnlHeader.add(btnLogout);
		
		pnlFondo.add(pnlHeader);
		
		add(pnlFondo, BorderLayout.CENTER);
        
		pnlProducts = new JPanel();
		pnlProducts.setBackground(Color.WHITE);
		pnlProducts.setLayout(new GridLayout(3, 6, 40, 40));
		pnlProducts.setBounds(200, 35, pantalla.width-200, pantalla.height-155);
		pnlFondo.add(pnlProducts, BorderLayout.CENTER);
		
		JPanel pnlMenu = new JPanel();	
		pnlMenu.setBackground(Color.decode("#d7d7d8"));
		pnlMenu.setLayout(null);
		pnlMenu.setBounds(0, 0, 200, getHeight());
		
		JLabel lbLogo = new JLabel(new ImageIcon(getClass().getResource(FILE_IMG_LOGO)));
		lbLogo.setBounds(0, 5, 200, 105);
		pnlMenu.add(lbLogo);
		
		JButton btnShoopingCar = new JButton("Purchases");
		btnShoopingCar.setForeground(Color.BLACK);
		btnShoopingCar.setBackground(Color.decode("#eb5424"));
		btnShoopingCar.setIcon(new ImageIcon(getClass().getResource(FILE_IMG_CAR)));
		btnShoopingCar.addActionListener(controller);
		btnShoopingCar.setBounds(20, 140, 140, 60);
		btnShoopingCar.setActionCommand(Action.SHOW_DIALOGSHOPING.name());
		pnlMenu.add(btnShoopingCar);
		
		pnlFondo.add(pnlMenu);
		
		JPanel pnlPage = new JPanel();
		pnlPage.setBounds(200, getHeight()-120, getWidth()-40, 55);
		pnlPage.setBackground(Color.WHITE);
		
		JButton btnFirst = new JButton(new ImageIcon(getClass().getResource("/imgs/primero.png")));
		btnFirst.setBackground(Color.WHITE);
		btnFirst.setBorder(null);
		pnlPage.add(btnFirst);
		
		JButton btnPreview = new JButton(new ImageIcon(getClass().getResource("/imgs/anterior.png")));
		btnPreview.setBackground(Color.WHITE);
		btnPreview.addActionListener(controller);
		btnPreview.setBorder(null);
		btnPreview.setActionCommand(Action.PAGE_PREVIEW_USER.name());
		pnlPage.add(btnPreview);
		
		lbPage = new JLabel("1");
		lbPage.setText(lbPage.getText());
		pnlPage.add(lbPage);
		
		JButton btnNext = new JButton(new ImageIcon(getClass().getResource("/imgs/siguiente.png")));
		btnNext.setBackground(Color.WHITE);
		btnNext.setBorder(null);
		btnNext.addActionListener(controller);
		btnNext.setActionCommand(Action.PAGE_NEXT_USER.name());
		pnlPage.add(btnNext);
		
		JButton btnLastest = new JButton(new ImageIcon(getClass().getResource("/imgs/ultimo.png")));
		btnLastest.setBackground(Color.WHITE);
		btnLastest.setBorder(null);
		pnlPage.add(btnLastest);
		
		pnlFondo.add(pnlPage);
	}
	
	public String getPage(){
		return lbPage.getText();
	}

	public void addPage(int pageActual, int pageTotal) {
		lbPage.setText("" + pageActual + " de " + pageTotal );
	}
	
	public double getValueFilter() {
		return Double.parseDouble(txtValueFilter.getText());
	}

	public JLabel getImage(String wayImage) {
		JLabel lbImage = new JLabel();
		lbImage.setAlignmentY(SwingConstants.CENTER);
		lbImage.setSize(80, 80);
		ImageIcon image = new ImageIcon(wayImage);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_DEFAULT));
		lbImage.setIcon(icon);	
		return lbImage;
	}
//	public void addProduct (Controller controller, int id, int numberOfProduct,  String wayImage, String name, String description, double value) {

	public void addProduct (Controller controller, ArrayList<Product> produtosDisponible) {
		for (Product product : produtosDisponible) {
			Object [] informacionProducto = product.getDetallesProduct();
			double value =  (double) informacionProducto[7];
			
			JPanel pnlProduct = new JPanel();
			pnlProduct.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pnlProduct.setBackground(Color.WHITE);
			pnlProduct.setLayout(new BorderLayout());
			
			JPanel pnlData = new JPanel();
			pnlData.setLayout(new BorderLayout());
			pnlProduct.add(pnlData, BorderLayout.SOUTH);
			
			JLabel lbImage = new JLabel();
			lbImage.setHorizontalAlignment(SwingConstants.CENTER);
			Image img = new ImageIcon(informacionProducto[1].toString()).getImage().getScaledInstance( 200, -12, java.awt.Image.SCALE_AREA_AVERAGING);
			lbImage.setIcon(new ImageIcon(img));
			pnlProduct.add(lbImage, BorderLayout.CENTER);
			
			JTextArea txtData = new JTextArea("Name : " + informacionProducto[2].toString() + "\nDescription : " + informacionProducto[6].toString() + "\nNumber of Product : " + (int) informacionProducto[3] + "\nValue : " + value );
			txtData.setFont(new Font("Arial", Font.BOLD, 12));
			txtData.setAlignmentX(SwingConstants.CENTER);
			txtData.setBorder(null);
			txtData.setEditable(false);
			pnlData.add(txtData, BorderLayout.CENTER);
			JScrollPane scroll = new JScrollPane(txtData);
			
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			pnlData.add(scroll, BorderLayout.CENTER);
			
			JButton btnAddProductToShoopingcar = new JButton(new ImageIcon(getClass().getResource(FILE_IMG_SHOPING)));
			btnAddProductToShoopingcar.setBackground(Color.decode("#56a0d3"));
			btnAddProductToShoopingcar.setName("" + informacionProducto[0].toString());
			btnAddProductToShoopingcar.setText("Add to car");
			btnAddProductToShoopingcar.addActionListener(controller);
			btnAddProductToShoopingcar.setActionCommand(Action.ADD_SHOPING.name());
			pnlData.add(btnAddProductToShoopingcar, BorderLayout.AFTER_LAST_LINE);
			pnlProducts.add(pnlProduct);
		}
		revalidate();
	}
	
	public void clearPnlProduct() {
		pnlProducts.removeAll();
	}
}