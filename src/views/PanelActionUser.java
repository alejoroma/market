package views;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Action;
import controller.Controller;

public class PanelActionUser extends JPanel{

	private static final long serialVersionUID = 1L;

	public PanelActionUser(Controller controller) {
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton btnBuy = new JButton("BUY");
		btnBuy.setBackground(Color.ORANGE);
		btnBuy.addActionListener(controller);
		btnBuy.setActionCommand(Action.BUY.name());
		add(btnBuy);
	}
}