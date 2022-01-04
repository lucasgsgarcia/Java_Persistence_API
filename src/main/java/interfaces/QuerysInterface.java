package interfaces;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import entidades.Offices;
import entidades.Salesreps;
import services.QuerysService;

public class QuerysInterface {
	public static void ex08() throws Exception {
		List<Date> lista = QuerysService.olderDate();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		for(Date d : lista) {
			String prettierDate = formatter.format(d);
			JOptionPane.showMessageDialog(null, prettierDate);
		}
	}
	
	public static void ex02() throws Exception {
		List<Offices> offices = QuerysService.allOfficess();
		String data = "";
		
		for(Offices o : offices) {
			data += o.getOffice()+ " - "+o.getCity() +"\n";
		}
		
		JOptionPane.showMessageDialog(null, data);
	}
	
	public static void ex06() throws Exception {
		List<Object[]> list = QuerysService.salesrepsBelowQuota();
		String data = "";
		
		for(Object[] nomes : list) {
			data += nomes[0] + " - " + nomes[1] + "\n";
		}
		
		JOptionPane.showMessageDialog(null, data);
	}
	
	public static void ex05() throws Exception {
		List<Object[]> list = QuerysService.totalQuotaAndSales();
		String data = "";
		
		for(Object[] nomes : list) {
			data += nomes[0] + " - " + nomes[1] + " - " + nomes[2] + "\n";
		}
		
		JOptionPane.showMessageDialog(null, data);
	}
	
	public static void ex09() throws Exception {
		List<Object[]> list = QuerysService.salesmanAboveQuota();
		String data = "";
		
		JOptionPane.showMessageDialog(null, list.size());
	}
	
	public static void ex03() throws Exception {
		List<Object[]> list = QuerysService.OfficessObjectivesAndSales();
		String data = "";
		
		for(Object[] nomes : list) {
			data += nomes[0] + " - " + nomes[1] + " - " + nomes[2] + "\n";
		}
		
		JOptionPane.showMessageDialog(null, data);
	}
	
	public static void ex04() throws Exception {
		List<Object[]> list = QuerysService.nameOfficesHireDate();
		String data = "";
		
		for(Object[] nomes : list) {
			data += nomes[0] + " - " + nomes[1] + " - " + nomes[2] + "\n";
		}
		
		JOptionPane.showMessageDialog(null, data);
	}
	
	public static void ex10() throws Exception {
		List<String> list = QuerysService.customersFromBill();
		String data = "";
		
		for(String s : list) {
			data += s +"\n";
		}
		
		JOptionPane.showMessageDialog(null, data);
	}
	
	public static void ex11() throws Exception {
		List<String> list = QuerysService.productCodeACI();
		String data = "";
		
		for(String s : list) {
			data += s +"\n";
		}
		
		JOptionPane.showMessageDialog(null, data);
	}
	
	public static void ex14() throws Exception {
		List<Object[]> list = QuerysService.ordersAndPrices();
		String data = "";
		
		for(Object[] s : list) {
			data += s[0] + " - " + s[1] + " - " + s[2]  +"\n";
		}
		
		
		JOptionPane.showMessageDialog(null, data);
	}
	
	public static void ex12() throws Exception {
		List<Object[]> list = QuerysService.OfficessFromSalesman();
		String data = "";
		
		for(Object[] s : list) {
			data += s[0] + " - " + s[1] + " - " + s[0] +  "\n";
		}
		
		
		JOptionPane.showMessageDialog(null, data);
	}
	
	public static void ex13() throws Exception {
		List<Object[]> list = QuerysService.OfficessAndMgr();
		String data = "";
		
		for(Object[] s : list) {
			data += s[0] + " - " + s[1] + " - " + s[0] +  "\n";
		}
		
		
		JOptionPane.showMessageDialog(null, data);
	}
	
	public static void ex15() throws Exception {
		List<Object[]> list = QuerysService.ordersAboveAndSalesman();
		String data = "";
		
		for(Object[] s : list) {
			data += s[0] + " - " + s[1] + " - " + s[0] +  "\n";
		}
		
		
		JOptionPane.showMessageDialog(null, data);
	}
}
