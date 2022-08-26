package it.unibo.apice.oop.p16lambda.optional;

import java.util.Optional;



public class UseOptional2 {

	public static void main(String[] args) throws Exception {

		final Optional<Integer> opt = Optional.of(10); 
		final Optional<Integer> opt2 = Optional.empty();
		System.out.println(opt.isPresent());
		System.out.println(opt2.isPresent());
		
		if (opt.isPresent()){
			System.out.println(opt.get()); // 10
		} else {
			System.exit(0);
		}
		opt.ifPresent(System.out::println); // 10
		opt2.ifPresent(System.out::println); // nothing
		
		opt.map(x -> x+1).ifPresent(System.out::println); // 11
		opt.map(x -> x+"1").ifPresent(System.out::println); // "101"
		
		// Your first monad example!
		Optional<Integer> op3 = opt.flatMap(x -> 
								opt2.flatMap(y ->
								opt2.flatMap(z -> Optional.of(x+y+z))));
		System.out.println(op3);
		
		System.out.println(opt.orElseThrow(()->new Exception())); // 10
		System.out.println(opt2.orElseThrow(()->new Exception())); // exc

	}

}
