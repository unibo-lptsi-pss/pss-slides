

class Point3D { // dichiarazione classe
	double x; // 3 campi
	double y;
	double z;
	
	Point3D(){
		this();
	}
	
	Point3D(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	Point3D(double d){
		this(d,d,d);
		System.out.println("Ho creato un oggetto col terzo costruttore");
	}
	

}