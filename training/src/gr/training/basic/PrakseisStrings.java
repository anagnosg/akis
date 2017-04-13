package gr.training.basic;

public class PrakseisStrings {
	
	public static void main(String[] args){
		String s  = "Αυτό εδώ είναι ένα αλφαριθμητικό ";
		
		int thesi  =s.indexOf("ώ");
		System.out.println(thesi);
		int thesi2  =s.indexOf("α");
		System.out.println(thesi2);
		int thesi3  =s.indexOf("έ");
		System.out.println(thesi3);
		
		int thesi4  =s.lastIndexOf("α");
		System.out.println(thesi4);
		
		int thesi5  =s.lastIndexOf("εδώ");
		System.out.println(thesi5);
		
		
		String s2 = s.substring(0,thesi5);
		System.out.println(s2);
		
		s2 = s.substring(0,6);
		System.out.println(s2);
		s2 = s.substring(0,0);
		System.out.println(s2);
		s2 = s.substring(0,s.length());
		System.out.println(s2);
		s2 = s.substring(thesi5,s.length());
		System.out.println(s2);
		
		String s3 = "akis";
		String s4 = "AKIS";
		boolean b = s3.equals(s4);
		System.out.println(b);
		b = s3.equalsIgnoreCase(s4);
		System.out.println(b);
		
		
		
		
		
	}
}
