/* Versione specializzata di LimitCounter:
    - Stoppa il conteggio solo all'arrivo di stopNow().
    - Riusa switchOn del padre */
public class UnlimitedCounter extends LimitCounter{
    
    private boolean stopped;
   
    public UnlimitedCounter(){
      	super(0,-1);
      	this.stopped = false;
    }
    
    public void stopNow(){
    	this.stopped = true;
    }
    
    public boolean isOver(){
    	return this.stopped;
    } 
}
