package gr.training.basic;

public class FlowControl2 {
	public static void main(String[] args) {
		boolean b = false;
		// μέσα στις παρενθέσεις είναι το expression. H έκφραση. Μέσα στα
		// άγκυστρα είναι το
		// κομμάτι του κώδικα που αντιστοιχεί if.
		// An η έκφραση που είναι στην παρένθεση είναι αληθείς (true) τότε θα
		// εκτελεστεί ο κώδικας του if.

		if (b) {
			System.out.println("Είναι true");

		}
		// το else δεν πέρνει expression γιατί εκτελείται όταν δεν εκτελείται το
		// άλλο τμήμα του if.
		else {
			System.out.println("Είναι false");
		}

		int i = 0;
		i=2;
		if (i < 1) {
			System.out.println("ΤΟ i einai mikrotero apo 1");
		}
		else{
			System.out.println("το ι e;inai megalytero h iso");
		}
	}
}
