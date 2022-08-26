import java.util.*;

public class UseCollectionIterator{
    public static void main(String[] s){
    	// Uso la LinkedList
    	LinkedList<Double> list = new LinkedList<>();
    	// Vi inserisco 50 elementi
    	for (int i=0;i<50;i++){
    	    list.add(Math.random());
    	}
    	// Li stampo con un foreach
    	int ct=0;
    	for (double d: list){
    	    System.out.println(ct++ + "\t"+ d);
    	}
    	// 0       0.10230513602737423
    	// 1       0.4318582138894327
    	// 2       0.5239222319032795
    	// ..
    }
} 
