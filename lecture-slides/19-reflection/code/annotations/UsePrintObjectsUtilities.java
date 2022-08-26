public class UsePrintObjectsUtilities {
	public static void main(String[] args) {
	   Person p = new Person("Marco", 100);
	   System.out.println(PrintObjectsUtilities.objectToString(p));
	   // getName:Marco,id->100|
	}
}
