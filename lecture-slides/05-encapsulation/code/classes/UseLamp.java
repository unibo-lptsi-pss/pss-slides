public class UseLamp{
    private static void test1(){
    	Lamp l=new Lamp();
    	l.switchOn();
    	l.setIntensity(0.5);
    	l.dim();
    	l.dim();
    	l.brighten();
    	System.out.println(
    	    "Acceso: "+l.isSwitchedOn()+
    	    " Intensità: "+l.getIntensity());
    	// Acceso: true Intensità: 0.4
    }
    
    public static void main(String[] s){
    	UseLamp.test1();
    	// altri test...
    }
}
