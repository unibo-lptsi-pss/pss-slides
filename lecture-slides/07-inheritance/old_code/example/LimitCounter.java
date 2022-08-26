public class LimitCounter extends ExtendibleCounter{
   
    protected int limit;
    
    public LimitCounter(int initialValue,int limit){
      	super(initialValue);
    	this.limit = limit;
    }
    
    public boolean isOver(){
    	return this.getDistanceToLimit() == 0;
    }
    
    public int getDistanceToLimit(){
    	return this.limit-this.value;
    }
    
    public void increment(){
    	if (!this.isOver()){
    	    super.increment();
    	}
   }
}
