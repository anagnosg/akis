package gr.akis.handsapp.models.Score.Requests;

public class DeleteScoreRequest {
	private String token;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	private Integer venueId;
	 
	public Integer getVenueId() {
		return venueId;
	}
	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}
	

}
