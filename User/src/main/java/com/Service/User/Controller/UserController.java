package com.Service.User.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.Service.User.Bean.Responce;
import com.Service.User.Entity.UserEntity;
import com.Service.User.Service.UserService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

@RestController
public class UserController {

	private UserService service;

	public UserController(UserService ser) {
		this.service = ser;
	}

	@PostMapping("/registerUser")
	public Responce registerUser(@RequestBody UserEntity userDetails) {

		Responce responce = new Responce();
		try {
			responce = service.registerUser(userDetails);
		} catch (Exception e) {
			responce.setMessage(e.getMessage());
			responce.setCode(400);
		}
		return responce;

	}

	@GetMapping("/getUserDetails")
	public Responce getUserdeatils() {

		Responce responce = new Responce();
		try {

			responce = service.getUserdetails();

		} catch (Exception e) {
			responce.setMessage(e.getMessage());
			responce.setCode(400);
		}

		return responce;

	}

	@GetMapping("/getSpecificUserdetils/{emailId}")
	public Responce getSpecificUserdetils(@PathVariable String emailId) {

		Responce responce = new Responce();
		try {
			responce = service.getSpecificUserdetils(emailId);

		} catch (Exception e) {
			responce.setMessage(e.getMessage());
			responce.setCode(400);
		}
		return responce;

	}
}
