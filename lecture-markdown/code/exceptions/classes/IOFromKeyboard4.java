import java.io.*;

public class IOFromKeyboard4 {

    // L'uso di System.console().readLine() non lancia
    // eccezioni
    public static void main(String[] args) {
        while (true) {
            System.out.print("Inserisci un numero: ");
            int a = Integer.parseInt(System.console().readLine());
            System.out.println("Hai inserito il num.: " + a);
        }
    }
}

/*
 * Si controlli la classe java.lang.Console, fornisce
 * varie funzioni utili per l'I/O, come le stampe formattate
 * tipo printf
 */
