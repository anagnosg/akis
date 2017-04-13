package gr.training.basic;

public class Pinakes {

	public static void main(String[] args){
		int[] pinakas1= new int[10]; //deka 8esei 
		pinakas1[0] = 0;//ksekinaei apo to 0 
		pinakas1[1] = 0;//στην δεύτερη γραμή του πίνακα βάλαμε το αριθμό 7.
		pinakas1[9] = 0;
		
		
		//παμε να γεμενίσουμε εναν πίνακα με στοιχεία  .
		
		for( int i =0; i < pinakas1.length ; i++){
			pinakas1[i]=i;
		}
		
		/*for( int i =0; i < 10 ; i++){
			System.out.println(pinakas1[i]);
		}*/
		for( int i =0; i < pinakas1.length ; i++){
			System.out.println(pinakas1[i]);
		}
		
	}
}
