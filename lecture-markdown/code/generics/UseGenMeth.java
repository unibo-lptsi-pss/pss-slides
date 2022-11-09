public class Vector<X> {
	// ...
	<E> Vector<Pair<X, E>> genVectorPair(E e) {
		Vector<Pair<X, E>> vp = new Vector<>(); // Inferenza
		for (int i = 0; i < this.size; i++) {
			vp.addElement(new Pair<>(this.getElementAt(i), e));
		}
		return vp;
	}
}

public class UseGenMeth {
	public static void main(String[] s) {
		Vector<String> vs = new Vector<>();
		vs.addElement("prova");
		vs.addElement("di");
		vs.addElement("vettore");
		Vector<Pair<String, Integer>> vp = vs.<Integer>genVectorPair(101);
		// versione con inferenza..
		// Vector<Pair<String,Integer>> vp2 = vs.genVectorPair(101);
		System.out.println(vp);
		// |<prova,101>|<di,101>|<vettore,101>|
	}
}
