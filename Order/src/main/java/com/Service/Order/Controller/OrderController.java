package com.Service.Order.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.Service.Order.Entity.OrderEntity;
import com.Service.Order.Service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;

	@PostMapping("/order")
	public OrderEntity createOrder(@RequestBody OrderEntity order, @RequestHeader("Authorization") String token) {
		return service.createOrder(order, token);
	}
}
