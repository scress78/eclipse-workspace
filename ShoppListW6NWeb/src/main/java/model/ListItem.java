/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Jan 22, 2022
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class ListItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	private String store;
	private String item;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	
	public ListItem(int id, String store, String item) {
		super();
		this.id = id;
		this.store = store;
		this.item = item;
	}
	
	public ListItem(String store, String item) {
		super();
		this.store = store;
		this.item = item;
	}
	
	public ListItem() {
		super();
	}
	
	
	public String returnItemDetails() {
		return this.store + ":" + this.item;
		}
	
	
}
