package it.unibo.apice.oop.p22effective.immutable;

abstract class AbstractComplex implements Complex {
	// Metodi con approccio funzionale
	@Override
	public Complex chgRe(final double re) {
		return new Cartesian(re, this.getIm());
	}

	@Override
	public Complex chgIm(final double im) {
		return new Cartesian(this.getRe(), im);
	}

	@Override
	public Complex chgRadius(double r) {
		return new Polar(r, this.getTheta());
	}

	@Override
	public Complex chgTheta(double t) {
		return new Polar(this.getRadius(), t);
	}

	@Override
	public Complex add(final Complex toAdd) {
		return new Cartesian(this.getRe() + toAdd.getRe(), this.getIm()
				+ toAdd.getIm());
	}

	// Si potrebbe fare caching del toString
	@Override
	public String toString() {
		return "[" + getRe() + "," + getIm() + "]";
	}

	static final class Cartesian extends AbstractComplex {

		private final double re;
		private final double im;

		Cartesian(final double re, final double im) {
			this.re = re;
			this.im = im;
		}

		@Override
		public double getRe() {
			return re;
		}

		@Override
		public double getIm() {
			return im;
		}

		@Override
		public double getRadius() {
			return Math.sqrt(this.re * this.re + this.im * this.im);
		}

		@Override
		public double getTheta() {
			return Math.atan2(this.im, this.re);
		}
	}

	static final class Polar extends AbstractComplex {

		private final double r;
		private final double theta;

		Polar(final double r, final double theta) {
			if (r < 0.0) {
				throw new IllegalArgumentException();
			}
			this.r = r;
			this.theta = theta;
		}

		@Override
		public double getRe() {
			return this.getRadius() * Math.cos(this.getTheta());
		}

		@Override
		public double getIm() {
			return this.getRadius() * Math.sin(this.getTheta());
		}

		@Override
		public double getRadius() {
			return this.r;
		}

		@Override
		public double getTheta() {
			return this.theta;
		}
	}
}
