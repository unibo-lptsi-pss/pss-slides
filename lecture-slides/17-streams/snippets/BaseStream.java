public interface BaseStream<T, S extends BaseStream<T, S>> extends ... {

    // Torna un iteratore sugli elementi rimasti dello stream, e lo chiude
    Iterator<T> iterator();

    // spliterator è un iteratore che supporta parallelismo..
    Spliterator<T> spliterator();
    
    // è uno stream gestibili in modalità parallela
    boolean isParallel();

    // torna una variante sequenziale dello stream
    S sequential();

    // torna una variante parallela dello stream
    S parallel();

    // torna una variante non ordinata dello stream
    S unordered();
  
    // associa un handler chiamato alla chiusura dello stream
    S onClose(Runnable closeHandler);

    void close();
}
 
