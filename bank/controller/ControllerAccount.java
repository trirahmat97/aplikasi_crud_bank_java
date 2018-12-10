package bank.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bank.model.Account;
import bank.model.Transaction;

public class ControllerAccount {
	DbConnection objConnection = new DbConnection();
	Connection connection = objConnection.get_connection();
	String notif;
	
	public List<Account> searchAccount(Account data){
		PreparedStatement ps = null;
		List<Account> list = new ArrayList<>();
		try {			
			String query = "select * from Account where id = ?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, data.getId());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("id"));
				account.setOpendate(rs.getString("opendate"));
				account.setBalance(rs.getInt("balance"));
				account.setCustomerid(rs.getInt("customerid"));
				list.add(account);
			}
		}catch(Exception e) {}
		return list;
	}
	
	public String addCustomer(Account data) {
		PreparedStatement ps = null;
		try {
			String query = "insert into account (opendate, balance, customerid) values (?,?,?)";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, data.getOpendate());
			ps.setInt(2, data.getBalance());
			ps.setInt(3,  data.getCustomerid());
			ps.executeUpdate();
			notif="success ..!";
		}catch(Exception e) {
			notif = "gagal input...!";
		}
		return notif;
	}
	
	public String deleteAccount(Account data) {
		PreparedStatement ps=null;
		try {		
			String query = "delete from Account where id = ?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, data.getId());
			ps.executeUpdate();
			notif = "Success delete..";
		}catch(Exception e) {
			notif = "failed delete..";
		}
		return notif;
	}

	public String updateAccount(Account data) {
		PreparedStatement ps = null;
		try {
			String query = "update account set balance=? where id=?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, data.getBalance());
			ps.setInt(2, data.getId());
			ps.executeUpdate();
			notif="success update..!";
		}catch(Exception e) {
			notif = "failed update...!";
		}
		return notif;
	}

	public List<Account> viewAccount(){
		PreparedStatement ps = null;
		List<Account> list = new ArrayList<>();
		try {
			String query = "SELECT * FROM account";
			ps = (PreparedStatement) connection.prepareStatement(query);					
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("id"));
				account.setOpendate(rs.getString("opendate"));
				account.setBalance(rs.getInt("balance"));
				account.setCustomerid(rs.getInt("customerid"));
				list.add(account);
			}
		}catch(Exception e) {}
		return list;
	}


}
