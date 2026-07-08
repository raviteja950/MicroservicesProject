package com.Service.Order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.Service.Order.Config.userServieLoadbalancer;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@LoadBalancerClient(name = "user-service",configuration = userServieLoadbalancer.class)
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
