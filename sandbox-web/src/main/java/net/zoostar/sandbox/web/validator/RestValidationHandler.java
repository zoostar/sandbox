package net.zoostar.sandbox.web.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.zoostar.sandbox.module.exception.SandboxException;

@ControllerAdvice
public class RestValidationHandler {
	
	static final Logger logger = LoggerFactory.getLogger(RestValidationHandler.class);

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
