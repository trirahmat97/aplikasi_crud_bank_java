package bank.model;

public class Transaction {
	private int id;
	private String type;
	private int amount;
	private String amountsign;
	private int accountid;
	
	public Transaction() {}
	
	public Transaction(String type, int amount, String amountsign, int accountid) {
		this.type = type;
		this.amount = amount;
		this.amountsign = amountsign;
		this.accountid = accountid;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAmountsign() {
		return amountsign;
	}

	public void setAmountsign(String amountsign) {
		this.amountsign = amountsign;
	}

	
}
