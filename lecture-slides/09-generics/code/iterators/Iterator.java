public interface Iterator<E>{
  
    // torna il prossimo elemento dell'iterazione
    E next();
    
    // dice se vi saranno altri elementi
    boolean hasNext();
    
    /* Nota: non è noto cosa succede se si 
       chiama next() quando hasNext() ha dato 
       esito falso */
}
