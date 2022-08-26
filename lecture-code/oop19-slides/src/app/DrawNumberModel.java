package app;

public interface DrawNumberModel {
	
	enum Result {
		NOT_IN_RANGE, TOO_LOW, TOO_HIGH, WON
	}
		
	Result draw(int number);
}
