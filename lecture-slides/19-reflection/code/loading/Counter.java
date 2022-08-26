class Counter{
    
    /* Il campo è reso inaccessibile direttamente */
    private int countValue;
    
    /* E' il costruttore che inizializza i campi */ 
    public Counter(){
    	this.countValue=0;
    }
    
    /* Unico modo per osservare lo stato */
    public int getValue(){
    	return this.countValue;
    }
    
    /* Unico modo per modificare lo stato */
    public void increment(){
    	this.countValue++;
    } 
} 
