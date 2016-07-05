package models.entity;

public class Product {

	private int id;
	private String image;
	private String name;
	private int numberOfProduct;
	private TypePerson typePerson;
	private TypeProduct typeProduct;
	private String description;
	private double value;
	private StatusProduct statusProduct;
	
	public Product(int id, String image, String name, int numberOfProduct, TypePerson typePerson, TypeProduct typeProduct,String description, double value) {
		this.id = id;
		this.image = image;
		this.name = name;
		this.numberOfProduct = numberOfProduct;
		this.typePerson = typePerson;
		this.typeProduct = typeProduct;
		this.description = description;
		this.value = value;
		this.statusProduct = StatusProduct.DISPONIBLE;
	}

	public void viewStatusProduct() {
		if (numberOfProduct > 0) {
		numberOfProduct--;
		}
		changeStatus(numberOfProduct);
	}
	
	public void changeStatus(int numberOfProduct) {
		if (numberOfProduct == 0) {
			statusProduct = StatusProduct.NO_DISPONIBLE;
		}
	}
	
	public Product() {
	}

	public double getValue() {
		return value;
	}

	public TypeProduct getTypeProduct() {
		return typeProduct;
	}

	public Object[] getAdminProduct(Object actions) {
		Object[] product = {id, name, typePerson, typeProduct, value, actions};
		return product;
	}
	
	public Object[] getDetallesProduct() {
		Object[] product = {id, image, name,numberOfProduct ,typePerson, typeProduct,description, value};
		return product;
	}

	public Object[] getUserProduct(Object image, Object actions) {
		Object[] product = {image, name, numberOfProduct, typePerson, typeProduct, description, value, actions};
		return product;
	}
	public String obtenerImagen() {
		return image;
	}
	
	public int obtenerId() {
		return id;
	}

	public TypePerson getTypePerson() {
		return typePerson;
	}
}