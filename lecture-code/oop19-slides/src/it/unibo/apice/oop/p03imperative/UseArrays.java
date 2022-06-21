package it.unibo.apice.oop.p03imperative;

class UseArrays {
	public static void main(String[] s) {
		int[] a = new int[] { 10, 20, 30 };
		System.out.println("a: " + a[0] + " " + a[1] + " " + a[2]);
		double[] b = new double[] { 10.1, 10.2 };
		b[1] = 10.21;
		String[] c = new String[] { "10", "20", "3" + "0" };
		System.out.println("c.length: " + c.length);// 3
		boolean[] d = new boolean[10000];
		System.out.println("d[5000]: " + d[5000]); // false
		int[][] e = new int[5][5]; // matrice 5x5 di zeri
		int[][] f = new int[][] { new int[] { 11, 12, 13, 14 },
				new int[] { 21, 22, 23, 24 }, new int[] { 31, 32, 33, 34 } };
		System.out.println("f.length: " + f.length); // 3
		System.out.println("f[0].length: " + f[0].length); // 4
		System.out.println("f[1][2]: " + f[1][2]); // 23
		System.out.println("Error on f[1][4]: " + f[1][4]); //Exception
		// Versioni semplificate: 
		// int[] aa = {10,20,30};
		// int[][] aaa = {{10},{20},{30}};
	}
}