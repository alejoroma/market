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

	public void editProduct(Object[] listProductEdit) {
		System.out.println(listProductEdit[0]+ "v");
		this.id = (int)listProductEdit[0];
		this.image = (String)listProductEdit[1];
		this.name = (String)listProductEdit[2];
		this.numberOfProduct = (int)listProductEdit[3];
		this.typePerson = (TypePerson)listProductEdit[4];
		this.typeProduct = (TypeProduct)listProductEdit[5];
		this.description = (String)listProductEdit[6];
		this.value = (double)listProductEdit[7];
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
	
	public StatusProduct getStatusProduct() {
		return statusProduct;
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
}