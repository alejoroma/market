package views;

import java.awt.Component;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

import controller.Controller;

public class CellEditorTableUser extends AbstractCellEditor implements TableCellEditor {

	private static final long serialVersionUID = 1L;
	Controller controller;
	
	 public CellEditorTableUser(Controller controller) {
		this.controller = controller;
	}

	@Override
	public Object getCellEditorValue() {
		return new PanelActionUser(controller);
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return (JComponent)value;
	}
}
