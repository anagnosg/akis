package gr.akis.handsapp.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.handsapp.db.ServicesDb;
import gr.akis.handsapp.models.Services;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;

@RequestScoped
public class ServicesBs {

	@Inject
	ConnectionWrapper connwrap;

	@Inject
    ServicesDb serviceDB;
	 
	public List<Services> selectAll()  throws SQLException{
		List<Services> service;
		service = serviceDB.selectAll();
		return service;
	}
	
	public Services insert(Services service) throws SQLException{
		List<Services> services;
		services = serviceDB.selectAll();
		return serviceDB.insert(service);
	}
	
	public Services update(Services service) throws SQLException{
	
		return serviceDB.update(service);
	}
		
	public Services delete(Services service) throws SQLException{
		
		return serviceDB.delete(service);
	}

	public ServicesBs(){}
	
	public List<Services> selectFromServicesAllDummy() throws SQLException{
		List<Services> service = null; // ???s�?? ??sta? �a??t??.
		service = new ArrayList<Services>();
		
		//???s�?? d?? a?t??e?�???? �a??t?? Students  kai pro8hkh sthn lista. 
		Services s = new Services(); //Orismos antikeimenou me onoma ag kai klash Student; Arxikopoihsh tou
		s.setId(1);
		s.setDisability_platform(true);
		s.setWc(true);
		s.setParkin(false);
		s.setOffer("-10%");
		s.setSystem_braile(false);
		s.setDeaf_language(true);
		s.setOthers("-");
		
		service.add(s);
		
		
		return service;
	}

	public List<Services> selectFromServicesAll() throws SQLException{
		List<Services> service  ;
	
		service = serviceDB.selectAll();
		
		return service;
	}

	}




	
	


