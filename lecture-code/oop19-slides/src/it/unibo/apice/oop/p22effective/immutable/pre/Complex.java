package it.unibo.apice.oop.p22effective.immutable.pre;

public final class Complex {
	
	// costante pubblica senza rischio di modifica da fuori
	public static final Complex ZERO = new Complex(0,0);
	
	final private double re;
	final private double im;
	
	// uso uno static factory, quindi rendo la classe non-instanziabile
	private Complex(final double re, final double im){
		this.re = re;
		this.im = im;
	}
	
	// tecnica flightweight: riuso ZERO se possibile	
	public static Complex build(final double re, final double im){
		if (re == 0.0 && im == 0.0){
			return ZERO;
		} 
		return new Complex(re,im); 
	}

	public double getRe() {
		return re;
	}

	public double getIm() {
		return im;
	}
	
	// Metodi con approccio funzionale
	public Complex chgRe(final double re){
		return new Complex(re,this.im);
	}
	
	public Complex chgIm(final double im){
		return new Complex(this.re,im);
	}
	
	public Complex add(final Complex toAdd){
		return new Complex(this.re+toAdd.re,this.im+toAdd.im);
	}

	// Si potrebbe fare caching del toString
	@Override
	public String toString() {
		return "Complex [re=" + re + ", im=" + im + "]";
	}
	
	
}
