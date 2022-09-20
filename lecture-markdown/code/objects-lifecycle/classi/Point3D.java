package classi;

public class Point3D { // dichiarazione classe
	public double x; // 3 campi
	public double y;
	public double z;

	public Point3D build(double a, double b, double c) { // build con ritorno
		this.x = a;
		this.y = b;
		this.z = c;
		return this;
	}

	public double getModuloQuadro() { 
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}

	public static Point3D zero = new Point3D().build(0, 0, 0);

	public static Point3D max(Point3D[] ps) { // metodo statico
		Point3D max = zero; // ricerca max
		for (Point3D elem : ps) {
			if (elem.getModuloQuadro() > max.getModuloQuadro()) {
				max = elem;
			}
		}
		return max;
	}
}