package gr.anagnosg.schoolservices.models;

import java.util.List;

public class Classi {
	Integer Id;
	String Name;
	Integer Id_Sxoleio;
	List<Teacher> teachers;
	List<Student> students;

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getId_Sxoleio() {
		return Id_Sxoleio;
	}

	public void setId_Sxoleio(Integer iD_Sxoleio) {
		Id_Sxoleio = iD_Sxoleio;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;//pernei th parametro students pou einai mia lista apo Student kai th thetei 
		//sto property students tou adikeimenou taxi(classi)
	}
	
}
