package it.unibo.apice.oop.p14gui.mvc.model;

public interface DrawNumber {
	
	void reset();
	
	DrawResult attempt(int n) throws AttemptsLimitReachedException;
}
