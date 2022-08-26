package it.unibo.apice.oop.p16lambda.optional;

import java.util.*;

public class UseOptional3 {

	public static void main(String[] args) {
		
		final List<Integer> list = Arrays.asList(10,20,30,null,null,50,60,null);
		System.out.println(list);
		
		final List<Optional<Integer>> olist = new ArrayList<>();
		list.forEach(i -> olist.add(Optional.ofNullable(i)));
		System.out.println(olist);
		
		final List<Integer> l2 = new ArrayList<>();
		olist.forEach(o -> o.ifPresent(l2::add));
		System.out.println(l2);
		
		
		final List<Optional<Integer>> olist2 = new ArrayList<>();
		olist.forEach(o -> olist2.add(o.filter(i -> i<60)));
		System.out.println(olist2);
		
		final List<Optional<String>> olist3 = new ArrayList<>();
		olist.forEach(o -> olist3.add(o.map(i -> i<40 ? "small" : "big")));
		System.out.println(olist3);
	}

}
