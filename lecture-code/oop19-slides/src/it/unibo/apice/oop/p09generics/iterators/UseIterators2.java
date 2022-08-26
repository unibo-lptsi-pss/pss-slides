package it.unibo.apice.oop.p09generics.iterators;

public class UseIterators2{
    public static <E> void printAll(final Iterator<E> iterator){
    	while (iterator.hasNext()){
    	    System.out.println("Elemento : "+iterator.next());
    	}
    }
    
    public static void main(String[] s){
    	final Iterator<Integer> iterator = new IntRangeIterator(5,10);
    	
    	final List<String> list = new List<String>("a", // si potrebbe usare
    	    		    new List<String>("b", // inferenza
    	    		    new List<String>("c",
    	    		    new List<String>("d",null))));
    	final Iterator<String> iterator2 = new ListIterator<>(list);
    	
    	final Vector<java.util.Date> vector=new Vector<>(); // inferenza
    	vector.addElement(new java.util.Date());
    	vector.addElement(new java.util.Date());
        vector.addElement(new java.util.Date());
        
        final Iterator<java.util.Date> iterator3 = new VectorIterator<>(vector);
    	                                        // con inferenza:
        UseIterators2.<Integer>printAll(iterator);	      
        UseIterators2.<String>printAll(iterator2);	     
        UseIterators2.<java.util.Date>printAll(iterator3);
    }
}

