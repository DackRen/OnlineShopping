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
	 * �ύĿ¼���ͣ����ظ�������Ʒ���ɵ�Ŀ¼
	 * (non-Javadoc)
	 * @see com.os.coordination.ICustomerCoodinator#requestCatalog(com.os.service.catalogService.CatalogType)
	 */
	@Override
	public Catalog requestCatalog(CatalogType c) {
		// TODO Auto-generated method stub
		return catalogService.requestCatalog(c);
	}

	/*
	 * �ύ�û�ѡ�����ƷID �����û��������Ʒ���Ϻ���Ϣ
	 * (non-Javadoc)
	 * @see com.os.coordination.ICustomerCoodinator#requestSelectionFromCatalog(int[])
	 */
	@Override
	public HashSet<Item> requestSelectionFromCatalog(int[] itemId) {
		// TODO Auto-generated method stub
		return catalogService.requestSelection(itemId);
	}

	/*
	 * �ύ��Ʒ���򼯺�
	 * �������Ͷ���������
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
