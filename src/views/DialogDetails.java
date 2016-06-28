package views;

import java.awt.Color;
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

import models.entity.TypePerson;
import models.entity.TypeProduct;

public class DialogDetails extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtId, txtName, txtNumber, txtTypePerson, txtTypeProduct, txtValue;
	private JTextArea txtDescription;
	private JLabel lbImage;
	JButton btnConfirm;

	public DialogDetails() {
		setSize(500, 500);
		setModal(true);
		setTitle("Crud-Product 1.0");
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		getContentPane().setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		lbImage = new JLabel(":)");
		lbImage.setSize(100, 100);
		JLabel lbId = new JLabel("Id");
		txtId = new JTextField();
		txtId.setFocusable(false);
		JLabel lbName = new JLabel("Name");
		txtName = new JTextField();
		txtName.setFocusable(false);
		JLabel lbNumber = new JLabel("Number of products");	
		txtNumber = new JTextField();
		txtNumber.setFocusable(false);
		JLabel lbTypePerson  = new JLabel("Type of person");
		txtTypePerson = new JTextField();
		txtTypePerson.setFocusable(false);
		JLabel lbTypeProduct = new JLabel("Type product");
		txtTypeProduct = new JTextField();
		txtTypeProduct.setFocusable(false);
		JLabel lbDescription = new JLabel("Description");
		txtDescription = new JTextArea();
		txtDescription.setFocusable(false);
		JLabel lbValue = new JLabel("Value");
		txtValue = new JTextField();
		txtValue.setFocusable(false);

		gbc.insets.set(0, 2, 2, 40);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 2.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(lbImage, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(lbId, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(txtId, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(lbName, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(txtName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(lbNumber, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(txtNumber, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(lbTypePerson, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(txtTypePerson, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(lbTypeProduct, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(txtTypeProduct, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(lbDescription, gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
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
		add(lbValue, gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(txtValue, gbc);

		 btnConfirm = new JButton("Acept");
		 btnConfirm.setBackground(Color.decode("#01DF01"));
		 btnConfirm.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
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