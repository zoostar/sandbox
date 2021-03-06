package net.zoostar.sandbox.web.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.zoostar.sandbox.model.Person;
import net.zoostar.sandbox.module.exception.DuplicateEntityException;
import net.zoostar.sandbox.web.validator.PersonValidator;

@RestController
@RequestMapping("/api")
public class PersonRestController {
	
	static final Logger logger = LoggerFactory.getLogger(PersonRestController.class);

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		logger.debug("initBinder({})", binder);
		binder.setValidator(new PersonValidator());
	}

	@RequestMapping(path="/person", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Person> createNewPerson(@Valid @RequestBody Person person) throws DuplicateEntityException {
		if("string".equalsIgnoreCase(person.getSsn())) {
			throw new DuplicateEntityException(String.format("Person with SSN %s already exists.", person.getSsn()));
		}
		return new ResponseEntity<>(person, HttpStatus.CREATED);
	}
}
