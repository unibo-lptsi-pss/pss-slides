/**
 * Point3D is an example class for students.
 * It showcases some functionality of OO in Java
 * All properties have default (package) access
 */

public class ImmutablePoint3D{   
    
    private final double x;	// x coordinate   
    private final double y;	// y coordinate
    private final double z;	// z coordinate
  
    public ImmutablePoint3D(double x,double y, double z){
    	this.x=x;
    	this.y=y;
    	this.z=z;
    }
    
    /* Some simple functions that extract useful info from a point */
    
    public double getSquareModule(){
    	return this.x*this.x+this.y*this.y+this.z*this.z;
    }
    
    /* The following three are called selector methods */
    
    public double getX(){		
    	return this.x;
    }
    
    public double getY(){
    	return this.y;
    }
    
    public double getZ(){
    	return this.z;
    }
    
    /* An example of a method changing the object state */
    public ImmutablePoint3D translate(double x,double y,double z){
    	return new ImmutablePoint3D(this.x + x,this.y+y, this.z+z);
    }
}