package it.unibo.apice.oop.p06interfaces.domo;

public class UseDomusController{
    
    public static void main(String[] s){
    	// Creo un DomusController
    	final DomusController dc = new DomusController(10);
    	
    	// Installo dei dispositivi
    	dc.installDevice(0,new Lamp());
    	dc.installDevice(1,new Lamp());
    	dc.installDevice(2,new Lamp());
    	dc.installDevice(3,new TV());
    	dc.installDevice(4,new TV());
    	dc.installDevice(5,new Radio());
    	
    	// Li accendo tutti
    	dc.switchAll(true);
    	
    	// Verifico l'accensione
    	final boolean b = dc.isCompletelySwitchedOn(); // true
    }
}
