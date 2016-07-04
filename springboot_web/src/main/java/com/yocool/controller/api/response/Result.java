package com.yocool.controller.api.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Map;

public class Result<T> {

	private static final Logger logger = LoggerFactory.getLogger(Result.class);

	private T result;
	private String message;

	private Result() {
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static <T> ResponseEntity<Result<T>> success(T result) {
		Result<T> Result = new Result<T>();
		Result.setResult(result);
		ResponseEntity<Result<T>> responseResult = new ResponseEntity<Result<T>>(Result,
				HttpStatus.OK);
		logger.debug("Success with result {}", toString(result));
		return responseResult;
	}

	public static <T> ResponseEntity<Result<T>> success(T result, String message) {
		Result<T> Result = new Result<T>();
		Result.setMessage(message);
		Result.setResult(result);
		ResponseEntity<Result<T>> responseResult = new ResponseEntity<Result<T>>(Result,
				HttpStatus.OK);
		logger.debug("Success with result {} and message {}", toString(result), message);
		return responseResult;
	}

	public static <T> ResponseEntity<Result<T>> failed() {
		Result<T> Result = new Result<T>();
		ResponseEntity<Result<T>> result = new ResponseEntity<Result<T>>(Result,
				HttpStatus.BAD_REQUEST);
		logger.debug("Failed with no message.");
		return result;
	}

	public static <T> ResponseEntity<Result<T>> failed(String message) {
		Result<T> Result = new Result<T>();
		Result.setMessage(message);
		ResponseEntity<Result<T>> result = new ResponseEntity<Result<T>>(Result,
				HttpStatus.BAD_REQUEST);
		logger.debug("Failed with message {}", message);
		return result;
	}

	public static <T> ResponseEntity<Result<T>> failed(HttpStatus status, String message) {
		Result<T> Result = new Result<T>();
		Result.setMessage(message);
		ResponseEntity<Result<T>> result = new ResponseEntity<Result<T>>(Result, status);
		logger.debug("Failed with message {} and http status {}", message, status);
		return result;
	}

	public static <T> ResponseEntity<Result<T>> failed(Throwable e) {
		if (e instanceof RuntimeException) {
			return failed((RuntimeException) e);
		}
		Result<T> Result = new Result<T>();
		ResponseEntity<Result<T>> result = new ResponseEntity<Result<T>>(Result,
				HttpStatus.INTERNAL_SERVER_ERROR);
		logger.warn("Failed with throwable exception, message {}", e.getMessage());
		logger.debug("Failed with throwable exception, stack trace:", e);
		return result;
	}

	public static <T> ResponseEntity<Result<T>> failed(RuntimeException e) {
		Result<T> Result = new Result<T>();
		Result.setMessage(e.getMessage());
		ResponseEntity<Result<T>> result = new ResponseEntity<Result<T>>(Result,
				HttpStatus.BAD_REQUEST);
		logger.debug("Failed with base exception, stack trace:", e);
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static <T> String toString(T value) {
		if (value == null) {
			return "<Empty>";
		} else if (value instanceof Collection) {
			return "Collection with size " + ((Collection) value).size();
		} else if (value instanceof Map) {
			return "Map with size " + ((Map) value).size();
		}
		return String.valueOf(value);
	}

}