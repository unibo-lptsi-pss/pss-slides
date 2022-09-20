package it.unibo.apice.oop.p04objects.app;

public class Complex {
	
	double re;
	double im;
	
	Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	double getScalarProduct(){
		return this.re * this.re + this.im * this.im;
	}
	
	// Crea un nuovo complesso, sommando this a c
	Complex sum(Complex c){
		return new Complex(this.re + c.re, this.im + c.im);
	}
	
	// Crea un nuovo complesso, moltiplicando this a c
	Complex times(Complex c){
		return new Complex(this.re * c.re - this.im * c.im, 
				           c.re * this.im + c.im * this.re);
	}
	
}
