package it.unibo.lifecycle;

class Point3Dvar {   // dichiarazione classe
    double x;
    double y;
    double z;
    Point3Dvar(double x, double y, double z){
        this.x = x;	// metto l'argomento x in this.x
        this.y = y;	// ..
        this.z = z;	// ..
    }
    // ...
    public static void main(String[] args){
        //creo l'oggetto usando il costruttore a tre argomenti
        Point3Dvar p = new Point3Dvar(10.0,20.0,30.0);
        // stampo
        System.out.println("p: " + p.x + "," + p.y + "," + p.z);	
    }
}