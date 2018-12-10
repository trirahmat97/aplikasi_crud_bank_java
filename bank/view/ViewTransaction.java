package bank.view;

import java.util.List;
import java.util.Scanner;

import bank.controller.ControllerAccount;
import bank.controller.ControllerCustomer;
import bank.controller.ControllerTransaction;
import bank.model.Account;
import bank.model.Customer;
import bank.model.Transaction;

public class ViewTransaction {
	
	MyMenu mymenu = new MyMenu();
	Scanner input = new Scanner(System.in);
	Scanner in = new Scanner(System.in);
	int id, amount, accountid;
	String type, amountsign;
	
	//tampil menu1
	public void menu() {
		Scanner in = new Scanner(System.in);
		System.out.println("------- pilih menu pilih aje --------");
		System.out.println("1. Input Transaction ");
		System.out.println("2. Data Transaction ");
		System.out.println("3. Edit Transaction ");
		System.out.println("4. Delete Transaction ");
		System.out.println("5. Search Transaction ");
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
				addTransaction();
				menu();
				break;
				
			case 2:
				viewTransaction();
				menu();
				break;
				
			case 3:
				updateTransaction();
				menu();
				break;
				
			case 4:
				deleteTransaction();
				menu();
				break;
				
			case 5:
				searchTransaksi();
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
	public List<Transaction> searchTransaksi() {
		ControllerTransaction controller = new ControllerTransaction();
		Scanner input = new Scanner(System.in);
		
		System.out.println("--------- Menu Pencarian Customer -------");
		System.out.println("input ID Transaksi : ");
		
		int id = input.nextInt();
		Transaction data = new Transaction();
		data.setId(id);	
		List<Transaction> list = controller.searchTransaction(data);
		
		for(Transaction trans : list) {
			System.out.println("---------------------------------");
			System.out.println("ID \t \t: "+trans.getId());
			System.out.println("TYPE \t \t: "+trans.getType());
			System.out.println("AMOUNT \t \t: "+trans.getAmount());
			System.out.println("AMOUNT SIGN \t: "+trans.getAmountsign());
			System.out.println("ACCOUNT ID \t: "+trans.getAccountid());	
			System.out.println("---------------------------------");
		}
		return list;
	}
	
	//view
	private List<Transaction> viewTransaction(){
		ControllerTransaction ctransaction = new ControllerTransaction();
		List<Transaction> list = ctransaction.viewAccount();
		for(Transaction data : list) {
			System.out.println("---------------------------------");
			System.out.println("ID \t \t: "+data.getId());
			System.out.println("TYPE \t \t: "+data.getType());
			System.out.println("AMOUNT  \t: "+data.getAmount());
			System.out.println("AMOUNTSIGN \t: "+data.getAmountsign());	
			System.out.println("ID ACCOUNT \t: "+data.getAccountid());	
			System.out.println("---------------------------------");
		}
		return list;
	}

	public String addTransaction() {
		ControllerTransaction ctransaction = new ControllerTransaction();
		System.out.println("------- Insert Data Transaction --------");
		
		System.out.print("Type  \t \t: ");
		type = input.nextLine(); 
		System.out.print("Amount \t \t : ");
		amount = in.nextInt();
		System.out.print("Amountsign \t: ");
		amountsign = input.nextLine();
		System.out.print("Account ID \t: ");
		accountid = in.nextInt();
		
		Transaction mtransaction = new Transaction(type,amount,amountsign,accountid);
		String notif = ctransaction.addTransaction(mtransaction);
		System.out.println(notif);
		return notif;
	}
	
	public String deleteTransaction() {
		ControllerTransaction ctransaction = new ControllerTransaction();
		System.out.println("------- Delete Data Transaction --------");
		
		System.out.print("ID Transaction  : ");
		int id = input.nextInt(); 
		
		Transaction mtransaction = new Transaction();
		mtransaction.setId(id);
		String notif = ctransaction.deleteTransaction(mtransaction);
		System.out.println(notif);
		return notif;	
	}

	//update
	private String updateTransaction() {
		ControllerTransaction ctransaction = new ControllerTransaction();
		System.out.println("------- Update Data Transaction --------");
		
		System.out.print("ID Transaction  : ");
		int id = input.nextInt(); 
		System.out.print("Type  \t \t: ");
		type = in.nextLine(); 
		System.out.print("amount     \t: ");
		amount = input.nextInt();
		System.out.print("Amount Sign  \t: ");
		amountsign = in.nextLine(); 
	
		Transaction mtransaction = new Transaction();
		mtransaction.setId(id); mtransaction.setType(type);  mtransaction.setAmount(amount); mtransaction.setAmountsign(amountsign);;
		
		String notif = ctransaction.updateTransaction(mtransaction);
		System.out.println(notif);
		return notif;	
	}
}
