package views; 

import controller.Action;
import controller.Controller;
import models.dao.ProductManager;
import models.entity.Product;
import models.entity.TypePerson;
import models.entity.TypeProduct;

public class DialogEdit extends DialogAddProduct{

	private static final long serialVersionUID = 1L;

	public DialogEdit(Controller controller) {
		super(controller);
		btnCreate.setText("Edit");
		btnCreate.addActionListener(controller);
		btnCreate.setActionCommand(Action.EDIT.name());
		setLocationRelativeTo(null);
	}
	
	public void loadData(Product product) {
		Object [] informacionProducto = product.getDetallesProduct();
		txtId.setText((String) informacionProducto[0].toString());
		setLbImage(informacionProducto[1].toString());
		txtName.setText(informacionProducto[2].toString());
		spinerNumberProduct.setValue((int) informacionProducto[3]);
		cbxTypePerson.setSelectedItem((TypePerson)informacionProducto[4]);
		cbxTypeProduct.setSelectedItem((TypeProduct)informacionProducto[5]);
		txtDescription.setText(informacionProducto[6].toString());
		double value =  (double) informacionProducto[7];
		spinertValue.setValue((int) value);
	}
	
	public Product createProductEdit() {
		return createProduct();
	}
}