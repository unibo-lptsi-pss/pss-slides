package it.unibo.apice.oop.p06interfaces.domo;

public class Prova {

    public static void main(String[] args) {
        
        
        Device dev = Math.random()>0.5 ? new Lamp() : new TV();
        Lamp lamp = (Lamp)dev;
        lamp.setIntensity(0.5);

    }

}
