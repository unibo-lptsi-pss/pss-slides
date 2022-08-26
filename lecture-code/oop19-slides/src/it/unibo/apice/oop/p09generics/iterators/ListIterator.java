package it.unibo.apice.oop.p09generics.iterators;

/* Itera tutti gli elementi di una List */
public class ListIterator<E> implements Iterator<E>{
    
    private List<E> list; // Lista corrente
    
    public ListIterator(final List<E> list){
    	this.list = list;
    }
    
    public E next(){
    	final E element = this.list.getHead();// Elemento da tornare
    	this.list = this.list.getTail();// Aggiorno la lista
    	return element;
    }
    
    public boolean hasNext(){
    	return (this.list != null);
    }
}
