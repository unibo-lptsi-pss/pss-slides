package it.unibo.apice.oop.p09generics.generics;

public class UseVector{
	public static void main(String[] s){
    	
    	// Il tipo di vs è Vector<String>
    	// Ma la sua classe è Vector<X>
    	final Vector<String> vs = new Vector<String>(); 
    	vs.addElement("Prova");		
    	vs.addElement("di");		
    	vs.addElement("Vettore");
    	final String str = vs.getElementAt(0) + " " + 
    		     vs.getElementAt(1) + " " +
    		     vs.getElementAt(2); // Nota, nessun cast!
    	System.out.println(str);
        
    	final Vector<Integer> vi=new Vector<Integer>(); 
    	vi.addElement(10); // Autoboxing
    	vi.addElement(20);
    	vi.addElement(30);
    	final int i = vi.getElementAt(0) + // Unboxing 
    		vi.getElementAt(1) +
    		vi.getElementAt(2);
    	System.out.println(i);
    }
}

