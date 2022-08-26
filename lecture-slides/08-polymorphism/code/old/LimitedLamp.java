public class LimitedLamp extends SimpleLamp{
    
    private LimitCounter counter;
    
    public LimitedLamp(LimitCounter counter){
    	super(); // Questa istruzione è opzionale
    	this.counter = counter;
    }
    
    public void switchOn(){
    	if (!this.counter.isOver()){  // Se non è Over, accendo
    	    super.switchOn();
    	}
    	if (!this.isSwitchedOn()){    // Se sono riuscito, incremento
    	    this.counter.increment();
    	}
    }
        
    public boolean isOver(){ // delegazione a counter
    	return this.counter.isOver();
    }
    
    public String toString(){ // nota: "\t" è un TAB
    	return "\tisOver: "+this.isOver()+
    	       ";\t status: "+this.isSwitchedOn();
    }
} 
