/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 17, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.ListDetail;

/**
 * @author sunga
 *
 */
public class ListDetailHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ShoppingList");
	
	public void insertNewListDetails(ListDetail s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListDetail> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ListDetail> allDetails = em.createQuery("SELECT d FROM ListDetail d").getResultList();
		return allDetails;
	}
}


