package views.entrar;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import controller.*;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Dialog  extends JDialog {

	private static final long serialVersionUID = 1L;

	public static final int TAMAÑO_LETRA = 12;
	public static final String TYPE_WORD = "Arial Black";

	private JPasswordField txPassword;

	private JTextField txName;
	
	public Dialog(Controller controller){
		
		setModal(true);
		setTitle("Create Product");
		setFont(new Font(TYPE_WORD, Font.PLAIN, TAMAÑO_LETRA));
		setSize(300,250);
		getContentPane().setBackground(Color.WHITE);
		ImageIcon iconoAplicacion = new ImageIcon(getClass().getResource("/img/icono.jpg"));
		setIconImage(iconoAplicacion.getImage());
		setLocationRelativeTo(null);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();		
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.6;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel labelName = new JLabel("Name User: ",  SwingConstants.RIGHT);
		labelName.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMAÑO_LETRA));
		add(labelName, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.4;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth =1;
		gbc.fill = GridBagConstraints.BOTH;
		txName = new JTextField("");
		add(txName,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.6;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JLabel labelNumberOfProduct = new JLabel("Contrasena: : ",  SwingConstants.RIGHT);
		labelNumberOfProduct.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMAÑO_LETRA));
		add(labelNumberOfProduct, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.4;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		txPassword = new JPasswordField();
		add(txPassword,gbc);
			
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 1.5;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		JButton btnNewUser = new JButton("Crear User");
		btnNewUser.setBackground(Color.decode("#ffffff"));
		btnNewUser.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewUser.setForeground(Color.BLACK); 
		btnNewUser.setOpaque(false);
		btnNewUser.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
		btnNewUser.addActionListener(controller);
//		btnNewUser.setActionCommand(Action.CANCEL.name());
		add(btnNewUser,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 0.7;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JButton btnCAncel = new JButton("Cancel");
		btnCAncel.setBackground(Color.decode("#000000"));
		btnCAncel.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMAÑO_LETRA));
		btnCAncel.setForeground(Color.WHITE); 
		btnCAncel.setBorder(BorderFactory.createLineBorder(Color.decode("#000000")));
		btnCAncel.addActionListener(controller);
//		btnCAncel.setActionCommand(Action.CANCEL.name());
		add(btnCAncel,gbc);
	
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 0.7;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		JButton btnCreate = new JButton("Create");
		btnCreate.setBackground(Color.decode("#000000"));
		btnCreate.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMAÑO_LETRA));
		btnCreate.setForeground(Color.WHITE); 
		btnCreate.setBorder(BorderFactory.createLineBorder(Color.decode("#000000")));
		btnCreate.addActionListener(controller);
//		btnCreate.setActionCommand(Action.OPEN_WINDOWS_USER.name());
		add(btnCreate,gbc);
	}
	
	public void createProduct(){
		
//		String contraseña = txPassword.getSelectedText();
		System.out.println(txName.getText() + getPassword());
		clear();
		setVisible(false);
	}
	
	public String getPassword(){
		String salida = "";
		char passArray[] = txPassword.getPassword();
		for (int i = 0; i < passArray.length; i++) {
			salida += passArray[i];
		}
		return salida;
	}
	
	public void clear(){
		txName.setText("");
		txPassword.setText("");
	}
}