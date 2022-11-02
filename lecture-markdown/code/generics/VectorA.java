public class Vector<X>{
    
    private final static int INITIAL_SIZE = 10;
    
    private Object[] elements; 	// No X[], devo usare Object[]!!
    private int size;		
    
    public Vector(){		
    	this.elements = new Object[INITIAL_SIZE]; // Object[]
    	this.size = 0;
    }
    
    public void addElement(X e){	// Tutto come atteso
    	if (this.size == elements.length){
    	    this.expand();	
    	}
    	this.elements[this.size] = e;
    	this.size++;
    }
    ...
