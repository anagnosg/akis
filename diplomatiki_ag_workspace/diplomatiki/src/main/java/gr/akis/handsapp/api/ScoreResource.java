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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import gr.akis.handsapp.business.ScoreBs;
import gr.akis.handsapp.models.ResponseModel;
import gr.akis.handsapp.models.Score.Requests.AssignScoreRequest;
import gr.akis.handsapp.models.Score.Requests.DeleteScoreRequest;
import gr.akis.handsapp.models.Score.Requests.GetScoreRequest;
import gr.akis.handsapp.models.Score.Responses.Score;
import gr.akis.handsapp.utils.GsonUtils;
import io.swagger.annotations.Api;

@ApplicationScoped
@Path("/vathmologia")
@Api(value = "/vathmologia")
@Consumes("application/json")
@Produces("application/json")
public class ScoreResource {

	private static final Logger LOG = Logger.getLogger(ScoreResource.class.getName()); 
	@Inject
	ScoreBs vathmologiaBS;
	@Inject
	GsonUtils gsUtils; 
 
	@GET  
	@Path("/all")  
	@Consumes("application/json")
	@Produces("application/json")
	public Response all() {
		
		
		ResponseModel<List<Score>> rep = new ResponseModel<List<Score>>();
		try {  
			List<Score> list = vathmologiaBS.selectAll(); 
			
			rep.setData(list);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
	
	@GET  
	@Path("/venue") 
	@Consumes("application/json")
	@Produces("application/json")
	public Response selectByVenueId(@QueryParam("venue") Integer venue) {
		ResponseModel<List<Score>> rep = new ResponseModel<List<Score>>();
		try {  
			List<Score> list = vathmologiaBS.select(venue); 
			
			rep.setData(list);
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
	public Response insert(AssignScoreRequest request) {
		ResponseModel<Score> rep = new ResponseModel<Score>();
		try {
			 
			Score score = vathmologiaBS.insert(request);
			rep.setData(score);
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
	public Response delete(DeleteScoreRequest request) {
		ResponseModel<Boolean> rep = new ResponseModel<Boolean>(); // Orismos antikeimenou rep
		try {
			vathmologiaBS.delete(request);
			rep.setData(true);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
	
}
