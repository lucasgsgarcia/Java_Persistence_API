package services;

import java.util.Collection;

import javax.persistence.Query;

import entidades.ProductID;
import entidades.Products;

public class ProductService extends BasicService {
    public  static Products findById(ProductID pid) throws Exception{
        Products prod = null;

        try{
            transaction.begin();
            prod = em.find(Products.class, pid);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw e;
        }

        return prod;
    }

    public static void insert(Products prod) throws Exception{
        try{
            transaction.begin();
            em.persist(prod);
            transaction.commit();
        }catch (Exception ex){
           transaction.rollback();
           throw ex;
        }
    }
    
    public static void update(Products prod) throws Exception {
    	ProductID pid = new ProductID(prod.getMfr_id(), prod.getProduct_id());
    	Products prodToUpdate = findById(pid);
    	
    	try {
    		transaction.begin();
    		prodToUpdate.setMfr_id(prod.getMfr_id());
    		prodToUpdate.setDescription(prod.getDescription());
    		prodToUpdate.setPrice(prod.getPrice());
    		prodToUpdate.setQty_on_had(prod.getQty_on_had());
    		transaction.commit();
    	}catch(Exception ex) {
    		transaction.rollback();
    		throw ex;
    	}
    }
    
    public static void removeData(Products prod) throws Exception {
        try {
            transaction.begin();
            em.remove(prod);
            transaction.commit();
        }catch(Exception ex) {
            transaction.rollback();
            throw ex;
        }
    }
    
    public static Collection<Products> listAll(){
        Query query = em.createQuery("SELECT a FROM Products a");
        return (Collection<Products>) query.getResultList();
    }
}


