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

import gr.akis.handsapp.business.RegionBs;
import gr.akis.handsapp.models.Region;
import gr.akis.handsapp.models.ResponseModel;
import gr.akis.handsapp.utils.GsonUtils;
import io.swagger.annotations.Api;

	 @ApplicationScoped
	 @Path("/region")
	 @Api(value = "/region")
	 @Consumes("application/json")
	 @Produces("application/json")
	 public class RegionResource {

	 	
	 	
	 	private static final Logger LOG = Logger.getLogger(RegionResource.class.getName()); //Logger xrhsimopoieitai gia na katagraefis ston log tou application server tis energeies pou ginontai 

	 	@Inject
	 	RegionBs regionBS;
	 	@Inject
	 	GsonUtils gsUtils; // GsonUtils gsUtils = new GsonUtils(); 
	  
	 	@GET  //AUTA pou ksekinane me @ einai annotations 
	 	@Path("/all")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	 	@Consumes("application/json")
	 	@Produces("application/json")
	 	public Response all() {
	 		
	 		//�� E ��� response Model ����� ��� ����� ��� student , List<Student>
	 		ResponseModel<List<Region>> rep = new ResponseModel<List<Region>>(); // Orismos antikeimenou rep
	 		try {  
	 			List<Region> listregion = regionBS.selectAll(); 
	 			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
	 			rep.setData(listregion);
	 			LOG.info("End all");
	 			return Response.ok(rep).build();

	 		} catch (Exception e) {
	 			e.printStackTrace();
	 			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
	 			return Response.ok(rep).build();
	 		}
	 	}

	}


