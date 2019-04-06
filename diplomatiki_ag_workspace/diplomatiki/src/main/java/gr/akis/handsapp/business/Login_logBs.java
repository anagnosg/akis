package gr.akis.handsapp.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.handsapp.db.Login_logDB;
import gr.akis.handsapp.db.UserDB;
import gr.akis.handsapp.models.Login_log;
import gr.akis.handsapp.models.User;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;

@RequestScoped
public class Login_logBs {

	@Inject
	ConnectionWrapper connwrap;

	@Inject
	Login_logDB loginDB;
	 

	public List<Login_log> selectAll() throws SQLException {
		List<Login_log> login;
		login = loginDB.selectAll();
		return login;
	}
	
	
public Login_log insert(Login_log login) throws SQLException{
		
		return loginDB.insert(login);
	}
	
	public Login_log update(Login_log login) throws SQLException{
	
		return loginDB.update(login);
	}
	
	
	public Login_log delete(Login_log login) throws SQLException{
		
		return loginDB.delete(login);
	}

	public Login_logBs(){}
	
	public List<Login_log> selectMathimaAllDummy() throws SQLException{
		List<Login_log> login = null; // 
	login = new ArrayList<Login_log>();
		
		//Students  kai pro8hkh sthn lista. 
	Login_log l = new Login_log(); //Orismos antikeimenou me onoma ag kai klash Student; Arxikopoihsh tou
		l.setId(1);
		l.setUsername("akindynos");
		login.add(l);
		
		
		return login;
	}
	
	
	
	public List<Login_log> selectmathimaAll() throws SQLException{
		List<Login_log> login  ;
	
		login = loginDB.selectAll();
		 
		return login;
	}	
	public List<Login_log> selectUser(String username) throws SQLException {
		List<Login_log> login;
		login = loginDB.selectUser(username);
		return login;
	}
	
	

}
