package com.os.coordination;

import java.util.HashSet;

import com.os.entity.Catalog;
import com.os.entity.Customer;
import com.os.entity.Dao;
import com.os.entity.DeliveryOrder;
import com.os.entity.Item;
import com.os.service.DeliveryOrderService.DeliveryOrderService;
import com.os.service.DeliveryOrderService.IDeliveryOrderService;
import com.os.service.catalogService.CatalogService;
import com.os.service.catalogService.CatalogType;
import com.os.service.catalogService.ICatalogService;

public class CustomerCoodinator implements ICustomerCoodinator {

	ICatalogService catalogService = new CatalogService();
	/*
	 * 提交目录类型，返回该类型商品生成的目录
	 * (non-Javadoc)
	 * @see com.os.coordination.ICustomerCoodinator#requestCatalog(com.os.service.catalogService.CatalogType)
	 */
	@Override
	public Catalog requestCatalog(CatalogType c) {
		// TODO Auto-generated method stub
		return catalogService.requestCatalog(c);
	}

	/*
	 * 提交用户选择的商品ID 返回用户购买的商品集合和信息
	 * (non-Javadoc)
	 * @see com.os.coordination.ICustomerCoodinator#requestSelectionFromCatalog(int[])
	 */
	@Override
	public HashSet<Item> requestSelectionFromCatalog(int[] itemId) {
		// TODO Auto-generated method stub
		return catalogService.requestSelection(itemId);
	}

	/*
	 * 提交商品购买集合
	 * 生成配送订单并返回
	 * (non-Javadoc)
	 * @see com.os.coordination.ICustomerCoodinator#requesPurchase(java.util.HashSet)
	 */
	@Override
	public DeliveryOrder requesPurchase(HashSet<Item> iteamlist) {
		// TODO Auto-generated method stub
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		IDeliveryOrderService deliveryOrderService = new DeliveryOrderService();
		deliveryOrder.setOrderId(Dao.deliveryOrderList.size());
		deliveryOrder.setItemList(iteamlist);

		deliveryOrderService.store(deliveryOrder);
		return deliveryOrder;
	}

	@Override
	public Customer requestAccount(int coutomerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryOrder requseOrderStatus(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
