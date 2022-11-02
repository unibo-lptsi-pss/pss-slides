
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/generics/"]

+++

# Generici

<!-- {{% import path="front-page.md" %}} -->

{{% import path="cover.md" %}}

---



## Outline


  
### Goal della lezione



  *  Illustrare il problema delle collezioni polimorfiche
  *  Discutere il concetto di polimorfismo parametrico
  *  Illustrare i Generici di Java e alcuni loro vari dettagli
  


  
### Argomenti



  *  Collezioni con polimorfismo inclusivo
  *  Classi generiche
  *  Interfacce generiche
  *  Metodi generici
  




---

\section[Collezioni e polimorfismo]{Collections con polimorfismo inclusivo}


## Forme di riuso nella programmazione OO


  
### Composizione (e come caso particolare, delegazione)


    Un oggetto è ottenuto per composizione di oggetti di altre classi
  

  
### Estensione


    Una nuova classe è ottenuta riusando il codice di una classe pre-esistente
  

  
### Polimorfismo inclusivo (subtyping)


    Una funzionalità realizzata per lavorare su valori/oggetti del tipo `A`, può lavorare con qualunque valore/oggetto del sottotipo `B` (p.e., se `B` estende la classe `A`, o se `B` implementa l'interfaccia `A`)
  

  
### Polimorfismo parametrico (Java/C\# generics, C++ templates,..)


    Una funzionalità (classe o metodo) generica è costruita in modo tale da lavorare uniformemente su valori/oggetti indipendentemente dal loro tipo: tale tipo diventa quindi una sorta di parametro addizionale
  



---


## Astrazioni uniformi con le classi


  
### Astrazioni uniformi per problemi ricorrenti



    *  Durante lo sviluppo di vari sistemi si incontrano problemi ricorrenti che possono trovare una soluzione comune
    *  In alcuni casi queste soluzioni sono fattorizzabili (per astrazione) in una singola classe altamente riusabile
  


  
### Un caso fondamentale: le *__collection__*



    *  Una collection è un oggetto il cui compito è quello di immagazzinare il riferimento ad un numero (tipicamente non precisato) di altri oggetti 
    *  Fra i suoi compiti c'è quello di consentire modifiche ed accessi veloci all'insieme di elementi di tale collezioni
    *  Varie strategie possono essere utilizzate, seguendo la teoria/pratica degli algoritmi e delle strutture dati
  




---


## Un esempio: `IntVector`


  
### Collection `IntVector`



    *  Contiene serie numeriche (vettori) di dimensione non nota a priori
    *  Ossia, a lunghezza variabile..
  


  ![](img/uml-int-vector-abstracted.pdf)


---


## `UseIntVector`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/abstractions/UseIntVector.java" %}}
```



---


## `IntVector` -- implementazione


  
### Collection `IntVector`



    *  Contiene serie numeriche (vettori) di dimensione non nota a priori
    *  Realizzata componendo un array che viene espanso all'occorrenza
  


  ![](img/uml-int-vector.pdf)


---



## `IntVector` pt 1


  
```java
{{% import-raw from=3 to=25 path="pss-code/src/main/java/it/unibo/generics/abstractions/IntVector.java" %}}
```



---


## `IntVector` pt 2


  
```java
{{% import-raw from=26 to=50 path="pss-code/src/main/java/it/unibo/generics/abstractions/IntVector.java" %}}
```



---


## Un primo passo verso l'uniformità


  
### Solo elenchi di `int`?



    *  L'esperienza porterebbe subito alla necessità di progettare vettori di `float`, `double`, `boolean`,.. ossia di ogni tipo primitivo
    *  E poi, anche vettori di `String`, `Date`, eccetera
    *  L'implementazione sarebbe analoga, ma senza possibilità di riuso..
  


  
### Collection uniformi "monomorfiche"



    *  Una prima soluzione del problema la si ottiene sfruttando il polimorfismo inclusivo e la filosofia "everything is an object" (incluso l'uso dell'autoboxing dei tipi primitivi)
    *  Si realizza unicamente un `ObjectVector`, semplicemente sostituendo `int` con `Object`
    *  Si inserisce qualunque elemento (via upcast implicito)
    *  Quando si riottiene un valore serve un downcast esplicito
  




---


## Da `IntVector` a `ObjectVector`


  ![](img/uml-obj-vector.pdf)


---


## `UseObjectVector`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/abstractions/UseObjectVector.java" %}}
```



---


## Un altro caso di collection, la list linkata `ObjectList`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/abstractions/ObjectList.java" %}}
```



---


## `UseObjectList`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/abstractions/UseObjectList.java" %}}
```



---



## La necessità di un approccio a polimorfismo parametrico


  
### Prima di Java 5



    *  Questo era l'approccio standard alla costruzione di collection
    *  Java Collection Framework --- una libreria fondamentale
  


  
### Problema



    *  Con questo approccio, nel codice Java risultavano molti usi di oggetti simili a `ObjectVector` o `ObjectList`
    *  Si perdeva molto facilmente traccia di quale fosse il contenuto..{

      *  contenevano oggetti vari? solo degli `Integer`? solo delle `String`?
    
}
    *  Il codice conteneva spesso dei downcast sbagliati, e quindi molte applicazioni Java fallivano generando dei `ClassCastException`
  


  
### Più in generale


    Il problema si manifesta ogni volta che voglio collezionare oggetti il cui tipo non è noto a priori, ma potrebbe essere soggetto a polimorfismo inclusivo
  



---







## Polimorfismo parametrico


  
### Idea di base



    *  Dato un frammento di codice `F` che lavora su un certo tipo, diciamo `String`, se potrebbe anche lavorare in modo uniforme con altri..
    *  ..lo si rende parametrico, sostituendo a `String` una sorta di variabile `X` (chiamata *__type-variable__*, ossia una variabile che contiene un tipo)
    *  A questo punto, quando serve il frammento di codice istanziato sulle stringhe, si usa `F<String>`, ossia si richiede che `X` diventi `String`
    *  Quando serve il frammento di codice istanziato sugli integer, si usa `F<Integer>`
  


  
### Java Generics



    *  Classi/interfacce/metodi generici
    *  Nessun impatto a run-time, per via dell'implementazione a "erasure"{

      *  `javac` "compila via i generici", quindi la JVM non li vede
    
}
  




---


# Classi generiche

---



## La classe generica `List`


  \sizedcode{\scriptsize}{code/List.java}


---


## Uso di una classe generica


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/generics/UseList.java" %}}
```



---


## Terminologia, e elementi essenziali


  
### Data una classe generica `C<X,Y>`..



    *  `X` e `Y` sono dette le sue *__type-variable__*
    *  `X` e `Y` possono essere usati come un qualunque tipo dentro la classe (con alcune limitazioni che vedremo)
  


  
### I clienti delle classi generiche



    *  Devono usare *__tipi generici__*: versioni "istanziate" delle classi generiche

      *  `C<String,Integer>`, `C<C<Object,Object>,Object>`
      *  Non `C` senza parametri, altrimenti vengono segnalati dei warning
    

    *  Ogni type-variable va sostituita con un tipo effettivo, ossia con un *__parametro__*, che può essere{

      *  una classe (non-generica), p.e. `Object`, `String`,..
      *  una type-variable definita, p.e. `X,Y` (usate dentro la classe `C<X,Y>`)
      *  un tipo generico completamente istanziato, p.e. `C<Object,Object>`
      *  ..o  parzialmente istanziato, p.e. `C<Object,X>` (in `C<X,Y>`)
      *  NON con un tipo primitivo
    
}
  




---



## La classe generica `Vector`


  \sizedcode{\footnotesize}{code/Vector.java}


---


## Uso di `Vector<X>`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/generics/UseVector.java" %}}
```



---


## Implementazione di `Vector` pt 1


  \sizedcode{\scriptsize}{code/VectorA.java}


---


## Implementazione di `Vector` pt 2


  \sizedcode{\scriptsize}{code/VectorB.java}


---




## La classe generica `Pair<X,Y>`


  \srcode{\scriptsize}{3}{100}{pss-code/src/main/java/it/unibo/generics/generics/Pair.java}


---


## Uso di `Pair<X,Y>`


  \srcode{\ssmall}{3}{100}{pss-code/src/main/java/it/unibo/generics/generics/UsePair.java}


---


## Inferenza dei parametri


  
### Un problema sintattico dei generici



    *  Tendono a rendere il codice più pesante ("verbose")
    *  Obbligano a scrivere i parametri anche dove ovvi, con ripetizioni
  


  
### L'algoritmo di type-inference nel compilatore



    *  Nella `new` si possono tentare di omettere i parametri (istanziazione delle type-variable), indicando il "diamond symbol" `<>`
    *  Il compilatore cerca di capire quali siano questi parametri guardando gli argomenti della `new` e l'eventuale contesto dentro il quale la `new` è posizionata, per esempio, se assegnata ad una variabile
    *  Nel raro caso in cui non ci riuscisse, segnalerebbe un errore a tempo di compilazione.. quindi tanto vale provare!
    *  Ricordarsi `<>`, altrimenti viene confuso con un *__raw type__*, un meccanismo usato per gestire il legacy con le versioni precedenti di Java
    


  
### La local variable type inference



    *  in genere è alternativa al simbolo `<>`
  


  


---


## Esempi di inferenza


  \srcode{\ssmall}{3}{100}{pss-code/src/main/java/it/unibo/generics/generics/UsePair2.java}


---


## I vantaggi dei generici


  
Coi generici, Java diventa un linguaggio molto più espressivo!

  
### Svantaggi



    *  Il linguaggio risulta più sofisticato, e quindi complesso
    *  Se non ben usati, possono minare la comprensibilità del software
    *  Non vanno abusati!!
    *  Gli aspetti più avanzati dei generici, che vedremo, sono considerati troppo complessi
  


  
### Vantaggi -- se ben usati



    *  Codice più comprensibile
    *  Maggiori possibilità di riuso di funzionalità (quasi d'obbligo oramai)
    *  Codice più sicuro (safe) -- il compilatore segnala errori difficili da trovare altrimenti
  




---


# Interfacce generiche

---



## Interfacce generiche


  
### Cosa è una interfaccia generica



    *  È una interfaccia che dichiara type-variables: `{..\}`
    *  Le type-variable compaiono nei metodi definiti dall'interfaccia
    *  Quando una classe la implementa deve istanziare le type variabile (o assegnarle ad altre type-variable se essa stessa è generica)
  


  
### Utilizzi


    Per creare contratti uniformi che non devono dipendere dai tipi utilizzati
  

  
### Un esempio notevole, gli *__Iteratori__*



    *  Un iteratore è un oggetto usato per accedere ad una sequenza di elementi
    *  Ne vedremo ora una versione semplificata -- diversa da quella delle librerie Java
  




---


## L'interfaccia `Iterator`


    \srcode{\normalsize}{3}{100}{pss-code/src/main/java/it/unibo/generics/iterators/Iterator.java}


---


## Implementazione 1: `IntRangeIterator`


  \srcode{\scriptsize}{3}{100}{pss-code/src/main/java/it/unibo/generics/iterators/IntRangeIterator.java}


---


## Implementazione 2: `ListIterator`


  \srcode{\scriptsize}{3}{100}{pss-code/src/main/java/it/unibo/generics/iterators/ListIterator.java}


---


## Implementazione 3: `VectorIterator`


  \srcode{\scriptsize}{3}{100}{pss-code/src/main/java/it/unibo/generics/iterators/VectorIterator.java}


---


## `UseIterators`: nota l'accesso uniforme!


  \srcode{\ssmall}{3}{100}{pss-code/src/main/java/it/unibo/generics/iterators/UseIterators.java}


---


# Metodi generici

---



## Metodi generici


  
### Metodo generico


    Un metodo che lavora su qualche argomento e/o valore di ritorno in modo independente dal suo tipo effettivo. Tale tipo viene quindi astratto in una type-variable del metodo.
  

  
### Sintassi



    *  def: `{...\}`
    *  call: `{...\}`
    *  call con inferenza, stessa sintassi delle call standard, ossia senza `<>`
  


  
### Due casi principali, con medesima gestione



    *  Metodo generico (statico o non-statico) in una classe non generica
    *  Metodo generico (non-statico) in una classe generica
    * $\Rightarrow$ Il primo dei due molto più comune..
  




---


## Definizione di un metodo generico


  \sizedcode{\scriptsize}{code/UseIterators2A.java}


---


## Chiamata a metodo generico


  \sizedcode{\scriptsize}{code/UseIterators2B.java}


---


## Esempio di metodo generico in classe generica


  \sizedcode{\ssmall}{code/UseGenMeth.java}


---


## Notazione UML: non del tutto standard


  ![](img/uml-generics.pdf)


---


# Java Wildcards

---



## Java Wildcards


  
### Osservazione



    *  Esistono situazioni in cui un metodo debba accettare come argomento non solo oggetti di un tipo `C<T>`, ma di ogni `C<S>` dove `S <: T`
    *  Esempio: un metodo statico `printAll()` che prende in ingresso un iteratore e ne stampa gli elementi
    *  È realizzabile con un metodo generico, ma ci sono casi in cui si vorrebbe esprimere un tipo che raccolga istanziazioni diverse di una classe generica
  


  
### Java Wildcards



    *  Un meccanismo avanzato, quello inventato più di recente (2004-2006){

      *  {\scriptsize (Igarashi \& Viroli) + (Bracha \& Gafter) + (Torgersen \& Hansen \& von der Ahé)}
    
}
    *  Fornisce dei nuovi tipi, chiamati Wildcards 
    *  Simili a interfacce (non generano oggetti, descrivono solo contratti)
    *  Generalmente usati come tipo dell'argomento di metodi
  




---



## Java Wildcards


  \sizedcode{\footnotesize}{code/Numbers.java}
  \sizedcode{\footnotesize}{code/Wildcards.java}


---


## Java Wildcards


  
### 3 tipi di wildcard



    *  Bounded (covariante): `C<? extends T>`{

      *  accetta un qualunque `C<S>` con `S <: T`
    
}
    *  Bounded (controvariante): `C<? super T>`{

      *  accetta un qualunque `C<S>` con `S >: T`
    
}
    *  Unbounded: `C<?>`{

      *  accetta un qualunque `C<S>`
    
}    
  


  
### Uso delle librerie che dichiarano tipi wildcard



    *  Piuttosto semplice, basta passare un argomento compatibile o si ha un errore a tempo di compilazione
  


  
### Progettazione di librerie che usano tipi wildcard



    *  Molto avanzato: le wildcard pongono limiti alle operazioni che uno può eseguire, derivanti dal principio di sostituibilità
  




---


## Esempio Wildcard


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/generics/wildcard/Wildcard.java" %}}
```



---


