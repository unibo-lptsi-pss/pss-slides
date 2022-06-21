public class UseLimitedLamp {
    public static void main(String[] s){
    	// Caso 1, lampadina che si esaurisce dopo 3 switch
    	LimitedLamp lamp1 = new LimitedLamp(new LimitCounter(0,3));
    	lamp1.switchOn();
    	System.out.println("lamp1| "+lamp1);
    	for (int i=0;i<5;i++){
    	    lamp1.switchOff();
    	    lamp1.switchOn();
    	} // lampadina esaurita
    	System.out.println("lamp1| "+lamp1);
    	// Caso 2, lampadina che si esaurisce al comando stopNow
    	UnlimitedCounter ulc = new UnlimitedCounter();
    	LimitedLamp lamp2 = new LimitedLamp(ulc);
    	for (int i=0;i<100;i++){
    	    lamp1.switchOn();
    	    lamp1.switchOff();
    	} // lampadina non esaurita
    	System.out.println("lamp2| "+lamp2);
    	ulc.stopNow(); 		// lampadina esaurita ora
    	lamp2.switchOn();	// lo switchOn fallisce
    	System.out.println("lamp2| "+lamp2);
    }
}
