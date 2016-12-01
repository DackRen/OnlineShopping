package com.os.entity;

import java.sql.Date;
import java.util.HashSet;

public class DeliveryOrder {
	int orderId;
	//x orderStatus;
	//int accountId;
	float amountDue;
	//ÊÚÈ¨ID
	//int authorizationId;
	int supplierId;
	Date plannedShipDate;
	Date actualShipDate;
	Date paymentDate;
	HashSet<Item> itemList; 
	
	public HashSet<Item> getItemList() {
		return itemList;
	}
	public void setItemList(HashSet<Item> itemList) {
		this.itemList = itemList;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public float getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(float amountDue) {
		this.amountDue = amountDue;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public Date getPlannedShipDate() {
		return plannedShipDate;
	}
	public void setPlannedShipDate(Date plannedShipDate) {
		this.plannedShipDate = plannedShipDate;
	}
	public Date getActualShipDate() {
		return actualShipDate;
	}
	public void setActualShipDate(Date actualShipDate) {
		this.actualShipDate = actualShipDate;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
}
