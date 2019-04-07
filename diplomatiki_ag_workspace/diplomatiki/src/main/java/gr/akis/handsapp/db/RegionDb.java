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

import gr.akis.handsapp.models.Region;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;

@RequestScoped
public class RegionDb {

	@Inject
	ConnectionWrapper connWrapper;
	

	/** 
	 * Finds all persons
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Region> selectAll() throws SQLException {
		List<Region> region   = new ArrayList<Region>();
		 
		String sql = "SELECT ID , ID_REGION,REGION_NAME FROM  Region ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				ResultSet rs = pstate.executeQuery();) {
			while (rs.next()) {

				Region r = new Region();
				r.setId(rs.getInt("ID"));
				r.setId_region(rs.getInt("ID_REGION"));
				r.setRegion_name(rs.getString("REGION_NAME"));
			    region.add(r);
			}
		}
		return region;
}
	public Region insert(Region region) throws SQLException {

		String sql = "INSERT INTO REGION (ID_REGION ,REGION_NAME) VALUES (?,?)"; //orismoume se ena string thn sql pou 8a treksoume 

		Connection conn = this.connWrapper.getConnection(); // Pernoume mia sundesh (connection) me thn bash
		//apo to connection ekteloume thn methodo prepareStatement kai proetoimazoume thn java 
		//gia thn ektelesh ths entolhs sql.
		//Statement.RETURN_GENERATED_KEYS epistrefei ta identities .
		PreparedStatement pstate = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		//to try einai ena block kodika to opoio mporei n apetaksei kapoio exception 
		//kai me to try sthn periptosh pou petaksi kapoio exeception ekteloume kapoies leitourgies. 
		try {
			pstate.setInt(1,region.getId_region()); //pername tis patametrous 
			pstate.setString(2,region.getRegion_name());
			pstate.executeUpdate(); // ekteloume to sql .Epeidh einai insert h updat ekteloume to 
			//execute update.
			//kaloume apo to pstate thn methodo getGeneratedKeys gia na paroume ta identities.
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {//eprnouem to epomeno identity.
					region.setId(generatedKeys.getInt(1)); //badoume to id sto antikeimeno mas. 
				}
			}
		}
		//to finaly 8a ektelestei panta sto telos tou try oti kai na ginei sto try. 
		finally{
			if(pstate!=null){
				pstate.close();
				
			}
		}

		return region;
	}

	public Region update(Region region) throws SQLException {

		String sql = "update Region set id_region=? ,region_name=? where id = ?  ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1,  region.getId_region());
			pstate.setString(2, region.getRegion_name());
			pstate.setInt(3, region.getId());
			int count = pstate.executeUpdate();//epistrefei to plh8os ton grammon poy exei allaksei
			if (count != 0) {
				return region;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			 
		}
		return null;
	}
	
	public Region delete (Region region) throws SQLException {
		int count  = 0;
		String sql = "  delete from Region where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql );) {
			pstate.setInt(1, region.getId());
			count  = pstate.executeUpdate();
		}
		return region;
	}	

 
	
	}


