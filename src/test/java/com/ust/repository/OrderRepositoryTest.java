package com.ust.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.entity.Order;
import com.ust.service.OrderServiceImpl;

@SpringBootTest
class OrderRepositoryTest {

	@Autowired
	private OrderRepository orderRepository;
	private Order order;

	@BeforeEach
	void setUp() throws Exception {
		order = new Order(1, 1, "sreehari", null);
	}

	@AfterEach
	void tearDown() throws Exception {
		orderRepository.deleteAll();
		order = null;
	}

	@Test
	public void saveOrderReturnOrderDetails() {
		Order savedOrder = orderRepository.save(order);
		assertNotNull(savedOrder);
		assertEquals(order.getOrderId(), savedOrder.getOrderId());
		assertEquals(order.getCustomerId(), savedOrder.getCustomerId());
		assertEquals(order.getCustomerName(), savedOrder.getCustomerName());
		assertEquals(order.getProduct(), savedOrder.getProduct());

	}

	@Test
	public void getOrderByOrderIdReturnOrderDetails() {
		orderRepository.save(order);
		Optional<Order> findById = orderRepository.findById(order.getOrderId());
		assertNotNull(findById);
		assertEquals(order.getOrderId(), findById.get());
		assertEquals(order.getCustomerId(), findById.get());
		assertEquals(order.getCustomerName(), findById.get());
		assertEquals(order.getProduct(), findById.get());
	}

	@Test
	public void deleteOrderReturnOrderDetails() {

		orderRepository.save(order);
		Optional<Order> findById = orderRepository.findById(order.getOrderId());
		orderRepository.delete(findById.get());
		Optional<Order> findByIdAfterDelete = orderRepository.findById(order.getOrderId());
		assertEquals(null, findByIdAfterDelete);
	}

}
