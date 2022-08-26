public class UseOuter {

	public static void main(String[] args) {
		Outer o = new Outer(5);
		Outer.Inner in = o.new Inner(); // o racchiude in
		System.out.println(in.getValue()); // 0
		in.update();
		in.update();
		System.out.println(in.getValue()); // 5
		
		Outer.Inner in2 = new Outer(10).createInner();
		in2.update();
		in2.update();
		System.out.println(in2.getValue()); // 20
	}
}
