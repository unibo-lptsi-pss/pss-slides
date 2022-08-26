package a02a.sol1;

import java.util.*;
import java.util.stream.Stream;

public class SequenceAcceptorImpl implements SequenceAcceptor {
	
	private static Map<Sequence,Iterable<Integer>> sequences;
	
	static {
		sequences = new HashMap<>();
		sequences.put(Sequence.POWER2, ()->Stream.iterate(1,x->x*2).iterator());
		sequences.put(Sequence.FLIP, ()->Stream.iterate(1,x->1-x).iterator());
		sequences.put(Sequence.RAMBLE, ()->Stream.iterate(new Pair<>(0,1),p->new Pair<>(0,p.getY()+1))
				                                 .flatMap(p->Stream.of(p.getX(),p.getY()))
				                                 .iterator());
		/* 
		//alternative, non-stream-based implementation
		sequences.put(Sequence.RAMBLE, ()->new Iterator<Integer>() {
			int counter=0;
			public boolean hasNext() {
				return true;
			}
			public Integer next() {
				return counter++ % 2 == 0 ? 0 : counter/2;
			}
		});
		*/
		sequences.put(Sequence.FIBONACCI, ()->Stream.iterate(new Pair<>(1,1),p->new Pair<>(p.getY(),p.getX()+p.getY()))
													.map(Pair::getX)
													.iterator());
	}
	
	private Sequence seq;
	private Iterator<Integer> it;
	
	private void checkValidity() {
		if (seq == null) {
			throw new IllegalStateException();
		}
	}

	@Override
	public void reset(Sequence sequence) {
		this.seq = sequence;
		this.it = sequences.get(sequence).iterator();
	}

	@Override
	public void reset() {
		this.checkValidity();
		this.it = sequences.get(this.seq).iterator();
	}

	@Override
	public void acceptElement(int i) {
		this.checkValidity();
		if (!this.it.hasNext() || this.it.next()!=i) {
			throw new IllegalStateException();
		}
	}
}
