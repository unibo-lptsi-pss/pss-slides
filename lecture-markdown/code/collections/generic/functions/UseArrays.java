import java.util.*;

public class UseArrays implements Comparator<Integer> {

	public int compare(Integer a, Integer b) {
		return b - a; // ordine inverso
	}

	public static void main(String[] s) {
		Integer[] a = new Integer[20];
		for (int i = 0; i < 20; i++) {
			a[i] = (int) (Math.random() * 100);
		}
		System.out.println("rand: " + Arrays.toString(a));
		Arrays.sort(a); // sort in ordine naturale
		System.out.println("sort1: " + Arrays.toString(a));
		Arrays.sort(a, new UseArrays()); // sort col comparator
		System.out.println("sort2: " + Arrays.toString(a));
		Arrays.fill(a, 10, 15, 0); // fill nel range
		System.out.println("fill: " + Arrays.toString(a));

		Integer[][] b = new Integer[10][];
		Arrays.fill(b, a); // fill di un array di array
		System.out.println("recu: " + Arrays.deepToString(b));
	}
}
