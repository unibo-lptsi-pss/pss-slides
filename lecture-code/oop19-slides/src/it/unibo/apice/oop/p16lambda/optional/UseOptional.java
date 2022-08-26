package it.unibo.apice.oop.p16lambda.optional;

import java.util.*;

public class UseOptional {

	public static void main(String[] args) {
		
		final String s = Math.random() > 0.5 ? "high value" : null;
		//Optional<String> opt = Optional.ofNullable(s);
		Optional<String> opt = s == null ? Optional.empty() : Optional.of(s);
		
		System.out.println("present: "+opt.isPresent());
		System.out.println("orElse: "+opt.orElse("it is actually null"));
		try{
			System.out.println("get: "+opt.get());
		} catch (Exception e){
			System.out.println("get failed.."+e.getClass());
		}
		
		System.out.print("ifPresent..");
		opt.ifPresent(System.out::println);
		
	}

}
