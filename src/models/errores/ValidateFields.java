package models.errores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ValidateFields {
	
	public static boolean validateId(JTextField jTextField) {
		if (!jTextField.getText().equals("")) {
			return true;
		}
		return false;
	}
	
	public static boolean validateName(JTextField jTextField) {
		if (!jTextField.getText().equals("")) {
			return true;
		}
		return false;
	}
	
	public static boolean validatePrece(JTextField jTextField) {
		if (!jTextField.getText().equals("")) {
			return true;
		}
		return false;
	}
	
	public static boolean validateDescription(JTextArea textArea) {
		if (!textArea.getText().equals("")) {
			return true;
		}
		return false;
	}

	public static void onlyNumber(JTextField jTextField) {
		jTextField.addKeyListener(new KeyListener() {
			@SuppressWarnings("static-access")
			public void keyTyped(KeyEvent e) {
				Character character = e.getKeyChar();
				if (!character.isLetterOrDigit(character) || character.isLetter(character)) {
					e.consume();
				}
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
	}
	
	public static void onlyLetter(JTextArea jTextArea) {
		jTextArea.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				Character character = e.getKeyChar();
				if (!Character.isLetterOrDigit(character) || Character.isDigit(character)) {
					if (character.charValue() != ' ') {
						e.consume();
					}
				}
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
	}

	public static void onlyLetter(JTextField jTextField) {
		jTextField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				Character character = e.getKeyChar();
				if (!Character.isLetterOrDigit(character) || Character.isDigit(character)) {
					if (character.charValue() != ' ') {
						e.consume();
					}
				}
			}
			public void keyPressed(KeyEvent e) {
				@SuppressWarnings("unused")
				Character character = e.getKeyChar();
			}
			public void keyReleased(KeyEvent e) {
			}
		});
	}
}