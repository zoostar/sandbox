package net.zoostar.sandbox.web.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.zoostar.sandbox.model.Person;
import net.zoostar.sandbox.web.validator.PersonValidator;
import net.zoostar.sandbox.web.validator.ValidationErrors;

@RestController
@RequestMapping("/api")
public class ValidationRestController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrors processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		ValidationErrors errors = new ValidationErrors();
		for(FieldError error : result.getFieldErrors()) {
			errors.addFieldError(error.getCode(), error.getDefaultMessage());
		}
		return errors;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new PersonValidator());
	}

	@RequestMapping(path="/person", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Person> createNewInventory(@Valid @RequestBody Person person) {
		return new ResponseEntity<>(person, HttpStatus.CREATED);
	}
}
