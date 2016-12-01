package com.os.service.catalogService;

import java.util.HashSet;

import com.os.entity.Catalog;
import com.os.entity.Item;

public interface ICatalogService {
	public Catalog requestCatalog(CatalogType ct);
	public HashSet<Item> requestSelection(int[] itemId);

}
