package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
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

	private static final String FILE_IMG_ICON = "/imgs/icon.png";
	private static final String FILE_IMG_CANCEL = "/imgs/cancele.png";
	private static final String FILE_IMG_ADD = "/imgs/add.png";
	private static final String FILE_IMG_LOAD_IMAGE = "/imgs/subirImage.png";
	private static final long serialVersionUID = 1L;
	protected JTextField txtId, txtName;
	protected JTextArea txtDescription;
	protected JSpinner spinerNumberProduct, spinertValue;
	protected JComboBox<TypePerson> cbxTypePerson;
	protected JComboBox<TypeProduct> cbxTypeProduct;
	protected JButton btnCreate, btnAddImage;
	protected JLabel lbImage, lbId;
	protected JTextArea textAreaErrors;
	protected JScrollPane scroll;
	protected JScrollPane scrollDescription;
	private String wayImage;

	public DialogAddProduct(Controller controller) {
		setIconImage(new ImageIcon(getClass().getResource(FILE_IMG_ICON)).getImage());
		setModal(true);
		setTitle("Data Entry Product");
		setSize(500, 500);
		getContentPane().setBackground(Color.decode("#85929E"));
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();	

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.insets.set(6,6,6,6);
		gbc.fill = GridBagConstraints.BOTH;
		JLabel jLabelId = new JLabel("Id:");
		jLabelId.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jLabelId,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		txtId = new JTextField();
		txtId.setToolTipText("Ingrese el numero que identifica el producto");
		ValidateFields.onlyNumber(txtId);
		add(txtId, gbc);;
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel jLabelName = new JLabel("Product Name:");
		jLabelName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jLabelName, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		txtName = new JTextField();
		ValidateFields.onlyLetter(txtName);
		txtName.setToolTipText("Ingrese el nombre del producto");
		add(txtName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel jLabelBrand = new JLabel("Cantidad Product:");
		jLabelBrand.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jLabelBrand, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		SpinnerModel sm = new SpinnerNumberModel(1, 1,10000 , 1); 
		spinerNumberProduct = new JSpinner(sm);
		spinerNumberProduct.setToolTipText("Ingrese la cantidad del producto");
		add(spinerNumberProduct, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel jLabelCategory = new JLabel("Type Person:");
		jLabelCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jLabelCategory, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		cbxTypePerson = new JComboBox<TypePerson>(TypePerson.values());
		cbxTypePerson.setToolTipText("Escoga el tipo de categoria");
		add(cbxTypePerson, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel jLabelPrice = new JLabel("Type Product:");
		jLabelPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jLabelPrice, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		cbxTypeProduct = new JComboBox<>(TypeProduct.values());
		cbxTypeProduct.setToolTipText("Ingrese el precio del producto");
		add(cbxTypeProduct, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel jLabelDescription = new JLabel(" ");
		jLabelDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jLabelDescription, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel jLrelleno= new JLabel("Description:");
		jLrelleno.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jLrelleno, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.weightx = 1;
		gbc.weighty = 2;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		txtDescription = new JTextArea();
		txtDescription.setToolTipText("Ingrese la descripcion del producto");
		txtDescription.setLineWrap(true); 
		scrollDescription = new JScrollPane();
		scrollDescription.setViewportView(txtDescription);
		add(scrollDescription, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel jLabelStatus = new JLabel("Value:");
		jLabelStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		add(jLabelStatus, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		SpinnerModel spinerModelValue = new SpinnerNumberModel(1, 1,10000 , 1); 
		spinertValue = new JSpinner(spinerModelValue);
		spinertValue.setToolTipText("Ingrese el estado del producto");
		add(spinertValue, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel LbRelleno2 = new JLabel("");
		add(LbRelleno2, gbc);
	
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		lbImage = new JLabel();
		lbImage.setIcon(new ImageIcon(getClass().getResource(FILE_IMG_LOAD_IMAGE)));
		lbImage.setText("Arrastra o sube la imagen");
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		lbImage.setPreferredSize(new Dimension(100,100));
		add(lbImage, gbc);

		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		btnAddImage = new JButton("Examinar");
		btnAddImage.setBackground(Color.decode("#808B96"));
		btnAddImage.addActionListener(controller);
		btnAddImage.setActionCommand(Action.ADD_IMAGE.name());
		btnAddImage.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnAddImage.setForeground(Color.WHITE); 
		add(btnAddImage, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty = 1;
		gbc.gridheight = 11;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel Lbrelleno3 = new JLabel("     ");
		Lbrelleno3.setHorizontalAlignment(SwingConstants.RIGHT);
		add(Lbrelleno3, gbc);

		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		textAreaErrors = new JTextArea();
		scroll = new JScrollPane(textAreaErrors );
		scroll.setBounds(0, 710, getWidth()-15, 75);
		scroll.setAutoscrolls(true);
		scroll.setBorder(BorderFactory.createTitledBorder("Errors:"));
		scroll.setVisible(false);
		add(scroll, gbc);
		
		JPanel PanelBotones = new JPanel();
		PanelBotones.setLayout(new  GridLayout(1, 2));
		
		JButton btnCancel= new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(getClass().getResource(FILE_IMG_CANCEL)));
		btnCancel.addActionListener(controller);
		btnCancel.setActionCommand(Action.CANCELE.name());
		btnCancel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnCancel.setForeground(Color.WHITE); 
		btnCancel.setBackground(Color.decode("#2980B9"));
		PanelBotones.add(btnCancel);

	
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(controller);
		btnCreate.setActionCommand(Action.ADD.name());
		btnCreate.setIcon(new ImageIcon(getClass().getResource(FILE_IMG_ADD)));
		btnCreate.setBackground(Color.decode("#52BE80"));
		btnCreate.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnCreate.setForeground(Color.WHITE); 
		PanelBotones.add(btnCreate);
		
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		add(PanelBotones, gbc);
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
//		try {
//			ValidateFields.validatePrece(txtValue);
//		} catch (ErrorDates e3) {
//			scroll.setVisible(true);
//			textAreaErrors.setText(e3.getMessage()+"\n");
//			textAreaErrors.setForeground(Color.RED);
//		}
		try {
			ValidateFields.validateDescription(txtDescription);
		} catch (ErrorDates e4) {
			scroll.setVisible(true);
			textAreaErrors.setText(e4.getMessage());
			textAreaErrors.setForeground(Color.RED);
		}
		revalidate();
	}

	public Product createProduct() {
		validateFields();
		return ProductManager.createProduct(Integer.parseInt(txtId.getText()),	wayImage, txtName.getText(),
				(int) spinerNumberProduct.getValue(),(TypePerson) cbxTypePerson.getSelectedItem(),	(TypeProduct) cbxTypeProduct.getSelectedItem(),
				txtDescription.getText(),(int) spinertValue.getValue());
	}
	
	public void resetDialog() {
		txtId.setText("");
		txtName.setText("");
		txtDescription.setText("");
		spinerNumberProduct.setValue(1);
		spinertValue.setValue(0);
		scroll.setVisible(false);
		lbImage.setIcon(new ImageIcon(getClass().getResource(FILE_IMG_LOAD_IMAGE)));
		lbImage.setText("Arrastra o sube la imagen");
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void addImage() {
		JFileChooser chooserFile = new JFileChooser();
		chooserFile.showOpenDialog(this);
		wayImage = chooserFile.getSelectedFile().toString();
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(wayImage).getImage().getScaledInstance( 150, -10, java.awt.Image.SCALE_AREA_AVERAGING);
		this.lbImage.setIcon(new ImageIcon(img));
	}
	
	public String getWayImage() {
		return wayImage;
	}
}