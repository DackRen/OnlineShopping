package com.os.coordination;

import com.os.service.DeliveryOrderService.DeliveryOrderService;
import com.os.service.DeliveryOrderService.IDeliveryOrderService;

public class SupplierCoordinator implements ISupplierCoordinator{
	IDeliveryOrderService deliveryOrderService = new DeliveryOrderService();
	
	
	@Override
	public int requestOrder(int supplierId) {
		// TODO Auto-generated method stub
		return deliveryOrderService.select(supplierId).getOrderId();
	}

	@Override
	public void confirmShipment(int orderId) {
		// TODO Auto-generated method stub
		deliveryOrderService.commit(orderId);
	}

}
