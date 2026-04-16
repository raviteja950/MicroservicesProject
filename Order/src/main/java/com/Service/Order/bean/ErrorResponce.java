package com.Service.Order.bean;

public class ErrorResponce {

	private String message;
	private int code;

	private String details;

	public ErrorResponce(String message, int code, String details) {
		super();
		this.message = message;
		this.code = code;
		this.details = details;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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

	public ErrorResponce(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}

	public ErrorResponce() {
		super();
		// TODO Auto-generated constructor stub
	}

}
