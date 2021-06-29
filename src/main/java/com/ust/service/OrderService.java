package com.ust.service;

import java.util.List;

import com.ust.entity.Order;

public interface OrderService {
	Order saveOrder(Order order);
	List<Order> getAllOrders();
	Order getOrderByOrderId(int orderId);
	Order deleteOrder(int orderId);
	Order updateOrder(Order order) throws Exception;

}
