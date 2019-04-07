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
import gr.akis.handsapp.models.Service.Responses.*;
import gr.akis.handsapp.utils.ConnectionWrapper;

@RequestScoped
public class ServicesDb {
	@Inject
	ConnectionWrapper connWrapper;

	public List<Service> selectAll() throws SQLException {
		List<Service> service = new ArrayList<Service>();
		String sql = "SELECT ID , DESCRIPTION FROM  SERVICES ";

		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);
				ResultSet rs = pstate.executeQuery();) {
			while (rs.next()) {
				Service s = new Service();
				s.setId(rs.getInt("ID"));
				s.setDescription(rs.getString("DESCRIPTION"));
				service.add(s);
			}
		}
		return service;
	}

	public Service insert(Service service) throws SQLException {
		String sql = "INSERT INTO SERVICES (DESCRIPTION) VALUES (?)";
		Connection conn = this.connWrapper.getConnection();
		PreparedStatement pstate = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		try {
			pstate.setString(1, service.getDescription());
			pstate.executeUpdate();
			try (ResultSet generatedKeys = pstate.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					service.setId(generatedKeys.getInt(1));
				}
			}
		} finally {
			if (pstate != null) {
				pstate.close();
			}
		}
		return service;
	}

	public Service update(Service service) throws SQLException {
		String sql = "update SERVICES set DESCRIPTION =?  where ID = ?  ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setString(1, service.getDescription());
			pstate.setInt(2, service.getId());
			int count = pstate.executeUpdate();
			if (count != 0) {
				return service;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Service delete(Service service) throws SQLException {
		int count = 0;
		String sql = "  delete from Services where id = ?      ";
		try (PreparedStatement pstate = this.connWrapper.getConnection().prepareStatement(sql);) {
			pstate.setInt(1, service.getId());
			count = pstate.executeUpdate();
		}
		return service;
	}
}
