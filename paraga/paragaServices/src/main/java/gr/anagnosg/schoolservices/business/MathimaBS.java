package gr.anagnosg.schoolservices.business;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;
import gr.anagnosg.schooleservices.db.ClassDB;
import gr.anagnosg.schooleservices.db.MathimaDB;
import gr.anagnosg.schoolservices.models.Person;

@RequestScoped
public class MathimaBS {
	
		@Inject 
		ConnectionWrapper connwrap;
		
		@Inject 
		MathimaDB mathimaDB;
		@Inject 
		ClassDB skillDB;
		public List<Person> selectMathimaAll() throws SQLException{
			List<Person> mathima  ;
		
			mathima = mathimaDB.selectAll();
			 
			return mathima;
		}
		
		
		public Person insert(Person mathima) throws SQLException{
			
			return mathimaDB.insert(mathima);
		}
		
		public Person update(Person mathima) throws SQLException{
		
			return mathimaDB.update(mathima);
		}
		
		
		public Person delete(Person mathima) throws SQLException{
			
			return mathimaDB.delete(mathima);
		}

		public MathimaBS(){}
		
		public List<Person> selectMathimaAllDummy() throws SQLException{
			List<Person> mathimataki = null; // Ορισμός λίστας μαθητών.
			mathimataki = new ArrayList<Person>();
			
			//Ορισμός δυο αντικειμένων μαθητών Students  kai pro8hkh sthn lista. 
			Person math = new Person(); //Orismos antikeimenou me onoma ag kai klash Student; Arxikopoihsh tou
			math.setId(1);
			math.setName("Istoria");
			mathimataki.add(math);
			
			
			return mathimataki;
		}
		
		
		
		public List<Person> selectmathimaAll() throws SQLException{
			List<Person> mathimataki  ;
		
			mathimataki = mathimaDB.selectAll();
			 
			return mathimataki;
		}
	}
