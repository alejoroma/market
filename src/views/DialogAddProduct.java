package views;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Action;
import controller.Controller;
import models.dao.ProductManager;
import models.entity.Product;
import models.entity.TypePerson;
import models.entity.TypeProduct;

public class DialogAddProduct extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lbImage, lbId; 
	private JTextField txtId, txtName, txtValue;
	private JTextArea txtDescription;
	private JSpinner spinerNumberProduct;
	private JComboBox<TypePerson> cbxTypePerson;
	private JComboBox<TypeProduct> cbxTypeProduct;
	private JButton btnCreate, btnAddImage;
	public JButton getBtnAddImage() {
		return btnAddImage;
	}

	public DialogAddProduct(Controller controller) {
		setSize(500, 500);
		setModal(true);
		setTitle("Crud-Product 1.0");
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();

		lbImage = new JLabel(":)");
		lbImage.setSize(50, 50);
		lbImage.setHorizontalAlignment(SwingConstants.RIGHT);
		
		 btnAddImage = new JButton("New Image");
		 btnAddImage.setBackground(Color.decode("#FAAC58"));
		btnAddImage.addActionListener(controller);
		btnAddImage.setActionCommand(Action.ADD_IMAGE.name());
		
		lbId = new JLabel("Id");
		lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		txtId = new JTextField();
		JLabel lbName = new JLabel("Name");
		lbName.setHorizontalAlignment(SwingConstants.RIGHT);
		txtName = new JTextField();
		JLabel lbTypePerson = new JLabel("Type Person");
		lbTypePerson.setHorizontalAlignment(SwingConstants.RIGHT);
		cbxTypePerson = new JComboBox<>(TypePerson.values());
		JLabel lbTypeProduct = new JLabel("Type Product");
		lbTypeProduct.setHorizontalAlignment(SwingConstants.RIGHT);
		cbxTypeProduct = new JComboBox<>(TypeProduct.values());
		JLabel lbNumberProduct = new JLabel("Number");
		lbNumberProduct.setHorizontalAlignment(SwingConstants.RIGHT);
		spinerNumberProduct = new JSpinner();

		JLabel lbDescription = new JLabel("Description");
		lbDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDescription = new JTextArea();
		JLabel lbValue = new JLabel("Value");
		lbValue.setHorizontalAlignment(SwingConstants.RIGHT);
		txtValue = new JTextField();

		gbc.insets.set(0, 2, 2, 40);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 2.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(lbImage, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(btnAddImage, gbc);

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
		add(lbNumberProduct, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(spinerNumberProduct, gbc);

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
		add(cbxTypePerson, gbc);

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
		add(cbxTypeProduct, gbc);

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

		btnCreate = new JButton("Create");
		btnCreate.setBackground(Color.decode("#2E64FE"));
		btnCreate.addActionListener(controller);
		btnCreate.setActionCommand(Action.ADD.name());
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(btnCreate, gbc);

	}

	public JLabel getLbImage() {
		return lbImage;
	}

	public JLabel getLbId() {
		return lbId;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public JTextField getTxtValue() {
		return txtValue;
	}

	public JTextArea getTxtDescription() {
		return txtDescription;
	}

	public JSpinner getSpinerNumberProduct() {
		return spinerNumberProduct;
	}

	public JComboBox<TypePerson> getCbxTypePerson() {
		return cbxTypePerson;
	}
	
	public JComboBox<TypeProduct> getCbxTypeProduct() {
		return cbxTypeProduct;
	}

	public JButton getBtnCreate() {
		return btnCreate;
	}

	public Product createProduct() {
		return ProductManager.createProduct(Integer.parseInt(txtId.getText()), lbImage.getIcon().toString(), txtName.getText(), (int)spinerNumberProduct.getValue(), (TypePerson)cbxTypePerson.getSelectedItem(), (TypeProduct)cbxTypeProduct.getSelectedItem(), txtDescription.getText(), Double.parseDouble(txtValue.getText()));
	}

	public void setLbImage(String image) {
		ImageIcon image1 = new ImageIcon(image);
		Icon icon = new ImageIcon(image1.getImage().getScaledInstance(this.lbImage.getWidth(), this.lbImage.getHeight(), Image.SCALE_DEFAULT));
		this.lbImage.setIcon(icon);
	}
	
	public void resetDialog() {
		lbImage.setText("");
		txtId.setText("");
		txtName.setText("");
		txtDescription.setText("");
		txtValue.setText("");
	}

	public static void main(String[] args) {
		new DialogAddProduct(null);
	}
}