package net.zoostar.sandbox.module.exception;

public class DuplicateEntityException extends SandboxException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateEntityException() {
		super();
	}

	public DuplicateEntityException(String message) {
		super(message);
	}

	public DuplicateEntityException(Throwable cause) {
		super(cause);
	}

	public DuplicateEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateEntityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
