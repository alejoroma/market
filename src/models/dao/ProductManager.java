package models.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import models.entity.Product;
import models.entity.StatusProduct;
import models.entity.TypePerson;
import models.entity.TypeProduct;

public class ProductManager {

	public ProductManager() {
	}
	
	public static Product createProduct(int id, String image, String name, int numberOfProduct, TypePerson typePerson, TypeProduct typeProduct,	String description, double value) {
		return new Product(id, image, name, numberOfProduct, typePerson, typeProduct, description, value);
	}
	
	public static ArrayList<Product> loadProducto() throws IOException, ParseException{
		JsonParser parser = new JsonParser();
		FileReader fr = new FileReader("src/data/products.json");
		JsonElement datos = parser.parse(fr);
		if (datos.isJsonNull()) {
			return new ArrayList<Product>();
		}else{
			JsonArray array = datos.getAsJsonArray();
			ArrayList<Product> listProductos = new ArrayList<>();
			java.util.Iterator<JsonElement> iter = array.iterator();
			Gson gson = new Gson();
			while (iter.hasNext()) {
				JsonElement entrada = iter.next();
				Product producto = new Product();
				producto = gson.fromJson(entrada, Product.class);
				listProductos.add(producto);
			}
			return listProductos;
		}	
	}
	
	public void addProduct(Product product) throws ParseException, IOException {
		ArrayList<Product> lista = loadProducto();
		lista.add(product);
		saveProducto(lista);
	}
	
	public void removeProduct(int id) throws ParseException, IOException {
		ArrayList<Product> productList = loadProducto();
		for (Product product : productList) {
			if (product.obtenerId() == id) {
				productList.remove(product);
				break;
			}
		}
		saveProducto(productList);
	}

	public static void saveProducto(ArrayList<Product> producto) throws IOException {
		FileWriter file = new FileWriter("src/data/products.json");
		Gson gson = new Gson();
		file.write(gson.toJson(producto, producto.getClass()));
		file.flush();
		file.close();
	}

	public Product obtenerProductSelecionado(int id) throws Exception {
		ArrayList<Product> productList = loadProducto();
		for (Product product : productList) {
			if (product.obtenerId() == id) {
				return product;
			}
		}
		throw new Exception("Ha ocurrido un error desconocido");
	}

	public static void editProduct(int id, Product product) throws ParseException, IOException {
		ArrayList<Product> productList = loadProducto();
		for (int i = 0; i < productList.size(); i++) {
			if(productList.get(i).obtenerId() == id){
				productList.remove(i);
				productList.add(i, product);
			}
		}
		saveProducto(productList);
	}	
		

	public ArrayList<Product> filterForTypeProduct(TypeProduct typeProduct) throws ParseException, IOException{
		ArrayList<Product> productList = loadProducto();
		for (int i = 0; i < productList.size(); i++) {
			if (!productList.get(i).getTypeProduct().equals(typeProduct)) {
				productList.remove(i);
			}
		}
		return productList;
	}
	
	public static String getDate() {
		Calendar dataDate = new GregorianCalendar();
		dataDate.set(dataDate.get(Calendar.YEAR), dataDate.get(Calendar.MONTH), dataDate.get(Calendar.DAY_OF_MONTH),
				dataDate.get(Calendar.HOUR_OF_DAY), dataDate.get(Calendar.MINUTE), dataDate.get(Calendar.SECOND));
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");  
		 String date = sdf.format(dataDate.getTime());  
		 return date;
		}
	
	public ArrayList<Product> getFilterUser(Double value) throws ParseException, IOException {
		ArrayList<Product> productList = loadProducto();
		for (int i = 0; i < productList.size(); i++) {
			if (!(productList.get(i).getValue() == value)) {
				productList.remove(i);
			}
		}
		return productList;
	}
	
	
	public  ArrayList<Product> paginaPrincipal() throws ParseException, IOException{
		ArrayList<Product> productList = loadProducto();
		for (int i = productList.size() -6 ; i >= 0; i--) {
				productList.remove(i);
		}
		return productList;
	}
	
	public ArrayList<Product> paginaFinal() throws ParseException, IOException {
		ArrayList<Product> productList = loadProducto();
		ArrayList<Product> salida = new ArrayList<Product>();
		if (totalProductosUltimaPaguina() != 0) {
			for (int i = 0 ; i < totalProductosUltimaPaguina() ; i++) {
				salida.add(productList.get(i));
			}
		} else {
			for (int i = 0 ; i < 5  ; i++) {
				salida.add(productList.get(i));
			}
		}
		return salida;
	}
	
	public ArrayList<Product> siguientePaguina(int paguinaActual) throws ParseException, IOException {
		ArrayList<Product> productList = loadProducto();
		ArrayList<Product> salida = new ArrayList<Product>();
		if ((paguinaActual * 5 ) < productList.size()  ) {
			for (int i = productList.size() - (( paguinaActual * 5 )  + 1)  ; i >=  productList.size() - (( paguinaActual - 1 ) * 5) ; i--) {
				salida.add(productList.get(i));
			}
		} else {
			for (int i = 0 ; i < 5  ; i++) {
				salida.add(productList.get(i));
			}
		}
		return salida;
	}
	
	public int totalPaguinasCompletas() throws ParseException, IOException{
		return (loadProducto().size() + 1 ) / 5;
	}
	
	public int totalProductosUltimaPaguina() throws ParseException, IOException{
		return (loadProducto().size() + 1 ) % 5;
	}
	
	public int totalPaguinas() throws ParseException, IOException{
		return (totalProductosUltimaPaguina() == 0 )? totalPaguinasCompletas() : totalPaguinasCompletas() + 1 ;
	}

	public ArrayList<Product> obtenerProdutosDisponible() throws IOException, ParseException {
		ArrayList<Product> productList = loadProducto();
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).getStatusProduct().equals(StatusProduct.NO_DISPONIBLE)) {
					productList.remove(i);
				}
			}
		return productList;
	}
	
	
}