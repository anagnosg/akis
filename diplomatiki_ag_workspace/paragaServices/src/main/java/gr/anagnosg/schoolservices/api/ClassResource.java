package gr.anagnosg.schoolservices.api;


import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



import gr.anagnosg.schoolservices.business.ClassiBS;

import gr.anagnosg.schoolservices.models.Classi;

import gr.anagnosg.schoolservices.models.ResponseModel;

import gr.anagnosg.schoolservices.models.Student;
import gr.anagnosg.schoolservices.models.Teacher;
import io.swagger.annotations.Api;

@ApplicationScoped
@Path("/classi")
@Api(value = "/classi")
@Consumes("application/json")
@Produces("application/json")
public class ClassResource {
	private static final Logger LOG = Logger.getLogger(ClassResource.class.getName());
	
	@Inject
	ClassiBS classiBS;
	
	public ClassResource(){}
	 
	@POST  //AUTA pou ksekinane me @ einai annotations 
	@Path("/insert")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(Classi classi) {
		
		 
		ResponseModel<Classi> rep = new ResponseModel<Classi>(); // Orismos antikeimenou rep
		try {  
			 
			classi = classiBS.insert(classi); 
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData(classi);
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
	
	
	@POST  //AUTA pou ksekinane me @ einai annotations 
	@Path("/insertTaxiTeacher")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response insertTaxiTeacher(Classi classi ) {
		
		 
		ResponseModel<String> rep = new ResponseModel<String>(); // Orismos antikeimenou rep
		try {  
			Teacher teacher=null;
			if(classi.getTeachers()!=null && classi.getTeachers().size()>0){
				teacher = classi.getTeachers().get(0);
				
			}
			classiBS.insertTaxiTeacher(classi, teacher);
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData("ok");
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
	@POST  //AUTA pou ksekinane me @ einai annotations 
	@Path("/insertTaxiMathitis")  //Auta eiai annotations methodou. Mpanoun prin apo ton orismo ths methodou
	@Consumes("application/json")
	@Produces("application/json")
	public Response insertTaxiMathitis(Classi classi ) {
		
		 
		ResponseModel<String> rep = new ResponseModel<String>(); // Orismos antikeimenou rep
		try {  
			Student student=null;
			if(classi.getStudents()!=null && classi.getStudents().size()>0){
				student = classi.getStudents().get(0);
				
			}
			classiBS.insertTaxiMathitis(classi, student);
			//sto antikeimeno rep. 8etoume ta data tou, me thn lista apo mathites.
			rep.setData("ok");
			LOG.info("End all");
			return Response.ok(rep).build();

		} catch (Exception e) {
			e.printStackTrace();
			rep.setError(e.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
			return Response.ok(rep).build();
		}
	}
	
	
}
