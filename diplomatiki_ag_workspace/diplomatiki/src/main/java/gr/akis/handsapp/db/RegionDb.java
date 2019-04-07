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
import gr.akis.handsapp.utils.ConnectionWrapper;

@RequestScoped
public class RegionDb {

	@Inject
	ConnectionWrapper connWrapper;

	public List<Region> selectAll() throws SQLException {
		List<Region> region = new ArrayList<Region>();

		String sql = "SELECT ID , DESCRIPTION FROM  REGIONS ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				ResultSet rs = pstate.executeQuery();) {
			while (rs.next()) {

				Region r = new Region();
				r.setId(rs.getInt("ID"));
				r.setDescription(rs.getString("DESCRIPTION"));
				region.add(r);
			}
		}
		return region;
	}

	public Region insert(Region region) throws SQLException {

		String sql = "INSERT INTO REGIONS (DESCRIPTION)" + " VALUES (?)";

		Connection conn = this.connWrapper.getConnection();
		PreparedStatement pstate = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		try {
			pstate.setString(1, region.getDescription());
			pstate.executeUpdate();
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {// eprnouem to epomeno identity.
					region.setId(generatedKeys.getInt(1)); // badoume to id sto antikeimeno mas.
				}
			}
		} finally {
			if (pstate != null) {
				pstate.close();
			}
		}
		return region;
	}

	public Region update(Region region) throws SQLException {

		String sql = "update REGIONS set DESCRIPTION=? where ID = ?  ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setString(1, region.getDescription());
			pstate.setInt(2, region.getId());
			int count = pstate.executeUpdate();// epistrefei to plh8os ton grammon poy exei allaksei
			if (count != 0) {
				return region;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return null;
	}

	public Integer delete(Integer region) throws SQLException {
		int count = 0;
		String sql = "  delete from REGIONS where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, region);
			count = pstate.executeUpdate();
		}
		return region;
	}

}
