package it.unibo.apice.oop.p22effective.defensive;

import java.util.*;

public class MyCollection<X> {
	
	private final Set<X> set = new HashSet<>();
	
	public MyCollection<X> add(X x){
		set.add(x);
		return this;
	}
	
	public Set<X> getAll(){
		// return new HashSet<>(this.set)
		return Collections.unmodifiableSet(this.set);
	}

	public static void main(String[] args) {
		final MyCollection<Integer> myc = new MyCollection<>();
		myc.add(1).add(2).add(10);
		final Set<Integer> myc2 = myc.getAll();
		//myc2.add(11);
	}

}
