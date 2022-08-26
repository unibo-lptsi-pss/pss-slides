package it.unibo.apice.oop.p15io.trans;

import java.util.Date;
import java.io.*;

public class APersona implements java.io.Serializable {
	private static final long serialVersionUID = -8985026380526620812L;

	private final String nome;
	private transient Date lastUse = new Date();

	public APersona(final String nome) {
		this.nome = nome;
	}

	public void used() {
		this.lastUse = new Date();
	}

	public String toString() {
		return this.nome + ":"
				+ (this.lastUse == null ? "null" : this.lastUse.getTime());
	}

	private void writeObject(final ObjectOutputStream out) throws IOException {
		out.defaultWriteObject(); // accetto il comportamento di default
		System.err.println("writing");
	}

	// una sorta di costruttore..
	private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		System.err.println("reading");
		this.lastUse = new Date(); // in lettura, ripristino la data corrente
	}
}