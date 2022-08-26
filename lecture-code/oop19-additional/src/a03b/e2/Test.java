package a03b.e2;

public class Test {

	/*
     * Scopo di questo esercizio è realizzare una GUI con l'aspetto mostrato nell'immagine fig.png fornita, 
     * che contiene una sequenza di 5 pulsanti con valori numerici inizialmente random (da 0 a 9 incluso), e 
     * poi un JCheckBox. Inizialmente la checkbox è disabilitata. Premendo su un pulsante il suo numero si sposta 
     * a destra di una casella (se non esce dal range). Quando un numero si sposta viene fatto uno switch col numero 
     * nella casella d'arrivo. Se la checkbox è abilitata, invece, premendo su un pulsante il numero si sposterà
     * analogamente a sinistra, e così via.
     * Quando a fronte degli spostamenti i numeri si trovano in ordine crescente da sinistra a destra si chiuda
     * l'applicazione.
     * 
     * Sono considerati opzionali ai fini della possibilità di correggere l'esercizio, ma concorrono 
     * comunque al raggiungimento della totalità del punteggio:
     * - scorporamento di tutti gli aspetti che non sono di view in una interfaccia+classe esterna, via Strategy
     * - compilazione e esecuzione dell'esercizio da linea di comando
     * 
     * Indicazioni di punteggio:
     * - correttezza della parte obbligatoria: 9 punti
     * - qualità della parte obbligatoria: 1 punto
     * - qualità della parte opzionale (strategy): 5 punti
     * - compilazione e esecuzione da linea di comando: 2 punti
     * 
     * La classe GUIExample fornita include codice che potrebbe essere utile per la soluzione.
     */

    public static void main(String[] args) throws java.io.IOException {
        // new GUIExample();
        new GUI();
    }
}
