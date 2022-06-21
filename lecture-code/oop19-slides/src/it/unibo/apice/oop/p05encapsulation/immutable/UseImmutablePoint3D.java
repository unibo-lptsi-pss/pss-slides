package it.unibo.apice.oop.p05encapsulation.immutable;

public class UseImmutablePoint3D {

   public static void main(String[] args) {
      final ImmutablePoint3D p = new ImmutablePoint3D(10, 20, 30);
      // l'oggetto puntato da p non potrà essere modificato

      ImmutablePoint3D q = p.translate(1, 1, 1);
      // q punta ad un nuovo oggetto

      System.out.println(p.getX() + " " + p.getY() + " " + p.getZ());
      // 10,20,30
      System.out.println(q.getX() + " " + q.getY() + " " + q.getZ());
      // 11,21,31

      q = q.translate(1, 1, 1);
      // la variabile q punta ad un nuovo oggetto
      // il vecchio verrà eleminato dal GC

      System.out.println(q.getX() + " " + q.getY() + " " + q.getZ());
      // 12,22,32
   }
}
