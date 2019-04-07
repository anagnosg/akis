package gr.akis.handsapp.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.handsapp.db.RegionDb;
import gr.akis.handsapp.models.Region.Responses.Region;
import gr.akis.handsapp.utils.ConnectionWrapper;

@RequestScoped
public class RegionBs {

	@Inject
	ConnectionWrapper connwrap;

	@Inject
	RegionDb regionDB;

	public List<Region> selectAll() throws SQLException {
		List<Region> region;
		region = regionDB.selectAll();
		return region;
	}

	public Region insert(Region region) throws SQLException {
		List<Region> regions;
		regions = regionDB.selectAll();
		return regionDB.insert(region);
	}

	public Region update(Region region) throws SQLException {

		return regionDB.update(region);
	}

	public Integer delete(Integer region) throws SQLException {

		return regionDB.delete(region);
	}

	public RegionBs() {
	}

}
