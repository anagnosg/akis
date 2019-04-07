package gr.akis.handsapp.interfaces;

import gr.akis.handsapp.exceptions.ValidationException;

public interface SelfValidating {

	public void validate() throws ValidationException;
}
