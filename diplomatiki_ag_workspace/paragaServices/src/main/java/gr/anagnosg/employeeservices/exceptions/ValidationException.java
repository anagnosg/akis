package gr.anagnosg.employeeservices.exceptions;

public class ValidationException extends Exception{
	public ValidationException(){super();}
	public ValidationException(String message){super("Validation Exception :"+message);}
}
