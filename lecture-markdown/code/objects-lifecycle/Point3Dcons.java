class Point3D {   // dichiarazione classe
    double x;
    double y;
    double z;
    Point3D(double inx,double iny,double inz){ //costruttore
        this.x = inx;	// metto l'argomento inx in this.x
        this.y = iny;	// ..
        this.z = inz;	// ..
    }
    ...
}

//creo l'oggetto usando il costruttore a tre argomenti
Point3D p = new Point3D(10.0,20.0,30.0);
// stampo
System.out.println("p: " + p.x + "," + p.y + "," + p.z);	
// costruttore di "default" in questo caso non funziona!
//Point3D p2=new Point3D(); NO!!