package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import controller.Action;
import controller.Controller;
import models.dao.ProductManager;
import models.entity.Product;
import models.entity.TypePerson;
import models.entity.TypeProduct;
import models.errores.ErrorDates;
import models.errores.ValidateFields;

public class DialogAddProduct  extends JDialog{

	private static final long serialVersionUID = 1L;
	private JTextField txtId, txtName, txtValue;
	private JTextArea txtDescription;
	private JSpinner spinerNumberProduct;
	private JComboBox<TypePerson> cbxTypePerson;
	private JComboBox<TypeProduct> cbxTypeProduct;
	private JButton btnCreate, btnAddImage;
	private JLabel lbImage, lbId;
	private JTextArea textAreaErrors;
	private JScrollPane scroll;

	public DialogAddProduct(Controller controller) {
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		setModal(true);
		setTitle("Data Entry Product");
		setSize(500, 580);
		this.getContentPane().setBackground(new Color(159, 182, 205));
		setLayout(null);

		JPanel pnlDates = new JPanel();
		pnlDates.setBackground(new Color(159, 182, 205));
		pnlDates.setLayout(new GridLayout(7, 2, 10, 10));

		JLabel jLabelId = new JLabel("Id:");
		jLabelId.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlDates.add(jLabelId);

		txtId = new JTextField();
		txtId.setToolTipText("Ingrese el numero que identifica el producto");
		ValidateFields.onlyNumber(txtId);
		pnlDates.add(txtId);

		JLabel jLabelName = new JLabel("Product Name:");
		jLabelName.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlDates.add(jLabelName);

		txtName = new JTextField();
		ValidateFields.onlyLetter(txtName);
		txtName.setToolTipText("Ingrese el nombre del producto");
		pnlDates.add(txtName);

		JLabel jLabelBrand = new JLabel("Product Brand:");
		jLabelBrand.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlDates.add(jLabelBrand);

		SpinnerModel sm = new SpinnerNumberModel(1, 1,10000 , 1); 
		spinerNumberProduct = new JSpinner(sm);
		spinerNumberProduct.setToolTipText("Ingrese la marca del producto");
		pnlDates.add(spinerNumberProduct);

		JLabel jLabelCategory = new JLabel("Type Person:");
		jLabelCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlDates.add(jLabelCategory);

		cbxTypePerson = new JComboBox<TypePerson>(TypePerson.values());
		cbxTypePerson.setToolTipText("Escoga el tipo de categoria");
		pnlDates.add(cbxTypePerson);

		JLabel jLabelPrice = new JLabel("Type Product:");
		jLabelPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlDates.add(jLabelPrice);

		cbxTypeProduct = new JComboBox<>(TypeProduct.values());
		cbxTypeProduct.setToolTipText("Ingrese el precio del producto");
		pnlDates.add(cbxTypeProduct);

		JLabel jLabelDescription = new JLabel("Description:");
		jLabelDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlDates.add(jLabelDescription);

		txtDescription = new JTextArea();
		txtDescription.setToolTipText("Ingrese la descripcion del producto");
		pnlDates.add(txtDescription);

		JLabel jLabelStatus = new JLabel("Value:");
		jLabelStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlDates.add(jLabelStatus);

		txtValue = new JTextField();
		txtValue.setToolTipText("Ingrese el estado del producto");
		pnlDates.add(txtValue);

		lbImage = new JLabel(":)");
		setLayout(null);
		lbImage.setSize(50, 50);
		lbImage.setBackground(Color.ORANGE);
		lbImage.setBounds(100, 305, 100, 100);
		lbImage.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbImage);

		btnAddImage = new JButton("New Image");
		btnAddImage.setBackground(Color.decode("#FAAC58"));
		btnAddImage.setBounds(320, 330, 140, 40);
		btnAddImage.addActionListener(controller);
		btnAddImage.setActionCommand(Action.ADD_IMAGE.name());
		add(btnAddImage);

		pnlDates.setBounds(0, 0, getWidth()-15, 300);
		add(pnlDates);

		textAreaErrors = new JTextArea();
		scroll = new JScrollPane(textAreaErrors );
		scroll.setBounds(0, 410, getWidth()-15, 75);
		scroll.setAutoscrolls(true);
		scroll.setBorder(BorderFactory.createTitledBorder("Errors:"));
		scroll.setVisible(false);
		add(scroll, BorderLayout.EAST);

		JPanel pnlButtonConfirmation = new JPanel();
		pnlButtonConfirmation.setBackground(new Color(159, 182, 205));
		pnlButtonConfirmation.setLayout(new GridLayout(1, 2, 8, 10));
		pnlButtonConfirmation.setBounds(0, 500, getWidth(), 38);

		JButton btnCancel= new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(getClass().getResource("/imgs/cancele.png")));
		btnCancel.addActionListener(controller);
		btnCancel.setActionCommand(Action.CANCELE.name());
		btnCancel.setBackground(new Color(255, 240, 245));
		pnlButtonConfirmation.add(btnCancel);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(controller);
		btnCreate.setActionCommand(Action.ADD.name());
		btnCreate.setIcon(new ImageIcon(getClass().getResource("/imgs/add.png")));
		btnCreate.setBackground(new Color(238,224 ,229));
		pnlButtonConfirmation.add(btnCreate);

		add(pnlButtonConfirmation);
	}

	public void validateFields() {
		
			try {
				ValidateFields.validateId(txtId);
			} catch (ErrorDates e) {
				scroll.setVisible(true);
				textAreaErrors.setText(e.getMessage()+"\n");
				textAreaErrors.setForeground(Color.RED);
			}
		try {
			ValidateFields.validateName(txtName);
		} catch (ErrorDates e2) {
			scroll.setVisible(true);
			textAreaErrors.setText(e2.getMessage()+"\n");
			textAreaErrors.setForeground(Color.RED);
		}
		try {
			ValidateFields.validatePrece(txtValue);
		} catch (ErrorDates e3) {
			scroll.setVisible(true);
			textAreaErrors.setText(e3.getMessage()+"\n");
			textAreaErrors.setForeground(Color.RED);
		}
		try {
			ValidateFields.validateDescription(txtDescription);
		} catch (ErrorDates e4) {
			scroll.setVisible(true);
			textAreaErrors.setText(e4.getMessage());
			textAreaErrors.setForeground(Color.RED);
		}
	}

	public Product createProduct() {
		validateFields();
		return ProductManager.createProduct(Integer.parseInt(txtId.getText()),
				lbImage.getIcon().toString(), txtName.getText(),
				(int) spinerNumberProduct.getValue(),
				(TypePerson) cbxTypePerson.getSelectedItem(),
				(TypeProduct) cbxTypeProduct.getSelectedItem(),
				txtDescription.getText(),
				Double.parseDouble(txtValue.getText()));
	}
	
	public void resetDialog() {
		lbImage.setText("");
		txtId.setText("");
		txtName.setText("");
		txtDescription.setText("");
		txtValue.setText("");
		scroll.setVisible(false);
	}
	
	public void setLbImage(String image) {
		ImageIcon image1 = new ImageIcon(image);
		Icon icon = new ImageIcon(image1.getImage().getScaledInstance(this.lbImage.getWidth(), this.lbImage.getHeight(),Image.SCALE_DEFAULT));
		this.lbImage.setIcon(icon);
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


}