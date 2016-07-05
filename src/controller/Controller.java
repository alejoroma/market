package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import models.dao.ProductManager;
import models.entity.Product;
import persistence.PersistenceManager;
import views.DialogAddProduct;
import views.DialogDetails;
import views.DialogEdit;
import views.DialogShoping;
import views.PanelActionAdmin;
import views.WindowAdmin;
import views.WindowUser;
import views.entrar.WindowsManager;

public class Controller implements ActionListener{

	private WindowsManager mainWindow;
	private ProductManager productManager;
	private WindowAdmin dialogAdmin;
	private DialogAddProduct dialogAddProduct;
	private DialogDetails dialogDetails;
	private DialogEdit dialogEdit;
	private WindowUser dialogUser;
	private String wayImage;
	private int page = 0;
	private int id;

	public Controller() {
		mainWindow = new WindowsManager(this);
		dialogAdmin = new WindowAdmin(this);
		productManager = new ProductManager();
		dialogUser = new WindowUser(this);
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
//			this.showWindowUser();
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
//			addImage();
			break;
		case SHOW_DIALOG_DETAILS:
			showDialogDetails();
			break;
		case SHOW_DIALOG_EDIT:
			showDialogEdit();
			break;
		case EDIT:
			editProduct();
			break;
//		case PAGE_PREVIEW:
////			getPagePreview();
//			break;
//		case PAGE_NEXT:
////			getPageNext();
//			break;
		case CANCELE:
			cancele();
			break;
		case LOGOUT:
			logoutManager();
			break;
		case SHOPPING:
			new DialogShoping().setVisible(true);
			break;
		case FILTER_FOR_TYPE_PRODUCT:
//			filterForTypeProduct();
			break;
//		case BUY:
//			break;
		case FILTER_USER:
			break;
		}
	}
	
//	private void filterForTypeProduct() {
//		dialogAdmin.filterForCategory(productManager.filterForTypeProduct(dialogAdmin.getTypeCategorySelected()), this);
//	}

	private void showDialogEdit() {
		id =dialogAdmin.obtenerIDProductoSelecionado();
		try {
			Product product = productManager.obtenerProductSelecionado(id);
			dialogEdit.loadData(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dialogEdit.setVisible(true);
	}
	
	@SuppressWarnings("static-access")
	private void editProduct() {
		try {
			productManager.editProduct(id, dialogEdit.createProduct());
			loadProduct(productManager.loadProducto());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dialogEdit.setVisible(false);
	}
	
	private void showDialogDetails() {
		try {
			Product product = productManager.obtenerProductSelecionado(dialogAdmin.obtenerIDProductoSelecionado());
			dialogDetails.loadData(product);
			dialogDetails.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logoutManager(){
		if(PanelActionAdmin.Logout() == 0){
			dialogAdmin.setVisible(false);
			mainWindow.setVisible(true);
		}
	}
	
	private void cancele() {
		dialogAddProduct.setVisible(false);
		dialogAddProduct.resetDialog();
	}

	private void showDialogAdd() {
		dialogAddProduct.setLocationRelativeTo(mainWindow);
		dialogAddProduct.setVisible(true);
	}

	@SuppressWarnings("static-access")
	private void addProduct(){
		Product product = dialogAddProduct.createProduct();
		try {
			System.out.println("hola");
			productManager.addProduct(product);
			loadProduct(productManager.loadProducto());
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		product.setImage(wayImage);
//		if ((productManager.getProductList().size() % 10) == 0) {
//			dialogAdmin.removePage();
//		}
//		dialogAdmin.addToTable(product.getAdminProduct(new PanelActionAdmin(this)));
//		try {
//			PersistenceManager.saveProduct(productManager.getProductList());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}
	
	private void removeProduct() {
		if(PanelActionAdmin.remorveOK() == 0){
			try {
				productManager.removeProduct(dialogAdmin.obtenerIDProductoSelecionado());
			} catch (ParseException | IOException e) {
				e.printStackTrace();
			}
			dialogAdmin.removeRow();
		}
	}
	
	private void loadProduct(ArrayList<Product> produtos) throws IOException {
		dialogAdmin.removePage();
		int i = 0;
		for (int j = produtos.size() - 1; j >= 0; j--) {
			if (i++ == 10) {
				break;
			}
			dialogAdmin.addToTable(produtos.get(j).getAdminProduct(new PanelActionAdmin(this)));
		}
	}
	
	@SuppressWarnings("static-access")
	private void showDialogAdmin() {
		try {
			loadProduct(productManager.loadProducto());
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		dialogAdmin.setVisible(true);
	}

//	private void getPagePreview() {
//		dialogAdmin.removePage();
//		if (page > 0) {
//			page--;
//			dialogAdmin.addPage(page + 1, (productManager.getProductList().size())/10);
//		}
//		int i = page * 10;
//		while (i < productManager.getProductList().size() && i < (page * 10) + 10) {
//			dialogAdmin.addToTable(productManager.getProductList().get(i).getAdminProduct(new PanelActionAdmin(this)));
//			i++;
//		}
//	}
//
//	private void getPageNext() {
//		dialogAdmin.removePage();
//		if (page * 10 + 10 < productManager.getProductList().size()) {
//			page++;
//			dialogAdmin.addPage(page + 1, (productManager.getProductList().size())/10 );
//		}
//		int i = page * 10;
//		while (i < productManager.getProductList().size() && i < (page * 10) + 10) {
//			dialogAdmin.addToTable(productManager.getProductList().get(i).getAdminProduct(new PanelActionAdmin(this)));
//			i++;
//		}
//	}
//
//	private void showWindowUser() {
//		dialogUser.clearPnlProducts();
//		productManager.getProductList().clear();
//		try {
//			productManager.getProductList().addAll(PersistenceManager.loadProduct());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		int i = 0;
//		for (int j = productManager.getProductList().size() - 1; j >= 0; j--) {
//			if (i++ == 12) {
//				break;
//			}
//			dialogUser.addProduct(productManager.getProductList().get(j).getImage(), productManager.getProductList().get(j).getName(), 
//					productManager.getProductList().get(j).getDescription(), productManager.getProductList().get(j).getValue());
//		}
//		dialogUser.setVisible(true);
//	}
//
//	private void addImage() {
//		JFileChooser chooserFile = new JFileChooser();
//		chooserFile.showOpenDialog(dialogAddProduct);
//		wayImage = chooserFile.getSelectedFile().toString();
//		dialogAddProduct.setLbImage(wayImage);
//	}
//
	
}