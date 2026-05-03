package com.Service.User.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Service.User.Bean.RegisterRequest;
import com.Service.User.Bean.Responce;
import com.Service.User.Entity.RoleTable;
import com.Service.User.Entity.UserEntity;
import com.Service.User.Exception.CustomException;
import com.Service.User.Repository.RolesRepository;
import com.Service.User.Repository.userRepository;

@Service
public class UserService {

	private userRepository respo;
	private RolesRepository roles;
	

	public UserService(userRepository respo,RolesRepository rolesrepo) {
		this.respo = respo;
		this.roles = rolesrepo;
	}

	public Responce registerUser(RegisterRequest request) {

		Responce responce = new Responce();

		Set<RoleTable> role = new HashSet<RoleTable>();
		try {

			UserEntity userDetails = new UserEntity();
			userDetails.setUsername(request.getUsername());
			userDetails.setEmail(request.getEmail());
			userDetails.setPassword(request.getPassword());

			RoleTable roleDetales = roles.findById((long) 2).get();

			if (roleDetales != null && roleDetales.getRolename().equalsIgnoreCase("Normal_User")) {
				role.add(roleDetales);
				userDetails.setRoles(role);
				respo.save(userDetails);
				responce.setMessage("User Register succefully");
				responce.setCode(200);
			} else {
				responce.setMessage("Roles dones not present");
				responce.setCode(400);
			}

		} catch (Exception e) {
			responce.setMessage(e.getMessage());
			responce.setCode(400);
		}
		return responce;
	}

	public Responce getUserdetails() {

		Responce responce = new Responce();
		try {
			List<UserEntity> userList = respo.findAll();
			if (userList == null) {
				throw new CustomException("No User Details List are Found");
			} else {
				responce.setUserList(userList);
				responce.setCode(200);

			}
		} catch (Exception e) {
			responce.setMessage(e.getMessage());
			responce.setCode(400);
		}
		return responce;
	}

	public Responce getSpecificUserdetils(String id) {

		Responce responce = new Responce();
		try {
			UserEntity userDeatails = respo.findByEmail(id);

			if (userDeatails == null) {
				throw new CustomException("User details are Not Found");
			} else {
				responce.setUserDetails(userDeatails);
				responce.setCode(200);

			}
		} catch (Exception e) {
			responce.setMessage(e.getMessage());
			responce.setCode(400);
		}
		return responce;
	}

}
