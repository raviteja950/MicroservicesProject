package com.Service.Order.Config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class userServieLoadbalancer {

	@Bean
	public ReactorLoadBalancer<ServiceInstance> userServiceLoadBalancer(LoadBalancerClientFactory factory)
	{
		System.out.println("inside userServiceLoadbalancer");
		
//		String serviceId = environment.getProperty(
//	            LoadBalancerClientFactory.PROPERTY_NAME);
		
		return new RoundRobinLoadBalancer(factory.getLazyProvider("user-service", ServiceInstanceListSupplier.class), "user-service");
		
	}
}
