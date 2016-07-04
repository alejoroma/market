package views; 

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import controller.Action;
import controller.Controller;
import models.entity.TypePerson;
import models.entity.TypeProduct;

public class DialogEdit extends DialogAddProduct {

	private static final long serialVersionUID = 1L;

	public DialogEdit(Controller controller) {
		super(controller);
		btnCreate.setText("Edit");
		btnCreate.addActionListener(controller);
		btnCreate.setActionCommand(Action.EDIT.name());
	}
	
	public void loadData(int id, String image, String name, int numberOfProduct, TypePerson typePerson, TypeProduct typeProduct,
			String description, double value) {
		txtId.setText("" + id);
		loadImage(image);
		txtName.setText(name);
		spinerNumberProduct.setValue(numberOfProduct);
		cbxTypePerson.setSelectedItem(typePerson);
		cbxTypeProduct.setSelectedItem(typeProduct);
		txtDescription.setText(description);
		spinertValue.setValue(value);
	}
	
	public void loadImage(String image) {
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(image).getImage().getScaledInstance( 200, -1, java.awt.Image.SCALE_AREA_AVERAGING);
		lbImage.setIcon(new ImageIcon(img));
	}
	
	public Object[] getProductToEdit(String image) {
		Object[] listProductEdit = {Integer.parseInt(txtId.getText()), image,txtName.getText(),
				(int)spinerNumberProduct.getValue(), (TypePerson)cbxTypePerson.getSelectedItem(), 
				(TypeProduct)cbxTypeProduct.getSelectedItem(), txtDescription.getText(), (double)(spinertValue.getValue())};
		return listProductEdit;
	}
	
	public void exit() {
		dispose();
	}
}