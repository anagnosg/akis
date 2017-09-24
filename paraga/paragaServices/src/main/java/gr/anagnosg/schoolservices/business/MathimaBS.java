package gr.anagnosg.schoolservices.business;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import gr.anagnosg.employeeservices.db.utils.ConnectionWrapper;
import gr.anagnosg.schooleservices.db.ClassDB;
import gr.anagnosg.schooleservices.db.MathimaDB;
import gr.anagnosg.schoolservices.models.Mathima;

@RequestScoped
public class MathimaBS {
	
		@Inject 
		ConnectionWrapper connwrap;
		
		@Inject 
		MathimaDB mathimaDB;
		@Inject 
		ClassDB skillDB;
		public List<Mathima> selectMathimaAll() throws SQLException{
			List<Mathima> mathima  ;
		
			mathima = mathimaDB.selectAll();
			 
			return mathima;
		}
		
		
		public Mathima insert(Mathima mathima) throws SQLException{
			
			return mathimaDB.insert(mathima);
		}
		
		public Mathima update(Mathima mathima) throws SQLException{
		
			return mathimaDB.update(mathima);
		}
		
		
		public Mathima delete(Mathima mathima) throws SQLException{
			
			return mathimaDB.delete(mathima);
		}

		public MathimaBS(){}
		
		public List<Mathima> selectMathimaAllDummy() throws SQLException{
			List<Mathima> mathimataki = null; // Ορισμός λίστας μαθητών.
			mathimataki = new ArrayList<Mathima>();
			
			//Ορισμός δυο αντικειμένων μαθητών Students  kai pro8hkh sthn lista. 
			Mathima math = new Mathima(); //Orismos antikeimenou me onoma ag kai klash Student; Arxikopoihsh tou
			math.setId(1);
			math.setName("Istoria");
			mathimataki.add(math);
			
			
			return mathimataki;
		}
		
		
		
		public List<Mathima> selectmathimaAll() throws SQLException{
			List<Mathima> mathimataki  ;
		
			mathimataki = mathimaDB.selectAll();
			 
			return mathimataki;
		}
	}
