class Point3D {   // dichiarazione classe
  double x;       // 3 campi
  double y;
  double z;
  void build(double a,double b,double c){ // build
    this.x = a; this.y = b; this.z = c;
  }
  double getModuloQuadro(){               // getModuloQuadro
    return this.x * this.x + this.y * this.y + this.z * this.z;
  }
  boolean equal(Point3D q){		// equal
    return this.x == q.x && this.y == q.y && this.z == q.z;    
  }
}