package bank.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bank.model.ModelLogin;

public class ControllerLogin {
	
	DbConnection objConnection = new DbConnection();
	Connection connection = objConnection.get_connection();
	
	
	String notif;
	
	public String getLogin(ModelLogin dataLogin){
		PreparedStatement ps = null;
		try {
			String query = "SELECT * from customer WHERE username = ? and password= ?";			
			ps = connection.prepareStatement(query);
			ps.setString(1, dataLogin.getUsername());
			ps.setString(2, dataLogin.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(dataLogin.getUsername().equals(rs.getString("username")) && dataLogin.getUsername().equals(rs.getString("password"))) {
					notif ="success";
				}
			}else {
				System.out.println("gagal");
				notif ="username atau password anda salah";
			}
			
		}catch(Exception e) {
			notif = "Tidak terdeksi";
		}
		
 		return notif;
	}

}
