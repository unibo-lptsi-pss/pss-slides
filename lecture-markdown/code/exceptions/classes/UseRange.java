public class UseRange {
   public static void main(String[] args) {
      // args tiene le stringhe passate da linea di comando!
      int a = Integer.parseInt(args[0]); // "5"
      int b = Integer.parseInt(args[1]); // "10"
      RangeIterator r = new RangeIterator(a, b);
      System.out.print(r.next() + " ");
      System.out.print(r.next() + " ");
      System.out.println(r.next());
   }
}
/*
 * Esecuzione: java UseRange 5 10
 * args vale: new String[]{"5","10"}
 * risultato: 5 6 7

 * Esecuzione: java UseRange 5 10.1
 * risultato: NumberFormatException

 * Esecuzione: java UseRange 5 3
 * risultato: IllegalArgumentException

 * Esecuzione: java UseRange 3 4
 * risultato: NoSuchElementException
 */
