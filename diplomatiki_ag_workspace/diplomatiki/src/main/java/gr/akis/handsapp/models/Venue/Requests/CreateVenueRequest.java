package gr.akis.handsapp.models.Venue.Requests;

import java.util.List;

public class CreateVenueRequest {
	private String description;
	private int category;
	private String address;
	private int region;
	private String summary;
	private List<Integer> services;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<Integer> getServices() {
		return services;
	}
	public void setServices(List<Integer> services) {
		this.services = services;
	}
	
}
