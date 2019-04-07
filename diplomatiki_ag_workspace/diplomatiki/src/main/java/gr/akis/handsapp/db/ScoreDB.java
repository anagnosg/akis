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

import gr.akis.handsapp.models.Score.Responses.Score;
import gr.akis.handsapp.utils.ConnectionWrapper;

@RequestScoped
public class ScoreDB {

	@Inject
	ConnectionWrapper connWrapper;

	public void ScoreDB() {
	}

	public List<Score> selectAll() throws SQLException {
		return select(null);
	}

	public List<Score> select(Integer venueId) throws SQLException {
		List<Score> vathmologia = new ArrayList<Score>();

		String sql = "SELECT USER_ID,VENUE_ID,SCORE,COMMENT FROM SCORES ";
		if (venueId != null) {
			sql += " Where VENUE_ID=?";
		}

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			if (venueId != null) {
				pstate.setInt(1, venueId);
			}
			try (ResultSet rs = pstate.executeQuery();) {
				while (rs.next()) {

					Score v = new Score();
					v.setUserId(rs.getInt("USER_ID"));
					v.setVenueId(rs.getInt("VENUE_ID"));
					v.setComment(rs.getString("COMMENT"));
					v.setScore(rs.getInt("SCORE"));

					vathmologia.add(v);
				}
			}
		}
		return vathmologia;
	}

	public Score insert(Score vathmologia) throws SQLException {

		String sql = "INSERT INTO SCORES (USER_ID,VENUE_ID,SCORE,COMMENT ) " + "VALUES (?,?,?,?)";

		Connection conn = this.connWrapper.getConnection();

		PreparedStatement pstate = conn.prepareStatement(sql);

		try {
			pstate.setInt(1, vathmologia.getUserId());
			pstate.setInt(2, vathmologia.getVenueId());
			pstate.setInt(3, vathmologia.getScore());
			pstate.setString(4, vathmologia.getComment());

			pstate.executeUpdate();
		}

		finally {
			if (pstate != null) {
				pstate.close();

			}
		}

		return vathmologia;
	}

	public void delete(Integer userId, Integer venueId) throws SQLException {
		int count = 0;
		String sql = "  delete from SCORES where USER_ID = ?   AND   VENUE_ID = ?  ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, userId);
			pstate.setInt(2, venueId);
			count = pstate.executeUpdate();
		}
	}

}
