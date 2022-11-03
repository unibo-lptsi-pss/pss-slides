public class UseRange2 {
	public static void main(String[] s) {
		RangeIterator r = null; // va creata fuori dal try..
		try {
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			r = new RangeIterator(a, b);
		} catch (Exception e) { // varie exception possibili
			System.out.println("Sorry! Argomenti errati");
			System.out.println(e);
			System.exit(1); // abnormal termination
		}
		try {
			System.out.print(r.next() + " ");
			System.out.print(r.next() + " ");
			System.out.println(r.next());
		} catch (java.util.NoSuchElementException e) {
			System.out.println("Sorry! Fuori dai limiti..");
			System.exit(1); // abnormal termination
		}
		System.exit(0); // ok termination
	}
}
