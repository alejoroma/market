package views; 

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

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
		getBtnCreate().setText("Edit");
		getBtnCreate().addActionListener(controller);
		getBtnCreate().setActionCommand(Action.EDIT.name());
		setLocationRelativeTo(null);
	}
	
	public void loadData(Product product) {
		Object [] informacionProducto = product.getDetallesProduct();
		getTxtId().setText(informacionProducto[0].toString());
		setLbImage(informacionProducto[1].toString());
		getTxtName().setText(informacionProducto[2].toString());
		getSpinerNumberProduct().setValue((int) informacionProducto[3]);
		getCbxTypePerson().setSelectedItem((TypePerson)informacionProducto[4]);
		getCbxTypeProduct().setSelectedItem((TypeProduct)informacionProducto[5]);
		getTxtDescription().setText(informacionProducto[6].toString());
		double value =  (double) informacionProducto[7];
		getSpinerValue().setValue((int) value);
	}
	
	public Product editProduct(int id, String image) {
		Product exit = createProduct();
		exit.toString();
		return exit;
	}
}