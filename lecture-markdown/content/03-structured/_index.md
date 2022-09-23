
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/java-structured-programming/"]

+++

# Programmazione strutturata in Java

{{% import path="cover.md" %}}

## Riassunto delle puntate precedenti (i)

- Programma vs. sistema software
- Fasi processo di sviluppo: analisi $\to$ design $\to$ implementazione $\to$ collaudo $\to$ deployment
- Problem space (dominio/logica business) vs. solution space (scelte realizzative)
    - livello di astrazione
- Astrazione object-oriented
    - *oggetto = stato + comportamento + identità* (cf. *incapsulamento*)
    - interazione attraverso "scambio di messaggi"
    - *classe* come "tipo" di oggetti e come "template" di costruzione di oggetti simili (*istanze*)
    - *interfaccia* vs. implementazione (cf. *information-hiding*)
- Riuso mediante
    - utilizzo di altri oggetti (*composizione*) 
    - estensione dei servizi offerti da altri oggetti (*ereditarietà*)

---

- Java 17
    - *write once, run everywhere*
    - JDK: JRE (JVM [`java`] + JCL) + strumenti di sviluppo (`javac`, ...)
- Costrutti Java per la OOP
    - tipi primitivi vs. tipi oggetto (classi)
    - variabili e riferimenti ad oggetti (allocati nello *heap*) (assegnamento per copia)
    - lifetime di oggetti va oltre lo scope; no deallocazione manuale (cf. *GC*)
    - classi: *campi* & *metodi* (statici o d'istanza) -- accedibili mediante _dot notation_
    - concetto di *receiver* di una *method call* e variabile speciale `this`
    - *programmi*: metodo pubblico statico `main` in classe pubblica
- Strumenti: compilazione con `javac` ed esecuzione con `java`

_Competenza attuale attesa: costruzione di semplici classi; loro esercizio mediante programmi; compilazione ed esecuzione di programmi_

---

## Outline



### Goal della lezione



  *  Mostrare la parte imperativa/strutturata del linguaggio Java
  *  Illustrare le differenze rispetto al linguaggio C
  *  Approfondire alcuni aspetti nuovi (array, foreach)
  *  Discutere alcuni aspetti preliminari di qualità del software




### Argomenti



  *  Tipi e operatori di Java
  *  Il caso degli array
  *  Istruzioni di Java
  *  Costrutti di programmazione strutturata
  *  Costruzione e uso di utility class
  *  Elementi iniziali di buona programmazione


---


## Il tool `JShell`



### JShell (JDK 9+)



  *  richiamabile da linea di comando: `jshell`
  *  è una console Java, dove si possono eseguire istruzioni vedendone subito l'effetto
  *  si ispira a tool *REPL (Read-Eval-Print Loop)* di altri linguaggi
  *  non molto usata, ma utile per veloci esperimenti (cf. slide seguenti)


---


# Tipi e operatori di Java

---

## Tipi



### Cos'è un tipo

  *  È un meccanismo per classificare valori (e oggetti)
  *  Un *tipo* è costituito da un *nome*, un *set di valori*, e un *set di operatori*/meccanismi per manipolarli

### Tipi di Java

*  *Primitivi*: `boolean`, `byte`, `short`, `int`, `long`, `float`, `double`, `char`
*  *Classi*: `Object`, `String`, `Integer`, `ArrayList`, `JFrame`, $\ldots$
*  *Array*: `boolean[]`, `byte[]`, `String[]`, `String[][]`, $\ldots$
*  Altri che vedremo in seguito: interfacce, classi innestate, generici, ...

### Java e i tipi

* Java ha *tipizzazione statica*: ogni espressione ha un tipo noto dal compilatore
* Java ha *tipizzazione forte*: non si accettano espressioni con errori di tipo
* $\Rightarrow$ .. permette l'intercettazione a priori di molti errori
* $\Rightarrow$ .. disciplina progettazione e programmazione


---


## Tipo Booleano

* Nome del tipo: `boolean`
* Valori: `true`, `false`

*  Operatori unari: `!` (not)
*  Operatori binari: `&` (and), `|` (or), `^` (xor), `&&` (and-c), `||` (or-c)
    * `&&` e `||` valutano il secondo argomento solo se necessario (*short-circuiting*)
    * `false && X` restituisce `false` senza valutare `X`
    * `true || X` restituisce `true` senza valutare `X`
*  Operatori di confronto numerici: `>`, `<`, `>=`, `<=`
*  Operatori di uguaglianza (su tutti i tipi): `==`, `!=`
  ```java
  10 == 20                     // false
  new Object() == new Object() // false (confronta i riferimenti)
  ```
*  Operatore ternario (booleano,tipo,tipo): `?:`
    *  `b ? v1 : v2` restituisce `v1` se `b` è vero, `v2` altrimenti





---


## Tipi numerici


| Type name | Size (bits) | Minimum | Maximum |
| --------- | ---- | ------- | ------- |
| char | 16 | `\u0000` ($0$) | `\uFFFF` ($2^{16}-1$) |
| byte | 8 | $-128$ | $128$ |
| short | 16 | $-2^{15}$ | $2^{15}-1$ |
| int | 32 | $-2^{31}$ | $2^{31}-1$ |
| long | 64 | $-2^{63}$ | $2^{63}-1$ |
| float | 32 | IEEE754 | IEEE754 |
| double | 64 | IEEE754 | IEEE754 |
<!--| void | -- | -- | -- |-->
<!--| boolean | -- | -- | -- |-->

---


## Interi: `byte`, `short`, `int`, `long`



### Operatori



  *  Base: `+`, `-`, `*`, `/` (con resto), `%` (resto), `+` e `-` anche unari
  *  Bit-a-bit: `&` (and), `|` (or), `^` (xor), `~` (not)
  *  Shift: `>>` (dx senza segno), `<<` (sx), `>>>` (dx senza segno)
  *  Operatori unari/binari applicati ad un tipo, restituiscono il tipo stesso




### Codifica, rappresentazione



  *  Interi codificati in complemento a 2 (ciò impatta il suo range)
  *  Rappresentazione decimale (`200`), ottale (`0310`), esadecimale (`0xC8`)
  *  Di default sono `int`, per avere un `long` va aggiunta una `L` (`15L`)




### Prassi



*  Raro l'uso di `byte` e `short`, non molto più efficienti di `int`
*  `int` più efficiente di `long`





---


## Numeri in virgola mobile: `float`, `double`



### Operatori



  *  Base: `+`, `-`, `*`, `/` (con resto), `%` (resto), `+` e `-` anche unari




### Codifica, rappresentazione



  *  Codificati secondo lo standard IEEE 754
  *  Rappresentazione standard (`-128.345`), o scientifica (`-1.2835E+2`)
  *  Di default sono `double`, per avere un `float` va aggiunta una `F`

```java
5   // int
5.  // double
5d  // double
5f  // float
```

### Prassi



  *  Raro l'uso di `float`, anche se più efficiente di `double`
  *  Attenzione agli errori di precisione!!





---


## Provate voi stessi..


<!--  \srcode{\scriptsize}{3}{100}{\ecl/Try.java} -->

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/structured/Try.java" %}}
```

---


## Conversioni



### Conversioni di tipo, dette anche *cast*: `(tipo)valore`



* Fra tipi numerici sono sempre consentite
    * mentre non lo sono, ad es. tra tipi numerici e `boolean`
* Possono causare perdita di informazione
* Es.: `(int)3.33`, `((double)10)/3`, `(short)100`

### Conversioni automatiche, dette anche *coercizioni*



  *  Le inserisce automaticamente il compilatore in certi casi
  *  Quando ci si aspetta un tipo, e si usa un valore diverso
  *  Solo da un tipo più specifico a uno più generale (*promozione*)
      *  (+ Specifico $\rightarrow$ + Generale) `byte`$\rightarrow$`short`$\rightarrow$`int`$\rightarrow$`long`$\rightarrow$`float`$\rightarrow$`double`
  *  Due casi:
      *  In assegnamenti: `long l=100;` diventa `long l=(long)100;`
      *  Operazioni fra tipi diversi: `10.1+20` diventa `10.1+(double)10`
      *  Passando valori a funzioni






---


## I caratteri



### Rappresentazione (esterna)

  *  Singolo carattere: `'a'`, `'z'`, `'A'`, `'='`
  *  Codice ASCII: 65 (`'A'`), 66 (`'B'`)
  *  Caratteri escape: `'\n'`, `'\\'`, `'\0'`
  *  Caratteri UTF16: `'\u6C34'`




### Codifica (rappresentazione interna)

*  UTF16
    - variable-length encoding (ogni *codepoint* in 1 o 2 unità di 16 bit) $\to$ non compatibile con ASCII
*  automaticamente convertibile ad un numerico fra 0 e 65535



<!--  \srcode{\scriptsize}{3}{100}{\ecl/TryChars.java} -->

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/structured/TryChars.java" %}}
```


<!--

---

```
a".getBytes(java.nio.charset.StandardCharsets.ISO_8859_1) // byte[1] { 97 }

a".getBytes(java.nio.charset.StandardCharsets.UTF_8)      // byte[1] { 97 }

a".getBytes(java.nio.charset.StandardCharsets.UTF_16)     // byte[4] { -2, -1, 0, 97 }
```
-->

---


# Array

---



## Java array



### Caratteristiche generali



  *  Internamente sono degli oggetti (cf. creazione con `new`)
  *  Quindi sono gestiti con riferimenti sullo heap
  *  Notazione ad-hoc (e C-like) per creare, leggere e scrivere elementi




### Principale differenza rispetto al C



  *  Un array ha una lunghezza (campo `length`) esplicita e accessibile (non modificabile)
  *  È impossibile violare i limiti di una array, pena un errore (`ArrayIndexOutOfBoundsException`)
  *  L'accesso all'array è di conseguenza leggermente rallentato





---


## Sintassi Array



### Creazione array



* Due notazioni, per elenco (elencazione di valori) 
  ```java
  int[] ar1 = new int[]{10,20,30,40,50,7,8,9};
  var   ar2 = new int[]{10,20,30}; // variante con `var`
  int[] ar3 = {10,20,30};          // variante senza `new`
  ```
  e per dimensione
  ```java
  int[] ar4 = new int[200];        // new int[]{0,0,...,0}
  ```
    *  quando creati per dimensione, gli elementi sono inizializzati (come se fossero campi di una classe)
*  la creazione di array di array (*matrici*) è analoga:

```java
int[][] m  = new int[][]{ new int[]{...}, ... };
int[][] m2 = new int[200][200];
```

### Accesso array (*zero-indexed*)

```java
ar4.length    // 200 (lunghezza)
ar4[23]       // espressione per leggere 24-esimo elemento
ar4[23] = 10; // assegnamento del 24-esimo elemento
m[1][2] = 10; // assegnamento riga 2 colonna 3
```





---


## Qualche esempio d'uso di array


<!--  \srcode{\scriptsize}{3}{100}{\ecl/UseArrays.java} -->

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/structured/UseArrays.java" %}}
```

---


## Array di oggetti



### Creazione array -- stessa notazione



*  Per elenco:
```java
Object[] ar = new Object[]{ new Object(), new Object() };
```
*  Per dimensione
```java
Object[] ar2 = new Object[200];
```
* Note
    *  in ogni posizione c'è `null`
    *  frequente errore dello studente è pensare che sia un array di nuovi oggetti automaticamente creati
    *  ricorda: è una sola `new` quindi si crea un solo oggetto, l'array stesso





---

# Istruzioni (statement)

---

## I linguaggi OO sono anche imperativi/strutturati



### Java "estende" il C



  *  Come C++ e C\#, Java è alla base anche imperativo/strutturato -- altri linguaggi come Scala invece no
  *  Il codice di un metodo è un insieme di comandi C-like
<!--  *  Ecco perché li si chiama object-oriented e non object-based -->
<!-- In realtà: object-based PLs consentono di creare e usare oggetti; quelli object-oriented forniscono inoltre supporto per ereditarietà e polimorfismo -->




### Panoramica istruzioni



  *  Variabili e assegnamenti:
```java
int x;              // dichiarazione
int x=5;  var x=5;  // dichiarazione e inizializzazione (assegnamento)
x=5;                // assegnamento
```
  *  Ritorno: `return 5;`
  *  Chiamate: `meth(3,4);` `obj.meth(3);`  `Cls.meth(4);`
  *  Costrutti di controllo del flusso: `for`, `while`, `do`, `switch`, `if`, `break`, `continue`
  *  Qualche altra tipologia, che vedremo nel prosieguo





---


## Java vs C



### Principali differenze



* No coercizione da altri tipi verso `boolean` (cf. strong typing)
    * Nota: la condizione dell'`if`, `for`, `while` e `do` è un `boolean`
  ```java
  boolean b = 1;            // ERROR: incompatible types: int cannot be converted to boolean
  boolean b = (boolean) 1;  // incompatible types: int cannot be converted to boolean
  if(1){ /* ... */ }        // ERROR: incompatible types: int cannot be converted to boolean
  ```
* No puntatori, no de/allocazione manuale di oggetti

<!--
*  Nel `for` è possibile dichiarare la variabile di ciclo (come nel C99), che sarà visibile solo internamente
```java
for(int i=0; i<10; i++){ /* .. */ }
```
--->




### Differenza filosofica



*  Java è molto più restrittivo del C
*  Molto di ciò che è solo *warning* in C, è *errore* in Java
    *  *unreachable statement*: istruzioni non raggiungibili (per errore)
    *  *variable may not have been initialised* (uso variabile prima del suo init)
    *  *missing return statement* (un return finale è obbligatorio)
*  Può sembrare una filosofia che rende la programmazione "rigida", e invece è cruciale per supportare lo sviluppo di software di qualità
*  Le prassi che discuteremo ci porteranno ulteriori rigidità

---


## Java come linguaggio puramente strutturato-procedurale

### Un uso limitato (ma a volte utile) di Java

  *  Una classe ha solo metodi o campi dichiarati `static`
  *  In questo caso tale classe definice un insieme di *funzioni/procedure* e *variabili globali* (a quella classe), ossia una struttura analoga a quella di una libreria C
  *  Un metodo (o campo) *__statico__* viene richiamato nel seguente modo:
      *  da fuori la classe (se dichiarato `public`): `<nome-classe>.<nome-metodo>(...)`
      *  da dentro la classe: `<nome-metodo>(...)`
  *  E' una tecnica usata per realizzare *utility class*, come ad esempio la classe delle funzioni matematiche `java.lang.Math`


---



## Qualche prova di `java.lang.Math`


<!--  \srcode{\ssmall}{3}{100}{\ecl/UseMath.java} -->

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/structured/UseMath.java" %}}
```

---



## Un esercizio sugli array



Costruire una funzione che dato un array ne produce in uscita uno della stessa lunghezza, ma invertendo il primo elemento con l'ultimo, il secondo col penultimo, etc..

<!--  %\sizedcode{\scriptsize}{code/Reverse.java}
  \srcode{\scriptsize}{3}{100}{\ecl/Reverse.java} -->

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/structured/Reverse.java" %}}
```

---


## For-each



### Java introduce una variante del ciclo `for`



   *  supporta l'astrazione di "per ogni elemento della collezione fai.."
   *  utile con gli array quando non importa il valore corrente dell'indice
   *  utilizzabile con oggetti *iterabili*, quindi anche con le Collection di Java (liste, insiemi,..)




### Sintassi -- caso di array di interi

```java
for(int v: array){ /* uso di v */ }
```

   *  spesso usato con `var`:
```java
for(var v: array){ /* uso di v */ }
```
   *  `array` è una espressione che restituisce un `int[]`
   *  nel corpo del `for`, `v` vale via via ogni elemento dell'array
   *  leggi "per ogni `v` in `array` esegui il corpo"






---


## For-each: esempio


<!--  %\sizedcode{\scriptsize}{code/Sum.java}
  \srcode{\scriptsize}{3}{100}{\ecl/Sum.java} -->

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/structured/Sum.java" %}}
```

---


## Fornire input da linea di comando: argomenti del `main`


<!--  %\sizedcode{\scriptsize}{code/Sum.java}
  \srcode{\scriptsize}{3}{100}{\ecl/SumMain.java}-->

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/structured/SumMain.java" %}}
```

---


## Elementi applicativi all'interno del corso OOP



### Teoria o applicazioni?



  *  La parte applicativa è maggiormente sviluppata in laboratorio e poi sperimentata nella realtà nella prova d'esame di progetto
  *  In aula si illustrano i concetti, i meccanismi, e gli elementi metodologici
  *  Spesso comunque si mostreranno applicazioni di esempio, semplici ma "paradigmatiche", dove discutere alcuni aspetti tecnici e metodologici





---


## Applicazione: `GuessMyNumberApp`



### Problema


  Realizzare una applicazione che, scelto un numero a caso compreso fra 1 a 100, chieda all'utente di indovinarlo, dandogli $10$ tentativi e indicando ogni volta se il numero in input è maggiore o minore di quello scelto all'inizio



### Alcune scelte progettuali



  *  L'applicazione è realizzabile in prima battuta come codice strutturato dentro al `main`
  *  Le (max) 10 iterazioni sono realizzabili da un ciclo (p.e., `for`)




### Elementi implementativi



  *  `java.io.Console#readLine` usabile per leggere input da tastiera (console ottenibile da `System.console()`, se associata alla JVM in uso)
  *  `java.lang.Integer.parseInt(String)` usabile per convertire una stringa in un numero
  *  `java.util.Random.nextInt` usabile per ottenere un numero random





---



## Implementazione `GuessMyNumberApp`


<!--  \srcode{\scriptsize}{3}{100}{\ecl/GuessMyNumberApp.java} -->

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/structured/GuessMyNumberApp.java" %}}
```

---


# Qualità del software

---



## Come è fatto del "buon software"?



### Qualità *esterna* -- aspetti *funzionali*


* Realizza correttamente il suo compito
* In termini di quali funzionalità fornisce




### Qualità *esterna* -- aspetti *non-funzionali*



  *  Performance adeguate (alle specifiche)
  *  Uso efficiente/adeguato delle risorse del sistema (memoria, CPU)
  *  Caratteristiche di sicurezza, affidabilità, usabilità, etc..




### Qualità *interna* -- software ben costruito



  *  Facilmente manutenibile (leggibile, flessibile, riusabile)
  *  E quindi: meno "costoso", a breve-/medio-/lungo-termine
      * ci concentriamo per ora su questa tipologia





---


## Caratteristiche di *qualità interna*



### Elementi necessari per il funzionamento

  *  *Sintassi*: soddisfa la grammatica del linguaggio
  *  *Semantica*: passa tutti i check del compilatore


### Elementi aggiuntivi di qualità

  *  *Convenzioni*: soddisfa le convenzioni d'uso del linguaggio
  *  *Commenti*: usa i commenti mirati necessari a comprenderlo
  *  *Efficace*: usa tecniche che portano a evitare problemi futuri


---


## Correttezza sintattica



### Sintassi



  *  Gli errori di sintassi sono i primi ad essere eliminati
  *  Molti IDE li segnalano durante la digitazione
  *  La Java Language Specification fornisce la grammatica del linguaggio (V7, p.591)




### Esempi comuni d'errore (in questo corso, in genere all'inizio)



  *  Parentesi non bilanciate (specialmente le graffe)
  *  Refusi nelle keyword: `Class`, `clas`, `bolean`
  *  Punteggiatura errata o mancante: `for(int i=0,i<10,i++){..}`





---


## Correttezza semantica



### Correttezza semantica -- check del compilatore



*  Oltre ad errori sintattici (forma), il compilatore segnala anche gli errori semantici (significato)
    * ad es. quelli legati all'utilizzo dei tipi
*  Ed è molto più rigido del C
*  Possono essere di varia natura, e a volte più difficili da comprendere




### Esempi comuni d'errore


  *  Uso inappropriato dei tipi (e.g. *incompatible types* o *bad operand types for operator*):
```
int a = true;
int a = 5 + false;
if (5) ..
```
  *  Refusi nel nome di campi, metodi, classi: `string`, `system`, `Sistem` (cf. Errore *cannot find symbol*)
  *  Accesso a variabili, campi, metodi, classi che non esistono o non sono visibili
  *  Errori di flusso: *missing return statement*





---


## Convenzioni



### Convenzioni sul codice



*  Riguardano indentazione, commenti, dichiarazioni, convenzioni sui nomi
*  Migliorano leggibilità, e quindi comprensione
*  È cruciale che vengano seguite
*  http://www.oracle.com/technetwork/java/codeconv-138413.html




### Li vedremo via via.. intanto focalizziamoci sulla formattazione



*  Una istruzione per linea
*  Formattazione parentesi graffe (E' CRUCIALE!)
*  Inserire commenti nel codice---ne vedremo i dettagli





---


## Effective programming



### Programmazione efficace



*  Vi sono un insieme di tecniche di programmazione che l'esperienza ha mostrato migliorare l'efficacia della programmazione
*  Molte sono connesse a *best practice* di programmazone OO e all'uso di *pattern* di progettazione noti
    *  Si vedano i libri *"Effectiva Java"* e *"Design Patterns"*
*  Ne vedremo un po', mano a mano
<!--, e in dettaglio a fine del corso-->





---


## Una nota sulle performance



### Performance e JVM


*  I linguaggi OO sono stati spesso criticati perchè più lenti rispetto ai linguaggi imperativi/strutturati
*  Java e C\# in più hanno una VM d'esecuzione che introduce ulteriori rallentamenti
*  Di recente, tecniche avanzate (cf. *JIT compilation*) nelle VM hanno ridotto, se non in alcuni casi annullato, le differenze in performance




### In questo corso



*  Non ci occuperemo in dettaglio di questo aspetto
*  Prediligeremo sempre la soluzione più semplice/compatta
*  Ci si aspetta non si usino soluzioni sia più complesse che più lente
*  Ci si aspetta che si sappiano allocare correttamente le risorse (memoria, tempo) qualora richiesto
