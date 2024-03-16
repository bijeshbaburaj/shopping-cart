package com.jsp.shoppingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart.dto.Orders;

@Repository
public class OrderDao {

	@Autowired
	EntityManagerFactory emf;
	
	public void saveOrders(Orders orders) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(orders);
		et.commit();
	}
	
	public void updateOrders(Orders orders) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		
		et.begin();
		em.merge(orders);
		et.commit();
	}
	
	public void deleteOrdersById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		
		Orders orders = em.find(Orders.class, id);
		
		if (orders != null) {
			et.begin();
			em.remove(orders);
			et.commit();
		}
	}
	
	public Orders findOrdersById(int id) {
		EntityManager em = emf.createEntityManager();
		
		Orders orders = em.find(Orders.class, id);
		
		if (orders!=null) {
			return orders;
		} else {
			return null;
		}
	}
	
}
