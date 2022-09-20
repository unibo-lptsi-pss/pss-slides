class SumMain {
	public static int sum(int[] array) { // soluzione con for-each
		int sum = 0;
		for (int elem : array) { // per ogni elem in array..
			sum = sum + elem;
		}
		return sum;
	}
	// da invocare con: java SumMain 10 20 30 40
	public static void main(String[] args) {
		int[] input = new int[args.length];
		for (int i = 0; i < input.length; i++){
			input[i] = Integer.parseInt(args[i]);
		}
		int res = sum(input);
		System.out.println("Somma : " + res);
	}
}
