class Point3D {

    double x;
    double y;
    double z;

    void build(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    double getNormSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }
    
    boolean equal(Point3D other) {
        return this.x == other.x && this.y == other.y && this.z == other.z;    
    }
}