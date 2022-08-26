package it.unibo.apice.oop.p14gui.mvc.model;

import java.util.Random;

public class DrawNumberImpl implements DrawNumber {
	
	private int choice;
	private final int min;
	private final int max;
	private final int attempts;
	private int remainingAttempts;
	private final Random random = new Random();

	public DrawNumberImpl(final int min, final int max, final int attempts) {
		this.min = min;
		this.max = max;
		this.attempts = attempts;
		this.reset();
	}

	public void reset() {
		this.remainingAttempts = this.attempts;
		this.choice = this.min + random.nextInt(this.max-this.min+1);
	}

	public DrawResult attempt(int n) throws AttemptsLimitReachedException {
		if (this.remainingAttempts == 0) {
			throw new AttemptsLimitReachedException();
		}
		if (n < this.min || n > this.max){
			throw new IllegalArgumentException();
		}
		if (n > this.choice){
			return DrawResult.YOURS_IS_HIGHER;
		} 
		if (n < this.choice){
			return DrawResult.YOURS_IS_LOWER;
		} 
		return DrawResult.YOU_WON;
	}

}
