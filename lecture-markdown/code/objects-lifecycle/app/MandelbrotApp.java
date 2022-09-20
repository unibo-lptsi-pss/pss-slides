public class MandelbrotApp {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	public static final double MINX = -1.5;
	public static final double MAXX = 0.5;
	public static final double MINY = -1.0;
	public static final double MAXY = 1.0;
	public static final int MAX_ITER = 32;

	public static int greyColorFromIterations(int iter, int maxIter){
		if (iter == MAX_ITER) { return 0; } // Out of Mandelbrot set
		iter = 255-iter*(256/MAX_ITER); // 255,254,..,0 colors
		return iter | iter << 8 | iter << 16; // as grey
	}

	public static void main(String[] s){
		Mandelbrot mb = new Mandelbrot(WIDTH,HEIGHT,MINX,MAXX,MINY,MAXY,MAX_ITER);
		Picture p = new Picture(WIDTH,HEIGHT);
		while (!mb.isCompleted()){
			int iter = mb.computeIterations();
			int color = greyColorFromIterations(iter,MAX_ITER);
			p.drawPixel(mb.x, mb.y, color);
			mb.advancePosition();
} } }
