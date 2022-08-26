package it.unibo.apice.oop.p22effective.immutable;

import java.util.*;
import java.util.stream.*;

public class UseComplex {
	
	public static void main(String[] args){
		final List<Complex> l = Arrays.asList(
				Complex.valueOf(10.0, 20.0),
				Complex.valueOf(-10.0, 20.0),
				Complex.valueOfPolar(10.0, 0),
				Complex.valueOfPolar(10.0, Math.PI/4),
				Complex.valueOfPolar(10.0, Math.PI),
				Complex.valueOfPolar(10.0, 3*Math.PI/4),
				Complex.ZERO
		); 
		
		System.out.println(l.stream()
							.map(Complex::toString)
							.collect(Collectors.joining(";", "{", "}"))
		);
		
		System.out.println(l.stream()
							.map(c->c.chgRadius(1.0))
							.map(c->c.add(Complex.valueOf(10.0,10.0)))
							.map(Complex::toString)
							.collect(Collectors.joining(";", "{", "}"))
		);
	}
}
