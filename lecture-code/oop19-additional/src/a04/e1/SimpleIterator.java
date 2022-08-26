package a04.e1;

import java.util.Optional;

/**
 * An interface modelling a simple iterator of elements of type T
 * Note that it can also model an infinite stream of elements
 * 
 * @param <T>
 */
public interface SimpleIterator<T> {

	/**
	 * @return an empty optional if there are no more elements, otherwise it gives an optional 
	 * filled with the next element
	 */
	Optional<T> next();
}
