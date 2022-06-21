public class MultiCounter{
   
    private int value; 
    
    public MultiCounter(int initialValue){
    	this.value = initialValue;
    }
    
    public void increment(){
    	this.value++;
    }
    
    public int getValue(){
    	return this.value;
    }
    
    /* Nuovo metodo */
    public void multiIncrement(int n){
    	for (int i=0;i<n;i++){
    	    this.increment();
    	}
    }
}
