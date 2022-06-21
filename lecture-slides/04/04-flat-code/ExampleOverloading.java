

class ExampleOverloading {
	static int m(double a, int b) {
		return 1;
	}

	static int m(int a, double b) {
		return 2;
	}

	static int m2(double a, double b) {
		return 1;
	}

	static int m2(int a, int b) {
		return 2;
	}

	public static void main(String[] s) {
		// System.out.println(""+m(1,1)); AMBIGUOUS!
		// System.out.println(""+m(1.5,1.5)); NO COMPATIBLE!

		System.out.println("" + m2(1.5, 1.5)); // 1
		System.out.println("" + m2(1, 1)); // 2
	}

}
