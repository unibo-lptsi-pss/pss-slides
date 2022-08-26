public class TwoLampsDevice{
    
    /* Composizione di due Lamp! */
    private Lamp l1; // Potrei realizzare lo stato con un array
    private Lamp l2; // I clienti non ne sarebbero influenzati!
    
    /* Composizione inizializzata al momento della costruzione */
    public TwoLampsDevice(){
    	this.l1 = new Lamp();
    	this.l2 = new Lamp();
    }
    
    /* Metodi getter */
    public Lamp getFirst(){
    	return this.l1;
    }
    
    public Lamp getSecond(){
    	return this.l2;
    } 
