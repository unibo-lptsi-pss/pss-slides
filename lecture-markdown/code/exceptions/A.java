import java.util.*;
public class A{
    public static void main(final String[] args){
    	//Integer.parseInt("10.4");
    	//java.util.Collections.<Integer>emptySet().add(1);
    	final Iterator<Integer> i = Arrays.asList(1,2).iterator();
    	i.next();
    	i.next();
    	i.next(); // NoSuchElementException
    }
}
