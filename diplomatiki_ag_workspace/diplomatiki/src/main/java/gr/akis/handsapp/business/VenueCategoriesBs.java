package gr.akis.handsapp.business;

import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import gr.akis.handsapp.db.VenueCategoryDb;
import gr.akis.handsapp.models.VenueCategory.Responses.VenueCategory;
import gr.akis.handsapp.utils.ConnectionWrapper;

@RequestScoped
public class VenueCategoriesBs {
	@Inject
	ConnectionWrapper connwrap;
	@Inject
	VenueCategoryDb venueCategoriesDB;

	public List<VenueCategory> selectAll() throws SQLException {
		List<VenueCategory> categories;
		categories = venueCategoriesDB.selectAll();
		return categories;
	}

	public VenueCategory insert(VenueCategory category) throws SQLException {
		return venueCategoriesDB.insert(category);
	}

	public VenueCategory update(VenueCategory category) throws SQLException {
		return venueCategoriesDB.update(category);
	}

	public Integer delete(Integer category) throws SQLException {
		return venueCategoriesDB.delete(category);
	}
}