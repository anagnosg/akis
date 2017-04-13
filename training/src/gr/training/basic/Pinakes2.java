package gr.training.basic;

public class Pinakes2 {
	public static void main(String[] args){
		String[] pinakas1= new String[10]; //deka 8esei 
		pinakas1[0] = "ariumos 1 ";//ksekinaei apo to 0 
		pinakas1[1] = "akoma ena ";//στην δεύτερη γραμή του πίνακα βάλαμε το αριθμό 7.
		pinakas1[9] = "telos ";
		
		
		//παμε να γεμενίσουμε εναν πίνακα με στοιχεία  .
		
		for( int i =0; i < pinakas1.length ; i++){
			pinakas1[i]="Alfariumhtiko "+i;
		}
		
		/*for( int i =0; i < 10 ; i++){
			System.out.println(pinakas1[i]);
		}*/
		for( int i =0; i < pinakas1.length ; i++){
			System.out.println(pinakas1[i]);
		}
		
	}
}
