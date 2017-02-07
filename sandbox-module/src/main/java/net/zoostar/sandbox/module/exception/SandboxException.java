package net.zoostar.sandbox.module.exception;

public abstract class SandboxException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SandboxException() {
		super();
	}

	public SandboxException(String message) {
		super(message);
	}

	public SandboxException(Throwable cause) {
		super(cause);
	}

	public SandboxException(String message, Throwable cause) {
		super(message, cause);
	}

	public SandboxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
