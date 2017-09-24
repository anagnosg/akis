package gr.akis.paraga.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.paraga.models.Person;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;
import gr.anagnosg.schoolservices.models.Mathima;

@RequestScoped
public class PersonDB {

	@Inject
	ConnectionWrapper connWrapper;

	public void PersonDB() {
	}
	
	
	
	/** 
	 * Finds all persons
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Person> selectAll() throws SQLException {
		List<Person> persons   = new ArrayList<Person>();
		
		String sql = "SELECT ID , NAME,SURNAME,AGE,ADDRESS,POINTS FROM  Person ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				ResultSet rs = pstate.executeQuery();) {
			while (rs.next()) {

				Person p = new Person();
				p.setId(rs.getInt("ID"));
				p.setName(rs.getString("NAME"));
				p.setSurname(rs.getString("SURNAME"));
				p.setAge(rs.getInt("AGE"));
				p.setAddress(rs.getString("ADDRESS"));
				p.setPoints(rs.getInt("POINTS"));
			    persons.add(p);
			}
		}
		return persons;
	}
}
