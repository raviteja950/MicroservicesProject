package com.Service.Order.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.Service.Order.Entity.OrderEntity;
import com.Service.Order.Repository.OrderRepo;

@Component
public class OrderService {

	@Autowired
	private OrderRepo repo;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public OrderEntity createOrder(OrderEntity order, String token) {
		boolean result = validateUser(order.getUserName(), token);
		if (result) {
			return repo.save(order);
		} else {
			return null;
		}

	}

	public boolean validateUser(String userId, String token) {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate().exchange("http://localhost:9001/getSpecificUserdetils/" + userId,
				HttpMethod.GET, entity, String.class);

		if (!response.getStatusCode().is2xxSuccessful()) {
			return false;
		}
		return true;
	}
}
