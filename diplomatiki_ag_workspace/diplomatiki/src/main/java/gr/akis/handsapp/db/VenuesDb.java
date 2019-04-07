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
import gr.akis.handsapp.models.Venues;
import gr.akis.handsapp.utils.ConnectionWrapper;

@RequestScoped
public class VenuesDb {

	@Inject
	ConnectionWrapper connWrapper;

	/**
	 * Finds all persons
	 * 
	 * @return
	 * @throws SQLException
	 */

	public List<Venues> selectAll() throws SQLException {
		List<Venues> venue = new ArrayList<Venues>();

		String sql = "SELECT ID , ID_VENUES, RESTAURANTS, CAFE_BAR, CINEMA_THEATER, FESTIVALS, SPORTS, HEALTH, MUSEUM, PUBLIC_SERVICES, HOTEL,"
				+ " STORES, SUPER_MARKET, TRANSPORTS FROM  Venues ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				ResultSet rs = pstate.executeQuery();) {
			while (rs.next()) {

				Venues v = new Venues();
				v.setId(rs.getInt("ID"));
				v.setId_venues(rs.getInt("ID_VENUES"));
				v.setRestaurants(rs.getString("RESTAURANTS"));
				v.setCafe_bar(rs.getString("CAFE_BAR"));
				v.setCinema_theater(rs.getString("CINEMA_THEATER"));
				v.setFestivals(rs.getString("FESTIVALS"));
				v.setSports(rs.getString("SPORTS"));
				v.setHealth(rs.getString("HEALTH"));
				v.setMuseum(rs.getString("MUSEUM"));
				v.setPublic_services(rs.getString("PUBLIC_SERVICES"));
				v.setHotel(rs.getString("HOTEL"));
				v.setStores(rs.getString("STORES"));
				v.setSuper_market(rs.getString("SUPER_MARKET"));
				v.setTransports(rs.getString("TRANSPORTS"));

				venue.add(v);
			}
		}
		return venue;
	}

	public Venues insert(Venues venue) throws SQLException {

		String sql = "INSERT INTO VENUES (ID_VENUES ,RESTAURANTS ,CAFE_BAR ,CINEMA_THEATER ,FESTIVALS ,SPORTS ,HEALTH, MUSEUM, PUBLIC_SERVICES, HOTEL, "
				+ "STORES, SUPER_MARKET, TRANSPORTS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"; // orismoume se ena string thn
																							// sql pou 8a treksoume

		Connection conn = this.connWrapper.getConnection(); // Pernoume mia sundesh (connection) me thn bash
		// apo to connection ekteloume thn methodo prepareStatement kai proetoimazoume
		// thn java
		// gia thn ektelesh ths entolhs sql.
		// Statement.RETURN_GENERATED_KEYS epistrefei ta identities .
		PreparedStatement pstate = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		// to try einai ena block kodika to opoio mporei n apetaksei kapoio exception
		// kai me to try sthn periptosh pou petaksi kapoio exeception ekteloume kapoies
		// leitourgies.
		try {
			pstate.setInt(1, venue.getId_venues()); // pername tis patametrous
			pstate.setString(2, venue.getRestaurants());
			pstate.setString(3, venue.getCafe_bar());
			pstate.setString(4, venue.getCinema_theater());
			pstate.setString(5, venue.getFestivals());
			pstate.setString(6, venue.getSports());
			pstate.setString(7, venue.getHealth());
			pstate.setString(8, venue.getMuseum());
			pstate.setString(9, venue.getPublic_services());
			pstate.setString(10, venue.getHotel());
			pstate.setString(11, venue.getStores());
			pstate.setString(12, venue.getSuper_market());
			pstate.setString(13, venue.getTransports());

			pstate.executeUpdate(); // ekteloume to sql .Epeidh einai insert h updat ekteloume to
			// execute update.
			// kaloume apo to pstate thn methodo getGeneratedKeys gia na paroume ta
			// identities.
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {// eprnouem to epomeno identity.
					venue.setId(generatedKeys.getInt(1)); // badoume to id sto antikeimeno mas.
				}
			}
		}
		// to finaly 8a ektelestei panta sto telos tou try oti kai na ginei sto try.
		finally {
			if (pstate != null) {
				pstate.close();

			}
		}

		return venue;
	}

	public Venues update(Venues venue) throws SQLException {

		String sql = "update Venues set id_venues=? ,restaurants=? ,cafe_bar=? ,cinema_theater=? ,festivals=? ,sports=? ,health=? ,museum=? ,public_services=? "
				+ " ,hotel=? ,stores=? ,super_market=? ,transports=? ,where id = ?  ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, venue.getId_venues());
			pstate.setString(2, venue.getRestaurants());
			pstate.setString(3, venue.getCafe_bar());
			pstate.setString(4, venue.getCinema_theater());
			pstate.setString(5, venue.getFestivals());
			pstate.setString(6, venue.getSports());
			pstate.setString(7, venue.getHealth());
			pstate.setString(8, venue.getMuseum());
			pstate.setString(9, venue.getPublic_services());
			pstate.setString(10, venue.getHotel());
			pstate.setString(11, venue.getStores());
			pstate.setString(12, venue.getSuper_market());
			pstate.setString(13, venue.getTransports());
			pstate.setInt(14, venue.getId());
			int count = pstate.executeUpdate();// epistrefei to plh8os ton grammon poy exei allaksei
			if (count != 0) {
				return venue;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return null;
	}

	public Venues delete(Venues venue) throws SQLException {
		int count = 0;
		String sql = "  delete from Services where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, venue.getId());
			count = pstate.executeUpdate();
		}
		return venue;
	}

}
