package com.Service.Order.Util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class Templates {

	@Bean
	public RestClient restClientInstance() {
		return RestClient.create();
	}
}
