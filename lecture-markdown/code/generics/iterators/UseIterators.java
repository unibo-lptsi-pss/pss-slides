public class UseIterators{
    public static void main(String[] s){
    	List<String> list = new List<>("a", 
    	    		    new List<>("b", 
    	    		    new List<>("c",null))));
    	
    	Vector<java.util.Date> vector=new Vector<>();
    	vector.addElement(new java.util.Date());
    	vector.addElement(new java.util.Date());
        
        // creo 3 iteratori..
    	Iterator<Integer> iterator = new IntRangeIterator(5,10);
    	Iterator<String> iterator2 = new ListIterator<>(list);
    	Iterator<java.util.Date> iterator3 = new VectorIterator<>(vector);
    	
    	// ne stampo il contenuto..
    	while (iterator.hasNext()){
    	    System.out.println("Elemento : "+iterator.next());
    	}
    	while (iterator2.hasNext()){
    	    System.out.println("Elemento : "+iterator2.next());
    	}
    	while (iterator3.hasNext()){
    	    System.out.println("Elemento : "+iterator3.next());
    	}
    }
}

