package interfaces;

import entidades.ProductID;
import entidades.Products;

import java.util.Collection;

import javax.swing.*;
import services.ProductService;

public class ProductsInterface {
	public static void insertNewProduct() throws Exception{
    	String mfr_id = JOptionPane.showInputDialog("Input MFR: ");
        String product_id = JOptionPane.showInputDialog("Input Product ID: ");
        String description = JOptionPane.showInputDialog("Input the description: ");
        Double price = Double.parseDouble(JOptionPane.showInputDialog("Input the price: "));
        int qty_on_hand =  Integer.parseInt(JOptionPane.showInputDialog("Input the quantity of products: "));
        
        Products productObj = new Products(mfr_id, product_id, description, price, qty_on_hand);

        JOptionPane.showMessageDialog(null, "Inserting....");	

        ProductService.insert(productObj);
    }



    public static Products listData() throws Exception{
        String mfr_id = JOptionPane.showInputDialog("Mfr_Id: ");

        String product_id = JOptionPane.showInputDialog("Product ID: ");

        ProductID pid = new ProductID(mfr_id, product_id);

        Products product = ProductService.findById(pid);

        return product;
    }
    
    public static void updateProduct() throws Exception {
    	String mfr_id = JOptionPane.showInputDialog("Input MFR to update: \n" + listAllData());
        String product_id = JOptionPane.showInputDialog("Input Product ID to update: ");
        String description = JOptionPane.showInputDialog("Input the description: ");
        Double price = Double.parseDouble(JOptionPane.showInputDialog("Input the price: "));
        int qty_on_hand =  Integer.parseInt(JOptionPane.showInputDialog("Input the quantity of products: "));
        
        Products productObj = new Products(mfr_id, product_id, description, price, qty_on_hand);
    	
    	JOptionPane.showMessageDialog(null, "Changing....");
    	
    	ProductService.update(productObj);
    }
    
    public static void removeProduct() throws Exception {

    	Products productObj = ProductsInterface.listData();

    	JOptionPane.showMessageDialog(null, "Removing....");

    	ProductService.removeData(productObj);

    }
    
    public static String listAllData(){
        String data = "Products: \n";
        Collection<Products> list = ProductService.listAll();
        for (Products pdc : list) {
            data += pdc.getMfr_id() + " " + pdc.getProduct_id() + " " + pdc.getDescription() + " " + pdc.getPrice() + " " + pdc.getQty_on_had() + "\n";
        }
        return data;
    }	
}
