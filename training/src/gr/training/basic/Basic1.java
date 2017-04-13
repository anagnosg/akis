package gr.training.basic;

public class Basic1 {
	public static void main(String[] args) {
		//Θα φτειαξουμε το αλφαριθμητικό 
		//1,2,3,4,5,
		//Και μετά θα το εκτυπώσουμε 
		String s = "";
		for(int i=1 ; i< 6 ; i++){
			s=s+i+",";
		}
		System.out.println(s);
	}
}
