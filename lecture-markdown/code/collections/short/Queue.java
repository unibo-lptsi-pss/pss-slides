public interface Queue<E> extends Collection<E> {
    boolean offer(E e); // inserisce se c'è spazio
    E poll();		// preleva se c'è il primo
    E element();        // legge se c'è il primo, altrimenti eccezione
    E peek();		// legge se c'è il primo, altrimenti null
}
