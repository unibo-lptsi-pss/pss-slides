package drawnumber;

public interface DrawNumberModel {

	enum Result {
		TOO_HIGH, TOO_LOW, YOU_WIN, OUT_OF_RANGE
	}
	
	Result attempt(int n);
	
}
