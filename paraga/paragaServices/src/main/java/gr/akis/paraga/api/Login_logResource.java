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

import gr.akis.paraga.business.Login_logBs;
import gr.akis.paraga.business.UserBs;
import gr.akis.paraga.models.Login_log;
import gr.akis.paraga.models.User;
import gr.akis.paraga.utils.ErrorHandling;
import gr.anagnosg.schoolservices.models.ResponseModel;
import gr.anagnosg.utis.GsonUtils;
import io.swagger.annotations.Api;import java.util.List;

@ApplicationScoped
@Path("/Login_log")
@Api(value = "/Login_log")
@Consumes("application/json")
@Produces("application/json")public class Login_logResource {
private static final Logger LOG = Logger.getLogger(Login_logResource.class.getName()); //Logger xrhsimopoieitai gia na katagraefis ston log tou application server tis energeies pou ginontai 

	@Inject
	Login_logBs Login_logBS;
	@Inject
	GsonUtils gsUtils; // GsonUtils gsUtils = new GsonUtils(); 
 
	@GET  //AUTA pou ksekinane me @ einai annotations 
	@Path("/Login_log")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response Login_log(@QueryParam("username") String username) {
		
		//Το E του response Model είναι μια λίστα απο student , List<Student>
		ResponseModel<List<Login_log>> rep = new ResponseModel<List<Login_log>>(); // Orismos antikeimenou rep
		try {  
			List<Login_log> list = Login_logBS.selectAll();
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
		ResponseModel<List<Login_log>> rep = new ResponseModel<List<Login_log>>(); // Orismos antikeimenou rep
		try {  
			List<Login_log> list = Login_logBS.selectAll(); 
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
	public Response insert(Login_log login) {
		
		 
		ResponseModel<Login_log> rep = new ResponseModel<Login_log>(); // Orismos antikeimenou rep
		try {  
			 
			login = Login_logBS.insert(login); 
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(login);
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
	public Response update(Login_log login) {
		
		 
		ResponseModel<Login_log> rep = new ResponseModel<Login_log>(); // Orismos antikeimenou rep
		try {  
			 
			login = Login_logBS.update(login); 
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(login);
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
	public Response delete(Login_log login) {
		
		 
		ResponseModel<Login_log> rep = new ResponseModel<Login_log>(); // Orismos antikeimenou rep
		try {  
			 
			login = Login_logBS.delete(login); 
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(login);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
}

