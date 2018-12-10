package bank.view;

import java.util.List;
import java.util.Scanner;

import bank.controller.ControllerAccount;
import bank.model.Account;

public class NewFiture {
	MyMenu mymenu = new MyMenu();
	
	int accountid, customerid;
	public void menu() {
		Scanner in = new Scanner(System.in);
		System.out.println("------- pilih menu pilih aje --------");
		System.out.println("1. Search Transaction By Account ");
		System.out.println("2. Search Account By Customer ");
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
				searchTransaction();
				menu();
				break;
				
			case 2:
//				viewAccount();
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
	
	public List<Account> searchTransaction() {
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
}
