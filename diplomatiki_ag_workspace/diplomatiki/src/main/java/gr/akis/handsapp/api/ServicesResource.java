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

import gr.akis.handsapp.business.ServicesBs;
import gr.akis.handsapp.models.ResponseModel;
import gr.akis.handsapp.models.Service.Requests.CreateServiceRequest;
import gr.akis.handsapp.models.Service.Responses.Service;
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
		ResponseModel<List<Service>> rep = new ResponseModel<List<Service>>(); // Orismos antikeimenou rep
		try {
			List<Service> listservice = serviceBS.selectAll();
			rep.setData(listservice);
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
	public Response insert(CreateServiceRequest request) {
		ResponseModel<Service> rep = new ResponseModel<Service>();
		try {
			Service service = new Service();
			service.setDescription(request.getDescription());
			service = serviceBS.insert(service);
			rep.setData(service);
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
			Service service = serviceBS.delete(id) ;
			rep.setData(service.getId());
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
}

