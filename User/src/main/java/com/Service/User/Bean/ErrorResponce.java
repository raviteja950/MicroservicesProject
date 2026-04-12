package com.Service.User.Bean;

public class ErrorResponce {

	private String errorMessage;
	private int errorCode;
	private String errorDetails;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public ErrorResponce(String errorMessage, int errorCode, String errorDetails) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.errorDetails = errorDetails;
	}

	public ErrorResponce() {
		super();
		// TODO Auto-generated constructor stub
	}

}
