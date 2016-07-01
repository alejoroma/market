package views; 

import controller.Action;
import controller.Controller;
import models.dao.ProductManager;
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
	
	public void loadData(int id, String image, String name, int numberOfProduct, TypePerson typePerson,
			TypeProduct typeProduct,
			String description, double value) {
		getTxtId().setText("" + id);
		setLbImage(image);
		getTxtName().setText(name);
		getSpinerNumberProduct().setValue(numberOfProduct);
		getCbxTypePerson().setSelectedItem(typePerson);
		getCbxTypeProduct().setSelectedItem(typeProduct);
		getTxtDescription().setText(description);
		getSpinerValue().setValue(1);
	}
	
	public void editProduct(int id, String image) {
		ProductManager.editProduct(id, Integer.parseInt(getTxtId().getText()), image, getTxtName().getText(),
				(int)getSpinerNumberProduct().getValue(), (TypePerson)getCbxTypePerson().getSelectedItem(), 
				(TypeProduct)getCbxTypeProduct().getSelectedItem(), getTxtDescription().getText(), 
				Double.parseDouble(getSpinerValue().getValue().toString()));
		
	}
}