+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/basics/"]

+++

# Introduzione al linguaggio Java

{{% import path="front-page.md" %}}

---

## Outline
  
### Goal della lezione
*  Mostrare un primo semplice programma Java
*  Fornire una panoramica di alcuni meccanismi base di Java
  
### Argomenti
* Stampa a video
* Tipi primitivi e operatori
* Variabili e riferimenti

---

## Hello World in Java (25+)

```java
void main() {
    System.out.println("Hello, World!");
}
```
In C sarebbe:
```c
#include <stdio.h>
int main(void) {
    printf("Hello, World!\n");
    return 0;
}
```

Come leggerlo?
- In Java esiste un oggetto chiamato `System` che rappresenta il sistema (creato automaticamente dalla virtual machine)
- L'oggetto system può ricevere il messaggio `out`, e risponde fornendo un oggetto che rappresenta lo standard output
- Fra i messaggi che l'oggetto che rappresenta lo standard output può ricevere ci sono:
    - `print`, analogo a `printf` in C, che stampa a video la stringa fornita
    - `println`, come `print`, ma va a capo sempre anche se non viene specificato `\n` 

---

## Compilazione ed esecuzione

- Salviamo il sorgente dentro un file `HelloWorld.java`
- Java è un linguaggio compilato, prima di eseguirlo dobbiamo compilarlo
    - Ossia, dobbiamo *tradurlo* da codice Java a un formato eseguibile dalla Java Virtual Machine (JVM),
        chiamato *bytecode* (file con estensione `.class`)
    - Il compilatore trasforma **file** di testo (di solito `*.java`) in **file** binari (`*.class`)
    - Il tool di compilazione è `javac` (Java Compiler)
        - Posizioniamo il terminale dove si trova il nostro file Java e lanciamo: `javac HelloWorld.java`
- Osserviamo che viene creato il file `HelloWorld.class`
    - Questo file contiene le iscrizioni in linguaggio bytecode
    - È un file binario, non può essere letto con un editor di testo
    - È però possibile decompilarlo e osservare le istruzioni usando `javap`
- L'interprete del bytecode (la Java Virtual Machine) non esegue file, ma *classi*
- Eseguiamolo con `java HelloWorld`
    - Notate che eseguiamo `HelloWorld`, e non `HelloWorld.class`!
    - La risoluzione del file `.class` dove si trova la classe viene fatta automaticamente dalla JVM
- Il risultato è la stampa a video di `Hello, World!`

---
## Il tool `JShell`

- In fase di sviluppo può essere utile un tool che permetta di eseguire codice Java senza doverlo salvare in un file e compilarlo ogni volta.

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

* È un meccanismo per classificare valori (e oggetti)
* Un *tipo* è costituito da:
    * un *nome*
    * delle regole che ne definiscono la struttura, o l'enumerazione dei possibili valori
    * un *insieme di operatori* o meccanismi per manipolarli

### Type checking in Java

* Java ha *tipizzazione statica*: ogni espressione ha un tipo noto al compilatore
* Java è *type safe*: non si accettano espressioni con errori di tipo
* $\Rightarrow\ldots$ permette l'intercettazione a priori di molti errori
* $\Rightarrow\ldots$ disciplina progettazione e programmazione


---

### Tipi in Java

Java distingue due macro-categorie di tipi: tipi **primitivi** e tipi **non-primitivi**.

#### Tipi primitivi

I tipi primitivi in Java sono `boolean`, `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `void`
* Sono tipi "fondamentali"
* Sono predefiniti nel linguaggio e non possono essere ridefiniti o creati dal programmatore
* Non sono oggetti (non accettano l'invio di messaggi)
* Risiedono nello stack, non nello heap
* Hanno sempre un valore (non possono essere `null`)

#### Tipi non-primitivi

* *Classi*: tipi di dato creabili dal programmatore
    * Sono utilizzate per costruire oggetti, che risiedono nello heap
* *Array*: `boolean[]`, `byte[]`, `String[]`, `String[][]`, $\ldots$
    * Sequenze ordinate (accessibili per indice) di valori dello stesso tipo
    * Sono oggetti, ma hanno una sintassi speciale
* *Stringhe*: `String`
    * Sequenza di caratteri (oggetti, ma con sintassi speciale)
* *Wrapper types*: `Boolean`, `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Char`, `Void`
    * Versioni "oggetto" dei tipi primitivi, saranno utili in futuro
    * Per ora, sono comode per ottenere alcuni valori speciali (es.: `Integer.MAX_VALUE`)

---

## Tipi primitivi

| Type name | Size (bits) | Minimum        | Maximum               |
|-----------|-------------|----------------|-----------------------|
| `char`    | 16          | `\u0000` ($0$) | `\uFFFF` ($2^{16}-1$) |
| `byte`    | 8           | $-128$         | $128$                 |
| `short`   | 16          | $-2^{15}$      | $2^{15}-1$            |
| `int`     | 32          | $-2^{31}$      | $2^{31}-1$            |
| `long`    | 64          | $-2^{63}$      | $2^{63}-1$            |
| `float`   | 32          | IEEE754        | IEEE754               |
| `double`  | 64          | IEEE754        | IEEE754               |
| `boolean` | 8           | --             | --                    |
| `void`    | --          | --             | --                    |

---

## `boolean`

Rappresentano valori di verità

* Valori ammessi: `true`, `false`
* Operatori unari: `!` (not)
* Operatori binari: `&` (and), `|` (or), `^` (xor), `&&` (and-c), `||` (or-c)
    * `&&` e `||` valutano il secondo argomento solo se necessario (*short-circuiting*)
        * `false && X` restituisce `false` senza valutare `X`
        * `true || X` restituisce `true` senza valutare `X`

Gli *operatori* di *confronto e uguaglianza* restituiscono `boolean`
* Operatori di uguaglianza e diseguaglianza: `==`, `!=`
* Operatori di confronto fra primitivi numerici: `>`, `<`, `>=`, `<=`

Gli *operatori* e le *strutture di controllo* che operano sulla base di *valori di verità*
(operatore ternario `?:`, strutture `if`, `while`, e `for`)
si aspettano valori di tipo `boolean`

---

## Interi: `byte`, `short`, `int`, `long`

### Operatori

* Binari per operazioni numeriche: `+`, `-`, `*`, `/`, `%` (resto della divisione)
* Binari bit-a-bit: `&` (and), `|` (or), `^` (xor)
* Binari per bit-shift: `<<` (sinistra), `>>` (destra con segno), `>>>` (destra senza segno)
* Unari: `+`, `-` (inversione del segno), `~` (complemento bit-a-bit), `++` (incremento), `--` (decremento)
    * `++` e `--` possono essere prefissi o postfissi
        * `++x` e `--x` incrementano/decrementano e restituiscono il nuovo valore
        * `x++` e `x--` restituiscono il vecchio valore e poi incrementano/decrementano
* Operatori unari/binari applicati ad un tipo, restituiscono il tipo stesso

### Codifica, rappresentazione

* Interi codificati in [complemento a 2](https://it.wikipedia.org/wiki/Complemento_a_due)
    * da cui, per un numero di $N$ bit, il range di valori rappresentabili è $[-2^{N-1}, 2^{N-1}-1]$
* Rappresentazione decimale (`200`), ottale (`0310`), esadecimale (`0xC8`)
* Di default sono `int`, per avere un `long` va aggiunta una `L` (`15L`)
* Nessuna sintassi speciale per `byte` e `short` (usati di rado): si usano "cast" espliciti (`(byte) 5`)
* È possibile usare underscore (`_`) per separare le cifre
    * Es.: `1_000_000` è più leggibile di `1000000`
* Valori *speciali* nei wrapper types: `*.MAX_VALUE`, `*.MIN_VALUE`, e.g. `Integer.MAX_VALUE`

---

## Numeri in virgola mobile: `float`, `double`

Numeri con virgola mobile, con valori speciali che rappresentano valori non numerici o infiniti
### Operatori
* Unari: `+` e `-`
* Binari: `+`, `-`, `*`, `/`, `%` (resto della divisione)

### Codifica, rappresentazione
* Codificati secondo lo standard [IEEE 754](https://en.wikipedia.org/wiki/IEEE_754)
    * Perdono di precisione man mano che il numero cresce
    * Sono possibili errori di arrotondamento (provate a fare `0.1 + 0.2` in JShell)
* Rappresentazione standard (`-128.345`), o scientifica (`-1.2835E+2`)
* Di default sono `double`, per avere un `float` va aggiunta una `f`
* Valori speciali:
    * "not-a-number" (`Float.NaN`, `Double.NaN`),
    * $\infty$ (`Float.POSITIVE_INFINITY`, `Double.POSITIVE_INFINITY`)
    * $-\infty$ (`Float.NEGATIVE_INFINITY`, `Double.NEGATIVE_INFINITY`)
    * Valori più grandi e più piccoli rappresentabili: `*.MAX_VALUE`, `*.MIN_VALUE`

---

## Provate voi stessi

<!--  \srcode{\scriptsize}{3}{100}{\ecl/Try.java} -->

```java
{{% import-raw from=2 path="pss-code/src/main/java/it/unibo/structured/Try.java" %}}
```
---

## Conversioni fra tipi *primitivi*

### Conversioni di tipo forzate, dette *type cast*: `(tipo) valore`
* Sempre consentite fra tipi numerici
* non consentite tra tipi numerici e `boolean`
* Possono causare perdita di informazione!
    * Es.: `(int) 3.33`, `((double) 10)/3`, `(short) 100_000`

### Conversioni automatiche, dette *coercizioni*
* Solo da un tipo più specifico a uno più generale (*promozione*)
    * (+ Specifico $\rightarrow$ + Generale) `byte`$\rightarrow$`short`$\rightarrow$`int`$\rightarrow$`long`$\rightarrow$`float`$\rightarrow$`double`
    * Possono comunque generare perdita di informazione nel passaggio da `long` a `float`!
        * Provate: `(long) ((float) Long.MAX_VALUE - 1) == Long.MAX_VALUE - 1`
        * Perché?
* Le inserisce automaticamente il compilatore dove necessario, ad esempio:
    *  In assegnamenti: `long l = 100;` diventa `long l = 100L;`
    *  In operazioni fra tipi diversi: `10.1 + 10` diventa `10.1 + 10.0`
    *  Passando valori a funzioni che si aspettano un tipo più generale

---

## `char`

### Codifica (rappresentazione interna)
*  UTF16
    - variable-length encoding (ogni *codepoint* in 1 o 2 unità di 16 bit) $\to$ sussume ASCII
*  automaticamente convertibile da/a un numerico fra 0 e 65535

### Rappresentazione (esterna)
* Singolo carattere: `'a'`, `'z'`, `'A'`, `'='`, `'✀'`
* Codice UTF-16 (sussume ASCII): 65 (`'A'`), 66 (`'B'`), 9984 (`'✀'`)
* Caratteri speciali: `'\n'`, `'\\'`, `'\0'`...
* UTF-16 code units (equivale a Unicode code points da U+0000 a U+FFFF): `'\u2603'` (`'☃'`)
* Code points > U+FFFF possono essere rappresentati con due `char` (*surrogate pairs*)
    - Es.: `"\uD83E\uDD96"` (`"🦖"`) (notare che produce una stringa di due caratteri)

---

## Le Stringhe

Oggetti della classe `String` (vedremo le classi in dettaglio più avanti).

Si rappresentano con sequenze di caratteri racchiusi da doppi apici: `"Ciao Mondo!"`

Le istanze di `String` sono **immutabili**: una volta create non possono essere modificate.
  - Operazioni che "modificano" una stringa in realtà ne creano una nuova.

### Operazione principale — Concatenazione
- L'operatore `+` concatena stringhe:
```java
"Ciao " + "Mondo!" // "Ciao Mondo!"
String s = "Ciao";
s = s + " Mondo";   // crea una nuova String
```

### Conversioni
- Da primitivo a stringa: `String.valueOf(42)`, oppure `Integer.toString(42)`
    - In generale, per ogni wrapper type `T`, `T.toString(x)` converte `x` in `String`
- Da stringa a primitivo: `Integer.parseInt("42")`, `Double.parseDouble("3.14")`
    - In generale, per ogni wrapper type `T`, `T.parseT(s)` converte la stringa `s` in un valore di tipo `T`

**Attenzione**: le conversioni **non sono cast**!
* Java non consente cast fra tipi primitivi e tipi non-primitivi (eccetto wrapper types), le conversioni vanno effettuate tramite apposite funzioni


---

# Array

---

## Java array 

### Caratteristiche generali

*  Internamente sono degli oggetti
*  Quindi sono gestiti con riferimenti sullo heap
*  Notazione ad-hoc (e C-like) per creare, leggere e scrivere elementi

### Principale differenza rispetto al C

* Un array ha una lunghezza esplicita e accessibile (non modificabile)
    * In C la lunghezza va tracciata separatamente
* È impossibile violare i limiti di una array, pena un errore (`ArrayIndexOutOfBoundsException`)
    * In C si può provare a leggere o scrivere fuori dai limiti, con conseguenze imprevedibili
      (da lettura di dati spuri a crash del programma per segmentation fault)

---

## Sintassi Array (introduzione)

### Creazione array

- ```int[] array = {10, 20, 30};``` (inizializzazione per elenco)
- Vedremo altre forme più avanti

### Accesso array (*zero-indexed*)

```java
arr.length    // 3 (lunghezza)
arr[0]       // espressione per leggere 0-esimo elemento
arr[0] = 10; // assegnamento del 0-esimo elemento
```

---


## Qualche esempio d'uso di array


<!--  \srcode{\scriptsize}{3}{100}{\ecl/UseArrays.java} -->

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/structured/UseArrays.java" %}}
```

---

<!--
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
--> 

# Istruzioni (statement)

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

---

### Differenza filosofica

*  Java è molto più restrittivo di C
*  Molto di ciò che è solo *warning* in C, è **errore** in Java
    * *unreachable statement*: istruzioni non raggiungibili (per errore)
    * *variable may not have been initialised* (uso variabile prima del suo init)
    * *missing return statement* (un return finale è obbligatorio)
*  Può sembrare una filosofia che rende la programmazione "rigida", e invece è cruciale per supportare lo sviluppo di software di qualità
    * Principio ingegneristico: *fail fast*
*  Le prassi che discuteremo ci porteranno ulteriori rigidità

---

## Controllo di flusso: `if`

### Sintassi
```java
if(condizione) {
  // blocco eseguito se condizione è true
}
```
- La condizione deve essere di tipo `boolean`.
- Usare sempre le parentesi graffe anche per un'unica istruzione.
    - Non richiesto dalla sintassi, ma evita errori difficili da individuare.

### Esempio
```java
int x = 10;
if (x > 0) {
  System.out.println("Positivo");
}
```
---

## `if-else` e `else if`

### Sintassi
```java
if(cond1) {
  ...
} else if(cond2) {
  ...
} else {
  ...
}
```

### Esempio
```java
int n = Integer.parseInt(s);
if (n < 0) {
  System.out.println("Negativo");
} else if (n == 0) {
  System.out.println("Zero");
} else {
  System.out.println("Positivo");
}
```

---

## Ciclo `while`
### `while`
```java
while (condizione) {
  // corpo
}
```

1. valuta `condizione` (deve restituire `boolean`)
2. se `true`, esegue il corpo e torna a 1.

Esempio:
```java
int i = 0;
while (i < 5) {
  System.out.println(i);
  i++;
}
```

---

## Ciclo `do`-`while`
### `do`-`while`
```java
do {
  // corpo
} while (condizione);
```

1. esegue il corpo
2. valuta `condizione` (deve restituire `boolean`)
3. se `true`, torna a 1.

Utile se il corpo deve essere eseguito almeno una volta.

Esempio:
```java
int i = 0;
do {
  System.out.println(i);
  i++;
} while (i < 5);
```

--- 

## Ciclo `for` (classico)

### Sintassi
```java
for (inizializzazione; condizione; aggiornamento) {
  // corpo
}
```

1. Esegue `inizializzazione`
2. Valuta `condizione` (deve restituire `boolean`)
3. Se `true`, esegue il corpo
4. esegue `aggiornamento`
5. Torna a 2.

### Esempio
```java
for (int i = 0; i < 10; i++) {
  System.out.println(i);
}
```
- È possibile dichiarare una variabile nel blocco di inizializzazione
    - La variabile dichiarata (`int i`) ha scopo limitato al `for` (non è visibile fuori)

---

## Come si itera sugli array?

In Java si può usare il classico `for` (come in C):


<!--  %\sizedcode{\scriptsize}{code/Reverse.java}
  \srcode{\scriptsize}{3}{100}{\ecl/Reverse.java} -->

```java
{{% import-raw from=0 path="pss-code/src/main/java/it/unibo/structured/SimpleArray.java" %}}
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
{{% import-raw from=0 path="pss-code/src/main/java/it/unibo/structured/Sum.java" %}}
```

---

# Introduzione al linguaggio Java

{{% import path="front-page.md" %}}