package gr.training.basic;

public class Functions1 {
	
	
	//Αύτη η συνάρτηση είναι public. Μπορεί δηλαδή να κληθεί ακαι από άλλα αντιεκειμενα
	//Επιστρέφει αντικείμεννο τύπου String.
	// Ονομάζεται firstFunction
	//Kai den exei kanena orisma
	public String firstFunction(){
		String s = "akis";
		System.out.println("first");
		return s;
	}
	//Αυτή η συνάρτηση είναι public 
	// Επιστρέφει int 
	//Ονομάζεται addInt
	//Πέρνει 2 ορίσματα
	// το πρώτο είναι Int με όνομα a\
	// το δεύτετο είναι int me ονομα β. 
	//Θα πέρνει τους 2 αριθμούς a kai b kai θα του προσθέτει. Το αποτέλεσμα θα το επιστρέφει
	//to static καθοριζει ότι δεν χρειάζεται η δημιουργια αντικειμένου για την κλήση της συνάρτησης.
	public static int addInt(int a , int b ){
		int output=0;
		output = a+b ; 
		return output;
	}
	
	public static void main(String[] args) {
		int i = 1;
		int k = 2;
		int result=0;
		
		result = addInt(i,k);
		System.out.println(result);
		
	}
	
	
}
