package it.unibo.apice.oop.p04objects;

class UsePoint3D {
	public static void main(String[] s) {
		// creo e inizializzo vari punti
		Point3D p1 = new Point3D();
		p1.build(10, 20, 30);
		Point3D p2 = new Point3D();
		p2.build(5, 6, 7);
		Point3D p3 = new Point3D();
		p3.build(100, 100, 100);
		Point3D p4 = Point3D.zero; // questo è lo zero

		// costruisco l'array
		Point3D[] array = new Point3D[] { p1, p2, p3, p4 };

		// calcolo il max
		Point3D max = Point3D.max(array);

		// stampo
		System.out.println("Max: " + max.x + "," + max.y + "," + max.z);
	}
}