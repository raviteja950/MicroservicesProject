package com.Service.Order.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.Service.Order.Entity.OrderEntity;
import com.Service.Order.Service.OrderService;
import com.Service.Order.bean.Responce;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping("/order")
	public Responce createOrder(@RequestBody OrderEntity order) {

		Responce res = new Responce();
		try {
			res = service.createOrder(order);
		} catch (Exception e) {
			res.setCode(400);
			res.setMessage(e.getMessage());
		}
		return res;
	}
}
