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
import gr.akis.handsapp.models.Service.Responses.Service;
import gr.akis.handsapp.models.Venue.Responses.Venues;
import gr.akis.handsapp.models.VenueCategory.Responses.VenueCategory;
import gr.akis.handsapp.utils.ConnectionWrapper;

@RequestScoped
public class VenuesDb {

	@Inject
	ConnectionWrapper connWrapper;

	public List<Venues> selectAll() throws SQLException {
		return select(null);
	}

	public Venues selectById(Integer id) throws SQLException {
		List<Venues> v = select(id);
		if (v != null && v.size() > 0) {
			return v.get(0);
		}
		return null;
	}

	public List<Venues> select(Integer id) throws SQLException {
		List<Venues> venue = new ArrayList<Venues>();

		String sql = " SELECT a.ID as ID,a.DESCRIPTION as DESCRIPTION,a.ADDRESS,a.SUMMARY\r\n"
				+ "	,b.ID as CATEGORYID,b.DESCRIPTION as CATEGORY,c.ID as REGIONID,c.DESCRIPTION as REGION\r\n"
				+ "  FROM  VENUES a\r\n" + "  inner join VENUE_CATEGORIES b \r\n" + "  on a.CATEGORY_ID = b.ID\r\n"
				+ "  inner join REGIONS c \r\n" + "  on a.REGION_ID = c.ID";

		if (id != null) {
			sql += " Where a.ID = ? ";
		}
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			if (id != null) {
				pstate.setInt(1, id);
			}

			try (ResultSet rs = pstate.executeQuery();) {
				while (rs.next()) {

					Venues v = new Venues();
					v.setId(rs.getInt("ID"));
					v.setDescription(rs.getString("DESCRIPTION"));
					v.setAddress(rs.getString("ADDRESS"));
					v.setSummary(rs.getString("SUMMARY"));
					v.setCategoryId(rs.getInt("CATEGORYID"));
					v.setRegionId(rs.getInt("REGIONID"));
					VenueCategory vc = new VenueCategory();
					vc.setId(rs.getInt("CATEGORYID"));
					vc.setDescription(rs.getString("CATEGORY"));
					v.setCategory(vc);
					Region r = new Region();
					r.setId(rs.getInt("REGIONID"));
					r.setDescription(rs.getString("REGION"));
					v.setRegion(r);

					List<Service> services = selectServiceOfVenue(id);
					List<Integer> serviceIds = new ArrayList<Integer>();
					for (int i = 0; i < services.size(); i++) {
						serviceIds.add(services.get(i).getId());
					}
					v.setServices(services);
					v.setServiceIds(serviceIds);
					venue.add(v);
				}
			}
		}
		return venue;
	}

	public List<Service> selectServiceOfVenue(Integer venueId) throws SQLException {
		List<Service> services = new ArrayList<Service>();

		String sql = "Select * from   \r\n" + "  VENUES_HAVE_SERVICES d\r\n" + "  inner join SERVICES e\r\n"
				+ "  on d.SERVICE_ID = e.ID\r\n" + "  where d.VENUE_ID= ?";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, venueId);
			try (ResultSet rs = pstate.executeQuery();) {
				while (rs.next()) {

					Service s = new Service();
					s.setId(rs.getInt("ID"));
					s.setDescription(rs.getString("DESCRIPTION"));

					services.add(s);
				}
			}
		}
		return services;
	}

	public void addServiceToVenue(Integer venueId, Integer servicesId) throws SQLException {
		String sql = "INSERT INTO VENUES_HAVE_SERVICES (VENUE_ID,SERVICE_ID) " + " VALUES (?,?) ";

		Connection conn = this.connWrapper.getConnection();
		PreparedStatement pstate = conn.prepareStatement(sql);

		try {
			pstate.setInt(1, venueId); // pername tis patametrous
			pstate.setInt(2, servicesId);
			pstate.executeUpdate();

		} finally {
			if (pstate != null) {
				pstate.close();
			}
		}
	}

	public Venues insert(Venues venue) throws SQLException {

		String sql = "INSERT INTO VENUES (DESCRIPTION ,CATEGORY_ID ,REGION_ID ,ADDRESS ,SUMMARY) "
				+ " VALUES (?,?,?,?,?) ";

		Connection conn = this.connWrapper.getConnection();
		PreparedStatement pstate = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		try {
			pstate.setString(1, venue.getDescription()); // pername tis patametrous
			pstate.setInt(2, venue.getCategoryId());
			pstate.setInt(3, venue.getRegionId());
			pstate.setString(4, venue.getAddress());
			pstate.setString(5, venue.getSummary());

			pstate.executeUpdate();
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					venue.setId(generatedKeys.getInt(1));
				}
			}
		} finally {
			if (pstate != null) {
				pstate.close();
			}
		}
		if (venue.getServiceIds() != null) {
			// Add Services
			for (int i = 0; i < venue.getServiceIds().size(); i++) {
				int serviceId = venue.getServiceIds().get(i);
				addServiceToVenue(venue.getId(), serviceId);
			}
		}

		venue = selectById(venue.getId());
		return venue;
	}

	public Venues update(Venues venue) throws SQLException {

		String sql = "update Venues set DESCRIPTION=? ,CATEGORY_ID=? ,REGION_ID=? ,ADDRESS=? ,SUMMARY=? "
				+ " where id = ?  ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setString(1, venue.getDescription());
			pstate.setInt(2, venue.getCategory().getId());
			pstate.setInt(3, venue.getRegion().getId());
			pstate.setString(4, venue.getAddress());
			pstate.setString(5, venue.getSummary());
			int count = pstate.executeUpdate();// epistrefei to plh8os ton grammon poy exei allaksei
			if (count != 0) {
				return venue;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Integer delete(Integer venue) throws SQLException {
		int count = 0;
		String sql = "  delete from Venues where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, venue);
			count = pstate.executeUpdate();
		}
		return venue;
	}
}
