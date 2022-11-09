import java.util.Date;

public class UseIterators2 {
    public static <E> void printAll(Iterator<E> iterator){ /* ... */ }
    
    public static void main(String[] s) {
        Iterator<Integer> iterator = new IntRangeIterator(5, 10);
   
        List<String> list = // ...
        Iterator<String> iterator2 = new ListIterator(list);
    
        Vector<Date> vector= // ...
        Iterator<Date> iterator3 = new VectorIterator(vector);
    
        // Attenzione, il nome della classe è obbligatorio
        UseIterators2.<Integer>printAll(iterator);	      
        UseIterators2.<String>printAll(iterator2);	     
        UseIterators2.<Date>printAll(iterator3);
        
        // Con inferenza, il nome della classe non è obbligatorio
        printAll(iterator);	      
        printAll(iterator2);	     
        printAll(iterator3);
    }
}
