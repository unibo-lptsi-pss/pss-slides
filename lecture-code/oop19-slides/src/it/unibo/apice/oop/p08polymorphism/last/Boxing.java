package it.unibo.apice.oop.p08polymorphism.last;

/* Showcase dell'autoboxing */
public class Boxing {
	public static void main(String[] s) {
		final Object[] os = new Object[5];
		os[0] = new Object();
		os[1] = 5; // equivale a os[1]=new Integer(5);
		os[2] = 10; // equivale a os[2]=new Integer(10);
		os[3] = true; // equivale a os[3]=new Boolean(true);
		os[4] = 20.5; // equivale a os[4]=new Double(20.5);
		final Integer[] is = new Integer[] { 10, 20, 30, 40 };
		final int i = is[0] + is[1] + is[2] + is[3];
		// equivale a: is[0].intValue()+ is[1].intValue()+..
		// non funzionerebbe se 'is' avesse tipo Object[]..
		System.out.println("Somma: " + i); // 100
	}
}
