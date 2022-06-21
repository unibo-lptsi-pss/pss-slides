package it.unibo.apice.oop.p07inheritance.example;

public class EcoDomusController {

	/* Compongo n LimitedLamp */
	final private LimitedLamp[] lamps;

	public EcoDomusController(final int size, final int lampsLimit) {
		this.lamps = new LimitedLamp[size];
		for (int i = 0; i < size; i++) {
			this.lamps[i] = new LimitedLamp(lampsLimit);
		}
	}

	public LimitedLamp getLamp(final int position) {
		return this.lamps[position];
	}

	private LimitedLamp toBeUsedNext() {
		LimitedLamp best = null;
		for (final LimitedLamp lamp : this.lamps) {
			if (!lamp.isSwitchedOn() && 
				( best == null ||
				  lamp.getRemainingLifeTime() > best.getRemainingLifeTime())) {
				best = lamp;
			}
		}
		return best;
	}

	/* Accendo una lampadina spenta, scegliendola in modo economico */
	public void switchOnOne() {
		final LimitedLamp lamp = this.toBeUsedNext();
		if (lamp != null) {
			lamp.switchOn();
		}
	}

	/* Verifico se sono tutti accesi */
	public boolean allOver() {
		for (final LimitedLamp lamp : this.lamps) {
			if (!lamp.isOver()) {
				return false;
			}
		}
		return true;
	}

	public String toString() {
		String s = "";
		for (final LimitedLamp lamp : this.lamps) {
			s += (lamp.isSwitchedOn() ? "on" : "off");
			s += "(" + lamp.getRemainingLifeTime() + ")" + " | ";
		}
		return s;
	}
}
