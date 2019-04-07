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

import gr.akis.handsapp.business.RegionBs;
import gr.akis.handsapp.models.ResponseModel;
import gr.akis.handsapp.models.Region.Requests.CreateRegionRequest;
import gr.akis.handsapp.models.Region.Responses.Region;
import gr.akis.handsapp.utils.GsonUtils;
import io.swagger.annotations.Api;

@ApplicationScoped
@Path("/region")
@Api(value = "/region")
@Consumes("application/json")
@Produces("application/json")
public class RegionResource {

	private static final Logger LOG = Logger.getLogger(RegionResource.class.getName());
	@Inject
	RegionBs regionBS;
	@Inject
	GsonUtils gsUtils; // GsonUtils gsUtils = new GsonUtils();

	@GET
	@Path("/all")
	@Consumes("application/json")
	@Produces("application/json")
	public Response all() {
		ResponseModel<List<Region>> rep = new ResponseModel<List<Region>>();
		try {
			List<Region> listregion = regionBS.selectAll();
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
	public Response insert(CreateRegionRequest request) {
		ResponseModel<Region> rep = new ResponseModel<Region>();
		try {
			Region region = new Region();
			region.setDescription(request.getDescription());
			region = regionBS.insert(region);
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
		ResponseModel<Integer> rep = new ResponseModel<Integer>(); // Orismos antikeimenou rep
		try {
			Integer region = regionBS.delete(id);
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
