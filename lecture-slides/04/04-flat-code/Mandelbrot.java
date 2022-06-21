

public class Mandelbrot {
	
	static final double MAX_PRODUCT = 4.0;
	int width, height, x, y; // uno per linea di norma
	double minx, maxx, miny, maxy, maxIter; // uno per linea di norma
	
	Mandelbrot(int width, int height, double minx, double maxx, 
			   double miny, double maxy, int maxIter) {
		this.width = width;	this.height = height;
		this.minx = minx;	this.maxx = maxx;
		this.miny = miny;	this.maxy = maxy;
		this.maxIter = maxIter;
	}
	void advancePosition(){
		x = (x + 1) % width;
		y = y + (x == 0 ? 1 : 0);
	}
	boolean isCompleted(){
		return y == height;
	}
	int computeIterations(){
		Complex c0 = new Complex(this.minx + (this.maxx - this.minx) * x / width,
				                 this.miny + (this.maxy - this.miny) * y / height);
		Complex c = c0;
		int iter;
		for (iter = 0; c.getScalarProduct() < MAX_PRODUCT && iter < this.maxIter; iter++) {
			c = c.times(c).sum(c0); // c = c*c + c0
		}
		return iter;
	}	
}
