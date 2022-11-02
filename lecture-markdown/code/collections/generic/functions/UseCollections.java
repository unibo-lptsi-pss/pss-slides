import java.util.*;

public class UseCollections{
    
    public static void main(String[] s){
    	List<Integer> list = Arrays.asList(new Integer[]{0,1,2,3,4});
    	Set<List<Integer>> set = new HashSet<>(); 
    	
    	for (int i=0;i<5;i++){
    	    List<Integer> l2 = new ArrayList<>(list);
    	    Collections.shuffle(l2);// permuto
    	    if (!set.contains(l2)){ // no duplicazione!
    	    	set.add(l2); 	    // aggiungo
    	    }
    	}
    	System.out.println("shuf: "+set); //[[4,1,2,3,0],[3,1,4,0,2],..
    	
    	int ct=0;
    	for (List<Integer> l:set){
    	    Collections.fill(l,ct++);
    	}
    	System.out.println("inc: "+set); //[[0,0,0,0,0],[1,1,1,1,1],..
    	
    	System.out.println("cop: "+Collections.nCopies(5,list));
    	//[[0,1,2,3,4],[0,1,2,3,4],..
    }
}
