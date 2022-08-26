public class BiCounter extends ExtendibleCounter{
   
    public BiCounter(int initialValue){
    	super(initialValue);
    }
    
    public void decrement(){
    	/* Ora this.counter è accessibile */
    	this.value--;
   }
}
