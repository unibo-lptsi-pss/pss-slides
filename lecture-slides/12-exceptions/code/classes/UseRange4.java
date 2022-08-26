public class UseRange4{
    public static void main(String[] s){
    	RangeIterator r = null; // va creata fuori dal try..
    	try{ // attenzione alla formattazione di questo esempio!
    	    int a = Integer.parseInt(s[0]);
    	    int b = Integer.parseInt(s[1]);
    	    r = new RangeIterator(a,b);
    	    System.out.print(r.next()+" ");
    	    System.out.print(r.next()+" ");
    	    System.out.println(r.next());
    	} catch (Exception e){ //ogni altra eccezione
    	    throw e; // rilancio l'eccezione
    	    // dovrebbe dare un errore di compilazione: BUG?
    	} finally{
    	    // questo codice comunque eseguito
    	    System.out.println("bye bye..");
    	}
    }
}
