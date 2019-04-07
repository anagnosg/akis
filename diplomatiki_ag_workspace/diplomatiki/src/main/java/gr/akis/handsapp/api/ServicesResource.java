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
import gr.akis.handsapp.business.ServicesBs;
import gr.akis.handsapp.models.ResponseModel;
import gr.akis.handsapp.models.Services;
import gr.akis.handsapp.utils.GsonUtils;
import io.swagger.annotations.Api;

@ApplicationScoped
@Path("/service")
@Api(value = "/service")
@Consumes("application/json")
@Produces("application/json")
public class ServicesResource {

	private static final Logger LOG = Logger.getLogger(ServicesResource.class.getName());

	@Inject
	ServicesBs serviceBS;
	@Inject
	GsonUtils gsUtils; // GsonUtils gsUtils = new GsonUtils();

	@GET
	@Path("/all")
	@Consumes("application/json")
	@Produces("application/json")
	public Response all() {

		ResponseModel<List<Services>> rep = new ResponseModel<List<Services>>(); // Orismos antikeimenou rep
		try {
			List<Services> listservice = serviceBS.selectAll();
			rep.setData(listservice);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}

}
