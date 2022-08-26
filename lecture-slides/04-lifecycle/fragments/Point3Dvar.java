class Point3D {   // dichiarazione classe
    double x;
    double y;
    double z;
    Point3D(double x,double y,double z){
        this.x = x;	// metto l'argomento x in this.x
        this.y = y;	// ..
        this.z = z;	// ..
    }
    ...
}

//creo l'oggetto usando il costruttore a tre argomenti
Point3D p = new Point3D(10.0,20.0,30.0);
// stampo
System.out.println("p: " + p.x + "," + p.y + "," + p.z);	
