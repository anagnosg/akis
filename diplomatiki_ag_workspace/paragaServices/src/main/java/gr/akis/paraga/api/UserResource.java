package gr.akis.paraga.api;

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

import gr.akis.paraga.business.UserBs;
import gr.akis.paraga.models.User;
import gr.akis.paraga.utils.ErrorHandling;
import gr.anagnosg.schoolservices.models.ResponseModel;
import gr.anagnosg.utis.GsonUtils;
import io.swagger.annotations.Api;

@ApplicationScoped
@Path("/user")
@Api(value = "/user")
@Consumes("application/json")
@Produces("application/json")
public class UserResource {
private static final Logger LOG = Logger.getLogger(UserResource.class.getName()); //Logger xrhsimopoieitai gia na katagraefis ston log tou application server tis energeies pou ginontai 

	@Inject
	UserBs userBS;
	@Inject
	GsonUtils gsUtils; // GsonUtils gsUtils = new GsonUtils(); 
 
	@GET  //AUTA pou ksekinane me @ einai annotations 
	@Path("/user_password")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response user_password(@QueryParam("username") String username,@QueryParam("password")String password) {
		
		//Το E του response Model είναι μια λίστα απο student , List<Student>
		ResponseModel<List<User>> rep = new ResponseModel<List<User>>(); // Orismos antikeimenou rep
		try {  
			List<User> list = userBS.selectUser(username,password); 
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(list);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			
			rep.setError(new ErrorHandling(e).getErrorMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(rep).build();
		}
	}
	@GET  //AUTA pou ksekinane me @ einai annotations 
	@Path("/all")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response all() {
		
		//Το E του response Model είναι μια λίστα απο student , List<Student>
		ResponseModel<List<User>> rep = new ResponseModel<List<User>>(); // Orismos antikeimenou rep
		try {  
			List<User> list = userBS.selectAll(); 
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(list);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			
			rep.setError(new ErrorHandling(e).getErrorMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(rep).build();
		}
	}
	@POST  //AUTA pou ksekinane me @ einai annotations 
	@Path("/insert")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(User users) {
		
		 
		ResponseModel<User> rep = new ResponseModel<User>(); // Orismos antikeimenou rep
		try {  
			 
			users = userBS.insert(users); 
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(users);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
	

	@POST  //AUTA pou ksekinane me @ einai annotations 
	@Path("/update")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(User users) {
		
		 
		ResponseModel<User> rep = new ResponseModel<User>(); // Orismos antikeimenou rep
		try {  
			 
			users = userBS.update(users); 
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(users);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
	
	@DELETE //AUTA pou ksekinane me @ einai annotations 
	@Path("/delete")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(User Users) {
		
		 
		ResponseModel<User> rep = new ResponseModel<User>(); // Orismos antikeimenou rep
		try {  
			 
			Users = userBS.delete(Users); 
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(Users);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
}



