package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Action;
import controller.Controller;

public class PanelActionAdmin extends JPanel  {

	private static final long serialVersionUID = 1L;
	public static final int TAMAÑO_LETRA = 10;
	public static final String TYPE_WORD = "Arial Black";

	public PanelActionAdmin(Controller controller) {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 3, 5, 8));
		JButton btnDetails = new JButton("Details");
		btnDetails.setBackground(Color.decode("#1E8449"));
		btnDetails.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMAÑO_LETRA));
		btnDetails.setForeground(Color.WHITE); 
		btnDetails.addActionListener(controller);
		btnDetails.setActionCommand(Action.SHOW_DIALOG_DETAILS.name());
		add(btnDetails);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(Color.decode("#1F618D"));
		btnEdit.addActionListener(controller);
		btnEdit.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMAÑO_LETRA));
		btnEdit.setForeground(Color.WHITE); 
		btnEdit.setActionCommand(Action.SHOW_DIALOG_EDIT.name());
		add(btnEdit);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(Color.decode("#C0392B"));
		btnRemove.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMAÑO_LETRA));
		btnRemove.setForeground(Color.WHITE); 
		btnRemove.addActionListener(controller);
		btnRemove.setActionCommand(Action.REMOVE.name());
		add(btnRemove);
	}
}