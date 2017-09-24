package gr.akis.paraga.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.paraga.models.Person;
import gr.akis.paraga.models.Team;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;



	@RequestScoped
	public class TeamDB {

		@Inject
		ConnectionWrapper connWrapper;

		public void TeamDB() {
		}
		
		
		
		/** 
		 * Finds all persons
		 * 
		 * @return
		 * @throws SQLException
		 */
		public List<Team> selectAll() throws SQLException {
			List<Team> teams   = new ArrayList<Team>();
			
			String sql = "SELECT ID ,NAME,ADDRESS FROM  Team ";

			try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
					ResultSet rs = pstate.executeQuery();) {
				while (rs.next()) {

					Team t = new Team();
					t.setId(rs.getInt("ID"));
					t.setAddress(rs.getString("NAME"));
					t.setName(rs.getString("ADDRESS"));
					
					
				    teams.add(t);
				}
			}
			return teams;
		}	
	
	}


