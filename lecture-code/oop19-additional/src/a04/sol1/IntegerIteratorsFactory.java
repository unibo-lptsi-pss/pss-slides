package a04.sol1;

import java.util.*;

/* 
 * A factory for various simple iterators over integers. 
 */

interface IntegerIteratorsFactory {
    
    /**
     * @return an empty iterator, producing no elements
     */
    SimpleIterator<Integer> empty();
    
    /**
     * @return an iterator over all elements in the list
     */
    SimpleIterator<Integer> fromList(List<Integer> list);
    
    /**
     * @return an iterator over size random elements in range 0..size-1
     */
    SimpleIterator<Integer> random(int size);
    
    /**
     * @return an infinite iterator of elements 1,2,2,3,3,3,4,4,4,4,5,5,...
     */
    SimpleIterator<Integer> quadratic();
    
    /**
     * @return an infinite iterator of elements 0,0,1,0,1,2,0,1,2,3,0,1,2,3,4,...
     */
    SimpleIterator<Integer> recurring();
    
}
