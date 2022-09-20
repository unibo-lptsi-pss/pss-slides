package it.unibo.structured;

class TryChars {
	public static void main(String[] s) {
		System.out.println("lettera 'a' e a capo" + 'a');
		System.out.println("acqua (cinese) e a capo " + '\u6C34');
		System.out.println("backslash e a capo" + '\\');
		System.out.print("a capo " + '\n');
		System.out.print("a capo " + (char) 10);
	}
}
