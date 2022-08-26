public class UnlimitedCounter extends LimitCounter{
    
    public UnlimitedCounter(){
      	super(0,Integer.MAX_VALUE);
    }
    
    public int getDistanceToLimit(){
        // Quindi il contatore non scade mai
    	return Integer.MAX_VALUE;
    }
}
