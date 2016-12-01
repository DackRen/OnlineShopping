package com.os.entity;

import java.util.HashSet;

import com.os.service.catalogService.CatalogType;

public class Catalog {
	HashSet<Item> itemList; 
	String itemDescription;
	int supplierId;
	CatalogType catalogType;
	//linkType itemDetails;
	
	public CatalogType getCatalogType() {
		return catalogType;
	}
	public void setCatalogType(CatalogType catalogType) {
		this.catalogType = catalogType;
	}
	public HashSet<Item> getItemList() {
		return itemList;
	}
	public void setItemList(HashSet<Item> itemList) {
		this.itemList = itemList;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

}
