package it.unibo.apice.oop.p09generics.iterators;

public class List<X>{
    
    private X head;
    private List<X> tail;
    
    public List(X head, List<X> tail){
    	this.head = head;
    	this.tail = tail;
    }
    
    public X getHead(){			// Testa della lista
    	return this.head;
    }
    
    public List<X> getTail(){		// Coda della lista
    	return this.tail;
    }
    
    public int getLength(){		// Dimensione della lista
    	return (this.tail == null) ? 1 : 1 + this.tail.getLength();
    }
    
    public String toString(){		// Rappr. a stringa
    	return "|"+this.head + 
    	       ((this.tail == null) ? "|" : this.tail.toString());
    }
} 
