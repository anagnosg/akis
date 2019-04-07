package gr.akis.handsapp.models.User;

import java.util.Calendar;

public class Token {

	public int id ;
	public int userId;
	
	public String token;
	public Calendar expire;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Calendar getExpire() {
		return expire;
	}
	public void setExpire(Calendar expire) {
		this.expire = expire;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
