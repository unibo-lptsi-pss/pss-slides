package it.unibo.apice.oop.p09generics.iterators;

public class UseIntRangeIterator{
	
    public static void main(String[] s){
    	
    	List<String> ls = new List<>("10",new List<>("20",new List<>("30",null)));
    	
    	final ListIterator<String> it = new ListIterator<>(ls);
    	
    	while (it.hasNext()){
    		System.out.println(it.next());
    	}
    	
    	
    	
    	
    }
}

