public class LimitedLamp extends SimpleLamp{
    
    private LimitCounter counter;
    
    public LimitedLamp(int limit){
    	super(); // Questa istruzione è opzionale
    	this.counter = new LimitCounter(0,limit);
    }
    
    public void switchOn(){
    	if (!this.isSwitchedOn()){
    	    // incremento solo se è una vera accensione
    	    this.counter.increment(); 
    	}
    	if (!this.counter.isOver()){
    	    super.switchOn();
    	}
    }
    
    public int getRemainingLifeTime(){ // delegazione a counter
    	return this.counter.getDistanceToLimit();
    }
    
    public boolean isOver(){ // delegazione a counter
    	return this.counter.isOver();
    }
} 
