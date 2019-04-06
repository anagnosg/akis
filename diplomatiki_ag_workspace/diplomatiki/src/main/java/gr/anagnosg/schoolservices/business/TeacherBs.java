package gr.anagnosg.schoolservices.business;
import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;
import gr.anagnosg.schooleservices.db.ClassDB;

import gr.anagnosg.schooleservices.db.TeacherDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


import gr.anagnosg.schoolservices.models.Teacher;
@RequestScoped
public class TeacherBs {
	@Inject 
	ConnectionWrapper connwrap;
	
	@Inject 
	TeacherDB teacherDB;
	@Inject 
	ClassDB skillDB;
	public List<Teacher> selectTeachersAll() throws SQLException{
		List<Teacher> teacher  ;
	
		teacher = teacherDB.selectAll();
		 
		return teacher;
	}
	
	
	public Teacher insert(Teacher teacher) throws SQLException{
		
		return teacherDB.insert(teacher);
	}
	
	public Teacher update(Teacher teacher) throws SQLException{
	
		return teacherDB.update(teacher);
	}
	
	
	public Teacher delete(Teacher teacher) throws SQLException{
		
		return teacherDB.delete(teacher);
	}

	public TeacherBs(){}
	
	public List<Teacher> selectTeachersAllDummy() throws SQLException{
		List<Teacher> teachers = null; // Ορισμός λίστας μαθητών.
		teachers = new ArrayList<Teacher>();
		
		//Ορισμός δυο αντικειμένων μαθητών Students  kai pro8hkh sthn lista. 
		Teacher paouris = new Teacher(); //Orismos antikeimenou me onoma ag kai klash Student; Arxikopoihsh tou
		paouris.setId(1);
		paouris.setName("George");
		paouris.setSurname("Paouris");
		paouris.setAge(38);
		teachers.add(paouris);
		
		Teacher roinas = new Teacher(); //Orismos antikeimenou me onoma ag kai klash Student; Arxikopoihsh tou
		roinas.setId(2);
		roinas.setName("akis");
		roinas.setSurname("Roinas");
		roinas.setAge(30);
		teachers.add(roinas);
		
		
		
		
		
		return teachers;
	}
	
	
	
	public List<Teacher> selectteacherAll() throws SQLException{
		List<Teacher> teachers  ;
	
		teachers = teacherDB.selectAll();
		 
		return teachers;
	}

	}
	
	
	


