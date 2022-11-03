public class CountdownDevice extends AbstractDevice{
    
    private int countdown; // numero di on() prima di esaurimento
    
    public CountdownDevice(int countdown){
    	super(); // opzionale, ma meglio indicarlo
    	if (countdown < 1){ // meglio segnalare il problema..
    	    throw new IllegalArgumentException();
    	}
    	this.countdown = countdown;
    }
    
    protected boolean onFails(){ 
    	if (this.countdown == 0){ 
    		return true;
    	}
    	this.countdown--;
    	return false;
    }
    
    public String toString(){
    	return super.toString() + "." + this.countdown;
    }
} 