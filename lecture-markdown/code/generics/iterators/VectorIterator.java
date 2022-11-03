/* Itera tutti gli elementi di un Vector */
public class VectorIterator<E> implements Iterator<E> {

    private Vector<E> vector; // Vettore da iterare
    private int current; // Posizione nel vettore

    public VectorIterator(Vector<E> vector) {
        this.vector = vector;
        this.current = 0;
    }

    public E next() {
        return this.vector.getElementAt(this.current++);
    }

    public boolean hasNext() {
        return this.vector.getLength() > this.current;
    }
}
