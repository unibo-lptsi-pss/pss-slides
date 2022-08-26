class A {
  int i;
  void stampa(){
    System.out.println("Sono un oggetto della classe A");
    System.out.println("Il mio valore di i è: " + this.i);
  }
}
..
A obj = new A();
obj.i = 12;
obj.stampa();