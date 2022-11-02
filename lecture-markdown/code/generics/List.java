/* Classe generica in X:
   - X è il tipo degli elementi della lista */
public class List<X>{	
    
    private final X head;	   // Testa della lista, tipo X
    private final List<X> tail;  // Coda della lista, tipo List<X>
    
    public List(final X head, final List<X> tail){
    	this.head = head;
    	this.tail = tail;
    }
    
    public X getHead(){			
    	return this.head;
    }
    
    public List<X> getTail(){	
    	return this.tail;
    }
    
    // getLength() e toString() invariate
    ...
} 
