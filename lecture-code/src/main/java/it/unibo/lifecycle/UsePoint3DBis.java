package it.unibo.lifecycle;

class UsePoint3DBis {
	public static void main(String[] s) {
		// creo vari punti
		Point3DBis p1 = new Point3DBis().build(10, 20, 30);
		Point3DBis p2 = new Point3DBis().build(5, 6, 7);
		Point3DBis p3 = new Point3DBis().build(100, 100, 100);
		Point3DBis p4 = Point3DBis.zero; // questo è lo zero

		// costruisco l'array
		Point3DBis[] array = new Point3DBis[] { p1, p2, p3, p4 };

		// calcolo il max
		Point3DBis max = Point3DBis.max(array);

		// stampo
		System.out.println("Max: " + max.x + "," + max.y + "," + max.z);
	}
}