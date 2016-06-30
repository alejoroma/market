package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controller.Action;
import controller.Controller;

public class PanelActionAdmin extends JPanel  {

	private static final long serialVersionUID = 1L;
	public static final int TAMAÑO_LETRA = 10;
	public static final String TYPE_WORD = "Arial Black";
	private static JButton btCancelar;
	private static JButton btAceptar;

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
		
		
		
	    btCancelar= new JButton("Cancel");
	    btCancelar.setBackground(Color.decode("#2980B9"));
	    btCancelar.setFont(new Font("Arial Black", Font.PLAIN, 12));
	    btCancelar.setForeground(Color.WHITE);
	    
	    btAceptar= new JButton("Accept");
	    btAceptar.setBackground(Color.decode("#52BE80"));
	    btAceptar.setFont(new Font("Arial Black", Font.PLAIN, 12));
	    btAceptar.setForeground(Color.WHITE);
	   
	    btAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = getOptionPane((JComponent)e.getSource());
                pane.setValue(JOptionPane.OK_OPTION);
            }
        });
	    
	    btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = getOptionPane((JComponent)e.getSource());
                pane.setValue(JOptionPane.CANCEL_OPTION);
            }
        });
	}
	
	@SuppressWarnings("static-access")
	public static int  remorveOK(){
		UIManager UI=new UIManager();
		UI.put("OptionPane.background", Color.white);
		UI.put("Panel.background", Color.white);
	    JOptionPane myOptionPane = new JOptionPane("Are you sure you want to delate?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION,  new ImageIcon("src/imgs/png/warning.png"),new Object [] { btCancelar, btAceptar},btAceptar);
	    JDialog myDialog = myOptionPane.createDialog(null, "Remove");
	    myDialog.setModal(true);
	    myDialog.setVisible(true);
	    Object result = myOptionPane.getValue();
	    return Integer.parseInt(result +"");	
	}	

	@SuppressWarnings("static-access")
	public static int  Logout(){
		UIManager UI=new UIManager();
		UI.put("OptionPane.background", Color.white);
		UI.put("Panel.background", Color.white);
		JOptionPane myOptionPane = new JOptionPane("Are you sure you want to close?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION,  new ImageIcon("src/imgs/png/logout.png"),new Object [] { btCancelar, btAceptar},btAceptar);
	    JDialog myDialog = myOptionPane.createDialog(null, "Logout");
	    myDialog.setModal(true);
	    myDialog.setVisible(true);
	    Object result = myOptionPane.getValue();
	    return Integer.parseInt(result +"");
	}	
	
	protected static JOptionPane getOptionPane(JComponent parent) {
	    JOptionPane pane = null;
	    if (!(parent instanceof JOptionPane)) {
	        pane = getOptionPane((JComponent) parent.getParent());
	    } else {
	        pane = (JOptionPane) parent;
	    }
	    return pane;
	}
	
   @SuppressWarnings("unused")
private static void inactivateOption(Container container, String text) {
      Component[] comps = container.getComponents();
      for (Component comp : comps) {
         if (comp instanceof AbstractButton) {
            AbstractButton btn = (AbstractButton) comp;
            if (btn.getActionCommand().equals(text)) {
               btn.setEnabled(false);
               return;
            }
         } else if (comp instanceof Container) {
            inactivateOption((Container) comp, text);
         }
      }
   }
}