package io.matoshri.jpa.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1998813636989374563L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
}
