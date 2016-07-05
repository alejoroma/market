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
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import models.entity.Product;
import models.entity.TypePerson;
import models.entity.TypeProduct;

public class DialogDetails extends JDialog implements ActionListener {

	private static final String FILE_IMG_ICON = "/imgs/icon.png";

	private static final long serialVersionUID = 1L;
	
	private JLabel txtId, txtName, txtNumber, txtTypePerson, txtTypeProduct, txtValue;
	private JTextArea txtDescription;
	private JLabel lbImage;
	JButton btnConfirm;
	public static final int TAM = 12;
	public static final String TYPE_WORD = "Arial Black";

	public DialogDetails() {
		setSize(500, 500);
		setModal(true);
		setTitle("Crud-Product 1.0");
		setIconImage(new ImageIcon(getClass().getResource(FILE_IMG_ICON)).getImage());
		getContentPane().setBackground(Color.decode("#85929E"));
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets.set(0, 2, 2, 60);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel lbImg = new JLabel("Producto: ");
		lbImg.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbImg, gbc);
	
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 2.0;
		gbc.fill = GridBagConstraints.BOTH;
		lbImage = new JLabel("");
		lbImage.setSize(100, 100);
		add(lbImage, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth  = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
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
		txtId.setFont(new Font(TYPE_WORD, Font.PLAIN, TAM));
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
		txtName.setFont(new Font(TYPE_WORD, Font.PLAIN, TAM));
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
		txtNumber.setFont(new Font(TYPE_WORD, Font.PLAIN, TAM));
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
		txtTypePerson.setFont(new Font(TYPE_WORD, Font.PLAIN, TAM));
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
		txtTypeProduct.setFont(new Font(TYPE_WORD, Font.PLAIN, TAM));
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
		txtDescription.setFont(new Font(TYPE_WORD, Font.PLAIN, TAM));
		txtDescription.setBackground(Color.decode("#85929E"));
		txtDescription.setEditable(false);
		txtDescription.setEditable(false);
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
		txtValue.setFont(new Font(TYPE_WORD, Font.PLAIN, TAM));
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

	public void loadData(Product ProductEdit) {
		Object [] informacionProducto = ProductEdit.getDetallesProduct();
		txtId.setText(informacionProducto[0] + "");
		setLbImage(informacionProducto[1].toString());
		txtName.setText(informacionProducto[2].toString());
		txtNumber.setText("" + informacionProducto[3]);
		txtTypePerson.setText("" + informacionProducto[4]);
		txtTypeProduct.setText("" + informacionProducto[5]);
		txtDescription.setText(informacionProducto[6].toString());
		txtValue.setText("" + informacionProducto[7]);
	}
	
	public void setLbImage(String image) {
		lbImage.setText("");
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(image).getImage().getScaledInstance( 150, -10, java.awt.Image.SCALE_AREA_AVERAGING);
		this.lbImage.setIcon(new ImageIcon(img));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirm) {
			dispose();
		}
	}
}