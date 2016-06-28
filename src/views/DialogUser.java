package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.rmi.activation.ActivationInstantiator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import controller.Action;
import controller.Controller;

public class DialogUser extends JFrame{

	private static final long serialVersionUID = 1L;
	private static String[] HEAD = {"Image", "Name", "Number of product", "Type Person", "Type Product", "Description", "Value", "Actions"};
	private JLabel lbPage;
	private JTextField txtValueFilter;
	private JPanel pnlProducts;

	public DialogUser(Controller controller) {
		setTitle("Crud-Product 1.0");
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		setExtendedState(MAXIMIZED_BOTH);
		
		 pnlProducts = new JPanel();
		pnlProducts.setLayout(new GridLayout(4, 4));
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
		
		JPanel pnlPage = new JPanel();
		pnlPage.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(pnlPage, BorderLayout.SOUTH);

		pnlPage.setBackground(Color.WHITE);
		JButton btnFirst = new JButton("<");
		btnFirst.setBackground(Color.decode("#FE9A2E"));
		pnlPage.add(btnFirst);
		JButton btnPreview = new JButton(new ImageIcon(getClass().getResource("/imgs/anterior.png")));
		btnPreview.setBackground(Color.decode("#FE9A2E"));
		btnPreview.addActionListener(controller);
		btnPreview.setActionCommand(Action.PAGE_PREVIEW.name());
		pnlPage.add(btnPreview);
		lbPage = new JLabel("1");
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
		pnlProduct.setAlignmentY(CENTER_ALIGNMENT);
		pnlProduct.setLayout(new BorderLayout());
		JLabel lbImage = new JLabel();
		lbImage.setSize(100, 100);
		ImageIcon image = new ImageIcon(imageWay);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_DEFAULT));
		lbImage.setIcon(icon);
		pnlProduct.add(lbImage, BorderLayout.CENTER);
		JTextArea txtData = new JTextArea("N : " + name + "\n" + "D : " + description + "\n" + "V : " + value);
		txtData.setEditable(false);
		txtData.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		pnlProduct.add(txtData, BorderLayout.SOUTH);
		pnlProducts.add(pnlProduct);
	}
	
	public void clearPnlProducts() {
		pnlProducts.removeAll();
	}
}
