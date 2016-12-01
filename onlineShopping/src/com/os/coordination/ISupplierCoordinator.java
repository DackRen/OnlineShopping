package com.os.coordination;

public interface ISupplierCoordinator {
	public int requestOrder(int supplierId);
	public void confirmShipment(int orderId);

}
