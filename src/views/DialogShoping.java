package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DialogShoping extends JDialog{

	private static final long serialVersionUID = 1L;
	private static JPanel jPanelConten;
	private JTextArea textval;
	private double val;
	private JScrollPane jScrollPane;

	public DialogShoping() {
		setTitle("Shopping Cart");
		setSize(600, 650);
		this.setLayout(null);
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		setLocationRelativeTo(null);
		setResizable(false);

		jPanelConten = new JPanel();
		jPanelConten.setBounds(15, 50, 530, 565);
		jPanelConten.setBackground(new Color(220, 220, 220));
		jPanelConten.setOpaque(false);
		jPanelConten.setLayout(new GridLayout(4, 1));
		jScrollPane = new JScrollPane(jPanelConten);
		val = 0.0;
		textval = new JTextArea();
		textval.setForeground(Color.red);

		JLabel jlLabelTitle = new JLabel("Shopping Cart");
		jlLabelTitle.setBounds(30, 10, 200, 30);
		jlLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlLabelTitle.setFont(new Font("Arial", Font.BOLD, 25));
		jlLabelTitle.setForeground(Color.DARK_GRAY);
		add(jlLabelTitle);

		JLabel jlLabelPrice = new JLabel("Price");
		jlLabelPrice.setBounds(260, 18, 100, 30);
		jlLabelPrice.setHorizontalAlignment(SwingConstants.CENTER);
		jlLabelPrice.setFont(new Font("Arial", Font.BOLD, 15));
		jlLabelPrice.setForeground(Color.DARK_GRAY);
		add(jlLabelPrice);


		JLabel jlLabelQuantity = new JLabel("Quantity");
		jlLabelQuantity.setBounds(400, 18, 100, 30);
		jlLabelQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		jlLabelQuantity.setFont(new Font("Arial", Font.BOLD, 15));
		jlLabelQuantity.setForeground(Color.DARK_GRAY);
		add(jlLabelQuantity);

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

	public void addProduct(String imageWay, String name, String description, double value, int cantidad) {
		JLabel lbImage = new JLabel();
		lbImage.setSize(100, 100);
		ImageIcon image = new ImageIcon(imageWay);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_DEFAULT));
		lbImage.setIcon(icon);
		JPanel panelContenDates = new JPanel();
		panelContenDates.setLayout(new GridLayout(1, 2,10, 10));
		String[] cade = description.split(" ");
		JTextArea textArea = null;
		textArea = new JTextArea("\n"+"\n"+name+"\n"+description);
		textArea.setLineWrap(true);

		textArea.setEditable(false);
		textArea.setOpaque(false);
		panelContenDates.add(lbImage);
		panelContenDates.add(textArea);

		JLabel jlLabelValue = new JLabel(String.valueOf("     "+value));
		jlLabelValue.setForeground(Color.red);
		panelContenDates.add(jlLabelValue);

		JLabel jLabelQuantity = new JLabel(String.valueOf("    "+cantidad));
		panelContenDates.add(jLabelQuantity);
		jPanelConten.add(panelContenDates);
		jPanelConten.add(textval);
		jScrollPane.add(jPanelConten);
		val += value;
		textval.setText("                                                          Valor Total: "+String.valueOf(val));
		textval.setOpaque(false);
		textval.setEditable(false);
	}
}
