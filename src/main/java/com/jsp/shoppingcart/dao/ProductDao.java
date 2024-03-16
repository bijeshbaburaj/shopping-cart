package com.jsp.shoppingcart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart.dto.Product;

@Repository
public class ProductDao {

	@Autowired
	EntityManagerFactory emf;

	public void saveProduct(Product product) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(product);
		et.commit();
	}

	public void updateProduct(Product product) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(product);
		et.commit();
	}

	public void deleteProductById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product product = em.find(Product.class, id);

		et.begin();
		em.remove(product);
		et.commit();
	}

	public Product findProductById(int id) {
		EntityManager em = emf.createEntityManager();

		Product product = em.find(Product.class, id);

		if (product != null) {
			return product;
		} else {
			return null;
		}
	}

	public List<Product> findAllProduct() {
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select p from Product p");
		
		return query.getResultList();
	}
	
	public List<Product> findProductByBrand(String brand){
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p where p.brand=?1");
		query.setParameter(1, brand);
		return query.getResultList();
	}
	
	public List<Product> findProductByCategory(String category){
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p where p.category=?1");
		query.setParameter(1, category);
		return query.getResultList();
	}
	
	public List<Product> findProductByPriceRange(double stPrice, double endPrice){
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p where price between ?1 and ?2");
		query.setParameter(1, stPrice);
		query.setParameter(2, endPrice);
		return query.getResultList();
		
	}
}
