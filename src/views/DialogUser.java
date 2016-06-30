package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class DialogUser extends JFrame{

	private static final long serialVersionUID = 1L;
	private static String[] HEAD = {"Image", "Name", "Number of product", "Type Person", "Type Product", "Description", "Value", "Actions"};
	private JLabel lbPage;
	private JTextField txtValueFilter;
	private JPanel pnlProducts;

	public DialogUser(Controller controller) {
		setTitle("Flea market-User");
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		setExtendedState(MAXIMIZED_BOTH);
		
		 pnlProducts = new JPanel();
		pnlProducts.setLayout(new GridLayout(4, 4, 20, 20));
		pnlProducts.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		pnlProducts.setBackground(Color.WHITE);
		add(pnlProducts, BorderLayout.CENTER);

		JPanel pnlAction = new JPanel();
		pnlAction.setBackground(Color.WHITE);
		pnlAction.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(pnlAction, BorderLayout.NORTH);
		
		JLabel lbValueFilter = new JLabel("Filter for Value");
		lbValueFilter.setFocusable(false);
		pnlAction.add(lbValueFilter);
		txtValueFilter = new JTextField();
		txtValueFilter.setPreferredSize(new Dimension(100, 30));
		txtValueFilter.setSize(100, 30);
	
		pnlAction.add(txtValueFilter);
		
		JButton btnFilter = new JButton(new ImageIcon(getClass().getResource("/imgs/filter.png")));
		btnFilter.setBackground(Color.decode("#E6E6E6"));
		btnFilter.addActionListener(controller);
		btnFilter.setBorderPainted(false);
		btnFilter.setFocusable(false);
		btnFilter.setActionCommand(Action.FILTER_USER.name());
		pnlAction.add(btnFilter);
		
		JButton btnShopingCart = new JButton("uhafiah"/*new ImageIcon(getClass().getResource("/imgs/cart.png"))*/);
		btnShopingCart.addActionListener(controller);
		btnShopingCart.setActionCommand(Action.SHOPPING.name());
		pnlAction.add(btnShopingCart, FlowLayout.RIGHT);
		
		JPanel pnlPage = new JPanel();
		pnlPage.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(pnlPage, BorderLayout.SOUTH);

		pnlPage.setBackground(Color.WHITE);
		JButton btnFirst = new JButton("<");
		btnFirst.setBackground(Color.WHITE);
		pnlPage.add(btnFirst);
		JButton btnPreview = new JButton(new ImageIcon(getClass().getResource("/imgs/anterior.png")));
		btnPreview.setBackground(Color.WHITE);
		btnPreview.addActionListener(controller);
		btnPreview.setActionCommand(Action.PAGE_PREVIEW.name());
		pnlPage.add(btnPreview);
		lbPage = new JLabel("1");
		pnlPage.add(lbPage);
		JButton btnNext = new JButton(new ImageIcon(getClass().getResource("/imgs/siguiente.png")));
		btnNext.setBackground(Color.WHITE);
		btnNext.addActionListener(controller);
		btnNext.setActionCommand(Action.PAGE_NEXT.name());
		pnlPage.add(btnNext);
		JButton btnLastest = new JButton(">");
		btnLastest.setBackground(Color.WHITE);
		pnlPage.add(btnLastest);
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
	
	public void addProduct(String imageWay, String name, String description, double value) {
		JPanel pnlProduct = new JPanel();
		pnlProduct.setLayout(new BorderLayout());
		JPanel pnlImage = new JPanel();
		pnlImage.setLayout(new GridBagLayout());
		pnlImage.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel lbImage = new JLabel();
		//lbImage.setPreferredSize(new Dimension(200, 200));
		lbImage.setSize(150, 100);
		ImageIcon image1 = new ImageIcon(imageWay);
		Icon icon = new ImageIcon(image1.getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_REPLICATE));
		lbImage.setIcon(icon);
		//pnlImage.add(lbImage, BorderLayout.CENTER);
		JPanel pnlData = new JPanel();
		pnlData.setLayout(new GridBagLayout());
		pnlData.setBackground(Color.WHITE);
		GridBagConstraints gbc1 = new GridBagConstraints();
		JTextArea txtData = new JTextArea("Name : "  + name + "\n" +  "Description : " + description + "\n" + "Value : " + value);
		txtData.setBackground(Color.decode("#2E64FE"));
		txtData.setForeground(Color.WHITE);
		txtData.setEditable(false);
		txtData.setLineWrap(true);
		
		gbc.insets.set(5, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth  = 1;
		gbc.gridheight = 10;
		gbc.weightx = 0.5;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets.set(5, 130, 5, 50);
		pnlImage.add(lbImage, gbc);

		gbc1.gridx = 1;
		gbc1.gridy = 1;
		gbc1.gridwidth  = 0;
		gbc1.gridheight = 1;
		gbc1.weightx = 0.1;
		gbc1.weighty = 0.0;
		gbc1.insets.set(5, 130, 5, 160);
		gbc1.fill = GridBagConstraints.BOTH;
		pnlData.add(txtData, gbc1);
		JScrollPane scroll = new JScrollPane(txtData);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pnlData.add(scroll, gbc1);
	
		
		pnlProduct.add(pnlImage, BorderLayout.CENTER);
		pnlProduct.add(pnlData, BorderLayout.SOUTH);
		pnlProducts.add(pnlProduct);
		pnlProducts.repaint();
	}
	
	public void clearPnlProducts() {
		pnlProducts.removeAll();
	}
}
