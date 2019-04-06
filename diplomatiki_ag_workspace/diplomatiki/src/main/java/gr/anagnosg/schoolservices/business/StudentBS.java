package gr.anagnosg.schoolservices.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;

import gr.anagnosg.schooleservices.db.ClassDB;
import gr.anagnosg.schooleservices.db.StudentsDB;
import gr.anagnosg.schoolservices.models.Student;


@RequestScoped
public class StudentBS {
	
	@Inject 
	ConnectionWrapper connwrap;
	
	@Inject 
	StudentsDB studentDB; // SchoolDB schoolDB = new SchoolDB();
	@Inject 
	ClassDB skillDB;
	
	/**
	 * Φέρνει όλους τους μαθητες από την βάση
	 * @return
	 * @throws SQLException
	 */
	public List<Student> selectStudentsAll() throws SQLException{
		List<Student> students  ;
	
		students = studentDB.selectAll();
		 
		return students;
	}
	
	
	public Student insert(Student student) throws SQLException{
		
		return studentDB.insert(student);
	}
	
	public Student update(Student student) throws SQLException{
	
		return studentDB.update(student);
	}
	
	
	public Student delete(Student student) throws SQLException{
		
		return studentDB.delete(student);
	}
	
	/**
	 * Επιστρέφει μια καρφωτή λίστα απο μαθητές, για δοκιμές / εκπαίδευση.
	 * @return
	 * @throws SQLException
	 */
	public List<Student> selectStudentsAllDummy() throws SQLException{
		List<Student> students = null; // Ορισμός λίστας μαθητών.
		students = new ArrayList<Student>();
		
		//Ορισμός δυο αντικειμένων μαθητών Students  kai pro8hkh sthn lista. 
		Student ag = new Student(); //Orismos antikeimenou me onoma ag kai klash Student; Arxikopoihsh tou
		ag.setId(1);
		ag.setName("George");
		ag.setSurname("Anagnostopoulos");
		ag.setAddress("Psiloreitou 13,Agios Dhmitrios");
		ag.setAge(38);
		ag.setPhone("6974348778");
		ag.setEmail("anagnosg@gmail.com");
		students.add(ag);
		
		
		Student akis = new Student();
		akis.setId(2);
		akis.setName("akindynos");
		akis.setSurname("roinas");
		akis.setAddress("nikolaou gianna 37,perissos");
		akis.setAge(30);
		akis.setPhone("6936564090");
		akis.setEmail("akro23@yahoo.gr");
		students.add(akis);
		
		
		
		
		return students;
	}
	
	
	
	
	
}
