
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/lambdas/"]

+++

# Lambda e funzioni first-class

{{% import path="cover.md" %}}



---



## Outline


  
### Goal della lezione



*  Illustrare il concetto di lambda
*  Dettagliare il supporto alle lambda in Java


  
### Argomenti



*  Espressioni lambda
*  Interfacce funzionali
*  Altri usi nell'API
*  Stream




---


# Introduzione alle lambda

---



## Le novità di Java 8


  
### Una release molto attesa, che "rincorre" C# e Scala



*  Molte funzionalità rimandate da Java 7
* *Java 8* disponibile dall'estate 2014
*  Principale novità: *lambda* (ossia uno degli elementi fondamentali dello stile di *programmazione funzionale*)
    *  Le lambda portano ad uno stile più elegante e astratto di programmazione
    *  In Java, portano a codice più compatto e chiaro in certe situazioni
    *  Impatta alcuni aspetti di linguaggio
    *  Impatta varie librerie
  


  
### Risorse



*  Libri: R.Warburton, Java 8 Lambdas
*  [Un tutorial in rete](http://www.techempower.com/blog/2013/03/26/everything-about-java-8/)
*  [Java Specification Request (JSR)-335: Lambda Expressions for the Java Programming Language](http://cr.openjdk.java.net/~dlsmith/jsr335/jsr335-final/)





---


## Da classi/metodi alle lambda: il caso dei comparatori

---

### Comparatori definiti attraverso classi

    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/intro/FirstComparableBasic.java" %}}
```

---

### Comparatori definiti attraverso classi innestate

- Una **classe innestata statica** `B` (*static nested*) è definita all'interno di un'altra classe `A`
    - Dunque ci si può riferire ad essa via `A.B` (secondo regole di visibilità), o direttamente via `B` da dentro la classe `A` -- [approfondimento](/advanced-mechanisms-nesting)
    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/intro/FirstComparableNested.java" %}}
```

---


### Comparatori definiti attraverso classi anonime

- Una **classe anonima** è una classe definita "al volo" (senza fornirne dunque un nome) e immediatamente istanziata per evitare la proliferazione di classi -- [approfondimento](/19-advanced-mechanisms-nesting/#/36)
    *  Tipicamente: per implementare "al volo" una interfaccia
    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/intro/FirstComparableWithAnonymousClasses.java" %}}
```

---


### Comparatori attraverso lambda

- Una **lambda** è una *funzione anonima*, creata "al volo"
    - internamente implementata come *istanza* di un'**interfaccia funzionale** (un'interfaccia che definisce un solo metodo astratto)
    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/intro/FirstComparableWithLambdas.java" %}}
```

---

# Lambda expressions

---



## Elementi delle lambda expression


  
### Che cos'è una lambda



*  è una *funzione (anonima)* con *accesso ad uno scope locale* (cf. *closure*)
*  è applicabile a certi input, e dà un risultato (oppure `void`)
    *  per calcolare il risultato potrebbe usare qualche variabile nello scope in cui è definita
*  la lambda è *usabile come "valore"* (quindi, come dato), ossia è passabile a metodi, altre funzioni, o memorizzata in variabili/campi
    *  ossia, consente di "passare" del "codice"
  


  
### Caratteristica specifica di Java



*  come vedremo, una lambda è un oggetto, e il suo tipo è sempre quello di una `interface` detta "funzionale"
*  metodi statici o istanza possono essere usati a mo' di lambda (chiamati "method reference", perché sono interpretabili come funzioni (come i `delegate` di C#)



  


---


## Come si esprime una lambda


  
### Sintassi possibili



*  `(T1 x1, ..., Tn xn) -> { <body> }`
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



## `Esempi di Lambda`


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/intro/FilteringWithLambdas.java" %}}
```
      


---


## Come si esprime una lambda: i **method reference**


  
### Sintassi possibili



*  `<class>::<static-method>`
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
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/AllLambdas2.java" %}}
```
      


---




## Dove si può usare una lambda?


  
### Definizione di **interfaccia "funzionale"**



*  E' una `interface` con un singolo metodo astratto
    * Ma potrebbero esserci più metodi di default (cf. keyword `default`)

  
### Quale tipo è compatibile con una lambda?



*  Una lambda può essere passata *dove ci si attende un oggetto che implementi una interfaccia funzionale*
    *  C'è compatibilità se i tipi in input/output della lambda (inferiti o non) sono compatibili con quelli dell'unico metodo dell'interfaccia


  
### Motivazione:



*  Di fatto, *il compilatore traduce la lambda nella creazione di un oggetto di una classe anonima che implementa l'interfaccia funzionale*
    *  Uno specifico opcode a livello di bytecode evita di costruirsi effettivamente un `.class` per ogni lambda


  


---


## Generazione automatica della classe anonima


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/FirstComparable2.java" %}}
```



---


## Esempio: funzione riusabile di filtraggio


    
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/Filter.java" %}}
```

    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/FilterUtility.java" %}}
```



---



## Metodi `default` nelle interfacce


  
### Da Java 8 è possibile fornire implementazioni ai metodi delle `interface`



*  sintassi: `interface I { ... default int m(){ ... } }`
*  significato: non è necessario implementarli nelle sottoclassi

<!-- *  .. è possibile avere anche metodi statici -->



  
### Utilità



*  consente di aggiungere metodi a interfacce senza rompere la compatibilità con classi esistenti che le implementano
*  fornire "behaviour" ereditabile in modalità multipla
*  *costruire più facilmente interfacce funzionali*: *__queste devono in effetti avere un unico metodo senza default__*
*  consente di realizzare il pattern template method solo con interfacce



  
### Esempi di interfacce con metodi di default



*  `Iterable`, `Iterator`, `Collection`, `Comparator`

---

##  Annotazione `@FunctionalInterface`

*  da usare opzionalmente per interfacce funzionali, affinché il compilatore controlli che l'interfaccia sia funzionale (ossia che vi sia un solo metodo "astratto")
*  nella Java API viene usata spesso


<!--
  
### Nota

*  le annotazioni sono usate per vari scopi, ad esempio per indicare al compilatore di fare ulteriori controlli   

-->



---


# Lambda expressions nell'API di Java

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


## Package `java.util.function`


    
### Interfacce base



*  `Consumer<T>`: `accept:(T)->void`
*  `Function<T,R>`: `apply:(T)->R`
*  `Predicate<T>`: `test:(T)->boolean`	
*  `Supplier<T>`: `get:()->T`
*  `UnaryOperator<T>`: `apply:(T)->T`
    *  `BiConsumer<T,U>`: `accept:(T,U)->void`
*  `BiFunction<T,U,R>`:	`apply:(T,U)->R`
*  `BinaryOperator<T>`: 	`apply:(T,T)->T`
*  `BiPredicate<T,U>`: `test:(T,U)->boolean`
*  `java.lang.Runnable`: `run:()->void`
    

    
  
### Altre interfacce (usano i tipi primitivi senza boxing)



*  `BooleanSupplier`: `get:()->boolean`
*  `IntConsumer`: `accept:(int)->void`
*  ...


    


---


## Esempio: funzione riusabile di filtraggio via `Predicate`


    
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/FilterUtility2.java" %}}
```



---


## Esempio: comandi "programmati" via `Runnable`


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/RunnableUtility.java" %}}
```

---

## Esempio: funzioni di ordine superiore

- Le **funzioni di ordine superiore** sono funzioni che accettano in ingresso funzioni e/o che restituiscono in output funzioni

```java
import java.util.function.*;

Function<Integer, Function<Integer, Integer>> multiplier = x -> (y -> x * y);
Function<Integer, Integer> doubler = multiplier.apply(2);
assertEquals(10, doubler.apply(5));

BiFunction<Predicate<String>, Predicate<String>, Predicate<String>> and = 
  (p1, p2) -> (s -> p1.test(s) && p2.test(s));
Predicate<String> p = and.apply(s -> s.length() < 5, s -> s.toUpperCase().equals(s));
assertFalse(p.test("abc"));
assertFalse(p.test("ABCDEFG"));
assertTrue(p.test("ABC"));
```

<!--

---

## Esempio: chiusure lessicali

- Una *chiusura (lessicale)* o (in inglese) **closure** è una funzione che accede a simboli visibili nello scope
    - Limitazione: le variabili nello scope referenziate in una lambda devono essere `final`

```java
import java.util.function.*;

final int K = 10;
Predicate<String> p = (s) -> s.length() > K;
p.test("hello"); // false
p.test("hello world"); // true
```

-->

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

<!-- *  Facilitare la costruzioni di software "parallelo" (multicore) 

  


---


## Goal delle lambda, in una frase


  
**Realizzare "più algoritmi possibili su sequenze" in una sola istruzione**

-->


---


## Interfaccia `java.util.Map` -- metodi aggiuntivi


    
```java
{{% import-raw from=1 to=100 path="code/streams/Map.java" %}}
```



---


## Esempi su `Map`


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/UseMap.java" %}}
```

---


## Il concetto di Stream


  
### Idee



*  Uno Stream rappresenta un flusso sequenziale (anche infinito) di dati omogenei, usabile una volta sola, e dal quale si vuole ottenere una informazione complessiva e/o aggregata
*  Assomiglia al concetto di Iteratore, ma lo Stream è più dichiarativo, perché non indica passo-passo come l'informazione viene processata, e quindi è concettualmente più astratto
*  Ove possibile, uno Stream manipola i suoi elementi in modo "lazy" (ritardato): i dati vengono processati mano a mano che servono, non sono memorizzati tutti assieme come nelle Collection
*  E' possibile creare "catene" di trasformazioni di Stream (implementate con decorazioni successive) in modo funzionale, per ottenere flessibilmente computazioni non banali dei loro elementi, con codice più compatto e leggibile
*  Questa modalità di lavoro rende le computazioni (automaticamente) parallelizzabili, ossia computabili da un set arbitrario di Thread
  




---


## Computazioni con gli Stream


  
### Struttura a pipeline



*  Una sorgente o sink:
    *  Una Collection/array, un dispositivo di I/O, una funzione generatrice
*  Una sequenza di trasformazioni:
    *  mappe e filtri, ma non solo..
*  Un terminatore, che aggrega i dati dello Stream:
    *  una riduzione ad un valore, una Collection/array, un Iteratore
  

  
### Esempio: con persone con nome, città e reddito



*  Data una `List<Persona>` con proprietà reddito e città, ottenere la somma dei redditi di tutte le persone di Cesena
*  Come lo realizziamo tramite una pipeline?
    *  Sorgente: la lista
    *  Trasformazione 1: filtro sulle persone di Cesena
    *  Trasformazione 2: si mappa ogni persona sul suo reddito
    *  Terminazione: sommo
*  Aspetto cruciale: le fasi intermedie (dopo le trasformazioni), non generano collezioni temporanee



---


## Classe `Person` -- `equals`, `hashCode` e `toString` omessi


    
```java
{{% import-raw from=5 to=34 path="pss-code/src/main/java/it/unibo/streams/Person.java" %}}
```



---



## Realizzazione dell'esempio in Java 8


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/streams/UseStreamsOnPerson.java" %}}
```



---

Questa è solo una introduzione alle lambda in Java. 
Nel blocco di [approfondimento](/stream) si trovano ulteriori informazioni su come:
- creare stream
- manipolazioni di stream (avanzate)
- esempi di uso di stream