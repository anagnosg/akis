package gr.akis.handsapp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

//import org.jboss.security.auth.spi.Users;

import gr.akis.handsapp.models.Team;
import gr.akis.handsapp.models.User;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;

@RequestScoped
public class UserDB {
	@Inject
	ConnectionWrapper connWrapper;

	public UserDB() {
	}

	/**
	 * Finds all users
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<User> selectAll() throws SQLException {
		List<User> users = new ArrayList<User>();

		String sql = "SELECT ID ,USERNAME,PASSWORD FROM  Users ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				ResultSet rs = pstate.executeQuery();) {
			while (rs.next()) {

				User u = new User();
				u.setId(rs.getInt("ID"));
				u.setPassword(rs.getString("USERNAME"));
				u.setUsername(rs.getString("PASSWORD"));

				users.add(u);
			}
		}
		return users;
	}

	public List<User> selectUser(String username, String password) throws SQLException {
		List<User> users = new ArrayList<User>();

		String sql = "SELECT ID ,USERNAME,PASSWORD FROM  Users " + "where username=? and password=?";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);

		) {
			pstate.setString(1, username);
			pstate.setString(2, password);
			try (ResultSet rs = pstate.executeQuery();) {
				while (rs.next()) {

					User u = new User();
					u.setId(rs.getInt("ID"));
					u.setPassword(rs.getString("USERNAME"));
					u.setUsername(rs.getString("PASSWORD"));

					users.add(u);
				}
			}
		}
		return users;
	}

	public User insert(User users) throws SQLException {

		String sql = "INSERT INTO USERS (USERNAME ,PASSWORD) VALUES (?,?)";
		// orismoume se ena string thn sql pou 8a treksoume
		// Pernoume mia sundesh (connection) me thn bash
		Connection conn = this.connWrapper.getConnection(); 
		// apo to connection ekteloume thn methodo prepareStatement kai proetoimazoume thn java
		// gia thn ektelesh ths entolhs sql. Statement.RETURN_GENERATED_KEYS epistrefei ta identities .
		PreparedStatement pstate = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		// to try einai ena block kodika to opoio mporei n apetaksei kapoio exception
		// kai me to try sthn periptosh pou petaksi kapoio exeception ekteloume
		// kapoies leitourgies.
		try {
			// pername tis patametrous
			pstate.setString(1, users.getUsername()); 
			pstate.setString(2, users.getPassword());
			// ekteloume to sql .Epeidh einai insert h updat ekteloume to
			pstate.executeUpdate(); 
			// execute update.
			// kaloume apo to pstate thn methodo getGeneratedKeys gia na paroume
			// ta identities.
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					// eprnouem to epomeno identity. badoume to id sto antikeimeno mas.
					users.setId(generatedKeys.getInt(1)); 
				}
			}
		}
		// to finaly 8a ektelestei panta sto telos tou try oti kai na ginei sto try
		finally {
			if (pstate != null) {
				pstate.close();

			}
		}

		return users;
	}

	public User update(User users) throws SQLException {

		String sql = "update Users set username=? ,password=? where id = ?  ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setString(1, users.getUsername());
			pstate.setString(2, users.getPassword());
			pstate.setInt(3, users.getId());
			int count = pstate.executeUpdate();// epistrefei to plh8os ton grammon poy exei allaksei
			if (count != 0) {
				return users;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return null;
	}

	public User delete(User users) throws SQLException {
		int count = 0;
		String sql = "  delete from Users where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, users.getId());
			count = pstate.executeUpdate();
		}
		return users;
	}

}
