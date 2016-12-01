package com.os.entity;

public class Customer {
	int customerID;
	String customerName;
	String address;
	String telephoneNumber;
	
	public int getCostomerID() {
		return customerID;
	}
	public void setCostomerID(int costomerID) {
		this.customerID = costomerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
}
