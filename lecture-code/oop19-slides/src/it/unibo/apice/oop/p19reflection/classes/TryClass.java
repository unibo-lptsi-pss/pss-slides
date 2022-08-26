package it.unibo.apice.oop.p19reflection.classes;

public class TryClass {
	
	public static void main(String[] args) throws Exception {
		
		// Unico caso di recupero del corretto tipo generico
		final Class<String> c = String.class;
		System.out.println(c);
		System.out.println("oggetto "+c.newInstance());
		
		// Si può ottenere una class da una stringa calcolata
		final Class<?> c2 = Class.forName("java.lang" + ".String");
		System.out.println("oggetto "+(String)c2.newInstance());

		// Accesso alla classe di un oggetto
		final Object o = "3";
		final Class<?> c3 = o.getClass();
		System.out.println(c3); //String

		// Cast "unchecked" per recuperare il generico
		final Class<Integer> c4 = (Class<Integer>)o.getClass();
		System.out.println(c4);
		
		// Cast "unchecked" per recuperare il generico
		String s = cloneObject("prova");
		java.util.Date d = cloneObject(new java.util.Date());
		System.out.println(s.length()+" "+d);
	}
	
	private static <T> T cloneObject(T t) throws Exception {
		return (T)t.getClass().newInstance();
	}
}
