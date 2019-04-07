package gr.akis.handsapp.api;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import gr.akis.handsapp.business.UserBs;
import gr.akis.handsapp.models.ResponseModel;
import gr.akis.handsapp.models.User.Token;
import gr.akis.handsapp.models.User.Requests.CreateUserRequest;
import gr.akis.handsapp.models.User.Requests.LoginRequest;
import gr.akis.handsapp.models.User.Response.User;
import gr.akis.handsapp.utils.ErrorHandling;
import gr.akis.handsapp.utils.GsonUtils;
import io.swagger.annotations.Api;

@ApplicationScoped
@Path("/user")
@Api(value = "/user")
@Consumes("application/json")
@Produces("application/json")
public class UserResource {
	// Logger xrhsimopoieitai gia na
	// katagraefis ston log tou
	// application server tis
	// energeies pou ginontai
	private static final Logger LOG = Logger.getLogger(UserResource.class.getName()); 

	@Inject
	UserBs userBS;
	@Inject
	GsonUtils gsUtils; // GsonUtils gsUtils = new GsonUtils();

	@GET // AUTA pou ksekinane me @ einai annotations
	@Path("/all") // Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response all() {

		// Το E του response Model είναι μια λίστα απο student , List<Student>
		ResponseModel<List<User>> rep = new ResponseModel<List<User>>(); // Orismos antikeimenou rep
		try {
			List<User> list = userBS.selectAll();
			// sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(list);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {

			rep.setError(new ErrorHandling(e).getErrorMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(rep).build();
		}
	}

	@POST // AUTA pou ksekinane me @ einai annotations
	@Path("/login") // Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response login(LoginRequest request) {

		ResponseModel<Token> rep = new ResponseModel<Token>(); // Orismos antikeimenou rep
		try {

			Token user = userBS.insertToken(request);
			// sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(user);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
	
	@POST // AUTA pou ksekinane me @ einai annotations
	@Path("") // Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(CreateUserRequest request) {

		ResponseModel<User> rep = new ResponseModel<User>(); // Orismos antikeimenou rep
		try {

			User user = userBS.insert(request);
			// sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(user);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}

	@POST // AUTA pou ksekinane me @ einai annotations
	@Path("/update") // Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(User users) {

		ResponseModel<User> rep = new ResponseModel<User>(); // Orismos antikeimenou rep
		try {

			users = userBS.update(users);
			// sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(users);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}

	@DELETE // AUTA pou ksekinane me @ einai annotations
	@Path("") // Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(List<Integer> userIds) {

		ResponseModel<List<Integer>> rep = new ResponseModel<List<Integer>>(); // Orismos antikeimenou rep
		try {

			userIds = userBS.delete(userIds);
			// sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(userIds);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
}
