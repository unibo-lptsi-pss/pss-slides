package it.unibo.apice.oop.p22effective.immutable;

public interface Complex {

	// costante pubblica senza rischio di modifica da fuori
	public static final Complex ZERO = new AbstractComplex.Cartesian(0, 0);

	double getRe();

	double getIm();

	double getRadius();

	double getTheta();

	Complex chgRe(double re);

	Complex chgIm(double im);

	Complex chgRadius(double r);

	Complex chgTheta(double t);

	Complex add(Complex c);

	public static Complex valueOf(final double re, final double im) {
		if (re == 0.0 && im == 0.0) {
			return ZERO;
		}
		return new AbstractComplex.Cartesian(re, im);
	}

	public static Complex valueOfPolar(double r, double theta) {
		if (r == 0.0) {
			return ZERO;
		}
		return new AbstractComplex.Polar(r, theta % (2 * Math.PI));
	}
}