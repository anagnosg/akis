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

import gr.akis.handsapp.business.VenuesBs;
import gr.akis.handsapp.models.ResponseModel;
import gr.akis.handsapp.models.Region.Responses.Region;
import gr.akis.handsapp.models.Venue.Requests.CreateVenueRequest;
import gr.akis.handsapp.models.Venue.Responses.Venues;
import gr.akis.handsapp.utils.GsonUtils;
import io.swagger.annotations.Api;

@ApplicationScoped
@Path("/venue")
@Api(value = "/venue")
@Consumes("application/json")
@Produces("application/json")
public class VenuesResource {

	private static final Logger LOG = Logger.getLogger(VenuesResource.class.getName()); 
	@Inject
	VenuesBs venueBS;
	@Inject
	GsonUtils gsUtils;  

	@GET  
	@Path("/all")  
	@Consumes("application/json")
	@Produces("application/json")
	public Response all() {

		ResponseModel<List<Venues>> rep = new ResponseModel<List<Venues>>();  
		try {
			List<Venues> listvenue = venueBS.selectAll();
			 
			rep.setData(listvenue);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(CreateVenueRequest request) {
		ResponseModel<Venues> rep = new ResponseModel<Venues>();
		try {
			Venues venue = venueBS.insert(request);
			rep.setData(venue);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}

	@DELETE
	@Path("")
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(Integer id) {
		ResponseModel<Integer> rep = new ResponseModel<Integer>(); 
		try {
			Integer venue = venueBS.delete(id);
			rep.setData(venue);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
}
