package gr.akis.handsapp.models.User.Response;

import gr.akis.handsapp.models.User.Requests.CreateUserRequest;

public class User extends CreateUserRequest{
	Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
