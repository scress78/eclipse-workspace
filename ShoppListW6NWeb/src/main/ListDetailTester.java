import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailHelper;
import controller.ShopperHelper;
import model.ListDetail;
import model.ListItem;
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
public class ListDetailTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shopper cameron = new Shopper("Cameron");
		//ShopperHelper sh = new ShopperHelper();
		//sh.insertShopper(cameron);
		
		ListDetailHelper ldh = new ListDetailHelper();
		
		ListItem shampoo = new ListItem("Target", "Shampoo");
		ListItem brush = new ListItem("Target", "Brush");
		
		List<ListItem> cameronsItems = new ArrayList<ListItem>();
		cameronsItems.add(shampoo);
		cameronsItems.add(brush);
		
		
		ListDetail cameronsList = new ListDetail("Cameron's List", LocalDate.now(), cameron);
		cameronsList.setListOfItems(cameronsItems);
		
		ldh.insertNewListDetails(cameronsList);
		
		List<ListDetail> allLists = ldh.getLists();
		for (ListDetail a : allLists) {
			System.out.println(a.toString());
		}
	}

}
