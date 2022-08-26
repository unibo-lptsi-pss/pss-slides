/* Contatore con metodo isOver:
    - increment bloccato da isOver
    - costruttore con indicazione di limite */
public class LimitCounter extends ExtendibleCounter{
   
    protected int limit;
    
    public LimitCounter(int initialValue,int limit){
      	super(initialValue);
    	this.limit = limit;
    }
    
    public boolean isOver(){
    	return this.limit == this.counter;
    }
    
    public void increment(){
    	if (!this.isOver()){
    	    super.increment();
    	}
   }
}
