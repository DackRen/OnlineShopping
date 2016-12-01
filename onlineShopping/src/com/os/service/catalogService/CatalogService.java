package com.os.service.catalogService;

import java.util.HashSet;

import com.os.entity.Catalog;
import com.os.entity.Dao;
import com.os.entity.Item;

public class CatalogService implements ICatalogService{

	@Override
	public Catalog requestCatalog(CatalogType ct) {
		// TODO Auto-generated method stub
		for (Catalog cl : Dao.catalogList) {  
		      if (cl.getCatalogType().equals(ct))
		    	  return cl;
		}  
		return null;
	}
	@Override
	public HashSet<Item> requestSelection(int[] itemId) {
		// TODO Auto-generated method stub
		HashSet<Item> ilist = new HashSet<Item>(); 
		for (int item : itemId) {
			for (Item it : Dao.itemList) {  
			      if (it.getItemId()==item)
			    	  ilist.add(it);
			}  
		}
		return ilist;
	}

}
