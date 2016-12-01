package com.os.service.DeliveryOrderService;

import com.os.entity.Dao;
import com.os.entity.DeliveryOrder;

public class DeliveryOrderService implements IDeliveryOrderService {

	@Override
	public int store(DeliveryOrder deliveryOrder) {
		// TODO Auto-generated method stub
		Dao.deliveryOrderList.add(deliveryOrder);
		return deliveryOrder.getOrderId();
	}

	@Override
	public DeliveryOrder select(int supplierId) {
		// TODO Auto-generated method stub
		for (DeliveryOrder co : Dao.deliveryOrderList) {  
		      if (co.getSupplierId()==supplierId)
		    	  return co;
		}  
		return null;
	}

	@Override
	public void commit(int orderId) {
		// TODO Auto-generated method stub
		//确定订单 
		//改变status
		if(select(orderId)!=null)
			return;
			
	}
	
}
