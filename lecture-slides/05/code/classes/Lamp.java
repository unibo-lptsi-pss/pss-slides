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
    
    /* Metodi per accendere e spegnere */
    public void switchOn(){
    	this.switchedOn = true;
    }
    
    public void switchOff(){
    	this.switchedOn = false;
    }
    
    /* Gestione intensita' */
    private void correctIntensity(){ // A solo uso interno
    	if (this.intensity < MIN_VAL) { 
    	    this.intensity = MIN_VAL; 
    	}
    	if (this.intensity > MAX_VAL) { 
    	    this.intensity = MAX_VAL; 
    	}
    	// Sistemo l'eventuale problema di resto
    	this.intensity -= this.intensity % DELTA_VAL;
    }
    public void dim(){
    	this.setIntensity(this.intensity - DELTA_VAL);
    }
    public void brighten(){
    	this.setIntensity(this.intensity + DELTA_VAL);
    }
    public void setIntensity(double value){
    	this.intensity = value;
    	this.correctIntensity();
    }
    
    /* Selettori */
    public double getIntensity(){
    	return this.intensity;
    }
    public boolean isSwitchedOn(){
    	return this.switchedOn;
    }
} 
