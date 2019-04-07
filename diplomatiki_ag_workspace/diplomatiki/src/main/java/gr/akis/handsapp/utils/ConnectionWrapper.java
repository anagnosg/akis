package gr.akis.handsapp.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.sql.DataSource;


@RequestScoped
public class ConnectionWrapper {
	private static final Logger LOG = Logger.getLogger(ConnectionWrapper.class.getName());

	@Inject
	DataSource ds;
	private Connection conn;

	public ConnectionWrapper() {
	}

	/*
	 * Get connection from datasource
	 */
	public Connection getConnection() throws SQLException {
		if (conn == null) {
			conn = ds.getConnection();
		}
		return conn;
	}

	/*
	 * Closes the connection
	 */
	@PreDestroy
	public void destroy() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			
			LOG.severe("Unable to close connection.");
		}

	}

	public void beginTrans() throws SQLException {
		if (conn == null) {
			conn = this.ds.getConnection();
			conn.setAutoCommit(false);
		}
	}

	public void commitTrans() throws SQLException {
		conn.commit();
		conn.setAutoCommit(true);
	}

	public void rollbackTrans() throws SQLException{
		conn.rollback();
		conn.setAutoCommit(true);
	}
}
