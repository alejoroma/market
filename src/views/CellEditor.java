package views;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import controller.Controller;

public class CellEditor extends AbstractCellEditor implements TableCellEditor {

	private static final long serialVersionUID = 1L;
	Controller controller;
	
	public CellEditor(Controller controller) {
		this.controller = controller;
	}

	@Override
	public Object getCellEditorValue() {
		return new PanelActionAdmin(controller);
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return (JComponent)value;
	}
}