package gr.akis.paraga.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.paraga.models.Team;
import gr.akis.paraga.models.Vathmologia;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;

@RequestScoped
public class VathmologiaDB {

	@Inject
	ConnectionWrapper connWrapper;

	public void VathmologiaDB() {
	}
	
	
	
	/** 
	 * Finds all persons
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Vathmologia> selectAll() throws SQLException {
		List<Vathmologia> vathmologia   = new ArrayList<Vathmologia>();
		
		String sql = "SELECT ID ,BASKET_TEAM,ID_RACE,WIN,LOSE,POINTS FROM Vatmologia_omadwn";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				ResultSet rs = pstate.executeQuery();) {
			while (rs.next()) {

				Vathmologia v = new Vathmologia();
				v.setId(rs.getInt("ID"));
				v.setBasket_team(rs.getString("BASKET_TEAM"));
				v.setId_race(rs.getInt("ID_RACE"));
				v.setWin(rs.getInt("WIN"));
				v.setLose(rs.getInt("LOSE"));
				v.setPoints(rs.getInt("POINTS"));
				
				 vathmologia.add(v);
			}
		}
		return vathmologia;
	}			
}
