package it.unibo.apice.oop.p10collections.collection;

import java.util.*;

public class UseRangeSet {
	
	public static void main(String[] s) {
		// r è un Set a tutti gli effetti
		final RangeSet r = new RangeSet(0, 100);

		// ad esempio, lo uso per iterare
		for (final int i : r) {
			System.out.println("Elem: " + i);
		}

		// ad esempio, uso la contains()
		System.out.println(r.contains(25));
		
		// è comunque un set immutabile
		// quindi niente add(), remove(),...
	}
}
