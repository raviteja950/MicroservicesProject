package com.Service.Order.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.Service.Order.Entity.OrderEntity;
import com.Service.Order.Exception.CustomException;
import com.Service.Order.Repository.OrderRepo;
import com.Service.Order.bean.Responce;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OrderService {

	@Autowired
	private OrderRepo repo;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public Responce createOrder(OrderEntity order) {

		Responce responce = new Responce();
		try {
			responce = validateUser(order.getUserName(),order.getJwtToken());
			if (responce.getCode() == 200) {
				repo.save(order);
				responce.setCode(200);
				responce.setMessage("Order created sucessfully");
			} else {

				responce.setCode(400);
				responce.setMessage(responce.getMessage());
			}

		} catch (Exception e) {
			responce.setCode(400);
			responce.setMessage(e.getMessage());
		}

		return responce;
	}

	public Responce validateUser(String userId,String token) {

		Responce res = new Responce();
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer " + token);

			HttpEntity<?> entity = new HttpEntity<>( headers);
			ResponseEntity<String> response = restTemplate().exchange(
					"http://localhost:9001/getSpecificUserdetils/" + userId, HttpMethod.GET, entity, String.class);

			String responseBody = response.getBody();

			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(responseBody);
			int code = root.path("code").asInt();
			String message = root.path("message").asText();

			if (code != 200) {
				throw new CustomException(message);
			} else {
				res.setCode(200);
				res.setMessage("Fetched sucessfully user details from user service");
				res.setUserValid(true);
			}
		} catch (Exception e) {
			res.setCode(400);
			res.setMessage(e.getMessage());
		}
		return res;
	}
}
