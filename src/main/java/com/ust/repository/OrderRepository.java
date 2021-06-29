package com.ust.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ust.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {

}
