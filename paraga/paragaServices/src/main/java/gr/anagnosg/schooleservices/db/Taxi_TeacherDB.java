package gr.anagnosg.schooleservices.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;
import gr.anagnosg.schoolservices.models.Classi;

@RequestScoped
public class Taxi_TeacherDB {

	@Inject
	ConnectionWrapper connWrapper;

	public void insert(int Taxi_ID, int Teacher_ID) throws SQLException {
		String sql = "Insert TAXI_TEACHER(ID_TAXI ,ID_TEACHER)VALUES(?,?)";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {

			pstate.setInt(1, Taxi_ID);
			pstate.setInt(2, Teacher_ID);
			pstate.executeUpdate();

		}

	}
}
