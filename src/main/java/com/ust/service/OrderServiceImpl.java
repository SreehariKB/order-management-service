package com.ust.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.entity.Order;
import com.ust.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order saveOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> order = (List<Order>)orderRepository.findAll();
		return order;		
	}
	@Override
	public Order getOrderByOrderId(int orderId)  {
		Optional<Order> optional = orderRepository.findById(orderId);
			return optional.get();	
	}
	@Override
	public Order deleteOrder(int orderId) {
		@SuppressWarnings("unused")
		Optional<Order> optional = orderRepository.findById(orderId);
		Order orderById = orderRepository.findById(orderId).get();
		orderRepository.deleteById(orderId);
		return orderById;
	}

	@Override
	public Order updateOrder(Order order) throws Exception {
		if(orderRepository.existsById(order.getOrderId())) {
			Order save = orderRepository.save(order);
					return save;
		}
		else
			throw new Exception();
	}

}
