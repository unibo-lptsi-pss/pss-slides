package it.unibo.apice.oop.p06interfaces;

public class UseTwoLampsDevice {

	public static void main(String[] args) {
		TwoLampsDevice td = new TwoLampsDevice();
		System.out.println(td);
		td.ecoMode();
		System.out.println(td);
		td.getSecond().brighten();
		System.out.println(td);
	}

}
