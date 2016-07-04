package models.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import models.entity.Product;
import models.entity.StatusProduct;
import models.entity.TypePerson;
import models.entity.TypeProduct;

public class ProductManager {

	private static ArrayList<Product> productList;
	
	public ProductManager() {
		productList = new ArrayList<>();
	}
	
	public static Product createProduct(int id, String image, String name, int numberOfProduct, TypePerson typePerson, TypeProduct typeProduct,	String description, double value) {
		return new Product(id, image, name, numberOfProduct, typePerson, typeProduct, description, value);
	}
	
	public void addProduct(Product product) {
		productList.add(product);
	}
	
	public ArrayList<Product> getProductList() {
		return productList;
	}
	
	public Product getProduct(int id) throws Exception {
		for (Product product : productList) {
			if (product.getId() == id) {
				return product;
			}
		}
		throw new Exception("Ha ocurrido un error desconocido");
	}
	
	public void editProduct(int searchId, Object[] listProductEdit) {
		for (Product product : productList) {
			if (product.getId() == searchId) {
				product.editProduct(listProductEdit);
				break;
			}
		}
	}
	
	public void removeProduct(int id) {
		for (Product product : productList) {
			if (product.getId() == id) {
				productList.remove(product);
				break;
			}
		}
	}
	
	public ArrayList<Product> filterForTypeProduct(TypeProduct typeProduct){
		ArrayList<Product> productTypeList = new ArrayList<>();
		for (Product product : productList) {
			if (product.getTypeProduct().equals(typeProduct)) {
				productTypeList.add(product); 
			}
		}
		return productTypeList;
	}
	
	public ArrayList<Product> getFilterUser(Double value) {
		ArrayList<Product> productListAux = new ArrayList<>();
		for (Product product : productList) {
			if (product.getValue() == value) {
				productListAux.add(product);
			}
		}
		return productListAux;
	}
	
	public static String getDate() {
		Calendar dataDate = new GregorianCalendar();
		dataDate.set(dataDate.get(Calendar.YEAR), dataDate.get(Calendar.MONTH), dataDate.get(Calendar.DAY_OF_MONTH),
				dataDate.get(Calendar.HOUR_OF_DAY), dataDate.get(Calendar.MINUTE), dataDate.get(Calendar.SECOND));
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");  
		 String date = sdf.format(dataDate.getTime());  
		 return date;
		}
}