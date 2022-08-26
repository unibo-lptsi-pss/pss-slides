
public class Lamp implements Device{
    
    /* Costanti luminosita' */
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
    
    /* Metodi per accendere e spegnere */
    public void switchOn(){
    	this.switchedOn = true;
    }
    
    public void switchOff(){
    	this.switchedOn = false;
    }
    
    /* Gestione intensita' */
    private void correctIntensity(){ // Funzione a solo uso iterno
    	if (this.intensity < MIN_VAL) { 
    	    this.intensity = MIN_VAL; 
    	}
    	if (this.intensity > MAX_VAL) { 
    	    this.intensity = MAX_VAL; 
    	}
    }
    public void dim(){
    	this.setIntensity(this.intensity + DELTA_VAL);
    }
    public void brighten(){
    	this.setIntensity(this.intensity - DELTA_VAL);
    }
    public void setIntensity(double value){
    	this.intensity = value;
    	this.correctIntensity();
    }
    
    /* Osservatori */
    public double getIntensity(){
    	return this.intensity;
    }
    public boolean isSwitchedOn(){
    	return this.switchedOn;
    }
    
    public String toString(){
        return "I'm a Lamp..";
    }
} 
