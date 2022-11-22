public class Outer {

	private int i;

	public Outer(int i) {
		this.i = i;
	}

	public Inner createInner() {
		return new Inner();
		// oppure: return this.new Inner();
	}

	public class Inner {

		private int j = 0;

		public void update() {
			// si usa l'oggetto di outer..
			this.j = this.j + Outer.this.i;
		}

		public int getValue() {
			return this.j;
		}
	}
}
