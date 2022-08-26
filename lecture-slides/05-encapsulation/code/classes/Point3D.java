/**
 * Point3D is an example class for students.
 * It showcases some functionality of OO in Java
 * All properties have default (package) access
 */

public class Point3D{   
    
    /* A Point3D object is made of three doubles, and has
    few functions to manipulate them */
	
    // A constant ZERO point
    static final Point3D ZERO=new Point3D(0,0,0);
  	
    double x;	// x coordinate   
    double y;	// y coordinate
    double z;	// z coordinate
  
    /* A standard constructor initializing fields */
    Point3D(double x,double y, double z){
    	this.x=x;
    	this.y=y;
    	this.z=z;
    }
    
    /* Some simple functions that extract useful info from a point */
    
    double getSquareModule(){
    	return this.x*this.x+this.y*this.y+this.z*this.z;
    }
    
    /* The following three are called selector methods */
    
    double getX(){		
    	return this.x;
    }
    
    double getY(){
    	return this.y;
    }
    
    double getZ(){
    	return this.z;
    }
    
    /* An example of a method changing the object state */
    void translate(double x,double y,double z){
    	this.x += x;
    	this.y += y;
    	this.z += z;
    }
  
    /* We also provide an example static method */
    static Point3D max(Point3D[] ps){			
    	Point3D max=Point3D.ZERO;		// Inizializing max
    	for(Point3D elem:ps){			// Iterating over all input points
    	    if (elem.getSquareModule()>max.getSquareModule()){	
    	        max=elem;				// Update max if needed..
    	    }
    	}
    	return max;					    // Return max
    }
}