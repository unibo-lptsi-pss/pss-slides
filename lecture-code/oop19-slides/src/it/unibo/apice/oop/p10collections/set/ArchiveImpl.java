package it.unibo.apice.oop.p10collections.set;

import java.util.*;

public class ArchiveImpl implements Archive {

	private final Set<Persona> set = new HashSet<>();
	
	public void add(String nome, int annoNascita, boolean sposato) {
		this.set.add(new Persona(nome,annoNascita,sposato));
	}

	public void remove(String nome, int annoNascita) {
		this.set.remove(new Persona(nome,annoNascita,false));
	}

	public int size() {
		return this.set.size();
	}

	public Set<String> allMarried() {
		final Set<String> newset = new HashSet<>();
		for (final Persona p: this.set) {
			if (p.isSposato()) {
				newset.add(p.getName());
			}
		}
		return newset;
	}
}
