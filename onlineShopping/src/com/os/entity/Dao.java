package com.os.entity;

import java.util.HashSet;

import com.os.service.catalogService.CatalogType;

public class Dao {
	public static int currentUser=-1;
	public static Dao dao =new Dao();
	public static HashSet<Customer> customerList = new HashSet<Customer>(); 
	public static HashSet<Supplier> supplierList = new HashSet<Supplier>(); 
	public static HashSet<Catalog> catalogList = new HashSet<Catalog>();
	public static HashSet<Item> itemList = new HashSet<Item>(); 
	public static HashSet<DeliveryOrder> deliveryOrderList = new HashSet<DeliveryOrder>(); 
	public static HashSet<Inventory> inventoryList = new HashSet<Inventory>(); 
	
	
	public void test(){
		for(int i=0;i<3;i++){
			Item item=new Item();
			Catalog catalog=new Catalog();
			item.setItemId(i);
			item.setQuantity(i);
			item.setUnitCost(i);
			Dao.itemList.add(item);
			catalog.setItemList(Dao.itemList);
			catalog.setCatalogType(CatalogType.BOOK);
			catalog.setSupplierId(i);
			catalog.setItemDescription("TEST");
			catalogList.add(catalog);
			DeliveryOrder deliveryOrder = new DeliveryOrder();
			deliveryOrder.setOrderId(i);
			deliveryOrder.setAmountDue(i);
			deliveryOrder.setSupplierId(i);
			deliveryOrder.setItemList(itemList);
			deliveryOrderList.add(deliveryOrder);
		
		}
	}
}
