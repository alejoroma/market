package run;

import controller.Controller;
import models.dao.ProductManager;
import models.entity.TypePerson;
import models.entity.TypeProduct;

public class Run {

	public static void main(String[] args) {
		new Controller();
		/*ProductManager pm = new ProductManager();
		pm.createProduct(1, null, "tenis0", 20, TypePerson.MEN, TypeProduct.CALZADO, "....", 30000);
		pm.createProduct(2, null, "tenis1", 20, TypePerson.MEN, TypeProduct.CALZADO, "....", 30000);
		pm.createProduct(3, null, "tenis2", 20, TypePerson.MEN, TypeProduct.CALZADO, "....", 30000);
		System.out.println(pm.getProductList());
		pm.editProduct(1, 100000);
		pm.deleteProduct(2);
		System.out.println(pm.getProductList());*/
	}
} 