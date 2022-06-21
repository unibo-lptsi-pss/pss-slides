public class Lamp{
    
    /* Costanti luminosità */
    private final static double MIN_VAL = 0.0;
    private final static double MAX_VAL = 1.0;
    private final static double DELTA_VAL = 0.1;
    
    /* Campi della classe */
    private double intensity;
    private boolean switchedOn;
    
    /* Costruttore */
    public Lamp(){
    	this.switchedOn = false;
    	this.intensity = MIN_VAL;
    }
    
