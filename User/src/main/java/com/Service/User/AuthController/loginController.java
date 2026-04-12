package com.Service.User.AuthController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.User.Bean.Responce;
import com.Service.User.Bean.authenticateUser;
import com.Service.User.Entity.UserEntity;
import com.Service.User.Exception.CustomException;
import com.Service.User.Repository.userRepository;
import com.Service.User.Security.jwtUtility;

@RestController
@RequestMapping("/auth")
public class loginController {

	public jwtUtility jwt;

	public userRepository repo;

	public loginController(userRepository userRepository, jwtUtility jwtutil) {
		this.repo = userRepository;
		this.jwt = jwtutil;
	}

	@PostMapping("/login")
	public Responce login(@RequestBody authenticateUser user) {

		Responce responce = new Responce();
		try {
			UserEntity userDetails = repo.findByEmail(user.getEmail());
			if (userDetails == null || !user.getPassword().equalsIgnoreCase(userDetails.getPassword())) {
				throw new CustomException("In-valid  Credentials");
			} else {
				String token = jwt.generateToken(user.getEmail());
				responce.setMessage(token);
				responce.setCode(200);
			}

		} catch (Exception e) {
			responce.setMessage(e.getMessage());
			responce.setCode(400);
		}

		return responce;
	}
}
