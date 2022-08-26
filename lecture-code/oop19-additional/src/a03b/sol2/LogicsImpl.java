package a03b.sol2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LogicsImpl implements Logics {
	
	private final List<Integer> list;
	
	public LogicsImpl(int size) {
		final Random r = new Random();
		this.list = new LinkedList<>(IntStream.range(0,size).map(i -> r.nextInt(10)).boxed().collect(Collectors.toList()));
	}
	

	@Override
	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(this.list);
	}

	@Override
	public boolean isDone() {
		int prev = -1;
		for (int i: this.list) {
			if (prev > i) {
				return false;
			}
			prev = i;
		}
		return true;
	}


	@Override
	public void toLeft(int pos) {
		Collections.swap(this.list, Math.max(0, pos-1), pos);
	}

	@Override
	public void toRight(int pos) {
		Collections.swap(this.list, pos, Math.min(this.list.size()-1, pos+1));
	}

}
