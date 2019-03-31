package gr.akis.paraga.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.paraga.models.Person;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;
import gr.akis.paraga.models.Person;

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
	public Person insert(Person person) throws SQLException {

		String sql = "INSERT INTO PERSON (NAME ,SURNAME,AGE,ADDRESS,POINTS) VALUES (?,?,?,?,?)"; //orismoume se ena string thn sql pou 8a treksoume 

		Connection conn = this.connWrapper.getConnection(); // Pernoume mia sundesh (connection) me thn bash
		//apo to connection ekteloume thn methodo prepareStatement kai proetoimazoume thn java 
		//gia thn ektelesh ths entolhs sql.
		//Statement.RETURN_GENERATED_KEYS epistrefei ta identities .
		PreparedStatement pstate = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		//to try einai ena block kodika to opoio mporei n apetaksei kapoio exception 
		//kai me to try sthn periptosh pou petaksi kapoio exeception ekteloume kapoies leitourgies. 
		try {
			pstate.setString(1,person.getName()); //pername tis patametrous 
			pstate.setString(2,person.getSurname());
			pstate.setInt(3,person.getAge());
			pstate.setString(4,person.getAddress());
			pstate.setInt(5,person.getPoints());
			pstate.executeUpdate(); // ekteloume to sql .Epeidh einai insert h updat ekteloume to 
			//execute update.
			//kaloume apo to pstate thn methodo getGeneratedKeys gia na paroume ta identities.
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {//eprnouem to epomeno identity.
					person.setId(generatedKeys.getInt(1)); //badoume to id sto antikeimeno mas. 
				}
			}
		}
		//to finaly 8a ektelestei panta sto telos tou try oti kai na ginei sto try. 
		finally{
			if(pstate!=null){
				pstate.close();
				
			}
		}

		return person;
	}

	public Person update(Person person) throws SQLException {

		String sql = "update Person set name=? ,surname=?,age=?,address=?,points=? where id = ?  ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setString(1,  person.getName());
			pstate.setString(2, person.getSurname());
			pstate.setInt(3, person.getAge());
			pstate.setString(4, person.getAddress());
			pstate.setInt(5, person.getPoints());
			pstate.setInt(6, person.getId());
			int count = pstate.executeUpdate();//epistrefei to plh8os ton grammon poy exei allaksei
			if (count != 0) {
				return person;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			 
		}
		return null;
	}
	
	public Person delete (Person person) throws SQLException {
		int count  = 0;
		String sql = "  delete from Person where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql );) {
			pstate.setInt(1, person.getId());
			count  = pstate.executeUpdate();
		}
		return person;
	}	


}
