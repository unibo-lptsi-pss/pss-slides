public class Cov {

	public static void printAll(Vector<? extends Number> vect) {
		// Questo metodo usa solo 'X getElementAt()'
		// Quindi l'input può essere covariante!
		// Si noti che Number definisce 'int intValue()'
		for (int i = 0; i < vect.getLength(); i++) {
			System.out.println(vect.getElementAt(i).intValue());
		}
	}

	public static void main(String[] s) {
		Vector<Integer> vector = new Vector<>();
		vector.addElement(1);
		vector.addElement(2);
		vector.addElement(3);
		// Posso passare Vector<Integer> dove si attende
		// Vector<? extends Number>
		printAll(vector);
	}
}
