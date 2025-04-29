package com.GUWACosmetics.model;


public class CustomerModel {

	private String firstName;
	private String lastName;
	private String userName;
	private String phonenumber;
	private String email;
	private String password;
	private String confirm;
	
	
	public CustomerModel(String firstName, String lastName, String userName, String phonenumber, String email,
			String password, String confirm) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	

	

}