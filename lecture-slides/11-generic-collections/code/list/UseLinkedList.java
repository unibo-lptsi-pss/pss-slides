import java.util.*;

public class UseLinkedList{
    private static final String ELEMS = "A B C D E F G H I L M";
    public static void main(String[] s){
    	LinkedList<String> llist = 
    		new LinkedList<>(Arrays.asList(ELEMS.split(" ")));
    	llist.addFirst("*");
    	llist.addLast("*");
    	llist.removeFirstOccurrence("*");
    	llist.removeLastOccurrence("*");
    	
    	// bad performance
    	llist.add(llist.indexOf("L"),"K");
    	// better performance
    	ListIterator<String> it = llist.listIterator();
    	while (it.hasNext()){
    	    if (it.next().equals("I")){
    	    	it.add("J");
    	    	break;
    	    }
    	}
    	String[] str = llist.toArray(new String[0]);
    	System.out.println(Arrays.toString(str));
    }
}
