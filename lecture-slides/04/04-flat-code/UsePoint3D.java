

class UsePoint3D {
	public static void main(String[] s) {
		
		Point3D p = new Point3D();
		
		Point3D q = new Point3D(10,20,30);
		
		Point3D z = new Point3D(10);
		
		
		System.out.println(p.x + "," + p.y + "," + p.z);
		System.out.println(q.x + "," + q.y + "," + q.z);
		System.out.println(z.x + "," + z.y + "," + z.z);
		
	}
}