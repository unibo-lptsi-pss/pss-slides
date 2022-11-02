
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/collections/"]

+++

# Collezioni

<!-- {{% import path="front-page.md" %}} -->

{{% import path="cover.md" %}}

---







## Outline


  
### Goal della lezione



  *  Illustrare la struttura del Java Collections Framework
  *  Mostrare gli utilizzi delle funzonalità base
  *  Discutere alcune tecniche di programmazione correlate
  


  
### Argomenti



  *  Presentazione Java Collections Framework
  *  Iteratori e foreach
  *  Collezioni, Liste e Set
  *  `HashSet` e `TreeSet`
  %*  `ArrayList` e `LinkedList`
  %*  Funzioni di utilità in `Arrays` e `Collections`
  




---

\section[JCF]{Java Collections Framework}


## Java Collections Framework


  
### Java Collections Framework (JCF)



*  È una libreria del linguaggio Java
*  È una parte del package `java.util`
*  Gestisce strutture dati (o collezioni) e relativi algoritmi
  


  
### Importanza pratica



*  Virtualmente ogni sistema fa uso di collezioni di oggetti
*  Conoscerne struttura e dettagli vi farà programmatori migliori
  


  
### Importanza didattica



*  Fornisce ottimi esempi di uso di composizione, ereditarietà, genericità
*  Mette in pratica pattern di programmazione di interesse
*  Impatta su alcuni aspetti del linguaggio da approfondire
  




---


## JCF -- struttura complessiva


  ![](img/tax1.png)


---


## JCF -- struttura riorganizzata


  ![](img/tax.png)


---



## JCF -- alcuni aspetti generali


  
### È complessivamente piuttosto articolato



*  Un nostro obbiettivo è quello di isolare una sua sottoparte di interesse
*  Identificando e motivando le funzionalità prodotte
  


  
### Due tipi di collection, ognuna con varie incarnazioni



*  `Collection` -- contenitore di elementi atomici{

      *  3 sottotipi: `List` (sequenze), `Set` (no duplicazioni), `Queue`
    
}
*  `Map` -- contenitore di coppie chiave-valore
  


  
### Interfacce/classi di interesse:



*  Interfacce: `Collection`, `List`, `Set`, `Iterator`, `Comparable`
*  Classi collection: `ArrayList`, `LinkedList`, `HashSet`, `HashMap`
*  Classi con funzionalità: `Collections`, `Arrays`
  

  


---


## Una nota su eccezioni e JCF


  
### Eccezioni: un argomento che tratteremo in dettaglio


    Un meccanismo usato per gestire eventi ritenuti fuori dalla normale esecuzione (errori), ossia per dichiararli, lanciarli, intercettarli
  

  
### JCF e eccezioni



*  Ogni collection ha sue regole di funzionamento, e non ammette certe operazioni che richiedono controlli a tempo di esecuzione (ad esempio, certe collezioni sono immutabili, e non si può tentare di scriverci)
*  Molti metodi dichiarano che possono lanciare eccezioni -- ma possiamo non preoccuparcene per ora
  




---


# Iteratori e foreach

---



## Foreach


  
### Costrutto foreach



*  Abbiamo visto che può essere usato per iterare su un array in modo più astratto (compatto, leggibile){

      *  `{...\}`
    
}
*  Java fornisce anche un meccanismo per usare il foreach su qualunque collection, in particolare, su qualunque oggetto che implementa l'interfaccia `java.lang.Iterable<X>`
  


  
### `Iterable` e `Iterator`



*  L'interfaccia `Iterable` ha un metodo per generare e restituire un (nuovo) `Iterator`
*  Un iteratore è un oggetto con metodi `next()`, `hasNext()` (e `remove()`)
*  Dato l'oggetto `coll` che implementa `Iterable<T>` allora il foreach diventa:{

      *  `{...\}`
    
}
  




---


## Interfacce per l'iterazione


  \sizedcode{\scriptsize}{code/short/Iterable.java}
  \sizedcode{\scriptsize}{code/short/Iterator.java}
  \sizedcode{\scriptsize}{code/short/Collection-Short.java}


---


## Interfacce per l'iterazione -- UML


  ![](img/uml-iter.pdf)


---


## Esempio di iterable ad-hoc, e suo uso


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/iterator/Range.java" %}}
```

  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/iterator/UseRange.java" %}}
```



---


## Realizzazione del corrispondente iteratore


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/iterator/RangeIterator.java" %}}
```



---






## Iteratori e collezioni: preview


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/iterator/UseCollectionIterator.java" %}}
```



---


# Collection, List, Set

---



## Interfaccia `Collection`


  
### Ruolo di questo tipo di dato



*  È la radice della gerarchia delle collezioni
*  Rappresenta gruppi di oggetti (duplicati/non, ordinati/non)
*  Implementata via sottointerfacce (`List` e `Set`)
  


  
### Assunzioni



*  Definisce operazioni base valide per tutte le collezioni
*  Assume implicitamente che ogni collezione abbia due costruttori{

      *  Senza argomenti, che genera una collezione vuota
      *  Che accetta un `Collection`, dal quale prende tutti gli elementi
    
}
*  Le operazioni di modifica sono tutte "opzionali"{

      *  potrebbero lanciare un `UnsupportedOperationException`
    
}
*  Tutte le operazioni di ricerca lavorano sulla base del metodo `Object.equals()` da chiamare sugli elementi{

      *  questo metodo accetta un `Object`, influendo su alcuni metodi di `Collection`
    
}
  




---



## `Collection`


  \sizedcode{\ssmall}{code/short/Collection.java}


---


## Usare le collezioni


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/collection/UseCollection.java" %}}
```



---


## Creare collezioni (immutabili) -- Java 9+


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/collection/UseFactories.java" %}}
```



---


## `Set` e `List`


  
### `Set`



*  Rappresenta collezioni senza duplicati{

      *  nessuna coppia di elementi porta `Object.equals()` a dare `true`
      *  non vi sono due elementi `null`
    
}
*  Non aggiunge metodi rispetto a `Collection`
*  I metodi di modifica devono rispettare la non duplicazione
  


  
### `List`



*  Rappresenta sequenze di elementi
*  Ha metodi per accedere ad un elemento per posizione (0-based)
*  Andrebbe scandito via iteratore/foreach, non con indici incrementali
*  Fornisce un list-iterator che consente varie operazioni aggiuntive
  


  
La scelta fra queste due tipologie non dipende da motivi di performance, ma da quale modello di collezione serva!



---


## `Set` e `List`


  \sizedcode{\scriptsize}{code/short/List.java}
  \sizedcode{\scriptsize}{code/short/Set.java}


---


## `ListIterator`


  \sizedcode{\scriptsize}{code/short/ListIterator.java}


---


## `UseListIterator`


  
```java
{{% import-raw from=4 to=100 path="pss-code/src/main/java/it/unibo/collections/collection/UseListIterator.java" %}}
```



---


## Implementazione collezioni -- UML


    ![](img/uml-abs.pdf)


---


## Implementazione collezioni: linee guida generali


    
### Una modalità di progettazione da ricordare



	*  Interfacce: riportano le funzionalità definitorie del concetto
	*  Classi astratte: fattorizzano codice comune alle varie implementazioni
	*  Classi concrete: realizzano le varie implementazioni
    


    
### Nel codice cliente..



	*  In variabili, argomenti, tipi di ritorno, si usano le interfacce
	*  Le classi concrete solo nella `new`, a parte casi molto particolari
	*  Le classi astratte non si menzionano praticamente mai, solo eventualmente per chi volesse costruire una nuova implementazione
    




---



## Implementazione collezioni -- Design space


  
### Classi astratte



*  `AbstractCollection`, `AbstractList`, e `AbstractSet`
*  Realizzano "scheletri" di classi per collezioni, corrispondenti alla relative interfacce
*  Facilitano lo sviluppo di nuove classi aderenti alle interfacce
  


  
### Un esempio: `AbstractSet`



*  Per set immutabili, richiede solo di definire `size()` e `iterator()`
*  Per set mutabili, richiede anche di ridefinire `add()`
*  Per motivi di performance si potrebbero fare ulteriori override 
  


  
### Classi concrete.. fra le varie illustreremo:



*  `HashSet`, `TreeSet`, `ArrayList`, `LinkedList`
*  La scelta riguarda quasi esculsivamente esigenze di performance
  




---


## Esempio di creazione di un nuovo set: `RangeSet`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/collection/RangeSet.java" %}}
```



---


## Uso di `RangeSet`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/collection/UseRangeSet.java" %}}
```



---


# Implementazioni di `Set

---
`


## Implementazioni di `Set`


  
### Caratteristiche dei set



*  Nessun elemento duplicato (nel senso di `Object.equals()`)
* $\rightarrow$ Il problema fondamentale è il metodo `contains()`, nelle soluzioni più naive (con iteratore) potrebbe applicare una ricerca sequenziale, e invece si richiedono performance migliori
  


  
### Approccio 1: `HashSet`


   Si usa il metodo `Object.hashCode()` come funzione di *__hash__*, usata per posizionare gli elementi in uno store di elevate dimensioni
  

  
### Approccio 2: `TreeSet`


   Specializzazione di `SortedSet` e di `NavigableSet`. Gli elementi sono ordinati, e quindi organizzabili in un albero (red-black tree) per avere accesso in tempo logaritmico
  



---


## `HashSet`


  
### Idea di base: tecnica di hashing (via `Object.hashCode()`)



*  Si crea un array di elementi più grande del necessario (p.e. almeno il 25% in più), di dimensione `size`
*  Aggiunta di un elemento `e`{

      *  lo si inserisce in posizione `e.hashCode() % size`
      *  se la posizione è già occupata, lo si inserisce nella prima disponibile
      *  se l'array si riempie va espanso e si deve fare il rehashing
    
}
*  Ricerca di un elemento `f`{
 
      *  si guarda a partire da `f.hashCode() % size`, usando `Object.equals()`
      *  La funzione di hashing deve evitare il più possibile le collisioni
    
}
*  Risultato: scritture/letture sono $O(1)$ ammortizzato
  


  
### Dettagli interni



*  Realizzata tramite `HashMap`, che approfondiremo in futuro
  




---


## Costruttori di `HashSet`


  \sizedcode{\scriptsize}{code/short/HashSet.java}


---


## `equals()` e `hashCode()`


  
### La loro corretta implementazione è cruciale



*  Le classi di libreria di Java sono già OK
*  `Object` uguaglia lo stesso oggetto e l'hashing restituisce la posizione in memoria..
*  .. quindi nuove classi devono ridefinire `equals()` e `hashCode()` opportunamente
  


  
### Quale funzione di hashing?



*  oggetti `equals` devono avere lo stesso `hashCode`
*  non è detto il viceversa, ma è opportuno per avere buone performance di `HashSet`
*  si veda ad esempio: {\tt\small http://en.wikipedia.org/wiki/Java_hashCode()}
*  Eclipse fornisce la generazione di un `hashCode` ragionevole (ce ne sono di migliori: `djb2`, `murmur3`)
  




---


## Esempio: `Persona` pt.1


  
```java
{{% import-raw from=3 to=34 path="pss-code/src/main/java/it/unibo/collections/set/Persona.java" %}}
```



---


## Esempio: `Persona` pt.2


  
```java
{{% import-raw from=35 to=100 path="pss-code/src/main/java/it/unibo/collections/set/Persona.java" %}}
```



---


## `UseHashSetPersona`


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/set/UseHashSetPersona.java" %}}
```



---


## `TreeSet<E>`


  
### Specializzazione `NavigableSet` (e `SortedSet`)



*  Assume che esista un ordine fra gli elementi
*  Quindi ogni elemento ha una sua posizione nell'elenco
*  Questo consente l'approccio dicotomico alla ricerca
*  Consente funzioni addizionali, come le iterazioni in un intervallo
  


  
### Realizzazione ordinamento: due approcci (interno o esterno)



*  O con elementi che implementano direttamente `Comparable`{

      *  Nota che, p.e., `Integer` implementa `Comparable<Integer>`
    
}
*  O attraverso un `Comparator` esterno fornito alla `new`
  


  
### Implementazione `TreeSet`



*  Basata su red-black tree (albero binario bilanciato)
*  Tempo logaritmico per inserimento, cancellazione, e ricerca
  




---


## Comparazione "interna" agli elementi


  \sizedcode{\scriptsize}{code/short/Comparable.java}
  \sizedcode{\scriptsize}{code/Wrappers.java}
  \sizedcode{\scriptsize}{code/SortedPersona.java}


---


## Esempi di comparazione interna


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/sortedset/UseComparison.java" %}}
```



---


## Interfacce `SortedSet` e `NavigableSet`


  \sizedcode{\scriptsize}{code/short/SortedSet.java}
  \sizedcode{\scriptsize}{code/short/NavigableSet.java}


---



## `UseTreeSetPersona`: comparazione interna


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/sortedset/UseTreeSetPersona.java" %}}
```



---


## Costruttori di `TreeSet`, e comparatore "esterno"


  \sizedcode{\scriptsize}{code/short/TreeSet.java}
  \sizedcode{\scriptsize}{code/short/Comparator.java}


---


## Definizione di un comparatore esterno


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/sortedset/PersonaComparator.java" %}}
```



---


## `UseTreeSetPersona2`: comparazione esterna


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/sortedset/UseTreeSetPersona2.java" %}}
```



---


## Perché il tipo `Comparator<? super E>`


  
Data una classe `SortedSet<E>` il suo comparatore ha tipo \mbox{`Comparator<? super E>`}, perché non semplicemente `Comparator<E>`?

  
### È corretto



*  `Comparator` ha metodi che hanno `E` solo come argomento
*  quindi l'uso di `Comparator<? super E>` è una generalizzazione di `Comparator<E>`
  


  
### È utile



*  Supponiamo di aver costruito un comparatore per `SimpleLamp`, e che questo sia usabile anche per tutte le specializzazioni successivamente costruite (è la situazione tipica)
*  Anche un `SortedSet<UnlimitedLamp>` deve poter usare il `Comparator<SimpleLamp>`, ma questo è possibile solo grazie al suo tipo atteso `Comparator<? super E>`
  




---


## Un esempio di design con le collezioni



Implementare questa interfaccia che modella un archivio persone

  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/set/Archive.java" %}}
```



---


## Una soluzione con `HashSet`


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/set/ArchiveImpl.java" %}}
```



---


## Scenario d'uso dell'archivio


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/set/UseArchive.java" %}}
```



---





## Outline


  
### Goal della lezione



  *  Approfondire alcuni concetti sui generici
  *  Presentare altre classi per le collezioni
  


  
### Argomenti



  *  Il problema della type-erasure
  *  Polimorfismo vincolato
  *  Approfondimento sulle Wildcards
  *  Implementazioni di `List` e `Map`
  




---

# Il problema della **type-erasure**


## La classe generica `List`


```java
{{% import-raw path="code/generics/List.java" %}}
```


---


## Uso di una classe generica


```java
{{% import-raw path="code/generics/generics/UseList.java" %}}
```


---


## Terminologia, e elementi essenziali


  
### Data una classe generica `C<X,Y>`..



*  `X` e `Y` sono dette le sue *__type-variable__*
*  `X` e `Y` possono essere usate come un qualunque tipo dentro la classe (con alcune limitazioni che vedremo)
  


  
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



---


## Limitazioni all'uso dei generici


  
### Una type-variable (`X`) non è usabile in istruzioni del tipo:



*  `new X()`, `{..\}`, `new X[10]`, `instanceof X`
*  Il compilatore segnala un errore
*  errore anche l'`instanceof` su un tipo generico: `o instanceof C<String>`
  


  
### Type-variable, e tipi generici danno warning se usati in situazioni "borderline"



* ... `(X)o`, `(C<String>)o`
*  il compilatore segnala un "unchecked warning"
  


  
### Perché queste limitazioni? (Odersky \& Runne \& Wadler, 1998)



*  Derivano dallo schema di supporto ad erasure
    *  Il compilatore prende la classe `List<X>` e la trasforma in qualcosa di simile alla classe `ObjectList` prima di compilarla effettivamente..
    
  




---


## Qualche prova


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/generic/erasure/ErasurePitfalls.java" %}}
```



---



## La classe generica `Vector`


  
### Un dettaglio della sua implementazione:


Per via della type erasure, il suo campo non può essere di tipo `X[]`, bensì `Object[]`
  

```java
{{% import-raw path="code/generics/Vector.java" %}}
```


---


## Uso di `Vector<X>`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/generics/UseVector.java" %}}
```


---


## Implementazione di `Vector` pt 1



```java
{{% import-raw from=3 to=26 path="pss-code/src/main/java/it/unibo/generics/generics/Vector.java" %}}
```



---


## Implementazione di `Vector` pt 2



```java
{{% import-raw from=27 to=100 path="pss-code/src/main/java/it/unibo/generics/generics/Vector.java" %}}
```


---


## Ancora sugli "unchecked warning" coi generici



```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/generic/abstractions/ShowCast.java" %}}
```



---

# Polimorfismo vincolato


## Polimorfismo vincolato


  
### Negli esempi visti finora..



*  Data una classe `C<X>`, `X` può essere istanziato a qualunque sottotipo di `Object`
*  In effetti la definizione `class C<X> { ... }` equivale a `class C <X extends Object> { ... }`
  


  
### Polimorfismo vincolato (Igarashi \& Pierce \& Wadler, 2000)



*  In generale invece, può essere opportuno vincolare in qualche modo le possibili istanziazioni di `X`, ad essere sottotipo di un tipo più specifico di `Object`
*  `class C<X extends D> { ... }`
*  In tal caso, dentro `C`, si potrà assumere che gli oggetti di tipo `X` rispondano ai metodi della classe `D`
  




---


## `LampsRow` generica: Definizione


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/generic/constrained/LampsRow.java" %}}
```



---


## Uso


  
### Motivazione per questa genericità. Ha senso se:



*  si ritiene molto frequente l'uso di `SimpleLamp` simili tra loro, ossia di una comune specializzazione (classe)
*  è frequente l'uso di `getLamp()`  e quindi del cast
  


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/generic/constrained/UseLampsRow.java" %}}
```



---


# Java Wildcards e sostituibilità



## Java Wildcards

```java
{{% import-raw path="code/generics/Numbers.java" %}}
```


```java
{{% import-raw path="code/generics/Wildcards.java" %}}
```

---


## Java Wildcards


  
### 3 tipi di wildcard (Igarashi \& Viroli, 2002)


*  Bounded (covariante): `C<? extends T>`{
    *  accetta un qualunque `C<S>` con `S <: T`
*  Bounded (controvariante): `C<? super T>`{
    *  accetta un qualunque `C<S>` con `S >: T`
*  Unbounded: `C<?>`{
    *  accetta un qualunque `C<S>`    

  
### Uso delle librerie che dichiarano tipi wildcard



*  Piuttosto semplice, basta passare un argomento compatibile o si ha un errore a tempo di compilazione
  


  
### Progettazione di librerie che usano tipi wildcard



*  Molto avanzato: le wildcard pongono limiti alle operazioni che uno può eseguire, derivanti dal principio di sostituibilità




---



## Approfondimento: sulla sostituibilità dei generici


  
### Domanda: `Vector<Integer>` è un sottotipo di `Vector<Object>`?


Ovvero, possiamo pensare di passare un `Vector<Integer>` in tutti i contesti in cui invece ci si aspetta un `Vector<Object>`?
  

  
### Risposta: no!! Sembrerebbe di si.. ma:


cosa succede se nel metodo qui sotto passiamo un `Vector<Integer>`?<br>
    $\Rightarrow$ potremmo facilmente compromettere l'integrità del vettore
  


```java
{{% import-raw path="code/generics/Covariance.java" %}}
```

---


## Subtyping e safety


  
### *__Safety__* di un linguaggio OO


Se nessuna combinazione di istruzioni porta a poter invocare un metodo su un oggetto la cui classe non lo definisce{

    *  È necessario che il subtyping segua il principio di sostituibilità

Più in generale, se non possono accadere errori a tempo di esecuzione..
  

  
### Java



*  Si pone dove possibile l'obbiettivo della safety
*  Quindi, non è vero che `Vector<Integer> <: Vector<Object>`
  


  
### Generici e safety


In generale, istanziazioni diverse di una classe generica sono scollegate
    

*  non c'è *__covarianza__*: non è vero che `C<T> <: C<S>` con `T <: S`
*  non c'è *__controvarianza__*: non è vero che `C<S> <: C<T>` con `T <: S`
  




---


## Unsafety con gli array di Java


  
### Gli array di Java sono trattati come covarianti!



*  Gli array assomigliano moltissimo ad un tipo generico
*  `Integer[]` $\sim$ `Array<Integer>`, `T[]` $\sim$ `Array<T>`
*  E quindi sappiamo che non sarebbe safe gestirli con covarianza
*  E invece in Java è esattamente così!! P.e. `Integer[] <: Object[]`
*  Quindi ogni scrittura su array potrebbe potenzialmente fallire....lanciando un `ArrayStoreException`
  


```java
{{% import-raw path="code/generics/Arrays.java" %}}
```

---


## Covarianza e operazioni di accesso


  
### La covarianza (`C<T> <: C<S>` con `T <: S`) sarebbe ammissibile se:



*  La classe `C<X>` non avesse operazioni che ricevono oggetti `X`
*  Ossia, ha solo campi privati e nessun metodo con argomento `X`
  


  
### La controvarianza (`C<S> <: C<T>` con `T <: S`) sarebbe ammissibile se:



*  La classe `C<X>` non avesse operazioni che producono oggetti `X`
*  Ossia, ha solo campi privati e nessun metodo con tipo di ritorno `X`
  


  
### In pratica:



*  La maggior parte delle classi generiche `C<X>` hanno campi di tipo `X` (composizione) e operazioni getter e setter, e quindi per loro covarianza e controvarianza non funzionano
*  Con le wildcard si aumenta il riuso dei metodi che non usano tutte le funzione del tipo generico in input
  




---



## Esempio Wildcard Bounded covariante: `C<? extends T>`


```java
{{% import-raw path="code/generics/variance/Cov.java" %}}
```


---


## Esempio Wildcard Bounded controvariante: `C<? super T>`


```java
{{% import-raw path="code/generics/variance/Contra.java" %}}
```


---


## Esempio Wildcard Unbounded: `C<?>`


```java
{{% import-raw path="code/generics/variance/Unbounded.java" %}}
```


---


## Un uso tipico: metodi in classi generiche

```java
{{% import-raw path="code/generics/VectFrag.java" %}}
```

```java
{{% import-raw path="code/generics/variance/UseVector.java" %}}
```



---


# Implementazioni di `List`


## Implementazione collezioni -- UML


    ![](../10-collections/img/uml-abs.pdf)


---



## `List`



```java
{{% import-raw path="code/collections/short/List2.java" %}}
```



---


## Implementazioni di `List`


  
### Caratteristiche delle liste



*  Sono sequenze: ogni elemento ha una posizione
* $\rightarrow$ Il problema fondamentale è realizzare i metodi posizionali in modo efficiente, considerando il fatto che la lista può modificarsi nel tempo (altrimenti andrebbe bene un array)
  


  
### Approccio 1: `ArrayList`


Internamente usa un array di elementi con capacità maggiore di quella al momento necessaria. Se serve ulteriore spazio si alloca trasparentemente un nuovo e più grande array
  

  
### Approccio 2: `LinkedList`


Usa una double-linked list. L'oggetto `LinkedList` mantiene il riferimento al primo e ultimo elemento della lista, e alla dimensione della lista
  



---


## `ArrayList`


  
### Caratteristiche di performance



*  Lettura/scrittura in data posizione sono a tempo costante
*  La `add()` è tempo costante ammortizzato, ossia, $n$ add si effettuano in $O(n)$
*  Tutte le altre operazioni sono a tempo lineare
  


  
### Funzionalità aggiuntive

Per migliorare le performance (e l'occupazione in memoria) in taluni casi l'utente esperto può usare funzioni aggiuntive

*  Specificare la dim iniziale dell'array interno nella `new`
*  `trimToSize()` e `ensureCapacity()` per modifiche in itinere
  




---



## `ArrayList`: aspetti aggiuntivi


```java
{{% import-raw path="code/collections/short/ArrayList.java" %}}
```

---


## `UseArrayList`


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/generic/list/UseArrayList.java" %}}
```



---


## `LinkedList`


  
### Caratteristiche di performance



*  Accesso e modifica in una data posizione hanno costo lineare
*  Operazioni in testa o coda, quindi, sono a tempo costante
*  Usa in generale meglio la memoria rispetto `ArrayList`
*  (di norma però si preferisce `ArrayList`)
  


  
### Funzionalità aggiuntive



*  Implementa anche l'interfaccia `Deque`, usata per rappresentare una coda bidirezionale, potenzialmente con dimensione limitata
  




---


## `LinkedList`: funzioni aggiuntive relative a code (e stack)


```java
{{% import-raw path="code/collections/short/Queue.java" %}}
```

```java
{{% import-raw path="code/collections/short/Deque.java" %}}
```


---


## `LinkedList`: costruzione


```java
{{% import-raw path="code/collections/short/LinkedList.java" %}}
```

---


## `UseLinkedList`


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/generic/list/UseLinkedList.java" %}}
```



---



# Altre classi di utilità: `Arrays` e `Collections`


## Classi di utilità (moduli): `Arrays` e `Collections`


  
### `java.util.Arrays`



*  Contiene varie funzionalità d'ausilio alla gestione degli array
*  In genere ha varie versione dei metodi per ogni array di tipo primitivo
*  Ricerca binaria (dicotomica), Ordinamento (quicksort), copia
*  Operazioni base (`toString`, `equals`, `hashCode`), anche ricorsive
  


  
### `java.util.Collections`



*  Raccoglie metodi statici che sarebbero potuti appartenere alle varie classi/interfacce viste
*  Ricerca binaria (dicotomica), Ordinamento (quicksort), copia, min, max, sublist, replace, reverse, rotate, shuffle
*  Con esempi notevoli d'uso delle wilcard
  




---


## `Arrays`: qualche esempio di metodi


```java
{{% import-raw path="code/collections/short/Arrays.java" %}}
```

---


## `UseArrays`: qualche esempio di applicazione


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/generic/functions/UseArrays.java" %}}
```



---


## `Collections`: qualche esempio di metodi


```java
{{% import-raw path="code/collections/short/Collections.java" %}}
```

---


## `UseCollections`: qualche esempio di applicazione


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/generic/functions/UseCollections.java" %}}
```



---

# Il caso delle `java.util.Map`



## JCF -- struttura semplificata


![](imgs/tax.png)


---


## `Map`


```java
{{% import-raw path="code/collections/generic/short/Map_.java" %}}
```

---


## Usare le mappe


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/generic/map/UseMap.java" %}}
```



---


## Due implementazioni di `Map` e `AbstractMap`


  
### `Map<K,V>`



*  Rappresenta una funzione dal dominio `K` in `V`
*  La mappa tiene tutte le associazioni (o "entry")
*  Non posso esistere due entry con stessa chiave (`Object.equals`)
    
  


  
### `HashMap`



*  Sostanzialmente un `HashSet` di coppie `Key`, `Value`
*  L'accesso ad un valore tramite la chiave è fatto con hashing
*  Accesso a tempo costante, a discapito di overhead in memoria
  


  
### `TreeMap`



*  Sostanzialmente un `TreeSet` di coppie `Key`, `Value`
*  L'accesso ad un valore tramite la chiave è fatto con red-black tree
*  Accesso in tempo logaritmico
*  Le chiavi devono essere ordinate, come per i `TreeSet`
  




---

# Un esercizio sulle collezioni


## Interfaccia da implementare


  
```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/collections/generic/exercise/Graph.java" %}}
```



---


## Codice di prova


  
```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/collections/generic/exercise/UseGraph.java" %}}
```



---


## Strategia risolutiva

 
### Passi:



*  Capire bene cosa la classe deve realizzare
*  Pensare a quale tipo di collezioni può risolvere il problema in modo semplice e prestante
*  Realizzare i vari metodi
*  Controllare i casi particolari

