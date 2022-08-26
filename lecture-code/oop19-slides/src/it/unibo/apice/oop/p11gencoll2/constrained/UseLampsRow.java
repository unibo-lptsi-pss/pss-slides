package it.unibo.apice.oop.p11gencoll2.constrained;

public class UseLampsRow {
    
    public static void main(String[] s){
    	final LampsRow<UnlimitedLamp> lr = new LampsRow<>();
    	lr.addLamp(new UnlimitedLamp());
    	lr.addLamp(new UnlimitedLamp());
    	lr.addLamp(new UnlimitedLamp());
    	
    	lr.getLamp(0).switchOn();
    	lr.switchOffAll();
    	
    	System.out.println(lr.getLamp(0).isOver());
    	System.out.println(lr);
    }
}
