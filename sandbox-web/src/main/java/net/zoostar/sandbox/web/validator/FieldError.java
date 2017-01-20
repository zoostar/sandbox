package net.zoostar.sandbox.web.validator;

import java.io.Serializable;

public class FieldError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String message;

	public FieldError(String code, String message) {
		this.setCode(code);
		this.setMessage(message);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FieldError [field=").append(code).append(", message=").append(message).append("]");
		return builder.toString();
	}
}