public class UseMyException{
    public static void main(String[] s){
    	try{ // attenzione alla formattazione di questo esempio!
    	    int a = Integer.parseInt(s[0]);
    	    int b = Integer.parseInt(s[1]);
    	    RangeIterator r = new RangeIterator(a,b);
    	    System.out.print(r.next()+" ");
    	    System.out.print(r.next()+" ");
    	    System.out.println(r.next());
    	} catch (Exception e){
    	    String str = "Rilancio di:\n"+e;
    	    RuntimeException e2 = new MyException(str,s);
    	    throw e2;
    	}
    }
}
/* Esempio: java UseMyException 10 13.1
Exception in thread "main" Stato argomenti: [10, 13.1]
MyException: Rilancio di:
java.lang.NumberFormatException: For input string: "13.1"
        at UseMyException.main(UseMyException.java:13)
*/
