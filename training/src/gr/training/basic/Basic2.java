package gr.training.basic;

public class Basic2 {
	
	
	//Θα φτειάξουμε μια συνάρτηση η οποία δέχεται σαν ορίσματα την εκκίνηση, το τέλος και το βήμα ενός loop
	//kai ua epistrefei comma separeted me tous akeraioys 
	//start , end , bhma  Π.χ 1 ,10, 1 kai 8a epistrefei  String 1,2,3,4... ,10
	public static String commaSeparated(int start,int end,int step){
		String output = "";
		for(int i = start ; i < end ; i= i +step){
			if(i < end -step ){
				output = output + i+","; 
			}
			else{
				output = output + i;
			}
		}
		return output;
	}

	public static void main(String[] args) {
		int  start = 0 ; 
		int end = 10 ; 
		int step = 1;
		String s = "";
		s =commaSeparated(start,end,step);
		String s2 = "";
		
		int start2 = 4;
		int end2 = 12;
		int step2 =2;
		s2 =commaSeparated(start2,end2,step2);
		System.out.println(s2);
	}
	
	
}
