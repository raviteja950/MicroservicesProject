package com.Service.User.AdminController;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.User.Bean.Responce;
import com.Service.User.Service.UserService;

@RestController
@RequestMapping("/Admin")
@PreAuthorize("hasAuthority('Admin_User')")
public class AdminController {

	private UserService service;

	public AdminController(UserService ser) {
		this.service = ser;
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

}
