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

import gr.akis.handsapp.models.Services;
import gr.akis.handsapp.utils.ConnectionWrapper;

@RequestScoped
public class ServicesDb {

	@Inject	
	ConnectionWrapper connWrapper;

	/** 
	 * Finds all persons
	 * 
	 * @return
	 * @throws SQLException
	 */
	
	public List<Services> selectAll() throws SQLException {
		List<Services> service   = new ArrayList<Services>();
		 
		String sql = "SELECT ID , DISABILITY_PLATFORM, WC, PARKIN, OFFER, SYSTEM_BRAILE, DEAF_LANGUAGE, OTHERS FROM  Services ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				ResultSet rs = pstate.executeQuery();) {
			while (rs.next()) {

				Services s = new Services();
				s.setId(rs.getInt("ID"));
				s.setDisability_platform(rs.getBoolean("DISABILITY_PLATFORM"));
				s.setWc(rs.getBoolean("WC"));
				s.setParkin(rs.getBoolean("PARKIN"));
				s.setOffer(rs.getString("OFFER"));
				s.setSystem_braile(rs.getBoolean("SYSTEM_BRAILE"));
				s.setDeaf_language(rs.getBoolean("DEAF_LANGUAGE"));
				s.setOthers(rs.getString("OTHERS"));



			    service.add(s);
			}
		}
		return service;
}
	public Services insert(Services service) throws SQLException {

		String sql = "INSERT INTO SERVICES (DISABILITY_PLATFORM ,WC ,PARKIN ,OFFER ,SYSTEM_BRAILE ,DEAF_LANGUAGE ,OTHERS) VALUES (?,?,?,?,?,?,?)"; //orismoume se ena string thn sql pou 8a treksoume 

		Connection conn = this.connWrapper.getConnection(); // Pernoume mia sundesh (connection) me thn bash
		//apo to connection ekteloume thn methodo prepareStatement kai proetoimazoume thn java 
		//gia thn ektelesh ths entolhs sql.
		//Statement.RETURN_GENERATED_KEYS epistrefei ta identities .
		PreparedStatement pstate = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		//to try einai ena block kodika to opoio mporei n apetaksei kapoio exception 
		//kai me to try sthn periptosh pou petaksi kapoio exeception ekteloume kapoies leitourgies. 
		try {
			pstate.setBoolean(1,service.getDisability_platform()); //pername tis patametrous 
			pstate.setBoolean(2,service.getWc());
			pstate.setBoolean(3,service.getParkin());
			pstate.setString(4,service.getOffer());
			pstate.setBoolean(5,service.getSystem_braile());
			pstate.setBoolean(6,service.getDeaf_language());
			pstate.setString(7,service.getOthers());

			pstate.executeUpdate(); // ekteloume to sql .Epeidh einai insert h updat ekteloume to 
			//execute update.
			//kaloume apo to pstate thn methodo getGeneratedKeys gia na paroume ta identities.
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {//eprnouem to epomeno identity.
					service.setId(generatedKeys.getInt(1)); //badoume to id sto antikeimeno mas. 
				}
			}
		}
		//to finaly 8a ektelestei panta sto telos tou try oti kai na ginei sto try. 
		finally{
			if(pstate!=null){
				pstate.close();
				
			}
		}

		return service;
	}

	public Services update(Services service) throws SQLException {

		String sql = "update Services set disability_platform=? ,wc=? ,parkin=? ,offer=? ,system_braile=? ,deaf_language=? ,others=? where id = ?  ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setBoolean(1,  service.getDisability_platform());
			pstate.setBoolean(2, service.getWc());
			pstate.setBoolean(3, service.getParkin());
			pstate.setString(4, service.getOffer());
			pstate.setBoolean(5, service.getSystem_braile());
			pstate.setBoolean(6, service.getDeaf_language());
			pstate.setString(7, service.getOthers());
			pstate.setInt(8, service.getId());
			int count = pstate.executeUpdate();//epistrefei to plh8os ton grammon poy exei allaksei
			if (count != 0) {
				return service;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			 
		}
		return null;
	}
	
	public Services delete (Services service) throws SQLException {
		int count  = 0;
		String sql = "  delete from Services where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql );) {
			pstate.setInt(1, service.getId());
			count  = pstate.executeUpdate();
		}
		return service;
	}	

 
	
	
	
	
	
	}


