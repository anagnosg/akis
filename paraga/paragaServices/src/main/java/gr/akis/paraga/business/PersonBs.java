package gr.akis.paraga.business;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.paraga.db.PersonDB;
import gr.akis.paraga.models.Person;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;
import gr.anagnosg.schooleservices.db.ClassDB;
import gr.anagnosg.schooleservices.db.MathimaDB;
import gr.anagnosg.schoolservices.models.Mathima;

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

}
