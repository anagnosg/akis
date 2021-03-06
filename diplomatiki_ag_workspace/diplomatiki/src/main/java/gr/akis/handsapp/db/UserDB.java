package gr.akis.handsapp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import gr.akis.handsapp.models.User.Token;
import gr.akis.handsapp.models.User.Response.User;
import gr.akis.handsapp.utils.ConnectionWrapper;

@RequestScoped
public class UserDB {
	@Inject
	ConnectionWrapper connWrapper;

	public UserDB() {
	}

	public List<User> selectAll() throws SQLException {
		List<User> users = new ArrayList<User>();

		String sql = "SELECT ID ,USERNAME,PASSWORD FROM  USERS ";

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

	public User selectUser(String username, String password, int userId) throws SQLException {

		String sql = "SELECT ID ,USERNAME,PASSWORD,AGE,REGION_ID,EMAIL FROM  USERS ";
		if (userId != 0) {
			sql += "where ID=?";
		} else {
			sql += "where username=? and password=?";
		}

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			if (userId != 0) {
				pstate.setInt(1, userId);
			} else {
				pstate.setString(1, username);
				pstate.setString(2, password);
			}

			try (ResultSet rs = pstate.executeQuery();) {
				if (rs.next()) {

					User u = new User();
					u.setId(rs.getInt("ID"));
					u.setUsername(rs.getString("USERNAME"));
					u.setAge(rs.getInt("AGE"));
					u.setEmail(rs.getString("EMAIL"));
					return u;
				}
			}
		}
		return null;
	}

	public User insert(User users) throws SQLException {
		String sql = "INSERT INTO USERS (USERNAME ,PASSWORD,REGION_ID,EMAIL,AGE) " + "VALUES (?,?,?,?,?)";
		// orismoume se ena string thn sql pou 8a treksoume
		// Pernoume mia sundesh (connection) me thn bash
		Connection conn = this.connWrapper.getConnection();
		// apo to connection ekteloume thn methodo prepareStatement kai proetoimazoume
		// thn java
		// gia thn ektelesh ths entolhs sql. Statement.RETURN_GENERATED_KEYS epistrefei
		// ta identities .
		PreparedStatement pstate = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		// to try einai ena block kodika to opoio mporei n apetaksei kapoio exception
		// kai me to try sthn periptosh pou petaksi kapoio exeception ekteloume
		// kapoies leitourgies.
		try {
			// pername tis patametrous
			pstate.setString(1, users.getUsername());
			pstate.setString(2, users.getPassword());
			pstate.setInt(3, users.getRegionId());
			pstate.setString(4, users.getEmail());
			pstate.setInt(5, users.getAge());
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

		String sql = "update USERS set username=? ,password=? where id = ?  ";

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

	public Integer delete(Integer userId) throws SQLException {
		int count = 0;
		String sql = "  delete from USERS where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, userId);
			count = pstate.executeUpdate();
		}
		return userId;
	}

	public Token selectToken(String tokenString) throws SQLException {
		String sql = "SELECT ID,TOKEN ,USERID,EXPIRE FROM  TOKENS where TOKEN = ? and EXPIRE > ? ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {

			pstate.setString(1, tokenString);
			Timestamp time = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
			pstate.setTimestamp(2, time);
			try (ResultSet rs = pstate.executeQuery();) {
				if (rs.next()) {

					Token t = new Token();
					t.setId(rs.getInt("ID"));
					t.setUserId(rs.getInt("USERID"));

					return t;
				}
			}
		}
		return null;

	}

	public Token insertToken(Token token) throws SQLException {
		String sql = "INSERT INTO TOKENS (TOKEN ,USERID,EXPIRE) " + "VALUES (?,?,?)";
		Connection conn = this.connWrapper.getConnection();
		PreparedStatement pstate = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		try {
			pstate.setString(1, token.getToken());
			pstate.setInt(2, token.getUserId());
			Timestamp time = new java.sql.Timestamp(token.getExpire().getTimeInMillis());
			pstate.setTimestamp(3, time);
			pstate.executeUpdate();
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					
					token.setId(generatedKeys.getInt(1));
				}
			}
		}
	
		finally {
			if (pstate != null) {
				pstate.close();
			}
		}
		return token;
	}

	public void deleteTokens(Integer userId) throws SQLException {
		int count = 0;
		String sql = "  delete from Tokens where USERID = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, userId);
			count = pstate.executeUpdate();
		}
	}
}
