package com.os.coordination;

import java.util.HashSet;

import com.os.entity.Catalog;
import com.os.entity.Customer;
import com.os.entity.DeliveryOrder;
import com.os.entity.Item;

import com.os.service.catalogService.CatalogType;


public interface ICustomerCoodinator{
	public Catalog requestCatalog(CatalogType c);
	public HashSet<Item> requestSelectionFromCatalog(int[] itemId);
	public DeliveryOrder requesPurchase(HashSet<Item> iteamlist);//input puchaseInfo return orderID
	public Customer requestAccount(int coutomerId);
	public DeliveryOrder requseOrderStatus(int orderId);
	
}
