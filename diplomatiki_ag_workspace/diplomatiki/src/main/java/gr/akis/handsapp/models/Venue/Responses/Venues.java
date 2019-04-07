package gr.akis.handsapp.models.Venue.Responses;

import gr.akis.handsapp.models.Region.Responses.Region;
import gr.akis.handsapp.models.VenueCategory.Responses.VenueCategory;

public class Venues {
	Integer id;
	String description;
	Integer categoryId;
	VenueCategory category;
	String address;
	Integer regionId;
	Region region;
	String summary;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public VenueCategory getCategory() {
		return category;
	}
	public void setCategory(VenueCategory category) {
		this.category = category;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}
