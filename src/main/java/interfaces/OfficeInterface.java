package interfaces;

import java.util.Collection;

import javax.swing.JOptionPane;

import entidades.Offices;
import entidades.Salesreps;
import services.OfficeService;
import services.SalesrepsService;

public class OfficeInterface {
	public static void insertNewOffice() throws Exception{
		int office = Integer.parseInt(JOptionPane.showInputDialog("Input office code:"));
        String city = JOptionPane.showInputDialog("Input office city: ");
        String region = JOptionPane.showInputDialog("Input office region: ");
        int mgrCode =  Integer.parseInt(JOptionPane.showInputDialog("Input office manager (code): "));
        
        Salesreps salesman = SalesrepsService.findById(mgrCode);
        
       
        double target = Double.parseDouble(JOptionPane.showInputDialog("Input office target: "));
        double sales = Double.parseDouble(JOptionPane.showInputDialog("Input office sales: "));
        Offices officeObj = new Offices(office, city, region, salesman, target, sales);

        JOptionPane.showMessageDialog(null, "Inserting....");

        OfficeService.insert(officeObj);
    }

    public static Offices listData() throws Exception{
        int officeId = Integer.parseInt(JOptionPane.showInputDialog("Office id: "));

        Offices office = OfficeService.findById(officeId);

        return office;
    }
    
    public static void updateOffice() throws Exception {
    	int office = Integer.parseInt(JOptionPane.showInputDialog("Input office code to change: \n" + listAllData()));

    	String city = JOptionPane.showInputDialog("Input office city: ");
    	String region = JOptionPane.showInputDialog("Input office region: ");
    	int mgrCode =  Integer.parseInt(JOptionPane.showInputDialog("Input office manager (code): "));

    	Salesreps salesman = SalesrepsService.findById(mgrCode);


    	double target = Double.parseDouble(JOptionPane.showInputDialog("Input office target: "));
    	double sales = Double.parseDouble(JOptionPane.showInputDialog("Input office sales: "));
    	Offices officeObj = new Offices(office, city, region, salesman, target, sales);
    	
    	JOptionPane.showMessageDialog(null, "Changing....");
    	
    	OfficeService.update(officeObj);
    }
    
    public static void removeOffice() throws Exception {
    	int office = Integer.parseInt(JOptionPane.showInputDialog("Input office code to remove:"));
    	
    	Offices officeObj = OfficeService.findById(office);
    	
    	JOptionPane.showMessageDialog(null, "Removing....");
    	
    	OfficeService.removeData(officeObj);
    }
    
    public static String listAllData(){
        String data = "Offices: \n";
        Collection<Offices> list = OfficeService.listAll();
        for (Offices of : list) {
            data += of.getOffice() + " " + of.getCity() + " " + of.getRegion() + " " + of.getMgr() + " " + of.getTarget() + " " + of.getSales() + "\n";
        }
        return data;
    }
}
