package employeeServices;

import org.junit.Test;

import com.google.gson.Gson;

import gr.anagnosg.employeeservices.exceptions.ValidationException;
import gr.anagnosg.schoolservices.models.Student;

public class TestValidation {

	
	public void testValidation1() throws ValidationException{
		Student e = new Student();
		e.setPhone("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111dsaasasdf");
		e.validate();
		System.out.println(new Gson().toJson(e));
	}
	
}
