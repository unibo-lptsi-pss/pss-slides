package it.unibo.apice.oop.p12exceptions.classes;

public class UseMyException{
    public static void main(String[] s){
    	try{ // attenzione alla formattazione di questo esempio!
    		final int a = Integer.parseInt(s[0]);
    		final int b = Integer.parseInt(s[1]);
    		final RangeIterator r = new RangeIterator(a,b);
    		System.out.print(r.next()+" ");
    		System.out.print(r.next()+" ");
    		System.out.println(r.next());
    	} catch (Exception e){
    		final String str = "Rilancio di: "+e;
    		RuntimeException e2 = new MyException(str,s);
    		throw e2;
    	}
    }
}
/* Esempio: java UseMyException 10 13.1
Exception in thread "main" Stato argomenti: [10, 13.1]
it.unibo.apice.oop.p13exceptions.classes.MyException: Rilancio di: java.lang.NumberFormatException: For input string: "13.1"
	at it.unibo.apice.oop.p13exceptions.classes.UseMyException.main(UseMyException.java:14)
*/
