package bank.model;

public class Account {
	private String opendate;
	private int balance, customerid, id;
	
	public Account() {}
	
	public Account(String opendate, int balance, int customerid) {
		this.opendate = opendate;
		this.balance = balance;
		this.customerid = customerid;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpendate() {
		return opendate;
	}
	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	
}
