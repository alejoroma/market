package views.entrar;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import controller.Controller;


public class WindowsManager extends JFrame  {
	
	private static final long serialVersionUID = 1L;
	public static final int TAMAÑO_LETRA = 15;
	public static final String TYPE_WORD = "Arial Black";
	private Panelfondo ventanaLogin;
	
	public WindowsManager(Controller controller) {
		setTitle(":)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setBackground(Color.decode("#4d4d4f"));
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height - 38);
		ventanaLogin = new Panelfondo(controller);
		add(ventanaLogin);
		setVisible(true);
	}
}