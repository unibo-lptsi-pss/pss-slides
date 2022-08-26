package it.unibo.apice.oop.p12exceptions.classes;

public class UseRange{
    public static void main(String[] args){
    	// args tiene inizio e fine, passate da line di comando
    	final int a = Integer.parseInt(args[0]); // "5"
    	final int b = Integer.parseInt(args[1]); // "10"
    	final RangeIterator r = new RangeIterator(a,b);
    	// remove(); // cosa succede con remove?
    	try {
    		System.out.print(r.next()+" ");
    		System.out.print(r.next()+" ");
    		System.out.println(r.next());
    	} catch (final java.util.NoSuchElementException e){
    		System.out.println("eccezione.. ma il programma continua "+e.toString());
    	}
    	System.out.println("fine programma");
    }
}
/* Esecuzione: java UseRange 5 10
   args vale: new String[]{"5","10"}
   risultato:  5 6 7 */
  
/* Esecuzione: java UseRange 5 10.1
   risultato:  NumberFormatException */
   
/* Esecuzione: java UseRange 5 3
   risultato:  IllegalArgumentException */

/* Esecuzione: java UseRange 3 4
   risultato:  NoSuchElementException */ 	
