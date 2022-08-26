package a04.sol1;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class IntegerIteratorsFactoryImpl implements IntegerIteratorsFactory {
	
	// idea: costruiamo un adattatore da Stream a SimpleIterator
	private SimpleIterator<Integer> simpleIteratorFromStream(Stream<Integer> stream){
		Iterator<Integer> it = stream.iterator();
		return new SimpleIterator<Integer>() {
			@Override
			public Optional<Integer> next() {
				return Optional.of(true).filter(v -> it.hasNext()).map(v -> it.next());
			}
		};
	}
	
	//.. ora tutti i SimpleIterator si costruiscono piuttosto semplicemente,
	// costruendo lo stream dei valori da produrre
	@Override
	public SimpleIterator<Integer> empty() {
		return this.simpleIteratorFromStream(Stream.empty());
	}

	@Override
	public SimpleIterator<Integer> fromList(List<Integer> list) {
		return this.simpleIteratorFromStream(list.stream());
	}

	@Override
	public SimpleIterator<Integer> random(int size) {
		final Random random = new Random();
		return this.simpleIteratorFromStream(Stream.generate(()->random.nextInt(size))
				                                   .limit(size));
	}

	@Override
	public SimpleIterator<Integer> quadratic() {
		return this.simpleIteratorFromStream(Stream.iterate(0, x->x+1)
				                                   .flatMap(i -> Collections.nCopies(i, i)
				                                   .stream()));
	}

	@Override
	public SimpleIterator<Integer> recurring() {
		return this.simpleIteratorFromStream(Stream.iterate(0, x->x+1)
				                                   .flatMap(i -> Stream.iterate(0, x->x+1)
				                                   .limit(i)));
	}
	
}
