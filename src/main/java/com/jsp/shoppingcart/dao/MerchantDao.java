package com.jsp.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart.dto.Merchant;
import com.jsp.shoppingcart.dto.Product;

@Repository
public class MerchantDao {

	@Autowired
	EntityManagerFactory emf;
	
	@Autowired
	ProductDao pdao;
	
	public void saveMerchant(Merchant merchant) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(merchant);
		et.commit();
	}
	
	public Merchant login(String email, String password) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		try {
			Merchant merchant = (Merchant) query.getSingleResult();
			return merchant;
		}catch (NoResultException e) {
			return null;
		}
	}
	
	public void updateMerchant(Merchant merchant) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		
		et.begin();
		em.merge(merchant);
		et.commit();
	}
	
	public void deleteMerchantById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		
		Merchant merchant = em.find(Merchant.class, id);
		
		if(merchant !=null) {
			et.begin();
			em.remove(merchant);
			et.commit();
		}
	}
	
	public Merchant findMerchantById(int id) {
		EntityManager em = emf.createEntityManager();
		
		Merchant merchant = em.find(Merchant.class, id);
		
		if (merchant!=null) {
			return merchant;
		} else {
			return null;
		}
	}
	
	public Merchant deleteProductFromMerchant( int merchant_id, int product_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		
		Merchant merchant = em.find(Merchant.class, merchant_id);
		List<Product> product = merchant.getProduct();
		
		List<Product> productlist = new ArrayList<Product>();
		
		for (Product p : product) {
			if (p.getId() != product_id) {
				productlist.add(p);
			}
		}
		merchant.setProduct(productlist);
		
		return merchant;
		
	}
}
