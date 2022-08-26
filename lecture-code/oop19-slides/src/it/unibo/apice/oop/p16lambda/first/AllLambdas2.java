package it.unibo.apice.oop.p16lambda.first;

import java.util.*;

public class AllLambdas2 {
	
	private static int staticMyCompare(final String a, final String b) {
		return a.compareTo(b);
	}
	private int instanceMyCompare(final String a, final String b) {
		return b.compareTo(a);
	}
	public static void main(String[] args) {
		final List<String> list = Arrays.asList("a", "bb", "c", "ddd");
		final AllLambdas2 objAL = new AllLambdas2();

		Collections.sort(list, (x,y) -> staticMyCompare(x,y));
		Collections.sort(list, AllLambdas2::staticMyCompare);  // same as above
		System.out.println(list); // [a, bb, c, ddd]

		Collections.sort(list, (x,y) -> objAL.instanceMyCompare(x, y));
		Collections.sort(list, objAL::instanceMyCompare);  // same as above
		System.out.println(list); // [ddd, c, bb, a]
		
		Collections.sort(list, (x,y) -> x.compareTo(y));
		Collections.sort(list, String::compareTo);  // same as above
		System.out.println(list); // [ddd, c, bb, a]
	}
}
