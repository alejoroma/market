package models.entity;

public class Product {

	private int id;
	private String name;
	private String brand;
	private TypeCategory typeCategory;
	private double price;
	private String description;
	private StatusProduct statusProduct;
	private int quantity;
	
	public Product(int id, String name, String brand,TypeCategory typeCategory, double price, String description,
			StatusProduct statusProduct, int quantity) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.typeCategory = typeCategory;
		this.price = price;
		this.description = description;
		this.statusProduct = statusProduct;
		this.quantity = quantity;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Object[] getProduct(){
		Object[] object = {id, name, brand, typeCategory, price, description, statusProduct, quantity}; 
		return object;
	}
	
	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}
	

	public int getId() {
		return id;
	}

	public TypeCategory getTypeCategory() {
		return typeCategory;
	}

	public StatusProduct getStatusProduct() {
		return statusProduct;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setTypeCategory(TypeCategory typeCategory) {
		this.typeCategory = typeCategory;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatusProduct(StatusProduct statusProduct) {
		this.statusProduct = statusProduct;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand
				+ ", typeCategory=" + typeCategory + ", price=" + price
				+ ", description=" + description + ", stateProduct="
				+ statusProduct + ", quantity=" + quantity + "]";
	}
}