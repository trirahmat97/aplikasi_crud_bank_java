package bank.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import bank.controller.ControllerCustomer;
import bank.controller.ControllerLogin;
import bank.model.Customer;
import bank.model.ModelLogin;

public class ViewCustomer {
	
	MyMenu mymenu = new MyMenu();
	
	Scanner input = new Scanner(System.in);
	String username, password, firsname, lastname, phonenumber, phonetype;
	String birthdate;
	
	//tampil menu1
	public void menu1() {
		Scanner in = new Scanner(System.in);
		System.out.println("------- pilih menu pilih aje --------");
		System.out.println("1. Input customer ");
		System.out.println("2. Data customer ");
		System.out.println("3. Edit customer ");
		System.out.println("4. Delete customer ");
		System.out.println("5. Search customer ");
		System.out.println("0. Back To My-Menu ");
		System.out.println("-------------------------------------");
		System.out.print("pilih menu <0-5> : ");		
		//pilihan 
		try {
			int a = in.nextInt();
			switch(a) {
			
			case 0: 
				mymenu.menu();
				break;
			
			case 1:
				addCustomer();
				menu1();
				break;
				
			case 2:
				view();
				menu1();
				break;
				
			case 3:
				updateCustomer();
				menu1();
				break;
				
			case 4:
				deleteCustomer();
				menu1();
				break;
				
			case 5:
				searchCustomer();
				menu1();
				break;
				
			default:
				System.out.println("not number pilih");
				menu1();
				break;
			}
		}catch(Exception e) {
			menu1();
		}
	}

	public List<Customer> searchCustomer() {
		ControllerCustomer controller = new ControllerCustomer();
		Scanner input = new Scanner(System.in);
		
		System.out.println("--------- Menu Pencarian Customer -------");
		System.out.println("input ID CUSTOMER : ");
		
		int id = input.nextInt();
		Customer data = new Customer();
		data.setId(id);	
		List<Customer> list = controller.searchCustomer(data);
		
		for(Customer customer : list) {
			System.out.println("---------------------------------");
			System.out.println("ID \t \t: "+customer.getId());
			System.out.println("USERNAME \t: "+customer.getUsername());
			System.out.println("PASSWORD \t: "+customer.getPassword());
			System.out.println("FIRSNAME \t: "+customer.getFirtsname());
			System.out.println("LASTNAME \t: "+customer.getLastname());
			System.out.println("BRITHDATE \t: "+customer.getBirthdate());
			System.out.println("PHONETYPE \t: "+customer.getPhonetype());
			System.out.println("PHONENUMBER	: "+customer.getPhonenumber());			
			System.out.println("---------------------------------");
		}
		return list;
	}
	
	//add customer
	private String addCustomer() {
		ControllerCustomer dcustomer = new ControllerCustomer();
		System.out.println("------- Insert Data Customer --------");
		System.out.print("Username    : ");
		username = input.nextLine(); 
		System.out.print("Password    : ");
		password = input.nextLine();
		System.out.print("Firsname    : ");
		firsname = input.nextLine();
		System.out.print("Lastname    : ");
		lastname = input.nextLine();
		System.out.print("Birthdate   : ");
		birthdate = input.nextLine();
//		Date tgl = Date.valueOf(birthdate);
		System.out.print("Phonetype   : ");
		phonetype = input.nextLine();
		System.out.print("phonenumber : ");
		phonenumber = input.nextLine();
		Customer mcustomer = new Customer(username, password, firsname, lastname, birthdate, phonetype, phonenumber);
		String notif = dcustomer.addCustomer(mcustomer);
		return notif;	
	}
	
	//menampilkan data
	private List<Customer> view(){
		ControllerCustomer dcustomer = new ControllerCustomer();
		List<Customer> list = dcustomer.select();
		for(Customer customer : list) {
			System.out.println("---------------------------------");
			System.out.println("ID \t \t: "+customer.getId());
			System.out.println("USERNAME \t: "+customer.getUsername());
			System.out.println("PASSWORD \t: "+customer.getPassword());
			System.out.println("FIRSNAME \t: "+customer.getFirtsname());
			System.out.println("LASTNAME \t: "+customer.getLastname());
			System.out.println("BRITHDATE \t: "+customer.getBirthdate());
			System.out.println("PHONETYPE \t: "+customer.getPhonetype());
			System.out.println("PHONENUMBER	: "+customer.getPhonenumber());			
			System.out.println("---------------------------------");
		}
		return list;
    }
	
	//edit customer
	private String deleteCustomer() {
		ControllerCustomer controller = new ControllerCustomer();
		Scanner input = new Scanner(System.in);
		
		System.out.println("--------- Menu Delete Customer -------");
		System.out.println("input ID CUSTOMER : ");
		try {
			int id = input.nextInt();
			Customer data = new Customer();
			data.setId(id);
			String notif = controller.deleteCustomer(data);
			System.out.println(notif);
			return notif;
		}catch(Exception e) {
			System.out.println("\\u001b[31m input does not match the format !!");
			deleteCustomer();
		}
		String notif=null;
		return notif;
		
	}

	private String updateCustomer() {
		ControllerCustomer dcustomer = new ControllerCustomer();
		Scanner in = new Scanner(System.in);
		System.out.println("------- Update Data Customer --------");
		System.out.print("ID Customer : ");
		int id = in.nextInt(); 
		System.out.print("Username    : ");
		username = input.nextLine(); 
		System.out.print("Password    : ");
		password = input.nextLine();
		System.out.print("Firsname    : ");
		firsname = input.nextLine();
		System.out.print("Lastname    : ");
		lastname = input.nextLine();
		System.out.print("Birthdate   : ");
		birthdate = input.nextLine();
//			Date tgl = Date.valueOf(birthdate);
		System.out.print("Phonetype   : ");
		phonetype = input.nextLine();
		System.out.print("phonenumber : ");
		phonenumber = input.nextLine();
		Customer mcustomer = new Customer(username, password, firsname, lastname, birthdate, phonetype, phonenumber, id);
		String notif = dcustomer.updateCustomer(mcustomer);
		System.out.println(notif);
		return notif;
	}
}
