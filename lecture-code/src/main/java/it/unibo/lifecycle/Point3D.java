package it.unibo.lifecycle;

class Point3D { // dichiarazione classe
	double x; // 3 campi
	double y;
	double z;

	void build(double a, double b, double c) {
		this.x = a;
		this.y = b;
		this.z = c;
	}

	double getModuloQuadro() { 
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}

	static Point3D zero = new Point3D(); // 0,0,0

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