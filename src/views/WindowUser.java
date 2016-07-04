package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

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
import javax.swing.border.MatteBorder;

import controller.Action;
import controller.Controller;

public class WindowUser extends JFrame {

	private static final String FILE_IMG_SHOPING = "/imgs/shoping.png";
	private static final String FILE_IMG_CAR = "/imgs/car.png";
	private static final String FILE_IMG_ICON = "/imgs/icon.png";
	private static final long serialVersionUID = 1L;
	private JLabel lbPage;
	private JTextField txtValueFilter;
	private JPanel pnlProucts;

	public WindowUser(Controller controller) {
		setTitle("Crud-Product 1.0");
		setIconImage(new ImageIcon(getClass().getResource(FILE_IMG_ICON)).getImage());
		setExtendedState(MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
		pnlProucts = new JPanel();
		pnlProucts.setBackground(Color.WHITE);
		pnlProucts.setBorder(new MatteBorder(20, 200, 20, 200, Color.WHITE));
		pnlProucts.setLayout(new GridLayout(4, 5, 20, 20));
		add(pnlProucts, BorderLayout.CENTER);
		
		JPanel pnlShoping = new JPanel();
		JButton btnShopingCart = new JButton(new ImageIcon(getClass().getResource(FILE_IMG_CAR)));
		pnlShoping.add(btnShopingCart);
		btnShopingCart.addActionListener(controller);
		btnShopingCart.setActionCommand(Action.SHOW_DIALOGSHOPING.name());
		add(pnlShoping, BorderLayout.WEST);

		JPanel pnlAction = new JPanel();
		pnlAction.setBackground(Color.WHITE);
		pnlAction.setLayout(new BorderLayout());
		add(pnlAction, BorderLayout.NORTH);

		JPanel pnlPage = new JPanel();
		pnlPage.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(pnlPage, BorderLayout.SOUTH);

		pnlPage.setBackground(Color.WHITE);
		JButton btnFirst = new JButton(new ImageIcon(getClass().getResource("/imgs/primero.png")));
		btnFirst.setBackground(Color.WHITE);
		pnlPage.add(btnFirst);
		JButton btnPreview = new JButton(new ImageIcon(getClass().getResource("/imgs/anterior.png")));
		btnPreview.setBackground(Color.WHITE);
		btnPreview.addActionListener(controller);
		btnPreview.setActionCommand(Action.PAGE_PREVIEW_USER.name());
		pnlPage.add(btnPreview);
		lbPage = new JLabel("1");
		pnlPage.add(lbPage);
		JButton btnNext = new JButton(new ImageIcon(getClass().getResource("/imgs/siguiente.png")));
		btnNext.setBackground(Color.WHITE);
		btnNext.addActionListener(controller);
		btnNext.setActionCommand(Action.PAGE_NEXT_USER.name());
		pnlPage.add(btnNext);
		JButton btnLastest = new JButton(new ImageIcon(getClass().getResource("/imgs/ultimo.png")));
		btnLastest.setBackground(Color.WHITE);
		pnlPage.add(btnLastest);
	}

	public void addPage(int pageActual, int pageTotal) {
		this.lbPage.setText("" + pageActual + " de " + pageTotal );
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

	public void addProduct (Controller controller, int id, int numberOfProduct,  String wayImage, String name, String description, double value) {
		JPanel pnlProduct = new JPanel();
		pnlProduct.setBackground(Color.WHITE);
		pnlProduct.setLayout(new BorderLayout());
		pnlProduct.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		
		JPanel pnlData = new JPanel();
		pnlData.setLayout(new BorderLayout());
		pnlProduct.add(pnlData, BorderLayout.SOUTH);
		
		JLabel lbImage = new JLabel();
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(wayImage).getImage().getScaledInstance( 150, -1, java.awt.Image.SCALE_AREA_AVERAGING);
		lbImage.setIcon(new ImageIcon(img));
		pnlProduct.add(lbImage, BorderLayout.CENTER);
		
		JTextArea txtData = new JTextArea("Name : " + "\nDescription : " + description + "\nNumber of Product : " + numberOfProduct + "\nValue : " + value );
		txtData.setFont(new Font("Arial", Font.BOLD, 12));
		txtData.setLineWrap(true);
		txtData.setEditable(false);
		pnlData.add(txtData, BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane(txtData);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pnlData.add(scroll, BorderLayout.CENTER);
		JButton btnAddProductToShopingcart = new JButton(new ImageIcon(getClass().getResource(FILE_IMG_SHOPING)));
		btnAddProductToShopingcart.setText("" + id);
		btnAddProductToShopingcart.addActionListener(controller);
		btnAddProductToShopingcart.setActionCommand(Action.ADD_SHOPING.name());
		pnlData.add(btnAddProductToShopingcart, BorderLayout.AFTER_LAST_LINE);
		pnlProucts.add(pnlProduct);
	}
	
	public void clearPnlProduct() {
		pnlProucts.removeAll();
	}
}