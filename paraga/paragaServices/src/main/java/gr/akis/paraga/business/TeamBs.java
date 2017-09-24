package gr.akis.paraga.business;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.paraga.db.TeamDB;
import gr.akis.paraga.models.Team;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;

@RequestScoped
public class TeamBs {

	@Inject
	ConnectionWrapper connwrap;

	@Inject
	TeamDB teamDB;
	 

	public List<Team> selectAll() throws SQLException {
		List<Team> teams;
		teams = teamDB.selectAll();
		return teams;
	}
 }
