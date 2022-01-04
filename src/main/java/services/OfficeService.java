package services;

import java.util.Collection;

import javax.persistence.Query;

import entidades.Offices;

public class OfficeService extends BasicService {
	 public  static Offices findById(int offId) throws Exception{
	        Offices office = null;

	        try{
	            transaction.begin();
	            office = em.find(Offices.class, offId);
	            transaction.commit();
	        }catch(Exception e){
	            transaction.rollback();
	            throw e;
	        }

	        return office;
	    }
	 
	    public static void insert(Offices  office) throws Exception{
	        try{
	            transaction.begin();
	            em.persist(office);
	            transaction.commit();
	        }catch (Exception ex){
	           transaction.rollback();
	           throw ex;
	        }
	    }
	    
	    public static void update(Offices office) throws Exception {
	    	Offices officeToUpdate = findById(office.getOffice());
	    	
	    	try {
	    		transaction.begin();
	    		officeToUpdate.setCity(office.getCity());
	    		officeToUpdate.setMgr(office.getMgr());
	    		officeToUpdate.setRegion(office.getRegion());
	    		officeToUpdate.setSales(office.getSales());
	    		officeToUpdate.setTarget(office.getTarget());
	    		transaction.commit();
	    	}catch(Exception ex) {
	    		transaction.rollback();
	    		throw ex;
	    	}
	    }
	    
	    public static void removeData(Offices office) throws Exception {
	    	try {
	    		transaction.begin();
	    		em.remove(office);
	    		transaction.commit();
	    	}catch(Exception ex) {
	    		transaction.rollback();
	    		throw ex;
	    	}
	    }
	    
	    public static Collection<Offices> listAll(){
            Query query = em.createQuery("SELECT a FROM Office a");
            return (Collection<Offices>) query.getResultList();
        }
}
