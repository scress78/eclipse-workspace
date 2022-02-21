

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ListDetailHelper;
import controller.ListItemHelper;
import model.ListDetail;
import model.ListItem;
import model.Shopper;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/CreateNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ListItemHelper lih = new ListItemHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String shopperName =
		request.getParameter("shopperName");
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year),
			Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		String[] selectedItems =request.getParameterValues("allItemsToAdd");
		List<ListItem> selectedItemsInList = new ArrayList<ListItem>();
		
		//make sure something was selected – otherwise we get a nullpointer exception
		
		if (selectedItems != null && selectedItems.length > 0){
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ListItem c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
				}
		}
		
		Shopper shopper = new Shopper(shopperName);
		ListDetail sld = new ListDetail(listName, ld, shopper);
		sld.setListOfItems(selectedItemsInList);
		ListDetailHelper slh = new ListDetailHelper();
		slh.insertNewListDetails(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
