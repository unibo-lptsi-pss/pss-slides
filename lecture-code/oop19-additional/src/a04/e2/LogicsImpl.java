package a04.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final int size;
	private final List<Pair<Integer,Integer>> selected = new LinkedList<>();
	
	public LogicsImpl(int size) {
		this.size = size;
	}

	@Override
	public boolean hit(int x, int y) {
		Pair<Integer,Integer> p = new Pair<>(x,y);
		if (this.selected.isEmpty() || this.near(p,this.last())) {
			this.selected.add(p);
			return true;
		}
		return false;
	}
	
	private Pair<Integer,Integer> last(){
		return this.selected.get(this.selected.size()-1);
	}

	private boolean near(Pair<Integer, Integer> p, Pair<Integer, Integer> q) {
		return Math.abs(p.getX()-q.getX())<=1 && Math.abs(p.getY()-q.getY())<=1;
	}

	@Override
	public boolean isOver() {
		for (int i=0; i<this.size; i++) {
			for (int j=0; j<this.size; j++) {
				Pair<Integer,Integer> p = new Pair<>(i,j); 
				if (near(p,last()) && !this.selected.contains(p)) {
					return false;
				}
			}
		}
		return true;
	}

}
