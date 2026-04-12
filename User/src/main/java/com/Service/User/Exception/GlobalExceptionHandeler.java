package com.Service.User.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.Service.User.Bean.ErrorResponce;

@RestControllerAdvice
public class GlobalExceptionHandeler {

	@ExceptionHandler(CustomException.class)
	public ErrorResponce CustomExceptionHandler(CustomException exception,
			WebRequest req) {

		System.out.println(exception.getMessage());
		ErrorResponce responce = new ErrorResponce();
		responce.setErrorMessage(exception.getMessage());
		responce.setErrorDetails(req.getDescription(false));
		responce.setErrorCode(409);

		return responce;

	}

}
