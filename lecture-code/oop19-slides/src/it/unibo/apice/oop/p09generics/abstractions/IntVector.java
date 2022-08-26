package it.unibo.apice.oop.p09generics.abstractions;

public class IntVector{
    
    private static final int INITIAL_SIZE = 10;
    
    private int[] elements; // Deposito per gli elementi
    private int size;		// Numero di elementi
    
    public IntVector(){		// Inizialmente vuoto
    	this.elements = new int[INITIAL_SIZE];
    	this.size = 0;
    }
    
    public void addElement(final int e){
    	if (this.size == elements.length){
    	    this.expand();	// Se non c'è più spazio..
    	}
    	this.elements[this.size] = e;
    	this.size++;
    }
    
    public int getElementAt(final int position){
    	return this.elements[position];
    }
    
    public int getLength(){
    	return this.size;
    }
    
    private void expand(){	// Raddoppio lo spazio..
    	final int[] newElements = new int[this.elements.length*2];
    	for (int i=0; i < this.elements.length; i++){
    	    newElements[i] = this.elements[i];
    	}
    	this.elements = newElements;
    	//this.elements = java.util.Arrays.copyOf(this.elements, this.elements.length*2);
    }
    
    public String toString(){
    	String s="|";
    	for (int i=0; i < size; i++){
    	    s = s + this.elements[i] + "|";
    	}
    	return s;
    }
}
