package views.entrar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controller.Action;
import controller.Controller;

public class WindowsManager extends JFrame  {
	
	private static final long serialVersionUID = 1L;
	
	public WindowsManager(Controller controller) {
		setTitle("Log in");
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(getMaximumSize());
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(new Color(200, 200, 200));
		panelCenter.setLayout(null);
		panelCenter.setOpaque(false);
		add(panelCenter,BorderLayout.CENTER);
		
		JPanel jpanelConten = new JPanel();
		jpanelConten.setBounds(450, 100, 400, 500);
		jpanelConten.setLayout(null);
		jpanelConten.setBackground(new Color(220, 220, 220));
		panelCenter.add(jpanelConten);
		
		JLabel labelTitle1 = new JLabel("Flea market, all your shopping in one place");
		labelTitle1.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle1.setFont(new Font("Arial", Font.ITALIC, 16));
		labelTitle1.setForeground(new Color(0, 0, 0));
		labelTitle1.setBounds(30, 10, 350, 30);
		jpanelConten.add(labelTitle1);
		
		JLabel labelImageLogo = new JLabel(new ImageIcon(getClass().getResource("/imgs/png//commerce.png")));
		labelImageLogo.setBounds(80, 50, 250, 250);
		jpanelConten.add(labelImageLogo);
		
		JButton btnUser = new JButton(new ImageIcon(getClass().getResource("/imgs/png//manager.png")));
		btnUser.setBackground(Color.decode("#ffffff"));
		btnUser.setForeground(Color.WHITE); 
		btnUser.setOpaque(false);
		btnUser.setBorderPainted(false);
		btnUser.setLayout(null);
		btnUser.setBounds(100,350 , 50, 50);
		btnUser.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
		btnUser.addActionListener(controller);
		btnUser.setActionCommand(Action.USER.name());
		jpanelConten.add(btnUser);
		
		JLabel lbJLabelUser = new JLabel("User");
		lbJLabelUser.setBounds(105, 400, 100, 40);
		lbJLabelUser.setFont(new Font("Roman", Font.ITALIC, 15));
		lbJLabelUser.setForeground(Color.black);
		jpanelConten.add(lbJLabelUser);

		JButton btnVisitante = new JButton(new ImageIcon(getClass().getResource("/imgs/png//users.png")));
		btnVisitante.setBackground(Color.decode("#ffffff"));
		btnVisitante.setForeground(Color.WHITE); 
		btnVisitante.setOpaque(false);
		btnVisitante.setBounds(250, 350, 50, 50);
		btnVisitante.setBorderPainted(false);
		btnVisitante.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
		btnVisitante.addActionListener(controller);
		btnVisitante.setActionCommand(Action.MANAGER.name());
		jpanelConten.add(btnVisitante);
		
		JLabel labelManager = new JLabel("Manager");
		labelManager.setFont(new Font("Roman", Font.ITALIC, 15));
		labelManager.setForeground(Color.black);
		labelManager.setBounds(250, 400, 100, 40);
		jpanelConten.add(labelManager);
		
		setVisible(true);
		
	}
}