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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import gr.akis.handsapp.business.PersonBs;
import gr.akis.handsapp.business.TeamBs;
import gr.akis.handsapp.models.Person;
import gr.akis.handsapp.models.Team;
import gr.akis.handsapp.utils.ErrorHandling;
import gr.anagnosg.schoolservices.models.ResponseModel;
import gr.anagnosg.utis.GsonUtils;
import io.swagger.annotations.Api;

@ApplicationScoped
@Path("/team")
@Api(value = "/team")
@Consumes("application/json")
@Produces("application/json")
public class TeamResource {

	
	
	private static final Logger LOG = Logger.getLogger(TeamResource.class.getName()); //Logger xrhsimopoieitai gia na katagraefis ston log tou application server tis energeies pou ginontai 

	@Inject
	TeamBs teamBS;
	@Inject
	GsonUtils gsUtils; // GsonUtils gsUtils = new GsonUtils(); 
 
	@GET  //AUTA pou ksekinane me @ einai annotations 
	@Path("/all")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response all() {
		
		//Το E του response Model είναι μια λίστα απο student , List<Student>
		ResponseModel<List<Team>> rep = new ResponseModel<List<Team>>(); // Orismos antikeimenou rep
		try {  
			List<Team> list = teamBS.selectAll(); 
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
	public Response insert(Team teams) {
		
		 
		ResponseModel<Team> rep = new ResponseModel<Team>(); // Orismos antikeimenou rep
		try {  
			 
			teams = teamBS.insert(teams); 
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(teams);
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
	public Response update(Team teams) {
		
		 
		ResponseModel<Team> rep = new ResponseModel<Team>(); // Orismos antikeimenou rep
		try {  
			 
			teams = teamBS.update(teams); 
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(teams);
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
	public Response delete(Team teams) {
		
		 
		ResponseModel<Team> rep = new ResponseModel<Team>(); // Orismos antikeimenou rep
		try {  
			 
			teams = teamBS.delete(teams); 
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(teams);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}	
	




}
