package it.unibo.apice.oop.p11gencoll2.constrained;

public abstract class LimitedLamp extends SimpleLamp {

	public LimitedLamp() {
		super();
	}

	/*
	 * Questo metodo è fissato e non modificabile: - regola la coerenza con
	 * okSwitch() e isOver()
	 */
	public final void switchOn() {
		if (!this.isSwitchedOn()) {
			if (!this.isOver()) {
				super.switchOn();
				this.okSwitch();
			}
		}
	}

	/*
	 * A solo uso interno, cosa facciamo se abbiamo effettivamente acceso?
	 * Dipende dalla strategia..
	 */
	protected abstract void okSwitch();

	/* Strategia per riconoscere se la lamp è esaurita */
	public abstract boolean isOver();

	public String toString() {
		return "Over: " + this.isOver() + ", switchedOn: "
				+ this.isSwitchedOn();
	}
}
