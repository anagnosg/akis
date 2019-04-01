package gr.anagnosg.schoolservices.business;

import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;
import gr.anagnosg.employeeservices.exceptions.GeneralException;
import gr.anagnosg.schooleservices.db.ClassDB;

import gr.anagnosg.schooleservices.db.StudentsDB;
import gr.anagnosg.schooleservices.db.Taxi_MathitisDB;
import gr.anagnosg.schooleservices.db.Taxi_TeacherDB;
import gr.anagnosg.schooleservices.db.TeacherDB;
import gr.anagnosg.schoolservices.models.Classi;

import gr.anagnosg.schoolservices.models.Student;
import gr.anagnosg.schoolservices.models.Teacher;

@RequestScoped
public class ClassiBS {
	@Inject 
	ConnectionWrapper connwrap;
	@Inject 
	ClassDB classDB;
	
	@Inject 
	TeacherDB teacherDB;
	
	@Inject 
	Taxi_TeacherDB taxiTeacherDB;
	
	@Inject
	StudentsDB studentDB;
	
	@Inject
	Taxi_MathitisDB taxiMathitisDB;
	
	public Classi insert(Classi classi) throws SQLException{
		
		return classDB.insert(classi);
	}
	

	public void insertTaxiTeacher(Classi classi,Teacher teacher) throws GeneralException, SQLException{
		//Kanei insert ston pinaka taxi kai pernoume piso to antikeimeno me to ID sumplhromeno.
		connwrap.beginTrans();//ξεκιναει ενα transaction me th vash.
		try{//prospathise na mou ekteleseis to kwdika kai an vreis lathos pigene sto catch.
			classi =  classDB.insert(classi);
			//int i = 0/0; //Sumbainei la8os.
			//na eisago ton teacher.
			teacher = teacherDB.insert(teacher);
			// na kano eisagogh ston endiameso pinaka taxi_teacher. gia na diloso thn sxesi tous .
			taxiTeacherDB.insert(classi.getId(), teacher.getId());
			connwrap.commitTrans();
		}
		catch(Exception e){
			e.printStackTrace();//auth h edolh eltyponei sth consola san to system.out to lathos pou exei symvei.
			connwrap.rollbackTrans();//rollbackTrans anerei oles tis allages pou exoun ginei sto transaction.
			throw new GeneralException(e.getMessage());//dimiourgei ena adikeimeno new general exception
			//kai to ''petaei''pros ta epanw.
		}
	}
	
	public void insertTaxiMathitis(Classi classi,Student student) throws GeneralException, SQLException{
		//Kanei insert ston pinaka taxi kai pernoume piso to antikeimeno me to ID sumplhromeno.
		connwrap.beginTrans();
		try{
			classi =  classDB.insert(classi);
			student = studentDB.insert(student);
			taxiMathitisDB.insert(classi.getId(), student.getId());
			connwrap.commitTrans();
		}
		catch(Exception e){
			e.printStackTrace();
			connwrap.rollbackTrans();
			throw new GeneralException(e.getMessage());
		}
	}
	
	
	

}
