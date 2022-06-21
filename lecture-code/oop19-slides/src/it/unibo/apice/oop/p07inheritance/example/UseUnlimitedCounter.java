package it.unibo.apice.oop.p07inheritance.example;

public class UseUnlimitedCounter {
	public static void main(String[] s) {
		final UnlimitedCounter uc = new UnlimitedCounter();
		System.out.println("isOver: " + uc.isOver()); // false
		System.out.println("LifeTime: " + uc.getDistanceToLimit());
		uc.increment();
		uc.increment();
		uc.increment();
		System.out.println("isOver: " + uc.isOver()); // false
		System.out.println("LifeTime: " + uc.getDistanceToLimit());
	}
}
