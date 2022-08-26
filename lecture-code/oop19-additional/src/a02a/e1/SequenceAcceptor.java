package a02a.e1;

/**
 * This interface models an object accepting sequences of integers, raising an exception if a wrong number is used.
 * By a resetting method one can specify which kind of sequence to accept, specified in the Sequence enum, as follows:
 * - POWER2: 1,2,4,8,16,32,64,128,..
 * - FLIP: 1,0,1,0,1,0,1,0,1,0,..
 * - RAMBLE: 0,1,0,2,0,3,0,4,0,5,0,6,.. 
 * - FIBONACCI: 1,1,2,3,5,8,13,.. (each number is the sum of previous two, starting with 1,1)
 * Trying to accept the wrong number at any point, or starting before a proper reset, leads to throw an IllegalStateException
 */

public interface SequenceAcceptor {
	
	static enum Sequence {
		POWER2, FLIP, RAMBLE, FIBONACCI; 
	}

	/**
	 * Initiates a new sequence
	 * 
	 * @param sequence, the kind of the sequence to reset to
	 */
	void reset(Sequence sequence);
	
	/**
	 * Initiates a new sequence using current kind
	 * 
	 * @param sequence, the kind of the sequence to reset to
	 */
	void reset();

	
	/**
	 * Consumes the next element of the current sequence.
	 * 
	 * @param i, the next element accept
	 * @throws a IllegalStateException if the input is not accepted
	 */
	void acceptElement(int i);
		
}
