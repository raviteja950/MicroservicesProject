package com.Service.Order.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.Service.Order.bean.ErrorResponce;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ErrorResponce CustomExceptionhandler(CustomException exp, WebRequest req) {

		ErrorResponce responce = new ErrorResponce();

		responce.setMessage(exp.getMessage());
		responce.setCode(400);
		responce.setDetails(req.getDescription(false));

		return responce;
	}
}
