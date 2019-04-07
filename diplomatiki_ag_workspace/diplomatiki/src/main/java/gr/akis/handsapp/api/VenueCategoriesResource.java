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

import gr.akis.handsapp.business.VenueCategoriesBs;
import gr.akis.handsapp.models.ResponseModel;
import gr.akis.handsapp.models.Region.Responses.Region;
import gr.akis.handsapp.models.Service.Requests.CreateServiceRequest;
import gr.akis.handsapp.models.VenueCategory.Requests.CreateVenueCategory;
import gr.akis.handsapp.models.VenueCategory.Responses.VenueCategory;
import gr.akis.handsapp.utils.GsonUtils;
import io.swagger.annotations.Api;

@ApplicationScoped
@Path("/venue-category")
@Api(value = "/venue-category")
@Consumes("application/json")
@Produces("application/json")
public class VenueCategoriesResource {

	private static final Logger LOG = Logger.getLogger(VenueCategoriesResource.class.getName());
	@Inject
	VenueCategoriesBs venueCategoryBS;
	@Inject
	GsonUtils gsUtils; // GsonUtils gsUtils = new GsonUtils();

	@GET
	@Path("/all")
	@Consumes("application/json")
	@Produces("application/json")
	public Response all() {
		ResponseModel<List<VenueCategory>> rep = new ResponseModel<List<VenueCategory>>();
		try {
			List<VenueCategory> listregion = venueCategoryBS.selectAll();
			rep.setData(listregion);
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
	public Response insert(CreateVenueCategory request) {
		ResponseModel<VenueCategory> rep = new ResponseModel<VenueCategory>();
		try {
			VenueCategory region = new VenueCategory();
			region.setDescription(request.getDescription());
			region = venueCategoryBS.insert(region);
			rep.setData(region);
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
			Integer region = venueCategoryBS.delete(id);
			rep.setData(region);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}

}
