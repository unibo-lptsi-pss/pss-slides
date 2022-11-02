/* Itera tutti gli elementi di una List */
public class ListIterator<E> implements Iterator<E>{
    
    private List<E> list; // Lista corrente
    
    public ListIterator(List<E> list){
    	this.list = list;
    }
    
    public E next(){
    	E element = this.list.getHead();// Elemento da tornare
    	this.list = this.list.getTail();// Aggiorno la lista
    	return element;
    }
    
    public boolean hasNext(){
    	return (this.list != null);
    }
}
