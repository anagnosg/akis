package gr.akis.handsapp.business;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.handsapp.db.VathmologiaDB;
import gr.akis.handsapp.models.Vathmologia;
import gr.akis.handsapp.utils.ConnectionWrapper;

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
