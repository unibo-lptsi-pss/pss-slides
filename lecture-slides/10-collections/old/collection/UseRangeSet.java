import java.util.*;

public class UseRangeSet{
    public static void main(String[] s){
    	// r è un Set a tutti gli effetti
    	RangeSet r = new RangeSet(0,100);

    	// ad esempio, lo uso per iterare
    	for (int i: r){
    	    System.out.println("Elem: "+i);
    	}
    	
    	// ad esempio, uso la containsAll()
    	System.out.println(r.containsAll(Arrays.asList(25,27,87)));
    	
    	// è comunque un set immutabile
    	// quindi niente add(), remove(),...
    }
}
