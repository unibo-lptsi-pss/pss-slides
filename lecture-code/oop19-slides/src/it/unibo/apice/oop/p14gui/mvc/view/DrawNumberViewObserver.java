package it.unibo.apice.oop.p14gui.mvc.view;

public interface DrawNumberViewObserver {
	
	void newAttempt(int n);
	
	void resetGame();
	
	void quit();
}
