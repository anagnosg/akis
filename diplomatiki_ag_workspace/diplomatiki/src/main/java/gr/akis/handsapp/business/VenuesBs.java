package gr.akis.handsapp.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.handsapp.db.VenuesDb;
import gr.akis.handsapp.models.Venues;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;

@RequestScoped
public class VenuesBs {

	@Inject
	ConnectionWrapper connwrap;

	@Inject
    VenuesDb venueDB;
	 
	public List<Venues> selectAll()  throws SQLException{
		List<Venues> venue;
		venue = venueDB.selectAll();
		return venue;
	}
	
	public Venues insert(Venues venue) throws SQLException{
		List<Venues> venues;
		venues = venueDB.selectAll();
		return venueDB.insert(venue);
	}
	
	public Venues update(Venues venue) throws SQLException{
	
		return venueDB.update(venue);
	}
		
	public Venues delete(Venues venue) throws SQLException{
		
		return venueDB.delete(venue);
	}

	public VenuesBs(){}
	
	public List<Venues> selectFromVenuesAllDummy() throws SQLException{
		List<Venues> venue = null; // ???s�?? ??sta? �a??t??.
		venue = new ArrayList<Venues>();
		
		//???s�?? d?? a?t??e?�???? �a??t?? Students  kai pro8hkh sthn lista. 
		Venues v = new Venues(); //Orismos antikeimenou me onoma ag kai klash Student; Arxikopoihsh tou
		v.setId(1);
		v.setId_venues(1);
		v.setRestaurants("MASTER CHEF");
		v.setCafe_bar("MIKEL");
		v.setCinema_theater("ΘΕΑΤΡΟ MOYΣΟΥΡΗ");
		v.setFestivals("ΣΥΝΑΥΛΙΑ ΣΩΚΡΑΤΗ ΜΑΛΑΜΑ");
		v.setSports("BASKETBALL");
        v.setHealth("ΓΝΑ");
		v.setMuseum("ΜΟΥΣΕΙΟ ΑΚΡΟΠΟΛΗΣ");
		v.setPublic_services("IKA");
		v.setHotel("CARAVEL");
		v.setStores("MALL");
		v.setSuper_market("ΣΚΛΑΒΕΝΙΤΗΣ");
		v.setTransports("ΛΕΩΦΟΡΕΙΟ 605");
		venue.add(v);
		
		
		return venue;
	}

	public List<Venues> selectFromVenuesAll() throws SQLException{
		List<Venues> venue  ;
	
		venue = venueDB.selectAll();
		 
		return venue;
	}
}