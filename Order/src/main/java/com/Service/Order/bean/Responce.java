package com.Service.Order.bean;

import com.Service.Order.Entity.OrderEntity;

public class Responce {

	private String message;
	private int code = 0;

	private OrderEntity orderDetails;

	private boolean isUserValid = false;

	

	public boolean isUserValid() {
		return isUserValid;
	}

	public void setUserValid(boolean isUserValid) {
		this.isUserValid = isUserValid;
	}

	public OrderEntity getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderEntity orderDetails) {
		this.orderDetails = orderDetails;
	}

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

	public Responce(String message, int code, OrderEntity orderDetails) {
		super();
		this.message = message;
		this.code = code;
		this.orderDetails = orderDetails;
	}

	public Responce(String message, int code, boolean isUserValid) {
		super();
		this.message = message;
		this.code = code;
		this.isUserValid = isUserValid;
	}

}
