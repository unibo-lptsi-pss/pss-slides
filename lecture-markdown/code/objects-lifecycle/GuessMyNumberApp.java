package it.unibo.apice.oop.p04objects;

import java.io.Console; // Classe non funzionante dall'IDE Eclipse
import java.util.Random;

public class GuessMyNumberApp {
	
	public static final int ATTEMPTS = 10;
	public static final int MAX_GUESS = 100;
	public static final int MIN_GUESS = 1;

	public static void main(String[] args) {
		int number = new Random().nextInt(MAX_GUESS - MIN_GUESS) + MIN_GUESS;
		for (int i = 1; i <= ATTEMPTS; i++){
			System.out.println("Attempt no. "+i);
			System.out.println("Insert your guess.. ");
			int guess = Integer.parseInt(System.console().readLine());
			if (guess == number){
				System.out.println("You won!!");
				return;
			} else if (guess > number){
				System.out.println("Your guess is greater..");
			} else {
				System.out.println("Your guess is lower..");
			}
		}
		System.out.println("Sorry, you lost!");
	}
}
