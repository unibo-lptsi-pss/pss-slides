public class LimitCounter extends ExtendibleCounter{
   
    /* Aggiungo un campo, che tiene il limite */
    protected int limit;
    
    /* Fornisco un costruttore con 2 argomenti */
    public LimitCounter(int initialValue,int limit){
      	super(initialValue);
    	this.limit = limit;
    }
    
    public boolean isOver(){
    	return this.value == this.limit;
    }
    
    /* Overriding del metodo increment() */
    public void increment(){
    	// richiamo la versione del padre
    	if (!this.isOver()){
    	    super.increment(); // o anche..  this.value++;
    	}
   }
}
