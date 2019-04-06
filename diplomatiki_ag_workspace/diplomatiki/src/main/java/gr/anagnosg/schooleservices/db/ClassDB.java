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
public class ClassDB {

	@Inject
	ConnectionWrapper connWrapper;

	public Classi insert(Classi cl) throws SQLException {
		String sql = "INSERT INTO Taxi (Name, ID_SXOLEIO) VALUES (?, ? )";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);) {

			pstate.setString(1, cl.getName());
			pstate.setInt(2, cl.getId_Sxoleio());
			pstate.executeUpdate();
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					cl.setId(generatedKeys.getInt(1));
				}
			}

		}
		return cl;
	}
}