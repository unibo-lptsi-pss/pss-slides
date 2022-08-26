package a04.e2;

public class Test {

    /*
     * Scopo di questo esercizio è realizzare una GUI con l'aspetto mostrato nell'immagine fig.png, fornita, 
     * che contiene una griglia quadrata di pulsanti (4x4), inizialmente tutti abilitati, e che hanno sempre etichetta
     * vuota.
     * 
     * Si potrà premere una sequenza di pulsanti adiacenti (che via via confinano, orizzontalmente, verticalmente, 
     * o diagonalmente). Ad ogni pressione, il pulsante si disabilita. Se si preme un pulsante non adiacente al precedente
     * non deve succedere nulla. Il primo pulsante premuto può essere qualsiasi (e si disabiliterà).
     * Quando non può essere premuto più nessun pulsante (perché non ve ne sono più di adiacenti o di selezionabili)
     * l'applicazione si chiuda.
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
        new GUI();
    }
}
