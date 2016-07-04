package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import models.dao.ProductManager;
import models.entity.Product;
import models.entity.StatusProduct;
import persistence.PersistenceManager;
import views.DialogAddProduct;
import views.WindowAdmin;
import views.DialogDetails;
import views.DialogEdit;
import views.DialogProductList;
import views.DialogShoping;
import views.WindowUser;
import views.PanelActionAdmin;
import views.entrar.WindowsManager;

public class Controller implements ActionListener{

	private WindowsManager mainWindow;
	private ProductManager productManager;
	private WindowAdmin dialogAdmin;
	private DialogAddProduct dialogAddProduct;
	private DialogDetails dialogDetails;
	private DialogEdit dialogEdit;
	private WindowUser dialogUser;
	private DialogProductList dialogProducList;
	private Product	product;
	private int page;

	public Controller() {
		mainWindow = new WindowsManager(this);
		dialogAdmin = new WindowAdmin(this);
		productManager = new ProductManager();
		dialogUser = new WindowUser(this);
		dialogAddProduct = new DialogAddProduct(this); 
		dialogDetails = new DialogDetails();
		dialogEdit = new DialogEdit(this);
		dialogProducList = new DialogProductList(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Action.valueOf(e.getActionCommand())) {
		case MANAGER:
			showDialogAdmin();
			break;
		case USER:
			this.showWindowUser();
			break;
		case SHOW_DIALOD_ADD:
			dialogAddProduct.setVisible(true);
			break;
		case ADD:
			addProduct();
			break;
		case ADD_IMAGE:
			loadImage();
			break;
		case REMOVE:
			removeProduct();
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
		case PAGE_PREVIEW_ADMIN:
			getPagePreviewAdmin();
			break;
		case PAGE_NEXT_ADMIN:
			getPageNextAdmin();
			break;
		case PAGE_PREVIEW_USER:
			getPagePreviewUser();
			break;
		case PAGE_NEXT_USER:
			getPageNextUser();
			break;
		case CANCELE:
			dialogAddProduct.setVisible(false);
			break;
		case LOGOUT:
			logoutManager();
			break;
		case SHOPPING:
			new DialogShoping().setVisible(true);
			break;
		case FILTER_FOR_TYPE_PRODUCT:
			filterForTypeProduct();
			break;
		case FILTER_USER:
			break;
		case ADD_SHOPING:
			addShoping((JButton) e.getSource());
			break;
		case SHOW_DIALOGSHOPING:
			dialogProducList.setVisible(true);
			break;
		case BUY_PRODUCT:
			buyProduct();
			break;
		case BUY_ALL:
			buyAllProducts();
			break;
		}
	}

	private void buyAllProducts() {
		dialogProducList.buyAllProducts();
		dialogProducList.getValueAbsolute(this, dialogProducList.getValueAbsoluteUpdate());
	}

	private void buyProduct() {
		dialogProducList.buyProduct();
		dialogProducList.getValueAbsolute(this, dialogProducList.getValueAbsoluteUpdate());
	}

	private void addShoping(JButton btn) {
		try {
			Product product = productManager.getProduct(Integer.parseInt(btn.getText()));
			product.viewStatusProduct();
			PersistenceManager.saveProduct(productManager.getProductList());
			dialogProducList.addProduct(this, product.getImage(), ProductManager.getDate(), product.getName(), product.getValue());
			showWindowUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadImage() {
		if (dialogAddProduct.isVisible()) {
			dialogAddProduct.addImage();
		} else {
			dialogEdit.addImage();
		}
	}

	private void filterForTypeProduct() {
		dialogAdmin.filterForCategory(productManager.filterForTypeProduct(dialogAdmin.getTypeCategorySelected()), this);
	}

	public void logoutManager(){
		if(dialogAdmin.logout() == 0){
			dialogAdmin.setVisible(false);
			mainWindow.setVisible(true);
		}
	}

	private void addProduct() {
		page = 1;
		Product product = dialogAddProduct.createProduct();
		productManager.addProduct(product);
		dialogAddProduct.resetDialog();
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

	private void getPagePreviewAdmin() {
		dialogAdmin.removePage();
		if (page > 0) {
			page--;
			dialogAdmin.addPage(page + 1, getAbsolutePage());
		}
		int i = page * 10;
		while (i < productManager.getProductList().size() && i < (page * 10) + 10) {
			dialogAdmin.addToTable(productManager.getProductList().get(i).getAdminProduct(new PanelActionAdmin(this)));
			i++;
		}
	}
	
	private void getPagePreviewUser() {
		dialogUser.clearPnlProduct();
		if (page > 0) {
			page--;
			dialogUser.addPage(page + 1, getAbsolutePage());
		}
		int i = page * 20;
		while (i < productManager.getProductList().size() && i < (page * 20) + 20) {
			dialogUser.addProduct(this, productManager.getProductList().get(i).getId(), productManager.getProductList().get(i).getNumberOfProduct(),
					productManager.getProductList().get(i).getImage(), productManager.getProductList().get(i).getName(),
					productManager.getProductList().get(i).getDescription(), productManager.getProductList().get(i).getValue());
			i++;
		}
		dialogUser.repaint();
	}

	private void getPageNextAdmin() {
		dialogAdmin.removePage();
		if (page * 10 + 10 < productManager.getProductList().size()) {
			page++;
			dialogAdmin.addPage(page + 1, getAbsolutePage());
		}
		int i = page * 10;
		while (i < productManager.getProductList().size() && i < (page * 10) + 10) {
			dialogAdmin.addToTable(productManager.getProductList().get(i).getAdminProduct(new PanelActionAdmin(this)));
			i++;
		}
	}
	
	private void getPageNextUser() {
		dialogUser.clearPnlProduct();
		if (page * 20 + 20 < productManager.getProductList().size()) {
			page++;
			dialogUser.addPage(page + 1, getAbsolutePage());
		}
		int i = page * 20;
		while (i < productManager.getProductList().size() && i < (page * 20) + 20) {
			dialogUser.addProduct(this, productManager.getProductList().get(i).getId(), productManager.getProductList().get(i).getNumberOfProduct(),
					productManager.getProductList().get(i).getImage(), productManager.getProductList().get(i).getName(),
					productManager.getProductList().get(i).getDescription(), productManager.getProductList().get(i).getValue());
			i++;
		}
		dialogUser.repaint();
	}

	private int getAbsolutePage() {
		int page = productManager.getProductList().size() / 10;
		if (productManager.getProductList().size() % 10 != 0) {
			page++;
		}
		return page;
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
		dialogUser.clearPnlProduct();
		productManager.getProductList().clear();
		try {
			productManager.getProductList().addAll(PersistenceManager.loadProduct());
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i = 0;
		for (int j = productManager.getProductList().size() - 1; j >= 0; j--) {
			if (i++ == 20) {
				break;
			}
			productManager.getProductList().get(j).changeStatus(productManager.getProductList().get(j).getNumberOfProduct());
			if (productManager.getProductList().get(j).getStatusProduct() != StatusProduct.NO_DISPONIBLE) {
				dialogUser.addProduct(this, productManager.getProductList().get(j).getId(), productManager.getProductList().get(j).getNumberOfProduct(),
						productManager.getProductList().get(j).getImage(), productManager.getProductList().get(j).getName(), 
						productManager.getProductList().get(j).getDescription(), productManager.getProductList().get(j).getValue());
			}
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
			product = productManager.getProduct(dialogAdmin.getProduct());
			dialogEdit.loadData(product.getId(), product.getImage(), product.getName(), product.getNumberOfProduct(),
					product.getTypePerson(), product.getTypeProduct(), product.getDescription(), product.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dialogEdit.setVisible(true);
	}

	private void editProduct() {
		try {
			String wayImage; 
			if (dialogEdit.getWayImage() != null) {
				wayImage = dialogEdit.getWayImage();
			} else {
				wayImage = product.getImage();
			}
			productManager.editProduct(product.getId(), dialogEdit.getProductToEdit(wayImage));
			PersistenceManager.saveProduct(productManager.getProductList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		loadProduct();
		dialogEdit.exit();
	}

	private void removeProduct() {
		if(PanelActionAdmin.remorveOK() == 0){
			productManager.removeProduct(dialogAdmin.getProduct());
			try {
				PersistenceManager.saveProduct(productManager.getProductList());
			} catch (Exception e) {
				e.printStackTrace();
			}
			dialogAdmin.removeRow();
		}
	}
}