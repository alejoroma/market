package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;





import javax.swing.JButton;

import models.dao.ProductManager;
import models.entity.Product;
import models.entity.StatusProduct;
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
		case ADD_SHOPING:
			addShoping((JButton) e.getSource());
			break;
		case FILTER_USER:
			break;
		case PAGE_FIRST_PAGE:
			primeraPaguinaTabla();
			break;
		case PAGE_FINISH_PAGE:
			UltimaPaguinaTabla();
			break;
		case PAGE_NEXT_ADMIN:
			siguientePaguinaTabla();
			break;
		}
		
	}

	private void siguientePaguinaTabla() {
		int page = dialogAdmin.getPage() +1 ;
		try {
			dialogAdmin.paguinaActual(page, productManager.totalPaguinas());
			loadProduct(productManager.siguientePaguina(page));	
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	private void UltimaPaguinaTabla() {
		try {
			dialogAdmin.paguinaActual(productManager.totalPaguinas(), productManager.totalPaguinas());
			loadProduct(productManager.paginaFinal());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void primeraPaguinaTabla() {
		try {
			dialogAdmin.paguinaActual(1, productManager.totalPaguinas());
			loadProduct(productManager.paginaPrincipal());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	private void addShoping(JButton btn) {
//		try {
//			Product product = productManager.getProduct(Integer.parseInt(btn.getName()));
//			product.viewStatusProduct();
//			PersistenceManager.saveProduct(productManager.getProductList());
//			dialogProducList.addProduct(this, product.getImage(), ProductManager.getDate(), product.getName(), product.getValue());
//			showWindowUser();
//			dialogReport.refrechDates(0, dialogProducList.getNumberProduct(), 0, 0, 0, 0, 0);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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
			productManager.editProduct(id, dialogEdit.createProductEdit());
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
			productManager.addProduct(product);
			dialogAdmin.paguinaActual(1, productManager.totalPaguinas());
			loadProduct(productManager.paginaPrincipal());
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
		dialogAdmin.addToTable(produtos, this);
	}
	
	@SuppressWarnings("static-access")
	private void showDialogAdmin() {
		try {
			dialogAdmin.paguinaActual(1, productManager.totalPaguinas());
			loadProduct(productManager.paginaPrincipal());
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
	private void showWindowUser() {
		dialogUser.clearPnlProduct();
		try {
			dialogUser.addProduct(this, productManager.obtenerProdutosDisponible());
			dialogUser.setVisible(true);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
//	private void addImage() {
//		JFileChooser chooserFile = new JFileChooser();
//		chooserFile.showOpenDialog(dialogAddProduct);
//		wayImage = chooserFile.getSelectedFile().toString();
//		dialogAddProduct.setLbImage(wayImage);
//	}
//
	
}