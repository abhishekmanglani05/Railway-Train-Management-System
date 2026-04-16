package com.Model;

public class Customer {
	private String userName;      // max 50
    String email;         // unique
    private String password;      // 6-12, strong
    private String address;       // max 100
    private String contactNumber; // exact 10 digits
    private int userId;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Customer(String userName, String email, String password, String address, String contactNumber) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contactNumber = contactNumber;
	}
	
	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", contactNumber=" + contactNumber + ", userId=" + userId + "]";
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	} 
    
    
}
