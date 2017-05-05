package net.zoostar.sandbox.web.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.zoostar.sandbox.module.exception.SandboxException;
import net.zoostar.sandbox.web.controller.MainController;

@ControllerAdvice
public class MethodArgumentValidationHandler {
	
	static final Logger logger = LogManager.getLogger(MainController.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrors processValidationError(MethodArgumentNotValidException ex) {
		logger.error("Processing MethodArgumentNotValidException errors...");
		BindingResult result = ex.getBindingResult();
		ValidationErrors errors = new ValidationErrors();
		for(FieldError error : result.getFieldErrors()) {
			errors.addFieldError(error.getCode(), error.getDefaultMessage());
			logger.warn("Adding error: {}", error);
		}
		return errors;
	}

	@ExceptionHandler(SandboxException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String processValidationError(SandboxException ex) {
		logger.error(ex.getMessage(), ex);
		return ex.getMessage();
	}

}
