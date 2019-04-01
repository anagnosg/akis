package gr.akis.paraga.business;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.paraga.db.TeamDB;
import gr.akis.paraga.db.VathmologiaDB;
import gr.akis.paraga.models.Team;
import gr.akis.paraga.models.Vathmologia;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;

@RequestScoped
public class VathmologiaBs {
	@Inject
	ConnectionWrapper connwrap;

	@Inject
	VathmologiaDB vathmologiaDB;
	 

	public List<Vathmologia> selectAll() throws SQLException {
		List<Vathmologia> vathmologia;
		vathmologia = vathmologiaDB.selectAll();
		return vathmologia;
	}
}
