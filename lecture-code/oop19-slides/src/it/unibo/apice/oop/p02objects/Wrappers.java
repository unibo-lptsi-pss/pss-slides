package it.unibo.apice.oop.p02objects;

class Wrappers {
	public static void main(String[] s) {
		Integer i = new Integer(10);
		// nota gli escape character nella println
		System.out.println("Un intero \"wrapped\" " + i); 
		// stampa: Un intero "wrapped" 10
		
		Double d = new Double(10.2);
		// nota la stampa formattata come nella printf del C.. poco usata in Java
		System.out.format("Un Double %f\n", d); 
		// stampa: Un Double 10.200000
		System.out.println(d.intValue()); // 10
	}
}
