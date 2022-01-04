package interfaces;

import java.util.Collection;

import javax.swing.JOptionPane;

import entidades.Customers;
import entidades.Salesreps;
import services.CustomersService;
import services.SalesrepsService;

public class CustomerInterface {
	public static void insertNewCustomer() throws Exception{
		int cust_num = Integer.parseInt(JOptionPane.showInputDialog("Input customer number: "));
		String company = JOptionPane.showInputDialog("Input customer company's name: ");
		
		
		int repCode = Integer.parseInt(JOptionPane.showInputDialog("Input customers sales rep code: "));
		Salesreps cust_rep = SalesrepsService.findById(repCode);
		
		double credit_limit = Double.parseDouble(JOptionPane.showInputDialog("Input customers credit limit: "));

		Customers customer = new Customers(cust_num, cust_rep, company, credit_limit);
		
        JOptionPane.showMessageDialog(null, "Inserting....");

        CustomersService.insert(customer);
    }
	
	public static void updateCustomer() throws Exception{
		int cust_num = Integer.parseInt(JOptionPane.showInputDialog("Input customer number to update: \n" + listAllData()));
		String company = JOptionPane.showInputDialog("Input customer company's name: ");
		
		
		int repCode = Integer.parseInt(JOptionPane.showInputDialog("Input customers sales rep code: "));
		Salesreps cust_rep = SalesrepsService.findById(repCode);
		
		double credit_limit = Double.parseDouble(JOptionPane.showInputDialog("Input customers credit limit: "));

		Customers customer = new Customers(cust_num, cust_rep, company, credit_limit);
		
        JOptionPane.showMessageDialog(null, "Inserting....");

        CustomersService.update(customer);
    }
	
	  public static void removeCustomer() throws Exception {
	    	int customer = Integer.parseInt(JOptionPane.showInputDialog("Input customer code to remove:"));
	    	
	    	Customers customerObj = CustomersService.findById(customer);
	    	
	    	JOptionPane.showMessageDialog(null, "Removing....");
	    	
	    	CustomersService.removeData(customerObj);
	    }
	  
	  public static Customers listData() throws Exception{
	        int customerId = Integer.parseInt(JOptionPane.showInputDialog("Customers id: "));

	        Customers customer = CustomersService.findById(customerId);

	        return customer;
	    }
	  
	  public static String listAllData(){
          String data = "Customers: \n";
          Collection<Customers> list = CustomersService.listAll();
          for (Customers cm : list) {
              data += cm.getCust_num() + " " + cm.getCust_rep() + " " + cm.getCompany() + " " + cm.getCredit_limit();
          }
          return data;
      }
}
