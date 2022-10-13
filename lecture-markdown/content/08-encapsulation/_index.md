
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/encapsulation/"]

+++

# Encapsulation

{{% import path="cover.md" %}}


---

## Outline


  
### Goal della lezione



  *  Illustrare concetti generali di *incapsulamento* e *information hiding*
  *  Mostrare *tecniche di programmazione* "standard"
  *  Fornire primi *esempi di classi ben progettate*
  


  
### Argomenti



  *  Convenzioni su *formattazione* di codice sorgente Java
  *  *Incapsulamento* in Java
  *  Una metodologia di progettazione
  *  Ulteriori convenzioni


---


<!--

## Ambiente integrato Eclipse


  
### Funzionalità



  *  Supporto multi-linguaggio (C/C++, Java, Scala,..)
  *  Vasta quantità di plug-in 
  *  Supporta editing "intelligente", compilazione on-the-fly, debug, esecuzione
  *  Concetto di progetto
  


  
### Metodologia



*  creazione progetto, package, classi
*  esecuzione dalla classe col main
*  possibilità di importare/esportare file ZIP (p.e., codice aula)
  
---

-->


# Alcuni principi di buona progettazione


<!--
  % information hiding permette di calare le interdipendenze
    % encapsulation è il modo di risolvere la cosa nei ling OO
      % controllo d'accesso (mopdifiers)
      % impacchettamento di dati e funzioni (classe)
-->




## Dai meccanismi alla buona progettazione/programmazione


  
### La nostra analisi dell'OO in Java finora, ci ha insegnato:



*  Parte imperativa/procedurale di Java (tipi primitivi, operatori, cicli)
*  Classi, oggetti, costruttori, campi, metodi
*  Codice statico, controllo d'accesso
  


  
### Detto ciò, come realizziamo un buon sistema?


  Come programmiamo il sistema
  

*  per giungere al risultato voluto (*soddisfacimento requisiti*, funzionali e non), e
*  così che sia *facilmente manutenibile (estendibile, flessibile, leggibile)*?
  


  $\Rightarrow$ un lunghissimo percorso: muoviamo i primi passi..


---


## Passi


  
### Il nostro approccio


  

*  Ricapitoleremo le principali convenzioni sul codice Java 
*  Anticiperemo alcune tecniche di programmazione efficace basate sulle tecniche di *__incapsulamento__*, e conseguenti al fondamentale principio di *__decomposizione__* ($\Leftarrow$ aspetto cruciale della OO)
*  Daremo qualche linea guida utile in future per costruire sistemi di più grosse dimensioni
  


  
Nota: tutte queste tecniche e linee guida sono necessarie per gestire il livello di articolazione del linguaggio Java, ossia per rendere il suo uso più semplice possibile



---

# Formattazione del codice



## Convenzioni sulla formattazione


  
### Formattazione generale



*  *Indentazione* di 4 caratteri (comunque non 1, non 10..)
*  *Lughezza linee*: non più di 90 caratteri -- spezzare in modo coerente

{{% smaller %}}

```java
// MIGLIORABILE
void m() {
        // indentazione di 8 caratteri, da evitare, in quanto i sorgenti crescono facilmente orizzontalmente
        for(int i : new int[] {1, 2, 3}) {
                if(i % 2 == 0){
                        System.out.println(i);
                }
        }
        System.out.println("Questa è una stringa veramente lungha che potrebbe portare ad infrangere la regola")
}

// OK
void m() {
    for(int i : new int[] {1, 2, 3}) {
        if(i % 2 == 0){
            System.out.println(i);
        }
    }
    System.out.println("Questa è una stringa veramente lungha " + 
        "che potrebbe portare ad infrangere la regola")
}
```

{{% /smaller %}}

---
  
### Commenti nel codice



*  `// ...` su una linea
*  `/* ... */` su più linee per commentare sezioni
*  `/** ... */` su più linee per commenti che generano documentazione

```java
/**
 * (Commento di documentazione)
 * Questa classe modella un generico dispositivo elettronico.
 */
class Device {
    /*
     * Campi di istanza per modellare lo stato del dispositivo.
     */
    boolean on;

    /*
     * Metodi per accensione e spegnimento.
     */
    void switchOn() {
        if(!this.on){
            // Se non acceso, allora accendiamo 
            this.on = true;
        }
    }
    void switchOff() { ... }
}
```

---
  
### Istruzioni



*  Definizione di variabile: una per linea, meglio se a inizio del metodo
*  Meglio inizializzare sempre le variabili!
*  Una sola istruzione per riga 
  
```java
// MIGLIORABILE
int a, b, c;
b = c = 5;
if(a > b) { System.out.println("a = " + a); } else { System.out.println("b = " + b); }

// OK
int a = 0;
int b = 5;
int c = 5;
if(a > b) { 
    System.out.println("a = " + a); 
} else { 
    System.out.println("b = " + b); 
}
```



---



  
### Costrutti vari


* Blocchi e parentesi graffe
    *  Apertura graffa: a fine linea della dichiarazione
    *  Chiusura graffa: in linea a sè, dove inizia la linea che la apre
    *  Usare graffe anche con blocchi ad uno statement
* Espressioni
    * Non usare assegnamenti dentro a espressioni
    *  Disambiguare priorità operatori con parentesi
* Spaziature di diverse "sezioni" del codice
    * Metodi separati da una linea vuota (e non più di 1)

```java
// MIGLIORABILE
void m()
{
    if(this.disabled ? true : this.unavailable ? true : this.urgent) return; 
}
void f() 
{
    // ...
}

// OK
void m() {
    if(this.disabled ? true : (this.unavailable ? true : this.urgent)) { 
      return; 
    }
}

void f() {
    // ...
}
```

---

 
### Nomi



*  **Classi (e interface)**: iniziano con *maiuscola*
    *  Se nome strutturato usare `CamelCasing`
*  **Metodi, campi, variabili**: iniziano con *minuscola*
    *  Se nome strutturato usare `camelCasing`
*  **Package**: interamente in *minuscolo* (anche se parole consecutive), solo lettere
*  **Campi costanti**: tutte *maiuscole* con eventuale separatore `_`

```java
// MIGLIORABILE
package IT.UNIBO.some_package;
class some_class {
    static final int someConstant = 100;

    void Some_Method() { /* ... */ }
}

// OK
package it.unibo.somepackage;

class SomeClass {
    static final int SOME_CONSTANT = 100;
    
    void someMethod() { /* ... */ }
}
```


---

  
### Ordine degli elementi della classe (`protected` descritto in seguito)

1.  Campi statici (pubblici, poi protetti, poi privati)
2.  Campi istanza (pubblici, poi protetti, poi privati)
3.  Costruttori (pubblici, poi protetti, poi privati)
4.  Metodi (*raggruppati per ruolo*)
  
```java
// MIGLIORABILE
class SomeClass {
    void someMethod() { /* ... */ }

    private static final int SOME_CONSTANT1 = 100;
    public static final int SOME_CONSTANT2 = 100;

    private int someField;
}

// OK
class SomeClass {
    // Campi statici
    public static final int SOME_CONSTANT1 = 100;
    private static final int SOME_CONSTANT2 = 100;

    // Campi d'istanza
    private int someField;
    
    // Metodi d'istanza
    void someMethod() { /* ... */ }
}
```

---
  
### Nota finale

*  L'uso delle corrette convenzioni rende il codice molto più leggibile, ma anche meno conciso
*  Nelle slide è impossibile mostrarlo sempre in questo modo
*  Quindi useremo in futuro solo alcune convenzioni..


---


## Esempio di buona formattazione: `Point3D`

{{% smaller %}}


<div class="container">
<div class="col">

{{% smaller %}}


```java
{{% import-raw from=3 to=35 path="pss-code/src/main/java/it/unibo/formatting/Point3D.java" %}}
```

{{% /smaller %}}

</div>
<div class="col">

{{% smaller %}}

```java
{{% import-raw from=36 path="pss-code/src/main/java/it/unibo/formatting/Point3D.java" %}}
```

{{% /smaller %}}


</div></div>

{{% /smaller %}}


---



# Decomposizione, incapsulamento, information hiding


---


## Il principo di decomposizione: **divide et impera**


### Dividi e conquista: approccio *__top-down__*



  *  La soluzione di un problema complesso avviene dividendolo in problemi più semplici
  *  La suddivisione è spesso multi-livello




### Esempi



*  SW calcolatrice con GUI: GUI, gestione eventi, calcoli matematici
*  Disegno Mandelbrot: Complex, Mandelbrot, MandelbrotApp


---


## Decomposizione, modularità, e dipendenze


  
### Un punto cruciale della decomposizione è la **modularità**

* **Modularità**: il grado con cui un sistema è formato da "moduli" separati e combinabili
    * La suddivisione (in moduli) va fatta in modo tale che sia effettivamente conveniente
    * Bisogna isolare i "sottoproblemi" più semplici
* **Dipendenza**: modulo $A$ è una *dipendenza* del modulo $B$ se $B$ ha bisogno di $A$ per alcune sue funzioni
    * Una dipendenza crea un **accoppiamento (coupling)** 
* Bisogna cercare di ridurre al massimo le *"dipendenze"* fra i sottoproblemi, il che consente:
    *  più autonomia decisionale
    *  meno interazione con altri
    *  *__meno influenze negative nel caso di modifiche__* (se il modulo $A$ cambia, può essere necessario modificare come conseguenza il modulo "dipendente" $B$)
* **Coesione**: il grado con cui una serie di componenti lavora bene insieme

---

![](imgs/modularity.png)



**modularità = alta coesione intra-modulo + basso accoppiamento inter-moduli**

---
  
### Esempi di decomposizione per la calcolatrice



*  Caso 1: calcolatrice completa per soli numeri naturali, e parte separata per i reali
*  Caso 2: grafica separata da calcoli matematici
* $\Rightarrow$ quale dei due casi porta a meno dipendenze (ossia è più modulare)?
  




---


## Decomposizione e programmazione OO


  
### Nella programmazione OO, almeno 3 livelli di decomposizione



*  Suddivisione in *package* (dell'intero programma)
*  Suddivisione in *classi* (di un package o programma)
*  Suddivisione in *metodi* (di una classe)
  


  
### Il punto cruciale da affrontare ora è la suddivisone in classi



*  È necessario suddividire il codice in classi nel modo opportuno
*  Creando il miglior link col *"problem space"*
*  *__Diminuendo il più possibile le dipendenze fra classi__*
  


  
### Tecnica



*  Esistono consolidate pratiche di programmazione efficace che risolvono il problema, e che cominceremo ad analizzare in questa lezione -- farlo bene richiede molto tempo ed esperienza!
  




---


## Dipendenze e OO


  
### Dipendenza


Si dice che una classe `A` *dipende da* una classe `B` se all'interno del codice di `A` si menziona la classe `B` (ad esempio come input di un metodo) o qualche sua proprietà. 

* La dipendenza è tanto più profonda (*high coupling*) quanto più in `A` si usano anche costruttori e/o campi e/o metodi definiti in `B`.
  
Implicazione di avere una dipendenza

* Ogni dipendenza vincola fortemente la possibilità di fare modifiche, perché ne comporta altre da fare in cascata. Se `A` dipende da `B` e modifico `B`, dovrò probabilmente modificare anche `A`.
  

  
### La sindrome dell'"intoccabilità"---*SW "rigido"*


Costruendo software complesso con troppe dipendenze, si giunge al punto che ogni singola modifica ne richiederebbe molte altre, e rischierebbe quindi di essere troppo costosa -- risultato: non si cambia più il software!
  



---


## Incapsulamento

### Definizione

**Incapsulamento**: il grado con cui un insieme di dati e funzioni sono parte di un oggetto
  
L'incapsulamento si fonda su due ingredienti cruciali della programmazione OO:

1. **Impacchettamento dati + funzioni per manipolarli**
2. **Information hiding** (via *controllo d'accesso*)


  
### Filosofia

*  Ogni classe dichiari `public` solo quei (pochi) metodi/costruttori necessari a interagire con (o creare) le sue istanze
*  Il resto (che quindi include meri aspetti realizzativi) sia `private`
    *  metodi/costruttori a solo uso interno
    *  **tutti** i campi (ossia lo stato interno)



  
### Incapsulamento e dipendenze

Così facendo il "cliente" è debolmente influenzato da possibili modifiche future riguardanti meri aspetti realizzativi.
  



---


## Esempio base: conteggio (NON incapsulato)

* dati e funzioni sono tenuti separati

```java
{{% import-raw from=1 path="pss-code/src/main/java/it/unibo/encapsulation/bad/CounterValue.java" %}}
```

```java
{{% import-raw from=1 path="pss-code/src/main/java/it/unibo/encapsulation/bad/CounterFunctions.java" %}}
```

---

## Esempio base: classe `Counter` (POCO incapsulata)

* dati e funzioni sono tenuti insieme (cosa piuttosto naturale nella OOP)
* ma i dati sono ben visibili dall'esterno (no information hiding)

```java
{{% import-raw from=1 path="pss-code/src/main/java/it/unibo/encapsulation/bad/Counter.java" %}}
```

```java
{{% import-raw from=1 path="pss-code/src/main/java/it/unibo/encapsulation/bad/UseCounter.java" %}}
```

---

## Esempio base: classe `Counter` (ben incapsulata)

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/encapsulation/Counter.java" %}}
```

---


## Semplice uso


```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/encapsulation/UseCounter.java" %}}
```

---



## Uso contatore


  
### La classe contatore



   *  Incapsula una semplice funzionalità di conteggio
   *  Dà un approccio più astratto rispetto all'uso di un `int`
   *  Consende di agire sul conteggio solo con `getValue()` e `increment()`
   * $\Rightarrow$ è impossibile modificare il conteggio a piacimento (o per errore), ad esempio decrementando invece che incrementando, o azzerando
  


```java
{{% import-raw from=3 to=15 path="pss-code/src/main/java/it/unibo/encapsulation/UseCounter2.java" %}}
```

---


## Uso contatore, pt 2


  
### Altra possibilità



*  Passo il contatore alle funzioni che hanno bisogno di conteggi
*  Ciò consente un più ampio grado di riuso
*  In generale, ho aperto nuove possibilità d'uso
  



```java
{{% import-raw from=16 path="pss-code/src/main/java/it/unibo/encapsulation/UseCounter2.java" %}}
```

---


## Riflessione: incapsulamento e contratto


  
### Contratto

* Nel diritto, un contratto è un accordo tra due o più parti, per regolare un rapporto
* Nell'OOP, un **contratto** è una specifica del *rapporto tra un oggetto e i suoi utilizzatori*
    * indica cosa l'oggetto si attende dai suoi utilizzatori ("obblighi")
    * indica cosa gli utilizzatori si possono attendere dall'uso dell'oggetto ("benefici")
* *Grazie all'incapsulamento, è possibile vincolare fortemente questi contratti, controllando meglio il comportamento degli oggetti!*
  
<!--
* Il contratto di un oggetto corrisponde ai suoi scenari di utilizzo
* E quindi alle aspettative che un cliente ha quando usa l'oggetto
-->

  
### Il caso del Contatore

* L'utilizzatore può solo (1) creare un contatore; (2) ottenere il valore del contatore; e (3) incrementare il contatore
* Il valore del conteggio all'atto della costruzione è `0`
* Il valore del conteggio in ogni altro istante è pari al numero di chiamate di `increment()`
  


  
### Osservazione


È grazie a questa idea che è più facile comporre oggetti in sistemi più complicati (vedi funzione `countInMatrix`)
  



---


## Oggetti immutabili


  
### Cosa sono



*  **Oggetto immutabile**: oggetto per il quale è garantito che *il valore iniziale dei campi non cambierà mai*
*  Portano un ulteriore livello di indipendenza (e eleganza) nel codice
*  In alcuni casi potrebbero portare a soluzioni poco performanti
  


  
### Come si costruiscono



* I campi della classe sono dichiarati `final` (oltre che `private`), e..
    * ..contengono a loro volta valori primitivi o oggetti immutabili
* Quindi nessun metodo può modificarli (*solo i costruttori possono, la prima volta*)
* Pattern di utilizzo: *invece che cambiare i campi si possono solo creare nuovi oggetti con il nuovo stato desiderato*
  


  
### Osservazione


Per ora è sufficiente saperli riconoscere e costruire
  

  
### Favorire sempre immutabilità ove possibile -- un principio avanzato


Indicare anche `final` variabili e argomenti che non verranno modificati
  



---


## `ImmutablePoint3D`

{{% smaller %}}

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/encapsulation/immutable/ImmutablePoint3D.java" %}}
```

{{% /smaller %}}

---


## `UseImmutablePoint3D`


```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/encapsulation/immutable/UseImmutablePoint3D.java" %}}
```

---

# Una metodologia basata sull'incapsulamento


## Altro esempio: classe `Lamp`


  
### Analisi del problema


In un sistema domotico, dovremo gestire un certo numero di lampadine (da accendere/spegnere e pilotare tramite un apposito controllore centralizzato, oltre che tramite i comandi a muro). Tali comandi sono a pulsante con controllo di intensità (10 livelli). Il controllore deve poter accedere alla situazione di ogni lampadina (accesa/spenta, livello di intensità) e modificarla a piacimento. Al primo avvio, le lampadine sono spente e il controllo di intensità è a zero (in un intervallo $[0,1]$).
  

  
Come procediamo alla costruzione della classe `Lamp`?



---


## Progettazione e implementazione: fasi


  
### Fasi nella costruzione di una classe



* Progettazione della *parte pubblica* della classe
* Costruzione dello *stato*
* Completamento *implementazione*
* Miglioramento codice finale (*refactoring*)
* *Test* del risultato
  




---


## Fase 1: Progettazione della parte pubblica della classe


  
Ovvero, del nome della classe e delle signature di operazioni pubbliche (metodi e costruttori)

  
### Linee guida



*  Considerare tutti i vari *casi d'uso* di un oggetto della classe
*  Inserire *costruttori e metodi pubblici solo per le operazioni necessarie*
    *  Evitare ove possibile di inserire un numero elevato di tali operazioni
  


  
### Il caso `Lamp`



*  Un costruttore unico senza argomenti
*  Metodi per accendere/spegnere
*  Metodi per aumentare/ridurre/impostare intensità
*  Metodi per accedere allo stato della lampadina
  


  


---


## Parte pubblica della classe `Lamp`


```java
/* Classe d'esempio che modella il concetto di Lampadina
   in un sistema Domotico */
public class Lamp {
    
    /* Inizializzazione */ 
    public Lamp() { .. }
    
    /* Accendo/Spengo */
    public void switchOn() { .. }
    public void switchOff() { .. }
    
    /* Meno intenso/Più intenso/Quanto intenso */  
    public void dim() { .. }
    public void brighten() { .. }
    public void setIntensity(double value) { .. }
    
    /* Selezione */
    public double getIntensity() { .. }
    public boolean isSwitchedOn() { .. }
} 
```

---



## Fase 2: Costruzione dello stato


  
Ovvero, dei campi privati della classe

  
### Linee guida



*  Considerare che esistono varie scelte possibili (è un aspetto implementativo, ritrattabile successivamente)
*  L'insieme dei campi deve essere più piccolo possibile, per esigenze di performance (spazio in memoria) e di non duplicazione
*  L'insieme dei campi deve essere sufficiente a tenere traccia di tutti i modi in cui il comportamento dell'oggetto può cambiare a fronte dei messaggi ricevuti
  


  
### Il caso `Lamp`



*  Dovremo sapere se è accesa o spenta (`boolean switchedOn`)
*  Dovremo sapere il livello attuale di intensità (`double intensity`)
*  Non sembrano servire altre informazioni
  




---


## Stato e metodi della classe `Lamp`


```java
/* Classe d'esempio che modella il concetto di Lampadina
   in un sistema Domotico */
public class Lamp{

    /* Campi */
    private boolean switchedOn;
    private double intensity;
    
    /* Costruttore */
    public Lamp(){ .. }
 
    /* Metodi */
    public void switchOn(){ .. }
    public void switchOff(){ .. }
    public void dim(){ .. }
    public void brighten(){ .. }
    public void setIntensity(double value){ .. }
    public double getIntensity(){ .. }
    public boolean isSwitchedOn(){ .. }
} 
```


---



## Fase 3: Completamento implementazione



Ovvero, del corpo di costruttori e metodi

  
### Linee guida



*  Realizzare il corpo di ogni costruttore e metodo in modo compatibile col contratto previsto per la classe
*  Accettare il fatto che la prima versione prodotta non necessariamente sarà quella finale
  


  
### Il caso `Lamp`



*  `switchOn()`, `switchOff()` sono semplici *__setter__* del campo `switchedOn`
*  `isSwitchedOn()`, `getIntensity()` semplici *__getter__* dei due campi
*  `dim()` e `brigthen()` modificano il campo `intensity` (se nel range!)
  




---


## Prima versione Classe Lamp

{{% smaller %}}

```java
public class Lamp {
    private double intensity;
    private boolean switchedOn;
    
    public Lamp(){
    	this.switchedOn = false;
    	this.intensity = 0;
    }
    public void switchOn(){
    	this.switchedOn = true;
    }
    public void switchOff(){
    	this.switchedOn = false;
    }
    public void dim(){
    	this.intensity = (this.intensity < 0.1 ? 0 : this.intensity-0.1);
    }
    public void brighten(){
    	this.intensity = (this.intensity > 0.9  ? 1 : this.intensity+0.1);
    }
    public void setIntensity(double value){
    	this.intensity = value;
    	if (value < 0) { this.intensity = 0; } // Mal formattato!
    	if (value > 1) { this.intensity = 1; } // Mal formattato!
    }
    public double getIntensity(){
    	return this.intensity;
    }
    public boolean isSwitchedOn(){
    	return this.switchedOn;
    }
} 
```

{{% /smaller %}}


---


## Fase 4: Miglioramento codice finale


  
### Linee guida



*  Inserire commenti nel codice
*  Verificare la necessità di costanti per evitare numeri "magici"
*  Eventualmente fattorizzare sotto-funzioni in metodi/costruttori pubblici/privati, per evitare duplicazioni
  


  
### In concreto in questo caso



*  Vi sono numeri magici, usare costanti!
*  Gestire meglio il limite $0..1$
*  Evitare livelli intermedi ($0.145$) di luminosità
*  Ritrattare la scelta del tipo del campo `intensity` -- meglio un `int` fra $0$ e $10$!!
  




---


## Versione finale Classe Lamp


<div class="container">
<div class="col">

```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/encapsulation/Lamp.java" %}}
```

</div>
<div class="col">

{{% smaller %}}


```java
{{% import-raw from=32 path="pss-code/src/main/java/it/unibo/encapsulation/Lamp.java" %}}
```

{{% /smaller %}}


</div>
</div>


---



## Fase 5: Test del risultato


  
### Linee guida



*  Definire un insieme di scenari d'uso di un oggetto
*  Per ognuno costruire una procedura che crea l'oggetto, lo usa, e stampa i risultati necessari
  


  
### Il caso `Lamp`

Un possibile caso (non costituisce da solo un test esaustivo):

*  Costruisco l'oggetto lampadina
*  La accendo
*  Imposto la luminosità, poi la vario un poco
*  Leggo e stampo lo stato del sistema
  




---


## Classe UseLamp

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/encapsulation/UseLamp.java" %}}
```

---


## Il metodo toString()


  
### Una convenzione Java



*  Ogni classe dovrebbe definire un metodo `toString()`
*  Questo deve restituire una rappresentazione in stringa dell'oggetto
*  Così si incapsula anche la funzionalità di presentazione (su console)
*  Tale metodo è quello che viene automaticamente chiamato quando si usa l'operatore `+` per concatenare stringhe a oggetti
  




---


## UseLamp: uso di toString


  

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/encapsulation/UseLampString.java" %}}
```

---


## Il collaudo di Lamp è completato?


  
### Quanti scenari di test vanno preparati?



*  Non c'è un numero giusto
*  Non è possibile in generale controllare in modo completo
*  Bisogna trovare il giusto rapporto tempo/risultato
*  Certamente, un unico scenario è insufficiente
*  La metodologia *test-driven development* consiglia di costruire test esaustivi prima dell'effettivo sviluppo di ogni funzionalità

	*  Inizialmente percepito come un po' noioso
	*  Sembra far perdere tempo
	*  Spesso ripaga in termini di temi complessivi e qualità del software profotto
	*  Supportata da framework dedicati ai test (*JUnit*)

  




---



# Ulteriori convenzioni e linee guida


## Convenzione Java sui nomi di metodi getter/setter


  
### Metodi getter/setter



*  Un metodo *__getter__* è un metodo che senza input restituisce un valore, una proprietà dell'oggetto
*  Un metodo *__setter__* è un metodo che restituisce `void` e accetta un valore che modifica una proprietà dell'oggetto
*  (Tali proprietà sono spesso campi, ma ciò non è necessario)
*  In `Lamp`, `getIntensity` e `isSwitchedOn` sono getter, `setIntensity` è un setter
  


  
### Convenzione sul nome del metodo: sia data la proprietà `XYZ` di tipo `T`



*  Getter non booleano: `T getXYZ(){...}`
*  Getter booleano: `boolean getXYZ(){...}` o anche `boolean isXYZ() {...}`
*  Setter: `void setXYZ() {...}`
  




---


## Getter/setter in Lamp

```java
public class Lamp{
    ...
    
    // Setter per proprieta' Intensity di tipo double 
    public void setIntensity(double value){
    	...
    }
    
    // Getter per proprieta' Intensity di tipo double
    public double getIntensity(){
    	...
    }
    
    // Getter per proprieta' SwitchedOn di tipo boolean
    public boolean isSwitchedOn(){
    	...
    }
} 
```



---



## LampUtilities


```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/encapsulation/LampUtilities.java" %}}
```

