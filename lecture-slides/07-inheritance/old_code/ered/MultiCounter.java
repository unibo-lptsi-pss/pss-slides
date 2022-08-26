/* Si noti la clausola extends */
public class MultiCounter extends Counter{
    
    /* I costruttori vanno ridefiniti.
       Devono tuttavia richiamare quelli ereditati
       dalla sopraclasse */
    public MultiCounter(int initialValue){
    	/* Inizializza i campi ereditati
    	   come farebbe new Counter(initialValue) */
    	super(initialValue);
    }
   
    public void multiIncrement(int n){
    	for (int i=0;i<n;i++){
    	    this.increment(); 
    	}
    }
}
