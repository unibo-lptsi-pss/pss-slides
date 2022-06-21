package it.unibo.apice.oop.p08polymorphism.abs;

public abstract class LimitedLamp extends SimpleLamp {

	public LimitedLamp() {
		super();
	}

	/* Questo metodo è finale: 
	 * - regola la coerenza con okSwitch() e isOver() */
	public final void switchOn() {
		if (!this.isSwitchedOn() && !this.isOver()) {
			super.switchOn();
			this.okSwitch();
		}
	}

	// Cosa facciamo se abbiamo effettivamente acceso? Dipende dalla strategia
	protected abstract void okSwitch();

	/* Strategia per riconoscere se la lamp è esaurita */
	public abstract boolean isOver();

	public String toString() {
		return "Over: " + this.isOver() + 
		       ", switchedOn: "	+ this.isSwitchedOn();
	}
}
