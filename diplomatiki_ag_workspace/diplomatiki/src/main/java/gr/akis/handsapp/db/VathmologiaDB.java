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

import gr.akis.handsapp.models.Vathmologia;
import gr.akis.handsapp.utils.ConnectionWrapper;

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
	public Vathmologia insert(Vathmologia vathmologia) throws SQLException {

		String sql = "INSERT INTO VATHMOLOGIA (BASKET_TEAM,ID_RACE,WIN,LOSE,POINTS) VALUES (?,?,?,?,?)"; //orismoume se ena string thn sql pou 8a treksoume 

		Connection conn = this.connWrapper.getConnection(); // Pernoume mia sundesh (connection) me thn bash
		//apo to connection ekteloume thn methodo prepareStatement kai proetoimazoume thn java 
		//gia thn ektelesh ths entolhs sql.
		//Statement.RETURN_GENERATED_KEYS epistrefei ta identities .
		PreparedStatement pstate = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		//to try einai ena block kodika to opoio mporei n apetaksei kapoio exception 
		//kai me to try sthn periptosh pou petaksi kapoio exeception ekteloume kapoies leitourgies. 
		try {
			pstate.setString(1,vathmologia.getBasket_team()); //pername tis patametrous 
			pstate.setInt(2,vathmologia.getId_race());
			pstate.setInt(3,vathmologia.getWin());
			pstate.setInt(4,vathmologia.getLose());
			pstate.setInt(5,vathmologia.getPoints());
			pstate.executeUpdate(); // ekteloume to sql .Epeidh einai insert h updat ekteloume to 
			//execute update.
			//kaloume apo to pstate thn methodo getGeneratedKeys gia na paroume ta identities.
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {//eprnouem to epomeno identity.
					vathmologia.setId(generatedKeys.getInt(1)); //badoume to id sto antikeimeno mas. 
				}
			}
		}
		//to finaly 8a ektelestei panta sto telos tou try oti kai na ginei sto try. 
		finally{
			if(pstate!=null){
				pstate.close();
				
			}
		}

		return vathmologia;
	}

	public Vathmologia update(Vathmologia vathmologia) throws SQLException {

		String sql = "update Vathmologia set name=? ,surname=?,age=?,address=?,points=? where id = ?  ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setString(1,vathmologia.getBasket_team()); //pername tis patametrous 
			pstate.setInt(2,vathmologia.getId_race());
			pstate.setInt(3,vathmologia.getWin());
			pstate.setInt(4,vathmologia.getLose());
			pstate.setInt(5,vathmologia.getPoints());
			pstate.setInt(6, vathmologia.getId());
			int count = pstate.executeUpdate();//epistrefei to plh8os ton grammon poy exei allaksei
			if (count != 0) {
				return  vathmologia;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			 
		}
		return null;
	}
	
	public Vathmologia delete (Vathmologia vathmologia) throws SQLException {
		int count  = 0;
		String sql = "  delete from Vathmologia where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql );) {
			pstate.setInt(1, vathmologia.getId());
			count  = pstate.executeUpdate();
		}
		return  vathmologia;
	}	


	
	
	
}
