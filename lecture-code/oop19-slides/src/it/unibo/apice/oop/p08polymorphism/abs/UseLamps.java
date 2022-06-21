package it.unibo.apice.oop.p08polymorphism.abs;

public class UseLamps {
	// clausola throws Exception qui sotto necessaria!!
	public static void main(String[] s) throws Exception {
		LimitedLamp lamp = new UnlimitedLamp();
		lamp.switchOn();
		System.out.println("ul| " + lamp);
		for (int i = 0; i < 1000; i++) {
			lamp.switchOff();
			lamp.switchOn();
		}
		System.out.println("ul| " + lamp); // non si è esaurita

		lamp = new CountdownLamp(5);
		for (int i = 0; i < 4; i++) {
			lamp.switchOn();
			lamp.switchOff();
		}
		System.out.println("cl| " + lamp);
		lamp.switchOn();
		System.out.println("cl| " + lamp); // al quinto switch si esaurisce

		lamp = new ExpirationTimeLamp(1000); // 1 sec
		lamp.switchOn();
		System.out.println("el| " + lamp);
		Thread.sleep(10000); // attendo 1.1 secs
		System.out.println("el| " + lamp); // dopo 1.1 secs si è esaurita
	}
}
