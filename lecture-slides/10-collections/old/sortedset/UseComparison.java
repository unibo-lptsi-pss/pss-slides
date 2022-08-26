public class UseComparison{
    public static void main(String[] s){
    	System.out.println("abc vs def: "+
    	                   "abc".compareTo("def")); // neg
    	System.out.println("1 vs 2: "+
    	                    new Integer(1).compareTo(2));// neg
    	
    	Persona p1 = new Persona("Rossi",1960,false);
    	Persona p2 = new Persona("Rossi",1972,false);
    	Persona p3 = new Persona("Bianchi",1972,false);
    	Persona p4 = new Persona("Bianchi",1972,true);
    	
    	System.out.println(p1+" vs "+p2+": "+
    	                   p1.compareTo(p2)); // pos
    	System.out.println(p2+" vs "+p3+": "+
    	                   p2.compareTo(p3)); // pos
    	System.out.println(p3+" vs "+p4+": "+
    	                   p3.compareTo(p4)); // zero
    }   
}
