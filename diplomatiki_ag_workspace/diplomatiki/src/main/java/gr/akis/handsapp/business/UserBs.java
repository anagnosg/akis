package gr.akis.handsapp.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.handsapp.db.UserDB;
import gr.akis.handsapp.models.User.Requests.CreateUserRequest;
import gr.akis.handsapp.models.User.Response.User;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;

@RequestScoped
public class UserBs {

	@Inject
	ConnectionWrapper connwrap;

	@Inject
	UserDB userDB;

	public List<User> selectAll() throws SQLException {
		List<User> users;
		users = userDB.selectAll();
		return users;
	}

	public User insert(CreateUserRequest request) throws SQLException {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setAge(request.getAge());
		user.setEmail(request.getEmail());
		user.setRegionId(request.getRegionId());
		return userDB.insert(user);
	}

	public User update(User users) throws SQLException {

		return userDB.update(users);
	}

	public User delete(User users) throws SQLException {

		return userDB.delete(users);
	}

	public UserBs() {
	}

	public List<User> selectMathimaAllDummy() throws SQLException {
		List<User> users = null; //
		users = new ArrayList<User>();

		// Students kai pro8hkh sthn lista.Orismos antikeimenou me onoma ag kai klash
		// Student; Arxikopoihsh tou
		User u = new User();
		u.setId(1);
		u.setUsername("akindynos");
		users.add(u);

		return users;
	}

	public List<User> selectmathimaAll() throws SQLException {
		List<User> users;

		users = userDB.selectAll();

		return users;
	}

	public List<User> selectUser(String username, String password, int userId) throws SQLException {
		List<User> users;
		users = userDB.selectUser(username, password, userId);
		return users;
	}

}
