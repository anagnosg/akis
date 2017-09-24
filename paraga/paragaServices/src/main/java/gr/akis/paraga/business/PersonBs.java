package gr.akis.paraga.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.paraga.db.PersonDB;
import gr.akis.paraga.models.Person;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;
import gr.akis.paraga.models.Person;

@RequestScoped
public class PersonBs {

	@Inject
	ConnectionWrapper connwrap;

	@Inject
	PersonDB personDB;
	 

	public List<Person> selectAll() throws SQLException {
		List<Person> persons;
		persons = personDB.selectAll();
		return persons;
	}
	
	public Person insert(Person person) throws SQLException{
		
		return personDB.insert(person);
	}
	
	public Person update(Person person) throws SQLException{
	
		return personDB.update(person);
	}
	
	
	public Person delete(Person person) throws SQLException{
		
		return personDB.delete(person);
	}

	public PersonBs(){}
	
	public List<Person> selectMathimaAllDummy() throws SQLException{
		List<Person> person = null; // ???sµ?? ??sta? µa??t??.
		person = new ArrayList<Person>();
		
		//???sµ?? d?? a?t??e?µ???? µa??t?? Students  kai pro8hkh sthn lista. 
		Person p = new Person(); //Orismos antikeimenou me onoma ag kai klash Student; Arxikopoihsh tou
		p.setId(1);
		p.setName("Istoria");
		person.add(p);
		
		
		return person;
	}
	
	
	
	public List<Person> selectmathimaAll() throws SQLException{
		List<Person> person  ;
	
		person = personDB.selectAll();
		 
		return person;
	}
}
