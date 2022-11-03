import java.io.*;

public class IOFromKeyboard3 {

	// Un metodo dentro al quale può essere generata una eccezione
	// non ivi gestita, deve dichiararla con la throws..
	// Si può indicare eventualmente anche una sopraclasse
	public static void main(String[] args) throws Exception {
		BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("Inserisci un numero: ");
			int a = Integer.parseInt(keyboardInput.readLine());
			System.out.println("Hai inserito il num.: " + a);
		}
	}
}
