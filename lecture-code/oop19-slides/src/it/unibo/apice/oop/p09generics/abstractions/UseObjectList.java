package it.unibo.apice.oop.p09generics.abstractions;

public class UseObjectList {
	public static void main(String[] s) {
		final ObjectList list = 
				new ObjectList(10, new ObjectList(20, 
				new ObjectList(30, new ObjectList(40, null))));
		// Cast necessari, eccezioni possibili
		final int first = (Integer) list.getHead(); // Unboxing
		final int second = (Integer) list.getTail().getHead();
		final int third = (Integer) list.getTail().getTail().getHead();
		System.out.println(first + " " + second + " " + third);
		System.out.println(list.toString());
		System.out.println(list.getLength());

		// Usabile anche con le stringhe
		final ObjectList list2 = new ObjectList("a", 
				new ObjectList("b",
				new ObjectList("c", 
				new ObjectList("d", null))));
		System.out.println(list2.toString());
	}
}
