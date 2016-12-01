package com.os.service.DeliveryOrderService;

import com.os.entity.DeliveryOrder;

public interface IDeliveryOrderService {
	public int store(DeliveryOrder deliveryOrder);
	public DeliveryOrder select(int orderId);
	public void commit(int orderId);

}
