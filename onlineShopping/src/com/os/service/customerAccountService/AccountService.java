package com.os.service.customerAccountService;

import com.os.entity.Customer;
import com.os.entity.Dao;
import com.os.entity.Supplier;

public class AccountService implements IAccountService {
	@Override
	public int createCustomerAccount(String UserName,String Telephone,String Address) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setCustomerName(UserName);
		customer.setTelephoneNumber(Telephone);
		customer.setAddress(Address);
		customer.setCostomerID(Dao.customerList.size());
		Dao.customerList.add(customer);
		return customer.getCostomerID();
		}
	public int createSupplierAccount(String UserName,String Telephone,String Address) {
		// TODO Auto-generated method stub
		Supplier supplier = new Supplier();
		supplier.setSupplierName(UserName);
		supplier.setTelephoneNember(Telephone);
		supplier.setAddress(Address);
		supplier.setSupplierId(Dao.customerList.size());
		Dao.supplierList.add(supplier);
		return supplier.getSupplierId();
		}
	@Override
	public int requestCustomerAccount(String UserName) {
		// TODO Auto-generated method stub
		for (Customer ct : Dao.customerList) {  
		      if (ct.getCustomerName().equals(UserName))
		    	  return ct.getCostomerID();
		}  
		return -1;
	}
	@Override
	public int requestSupplierAccount(String UserName) {
		// TODO Auto-generated method stub
		for (Supplier sl : Dao.supplierList) {  
		      if (sl.getSupplierName().equals(UserName))
		    	  return sl.getSupplierId();
		}  
		return -1;
	}
}
