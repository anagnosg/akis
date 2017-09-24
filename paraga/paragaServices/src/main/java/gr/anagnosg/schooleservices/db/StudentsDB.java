package gr.anagnosg.schooleservices.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import javax.sql.DataSource;

import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;
import gr.anagnosg.employeeservices.exceptions.BusinessException;

import gr.anagnosg.schoolservices.models.Student;
import gr.anagnosg.schoolservices.models.Skill;

@RequestScoped
public class StudentsDB {

	@Inject
	ConnectionWrapper connWrapper;

	public void SchoolDB() {
	}

	/**
	 * Finds all students
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Student> selectAll() throws SQLException {
		List<Student> students = new ArrayList<Student>();
		;
		String sql = "SELECT  ID , NAME , SURNAME , EMAIL , ADDRESS , PHONE , AGE FROM   MATHITES ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				ResultSet rs = pstate.executeQuery();) {
			while (rs.next()) {

				Student student = new Student();
				student.setId(rs.getInt("ID"));
				student.setName(rs.getString("NAME"));
				student.setSurname(rs.getString("SURNAME"));
				student.setEmail(rs.getString("EMAIL"));
				student.setAddress(rs.getString("ADDRESS"));
				student.setPhone(rs.getString("PHONE"));
				student.setAge(rs.getInt("AGE"));
				students.add(student);
			}
		}
		return students;
	}

	public Student insert(Student st) throws SQLException {

		String sql = "INSERT INTO MATHITES   (NAME,SURNAME,EMAIL,ADDRESS,PHONE,AGE) " + " VALUES (?,?,?,?,?,?)";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);) {
			pstate.setString(1, st.getName());
			pstate.setString(2, st.getSurname());
			pstate.setString(3, st.getEmail());
			pstate.setString(4, st.getAddress());
			pstate.setString(5, st.getPhone());
			pstate.setInt(6, st.getAge());
			pstate.executeUpdate();
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					st.setId(generatedKeys.getInt(1));
				}
			}
		}

		return st;
	}

	public Student update(Student st) throws SQLException {

		String sql = "update Mathites set name=? , surname = ? , email = ? , address = ? "+
		", phone = ? , age = ? where id = ?  ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setString(1,  st.getName());
			pstate.setString(2, st.getSurname());
			pstate.setString(3, st.getEmail());
			pstate.setString(4, st.getAddress());
			pstate.setString(5, st.getPhone());
			pstate.setInt(6, st.getAge());
			pstate.setInt(7, st.getId());
			int count = pstate.executeUpdate();//epistrefei to plh8os ton grammon poy exei allaksei
			if (count != 0) {
				return st;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			 
		}
		return null;
	}
	
	public Student delete (Student st) throws SQLException {
		int count  = 0;
		String sql = "  delete from Mathites where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql );) {
			pstate.setInt(1, st.getId());
			count  = pstate.executeUpdate();
		}
		return st;
	}
}
