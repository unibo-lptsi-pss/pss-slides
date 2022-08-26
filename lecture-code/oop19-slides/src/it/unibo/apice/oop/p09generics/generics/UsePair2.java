package it.unibo.apice.oop.p09generics.generics;

public class UsePair2{
    public static void main(String[] s){
    	// Parametri in new Vector() inferiti dal tipo della variabile  	
    	final Vector<Pair<String,Integer>> v = new Vector<>(); 
    	// Parametri in new Pair(..) inferiti dal tipo degli argomenti
    	v.addElement(new Pair<>("Prova",1));		
    	v.addElement(new Pair<>("di",2));		
    	v.addElement(new Pair<>("Vettore",3));
    	final String str = v.getElementAt(0).getFirst() + " " + 
    		     v.getElementAt(1).getFirst() + " " +
    		     v.getElementAt(2).getFirst(); // Nota, nessun cast!
    	System.out.println(str);
    	System.out.println(v);
        
        // Inferenza grazie agli argomenti e tipo variabile..
    	final List<Pair<Integer,Integer>> l = 
          new List<>(new Pair<>(1,1), 
          new List<>(new Pair<>(2,2),
          new List<>(new Pair<>(3,3),
          null)));
    	System.out.println(l);
    	
    	// Local variable type inference
    	final var v2 = new Vector<Integer>();
    	v2.addElement(1);		
    	System.out.println(v2);
    }
}

