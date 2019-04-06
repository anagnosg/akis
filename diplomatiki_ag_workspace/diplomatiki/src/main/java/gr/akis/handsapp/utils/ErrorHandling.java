package gr.akis.handsapp.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorHandling {
	Exception e;
	public ErrorHandling(Exception ex){
		this.e=ex;
	}
	
	public String getErrorMessage(){
		if(e!=null){
			if(e.getMessage()!=null){
				return e.getMessage();
			}
			else{
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);
				String sStackTrace = sw.toString(); // stack trace as a string
				return sStackTrace;//Επιστρέφει το stacktrace
			}
		}
		else{
			return "Exception is null";
		}
	}
}
