package test;

import classi.Point3D; 

class UsePoint3D {
	public static void main(String[] s) {
		
		Point3D p1 = new classi.Point3D().build(10, 20, 30);
		p1 = null;
		
		System.out.println(p1.x + "," + p1.y + "," + p1.z);
	}
}