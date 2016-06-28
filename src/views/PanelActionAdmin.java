package views;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Action;
import controller.Controller;

public class PanelActionAdmin extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelActionAdmin(Controller controller) {
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton btnDetails = new JButton("Details");
		btnDetails.setBackground(Color.decode("#01DF01"));
		btnDetails.addActionListener(controller);
		btnDetails.setActionCommand(Action.SHOW_DIALOG_DETAILS.name());
		add(btnDetails);
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(Color.decode("#2E64FE"));
		btnEdit.addActionListener(controller);
		btnEdit.setActionCommand(Action.SHOW_DIALOG_EDIT.name());
		add(btnEdit);
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(Color.decode("#FF0000"));
		btnRemove.addActionListener(controller);
		btnRemove.setActionCommand(Action.REMOVE.name());
		add(btnRemove);
	}
}