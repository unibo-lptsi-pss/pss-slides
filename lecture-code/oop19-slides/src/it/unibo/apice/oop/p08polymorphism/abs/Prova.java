package it.unibo.apice.oop.p08polymorphism.abs;

interface I {
    int getValore();
    String getDescrizione();
}

abstract class C implements I {
    public String getDescrizione(){
        return "desc";
    }
}

class D extends C{
    
    public int getValore(){
        return 1;
    }
    
}

public class Prova {

    public static void main(String[] args) {
        D obj = new D();
    }
}
