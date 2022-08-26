package it.unibo.apice.oop.p15gui.mvc;

public interface ViewObserver {
	
	void commandLoad();
	void commandSave();
	void commandAdd(Object[] arg);
	void commandQuit();
}
