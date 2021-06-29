package com.ust.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
	@Id
	private int orderId;
	private int customerId;
	private String customerName;
	private List<Product> product;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, int customerId, String customerName, List<Product> product) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.product = product;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", product=" + product + "]";
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	

}
