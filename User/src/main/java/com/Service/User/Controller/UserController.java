package com.Service.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.Service.User.Bean.RegisterRequest;
import com.Service.User.Bean.Responce;
import com.Service.User.Entity.UserEntity;
import com.Service.User.Exception.CustomException;
import com.Service.User.Security.jwtUtility;
import com.Service.User.Service.UserService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

@RestController
public class UserController {

	@Autowired
	private jwtUtility util;

	private UserService service;

	public UserController(UserService ser) {
		this.service = ser;
	}

	@PostMapping("/registerUser")
	public Responce registerUser(@RequestBody RegisterRequest request) {

		Responce responce = new Responce();
		try {
			responce = service.registerUser(request);
		} catch (Exception e) {
			responce.setMessage(e.getMessage());
			responce.setCode(400);
		}
		return responce;

	}

	@GetMapping("/isValidUser")
	public Responce isValidUser(Authentication authentication) {

		Responce responce = new Responce();
		try {

			String user = (String) authentication.getPrincipal();
			if (!user.isEmpty() || !user.isBlank()) {
				responce.setMessage("User autenticated sucessfully");
				responce.setCode(200);
			} else {
				responce.setMessage("User authentication failed");
				responce.setCode(400);
			}

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
