package app;

import java.util.Random;

public class DrawNumberModelImpl implements DrawNumberModel {
	
	private final static int MIN_INCLUDED = 1;
	private final static int MAX_INCLUDED = 100;
	
	private final int number;
	
	public DrawNumberModelImpl() {
		this.number = new Random().nextInt(MAX_INCLUDED-MIN_INCLUDED+1)+MIN_INCLUDED;
	}

	@Override
	public Result draw(int number) {
		if (number < MIN_INCLUDED || number > MAX_INCLUDED) {
			return Result.NOT_IN_RANGE;
		}
		if (number > this.number) {
			return Result.TOO_HIGH;
		} 
		if (number < this.number) {
			return Result.TOO_LOW;
		}
		return Result.WON;
	}
}
