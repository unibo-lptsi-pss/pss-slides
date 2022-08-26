package it.unibo.apice.oop.p22effective.immutable.pre;

public class UseComplex {
	
	public static void main(String[] args){
		Complex c1 = Complex.build(0, 0);
		Complex c2 = Complex.build(10.5, 20.2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.add(Complex.build(1, 1)));
		System.out.println(c2.add(Complex.build(1, 1)));
		System.out.println(c1);
		System.out.println(c2);
	}

}
