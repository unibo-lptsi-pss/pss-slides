package it.unibo.apice.oop.p15gui.mvc;

public interface ViewInterface {
	
	void clearData();
	void addData(Object[] o);
	void commandFailed(String message);
	void attachViewObserver(ViewObserver listener);

}