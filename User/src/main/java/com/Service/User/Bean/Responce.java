package com.Service.User.Bean;

import java.util.List;

import com.Service.User.Entity.UserEntity;

public class Responce {

	private String message;
	private int code = 0;

	private List<UserEntity> userList;

	private UserEntity userDetails;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Responce(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}

	public Responce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<UserEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}

	public UserEntity getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserEntity userDetails) {
		this.userDetails = userDetails;
	}

	public Responce(String message, int code, UserEntity userDetails) {
		super();
		this.message = message;
		this.code = code;
		this.userDetails = userDetails;
	}

	public Responce(String message, int code, List<UserEntity> userList) {
		super();
		this.message = message;
		this.code = code;
		this.userList = userList;
	}

}
