public class UseLamp2{
    private static boolean test1(){
    	Lamp l=new Lamp();
    	l.switchOn();
    	l.setIntensity(0.5);
    	l.dim();
    	l.dim();
    	l.brighten();
    	return (l.isSwitchedOn() && l.getIntensity()==0.4);
    }
    
    public static void main(String[] s){
    	System.out.println("Esito di test1: "+test1());
    }
}
