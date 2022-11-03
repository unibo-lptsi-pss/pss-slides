import java.io.*;

public class IOFromKeyboard {

	// La dichiarazione throws qui è obbligatoria!
	public static int getIntFromKbd() throws IOException {
		InputStreamReader ISR = new InputStreamReader(System.in);
		BufferedReader keyboardInput = new BufferedReader(ISR);
		String line = keyboardInput.readLine(); // IOException
		return Integer.parseInt(line);
	}

	public static void main(String[] args) {
		try {
			System.out.print("Inserisci un numero: ");
			int a = getIntFromKbd();
			System.out.println("Hai inserito il num.: " + a);
		} catch (IOException e) { // con la tastiera non se ne hanno
			System.out.println("Errore di I/O: " + e);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
}
