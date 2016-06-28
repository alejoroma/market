package models.dao;

import java.util.ArrayList;

import models.entity.Product;
import models.entity.TypePerson;
import models.entity.TypeProduct;

public class ProductManager {

	private static ArrayList<Product> producList;
	
	public ProductManager() {
		producList = new ArrayList<>();
	}
	
	public static Product createProduct(int id, String image, String name, int numberOfProduct, TypePerson typePerson, TypeProduct typeProduct,	String description, double value) {
		return  new Product(id, image, name, numberOfProduct, typePerson, typeProduct, description, value);
	}
	
	public void addProduct(Product product) {
		producList.add(product);
	}
	
	public ArrayList<Product> getProductList() {
		return producList;
	}
	
	public Product getProduct(int id) throws Exception {
		for (Product product : producList) {
			if (product.getId() == id) {
				return product;
			}
		}
		throw new Exception("Ha ocurrido un error desconocido");
	}
	
	public static void editProduct(int searchId, int id, String image, String name, int numberOfProduct, TypePerson typePerson, TypeProduct typeProduct,
			String description, double value) {
		System.out.println(id+ "·..");
		for (Product product : producList) {
			if (product.getId() == searchId) {
				product.setId(id);
				product.setImage(image);
				product.setValue(value);
				product.setNumberOfProduct(numberOfProduct);
				product.setTypePerson(typePerson);
				product.setTypeProduct(typeProduct);
				product.setDescription(description);
				product.setValue(value);
			}
		}
	}
	
	public void removeProduct(int id) {
		for (Product product : producList) {
			if (product.getId() == id) {
				producList.remove(product);
				break;
			}
		}
	}
	
	public ArrayList<Product> getFilterUser(Double value) {
		ArrayList<Product> productListAux = new ArrayList<>();
		for (Product product : producList) {
			if (product.getValue() == value) {
				productListAux.add(product);
			}
		}
		return productListAux;
	}
}