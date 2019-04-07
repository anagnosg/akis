package gr.akis.handsapp.business;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.handsapp.db.VenueCategoryDb;
import gr.akis.handsapp.db.VenuesDb;
import gr.akis.handsapp.models.Venue.Requests.CreateVenueRequest;
import gr.akis.handsapp.models.Venue.Responses.Venues;
import gr.akis.handsapp.utils.ConnectionWrapper;

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
	
	public List<Venues> select(Integer id)  throws SQLException{
		List<Venues> venue;
		venue = venueDB.select(id);
		return venue;
	}
	
	public Venues insert(CreateVenueRequest request) throws SQLException{
		Venues venue = new Venues();
		venue.setRegionId(request.getRegion());
		venue.setDescription(request.getDescription());
		venue.setCategoryId(request.getCategory());
		venue.setAddress(request.getAddress());
		venue.setSummary(request.getSummary());
		venue.setServiceIds(request.getServices());
		return venueDB.insert(venue);
	}
	
	public Venues update(Venues venue) throws SQLException{
	
		return venueDB.update(venue);
	}
		
	public Integer delete(Integer venue) throws SQLException{
		
		return venueDB.delete(venue);
	}

	public VenuesBs(){}
}