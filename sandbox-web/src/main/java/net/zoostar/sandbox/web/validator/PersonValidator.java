package net.zoostar.sandbox.web.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.zoostar.sandbox.model.Person;

public class PersonValidator implements Validator {

	static final Logger logger = LoggerFactory.getLogger(PersonValidator.class);
	
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
