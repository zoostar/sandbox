package net.zoostar.sandbox.web.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.zoostar.sandbox.model.Person;
import net.zoostar.sandbox.web.controller.MainController;

public class PersonValidator implements Validator {

	static final Logger logger = LogManager.getLogger(MainController.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Person.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("Validating entity Person...");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ssn", HttpStatus.UNPROCESSABLE_ENTITY.toString(), "SSN may not be empty!");
	}

}
