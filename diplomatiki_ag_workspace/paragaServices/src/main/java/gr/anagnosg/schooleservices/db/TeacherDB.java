package gr.anagnosg.schooleservices.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import gr.anagnosg.schoolservices.models.Teacher;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;
import gr.anagnosg.schoolservices.models.ResponseModel;
import gr.anagnosg.schoolservices.models.Student;

@RequestScoped
public class TeacherDB {
	@Inject
	ConnectionWrapper connWrapper;

	public TeacherDB(){}
	
	public List<Teacher> selectAll() throws SQLException {
		List<Teacher> teachers = new ArrayList<Teacher>();

		String sql = "SELECT  ID , NAME , SURNAME ,  AGE FROM  Teacher ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				ResultSet rs = pstate.executeQuery();) {
			while (rs.next()) {

				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("ID"));
				teacher.setName(rs.getString("NAME"));
				teacher.setSurname(rs.getString("SURNAME"));
				teacher.setAge(rs.getInt("AGE"));
				teachers.add(teacher);
			}
		}
		return teachers;
	}

	// h parakatw synartisi eisagei ena adikeimeno teacher.
	public Teacher insert(Teacher teacher) throws SQLException {
		// orizoume ena string sql kai thetoume timh to parakatw. "INSERT INTO
		// Teacher.....
		// sto string mas sql ta erotimatika einai ta oi parametroi pou dexete
		// to prepard statement.
		String sql = "INSERT INTO Teacher (NAME,SURNAME,AGE) " + " VALUES (?,?,?)";
		// h edolh pou vriskete mesa sto try dhmiourgei ena adikeimeno prepard
		// statement me onoma pstate.
		// h methodos prepard statement pou ekteleite pernei san orisma to sql
		// pou orisame parapanw.
		// san deuterh parametros pernei to Statement.RETURN_GENERATED_KEYS pou
		// epistrefei to id pou kanei generate th vash apo monh ths.

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);) {
			// sto adikeimeno mas pstate vazoume sa parametro prwth to onoma tou
			// teacher,pou to pernoume apo to input mas teacher
			// o typos ths parametrou einai string gia auto xrhsimopoioume
			// setString.
			pstate.setString(1, teacher.getName());
			// san deutrh to surname
			pstate.setString(2, teacher.getSurname());
			// san trith parametro to Age kai xrhsimopoioume int
			pstate.setInt(3, teacher.getAge());
			// kaloume thn methodo executeUpdate kai ekteloume to sql.
			pstate.executeUpdate();

			// epeidh exoume orisei Statement.RETURN_GENERATED_KEYS kaloume thn
			// getGeneratedKeys(),h opoia mas epistrefei ena resultSet
			// apo to opoio mporoume na paroume to id pou exei kanei h Generated
			// vash.
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				// pernoume to epomeno ean yparxei apotelesma tou ResultSet
				if (generatedKeys.next()) {
					// thetoume sto input adikeimeno mas teacher to id ths
					// vashs.
					teacher.setId(generatedKeys.getInt(1));
				}
			}
		}

		return teacher;
	}

	public Teacher update(Teacher teacher) throws SQLException {

		String sql = "update Mathites set name=? , surname = ?, age = ?  where id = ?  ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setString(1, teacher.getName());
			pstate.setString(2, teacher.getSurname());
			pstate.setInt(3, teacher.getAge());
			pstate.setInt(4, teacher.getId());
			int count = pstate.executeUpdate();// epistrefei to plh8os ton
												// grammon poy exei allaksei
			if (count != 0) {
				return teacher;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return null;
	}

	public Teacher delete(Teacher teacher) throws SQLException {
		int count = 0;
		String sql = "  delete from Mathites where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, teacher.getId());
			count = pstate.executeUpdate();
		}
		return teacher;
	}

}