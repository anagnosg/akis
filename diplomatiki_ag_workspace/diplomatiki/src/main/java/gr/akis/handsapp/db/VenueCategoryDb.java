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
import gr.akis.handsapp.models.Region.Responses.Region;
import gr.akis.handsapp.models.VenueCategory.Responses.VenueCategory;
import gr.akis.handsapp.utils.ConnectionWrapper;

@RequestScoped
public class VenueCategoryDb {

	@Inject
	ConnectionWrapper connWrapper;

	public List<VenueCategory> selectAll() throws SQLException {
		List<VenueCategory> categories = new ArrayList<VenueCategory>();

		String sql = "SELECT ID , DESCRIPTION FROM  VENUE_CATEGORIES ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				ResultSet rs = pstate.executeQuery();) {
			while (rs.next()) {

				VenueCategory r = new VenueCategory();
				r.setId(rs.getInt("ID"));
				r.setDescription(rs.getString("DESCRIPTION"));
				categories.add(r);
			}
		}
		return categories;
	}

	public VenueCategory insert(VenueCategory category) throws SQLException {

		String sql = "INSERT INTO VENUE_CATEGORIES (DESCRIPTION)" + " VALUES (?)";

		Connection conn = this.connWrapper.getConnection();
		PreparedStatement pstate = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		try {
			pstate.setString(1, category.getDescription());
			pstate.executeUpdate();
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {// eprnouem to epomeno identity.
					category.setId(generatedKeys.getInt(1)); // badoume to id sto antikeimeno mas.
				}
			}
		} finally {
			if (pstate != null) {
				pstate.close();
			}
		}
		return category;
	}

	public VenueCategory update(VenueCategory category) throws SQLException {

		String sql = "update REGIONS set DESCRIPTION=? where ID = ?  ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setString(1, category.getDescription());
			pstate.setInt(2, category.getId());
			int count = pstate.executeUpdate();// epistrefei to plh8os ton grammon poy exei allaksei
			if (count != 0) {
				return category;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return null;
	}

	public Integer delete(Integer category) throws SQLException {
		int count = 0;
		String sql = "  delete from VENUE_CATEGORIES where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, category);
			count = pstate.executeUpdate();
		}
		return category;
	}

}
