package it.unibo.apice.oop.p17streams;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Stream.*;

public class UseFactoriesImport {

	public static void main(String[] args) {

		List<Integer> li = Arrays.asList(10,20,30,5,6,7,10,20,100);
		System.out.print("Collection: ");
		li.stream().forEach(i->System.out.print(" "+i));
		
		System.out.print("\nEmpty: ");
		empty().forEach(i->System.out.print(" "+i));
		
		System.out.print("\nFromValues: ");
		of("a","b","c").forEach(i->System.out.print(" "+i));
		
		System.out.print("\nIterate(+1): ");
		iterate(0,i->i+1).limit(20).forEach(i->System.out.print(" "+i));
		
		System.out.print("\nSuppl(random): ");
		generate(()->Math.random()).limit(5).forEach(i->System.out.print(" "+i));
		
		System.out.print("\nConcat: ");
		concat(of("a","b"),of(1,2)).forEach(i->System.out.print(" "+i));
		
		System.out.print("\nBuilder: ");
		builder().add(1).add(2).build().forEach(i->System.out.print(" "+i));
		
		System.out.print("\nRange: ");
		IntStream.range(0,20).forEach(i->System.out.print(" "+i));
	}
}

