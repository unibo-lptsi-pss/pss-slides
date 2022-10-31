package java.util;

public final class Optional<T> {
    
    // metodi statici di costruzione 
    public static<T> Optional<T> empty() {..}
    public static <T> Optional<T> of(T value) {..}
    public static <T> Optional<T> ofNullable(T value) {..}
    
    // selettori
    public T get() {..} // throws NoSuchElementException on null
    public boolean isPresent() {..}
    public T orElse(T other) { .. }
    
    // uso di funzioni
    public T orElseGet(Supplier<? extends T> other) {..}
    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {..}
    public void ifPresent(Consumer<? super T> consumer) {..}
    public Optional<T> filter(Predicate<? super T> predicate) {..}
    public <U> Optional<U> map(Function<? super T, ? extends U> mapper) {..}
    public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper) {..}

}
 
