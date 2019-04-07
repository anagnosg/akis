package gr.akis.handsapp.api;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import gr.akis.handsapp.business.VenuesBs;
import gr.akis.handsapp.models.Venues;
import gr.anagnosg.schoolservices.models.ResponseModel;
import gr.anagnosg.utis.GsonUtils;
import io.swagger.annotations.Api;

@ApplicationScoped
@Path("/venue")
@Api(value = "/venue")
@Consumes("application/json")
@Produces("application/json")
public class VenuesResource {

	private static final Logger LOG = Logger.getLogger(VenuesResource.class.getName()); //Logger xrhsimopoieitai gia na katagraefis ston log tou application server tis energeies pou ginontai 

 	@Inject
 	VenuesBs venueBS;
 	@Inject
 	GsonUtils gsUtils; // GsonUtils gsUtils = new GsonUtils(); 
  
 	@GET  //AUTA pou ksekinane me @ einai annotations 
 	@Path("/all")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
 	@Consumes("application/json")
 	@Produces("application/json")
 	public Response all() {
 		
 		//�� E ��� response Model ����� ��� ����� ��� student , List<Student>
 		ResponseModel<List<Venues>> rep = new ResponseModel<List<Venues>>(); // Orismos antikeimenou rep
 		try {  
 			List<Venues> listvenue = venueBS.selectAll();
 			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
 			rep.setData(listvenue);
 			LOG.info("End all");
 			return Response.ok(rep).build();

 		} catch (Exception e) {
 			e.printStackTrace();
 			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
 			return Response.ok(rep).build();
 		}
 	}


	}



	
	


