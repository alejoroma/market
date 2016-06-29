package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.entity.TypePerson;
import models.entity.TypeProduct;

public class DialogDetails extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel txtId, txtName, txtNumber, txtTypePerson, txtTypeProduct, txtValue;
	private JTextArea txtDescription;
	private JLabel lbImage;
	JButton btnConfirm;
	public static final int TAMA�O_LETRA = 12;
	public static final String TYPE_WORD = "Arial Black";

	public DialogDetails() {
		setSize(500, 500);
		setModal(true);
		setTitle("Crud-Product 1.0");
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		getContentPane().setBackground(Color.decode("#85929E"));
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	
		gbc.insets.set(0, 2, 2, 60);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 2.0;
		gbc.fill = GridBagConstraints.BOTH;
		lbImage = new JLabel(":)");
		lbImage.setSize(100, 100);
		add(lbImage, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbId = new JLabel("Id: ");
		lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbId, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtId = new JLabel();
		txtId.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMA�O_LETRA));
		txtId.setFocusable(false);
		add(txtId, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbName = new JLabel("Name: ");
		lbName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbName, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtName = new JLabel();
		txtName.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMA�O_LETRA));
		txtName.setFocusable(false);
		add(txtName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbNumber = new JLabel("Number of products: ");	
		lbNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbNumber, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtNumber = new JLabel();
		txtNumber.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMA�O_LETRA));
		txtNumber.setFocusable(false);
		add(txtNumber, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbTypePerson  = new JLabel("Type of person: ");
		lbTypePerson.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbTypePerson, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtTypePerson = new JLabel();
		txtTypePerson.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMA�O_LETRA));
		txtTypePerson.setFocusable(false);
		add(txtTypePerson, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbTypeProduct = new JLabel("Type product: ");
		lbTypeProduct.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbTypeProduct, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtTypeProduct = new JLabel();
		txtTypeProduct.setFocusable(false);
		txtTypeProduct.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMA�O_LETRA));
		add(txtTypeProduct, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbDescription = new JLabel("Description: ");
		lbDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbDescription, gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtDescription = new JTextArea();
		txtDescription.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMA�O_LETRA));
		txtDescription.setFocusable(false);
		add(txtDescription, gbc);

		JScrollPane scroll = new JScrollPane(txtDescription);
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(scroll, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbValue = new JLabel("Value: ");
		lbValue.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbValue, gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		txtValue = new JLabel();
		txtValue.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMA�O_LETRA));
		txtValue.setFocusable(false);
		add(txtValue, gbc);

		btnConfirm = new JButton("Acept");
		btnConfirm.addActionListener(this);
		btnConfirm.setBackground(Color.decode("#1E8449"));
		btnConfirm.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnConfirm.setForeground(Color.WHITE); 
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.gridwidth  = 2;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.insets.set(0, 2, 2, 0);
		gbc.fill = GridBagConstraints.BOTH;
		add(btnConfirm, gbc);
	}

	public void loadData(int id, String image, String name, int numberOfProduct, TypePerson typePerson, TypeProduct typeProduct,
			String description, double value) {
		txtId.setText("" + id);
		ImageIcon image1 = new ImageIcon(image);
		Icon icon = new ImageIcon(image1.getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_REPLICATE));
		lbImage.setIcon(icon);
		txtName.setText(name);
		txtNumber.setText("" + numberOfProduct);
		txtTypePerson.setText("" + typePerson);
		txtTypeProduct.setText("" + typeProduct);
		txtDescription.setText(description);
		txtValue.setText("" + value);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirm) {
			dispose();
		}
	}
}