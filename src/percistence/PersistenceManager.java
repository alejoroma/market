package percistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import models.entity.Product;
import models.entity.TypePerson;
import models.entity.TypeProduct;

public class PersistenceManager {

	private static final String FILE_DATA_PRODUCTS = "src/data/products.json";
	private static final String VALUE = "value";
	private static final String DESCRIPTION = "description";
	private static final String TYPE_PRODUCT = "typeProduct";
	private static final String TYPE_PERSON = "typePerson";
	private static final String NAME = "name";
	private static final String NUMBER_OF_PRODUCT = "numberOfProduct";
	private static final String IMAGE = "image";
	private static final String ID = "id";
	private static final String PRODUCTS = "Products";

	public static void saveProduct(ArrayList<Product> product) throws Exception {
		Gson gson = new Gson();
		JsonArray datatList = new JsonArray();
		JsonObject objProducts = new JsonObject();
		objProducts.add(PRODUCTS, gson.toJsonTree(product));
		datatList.add(objProducts);
		FileWriter fileWriter = new FileWriter(new File(FILE_DATA_PRODUCTS));
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(datatList.toString());
		bufferedWriter.close();
	}

	public static ArrayList<Product> loadProduct() throws IOException {
		ArrayList<Product> productList = new ArrayList<>();
		FileReader fileReader = new FileReader(new File(FILE_DATA_PRODUCTS));
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = "", result = "";
		while ((line = bufferedReader.readLine()) != null) {
			result  += line;
		}
		bufferedReader.close();
		Gson gson = new Gson();
		if (!result.equals("")) {
		JsonArray list = (JsonArray) gson.fromJson(result, JsonElement.class);
		for (JsonElement jsonElement : list) {
			JsonArray listP = jsonElement.getAsJsonObject().get(PRODUCTS).getAsJsonArray();
			for (JsonElement jsonElement2 : listP) {
			int id = jsonElement2.getAsJsonObject().get(ID).getAsInt();
			String image =  jsonElement2.getAsJsonObject().get(IMAGE).getAsString();
			String  name =  jsonElement2.getAsJsonObject().get(NAME).getAsString(); 
			int	numberOfProduct =  jsonElement2.getAsJsonObject().get(NUMBER_OF_PRODUCT).getAsInt();
			TypePerson typePerson =  TypePerson.valueOf(jsonElement2.getAsJsonObject().get(TYPE_PERSON).getAsString());
			TypeProduct	typeProduct =  TypeProduct.valueOf(jsonElement2.getAsJsonObject().get(TYPE_PRODUCT).getAsString());
			String description =  jsonElement2.getAsJsonObject().get(DESCRIPTION).getAsString();
			double value =  jsonElement2.getAsJsonObject().get(VALUE).getAsDouble();
			productList.add(new Product(id, image, name, numberOfProduct, typePerson, typeProduct, description, value));
			}
		}
		}
		return productList;
	}
}