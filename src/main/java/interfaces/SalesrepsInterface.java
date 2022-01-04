package interfaces;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.swing.JOptionPane;

import entidades.Offices;
import entidades.Salesreps;
import services.OfficeService;
import services.SalesrepsService;

public class SalesrepsInterface {
	public static void insertNewSalesman() throws Exception{
		int empl_num = Integer.parseInt(JOptionPane.showInputDialog("Input the employee code: "));
		String name = JOptionPane.showInputDialog("Input the employee name: ");
		int age = Integer.parseInt(JOptionPane.showInputDialog("Input employee age: "));
		
		int officeCode = Integer.parseInt(JOptionPane.showInputDialog("Input the code of the office: "));
		Offices office = OfficeService.findById(officeCode);
		
		String title = JOptionPane.showInputDialog("Input the title of the employee: ");
		
		String hireDateString = JOptionPane.showInputDialog("Input the hire date of the employee: ");
		Date hireDate = new SimpleDateFormat("dd/MM/yyyy").parse(hireDateString);
		
		int managerCode = Integer.parseInt(JOptionPane.showInputDialog("Input manager code: "));
		Salesreps manager = SalesrepsService.findById(managerCode);
		
		double quota = Double.parseDouble(JOptionPane.showInputDialog("Input employee quota: "));
		double sales = Double.parseDouble(JOptionPane.showInputDialog("Input employee sales: "));
		
        Salesreps salesman = new Salesreps(empl_num, name, age, office, title, hireDate, manager, quota, sales);

        JOptionPane.showMessageDialog(null, "Inserting....");

        SalesrepsService.insert(salesman);
    }
	
	public static void updateSalesman() throws Exception{
		int empl_num = Integer.parseInt(JOptionPane.showInputDialog("Input the employee code to update: \n" + listAllData()));
		String name = JOptionPane.showInputDialog("Input the employee name: ");
		int age = Integer.parseInt(JOptionPane.showInputDialog("Input employee age: "));
		
		int officeCode = Integer.parseInt(JOptionPane.showInputDialog("Input the code of the office: "));
		Offices office = OfficeService.findById(officeCode);
		
		String title = JOptionPane.showInputDialog("Input the title of the employee: ");
		
		String hireDateString = JOptionPane.showInputDialog("Input the hire date of the employee: ");
		Date hireDate = new SimpleDateFormat("dd/MM/yyyy").parse(hireDateString);
		
		int managerCode = Integer.parseInt(JOptionPane.showInputDialog("Input manager code: "));
		Salesreps manager = SalesrepsService.findById(managerCode);
		
		double quota = Double.parseDouble(JOptionPane.showInputDialog("Input employee quota: "));
		double sales = Double.parseDouble(JOptionPane.showInputDialog("Input employee sales: "));
		
        Salesreps salesman = new Salesreps(empl_num, name, age, office, title, hireDate, manager, quota, sales);

        JOptionPane.showMessageDialog(null, "Inserting....");

        SalesrepsService.update(salesman);
    }
	
    public static void removeSalesman() throws Exception {
    	int salesman = Integer.parseInt(JOptionPane.showInputDialog("Input salesman code to remove:"));
    	
    	Salesreps salesmanObj = SalesrepsService.findById(salesman);
    	
    	JOptionPane.showMessageDialog(null, "Removing....");
    	
    	SalesrepsService.removeData(salesmanObj);
    }
    

    public static Salesreps listData() throws Exception{
        int salesmanId = Integer.parseInt(JOptionPane.showInputDialog("Salesman id: "));

        Salesreps salesman = SalesrepsService.findById(salesmanId);

        return salesman;
    }
    
    public static String listAllData(){
        String data = "Salesreps: \n";
        Collection<Salesreps> list = SalesrepsService.listAll();
        for (Salesreps sr : list) {
            data += sr.getEmpl_num() + " " + sr.getName() + " " + sr.getAge() + " Office:" + sr.getRep_office().getOffice() + " " + sr.getTitle() +
                    " " + sr.getHire_date().toString() + " Manager:" + sr.getManager().getEmpl_num() + " " + sr.getQuota() +  " " + sr.getSales() + "\n";
        }
        return data;
    }
}
