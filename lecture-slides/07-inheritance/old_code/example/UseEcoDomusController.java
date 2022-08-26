public class UseEcoDomusController {
    public static void main(String[] s){
    	// Simulazione sessione di lavoro
    	EcoDomusController controller;
    	controller = new EcoDomusController(5,10);
    	System.out.println(""+controller);
    	// off(10) | off(10) | off(10) | off(10) | off(10) |
    	LimitedLamp l=controller.getLamp(0);
    	l.switchOn();
    	l.switchOff();
    	l.switchOn();
    	System.out.println(""+controller);
    	// on(8) | off(10) | off(10) | off(10) | off(10) | 
    	controller.switchOnOne();
    	controller.switchOnOne();
    	controller.switchOnOne();
    	controller.switchOnOne();
    	System.out.println(""+controller);
    	// on(8) | on(9) | on(9) | on(9) | on(9) |
    }
} 
