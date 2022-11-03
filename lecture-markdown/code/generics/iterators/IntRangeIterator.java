/* Itera tutti i numeri interi fra 'start' e 'stop' inclusi */
public class IntRangeIterator implements Iterator<Integer> {

	private int current; // valore corrente
	private int stop; // valore finale

	public IntRangeIterator(int start, int stop) {
		this.current = start;
		this.stop = stop;
	}

	public Integer next() {
		// Finita l'iterazione: current = stop + 1
		int returnValue = Math.min(this.current, this.stop);
		if (this.current <= this.stop) {
			this.current++; // incremento solo se necessario
		}
		return returnValue;
	}

	public boolean hasNext() {
		return this.current <= this.stop;
	}
}
