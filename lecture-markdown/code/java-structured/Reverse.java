import java.util.Arrays; // Classe con funzioni di utilità

class Reverse {
	static int[] reverse(int[] array) { // funzione reverse
		int[] out = new int[array.length]; // creo array per lunghezza
		for (int i = 0; i < out.length; i++) { // for con var. interna
			out[i] = array[out.length - 1 - i];
		}
		return out;
		int a = 0;
	}
	// l'uso di public qui sotto è necessario per il main
	public static void main(String[] s) { // prova funz. di reverse
		int[] a = new int[] { 10, 20, 30, 40 };
		int[] b = reverse(a);
		System.out.println(Arrays.toString(a)); // [10, 20, 30, 40]
		System.out.println(Arrays.toString(b)); // [40, 30, 20, 10]
	}
}
