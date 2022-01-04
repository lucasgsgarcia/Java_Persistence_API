package services;

import java.util.Collection;

import javax.persistence.Query;

import entidades.Salesreps;

public class SalesrepsService extends BasicService {
	 public  static Salesreps findById(int repsId) throws Exception{
	        Salesreps reps = null;

	        try{
	            transaction.begin();
	            reps = em.find(Salesreps.class, repsId);
	            transaction.commit();
	        }catch(Exception e){
	            transaction.rollback();
	            throw e;
	        }

	        return reps;
	    }
	 
	 public static void insert(Salesreps  salesman) throws Exception{
	        try{
	            transaction.begin();
	            em.persist(salesman);
	            transaction.commit();
	        }catch (Exception ex){
	           transaction.rollback();
	           throw ex;
	        }
	    }
	 
	 public static void update(Salesreps salesman) throws Exception {
	    	Salesreps salesmanToUpdate = findById(salesman.getEmpl_num());
	    	
	    	try {
	    		transaction.begin();
	    		salesmanToUpdate.setName(salesman.getName());
	    		salesmanToUpdate.setAge(salesman.getAge());
	    		salesmanToUpdate.setRep_office(salesman.getRep_office());
	    		salesmanToUpdate.setTitle(salesman.getTitle());
	    		salesmanToUpdate.setHire_date(salesman.getHire_date());
	    		salesmanToUpdate.setManager(salesman.getManager());
	    		salesmanToUpdate.setQuota(salesman.getQuota());
	    		salesmanToUpdate.setSales(salesman.getSales());
	    		transaction.commit();
	    	}catch(Exception ex) {
	    		transaction.rollback();
	    		throw ex;
	    	}
	    }
	 
	 public static void removeData(Salesreps salesman) throws Exception {
	    	try {
	    		transaction.begin();
	    		em.remove(salesman);
	    		transaction.commit();
	    	}catch(Exception ex) {
	    		transaction.rollback();
	    		throw ex;
	    	}
	    }
	 
	 public static Collection<Salesreps> listAll(){
         Query query = em.createQuery("SELECT a FROM Salesreps a");
         return (Collection<Salesreps>) query.getResultList();
     }
}
