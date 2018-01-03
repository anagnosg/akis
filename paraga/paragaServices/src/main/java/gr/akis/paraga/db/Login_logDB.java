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

import gr.akis.paraga.models.Login_log;
import gr.akis.paraga.models.User;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;

@RequestScoped
public class Login_logDB {
	@Inject
	ConnectionWrapper connWrapper;

	public Login_logDB() {
	}

	/**
	 * Finds all persons
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Login_log> selectAll() throws SQLException {
		List<Login_log> login = new ArrayList<Login_log>();

		String sql = "SELECT ID ,USERNAME FROM  Login_log ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				ResultSet rs = pstate.executeQuery();) {
			while (rs.next()) {

				Login_log l = new Login_log();
				l.setId(rs.getInt("ID"));
				l.setUsername(rs.getString("USERNAME"));
				

				login.add(l);
			}
		}
		return login;
	}

	public List<Login_log> selectUser(String username) throws SQLException {
		List<Login_log> login   = new ArrayList<Login_log>();
		
		String sql = "SELECT ID ,USERNAME FROM  Users " + "where username=?";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				
				
				
				
				) {
			pstate.setString(1,username);
			try(ResultSet rs = pstate.executeQuery();){
			while (rs.next()) {

				Login_log l = new Login_log();
				l.setId(rs.getInt("ID"));
				l.setUsername(rs.getString("USERNAME"));
			
				
				
			    login.add(l);
			}
			}
		}
		return login;
	}

	public Login_log insert(Login_log login) throws SQLException {

		String sql = "INSERT INTO USERS (USERNAME) VALUES (?)";
		                                                                    // orismoume
																			// se
																			// ena
																			// string
																			// thn
																			// sql
																			// pou
																			// 8a
																			// treksoume

		Connection conn = this.connWrapper.getConnection(); // Pernoume mia
															// sundesh
															// (connection) me
															// thn bash
		// apo to connection ekteloume thn methodo prepareStatement kai
		// proetoimazoume thn java
		// gia thn ektelesh ths entolhs sql.
		// Statement.RETURN_GENERATED_KEYS epistrefei ta identities .
		PreparedStatement pstate = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		// to try einai ena block kodika to opoio mporei n apetaksei kapoio
		// exception
		// kai me to try sthn periptosh pou petaksi kapoio exeception ekteloume
		// kapoies leitourgies.
		try {
			pstate.setString(1, login.getUsername()); // pername tis patametrous
			
			pstate.executeUpdate(); // ekteloume to sql .Epeidh einai insert h
									// updat ekteloume to
			// execute update.
			// kaloume apo to pstate thn methodo getGeneratedKeys gia na paroume
			// ta identities.
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {// eprnouem to epomeno identity.
					login.setId(generatedKeys.getInt(1)); // badoume to id sto
															// antikeimeno mas.
				}
			}
		}
		// to finaly 8a ektelestei panta sto telos tou try oti kai na ginei sto
		// try.
		finally {
			if (pstate != null) {
				pstate.close();

			}
		}

		return login;
	}

	public Login_log update(Login_log login) throws SQLException {

		String sql = "update Users set username=? where id = ?  ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setString(1, login.getUsername());
			pstate.setInt(3, login.getId());
			int count = pstate.executeUpdate();// epistrefei to plh8os ton
												// grammon poy exei allaksei
			if (count != 0) {
				return login;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return null;
	}

	public Login_log delete(Login_log login) throws SQLException {
		int count = 0;
		String sql = "  delete from Login_log where id = ? ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, login.getId());
			count = pstate.executeUpdate();
		}
		return login;
	}

}