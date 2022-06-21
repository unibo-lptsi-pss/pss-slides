package it.unibo.apice.oop.p05encapsulation;

public class LampUtilities {

   /* Costruisco una fila di lampadine */
   public static Lamp[] buildLampRow(final int size) {
      final Lamp[] array = new Lamp[size];
      for (int index = 0; index < size; index++) {
         array[index] = new Lamp();
      }
      return array;
   }

   /* Accendo/spengo una fila di lampadine */
   public static void switchAll(final boolean switchedOn, final Lamp[] array) {
      for (Lamp l : array) {
         if (switchedOn) {
            l.switchOn();
         } else {
            l.switchOff();
         }
      }
   }
}
