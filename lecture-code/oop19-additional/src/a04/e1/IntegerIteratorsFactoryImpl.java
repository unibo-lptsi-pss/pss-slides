package a04.e1;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class IntegerIteratorsFactoryImpl implements IntegerIteratorsFactory {
	
	private static <X> SimpleIterator<X> fromIterator(Iterator<X> iterator){
		return new SimpleIterator<>() {
			@Override
			public Optional<X> next() {
				if (iterator.hasNext()) {
					return Optional.of(iterator.next());
				}
				return Optional.empty();
			}
		};
	}

	@Override
	public SimpleIterator<Integer> empty() {
		return fromIterator(Stream.<Integer>empty().iterator());
	}

	@Override
	public SimpleIterator<Integer> fromList(List<Integer> list) {
		return fromIterator(list.stream().iterator());
	}

	@Override
	public SimpleIterator<Integer> random(int size) {
		Random random = new Random();
		Stream<Integer> stream = Stream.generate(()->random.nextInt(size)).limit(size);
		return fromIterator(stream.iterator());
	}

	@Override
	public SimpleIterator<Integer> quadratic() {
		Stream<Integer> stream = Stream.iterate(1,i->i+1)
				                       .flatMap(i-> Stream.generate(()->i).limit(i));
		return fromIterator(stream.iterator());
	}

	@Override
	public SimpleIterator<Integer> recurring() {
		// TODO Auto-generated method stub
		return null;
	}

}
