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

import gr.akis.handsapp.models.Person;
import gr.akis.handsapp.models.Team;
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
		public Team insert(Team teams) throws SQLException {

			String sql = "INSERT INTO TEAM (NAME ,ADDRESS) VALUES (?,?)"; //orismoume se ena string thn sql pou 8a treksoume 

			Connection conn = this.connWrapper.getConnection(); // Pernoume mia sundesh (connection) me thn bash
			//apo to connection ekteloume thn methodo prepareStatement kai proetoimazoume thn java 
			//gia thn ektelesh ths entolhs sql.
			//Statement.RETURN_GENERATED_KEYS epistrefei ta identities .
			PreparedStatement pstate = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//to try einai ena block kodika to opoio mporei n apetaksei kapoio exception 
			//kai me to try sthn periptosh pou petaksi kapoio exeception ekteloume kapoies leitourgies. 
			try {
				pstate.setString(1,teams.getName()); //pername tis patametrous 
				pstate.setString(2,teams.getAddress());
				pstate.executeUpdate(); // ekteloume to sql .Epeidh einai insert h updat ekteloume to 
				//execute update.
				//kaloume apo to pstate thn methodo getGeneratedKeys gia na paroume ta identities.
				try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
					if (generatedKeys.next()) {//eprnouem to epomeno identity.
						teams.setId(generatedKeys.getInt(1)); //badoume to id sto antikeimeno mas. 
					}
				}
			}
			//to finaly 8a ektelestei panta sto telos tou try oti kai na ginei sto try. 
			finally{
				if(pstate!=null){
					pstate.close();
					
				}
			}

			return teams;
		}

		public Team update(Team teams) throws SQLException {

			String sql = "update Team set name=? ,address=? where id = ?  ";

			try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
				pstate.setString(1,  teams.getName());
				pstate.setString(2,  teams.getAddress());
				pstate.setInt(3, teams.getId());
				int count = pstate.executeUpdate();//epistrefei to plh8os ton grammon poy exei allaksei
				if (count != 0) {
					return  teams;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				 
			}
			return null;
		}
		
		public Team delete (Team teams) throws SQLException {
			int count  = 0;
			String sql = "  delete from Team where id = ?      ";
			try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql );) {
				pstate.setInt(1, teams.getId());
				count  = pstate.executeUpdate();
			}
			return teams;
		}	
	
		
		
		
	
	}


