package com.Service.User.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Service.User.Bean.Responce;
import com.Service.User.Entity.UserEntity;
import com.Service.User.Exception.CustomException;
import com.Service.User.Repository.userRepository;

@Service
public class UserService {

	private userRepository respo;

	public UserService(userRepository respo) {
		this.respo = respo;
	}

	public Responce registerUser(UserEntity userDetails) {

		Responce responce = new Responce();
		try {
			respo.save(userDetails);
			responce.setMessage("User Register succefully");
			responce.setCode(200);

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
