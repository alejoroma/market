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


	public Product() {
	}

	public Product(int id, String image, String name, int numberOfProduct, TypePerson typePerson, TypeProduct typeProduct,
			String description, double value) {
		this.id = id;
		this.image = image;
		this.name = name;
		this.numberOfProduct = numberOfProduct;
		this.typePerson = typePerson;
		this.typeProduct = typeProduct;
		this.description = description;
		this.value = value;
	}

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfProduct() {
		return numberOfProduct;
	}

	public TypePerson getTypePerson() {
		return typePerson;
	}

	public TypeProduct getTypeProduct() {
		return typeProduct;
	}

	public String getDescription() {
		return description;
	}

	public double getValue() {
		return value;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfProduct(int numberOfProduct) {
		this.numberOfProduct = numberOfProduct;
	}

	public void setTypePerson(TypePerson typePerson) {
		this.typePerson = typePerson;
	}

	public void setTypeProduct(TypeProduct typeProduct) {
		this.typeProduct = typeProduct;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object[] getAdminProduct(Object actions) {
		Object[] product = {id, name, typePerson, typeProduct, value, actions};
		return product;
	}

	public Object[] getUserProduct(Object image, Object actions) {
		Object[] product = {image, name, numberOfProduct, typePerson, typeProduct, description, value, actions};
		return product;
	}

	public int getId() {
		return this.id;

	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", image=" + image + ", name=" + name + ", numberOfProduct=" + numberOfProduct
				+ ", typePerson=" + typePerson + ", typeProduct=" + typeProduct + ", description=" + description
				+ ", value=" + value + "]";
	}
}