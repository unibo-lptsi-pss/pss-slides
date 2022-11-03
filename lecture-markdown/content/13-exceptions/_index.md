
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
  *  Esempi e Pattern MVC




---


# Errori

---



## Errori nei programmi


  
### Errori a tempo di compilazione (compile-time)



*  sono quelli più grossolani, sono intercettati dal compilatore
*  quindi rientrano nella fase dell'implementazione, sono innocui
*  un linguaggio con strong typing consente di identificarne molti a compile-time
  


  
### Errori a tempo di esecuzione (run-time) ($\Leftarrow$ oggetto della lezione)



*  sono condizioni anomale dovute alla dinamica del sistema
    *  parametri anomali a funzioni, errori nell'uso delle risorse di sistema, ...
*  in genere è possibile 
    1. identificare/descrivere dove potrebbero accadere, 
    2. intercettarli e
    3. gestirli prevedendo procedure di compensazione (rimedio al problema che le ha causate)
*  alcuni linguaggi (come Java, non il C) forniscono costrutti per agevolarne la gestione
  




---


## Errori per causa interna: lanciati dalla JVM


Errore numerico  

```java
{{% import-raw path="code/exceptions/Div.java" %}}
```

Overflow memoria

```java
{{% import-raw path="code/exceptions/Rec.java" %}}
```

Riferimento null

```java
{{% import-raw path="code/exceptions/Null.java" %}}
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
{{% import-raw path="code/exceptions/Arg.java" %}}
```

Elemento non disponibile

```java
{{% import-raw path="code/exceptions/It.java" %}}
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
  


  
### Il cliente (a sua volta progettista di un altro oggetto) deve:



*  essere informato di come l'oggetto va usato
*  intercettare gli errori e porvi rimedio con un *handler* 




---


## Eccezioni in Java


  
### Riassunto Java Exceptions



*  Gli errori a run-time in Java sono rappresentati da oggetti della classe `java.lang.Throwable`. Vengono "lanciati":

    *  da esplicite istruzioni del tipo: `throw <exception-object>;`
    *  o, direttamente dalla JVM per cause legate al "sistema operativo"
    
*  Tali oggetti portano informazioni utili a capire la causa dell'errore
*  Si può dichiarare se un metodo potrà lanciare una eccezione: `<meth-signature> throws <excep-class> { .. }`
```java
void m() throws SomeException { ... }
```
*  Si può intercettare una eccezione e porvi rimedio: `try { <instructions> } catch(<excep-class> <var>) { ... }`
```java
try {
    m();
} catch(SomeException){ ... }
```


**Tutti meccanismi che impareremo a progettare e implementare in questa lezione!**



---


## Tipologie di errori in Java


  
### **Errori**: `java.lang.Error` e sottoclassi



*  Dovute a un problema "serio" (e non risolvibile) interno alla JVM
*  *Di norma una applicazione non si deve preoccupare di intercettarli (non ci sarebbe molto di più da fare che interrompere l'esecuzione)*
  


  
### **Eccezioni unchecked**: `java.lang.RuntimeException` e sottoclassi



*  Causate da un bug nella programmazione
*  *Di norma una applicazione non si deve preoccupare di intercettarli (dovrebbero essere risolti tutti in fase di debugging del sistema)*
  


  
### **Eccezioni checked**: i `java.lang.Throwable` tranne le precedenti



*  Causate da un problema prevedibile ma non rimediabile a priori
*  *Le applicazione devono dichiarli esplicitamente, e vanno intercettati e gestiti esplicitamente*
  




---


## Tipologie di errori in Java: UML


  ![](imgs/uml-throw.png)


---


## Usuale gestione


  
### Errori



*  Nessuna gestione necessaria ("se capitano, capitano...")
  


  
### Eccezioni unchecked



*  Si potrebbero dichiarare con un commento al codice
*  Di norma si riusano le classi `java.lang.RuntimeException` del JDK, ossia non se ne definiscono di nuove tipologie
*  Si lanciano con l'istruzione `throw`
  


  
### Eccezioni checked



*  Vanno dichiarate nel metodo con la clausola `throws`
*  La documentazione deve spiegare in quali casi vengono lanciate
*  Vanno intercettate con l'istruzione `try-catch`
*  Di norma si costruiscono sotto-classi ad-hoc di `Exception` (per modellare problemi "domain-specific")
  




---


## Errori ed eccezioni unchecked: cosa accade


  
### Quando accadono, ossia quando vengono lanciate..



*  Causano l'interruzione dell'applicazione
*  Comportano la scrittura su console di errore (`System.err`) di un messaggio che include lo *__StackTrace__* -- `Thread.dumpStack();`
    *  nota, solitamente `System.err` coincide con `System.out`
*  Dal quale possiamo desumere la sequenza di chiamate e il punto del codice in cui si ha avuto il problema
  


  
### Errori/eccezioni unchecked comuni e già viste



*  `StackOverFlowError`: stack esaurito (ricorsione infinita?)
*  `NullPointerException`, `ArrayStoreException`, `ClassCastException`, `ArrayIndexOutOfBoundsException`, `NumericException`, `OperationNotSupportedException`
*  Altri andranno verificati sulla documentazione quando incontrati
  




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

# Impl.corretta di `RangeIterator`


## Riconsideriamo l'implementazione di `RangeIterator`


  
### Elementi da considerare



*  Controllare l'interfaccia `java.util.Iterator`
*  Verificare la documentazione presente nel sorgente (ed in particolare, come si specificano le eccezioni lanciate)
*  Il comando: `javadoc Iterator.java`
*  La documentazione HTML prodotta
*  Realizzazione e prova di `RangeIterator`
  




---


## Documentazione di `Iterator`: header


```java
{{% import-raw path="code/exceptions/util/Iterator1.java" %}}
```

---


## Documentazione di `Iterator`: `next()` e `hasNext()`


```java
{{% import-raw path="code/exceptions/util/Iterator2.java" %}}
```


---


## Documentazione di `Iterator`: `remove()`


```java
{{% import-raw path="code/exceptions/util/Iterator3.java" %}}
```

---


## Documentazione generata: pt1


  ![](imgs/javadoc1.png)


---


## Documentazione generata: pt2


  ![](imgs/javadoc2.png)


---


## Realizzazione di `RangeIterator`


```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/exceptions/classes/RangeIterator.java" %}}
```



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



*  Se il body nella `try` lancia una eccezione del tipo specificato nella `catch`
*  Allora si esegue il corrispondente handler, e non si ha la terminazione della applicazione
*  Se non c'è eccezione si salta l'handler e si prosegue
  




---


## Uso della `RangeIterator` senza `try-catch`


  
```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/exceptions/classes/UseRange.java" %}}
```



---


## Uso della `RangeIterator` con `try-catch`


  
```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/exceptions/classes/UseRange2.java" %}}
```



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



*  Se il body nella `try` lancia una eccezione
*  La prima `catch` pertinente esegue l'handler (non ci possono essere sovrapposizioni!)
*  Poi si eseguirà anche il `completion-body`
*  Il body nella `finally` sarà comunque eseguito!
  




---


## `catch` multipli e `finally`


```java
{{% import-raw path="code/exceptions/classes/UseRange3.java" %}}
```

---


## Spiegazione


  
### Come funziona la `finally`?



*  garantisce che il codice nel suo handler sarà sicuramente eseguito
*  ... sia se ho avuto eccezione
*  ... sia se non ho avuto eccezione
*  ... sia se uno degli handler delle catch ha generato eccezione
  


  
### A cosa serve?



*  in genere contiene del codice di cleanup che deve comunque essere eseguito
*  rilascio risorse, chiusura file, stampa messaggi, etc..
  


  
### Vedremo la prossima settimana il costrutto chiamato `try`-with-resources



*  consente di non esprimere il `finally`
  




---

# Creazione e rilancio di eccezioni


## Creazione di una nuova classe di eccezioni


  
### Nuove eccezioni



*  Un sistema potrebbe richiedere nuovi tipi di eccezioni, che rappresentano eventi specifici collegati al dominio applicativo

    *  Persona già presente (in un archivio cittadini)
    *  Lampadina esaurita (in una applicazione domotica)
    
*  Semplicemente si fa una estensione di `Exception` o `RuntimeException`

    *  a seconda che la si voglia checked o unchecked
    *  per il momento stiamo considerando solo le unchecked
    

*  Non vi sono particolari metodi da ridefinire di solito
    *  Solo *ricordarsi di chiamare correttamente il costruttore del padre*
    *  Se si vuole incorporare una descrizione articolata della *causa dell'eccezione*, la si può inserire nei campi dell'oggetto tramite il costruttore o metodi setter..
  




---


## Esempio: `MyException`


  
```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/exceptions/classes/MyException.java" %}}
```



---


## Esempio: `UseMyException`


  
```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/exceptions/classes/UseMyException.java" %}}
```



---

# Dichiarazione eccezioni checked


## Checked vs Unchecked


  
### Unchecked: `RuntimeException` o sottoclassi



*  Quelle viste finora, dovute ad un bug di programmazione
*  Quindi sono da catturare opzionalmente, perché rimediabili
* $\Rightarrow$ ..le linee guida più moderne le sconsigliano
  


  
### Checked: `Exception` o sottoclassi ma non di `RuntimeException`



*  Rappresentano errori non riconducibili ad una scorretta programmazione, ma ad eventi abbastanza comuni anche nel sistema una volta installato e funzionante

    *  Funzionamento non normale, ma non tale da interrompere l'applicazione (p.e., l'utente fornisce un input errato inavvertitamente)
    *  Un problema con l'interazione col S.O. (p.e., file inesistente)
    
*  I metodi che le lanciano lo *__devono__* dichiararle esplicitamente (`throws`)
*  Chi chiama tali metodi *__deve__* obbligatoriamente gestirle

    *  o catturandole con un `try-catch`
    *  o rilanciandole al chiamante con la `throws` 
    




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


## Input da tastiera: da Java 6 (non funziona in Eclipse!)


  
```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/exceptions/classes/IOFromKeyboard4.java" %}}
```



---

# Esempio: applicazione domotica con eccezioni


## Requirements


  


*  Una fila di $n$ `Device` con tempo di vita limitato
*  Il sistema dovrà supportare in futuro diverse politiche di fine-vita dei device
*  *Il fine-vita viene rilevato al tentativo di accensione, ed è segnalato da una eccezione checked*
*  Esistono comandi per accendere e spegnere tutti i device
*  Il sistema dovrà essere a prova di qualunque eccezione
  




---


## UML: Modellazione `Device`


  ![](imgs/uml-device.png)


---


## Interfaccia `Device`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/Device.java" %}}
```



---


## Eccezione `DeviceIsOverException`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/DeviceIsOverException.java" %}}
```



---


## `AbstractDevice`, pt1


  
```java
{{% import-raw from=3 to=26 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/AbstractDevice.java" %}}
```



---


## `AbstractDevice`, pt2


  
```java
{{% import-raw from=27 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/AbstractDevice.java" %}}
```



---


## `CountdownDevice`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/CountdownDevice.java" %}}
```



---


## `DeviceRow`: Campi e costruttore


  
```java
{{% import-raw from=5 to=32 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/DeviceRow.java" %}}
```



---


## `DeviceRow`: Selettori e `allOff()`


  
```java
{{% import-raw from=33 to=56 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/DeviceRow.java" %}}
```



---


## `DeviceRow`: `allOn()` e `toString()`


  
```java
{{% import-raw from=57 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/DeviceRow.java" %}}
```



---


## `UseDevice`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/UseDevice.java" %}}
```



---


## Una applicazione completa


  
### Elementi aggiuntivi



*  Vi dovrà essere una interazione con l'utente
*  Potrà da console fornire i comandi: `+N`, `-N`, `+all`, `-all`, `exit`
*  ..e vedere direttamente l'effetto che hanno sul `DeviceRow`
*  (è un prodromo di applicazione con GUI..)
  


  
### Un problema architetturale



*  come allestire una applicazione con interazione con l'utente?
  




---


## Il pattern architetturale **MVC (Model - View - Controller)**


  
### MVC -- divide l'applicazione in 3 parti



*  `Model`: modello OO del dominio applicativo del sistema
*  `View`: gestisce le interazioni con l'utente (in futuro una GUI)
*  `Controller`: gestisce il coordinamento fra Model e View
  


  
### Applicazione (domotica)



*  `Model`

	*  Un wrapper per un `DeviceRow`
    

*  `View`

    *  Implementata da un `ConsoleView` che lavora con la Console
    

*  `Controller`

	*  Utilizza un `CommandExecutor` che "processa" i comandi da tastiera
    

* $\Rightarrow$ `View` e `Model` nascoste da interfacce, per supportare un buon disaccoppiamento
  


  


---


## UML: Design generale


  ![](imgs/dia.jpg)


---


## `Controller`, pt1


  
```java
{{% import-raw from=3 to=24 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/Controller.java" %}}
```



---


## `Controller`, pt2


  
```java
{{% import-raw from=25 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/Controller.java" %}}
```



---


## Eccezioni


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/ExitCommandException.java" %}}
```

  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/CommandNotRecognisedException.java" %}}
```



---


## Interfaccia e implementazione `Model`


    
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/Model.java" %}}
```

    
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/DeviceRowModel.java" %}}
```



---



## Interfaccia `View`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/View.java" %}}
```



---



## `ConsoleView`, pt1


  
```java
{{% import-raw from=3 to=25 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/ConsoleView.java" %}}
```



---


## `ConsoleView`, pt2


  
```java
{{% import-raw from=26 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/ConsoleView.java" %}}
```



---


## Interfaccia `CommandExecutor`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/CommandExecutor.java" %}}
```



---



## `SimpleCommandExecutor`, pt1


  
```java
{{% import-raw from=3 to=23 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/SimpleCommandExecutor.java" %}}
```



---


## `SimpleCommandExecutor`, pt2


  
```java
{{% import-raw from=24 to=48 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/SimpleCommandExecutor.java" %}}
```



---


## `SimpleCommandExecutor`, pt3


  
```java
{{% import-raw from=49 to=64 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/SimpleCommandExecutor.java" %}}
```



---


## `SimpleCommandExecutor`, pt4


  
```java
{{% import-raw from=65 to=100 path="pss-code/src/main/java/it/unibo/exceptions/safedevices/SimpleCommandExecutor.java" %}}
```

  

---
  

## Note su questa progettazione


  
### Complessivamente



*  è lungi dall'essere ottimale
*  è un primo passo verso l'idea di "buon progetto"
  


  
### Aspetti positivi



*  Suddivisione base secondo logica MVC
*  M e V "nascosti" da interfacce, favorendo disaccoppiamento
  


  
### Aspetti da migliorare -- ve ne sono sempre!!



*  `Controller` contiene elementi relativi all'interazione con l'utente

    *  sarebbero da astrarre in chiamate di metodo da fare sulla `View`

*  `CommandExecutor` contiene due logiche, e non andrebbe bene:

    *  riconoscimento della stringa in input (da gestire nella `View`)
    *  conseguente esecuzione del comando
    
  