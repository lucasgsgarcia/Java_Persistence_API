package services;

import java.util.Collection;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import entidades.Customers;
import entidades.Salesreps;

public class CustomersService extends BasicService {
	 public  static Customers findById(int custId) throws Exception{
	        Customers customer = null;

	        try{
	            transaction.begin();
	            customer = em.find(Customers.class, custId);
	            transaction.commit();
	        }catch(Exception e){
	            transaction.rollback();
	            throw e;
	        }

	        return customer;
	    }
	 
	 public static void insert(Customers  customer) throws Exception{
	        try{
	            transaction.begin();
	            em.persist(customer);
	            transaction.commit();
	        }catch (Exception ex){
	           transaction.rollback();
	           throw ex;
	        }
	    }
	 
	 public static void update(Customers customer) throws Exception {
	    	Customers customerToUpdate = findById(customer.getCust_num());
	    	
	    	try {
	    		transaction.begin();
	    		customerToUpdate.setCompany(customer.getCompany());
	    		customerToUpdate.setCust_rep(customer.getCust_rep());
	    		customerToUpdate.setCredit_limit(customer.getCredit_limit());
	    		transaction.commit();
	    	}catch(Exception ex) {
	    		transaction.rollback();
	    		throw ex;
	    	}
	    }
	 
	 public static void removeData(Customers customer) throws Exception {
	    	try {
	    		transaction.begin();
	    		em.remove(customer);
	    		transaction.commit();
	    	}catch(Exception ex) {
	    		transaction.rollback();
	    		throw ex;
	    	}
	    }
	 
	 public static Collection<Customers> listAll(){
         Query query = em.createQuery("SELECT a FROM Customers a");
         return (Collection<Customers>) query.getResultList();
     }
}
