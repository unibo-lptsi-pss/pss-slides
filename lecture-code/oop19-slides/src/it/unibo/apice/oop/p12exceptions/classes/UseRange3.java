package it.unibo.apice.oop.p12exceptions.classes;

public class UseRange3{
    public static void main(String[] s){
    	RangeIterator r = null; // creabile anche dentro al try..
    	try{ // attenzione alla formattazione di questo esempio!
    		final int a = Integer.parseInt(s[0]);
    	    final int b = Integer.parseInt(s[1]);
    	    r = new RangeIterator(a,b);
    	    System.out.print(r.next()+" ");
    	    System.out.print(r.next()+" ");
    	    System.out.println(r.next());
    	    throw new Error();
    	} catch (ArrayIndexOutOfBoundsException e){
    	    System.out.println("Servono almeno due argomenti!");
    	} catch (NumberFormatException e){
    	    System.out.println("Servono argomenti interi!");
    	} catch (IllegalArgumentException e){
    	    System.out.println(e);
    	} catch (Exception e){ //ogni altra eccezione
    	    throw e; // rilancio l'eccezione
    	} finally{
    	    // questo codice comunque eseguito
    	    System.out.println("bye bye..");
    	}
    }
}
