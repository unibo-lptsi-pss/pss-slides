package it.unibo.apice.oop.p15gui.events;

import java.util.*;
import java.io.*;

public class ToStream implements EObserver{
	
	private PrintStream ps;
	
	public ToStream(PrintStream ps){
		this.ps = ps;
	}
	
	public void update(ESource o, Object arg) {
		ps.println("The sum is "+arg);
	}
}
