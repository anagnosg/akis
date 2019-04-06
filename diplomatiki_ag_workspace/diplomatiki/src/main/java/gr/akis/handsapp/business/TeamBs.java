package gr.akis.handsapp.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.handsapp.db.TeamDB;

import gr.akis.handsapp.models.Team;
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
public Team insert(Team teams) throws SQLException{
		
		return teamDB.insert(teams);
	}
	
	public Team update(Team teams) throws SQLException{
	
		return teamDB.update(teams);
	}
	
	
	public Team delete(Team teams) throws SQLException{
		
		return teamDB.delete(teams);
	}

	public TeamBs(){}
	
	public List<Team> selectMathimaAllDummy() throws SQLException{
		List<Team> teams = null; // 
		teams = new ArrayList<Team>();
		
		//Students  kai pro8hkh sthn lista. 
		Team t = new Team(); //Orismos antikeimenou me onoma ag kai klash Student; Arxikopoihsh tou
		t.setId(1);
		t.setName("KOLOSOS RODOY");
		teams.add(t);
		
		
		return teams;
	}
	
	
	
	public List<Team> selectmathimaAll() throws SQLException{
		List<Team> teams  ;
	
		teams = teamDB.selectAll();
		 
		return teams;
	}
 }
