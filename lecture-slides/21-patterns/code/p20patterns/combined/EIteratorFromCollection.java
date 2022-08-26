package it.unibo.apice.oop.p18patterns.combined;

// Un adattatore da Collection a EIterator
public class EIteratorFromCollection<X> implements EIterator<X>{
	private java.util.Iterator<X> iterator;
	
	public EIteratorFromCollection(java.util.Collection<X> c){
		this.iterator = c.iterator();
	}
	
	@Override
	public X next(){
		return this.iterator.next();
	}
}
