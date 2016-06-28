package views.entrar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import controller.Action;
import controller.Controller;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panelfondo  extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon imagen;
	public static final int TAMAÑO_LETRA = 15;
	public static final String TYPE_WORD = "Arial Black";
	
	
	public Panelfondo(Controller controller){
		imagen = new ImageIcon(getClass().getResource("/imgs/fondoP.jpg"));

		setLayout(null);
		setBackground(Color.WHITE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height - 38);

		JButton btnUser = new JButton(new ImageIcon(getClass().getResource("/imgs/png//manager.png")));
		btnUser.setBackground(Color.decode("#ffffff"));
		btnUser.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMAÑO_LETRA));
		btnUser.setForeground(Color.WHITE); 
		btnUser.setOpaque(false);
		btnUser.setBorderPainted(false);
		btnUser.setBounds(550, 300, 100, 100);
		btnUser.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
		btnUser.addActionListener(controller);
		btnUser.setActionCommand(Action.USER.name());
		add(btnUser);

		JButton btnVisitante = new JButton(new ImageIcon(getClass().getResource("/imgs/png//users.png")));
		btnVisitante.setBackground(Color.decode("#ffffff"));
		btnVisitante.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMAÑO_LETRA));
		btnVisitante.setForeground(Color.WHITE); 
		btnVisitante.setOpaque(false);
		btnVisitante.setBounds(650, 300, 100, 100);
		btnVisitante.setBorderPainted(false);
		btnVisitante.setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
		btnVisitante.addActionListener(controller);
		btnVisitante.setActionCommand(Action.MANAGER.name());
		add(btnVisitante);
		
//		JLabel lbUser = new JLabel("User", SwingConstants.CENTER);
//		lbUser.setBounds(550, 405, 85, 30);
//		lbUser.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMAÑO_LETRA));
//		lbUser.setForeground(Color.decode("#000000"));
//		add(lbUser);
//		
//		JLabel lbVisitante = new JLabel("Client" , SwingConstants.CENTER);
//		lbVisitante.setBounds(650, 405, 100, 30);
//		lbVisitante.setFont(new Font(TYPE_WORD, Font.PLAIN, TAMAÑO_LETRA));
//		lbVisitante.setForeground(Color.decode("#000000"));
//		add(lbVisitante);
		
		setVisible(true);
	}

	public void pintar(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(imagen.getImage(), 0, 0, this);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		pintar(g);
	}
}