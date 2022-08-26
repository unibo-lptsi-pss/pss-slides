package it.unibo.apice.oop.p16lambda.first;

import java.util.*;

public class AllLambdas {

	private static int mycompare(final String a, final String b) { 
		return a.compareTo(b);
	}

	public static void main(String[] args) {
		final List<String> list = Arrays.asList("a", "bb", "c", "ddd");

		Collections.sort(list, (String a, String b) -> {
			return a.length() - b.length();
		});
		System.out.println(list); // [a, c, bb, ddd]

		Collections.sort(list, (a, b) -> {
			return a.length() - b.length();
		});
		System.out.println(list); // [a, c, bb, ddd]

		Collections.sort(list, (String a, String b) -> a.length() - b.length());
		System.out.println(list); // [a, c, bb, ddd]

		Collections.sort(list, (a, b) -> a.length() - b.length());
		System.out.println(list); // [a, c, bb, ddd]

		Collections.sort(list, (a, b) -> mycompare(a, b));
		System.out.println(list); // [a, c, bb, ddd]
	}
}
