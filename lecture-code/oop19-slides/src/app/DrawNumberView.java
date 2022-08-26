package app;

public interface DrawNumberView {
	
	void numberTooHigh();
	
	void numberTooLow();
	
	void won();
	
	void notInRange();
	
	void outOfMoves();
	
	void addController(DrawNumberController controller);
}
