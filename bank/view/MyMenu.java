package bank.view;

import java.util.Scanner;

public class MyMenu {
	public void menu() {
		
		ViewCustomer viewcus = new ViewCustomer();
		ViewAccount viewacc = new ViewAccount();
		ViewTransaction viewtra = new ViewTransaction();
		
		Scanner in = new Scanner(System.in);
		System.out.println("------- pilih menu pilih aje --------");
		System.out.println("1. Customer ");
		System.out.println("2. Account ");
		System.out.println("3. Transacsion ");
		System.out.println("4. New Fiture ");
		System.out.println("0. Exit ");
		System.out.println("-------------------------------------");
		System.out.print("pilih menu <1-5> : ");		
		//pilihan 
		try {
			int a = in.nextInt();
			switch(a) {
			case 0: System.exit(0);
			menu();
			break;
			
			case 1:
				viewcus.menu1();
				menu();
				break;
				
			case 2:
				viewacc.menu();
				menu();
				break;
				
			case 3:
				viewtra.menu();
				menu();
				break;
				
			case 4:
//				deleteAccout();
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
	
}
