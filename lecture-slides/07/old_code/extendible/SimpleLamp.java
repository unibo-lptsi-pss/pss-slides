public class SimpleLamp{
    
    /* Campi della classe */
    private boolean switchedOn;
    
    /* Costruttore di default */
    public SimpleLamp(){
    	this.switchedOn = false;
    }
    
    /* Metodi per accendere e spegnere */
    public void switchOn(){
    	this.switchedOn = true;
    }
    
    public void switchOff(){
    	this.switchedOn = false;
    }
    
    /* Getter */
    public boolean isSwitchedOn(){
    	return this.switchedOn;
    }
} 
