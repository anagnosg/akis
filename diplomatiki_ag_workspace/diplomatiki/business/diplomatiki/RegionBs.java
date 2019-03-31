package diplomatiki;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.paraga.db.PersonDB;
import gr.akis.paraga.models.Person;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;

@RequestScoped
public class RegionBs {
	
	@Inject
	ConnectionWrapper connwrap;

	@Inject
    RegionDb regionDB;
	 
	public List<Region> selectAll()  throws SQLException{
		List<Region> region;
		region = regionDB.selectAll();
		return region;
	}
	
	public Region insert(Region region) throws SQLException{
		List<Region> regions;
		regions = regionDB.selectAll();
		return regionDB.insert(region);
	}
	
	public Region update(Region region) throws SQLException{
	
		return regionDB.update(region);
	}
		
	public Region delete(Region region) throws SQLException{
		
		return regionDB.delete(region);
	}

	public RegionBs(){}
	
	public List<Region> selectFromRegionAllDummy() throws SQLException{
		List<Region> region = null; // ???s�?? ??sta? �a??t??.
		region = new ArrayList<Region>();
		
		//???s�?? d?? a?t??e?�???? �a??t?? Students  kai pro8hkh sthn lista. 
		Region r = new Region(); //Orismos antikeimenou me onoma ag kai klash Student; Arxikopoihsh tou
		r.setId(1);
		r.setId_region(1);
		r.setRegion_name("N.IONIA");
		region.add(r);
		
		
		return region;
	}

	public List<Region> selectFromRegionAll() throws SQLException{
		List<Region> region  ;
	
		region = regionDB.selectAll();
		 
		return region;
	}

	}


