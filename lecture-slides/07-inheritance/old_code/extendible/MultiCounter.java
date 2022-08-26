public class MultiCounter extends ExtendibleCounter{
   
    public MultiCounter(int initialValue){
    	super(initialValue);
    }
    
    public void multiIncrement(int n){
    	// Ora realizzabile più efficientemente
    	if (n > 0) {
    	    this.value = this.value + n;
    	}
    }
}
