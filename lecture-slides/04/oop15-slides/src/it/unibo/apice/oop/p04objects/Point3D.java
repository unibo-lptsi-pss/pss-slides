package it.unibo.apice.oop.p04objects;

class Point3D { // dichiarazione classe
	double x; // 3 campi
	double y;
	double z;

	Point3D build(double a, double b, double c) { // build con ritorno
		this.x = a;
		this.y = b;
		this.z = c;
		return this;
	}

	double getModuloQuadro() { 
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}

	static Point3D zero = new Point3D().build(0, 0, 0);

	static Point3D max(Point3D[] ps) { // metodo statico
		Point3D max = zero; // ricerca max
		for (Point3D elem : ps) {
			if (elem.getModuloQuadro() > max.getModuloQuadro()) {
				max = elem;
			}
		}
		return max;
	}
}