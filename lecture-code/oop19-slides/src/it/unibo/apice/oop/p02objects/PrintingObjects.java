package it.unibo.apice.oop.p02objects;

import java.util.Date;
import java.util.Random;

// java.lang.System non va importata

class PrintingObjects {
	public static void main(String[] s) {
		Date d = new Date();
		System.out.println("Data corrente: " + d);
		System.out.println("Millisec. dal 1/1/1970: " + d.getTime());
		Random r = new Random();
		System.out.println("Numero random: " + r.nextInt());
		System.out.println("Altro numero random: " + r.nextInt());
		System.out.println("N. random fra (0-100): " + r.nextInt(100));
		String vjava = System.getProperty("java.version");
		String osname = System.getProperty("os.name");
		String usrdir = System.getProperty("user.dir");
		System.out.println("Versione Java: " + vjava);
		System.out.println("OS Name: " + osname);
		System.out.println("Usr dir: " + usrdir);
	}
}
