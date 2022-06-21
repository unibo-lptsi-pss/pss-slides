package it.unibo.apice.oop.p05encapsulation;

public class UseLampString{

	public static void main(String[] s){
		LampString l=new LampString();
    	l.switchOn();
    	l.setIntensity(0.5);
    	l.dim();
    	l.dim();
    	l.brighten();
    	System.out.println(l.toString());
    	System.out.println("Oppure : "+l);
    }
}
