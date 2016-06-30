package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFileChooser;
import models.dao.ProductManager;
import models.entity.Product;
import persistence.PersistenceManager;
import views.DialogAddProduct;
import views.DialogAdmin;
import views.DialogDetails;
import views.DialogEdit;
import views.DialogShoping;
import views.DialogUser;
import views.PanelActionAdmin;
import views.entrar.WindowsManager;

public class Controller implements ActionListener{

	private WindowsManager mainWindow;
	private ProductManager productManager;
	private DialogAdmin dialogAdmin;
	private DialogAddProduct dialogAddProduct;
	private DialogDetails dialogDetails;
	private DialogEdit dialogEdit;
	private DialogUser dialogUser;
	private String wayImage;
	private Product	product;
	private int page = 0;

	public Controller() {
		mainWindow = new WindowsManager(this);
		dialogAdmin = new DialogAdmin(this);
		productManager = new ProductManager();
		dialogUser = new DialogUser(this);
		dialogAddProduct = new DialogAddProduct(this); 
		dialogDetails = new DialogDetails();
		dialogEdit = new DialogEdit(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Action.valueOf(e.getActionCommand())) {
		case MANAGER:
			showDialogAdmin();
			mainWindow.setVisible(false);
			break;
		case USER:
			this.showWindowUser();
			mainWindow.setVisible(false);
			break;
		case SHOW_DIALOD_ADD:
			showDialogAdd();
			break;
		case ADD:
			addProduct();
			break;
		case REMOVE:
			removeProduct();
			break;
		case ADD_IMAGE:
			this.addImage();
			break;
		case SHOW_DIALOG_DETAILS:
			this.showDialogDetails();
			break;
		case SHOW_DIALOG_EDIT:
			this.showDialogEdit();
			break;
		case EDIT:
			this.editProduct();
			break;
		case PAGE_PREVIEW:
			this.getPagePreview();
			break;
		case PAGE_NEXT:
			this.getPageNext();
			break;
		case CANCELE:
			cancele();
			break;
		case LOGOUT:
			logoudManager();
			break;
		case SHOPPING:
			new DialogShoping().setVisible(true);
			break;
		}
	}
	
	public void logoudManager(){
		if(dialogAdmin.logout() == 0){
			dialogAdmin.setVisible(false);
			mainWindow.setVisible(true);
		}
	}
	
	
	private void cancele() {
		dialogAddProduct.setVisible(false);
	}

	private void showDialogAdd() {
		dialogAddProduct.setLocationRelativeTo(mainWindow);
		dialogAddProduct.setVisible(true);
	}

	private void addProduct() {
		Product product = dialogAddProduct.createProduct();
		productManager.addProduct(product);
		product.setImage(wayImage);
		if ((productManager.getProductList().size() % 10) == 0) {
			dialogAdmin.removePage();
		}
		dialogAdmin.addToTable(product.getAdminProduct(new PanelActionAdmin(this)));
		try {
			PersistenceManager.saveProduct(productManager.getProductList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		loadProduct();
	}

	private void getPagePreview() {
		dialogAdmin.removePage();
		if (page > 0) {
			page--;
			dialogAdmin.addPage(page + 1, (productManager.getProductList().size())/10);
		}
		int i = page * 10;
		while (i < productManager.getProductList().size() && i < (page * 10) + 10) {
			dialogAdmin.addToTable(productManager.getProductList().get(i).getAdminProduct(new PanelActionAdmin(this)));
			i++;
		}
	}

	private void getPageNext() {
		dialogAdmin.removePage();
		if (page * 10 + 10 < productManager.getProductList().size()) {
			page++;
			dialogAdmin.addPage(page + 1, (productManager.getProductList().size())/10 );
		}
		int i = page * 10;
		while (i < productManager.getProductList().size() && i < (page * 10) + 10) {
			dialogAdmin.addToTable(productManager.getProductList().get(i).getAdminProduct(new PanelActionAdmin(this)));
			i++;
		}
	}

	private void loadProduct() {
		try {
			dialogAdmin.removePage();
			productManager.getProductList().clear();
			productManager.getProductList().addAll(PersistenceManager.loadProduct());
			int i = 0;
			for (int j = productManager.getProductList().size() - 1; j >= 0; j--) {
				if (i++ == 10) {
					break;
				}
				dialogAdmin.addToTable(productManager.getProductList().get(j).getAdminProduct(new PanelActionAdmin(this)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showDialogAdmin() {
		loadProduct();
		dialogAdmin.setVisible(true);
	}

	private void showWindowUser() {
		dialogUser.clearPnlProducts();
		productManager.getProductList().clear();
		try {
			productManager.getProductList().addAll(PersistenceManager.loadProduct());
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i = 0;
		for (int j = productManager.getProductList().size() - 1; j >= 0; j--) {
			if (i++ == 12) {
				break;
			}
			dialogUser.addProduct(productManager.getProductList().get(j).getImage(), productManager.getProductList().get(j).getName(), 
					productManager.getProductList().get(j).getDescription(), productManager.getProductList().get(j).getValue());
		}
		dialogUser.setVisible(true);
	}

	private void showDialogDetails() {
		try {
			product = productManager.getProduct(dialogAdmin.getProduct());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dialogDetails.loadData(product.getId(),product.getImage(), product.getName(), product.getNumberOfProduct(),
				product.getTypePerson(), product.getTypeProduct(), product.getDescription(), product.getValue());
		dialogDetails.setLocationRelativeTo(mainWindow);
		dialogDetails.setVisible(true);
	}

	private void showDialogEdit() {
		try {
			System.out.println(dialogAdmin.getProduct());
			product = productManager.getProduct(dialogAdmin.getProduct());
			dialogEdit.loadData(product.getId(),product.getImage(), product.getName(), product.getNumberOfProduct(),
					product.getTypePerson(), product.getTypeProduct(), product.getDescription(), product.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dialogEdit.setVisible(true);
	}

	private void editProduct() {
		try {
			dialogEdit.editProduct(dialogAdmin.getProduct(), product.getImage());
			PersistenceManager.saveProduct(productManager.getProductList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		loadProduct();
	}

	private void addImage() {
		JFileChooser chooserFile = new JFileChooser();
		chooserFile.showOpenDialog(dialogAddProduct);
		wayImage = chooserFile.getSelectedFile().toString();
		dialogAddProduct.setLbImage(wayImage);
	}

	private void removeProduct() {
//		if()
		productManager.removeProduct(dialogAdmin.getProduct());
		try {
			PersistenceManager.saveProduct(productManager.getProductList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dialogAdmin.removeRow();
		System.out.println(productManager.getProductList());
	}
}