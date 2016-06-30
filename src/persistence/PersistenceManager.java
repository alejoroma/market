package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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

	public static void saveProduct(ArrayList<Product> product) throws Exception {
		Gson gson = new Gson();
		JsonArray datatList = new JsonArray();
		JsonObject objProducts = new JsonObject();
		objProducts.add("Products", gson.toJsonTree(product));
		datatList.add(objProducts);
		FileWriter fileWriter = new FileWriter(new File("src/data/products.json"));
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(datatList.toString());
		bufferedWriter.close();
	}

	public static ArrayList<Product> loadProduct() throws IOException {
		ArrayList<Product> productList = new ArrayList<>();
		FileReader fileReader = new FileReader(new File("src/data/products.json"));
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
			JsonArray listP = jsonElement.getAsJsonObject().get("Products").getAsJsonArray();
			for (JsonElement jsonElement2 : listP) {
			int id = jsonElement2.getAsJsonObject().get("id").getAsInt();
			String image =  jsonElement2.getAsJsonObject().get("image").getAsString();
			String  name =  jsonElement2.getAsJsonObject().get("name").getAsString(); 
			int	numberOfProduct =  jsonElement2.getAsJsonObject().get("numberOfProduct").getAsInt();
			TypePerson typePerson =  TypePerson.valueOf(jsonElement2.getAsJsonObject().get("typePerson").getAsString());
			TypeProduct	typeProduct =  TypeProduct.valueOf(jsonElement2.getAsJsonObject().get("typeProduct").getAsString());
			String description =  jsonElement2.getAsJsonObject().get("description").getAsString();
			double value =  jsonElement2.getAsJsonObject().get("value").getAsDouble();
			productList.add(new Product(id, image, name, numberOfProduct, typePerson, typeProduct, description, value));
			}
		}
		}
		return productList;
	}

	public static void main(String[] args) throws Exception {
		ArrayList<Product> a = new ArrayList<>();
		a.add(new Product(0,"", "d", 2, TypePerson.MEN, TypeProduct.FOOTWEAR, "ds", 34));
		a.add(new Product(0, "", "d", 2, TypePerson.MEN, TypeProduct.FOOTWEAR, "ds", 34));
		a.add(new Product(0, "", "d", 2, TypePerson.MEN, TypeProduct.FOOTWEAR, "ds", 34));
		ArrayList<Product> b = new ArrayList<>();
		try {
 			PersistenceManager.saveProduct(a);
 			b.addAll(PersistenceManager.loadProduct());
 			System.out.println(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}