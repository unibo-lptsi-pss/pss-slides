public class DynamicExecution {
    /* 
        - Chiede il nome di una classe e di un metodo.
        - Cerca un metodo con quel nome e che torni String
        - Lo invoca e stampa il risultato
        - (Nota la classe può essere creata a run-time)
    */
	public static void main(String[] s) throws Exception {
		BufferedReader reader = new BufferedReader(
		                new InputStreamReader(System.in));
		System.out.println("Nome della classe: ");
		String className = reader.readLine();
		System.out.println("Nome del metodo: ");
		String methName = reader.readLine();

		Class<?> cl = Class.forName(className);
		Constructor<?> cns = cl.getConstructor();
		Method met = cl.getDeclaredMethod(methName);
		if (!met.getReturnType().isAssignableFrom(String.class)) {
			throw new NoSuchMethodException("Tipo di ritorno errato");
		}
		Object o = cns.newInstance();
		String result = (String) met.invoke(o);
		System.out.println("OK");
		System.out.println(result);
	}

}
