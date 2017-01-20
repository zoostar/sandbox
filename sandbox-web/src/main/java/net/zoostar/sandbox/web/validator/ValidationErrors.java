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

	public void addFieldError(String path, String message) {
		FieldError error = new FieldError(path, message);
		fieldErrors.add(error);
	}
	
	public List<FieldError> getFieldErrors() {
		return this.fieldErrors;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValidationErrors [fieldErrors=").append(fieldErrors).append("]");
		return builder.toString();
	}
}
