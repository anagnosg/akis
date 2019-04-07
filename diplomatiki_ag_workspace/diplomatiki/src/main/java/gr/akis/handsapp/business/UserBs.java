package gr.akis.handsapp.business;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.akis.handsapp.db.UserDB;
import gr.akis.handsapp.exceptions.BusinessException;
import gr.akis.handsapp.models.User.Token;
import gr.akis.handsapp.models.User.Requests.CreateUserRequest;
import gr.akis.handsapp.models.User.Requests.LoginRequest;
import gr.akis.handsapp.models.User.Response.User;
import gr.akis.handsapp.utils.ConnectionWrapper;

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
	
	public Token insertToken(LoginRequest request) throws SQLException,BusinessException {
		User user = userDB.selectUser(request.getUsername(), request.getPassword(),0);
		//O xristis ebale sosto username password opote 8a kanoume eggrafi ston token pinaka
		if(user==null) 
		{
			throw new BusinessException("Τα στοιχεία που δώσατε δεν είναι σωστά.");
		}
		String tokenString = java.util.UUID.randomUUID().toString();
		Calendar expire = Calendar.getInstance();
		expire.add(Calendar.HOUR, 1);//Expires in one hour
		//Create token and insert it 
		Token token = new Token();
		token.setToken(tokenString);
		token.setUserId(user.getId());
		token.setExpire(expire);
		return userDB.insertToken(token);
	}
	

	public User update(User users) throws SQLException {

		return userDB.update(users);
	}

	public User delete(User users) throws SQLException {

		return userDB.delete(users);
	}

	public UserBs() {
	}
	
	public User selectUser(String username, String password, int userId) throws SQLException {
		User user = userDB.selectUser(username, password, userId);
		return user;
	}

}
