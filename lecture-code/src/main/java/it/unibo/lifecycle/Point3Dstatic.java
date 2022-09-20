package it.unibo.lifecycle;

class Point3Dstatic {   // dichiarazione classe
    // ...
    static Point3D zero;
    static Point3D uno;
    static{		  // inizializzazione campi statici
        zero = new Point3D();  
        zero.build(0,0,0);
        uno = new Point3D();
        uno.build(1,1,1);
    }
    // ...
}