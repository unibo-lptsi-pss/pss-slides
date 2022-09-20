package it.unibo.lifecycle;

public class Complex {

	double re;
	double im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public double getScalarProduct(){
		return this.re * this.re + this.im * this.im;
	}

	// Crea un nuovo complesso, sommando this a c
	public Complex sum(Complex c){
		return new Complex(this.re + c.re, this.im + c.im);
	}

	// Crea un nuovo complesso, moltiplicando this a c
	public Complex times(Complex c){
		return new Complex(this.re * c.re - this.im * c.im,
				           c.re * this.im + c.im * this.re);
	}
}