package bank.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bank.model.Customer;

public class ControllerCustomer {
	
	DbConnection objConnection = new DbConnection();
	Connection connection = objConnection.get_connection();
	String notif;
	
	public List<Customer> searchCustomer(Customer data){
		PreparedStatement ps = null;
		List<Customer> list = new ArrayList<>();
		try {
			String query = "select * from customer where id = ?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, data.getId());
			ResultSet rs = ps.executeQuery();		
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("password"));
				customer.setFirtsname(rs.getString("firsname"));
				customer.setLastname(rs.getString("lastname"));
				customer.setBirthdate(rs.getString("birthdate"));
				customer.setPhonetype(rs.getString("phonetype"));
				customer.setPhonenumber(rs.getString("phonenumber"));
				list.add(customer);
			}
		}catch(Exception e) {}
		return list;
	}
	
	//lihat data customer
		public List<Customer> select() {
			PreparedStatement ps = null;
			List<Customer> list = new ArrayList<>();
			try {
				String query = "SELECT * FROM customer";
				ps = (PreparedStatement) connection.prepareStatement(query);					
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Customer customer = new Customer();
					customer.setId(rs.getInt("id"));
					customer.setUsername(rs.getString("username"));
					customer.setPassword(rs.getString("password"));
					customer.setFirtsname(rs.getString("firsname"));
					customer.setLastname(rs.getString("lastname"));
					customer.setBirthdate(rs.getString("birthdate"));
					customer.setPhonetype(rs.getString("phonetype"));
					customer.setPhonenumber(rs.getString("phonenumber"));
					list.add(customer);
				}
			}catch(Exception e) {}
			return list;
		}
	
	public String addCustomer(Customer data) {
		PreparedStatement ps = null;
		try {
			String query = "insert into customer (username,password,firsname,lastname,birthdate,phonetype,phonenumber) values (?,?,?,?,?,?,?)";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, data.getUsername());
			ps.setString(2, data.getPassword());
			ps.setString(3, data.getFirtsname());
			ps.setString(4, data.getLastname());
			ps.setString(5, data.getBirthdate());
			ps.setString(6, data.getPhonetype());
			ps.setString(7, data.getPhonenumber());
			ps.executeUpdate();
			notif = "behasil";
		}catch(Exception e) {
			notif = "gagal";
		}
		return notif;
	}
	
	
	public String deleteCustomer(Customer data) {
		PreparedStatement ps=null;
		try {		
			String query = "delete from customer where id = ?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, data.getId());
			ps.executeUpdate();
			notif = "Berhasil delete";
		}catch(Exception e) {
			notif = "gagal delete";
		}
		return notif;
	}

	public String updateCustomer(Customer data) {
		PreparedStatement ps = null;
		try {
			String query = "update customer set username = ?, password=?, firsname=?, lastname=?, birthdate=?, phonetype=?, phonenumber=? where id =?)";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, data.getUsername());
			ps.setString(2, data.getPassword());
			ps.setString(3, data.getFirtsname());
			ps.setString(4, data.getLastname());
			ps.setString(5, data.getBirthdate());
			ps.setString(6, data.getPhonetype());
			ps.setString(7, data.getPhonenumber());
			ps.setInt(8, data.getId());
			System.out.println(ps);
			ps.executeUpdate();
			notif = "behasil";
		}catch(Exception e) {
			notif = "gagal";
		}
		return notif;
	}
}
