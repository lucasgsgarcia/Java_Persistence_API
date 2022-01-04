package services;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import entidades.Offices;
import entidades.Salesreps;

public class QuerysService extends BasicService {
	public static List<Date> olderDate() throws Exception {
		List<Date> orders = null;
		
		try {
		transaction.begin();	
			
		String consulta =  "SELECT min(e.order_date) FROM Orders e";

		Query query = em.createQuery(consulta);

		orders = query.getResultList();
		
		transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
            throw ex;
		}
		return orders;

	}
	
	public static List<Offices> allOfficess() throws Exception {
		List<Offices> Officess = null;
		
		try {
			transaction.begin();
			
			String consulta = "Select e FROM Offices e ";

			Query query = em.createQuery(consulta);
			
			Officess = query.getResultList();
			
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			throw ex;
		}
		
		return Officess;
	}
	
	public static List<Object[]> salesrepsBelowQuota() throws Exception{
		List<Object[]> list = null;
		
		try {
			transaction.begin();
			list = em.createNamedQuery("Salesreps.findVendedoresAbaixoQuota").getResultList();
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			throw ex;
		}
		
		return list;
	}
	
	public static List<Object[]> totalQuotaAndSales() throws Exception{
		List<Object[]> list = null;
		
		try {
			transaction.begin();
			list = em.createNamedQuery("Salesreps.findCotasVendastodosVendededores").getResultList();
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			throw ex;
		}
		
		return list;
	}
	
	public static List<Object[]> salesmanAboveQuota() throws Exception{
		List<Object[]> list = null;
		
		try {
			transaction.begin();
			list = em.createNamedQuery("Salesreps.findQtdVendedoresAcimaQuota").getResultList();
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			throw ex;
		}
		
		return list;
	}
	
	public static List<Object[]> OfficessObjectivesAndSales() throws Exception{
		List<Object[]> list = null;
		
		try {
			transaction.begin();
			list = em.createNamedQuery("Offices.findEscritoriosObjetivosVendas").getResultList();
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			throw ex;
		}
		
		return list;
	}
	
	public static List<Object[]> nameOfficesHireDate() throws Exception{
		List<Object[]> list = null;
		
		try {
			transaction.begin();
			list = em.createNamedQuery("Salesreps.findNomeEscritorioContratacao").getResultList();
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			throw ex;
		}
		
		return list;
	}
	
	public static List<String> customersFromBill() throws Exception {
		List<String> list = null;
		
		try {
			transaction.begin();
			
			String consulta = "SELECT e.company FROM Customers e where e.cust_rep = (select e.empl_num from Salesreps e where e.name LIKE '%Bill Adams%')";

			Query query = em.createQuery(consulta);
			
			list = query.getResultList();
			
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			throw ex;
		}
		
		return list;
	}
	
	public static List<String> productCodeACI() throws Exception {
		List<String> list = null;
		
		try {
			transaction.begin();
			
			String consulta = "SELECT e.product_id from Products e WHERE e.mfr_id = 'ACI' AND e.qty_on_hand > (SELECT e.qty_on_hand from Products e where e.mfr_id = 'ACI' AND e.product_id = '41004')";

			Query query = em.createQuery(consulta);
			
			list = query.getResultList();
			
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			throw ex;
		}
		
		return list;
	}
	
	public static List<Object[]> ordersAndPrices() throws Exception {
		List<Object[]> list = null;
		
		try {
			transaction.begin();
			
//			String consulta = "SELECT s.name FROM Offices o JOIN Salesreps s ON s.rep_Offices = o.Offices";
			String consulta = "SELECT o.order_num, p.description, p.price FROM Orders o, Products p";

			Query query = em.createQuery(consulta);
			
			list = query.getResultList();
			
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			throw ex;
		}
		
		return list;
	}
	
	public static List<Object[]> OfficessFromSalesman() throws Exception {
		List<Object[]> list = null;
		
		try {
			transaction.begin();
			
			

			list = em.createQuery("select p.name, e.city, e.region from Offices e join Salesreps p ON p.rep_Offices = e.Offices").getResultList();
			
			
			
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			throw ex;
		}
		
		return list;
	}
	
	public static List<Object[]> OfficessAndMgr() throws Exception {
		List<Object[]> list = null;
		
		try {
			transaction.begin();
			
			list = em.createQuery("select e.Offices, p from Officess e join Salesreps p ON p.rep_Offices = e.Offices WHERE e.target > 600000").getResultList();
				
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			throw ex;
		}
		
		return list;
	}
	
	public static List<Object[]> ordersAboveAndSalesman() throws Exception {
		List<Object[]> list = null;
		
		try {
			transaction.begin();
			
			list = em.createQuery("SELECT p.name, c.company FROM Salesreps p JOIN Orders o ON o.rep = p.empl_num JOIN Customers c ON o.cust = c.cust_num WHERE o.amount > 25000").getResultList();
				
			transaction.commit();
		}catch(Exception ex) {
			transaction.rollback();
			throw ex;
		}
		
		return list;
	}
}
