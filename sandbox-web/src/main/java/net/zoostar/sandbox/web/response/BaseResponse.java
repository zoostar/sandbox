package net.zoostar.sandbox.web.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public BaseResponse() {
		super();
	}
	
	public BaseResponse(String message) {
		this.message = message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseResponse [message=").append(message).append("]");
		return builder.toString();
	}

}
