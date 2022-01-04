package interfaces;

import java.util.Collection;
import java.util.Date;

import javax.swing.JOptionPane;

import entidades.Customers;
import entidades.Offices;
import entidades.Orders;
import entidades.ProductID;
import entidades.Products;
import entidades.Salesreps;
import services.CustomersService;
import services.OfficeService;
import services.OrdersService;
import services.ProductService;
import services.SalesrepsService;

public class OrdersInterface {
	public static void insertNewOrder() throws Exception{
		int order_num = Integer.parseInt(JOptionPane.showInputDialog("Input order number: "));

		int custCode = Integer.parseInt(JOptionPane.showInputDialog("Input customer (code): "));
		Customers customer = CustomersService.findById(custCode);

		int repCode = Integer.parseInt(JOptionPane.showInputDialog("Input the rep of the order: "));
		Salesreps salesman = SalesrepsService.findById(repCode);

		Products p = ProductsInterface.listData();

		int qty = Integer.parseInt(JOptionPane.showInputDialog("Input the quantity"));
		int amount = Integer.parseInt(JOptionPane.showInputDialog("Input the amount"));


		Orders order = new Orders(order_num, new Date(), customer, salesman, p, qty, amount);

		JOptionPane.showMessageDialog(null, "Inserting....");

		OrdersService.insert(order);
	}

	public static void updateOrder() throws Exception {
		int order_num = Integer.parseInt(JOptionPane.showInputDialog("Input order number to update: \n" + listAllData()));

		int custCode = Integer.parseInt(JOptionPane.showInputDialog("Input customer (code): "));
		Customers customer = CustomersService.findById(custCode);

		int repCode = Integer.parseInt(JOptionPane.showInputDialog("Input the rep of the order: "));
		Salesreps salesman = SalesrepsService.findById(repCode);

		Products p = ProductsInterface.listData();

		int qty = Integer.parseInt(JOptionPane.showInputDialog("Input the quantity"));
		int amount = Integer.parseInt(JOptionPane.showInputDialog("Input the amount"));


		Orders order = new Orders(order_num, new Date(), customer, salesman, p, qty, amount);
		
		JOptionPane.showMessageDialog(null, "Updating....");
		
		OrdersService.update(order);
	}

	public static Orders listData() throws Exception{
        int orderCode = Integer.parseInt(JOptionPane.showInputDialog("Input order code: "));


        Orders order = OrdersService.findById(orderCode);

        return order;
    }
	
	 public static void removeOrder() throws Exception {
	    	int order = Integer.parseInt(JOptionPane.showInputDialog("Input order code to remove:"));
	    	
	    	Orders orderObj = OrdersService.findById(order);
	    	
	    	JOptionPane.showMessageDialog(null, "Removing....");
	    	
	    	OrdersService.removeData(orderObj);
	    }
	 
	 public static String listAllData(){
         String data = "Orders: \n";
         Collection<Orders> list = OrdersService.listAll();
         for (Orders ord : list) {
             data += ord.getOrder_num() + " " + ord.getOrder_date().toString() + " " + ord.getCust() + " " + ord.getRep() + " " + ord.getProduct() + " " + ord.getQty() + " " + ord.getAmount() + "\n";
         }
         return data;
 }
}
