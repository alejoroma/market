package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Action;
import controller.Controller;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainWindow(Controller controller) {
		setSize(500, 500);
		setTitle("Crud-Product 1.0");
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(pnlHeader, BorderLayout.NORTH);
		
		JPanel pnlBody = new JPanel();
		pnlBody.setBackground(Color.WHITE);
		pnlBody.setLayout(new GridLayout(1, 1));
		add(pnlBody, BorderLayout.CENTER); 
		
		JLabel lbImage = new JLabel(new ImageIcon(getClass().getResource("/imgs/image.jpg")));
		pnlBody.add(lbImage);
		JButton btnAdmin = new JButton("Manager");
		btnAdmin.setBackground(Color.ORANGE);
		btnAdmin.addActionListener(controller);
		btnAdmin.setActionCommand(Action.MANAGER.name());
		pnlHeader.add(btnAdmin);
		
		JButton btnUser = new JButton("User");
		btnUser.setBackground(Color.GREEN);
		btnUser.addActionListener(controller);
		btnUser.setActionCommand(Action.USER.name());
		pnlHeader.add(btnUser);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainWindow(null);
	}
}
