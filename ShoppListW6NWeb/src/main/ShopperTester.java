

import java.util.List;

import controller.ShopperHelper;
import model.Shopper;

/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 17, 2022
 */

/**
 * @author sunga
 *
 */
public class ShopperTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shopper bill = new Shopper("Bill");
		ShopperHelper sh = new ShopperHelper();
		sh.insertShopper(bill);
		
		List<Shopper> allShoppers = sh.showAllShoppers();
		for(Shopper a: allShoppers) {
			System.out.println(a.toString());
		}

	}

}
