package bank.model;

public class Customer{
	private int id;
	private String username;
	private String password;
	private String firtsname;
	private String lastname;
	private String birthdate;
	private String phonetype;
	private String phonenumber;
	
	public Customer() {
		
	}
	
	public Customer(String username, String password, String firstname, String lastname, String birthdate, String phonetype, String phonenumber) {
		this.username = username;
		this.password = password;
		this.firtsname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.phonetype = phonetype;
		this.phonenumber = phonenumber;
	}
	
	public Customer(String username, String password, String firstname, String lastname, String birthdate, String phonetype, String phonenumber, int id) {
		this.username = username;
		this.password = password;
		this.firtsname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.phonetype = phonetype;
		this.phonenumber = phonenumber;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirtsname() {
		return firtsname;
	}

	public void setFirtsname(String firtsname) {
		this.firtsname = firtsname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhonetype() {
		return phonetype;
	}

	public void setPhonetype(String phonetype) {
		this.phonetype = phonetype;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}	
	
}
