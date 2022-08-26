package it.unibo.apice.oop.p18patterns.combined;

import java.util.*;

public class UseFilteredEIterator {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,20,30,40,50);
		EIterator<Integer> it = new EIteratorFromCollection<>(list);
		Predicate<Integer> pred = new Predicate<Integer>(){
			public boolean holds(Integer i){
				return i < 40;
			}
		};
		EIterator<Integer> filt = new FilteredEIterator<Integer>(it,pred);
		try{
			while(true){
				System.out.println(filt.next());
			}
		} catch (NoSuchElementException e){
			System.out.println("over");
		}
	}
}
