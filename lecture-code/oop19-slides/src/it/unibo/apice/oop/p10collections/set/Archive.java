package it.unibo.apice.oop.p10collections.set;

import java.util.Set;

public interface Archive {

	void add(String nome, int annoNascita, boolean sposato);
	
	void remove(String nome, int annoNascita);
	
	int size();
	
	Set<String> allMarried();
}
