import java.io.*;

public class IOFromKeyboard2 {

	private static final BufferedReader KBD = new BufferedReader(new InputStreamReader(System.in));

	public static int getIntFromKbd() throws IOException {
		return Integer.parseInt(KBD.readLine());
	}

	public static void main(String[] args) {
		try {
			System.out.print("Inserisci un numero: ");
			int a = getIntFromKbd();
			System.out.println("Hai inserito il num.: " + a);
		} catch (IOException e) {
			System.out.println("Errore di I/O: " + e);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
}
