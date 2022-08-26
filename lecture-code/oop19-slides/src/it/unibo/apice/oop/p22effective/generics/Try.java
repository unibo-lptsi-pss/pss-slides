package it.unibo.apice.oop.p22effective.generics;

import java.util.*;

public class Try {

	public static void main(String[] args) {
		
		Object[] o = new String[]{"1","2"};
		//o[0] = new Integer(10);  // eccezione
		
		List<Integer[]> list = new ArrayList<Integer[]>();
		list.add(new Integer[]{10,20,30});
		list.add(new Integer[]{40,50});
		
		List<Integer> l1 = Arrays.asList(10,20,30);
		List<Integer> l2 = Arrays.asList(40,50);
		//List<Integer>[] list2 = new List<Integer>[]{l1,l2}; // non compila

		List<Integer> li = Collections.unmodifiableList(Arrays.asList(10,20,30));
		//li.add(10);
		
		System.out.println(new Integer[10].getClass().getComponentType());
	}

}
