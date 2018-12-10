package bank.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bank.model.Customer;
import bank.model.Transaction;

public class ControllerTransaction {
	DbConnection objConnection = new DbConnection();
	Connection connection = objConnection.get_connection();
	String notif;
	
	public List<Transaction> searchTransaction(Transaction data){
		PreparedStatement ps = null;
		List<Transaction> list = new ArrayList<>();
		try {			
			String query = "select * from Transaction where id = ?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, data.getId());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Transaction trans = new Transaction();
				trans.setId(rs.getInt("id"));
				trans.setType(rs.getString("type"));
				trans.setAmount(rs.getInt("amount"));
				trans.setAmountsign(rs.getString("amountsign"));
				trans.setAccountid(rs.getInt("accountid"));
				list.add(trans);
			}
		}catch(Exception e) {}
		return list;
	}

	public String addTransaction(Transaction data) {
		PreparedStatement ps = null;
		try {
			String query = "insert into transaction (type, amount, amountsign, accountid) values (?,?,?,?)";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, data.getType());
			ps.setInt(2, data.getAmount());
			ps.setString(3, data.getAmountsign());
			ps.setInt(4, data.getAccountid());
			ps.executeUpdate();
			notif="success ..!";
		}catch(Exception e) {
			notif = "gagal input...!";
		}
		return notif;
	}

	public String deleteTransaction(Transaction data) {
		PreparedStatement ps=null;
		try {		
			String query = "delete from transaction where id = ?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, data.getId());
			ps.executeUpdate();
			notif = "Success delete..";
		}catch(Exception e) {
			notif = "failed delete..";
		}
		return notif;
	}
	
	public List<Transaction> viewAccount(){
		PreparedStatement ps = null;
		List<Transaction> list = new ArrayList<>();
		try {
			String query = "SELECT * FROM transaction";
			ps = (PreparedStatement) connection.prepareStatement(query);					
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setId(rs.getInt("id"));
				transaction.setType(rs.getString("type"));
				transaction.setAmount(rs.getInt("amount"));
				transaction.setAmountsign(rs.getString("amountsign"));
				transaction.setAccountid(rs.getInt("accountid"));
				list.add(transaction);
			}
		}catch(Exception e) {}
		return list;
	}

	public String updateTransaction(Transaction data) {
		PreparedStatement ps = null;
		try {
			String query = "update transaction set type=?, amount=?, amountsign=? where id=?";
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, data.getType());
			ps.setInt(2, data.getAmount());
			ps.setString(3, data.getAmountsign());
			ps.setInt(4, data.getId());
			ps.executeUpdate();
			notif="success update..!";
		}catch(Exception e) {
			notif = "failed update...!";
		}
		return notif;
	}
}
