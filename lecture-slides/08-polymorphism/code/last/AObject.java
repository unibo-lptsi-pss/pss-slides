import java.util.Arrays;
/* Tutti gli oggetti possono formare un elenco Object[] */
public class AObject{
    public static void main(String[] s){
    	Object[] os = new Object[5];
    	os[0] = new Object();
    	os[1] = "stringa";
    	os[2] = new Integer(10);
    	os[3] = new int[]{10,20,30};
    	os[4] = new java.util.Date();
    	printAll(os);
    	System.out.println(Arrays.toString(os));
    	System.out.println(Arrays.deepToString(os));
    }
    public static void printAll(Object[] array){
    	for (Object o: array){
    	    System.out.println("Oggetto:"+o.toString());
    	}
    }
} 
