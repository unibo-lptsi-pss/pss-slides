package it.unibo.apice.oop.p02objects;

class UsePoint3D {
	public static void main(String[] s) {
		Point3D p = new Point3D(); // creo un punto p
		p.build(10.0, 20.0, 30.0); // ne imposto i valori
		Point3D q = new Point3D(); // creo un punto q
		q.build(10.0, 20.0, 31.0); // ne imposto i valori
		System.out.println("Modulo quadro di p: " + p.getModulo2());
		System.out.println("p è uguale a q? : " + p.equal(q));
	}
}