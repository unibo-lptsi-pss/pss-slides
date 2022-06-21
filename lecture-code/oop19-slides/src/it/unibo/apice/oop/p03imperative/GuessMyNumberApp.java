package it.unibo.apice.oop.p03imperative;

import java.io.Console; 
import java.util.Random;

public class GuessMyNumberApp {

	public static void main(String[] args) {
		int number = new Random().nextInt(99) + 1;
		for (int i = 1; i <= 10; i++){
			System.out.println("Attempt no. "+i);
			System.out.println("Insert your guess.. ");
			int guess = Integer.parseInt(System.console().readLine());
			if (guess == number){
				System.out.println("You won!!");
				return;
			} else if (guess > number){
				System.out.println("Your guess is greater, try again..");
			} else {
				System.out.println("Your guess is lower, try again..");
			}
		}

	}

}
