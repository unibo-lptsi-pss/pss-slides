package it.unibo.apice.oop.p19reflection.annotations;

public class UsePrintObjectsUtilities {
	
	public static void main(String[] args) {
		final Person p = new Person("Marco", 100);
		System.out.println(PrintObjectsUtilities.objectToString(p));
		// getName->Marco, getId->100, 
		
		final Product pr = new Product("Pr", 200, 100000);
		System.out.println(PrintObjectsUtilities.objectToString(pr));
		// qty->100000.0; getName->Pr; getId:200; 
	}
}
