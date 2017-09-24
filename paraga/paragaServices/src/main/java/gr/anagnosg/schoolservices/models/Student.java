package gr.anagnosg.schoolservices.models;



import gr.anagnosg.employeeservices.exceptions.ValidationException;
import gr.anagnosg.employeeservices.interfaces.SelfValidating;



public class Student implements SelfValidating{

	Integer Id;
	String name;
	String surname;
	String email;
	String address;
	String phone;
	Integer age;
	
	
	
	



	public Integer getId() {
		return Id;
	}



	public void setId(Integer id) {
		Id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
	@Override
	public void validate() throws ValidationException {
		// TODO Auto-generated method stub
		
	}
}
