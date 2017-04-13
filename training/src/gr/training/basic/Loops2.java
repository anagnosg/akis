package gr.training.basic;

public class Loops2 {
	
	//ξεκινάει το πρόγραμμα με b ισο με true.
	//orizei mia metablhth i ish me 0
	//ektelei while loop oso to b einai true
	//ektuponei to i
	//auksanei kata 1 to i ;
	//elegxei an to i einai megalytero apo to 10
	//kai an einai megalutero apo 10 kanei to b false
	//kai epomenos afou kanei false stamataei to while loop.
	
	public static void main(String[] args) {
		//while loop
		boolean b = true;
		//oso h ekfrsh b einai true ektelese to loop.
		int i = 0 ;
		while(b){
			System.out.println(i);
			i=i+1;
			if(i>10){
				b=false;
			}
		}
	}
}
