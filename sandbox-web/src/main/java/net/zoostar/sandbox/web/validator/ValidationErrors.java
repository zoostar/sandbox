package net.zoostar.sandbox.web.validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrors implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<FieldError> fieldErrors = new ArrayList<>();

	public ValidationErrors() {
		super();
	}
	
	public List<FieldError> getFieldErrors() {
		return this.fieldErrors;
	}

	public void addFieldError(String path, String message) {
		FieldError error = new FieldError(path, message);
		fieldErrors.add(error);
	}
}
