import java.util.Date;
public class UseIterators2{
    
    public static <E> void printAll(Iterator<E> iterator){
    	while (iterator.hasNext()){
    	    System.out.println("Elemento : "+iterator.next());
    	}
    }
    
    ...
