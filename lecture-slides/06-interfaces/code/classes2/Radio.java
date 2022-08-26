public class Radio implements Device{
    
    /* Campi della classe */
    private boolean switchedOn;
    
    /* Costruttore */
    public Radio(){
    	this.switchedOn = false;
    }
    
    /* Metodi per accendere e spegnere */
    public void switchOn(){
    	this.switchedOn = true;
    }
    
    public void switchOff(){
    	this.switchedOn = false;
    }
    
    public boolean isSwitchedOn(){
    	return this.switchedOn;
    }
    
    public String toString(){
        return "I'm a Radio..";
    }
} 
