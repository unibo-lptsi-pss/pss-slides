class Sum {
	public static int sum(int[] array) { // soluzione standard
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		return sum;
	}

	public static int sum2(int[] array) { // soluzione con for-each
		int sum = 0;
		for (int elem : array) { // per ogni elem in array..
			sum = sum + elem;
		}
		return sum;
	}

	public static void main(String[] s) {
		int res = sum2(new int[] { 10, 20, 30, 40 });
		System.out.println("Somma : " + res);
	}
}
