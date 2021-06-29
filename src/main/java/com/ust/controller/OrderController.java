package com.ust.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.entity.Order;
import com.ust.service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/add")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);

	}

	@GetMapping("/all-orders")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orderList = orderService.getAllOrders();
		return new ResponseEntity<List<Order>>(orderList, HttpStatus.OK);
	}

	@GetMapping(path = "/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable("orderId") int orderId) {

		return new ResponseEntity<Order>(orderService.getOrderByOrderId(orderId), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{orderId}")

	public ResponseEntity<Order> deleteOrder(@PathVariable("orderId") int orderId) {
		Order order = orderService.deleteOrder(orderId);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) throws Exception {
		Order order1 = orderService.updateOrder(order);
		if (order1 != null) {
			return new ResponseEntity<>(order1, HttpStatus.OK);
		}
		throw new Exception();

	}
	
	
}
