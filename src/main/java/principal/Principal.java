package principal;

import interfaces.CustomerInterface;
import interfaces.OfficeInterface;
import interfaces.OrdersInterface;
import interfaces.ProductsInterface;
import interfaces.QuerysInterface;
import interfaces.SalesrepsInterface;
import services.QuerysService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.*;

import entidades.Customers;
import entidades.Offices;
import entidades.Orders;
import entidades.Products;
import entidades.Salesreps;

public class Principal {
    public static void main(String[] args) throws Exception {

    	//prof.pena.utf@gmail.com

        EntityManagerFactory fabrica1 = Persistence.createEntityManagerFactory("default");
        EntityManager gerenciador2 = fabrica1.createEntityManager();

        EntityTransaction et = gerenciador2.getTransaction();

        et.begin();

        //starting the menu of cruds and searchs
        int option;
        int subOption;

        while(true){
            option = Integer.parseInt(JOptionPane.showInputDialog("0 - Exit\n" +
                    "1 - CRUD Offices\n"
            		+"2 - CRUD Products\n"
                    +"3 - CRUD Orders\n"
            		+"4 - CRUD Salesreps\n"
                    +"5 - CRUD Customers\n"
            		+"6- Querys"));

            switch (option){
                case 0:
                    gerenciador2.close();
                    fabrica1.close();
                    System.exit(0);
                    break;
                case 1: //OFFICES control menu
                    subOption = Integer.parseInt(JOptionPane.showInputDialog("0 - Go back\n" +
                            "1 - Create\n" +
                            "2 - Update\n" +
                            "3 - Delete\n" +
                            "4 - Search"));
                    switch (subOption){
                        case 0:
                            break;
                        case 1:
                        	OfficeInterface.insertNewOffice();
                            break;
                        case 2:
                        	OfficeInterface.updateOffice();
                        	break;
                        case 3:
                        	OfficeInterface.removeOffice();
                        	break;
                        case 4:
                        	Offices office = OfficeInterface.listData();
                        	if(office != null) {
                        		JOptionPane.showMessageDialog(null, "Data show\n"
                        				+"\nID: "+office.getOffice()
                        				+"\nCity: "+office.getCity()
                        				+"\nRegion: "+office.getRegion()
                        				+"\nManager: "+office.getMgr().getName()
                        				+"\nTarget: "+office.getTarget()
                        				+"\nSales: "+office.getSales());
                        	}else {
                        		JOptionPane.showMessageDialog(null, "Objeto não existente");
                        	}
                        	break;
                    }
                    break;
                case 2: //PRODUCTS control menu
                    subOption = Integer.parseInt(JOptionPane.showInputDialog("0 - Go back\n" +
                            "1 - Register\n" +
                            "2 - Update\n" +
                            "3 - Delete\n" +
                            "4 - Search"));

                    switch (subOption){
                    case 0:
                        break;
                    case 1:
                        ProductsInterface.insertNewProduct();
                        break;
                    case 2:
                    	ProductsInterface.updateProduct();
                        break;
                    case 3:
                    	ProductsInterface.removeProduct();
                        break;
                    case 4:
                    	Products product = ProductsInterface.listData();
                        if(product != null) {
                            JOptionPane.showMessageDialog(null, "Data show\n"
                                    +"\nMFR ID: "+product.getMfr_id()
                                    +"\nProduct ID: "+product.getProduct_id()
                                    +"\nDescription: "+product.getDescription()
                                    +"\nPrice: "+product.getPrice()
                                    +"\nQuantity: "+product.getQty_on_had());
                        }else {
                            JOptionPane.showMessageDialog(null, "Objeto não existente");
                        }
                        break;
                    }
                    break;
                case 3: //ORDERS control menu
                	subOption = Integer.parseInt(JOptionPane.showInputDialog("0 - Go back\n" +
                			"1 - Register\n" +
                			"2 - Update\n" +
                			"3 - Delete\n" +
                			"4 - Search"));

                	switch (subOption){
                	case 0:
                		break;
                	case 1:
                		OrdersInterface.insertNewOrder();
                		break;
                	case 2:
                		OrdersInterface.updateOrder();
                		break;
                	case 3:
                		OrdersInterface.removeOrder();
                		break;
                	case 4:
                		Orders order = OrdersInterface.listData();
                		
                		if(order != null) {
                            JOptionPane.showMessageDialog(null, "Data show\n"
                                    +"\nOrder Number: "+order.getOrder_num()
                                    +"\nOrder Date: "+order.getOrder_date()
                                    +"\nCustomer: "+order.getCust().getCompany()
                                    +"\nSalesrep: "+order.getRep().getName()
                                    +"\nCod Manufacturer: "+order.getProduct().getMfr_id()
                                    +"\nCod product: "+order.getProduct().getProduct_id()
                                    +"\nQuantity: "+order.getQty()
                                    +"\nAmount: "+order.getAmount());
                        }else {
                            JOptionPane.showMessageDialog(null, "Objeto não existente");
                        }
                		break;
                	}
                	break;
                	
                case 4: //SALESREPS control menu
                	subOption = Integer.parseInt(JOptionPane.showInputDialog("0 - Go back\n" +
                			"1 - Register\n" +
                			"2 - Update\n" +
                			"3 - Delete\n" +
                			"4 - Search"));

                	switch (subOption){
                	case 0:
                		break;
                	case 1:
                		SalesrepsInterface.insertNewSalesman();
                		break;
                	case 2:
                		SalesrepsInterface.updateSalesman();
                		break;
                	case 3:
                		SalesrepsInterface.removeSalesman();
                		break;
                	case 4:
                		Salesreps salesman = SalesrepsInterface.listData();
                		
                		if(salesman != null) {
                            JOptionPane.showMessageDialog(null, "Data show\n"
                                    +"\nName: "+salesman.getName()
                                    +"\nAge: "+salesman.getAge()
                                    +"\nOffice: "+salesman.getRep_office().getCity()
                                    +"\nTitle: "+salesman.getTitle()
                                    +"\nHire date: "+salesman.getHire_date()
                                    +"\nManager: "+salesman.getManager().getName()
                                    +"\nQuota: "+salesman.getQuota()
                                    +"\nSales: "+salesman.getSales());
                        }else {
                            JOptionPane.showMessageDialog(null, "Objeto não existente");
                        }
                		break;
                	}
                	break;
                	
                case 5: //CUSTOMERS control menu
                	subOption = Integer.parseInt(JOptionPane.showInputDialog("0 - Go back\n" +
                			"1 - Register\n" +
                			"2 - Update\n" +
                			"3 - Delete\n" +
                			"4 - Search"));

                	switch (subOption){
                	case 0:
                		break;
                	case 1:
                		CustomerInterface.insertNewCustomer();
                		break;
                	case 2:
                		CustomerInterface.updateCustomer();
                		break;
                	case 3:
                		CustomerInterface.removeCustomer();
                		break;
                	case 4:
                		Customers customer = CustomerInterface.listData();
                		
                		if(customer != null) {
                            JOptionPane.showMessageDialog(null, "Data show\n"
                                    +"\nCustomer Number: "+customer.getCust_num()
                                    +"\nCompany name: "+customer.getCompany()
                                    +"\nCustomer sales rep: "+customer.getCust_rep().getName()
                                    +"\nTCustomer credit limit: "+customer.getCredit_limit());
                        }else {
                            JOptionPane.showMessageDialog(null, "Objeto não existente");
                        }
                		break;
                	}
                	break;
                	
                case 6:
                	subOption = Integer.parseInt(JOptionPane.showInputDialog("0 - Go back\n" +
                			"1 - EX - 08\n"+
                			"2 - EX - 02\n"+
                			"3 - EX - 06\n"+
                			"4 - EX - 05\n"+
                			"5 - EX - 09\n"+
                			"6 - EX - 03\n"+
                			"7 - EX - 04\n"+
                			"8 - EX - 10\n"+
                			"9 - EX - 11\n"+
                			"10 - EX - 14\n"+
                			"11 - EX - 12\n"+
                			"12 - EX - 13\n"+
                			"13 - EX - 15"));
                	
                	switch(subOption) {
                	case 0:
                		break;
                	case 1:
                		QuerysInterface.ex08();
                		break;
                	case 2:
                		QuerysInterface.ex02();
                		break;
                	case 3:
                		QuerysInterface.ex06();
                		break;
                	case 4:
                		QuerysInterface.ex05();
                		break;
                	case 5:
                		QuerysInterface.ex09();
                		break;
                	case 6:
                		QuerysInterface.ex03();
                		break;
                	case 7:
                		QuerysInterface.ex04();
                		break;
                	case 8:
                		QuerysInterface.ex10();
                		break;
                	case 9:
                		QuerysInterface.ex11();
                		break;
                	case 10:
                		QuerysInterface.ex14();
                		break;
                	case 11:
                		QuerysInterface.ex12();
                		break;
                	case 12:
                		QuerysInterface.ex13();
                		break;
                	case 13: 
                		QuerysInterface.ex15();
                		break;
                	}
                	break;
            }

        }
    }

}
