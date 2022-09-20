package it.unibo.lifecycle;

public class Point3Dcons {   // dichiarazione classe
    double x;
    double y;
    double z;
    Point3Dcons(double inx,double iny,double inz){ //costruttore
        this.x = inx;	// metto l'argomento inx in this.x
        this.y = iny;	// ..
        this.z = inz;	// ..
    }
    
    public static void main(String[] args){
        //creo l'oggetto usando il costruttore a tre argomenti
        Point3Dcons p = new Point3Dcons(10.0,20.0,30.0);
        // stampo
        System.out.println("p: " + p.x + "," + p.y + "," + p.z);	
        // costruttore di "default" in questo caso non funziona!
        //Point3D p2=new Point3D(); NO!!
    }
}