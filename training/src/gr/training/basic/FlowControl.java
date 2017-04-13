package gr.training.basic;
//Θα μάθουμε τους τελεστες σύγκρισης 
public class FlowControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		//θα μάθουμε την έννοια των εκφράσεων 
		boolean b = false;
		//η κφραση i<1 σημαίνει σύγκρινε το i με τον ακέραιο 1 και μες μου αν είναι μικρότερος 
		b = i<1;
		System.out.println(b);
		i=2;
		b = i<1;
		System.out.println(b);
		//ο επόμενος μας τελεστης σύγκρισης είναι το >  το οποίο σημαίνει μεγαλύτερο 
		//δηλαδή το i>1 συμαίνει σύγκρινε μου το i αν είναι μεγαλύτερο από το 1 και αν είναι επέστρεψε true
		b = i>1;
		System.out.println(b);
		//ο τελεστής σύγκρισης == συμαίνει είναι το i ίσος με το 1. 
		b=i==1;
		System.out.println(b);
		//ο telest;hw s;ygkrish != σημαίνει είναι διαφορετικό   είναι το I 
		b=i!=1;
	}

}
