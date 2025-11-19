
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/lambdas/"]

+++

# Functional Java con Lambda e Stream

{{% import path="front-page.md" %}}

---

## A partire da Java 8

* Principale novità: *lambda* (ossia uno degli elementi fondamentali dello stile di *programmazione funzionale*)
    * Le lambda portano ad uno stile più elegante e astratto di programmazione
    * In Java, portano a codice più compatto e chiaro in certe situazioni
    * Impatta alcuni aspetti di linguaggio
    * Impatta varie librerie

### Risorse

*  Libri: R.Warburton, Java 8 Lambdas
*  [Java Specification Request (JSR)-335: Lambda Expressions for the Java Programming Language](http://cr.openjdk.java.net/~dlsmith/jsr335/jsr335-final/)

---

### Comparatori definiti attraverso classi

    
```java
{{% import-raw from=7 path="pss-code/src/main/java/it/unibo/lambdas/intro/FirstComparableBasic.java" %}}
``` 

---

### Comparatori definiti attraverso classi innestate

- Una **classe innestata statica** `B` (*static nested*) è definita all'interno di un'altra classe `A`
    - Dunque ci si può riferire ad essa via `A.B` (secondo regole di visibilità), o direttamente via `B` da dentro la classe `A` -- [approfondimento](/advanced-mechanisms-nesting)
    
```java
{{% import-raw from=7 path="pss-code/src/main/java/it/unibo/lambdas/intro/FirstComparableNested.java" %}}
```

---


### Comparatori definiti attraverso classi anonime

- Una **classe anonima** è una classe definita "al volo" (senza fornirne dunque un nome) e immediatamente istanziata per evitare la proliferazione di classi -- [approfondimento](/19-advanced-mechanisms-nesting/#/36)
    *  Tipicamente: per implementare "al volo" una interfaccia
    
```java
{{% import-raw from=7 path="pss-code/src/main/java/it/unibo/lambdas/intro/FirstComparableWithAnonymousClasses.java" %}}
```

---


### Comparatori attraverso lambda

- Una **lambda** è una *funzione anonima*, creata "al volo"
- internamente implementata come *istanza* di un'**interfaccia funzionale**
    - un'interfaccia "SAM" (single abstract method), ossia che definisce un solo metodo astratto

```java
{{% import-raw path="pss-code/src/main/java/it/unibo/lambdas/intro/FirstComparableWithLambdas.java" %}}
```

---

## Elementi delle lambda expression

### Che cos'è una lambda
* è una *funzione (anonima)* con *accesso a uno scope locale* (cf. *chiusura* o *closure*)
* è applicabile a certi input, e dà un risultato (oppure `void`)
   * per calcolare il risultato potrebbe usare qualche variabile nello scope in cui è definita
* la lambda è *usabile come "valore"* (quindi, come dato), ossia è passabile a metodi, altre funzioni, o memorizzata in variabili/campi
   * ossia, consente di "passare" del "codice"

### Caratteristica specifica di Java
* come vedremo, una lambda è un oggetto, e il suo tipo è sempre quello di una `interface` detta "funzionale"
*  metodi statici o istanza possono essere usati a mo' di lambda (chiamati "method reference", perché sono interpretabili come funzioni)

---

## Come si esprime una lambda

### Sintassi possibili
* `(T1 x1, ..., Tn xn) -> { <body> }`
*  `(x1, ..., xn) -> { <body> }`
*  `x -> { <body> }`
*  `(T1 x1,..,Tn xn) -> <exp>`
*  `(x1,..,xn) -> <exp>`
*  `x -> <exp>`
*  .. oppure un "method reference" (si veda in seguito)

### Ossia:
*  Per gli argomenti si può esprimere un tipo o può essere inferito (*type inference*)
*  Con un argomento, le parentesi tonde sono omettibili
*  Il body può essere direttamente una singola espressione/istruzione

---

## Esempi di sintassi di Lambda expressions

```java
{{% import-raw path="pss-code/src/main/java/it/unibo/lambdas/intro/FilteringWithLambdas.java" %}}
```

---

## Method references

### Sintassi possibili
*  
* `<class>::<static-method>`
    *  sta per `(x1, ..., xn) -> <class>.<static-method>(x1, ..., xn)`
*  `<class>::<instance-method>`
    *  sta per `(x1, ..., xn) -> x1.<instance-method>(x2, ..., xn)`
*  `<obj>::<method>`
    *  sta per `(x1, ..., xn) -> <obj>.<method>(x1, ..., xn)`
*  `<class>::new`
    *  sta per `(x1, ..., xn) -> new <class>(x1, ..., xn)`

### Ossia:
*  Descrivibile come metodo (statico o non), o costruttore..
*  Usabile "naturalmente" (e opzionalmente) quando la lambda non fa altro che chiamare un metodo usando "banalmente" i suoi input e restituendo il suo "output"

---

## `Esempi di Method Reference (casi 1,2,3)`

```java
{{% import-raw path="pss-code/src/main/java/it/unibo/lambdas/first/AllLambdas2.java" %}}
```

---

## Dove si può usare una lambda?
 
### Definizione di **interfaccia "funzionale"**

* È una `interface` con un **singolo metodo astratto**
    * Non c'è ambiguità circa quale metodo implementare

### Quale tipo è compatibile con una lambda?
*  Una lambda può essere passata *dove ci si attende un oggetto che implementi una interfaccia funzionale*
    *  C'è compatibilità se i tipi in input/output della lambda (inferiti o non) sono compatibili con quelli dell'unico metodo dell'interfaccia

### Motivazione:
*  Di fatto, *il compilatore traduce la lambda nella creazione di un oggetto di una classe anonima che implementa l'interfaccia funzionale*
    *  Uno specifico opcode a livello di bytecode evita di costruirsi effettivamente un `.class` per ogni lambda

---

## Generazione automatica della classe anonima

```java
{{% import-raw path="pss-code/src/main/java/it/unibo/lambdas/first/FirstComparable2.java" %}}
```

---

## Esempio: funzione riusabile di filtraggio
    
```java
{{% import-raw path="pss-code/src/main/java/it/unibo/lambdas/first/Filter.java" %}}
```

```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/FilterUtility.java" %}}
```

---

## Metodi `default` nelle interfacce

### È possibile fornire implementazioni *di default* ai metodi delle `interface`
* sintassi: `interface I { ... default int m(){ ... } }`
* significato: non è necessario implementarli nelle sottoclassi

### Utilità
* consente di aggiungere metodi a interfacce senza rompere la compatibilità con classi esistenti che le implementano
* fornire comportamento ereditabile in modalità multipla
* *costruire più facilmente interfacce funzionali*: *__queste devono in effetti avere un unico metodo senza default__*
* consente di realizzare il pattern template method solo con interfacce

### Esempi di interfacce con metodi di default nella Java API:
* `Iterable`, `Iterator`, `Collection`, `Comparator`

###  Annotazione `@FunctionalInterface`
* da usare per interfacce funzionali, affinché il compilatore controlli che l'interfaccia sia funzionale
    * ossia che vi sia un solo metodo "astratto"

---

## Interfacce funzionali di libreria -- package `java.util.function`

### Perché scriversi una nuova interfaccia funzionale all'occorrenza?
*  Lo si fa solo per rappresentare concetti specifici del dominio
*  Lo si fa se ha metodi default aggiuntivi

### In `java.util.function` vengono fornite varie interfacce "general purpose"
*  Sono tutte funzionali
*  Hanno metodi aggiuntivi default di cui non ci occupiamo
*  Hanno un metodo "astratto" chiamato, a seconda: `apply`, `accept`, `test` o `get`

---

## Package `java.util.function`, funzioni che lavorano su oggetti generici

| Interface                 | Method signature                                  | Lambda type                  |
| ------------------------- | ------------------------------------------------- | ---------------------------- |
| `Consumer<T>`             | `void accept(T t)`                                | `(T) -> void`                |
| `BiConsumer<T,U>`         | `void accept(T t, U u)`                           | `(T, U) -> void`             |
| `Function<T,R>`           | `R apply(T t)`                                    | `(T) -> R`                   |
| `BiFunction<T,U,R>`       | `R apply(T t, U u)`                               | `(T, U) -> R`                |
| `UnaryOperator<T>`        | `T apply(T t)`                                    | `(T) -> T`                   |
| `BinaryOperator<T>`       | `T apply(T t1, T t2)`                             | `(T, T) -> T`                |
| `Predicate<T>`            | `boolean test(T t)`                               | `(T) -> boolean`             |
| `BiPredicate<T,U>`        | `boolean test(T t, U u)`                          | `(T, U) -> boolean`          |
| `Supplier<T>`             | `T get()`                                         | `() -> T`                    |
| `java.lang.Runnable`      | `void run()`                                      | `() -> void`                 |

---

## Package `java.util.function`, funzioni che lavorano su `int`

| Interface              | Method signature                      | Lambda type         |
| ---------------------- | ------------------------------------- | ------------------- |
| `IntConsumer`          | `void accept(int value)`              | `(int) -> void`     |
| `IntFunction<R>`       | `R apply(int value)`                  | `(int) -> R`        |
| `ToIntFunction<T>`     | `int applyAsInt(T value)`             | `(T) -> int`        |
| `ToIntBiFunction<T,U>` | `int applyAsInt(T t, U u)`            | `(T, U) -> int`     |
| `IntSupplier`          | `int getAsInt()`                      | `() -> int`         |
| `IntUnaryOperator`     | `int applyAsInt(int operand)`         | `(int) -> int`      |
| `IntBinaryOperator`    | `int applyAsInt(int left, int right)` | `(int, int) -> int` |
| `IntPredicate`         | `boolean test(int value)`             | `(int) -> boolean`  |
| `IntToLongFunction`    | `long applyAsLong(int value)`         | `(int) -> long`     |
| `IntToDoubleFunction`  | `double applyAsDouble(int value)`     | `(int) -> double`   |

---

## Package `java.util.function`, funzioni che lavorano su `long`

| Interface               | Method signature                          | Lambda type            |
| ----------------------- | ----------------------------------------- | ---------------------- |
| `LongConsumer`          | `void accept(long value)`                 | `(long) -> void`       |
| `LongFunction<R>`       | `R apply(long value)`                     | `(long) -> R`          |
| `ToLongFunction<T>`     | `long applyAsLong(T value)`               | `(T) -> long`          |
| `ToLongBiFunction<T,U>` | `long applyAsLong(T t, U u)`              | `(T, U) -> long`       |
| `LongSupplier`          | `long getAsLong()`                        | `() -> long`           |
| `LongUnaryOperator`     | `long applyAsLong(long operand)`          | `(long) -> long`       |
| `LongBinaryOperator`    | `long applyAsLong(long left, long right)` | `(long, long) -> long` |
| `LongPredicate`         | `boolean test(long value)`                | `(long) -> boolean`    |
| `LongToIntFunction`     | `int applyAsInt(long value)`              | `(long) -> int`        |
| `LongToDoubleFunction`  | `double applyAsDouble(long value)`        | `(long) -> double`     |

---

## Package `java.util.function`, funzioni che lavorano su `double`

| Interface                 | Method signature                                  | Lambda type                  |
| ------------------------- | ------------------------------------------------- | ---------------------------- |
| `DoubleConsumer`          | `void accept(double value)`                       | `(double) -> void`           |
| `DoubleFunction<R>`       | `R apply(double value)`                           | `(double) -> R`              |
| `ToDoubleFunction<T>`     | `double applyAsDouble(T value)`                   | `(T) -> double`              |
| `ToDoubleBiFunction<T,U>` | `double applyAsDouble(T t, U u)`                  | `(T, U) -> double`           |
| `DoubleSupplier`          | `double getAsDouble()`                            | `() -> double`               |
| `DoubleUnaryOperator`     | `double applyAsDouble(double operand)`            | `(double) -> double`         |
| `DoubleBinaryOperator`    | `double applyAsDouble(double left, double right)` | `(double, double) -> double` |
| `DoublePredicate`         | `boolean test(double value)`                      | `(double) -> boolean`        |
| `DoubleToIntFunction`     | `int applyAsInt(double value)`                    | `(double) -> int`            |
| `DoubleToLongFunction`    | `long applyAsLong(double value)`                  | `(double) -> long`           |

---

## Esempio: funzione riusabile di filtraggio via `Predicate`

```java
{{% import-raw path="pss-code/src/main/java/it/unibo/lambdas/first/FilterUtility2.java" %}}
```

---

## Esempio: comandi "programmati" via `Runnable`

```java
{{% import-raw path="pss-code/src/main/java/it/unibo/lambdas/first/RunnableUtility.java" %}}
```

---

## Funzioni di ordine superiore

- Le **funzioni di ordine superiore** sono funzioni che accettano in ingresso funzioni e/o che restituiscono in output funzioni

```java
final Function<Integer, Function<Integer, Integer>> multiplier = x -> (y -> x * y);
final Function<Integer, Integer> doubler = multiplier.apply(2);
assertEquals(10, doubler.apply(5));

final BiFunction<Predicate<String>, Predicate<String>, Predicate<String>> and = 
  (p1, p2) -> (s -> p1.test(s) && p2.test(s));
Predicate<String> p = and.apply(s -> s.length() < 5, s -> s.toUpperCase().equals(s));
assertFalse(p.test("abc"));
assertFalse(p.test("ABCDEFG"));
assertTrue(p.test("ABC"));
```

---

## Chiusure lessicali

- Una *chiusura (lessicale)* o (in inglese) **closure** è una funzione che accede a simboli visibili nello scope
    - Limitazione: le variabili nello scope referenziate in una lambda devono essere `final`

```java
final int k = 10;
Predicate<String> p = (s) -> s.length() > k;
p.test("hello"); // false
p.test("hello world"); // true
```

---

## Motivazioni e vantaggi nell'uso delle lambda in Java

### Elementi di **programmazione funzionale** in Java
*  Le lambda consentono di aggiungere certe funzionalità della programmazione funzionale in Java, creando quindi una contaminazione OOP + FP
*  Il principale uso è quello che concerne la *creazione di funzionalità (metodi) ad alto riuso* -- ad esempio `filterAll`
*  Tali metodi possono prendere in ingresso funzioni, passate con sintassi semplificata rispetto a quella delle classi anonime, rendendo più "naturale" e agevole l'uso di questo meccanismo

### Miglioramento alle API di Java
*  Concetto di `Stream<T>` e sue manipolazioni, per lavorare su dati sequenziali (collezioni, file, ...)
*  Supporto più diretto ad alcuni pattern: Command, Strategy, Observer
*  Alcune migliorie "varie" nelle API

---

## Interfaccia `java.util.Map` -- metodi aggiuntivi

```java
{{% import-raw from=1 to=100 path="code/streams/Map.java" %}}
```

---

## Esempi su `Map`

```java
{{% import-raw path="pss-code/src/main/java/it/unibo/lambdas/first/UseMap.java" %}}
```

---

## Il concetto di `Stream`

### Idee



* Uno `Stream` rappresenta un *flusso sequenziale (anche infinito)* di *dati omogenei*, 
*usabile una volta sola*
* Assomiglia al concetto di `Iterator`, ma lo Stream è più dichiarativo,
perché non indica passo-passo come l'informazione viene processata, e quindi è concettualmente più astratto
* Ove possibile, uno `Stream` manipola i suoi elementi in modo "lazy" (ritardato):
i dati vengono processati mano a mano che servono,
non sono memorizzati tutti assieme come nelle Collection
* È possibile creare *pipeline* (catene) di trasformazioni di Stream (implementate con decorazioni successive) in modo funzionale, 
per ottenere flessibilmente computazioni non banali dei loro elementi, con codice più compatto e leggibile
* Questa modalità di lavoro rende alcune computazioni (automaticamente) parallelizzabili

---

## Computazioni con gli Stream

### Struttura a pipeline

* Una sorgente o sink:
    * Una Collection/array, un dispositivo di I/O, una funzione generatrice
* Una sequenza di trasformazioni:
    * trasformare (mappare), filtrare, raggruppare, ma non solo
* Un terminatore, che aggrega i dati dello Stream:
    * una riduzione a un valore, una Collection/array, un Iteratore

### Esempio: con persone con nome, città e reddito
* Data una `List<Persona>` con proprietà reddito e città, ottenere la somma dei redditi di tutte le persone di Cesena
* Come lo realizziamo tramite una pipeline?
    * Sorgente: la lista
    * Trasformazione 1: filtro sulle persone di Cesena
    * Trasformazione 2: si mappa ogni persona sul suo reddito
    * Terminazione: sommo
* Aspetto cruciale: le fasi intermedie (dopo le trasformazioni), non generano collezioni temporanee

---

## Classe `Person` -- `equals`, `hashCode` e `toString` omessi

```java
{{% import-raw from=7 path="pss-code/src/main/java/it/unibo/streams/Person.java" %}}
```

---

## Realizzazione dell'esempio con gli Stream

```java
{{% import-raw from=5 path="pss-code/src/main/java/it/unibo/streams/UseStreamsOnPerson.java" %}}
```

---

Questa è solo una introduzione alle lambda in Java. 
Nel blocco di [approfondimento](/stream) si trovano ulteriori informazioni su come:
- creare stream
- manipolazioni di stream (avanzate)
- esempi di uso di stream

---

# Lambda e funzioni first-class

{{% import path="cover.md" %}}