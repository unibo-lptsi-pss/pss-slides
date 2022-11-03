public class UncheckedThrow {
	public static void main(String[] args) {
		int[] a = new int[] { 10, 20, 30 };
		int b = accessArray(a, 1); // OK
		int c = accessArray(a, 3); // Eccezione
	}

	public static int accessArray(int[] array, int pos) {
		if (pos < 0 || pos >= array.length) {
			String msg = "\nSei fuori dai limiti!.. " + pos;
			throw new java.lang.IllegalArgumentException(msg);
		}
		return array[pos];
	}
}

/*
 * Stampa dell'errore:
 * 
 * Exception in thread "main" java.lang.IllegalArgumentException:
 * Sei fuori dai limiti!.. 3
 * at UncheckedThrow.accessArray(UncheckedThrow.java:11)
 * at UncheckedThrow.main(UncheckedThrow.java:5)
 */
