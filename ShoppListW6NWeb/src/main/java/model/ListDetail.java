/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 17, 2022
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author sunga
 *
 */

@Entity
public class ListDetail {
	
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate tripDate;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Shopper shopper;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListItem> listOfItems;
	
	
	public ListDetail(int id, String listName, LocalDate tripDate, Shopper shopper, List<ListItem> listOfItems) {
			//omitted for space but set them in your code
	}
	
		
	public ListDetail(String listName, LocalDate tripDate, Shopper shopper, List<ListItem> listOfItems) {
	//omitted for space but set them in your code 
	}
	
	public ListDetail(String listName, LocalDate tripDate, Shopper shopper) {
	//omitted for space but set them in your code 
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
	}
	
	
	@Override
	public String toString() {
		return "ListDetail [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", shopper=" + shopper
				+ ", listOfItems=" + listOfItems + "]";
	}
	
	public ListDetail() {
		super();
	}
	
	/*
	public ListDetail(int id, String listName, LocalDate tripDate, Shopper shopper, List<ListItem> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
		this.listOfItems = listOfItems;
	}
	*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getTripDate() {
		return tripDate;
	}
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	public Shopper getShopper() {
		return shopper;
	}
	public void setShopper(Shopper shopper) {
		this.shopper = shopper;
	}
	public List<ListItem> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<ListItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

}
