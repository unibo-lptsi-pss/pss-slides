public class Vector<X>{
    private Object[] elements = new Object[10]; // Deposito elementi
    private int size = 0;		// Numero di elementi
    
    public void addElement(X e){
    	if (this.size == elements.length){
    	    this.expand();	// Se non c'è spazio
    	}
    	this.elements[this.size] = e;
    	this.size++;
    }
    
    @SuppressWarnings("unchecked")
    public X getElementAt(int position){
    	return (X)this.elements[position];
    }
    
    public int getLength(){
    	return this.size;
    }

    private void expand(){	// Raddoppio lo spazio..
    	Object[] newElements = new Object[this.elements.length*2];
    	for (int i=0; i < this.elements.length; i++){
    	    newElements[i] = this.elements[i];
    	}
    	this.elements = newElements;
    }
}
