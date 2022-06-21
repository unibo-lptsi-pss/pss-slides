package it.unibo.apice.oop.p04objects.points;

class Point3D { 
	double x;
	double y;
	double z;

	Point3D build(double a, double b, double c) {
		this.x = a;
		this.y = b;
		this.z = c;
		return this;
	}

	double getModuloQuadro() { 
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}

}