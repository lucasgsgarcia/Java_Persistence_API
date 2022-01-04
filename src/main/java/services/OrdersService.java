package services;

import java.util.Collection;

import javax.persistence.Query;

import entidades.Offices;
import entidades.Orders;

public class OrdersService extends BasicService {
	 public  static Orders findById(int orderId) throws Exception{
	        Orders order = null;

	        try{
	            transaction.begin();
	            order = em.find(Orders.class, orderId);
	            transaction.commit();
	        }catch(Exception e){
	            transaction.rollback();
	            throw e;
	        }

	        return order;
	    }
	
    public static void insert(Orders  order) throws Exception{
        try{
            transaction.begin();
            em.persist(order);
            transaction.commit();
        }catch (Exception ex){
           transaction.rollback();
           throw ex;
        }
    }
    
    public static void update(Orders order) throws Exception {
    	Orders orderToUpdate = findById(order.getOrder_num());
    	
    	try {
    		transaction.begin();
    		orderToUpdate.setAmount(order.getAmount());
    		orderToUpdate.setCust(order.getCust());
    		orderToUpdate.setOrder_date(order.getOrder_date());
    		orderToUpdate.setProduct(order.getProduct());
    		orderToUpdate.setQty(order.getQty());
    		orderToUpdate.setRep(order.getRep());
    		transaction.commit();
    	}catch(Exception ex) {
    		transaction.rollback();
    		throw ex;
    	}
    }
    
    public static void removeData(Orders order) throws Exception {
    	try {
    		transaction.begin();
    		em.remove(order);
    		transaction.commit();
    	}catch(Exception ex) {
    		transaction.rollback();
    		throw ex;
    	}
    }
    
    public static Collection<Orders> listAll(){
        Query query = em.createQuery("SELECT a FROM Orders a");
        return (Collection<Orders>) query.getResultList();
    }
}
