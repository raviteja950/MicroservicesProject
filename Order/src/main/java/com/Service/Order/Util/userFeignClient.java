package com.Service.Order.Util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import com.Service.Order.bean.Responce;

@FeignClient(name = "user-service", url = "http://localhost:9001")
public interface userFeignClient {

	@GetMapping(value="/isValidUser",headers = {"Content-Type=application/json"})
	public Responce isValidUser(@RequestHeader("Authorization") String token);

}
