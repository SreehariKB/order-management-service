package com.ust.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

import com.ust.entity.Order;
import com.ust.repository.OrderRepository;

@DataMongoTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
class OrderControllerTest {

	@Autowired
	private OrderRepository repo;
	@SuppressWarnings("unused")
	private Order order;

	@Test
	@Rollback(false)
	@org.junit.jupiter.api.Order(1)
	void testFindAll() {

		com.ust.entity.Order savedOrder = new Order(1, 1, "sreehari", null);
		repo.save(savedOrder);

	}

	@Test
	@Rollback(false)
	@org.junit.jupiter.api.Order(2)
	public void testCreateOrder() {
		Order savedOrder = repo.save(new Order(1, 1, "sreehari", null));

		assertThat(savedOrder.getOrderId()).isGreaterThan(0);
	}

	@Test
	@Rollback(false)
	@org.junit.jupiter.api.Order(3)
	void testUpdateOrder() {

		int orderId = 2;
		Order order = new Order(orderId, 2, "sreehari", null);
		order.setOrderId(2);

		repo.save(order);

		Optional<Order> updatedOrder = repo.findById(orderId);
		assertThat(updatedOrder.get()).isEqualTo(orderId);

	}

	/*
	 * @Test
	 * 
	 * @Rollback(false) public void testListProducts() {
	 * 
	 * List <Purchase> purchase=repo.findAll();
	 * 
	 * for(Purchase purchases :purchase) { System.out.println(purchases); }
	 * 
	 * assertThat(purchase).size().isGreaterThan(0);
	 * 
	 * }
	 * 
	 * 
	 * @Test
	 * 
	 * @Rollback(false)
	 * 
	 * @Order(6) void testDeletePurchase() { Integer id=2; boolean
	 * isExistBeforeDelete=repo.findById(id).isPresent(); repo.deleteById(id);
	 * 
	 * boolean notExistAfterDelete=repo.findById(id).isPresent();
	 * assertTrue(isExistBeforeDelete); assertFalse(notExistAfterDelete); }
	 * 
	 * }
	 */

}
