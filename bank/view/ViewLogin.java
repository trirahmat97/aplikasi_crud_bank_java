package bank.view;

import java.util.Scanner;

import bank.controller.ControllerLogin;
import bank.model.ModelLogin;

public class ViewLogin {
	Scanner input = new Scanner(System.in);
	String username, password;
	
	public String login() {
		
		MyMenu mymenu = new MyMenu();
		
		ControllerLogin clogin = new ControllerLogin();
		System.out.println("------- Input Username and Password --------");
		
		System.out.print("Username  : ");
		username = input.nextLine(); 
		
		System.out.print("Password  : ");
		password = input.nextLine();
		
		ModelLogin mlogin = new ModelLogin();
		mlogin.setUsername(username); mlogin.setPassword(password);
		
		String notif = clogin.getLogin(mlogin);
		
		if(notif=="success") {
			mymenu.menu();
		}else {
			System.out.println(notif);
			login();
		}
		
		return notif;
	}

}
