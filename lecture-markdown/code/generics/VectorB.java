    ...
    public X getElementAt(int position){  
    	return (X)this.elements[position]; // Conversione a X
    	// Genera un unchecked warning!
    }
    
    private void expand(){	
    	// Ancora Object[]
    	Object[] newElements = new Object[this.elements.length*2];
    	for (int i=0; i < this.elements.length; i++){
    	    newElements[i] = this.elements[i];
    	}
    	this.elements = newElements;
    }
    
    // getLength() e toString() inalterate
    ...
}
