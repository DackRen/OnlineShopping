package com.os.service.customerAccountService;

public interface IAccountService {
	//CustomerAccount requsetAccount
	public int createCustomerAccount(String UserName,String Telephone,String Address);
	public int createSupplierAccount(String UserName,String Telephone,String Address);
	public int requestCustomerAccount(String UserName);
	public int requestSupplierAccount(String UserName);

	
}
