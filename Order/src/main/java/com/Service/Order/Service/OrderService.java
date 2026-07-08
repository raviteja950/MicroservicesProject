package com.Service.Order.Service;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import com.Service.Order.Entity.OrderEntity;
import com.Service.Order.Exception.CustomException;
import com.Service.Order.Repository.OrderRepo;
import com.Service.Order.Util.userFeignClient;
import com.Service.Order.bean.Responce;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.shared.Application;

@Component
public class OrderService {

	@Autowired
	private OrderRepo repo;

	@Autowired
	RestTemplate restTemplate;

//	@Autowired
//	private RestClient restClient;
//
//	@Autowired
//	private userFeignClient feignClient;

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Value("${userService.Url}")
	private String userServiceUrl;
	

	public Responce createOrder(OrderEntity order) {

		Responce responce = new Responce();
		try {
			//responce = validateUserFeignClinet(order.getJwtToken());
			responce = validateUserUsingRestTemplate(order.getJwtToken());
			if (responce.isUserValid()) {
				repo.save(order);
				responce.setCode(200);
				responce.setMessage("Order created sucessfully");
			} else {

				responce.setCode(responce.getCode());
				responce.setMessage(responce.getMessage());
			}

		} catch (Exception e) {
			responce.setCode(400);
			responce.setMessage(e.getMessage());
		}

		return responce;
	}

	public Responce validateUserUsingRestTemplate(String token) {

		Responce res = new Responce();
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer " + token);

			List<ServiceInstance> list = discoveryClient.getInstances("user-service");

			System.out.println(userServiceUrl);
			
			
			URI uri = list.get(0).getUri();
			System.out.println(uri);

			HttpEntity<?> entity = new HttpEntity<>(headers);
			ResponseEntity<String> response = restTemplate.exchange( userServiceUrl+"/isValidUser", HttpMethod.GET,
					entity, String.class);

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
				res.setUserValid(false);
			}
		} catch (Exception e) {
			res.setCode(400);
			res.setMessage(e.getMessage());
		}
		return res;
	}

//	public Responce validateUserUsingRestClinet(String token) {
//
//		Responce res = new Responce();
//		try {
//
//			res = restClient.get().uri("http://localhost:9001/isValidUser").accept(MediaType.APPLICATION_JSON)
//					.header("Authorization", "Bearer " + token).retrieve().body(Responce.class);
//
//			if (res.getCode() != 200) {
//				throw new CustomException(res.getMessage());
//			} else {
//				res.setCode(200);
//				res.setMessage("Fetched sucessfully user details from user service");
//				res.setUserValid(false);
//			}
//
//		} catch (Exception e) {
//			res.setCode(400);
//			res.setMessage(e.getMessage());
//		}
//
//		return res;
//
//	}
//
//	public Responce validateUserFeignClinet(String token) {
//
//		Responce res = new Responce();
//		try {
//
//			res = feignClient.isValidUser("Bearer " + token);
//
//			if (res.getCode() != 200) {
//				throw new CustomException(res.getMessage());
//			} else {
//				res.setCode(200);
//				res.setMessage("Fetched sucessfully user details from user service");
//				res.setUserValid(false);
//			}
//
//		} catch (Exception e) {
//			res.setCode(400);
//			res.setMessage(e.getMessage());
//		}
//
//		return res;
//
//	}
}
