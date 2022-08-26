/* Showing ClassCastException */
public class ShowCCE{
    public static void main(String[] as){
    	Object o = new Integer(10);
    	Integer i = (Integer)o; // OK
    	String s = (String)o; 	// ClassCastException
    	// int i = o.intValue(); // No, intValue() non def.
    	// String s = (String)i; // No, tipi inconvertibili
    }
} 
