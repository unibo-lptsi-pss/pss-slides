package it.unibo.apice.oop.p05encapsulation;

public class UseLamp {
   private static void test1() {
      final Lamp l = new Lamp();
      System.out.println(l);
      l.switchOn();
      l.setIntensity(0.5);
      l.dim();
      l.dim();
      System.out.println(l);
      l.brighten();
      System.out.println(l);
      // Acceso: true Intensità: 0.4
   }

   public static void main(final String[] s) {
      UseLamp.test1();
      // altri test...
   }
}
