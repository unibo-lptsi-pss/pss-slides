/* Lista linkata di oggetti, con soli metodi getter */
public class ObjectList {

    private Object head;
    private ObjectList tail;

    public ObjectList(Object head, ObjectList tail) {
        this.head = head;
        this.tail = tail;
    }

    public Object getHead() { // Testa della lista
        return this.head;
    }

    public ObjectList getTail() { // Coda della lista
        return this.tail;
    }

    public int getLength() { // Dimensione della lista
        return (this.tail == null) ? 1 : 1 + this.tail.getLength();
    }

    public String toString() { // Rappr. a stringa
        return "|" + this.head +
                ((this.tail == null) ? "|" : this.tail.toString());
    }
}
