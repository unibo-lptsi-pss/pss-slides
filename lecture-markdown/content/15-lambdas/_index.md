
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/lambdas/"]

+++

# Lambda e funzioni first-class

<!-- {{% import path="front-page.md" %}} -->

{{% import path="cover.md" %}}

---



## Outline


  
### Goal della lezione



  *  Illustrare il concetto di lambda
  *  Dettagliare il supporto alle lambda in Java 8
  


  
### Argomenti



    *  Lambda expressions
    *  Functional interfaces
    *  Altri usi nell'API
  




---


# Introduzione alle lambda

---



## Le novità di Java 8


  
### Una release molto attesa, che "rincorre" C\# e Scala



    *  Molte funzionalità rimandate da Java 7
    *  Java 8 disponibile dall'estate 2014
    *  Principale novità: lambda (ossia uno degli elementi fondamentali dello stile di programmazione funzionale)
    *  Le lambda portano ad uno stile più elegante e astratto di programmazione
    *  In Java, portano a codice più compatto e chiaro in certe situazioni
    *  Impatta alcuni aspetti di linguaggio
    *  Impatta varie librerie
  


  
### Risorse



    *  Libri: R.Warburton, Java 8 Lambdas
    *  Tutorial in rete: {\footnotesize `http://www.techempower.com/blog/2013/03/26/everything-about-java-8/`}
    *  Specification: {\footnotesize `dlsmith/jsr335-0.6.1/`}
  




---


## Preview 1: strategie funzionali


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/FirstComparable.java" %}}
```



---


## Handler eventi senza lambda


  
```java
{{% import-raw from=8 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/UseButtonEvents.java" %}}
```
    


---


## Preview 2: handler eventi con le lambda


  
```java
{{% import-raw from=7 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/UseButtonEventsWithLambda.java" %}}
```
    


---



## Preview 3: iterazioni "dichiarative" con gli *__stream__*


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/FirstStream.java" %}}
```
      


---


# Lambda expressions

---



## Elementi delle lambda expression


  
### Che cos'è una lambda



    *  è una funzione (anonima) con accesso ad uno scope locale
    *  è applicabile a certi input, e dà un risultato (oppure `void`)
    *  per calcolare il risultato potrebbe usare qualche variabile nello scope in cui è definita
    *  la lambda è usabile come "valore" (quindi, come dato), ossia è passabile a metodi, altre funzioni, o memorizzata in variabili/campi
    *  ossia si può "passare" del "codice"
  


  
### Caratteristica specifica di Java



    *  come vedremo, una lambda è un oggetto, e il suo tipo è sempre quello di una `interface` detta "funzionale"
    *  metodi statici o istanza possono essere usati a mo' di lambda (chiamati "method reference", perché sono interpretabili come funzioni (come i `delegate` di `C\#`)
  


  


---


## Come si esprime una lambda


  
### Sintassi possibili



    *  `{<body>\}`
    *  `{<body>\}`
    *  `{<body>\}`
    *  `(T1 x1,..,Tn xn) -> <exp>`
    *  `(x1,..,xn) -> <exp>`
    *  `x -> <exp>`
    *  .. oppure un "method reference"
  


  
### Ossia:



    *  Per gli argomenti si può esprimere un tipo o può essere inferito
    *  Con un argomento, le parentesi tonde sono omettibili
    *  Il body può essere direttamente una singola espressione/istruzione
  

  


---



## `Esempi di Lambda`


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/AllLambdas.java" %}}
```
      


---


## Come si esprime una lambda: method references


  
### Sintassi possibili



    *  `<class>::<static-method>`{
 *  sta per `(x1,..,xn)-> <class>.<static-method>(x1,..,xn)`
}
    *  `<class>::<instance-method>`{
 *  sta per `(x1,x2,..,xn)-> x1.<instance-method>(x2,..,xn)`
}
    *  `<obj>::<method>`{
 *  sta per `(x1,..,xn)-> <obj>.<method>(x1,..,xn)`
}
    *  `<class>::new`{
 *  sta per `(x1,..,xn)-> new <class>(x1,..,xn)`
}
  


  
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


  
### Definizione di interfaccia "funzionale" (def. non definitiva)



   *  E' una `interface` con un singolo metodo
  


  
### Quale tipo è compatibile con una lambda?



    *  Una lambda può essere passata dove ci si attende un oggetto che implementi una interfaccia funzionale
    *  C'è compatibilità se i tipi in input/output della lambda (inferiti o non) sono compatibili con quelli dell'unico metodo dell'interfaccia
  


  
### Motivazione:



    *  Di fatto, il compilatore traduce la lambda nella creazione di un oggetto di una classe anonima che implementa l'interfaccia funzionale
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


## Lambda che accedono al loro scope


    
```java
{{% import-raw from=8 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/ChangeButton.java" %}}
```



---



## Metodi `default` nelle interfacce


  
### Da Java 8 è possibile fornire implementazioni ai metodi delle `interface`



    *  sintassi: `{ ... default int m()\{...\}\}`
    *  significato: non è necessario implementarli nelle sottoclassi
    *  .. è possibile avere anche metodi statici
  


  
### Utilità



    *  consente di aggiungere metodi a interfacce senza rompere la compatibilità con classi esistenti che le implementano
    *  fornire "behaviour" ereditabile in modalità multipla
    *  costruire più facilmente interfacce funzionali: *__queste devono in effetti avere un unico metodo senza default__*
    *  consente di realizzare il patter template method solo con interfacce
  


  
### Esempi di interfacce con metodi di default



    *  `Iterable`, `Iterator`, `Collection`, `Comparator`
  




---



## Esempio `SimpleIterator`


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/interfaces/SimpleIterator.java" %}}
```

    
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/lambdas/interfaces/UseSimpleIterator.java" %}}
```



---


## Annotazione `@FunctionalInterface`


  
### Uso



    *  da usare opzionalmente per interfacce funzionali
    *  il compilatore la usa per assicurarsi che l'interfaccia sia funzionale, ossia che vi sia un solo metodo "astratto"
    *  nella Java API viene usata spesso
  


  
### Nota



    *  le annotazioni sono usate per vari scopi, ad esempio per indicare al compilatore di fare ulteriori controlli   




---


## Esempio `SimpleIterator`


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/interfaces/SimpleIterator2.java" %}}
```



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
      *  Hanno un metodo "astratto" chiamato, a seconda: <br> `apply`, `accept`, `test` o `get`
    

    


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


## Motivazioni e vantaggi nell'uso delle lambda in Java


  
### Elementi di programmazione funzionale in Java



    *  Le lambda consentono di aggiungere certe funzionalità della programmazione funzionale in Java, creando quindi una contaminazione OO + funzionale
    *  Il principale uso è quello che concerne la creazione di funzionalità (metodi) ad alto riuso -- ad esempio `filterAll`
    *  Tali metodi possono prendere in ingresso funzioni, passate con sintassi semplificata rispetto a quella delle classi anonime, rendendo più "naturale" e agevole l'uso di questo meccanismo
  


  
### Miglioramento alle API di Java



    *  Concetto di Stream e sue manipolazioni, per lavorare su dati sequenziali (collezioni, file,..)
    *  Facilitare la costruzioni di software "parallelo" (multicore)
    *  Supporto più diretto ad alcuni pattern: Command, Strategy, Observer
    *  Alcune migliorie "varie" nelle API
  


  


---


## Goal delle lambda, in una frase


  
\huge Realizzare "più algoritmi possibili su sequenze" in una sola istruzione



---



## "Nuove" interfacce `Iterator` e `Iterable`


    
```java
{{% import-raw from=1 to=100 path="code/streams/Iterable.java" %}}
```

    
```java
{{% import-raw from=1 to=100 path="code/streams/Iterator.java" %}}
```



---


## Uso delle "nuove" interfacce `Iterator` e `Iterable`


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/UseIterators.java" %}}
```



---


## Interfaccia `java.util.Map` -- metodi aggiuntivi


    
```java
{{% import-raw from=1 to=100 path="code/streams/Map.java" %}}
```



---


## Uso delle "nuova" interfacce `Map`


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/first/UseMap.java" %}}
```



---



## La classe `Optional`


    
### Il problema del `NullPointerException`



      *  è una eccezione particolarmente annosa (è ora la più frequente)
      *  a volte è inevitable inizializzare a `null` campi/variabili, o tornare valori null.. ma poi si rischia di ritrovarsi l'eccezione in punti non aspettati
      *  gestire l'assenza di una informazione con `null` è inappropriato!
    


    
### Idea



      *  la classe `Optional<T>` và usata ove ci si attende opzionalmente un oggetto di tipo `T`
      *  un oggetto di `Optional<T>` è un wrapper di un `T`, ma potrebbe non contenere nulla, ossia è una collezione di 0 o 1 elemento di tipo `T` 
      *  accedendovi con metodi quali `ifPresent()` o `orElse()` si bypassa il problema del `null`
      *  c'è comunque un metodo `get()` che rilancia l'eccezione uncheked `NoSuchElementException`
      *  purtroppo `Optional<T>` NON è serializzabile!
    


    


---


## Classe `java.util.Optional`


    
```java
{{% import-raw from=1 to=100 path="code/streams/Optional.java" %}}
```



---


## `UseOptional`


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/optional/UseOptional.java" %}}
```



---


## `UseOptional2`


    
```java
{{% import-raw from=7 to=100 path="pss-code/src/main/java/it/unibo/lambdas/optional/UseOptional2.java" %}}
```



---


## `UseOptional3`


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/optional/UseOptional3.java" %}}
```



---


## `Optional` per campi opzionali, e manipolazioni con `map`


    
### Come evitare il `NullPointerException` in una applicazione?



      *  Non si menzioni mai il `null` nell'applicazione
      *  Non si lascino variabili o campi non inizializzati
      *  Si usi `Optional` per campi con contenuto opzionale, inizializzati a `Optional.empty`
      *  I valori di `Optional` vengano manipolati in modo "dichiarativo" con i suoi metodi, ad esempio, `map`
      * $\Rightarrow$ Il codice risultante sarà molto più espressivo
     


     
### Inconveniente:



      *  e se non si può controllare che il caller di una classe non passi dei `null`?
      *  si intercettino gli eventuali `null` in ingresso ad ogni metodo, ponendovi un rimedio che non sia il lancio di una eccezione unchecked
      *  si usi `Objects.requireNonNull()`
     




---




## `Person`


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/lambdas/optional/Person.java" %}}
```



---


## `UsePerson`


    
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/lambdas/optional/UsePerson.java" %}}
```



---
