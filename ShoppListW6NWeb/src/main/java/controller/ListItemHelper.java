/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Jan 22, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

/**
 * @author sunga
 *
 */
public class ListItemHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("ShoppingList");

	public void insertItem(ListItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListItem> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<ListItem> allItems = em.createQuery(
				"SELECT i FROM ListItem i").getResultList();
		return allItems;
	}
	
	public void deleteItem(ListItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem>typedQuery = em.createQuery(
				"select li from ListItem li where li.store = :selectedStore and li.item = :selectedItem", ListItem.class);
		
		//substitute parameter with actual data from toDelete
		typedQuery.setParameter("selectedStore", toDelete.getStore());
		typedQuery.setParameter("selectedItem", toDelete.getItem());
		
		// limit to one result
		typedQuery.setMaxResults(1);
		
		//get the result, save to new list item
		ListItem result = typedQuery.getSingleResult();
		
		//remove result
		em.remove(result);
		em.getTransaction().commit(); // commit and close
		em.close();
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public ListItem searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateItem(ListItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * @param storeName
	 * @return
	 */
	public List<ListItem> searchforItemByStore(String storeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem>typedQuery = em.createQuery(
				"select li from ListItem li where li.store = :selectedStore", ListItem.class);
		typedQuery.setParameter("selectedStore", storeName);
		
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}

	/**
	 * @param itemName
	 * @return
	 */
	public List<ListItem> searchForItemByItem(String itemName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem>typedQuery = em.createQuery(
				"select li from ListItem li where li.store = :selectedStore", ListItem.class);
		typedQuery.setParameter("selectedItem", itemName);
		
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
	
}
