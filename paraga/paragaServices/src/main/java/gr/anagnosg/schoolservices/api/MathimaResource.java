package gr.anagnosg.schoolservices.api;

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
import gr.anagnosg.schoolservices.business.MathimaBS;
import gr.anagnosg.schoolservices.models.Person;
import gr.anagnosg.schoolservices.models.ResponseModel;
import gr.anagnosg.utis.GsonUtils;
import io.swagger.annotations.Api;

	@ApplicationScoped
	@Path("/mathima") // Einai to path ths yphresia klashs 
	@Api(value = "/mathima") //Auta einai annotations ths klassh 
	@Consumes("application/json") //H yphresia mou katanalonei , dexetai san input json
	@Produces("application/json") // //yphesia paragei json 
	public class MathimaResource {	
		private static final Logger LOG = Logger.getLogger(MathimaResource.class.getName()); //Logger xrhsimopoieitai gia na katagraefis ston log tou application server tis energeies pou ginontai 

		@Inject
		MathimaBS mathimaBS; // StudentBS studentBS = new StudentBS(); // dhmiourgeis ena antikeimeno ths klashs StudentBS
		@Inject
		GsonUtils gsUtils; // GsonUtils gsUtils = new GsonUtils(); 
	 
		@GET  //AUTA pou ksekinane me @ einai annotations 
		@Path("/all")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
		@Consumes("application/json")
		@Produces("application/json")
		public Response all() {
			
			//Το E του response Model είναι μια λίστα απο student , List<Student>
			ResponseModel<List<Person>> rep = new ResponseModel<List<Person>>(); // Orismos antikeimenou rep
			try { // To try catch einai ena komati kodika sto opoio leme to ekshs.
				//pros8hse na ekteleseis tis entoles pou briskontai sto body tou try kai 
				//an submei kapoio la8os ektelese to kattalhlo catch.
				
				
				//orizoume mia metablhth me onoma liststudents
				//o tupos ths (klash) einai List (lista) apo Student.
				//Kaloume apo to antikeimeno studentBS thn methodo selectStudentsAl. H opoia epistrefei 
				//olous tous mathites.
				List<Person> listmathimataki = mathimaBS.selectmathimaAll(); 
				//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
				rep.setData(listmathimataki);
				LOG.info("End all");
				return Response.ok(rep).build();

			} catch (Exception e) {
				e.printStackTrace();
				rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
				return Response.ok(rep).build();
			}
		}
		
		
		@POST  //AUTA pou ksekinane me @ einai annotations 
		@Path("/insert")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
		@Consumes("application/json")
		@Produces("application/json")
		public Response insert(Person mathima) {
			
			 
			ResponseModel<Person> rep = new ResponseModel<Person>(); // Orismos antikeimenou rep
			try {  
				 
				mathima = mathimaBS.insert(mathima); 
				//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
				rep.setData(mathima);
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
		public Response update(Person mathima) {
			
			 
			ResponseModel<Person> rep = new ResponseModel<Person>(); // Orismos antikeimenou rep
			try {  
				 
				mathima = mathimaBS.update(mathima); 
				//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
				rep.setData(mathima);
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
		public Response delete(Person mathima) {
			
			 
			ResponseModel<Person> rep = new ResponseModel<Person>(); // Orismos antikeimenou rep
			try {  
				 
				mathima = mathimaBS.delete(mathima); 
				//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
				rep.setData(mathima);
				LOG.info("End all");
				return Response.ok(rep).build();

			} catch (Exception e) {
				e.printStackTrace();
				rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
				return Response.ok(rep).build();
			}
		}	
		

	

	}


