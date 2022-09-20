package it.unibo.apice.oop.p04objects.points;

class Points { // Modulo con funzionalità per punti 
	
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