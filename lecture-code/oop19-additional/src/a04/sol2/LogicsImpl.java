package a04.sol2;

import java.util.*;
import java.util.stream.IntStream;

public class LogicsImpl implements Logics {
	
	private LinkedList<Pair<Integer,Integer>> selected = new LinkedList<>();
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
    }
    
    private boolean adjacent(Pair<Integer,Integer> p, Pair<Integer,Integer> q) {
    	return Math.abs(p.getX()-q.getX())<=1 && Math.abs(p.getY()-q.getY())<=1; 
    }
    
   	private boolean couldHit(int row, int col) {
		Pair<Integer,Integer> h = new Pair<>(row,col);
		return (this.selected.isEmpty() || 
				(!this.selected.contains(h) && adjacent(h,this.selected.getLast())));
	}

	@Override
	public boolean hit(int row, int col) {
		if (this.couldHit(row,col)) {
			this.selected.add(new Pair<>(row,col));
			return true;
		}
		return false;
	}

	@Override
	public boolean end() {
		return IntStream.range(0, size)
				        .boxed()
				        .flatMap(i -> IntStream.range(0, size).mapToObj(j -> new Pair<>(i,j)))
				        .allMatch(p -> !couldHit(p.getX(),p.getY()));
	}    
}

