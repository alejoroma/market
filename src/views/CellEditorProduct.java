package views;


import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import controller.Action;
import controller.Controller;

public class CellEditorProduct extends AbstractCellEditor implements TableCellEditor {

	private static final long serialVersionUID = 1L;
	Controller controller;
	
	 public CellEditorProduct(Controller controller) {
		this.controller = controller;
	}

	@Override
	public Object getCellEditorValue() {
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(controller);
		btnBuy.setActionCommand(Action.BUY_PRODUCT.name());
		return btnBuy;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		return (JComponent)value;
	}
}
