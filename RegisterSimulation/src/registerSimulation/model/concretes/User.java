package registerSimulation.model.concretes;

import registerSimulation.core.models.Model;

public class User implements Model{

	private int id;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private	boolean isVerified;
	
	
	public User() {
		
		
	}

	public User(int id, String firstName, String lastName, String eMail, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getisVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	@Override
	public String toString() {
		return "{\"id\": " + id + ", \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"email\": \"" + eMail
				+ "\", \"password\": \"" + password + "\", isActive: " + isVerified + "}";
	}
	
	
	
}
