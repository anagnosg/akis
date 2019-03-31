package gr.anagnosg.employeeservices.interfaces;

import gr.anagnosg.employeeservices.exceptions.ValidationException;

public interface SelfValidating {

	public void validate() throws ValidationException;
}
