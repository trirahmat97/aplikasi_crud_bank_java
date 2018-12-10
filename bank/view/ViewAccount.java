package bank.view;

import java.util.List;
import java.util.Scanner;

import bank.controller.ControllerAccount;
import bank.controller.ControllerTransaction;
import bank.model.Account;
import bank.model.Transaction;

public class ViewAccount {
	
	MyMenu mymenu = new MyMenu();
	
	Scanner input = new Scanner(System.in);
	String opendate;
	int balance, customerid;
	
	//tampil menu1
	public void menu() {
		Scanner in = new Scanner(System.in);
		System.out.println("------- pilih menu pilih aje --------");
		System.out.println("1. Input Account ");
		System.out.println("2. Data Account ");
		System.out.println("3. Edit Account ");
		System.out.println("4. Delete Account ");
		System.out.println("5. Search Account ");
		System.out.println("0. Back To MY-Menu ");
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
				addAccount();
				menu();
				break;
				
			case 2:
				viewAccount();
				menu();
				break;
				
			case 3:
				updateAccount();
				menu();
				break;
				
			case 4:
				deleteAccout();
				menu();
				break;
				
			case 5:
				searchAccount();
				menu();
				break;

			default:
				System.out.println("not number pilih");
				menu();
				break;
			}
		}catch(Exception e) {
			menu();
		}
	}
	
	public List<Account> searchAccount() {
		ControllerAccount controller = new ControllerAccount();
		Scanner input = new Scanner(System.in);
		
		System.out.println("--------- Menu Pencarian Customer -------");
		System.out.println("input ID Account : ");
		
		int id = input.nextInt();
		Account data = new Account();
		data.setId(id);	
		List<Account> list = controller.searchAccount(data);
		
		for(Account account : list) {
			System.out.println("---------------------------------");
			System.out.println("ID \t \t: "+account.getId());
			System.out.println("OPEN DATE\t: "+account.getOpendate());
			System.out.println("BALANCE \t: "+account.getBalance());
			System.out.println("CUSTUMER ID \t: "+account.getCustomerid());	
			System.out.println("---------------------------------");
		}
		return list;
	}
	
	//add customer
	private String addAccount() {
		ControllerAccount caccount = new ControllerAccount();
		System.out.println("------- Insert Data Customer --------");
		
		System.out.print("Open Date  : ");
		opendate = input.nextLine(); 
		System.out.print("Balance    : ");
		balance = input.nextInt();
		System.out.print("ID Customer: ");
		customerid = input.nextInt();
		
		Account maccount = new Account(opendate, balance, customerid);
		String notif = caccount.addCustomer(maccount);
		System.out.println(notif);
		return notif;	
	}
	
	//delete
	private String deleteAccout() {
		ControllerAccount caccount = new ControllerAccount();
		System.out.println("------- Delete Data Account --------");
		
		System.out.print("ID Account  : ");
		int id = input.nextInt(); 
		
		Account maccount = new Account();
		maccount.setId(id);
		String notif = caccount.deleteAccount(maccount);
		System.out.println(notif);
		return notif;	
	}

	//update
	private String updateAccount() {
		ControllerAccount caccount = new ControllerAccount();
		System.out.println("------- Update Data Customer --------");
		
		System.out.print("ID Account  : ");
		int id = input.nextInt(); 
		
		System.out.print("Balance     : ");
		balance = input.nextInt();
	
		Account maccount = new Account();
		maccount.setId(id); maccount.setBalance(balance);
		
		String notif = caccount.updateAccount(maccount);
		System.out.println(notif);
		return notif;	
	}
	
	//view
	private List<Account> viewAccount(){
		ControllerAccount caccount = new ControllerAccount();
		List<Account> list = caccount.viewAccount();
		for(Account data : list) {
			System.out.println("---------------------------------");
			System.out.println("ID \t \t: "+data.getId());
			System.out.println("OPENDATE \t: "+data.getOpendate());
			System.out.println("BALANCE  \t: "+data.getBalance());
			System.out.println("CUSTOMERID \t: "+data.getCustomerid());		
			System.out.println("---------------------------------");
		}
		return list;
	}

}
