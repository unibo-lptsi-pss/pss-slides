package it.unibo.apice.oop.p09generics.iterators;

public class UseIterators{
    public static void main(String[] s){
    	final List<String> list = new List<>("a", 
    	    		    new List<>("b", 
    	    		    new List<>("c",null)));
    	
    	final Vector<java.util.Date> vector=new Vector<>();
    	vector.addElement(new java.util.Date());
    	vector.addElement(new java.util.Date());
        
        // creo 3 iteratori..
    	final Iterator<Integer> iterator = new IntRangeIterator(5,10);
    	final Iterator<String> iterator2 = new ListIterator<>(list);
    	final Iterator<java.util.Date> iterator3 = 
    			new VectorIterator<>(vector);
    	
    	// ne stampo il contenuto..
    	printAll(iterator);
    	printAll(iterator2);
    	printAll(iterator3);
    }
    
    static <X> void printAll(Iterator<X> iterator) {
    	while (iterator.hasNext()){
    	    System.out.println("Elemento : "+iterator.next());
    	}
    }
}

