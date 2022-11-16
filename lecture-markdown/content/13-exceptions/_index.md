
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/exceptions/"]

+++

# Eccezioni

<!-- {{% import path="front-page.md" %}} -->

{{% import path="cover.md" %}}

---

## Outline

### Goal della lezione
*  Illustrare i vari meccanismi di gestione delle eccezioni in Java
*  Dare linee guida per la progrettazione di sistemi che usano eccezioni

### Argomenti
*  Errori a run-time e necessità di una loro gestione
*  Tipi di eccezioni/errori in Java
*  Istruzione `throw`
*  Costrutto `try-catch-finally`
*  Dichiarazioni `throws`
*  Esempi

---

# Errori

---

## Errori nei programmi

### Errori a tempo di compilazione (compile-time)

*  sono quelli più grossolani, sono intercettati dal compilatore
*  quindi rientrano nella fase dell'implementazione, sono innocui
*  un linguaggio con strong typing consente di identificarne molti a compile-time

### Errori a tempo di esecuzione (run-time) *$\Leftarrow$ oggetto della lezione*
*  sono condizioni anomale dovute alla dinamica del sistema
    *  parametri anomali a funzioni, errori nell'uso delle risorse di sistema, ...
*  in genere è possibile
    1. identificare/descrivere dove potrebbero accadere,
    2. intercettarli e
    3. gestirli prevedendo procedure di compensazione (rimedio al problema che le ha causate)
*  alcuni linguaggi (come Java, ma non C) forniscono costrutti per agevolarne la gestione

---

## Errori per causa interna: lanciati dalla JVM

Errore numerico

```java
int divide(int x, int y) { return x / y; }
...
int z = divide(5,0);
// ERRORE: divisione per 0
```

Stack Overflow

```java
int f(int i) { return i == 0 ? 0 : f(i + 1); }
...
int n = f(1);
// ERRORE: stack overflow
```

Deferenziamento di `null`

```java
int mysize(List<?> l) { return l.size(); }
...
int n=mysize(null);
```

---

## Violazioni di contratto d'uso di un oggetto: librerie Java

Operazione non supportata

```java
{{% import-raw path="code/exceptions/Op.java" %}}
```

Elemento non disponibile

```java
{{% import-raw path="code/exceptions/NoElement.java" %}}
```

Formato illegale

```java
{{% import-raw path="code/exceptions/Format.java" %}}
```

---


## Violazioni di contratto d'uso di un oggetto: nostro codice


Argomento errato

```java
public class LampRow {
    private final Lamp[] row;
    public LampsRow(final int size) {
    	if (size < 1) {
            // lancio eccezione, argomento non valido!
        }
    	this.row = new SimpleLamp[size];
    }
    ...
}
```

Elemento non disponibile

```java
public class LampRow {
    private final Lamp[] row;
    public Lamp get(int index) {
        if (index >= row.size) {
            // lancio eccezione, elemento assente!
        }
    }
    ...
}
```

---

## L'importanza della "error-aware programming"

### Contratti
*  Molti oggetti richiedono determinate *"condizioni di lavoro" (sequenze di chiamata, argomenti passati, aspettative d'uso di risorse computazionali)*
    *  Al di fuori queste condizioni è necessario interrompere il lavoro e effettuare azioni correttive

### Il progettista della classe deve:
*  identificare le condizioni di lavoro definite "normali"
*  intercettare quando si esce da tali condizioni
*  eventualmente segnalare l'avvenuto errore
* Principio **fail fast**: il software di qualità è costruito in modo tale da *fallire **subito** e **chiaramente*** in caso di condizioni "non nominali"
    * Fallire subito aiuta ad intercettare gli errori prima che diventino irrecuperabili
    * Fallire chiaramente aiuta l'utilizzatore a porre rimedio

### Il cliente (a sua volta progettista di un altro oggetto) deve:
*  essere informato di come l'oggetto va usato (da cui l'importanza di avere *chiari messaggi di errore*)
*  intercettare gli errori e porvi rimedio con un *handler*

---

## Eccezioni in Java
### Riassunto Java Exceptions
* Gli errori a run-time in Java sono rappresentati da oggetti della classe `java.lang.Throwable`. Vengono "lanciati":
    * da esplicite istruzioni del tipo: `throw <exception-object>;`
    * direttamente dalla JVM per cause legate al "sistema operativo"
* Tali oggetti portano informazioni utili a capire la causa dell'errore
* Si può dichiarare se un metodo potrà lanciare una eccezione
```java
void m() throws SomeException, AnotherException { ... }
```
* Si può intercettare una eccezione e porvi rimedio:
```java
try {
    m();
} catch (SomeException exception) {
    // handle exception!
}
```

**Tutti meccanismi che impareremo a progettare e implementare in questa lezione!**

---

## Tipologie di errori in Java
### **Errori**: `java.lang.Error` e sottoclassi
* Dovute a un problema "serio" (e non risolvibile) interno alla JVM
* *Di norma una applicazione non si deve preoccupare di intercettarli (non ci sarebbe molto di più da fare che interrompere l'esecuzione)*
    * Ad esempio, la memoria disponibile è insufficiente per continuare l'esecuzione

### **Eccezioni unchecked**: `java.lang.RuntimeException` e sottoclassi
* Causate da un bug nella programmazione
* *Nella maggior parte dei casi*, un'applicazione non dovrebbe intercettarle
    * vengono risolti in fase di debug
    * ci sono eccezioni...

### **Eccezioni checked**: i `java.lang.Throwable` tranne le precedenti
* Causate da un problema prevedibile ma non rimediabile a priori
* *Le applicazione devono dichiarli esplicitamente, e vanno intercettati e gestiti esplicitamente*

---

## Tipologie di errori in Java: UML

![](imgs/uml-throw.png)

---

## Usuale gestione

### Errori
* Nessuna gestione necessaria (se capitano, tipicamente è finita...)

### Eccezioni unchecked
* Vanno dichiarate in un commento Javadoc al codice
* Di norma si riusano le sottoclassi `java.lang.RuntimeException` del JDK, ossia non se ne definiscono di nuove tipologie
    * `ArithmeticException` errori di calcolo illegale
    * `IllegalArgumentException` per argomenti non supportati
    * `IllegalStateException` per errate sequenze di chiamate di metodo (inconsistenza interna)
    * `UnsupportedOperationException` per parti del programma non ancora sviluppate o non supportate
* Si lanciano con l'istruzione `throw`

### Eccezioni checked

*  Vanno dichiarate nella signature del metodo con la clausola `throws`
*  La documentazione deve spiegare in quali casi vengono lanciate
*  Vanno intercettate con l'istruzione `try-catch`
*  Di norma si costruiscono sotto-classi ad-hoc di `Exception` (per modellare problemi "domain-specific")

---

## Errori ed eccezioni unchecked: cosa accade

### Quando accadono, ossia quando vengono lanciate...
* Causano l'interruzione dell'applicazione
* Comportano la scrittura su console di errore (`System.err`) di un messaggio che include lo *__StackTrace__* -- `Thread.dumpStack();`
* Dal quale possiamo desumere la sequenza di chiamate e il punto del codice in cui si ha avuto il problema

### Errori/eccezioni unchecked comuni e già viste
* `StackOverFlowError`: stack esaurito (ricorsione infinita?)
* `NullPointerException`, `ArrayStoreException`, `ClassCastException`, `ArrayIndexOutOfBoundsException`, `NumericException`, `OperationNotSupportedException`
* Altri andranno verificati sulla documentazione quando incontrati

---

## Esempio di stampa
```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/exceptions/classes/UncheckedStackTrace.java" %}}
```

---

## L'istruzione `throw`

```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/exceptions/classes/UncheckedThrow.java" %}}
```

---

## L'istruzione `throw`: una variante equivalente

```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/exceptions/classes/UncheckedThrow2.java" %}}
```

---

## L'istruzione `throw`

### Sintassi generale

```java
throw <expression-that-evaluates-to-a-throwable>;
```

### Casi tipici

```java
throw new <exception-class>(<message-string>);
```

```java
throw new <exception-class>(<ad-hoc-args>);
```

```java
throw new <exception-class>();
```

### Effetto
*  Si interrompe immediatamente l'esecuzione del metodo in cui ci si trova (se non dentro una `try-catch`, come vedremo dopo..)
*  L'oggetto eccezione creato viene "riportato" al chiamante
*  Ricorsivamente, si giunge al `main`, con la stampa su `System.err` (exception chaining)

---

# Catturare eccezioni

---

## Il costrutto `try-catch`

### Sintassi (da estendere successivamente)

```java
try {
    <body-maybe-throwing-an-exception>}
} catch(<throwable-class> <var>) {
    <handler-body>
}
```

### Esempio

```java
try {
    RangeIterator r = new RangeIterator(a,b);
} catch(RuntimeException e) {
    System.out.println(e);
}
```

### Significato
* Se il body nella `try` lancia una eccezione del tipo specificato nella `catch`
* Allora si esegue il corrispondente handler, e non si ha la terminazione della applicazione
* Se non c'è eccezione si salta l'handler e si prosegue

---

## Il costrutto `try-catch-finally`

### Sintassi generale

```java
try {
    <body-maybe-throwing-an-exception>}
} catch(<throwable-class> <var>) {
    <handler-body>
} catch(<throwable-class> <var>) {
    <handler-body>
} catch(<throwable-class> <var>) {
    <handler-body>
} finally {
    <completion-body>
}
```

### Significato
* Se il body nella `try` lancia una eccezione
* La prima `catch` pertinente esegue l'handler (non ci possono essere sovrapposizioni!)
* Poi si eseguirà anche il `completion-body`
* Il body nella `finally` sarà comunque eseguito!

---

## Spiegazione

### Come funziona la `finally`?
* garantisce che il codice nel suo handler sarà sicuramente eseguito
    * sia se *ho avuto* eccezione
    * sia se *non ho avuto* eccezione
    * sia *se uno degli handler delle catch ha generato eccezione*

### A cosa serve?
* in genere contiene del codice di cleanup che deve comunque essere eseguito
* rilascio risorse, chiusura file, stampa messaggi, etc..

---

# Creazione e rilancio di eccezioni
## Creazione di una nuova classe di eccezioni

### Nuove eccezioni

* Un sistema potrebbe richiedere nuovi tipi di eccezioni, che rappresentano eventi specifici collegati al dominio applicativo
    *  Persona già presente (in un archivio cittadini)
    *  Lampadina esaurita (in una applicazione domotica)
* Semplicemente si fa una estensione di `Exception` o `RuntimeException`
    * a seconda che la si voglia checked o unchecked
    * per il momento stiamo considerando solo le unchecked
* Non vi sono particolari metodi da ridefinire di solito
    * Solo *ricordarsi di chiamare correttamente il costruttore del padre* (`super(...)`)
    * Si dovrebbe incorporare una descrizione articolata della *causa dell'eccezione*
        * come opportuno parametro della chiamata al costruttore del padre

---

## Esempio: `MyException`

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/exceptions/classes/MyException.java" %}}
```

---

## Esempio: `UseMyException`

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/exceptions/classes/UseMyException.java" %}}
```

---

## Checked vs Unchecked

### Unchecked: `RuntimeException` o sottoclassi
* Quelle viste finora, dovute ad un bug di programmazione
* Quindi sono da catturare opzionalmente, perché rimediabili
    * $\Rightarrow$ raramente vanno catturate!

### Checked: `Exception` o sottoclassi ma non di `RuntimeException`
* Rappresentano errori non riconducibili ad una scorretta programmazione, ma ad eventi abbastanza comuni anche nel sistema una volta installato e funzionante
    * Funzionamento non normale, ma forse recuperabile
        * Ad esempio, un errore di rete (potremmo riprovare)
* I metodi che le lanciano lo *__devono__* dichiararle esplicitamente (`throws`)
* Chi chiama tali metodi *__deve__* obbligatoriamente gestirle
    * o catturandole con un `try-catch`
    * o rilanciandole al chiamante con la `throws`
        * Nel qual caso, va *preservata l'eccezione originale*! (*parent* o *cause*)

---

## Una eccezione checked: `IOException` e input da tastiera

```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/exceptions/classes/IOFromKeyboard.java" %}}
```

---

## Qualche variante: campi statici

```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/exceptions/classes/IOFromKeyboard2.java" %}}
```

---

## Qualche variante: input iterato e rilancio

```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/exceptions/classes/IOFromKeyboard3.java" %}}
```

---

## Input da tastiera (alternativa più moderna)

```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/exceptions/classes/IOFromKeyboard4.java" %}}
```
