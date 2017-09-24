package gr.anagnosg.schooleservices.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;


	@RequestScoped
	public class Taxi_MathitisDB {

		@Inject
		ConnectionWrapper connWrapper;

		public void insert(int Taxi_ID, int Mathitis_ID) throws SQLException {
			String sql = "Insert TAXI_MATHITIS(ID_TAXI ,ID_MATHITIS)VALUES(?,?)";
			try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {

				pstate.setInt(1, Taxi_ID);
				pstate.setInt(2, Mathitis_ID);
				pstate.executeUpdate();

			}

		}
	
	}



