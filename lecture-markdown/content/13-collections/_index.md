
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



  *  Presentazione *Java Collections Framework*
  *  Iteratori e foreach
  *  Collezioni, Set, e Liste
  *  `HashSet` e `TreeSet`
  *  `ArrayList` e `LinkedList`
  *  Funzioni di utilità in `Arrays` e `Collections`
  *  Implementazioni di `List` e `Map`




---

# Java Collections Framework (JCF)

---

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


  ![](imgs/tax1.png)


---


## JCF -- struttura riorganizzata


  ![](imgs/tax.png)


---



## JCF -- alcuni aspetti generali


  
### È complessivamente piuttosto articolato



*  Un nostro obbiettivo è quello di isolare una sua sottoparte di interesse
*  Identificando e motivando le funzionalità prodotte
  


  
### Due tipi di collection, ognuna con varie incarnazioni



*  `Collection` -- contenitore di elementi atomici; 3 sottotipi di collezioni
    1. `List` (sequenze)
    2. `Set` (no duplicazioni)
    3. `Queue` (per tenere elenti da processare, in vario ordine, e.g., FIFO, LIFO, a priorità etc.)
*  `Map` -- contenitore di coppie chiave-valore
  


  
### Interfacce/classi di interesse:



*  Interfacce: `Collection`, `List`, `Set`, `Map`, `Queue`, `Iterator`, `Comparable`
*  Classi astratte: `AbstractList`, `AbstractSet`, `AbstractMap`
*  Classi collection: `ArrayList`, `LinkedList`, `HashSet`, `HashMap`, `PriorityQueue`
*  Classi con funzionalità: `Collections`, `Arrays`
  

  


---


## Una nota su eccezioni e JCF


  
### Eccezioni: un argomento che tratteremo in dettaglio


Un meccanismo usato per gestire eventi ritenuti fuori dalla normale esecuzione (errori), ossia per dichiararli, lanciarli, intercettarli
  

  
### JCF e eccezioni



*  Ogni collection ha sue regole di funzionamento, e non ammette certe operazioni che richiedono controlli a tempo di esecuzione 
    * ad esempio, certe collezioni sono immutabili, e non si può tentare di scriverci
    * oppure, non si può ottenere un elemento da una collezione vuota
*  Molti metodi dichiarano che possono lanciare eccezioni -- ma possiamo non preoccuparcene per ora
  




---


# Iteratori e foreach

---



## Foreach


  
### Costrutto foreach



*  Abbiamo visto che può essere usato per iterare su un array in modo più astratto (compatto, leggibile)
```java
for(int i: array) { ... }
```
*  Java fornisce anche un meccanismo per *usare il foreach su qualunque collection, in particolare, su qualunque oggetto che implementa l'interfaccia* `java.lang.Iterable<X>`
  


  
### `Iterable` e `Iterator`



*  L'interfaccia `Iterable` (contratto degli oggetti *iterabili*) ha un metodo per generare e restituire un (nuovo) `Iterator`
*  Un *iteratore* è un oggetto con metodi `next()`, `hasNext()` (e `remove()`)
*  Dato l'oggetto `coll` che implementa `Iterable<T>` allora il foreach diventa:
```java
for(T element: coll) { ... }
```
  




---


## Interfacce per l'iterazione


```java
{{% import-raw path="code/collections/short/Iterable.java" %}}
```

```java
{{% import-raw path="code/collections/short/Iterator.java" %}}
```

```java
{{% import-raw path="code/collections/short/Collection-Short.java" %}}
```

---


## Interfacce per l'iterazione -- UML


  ![](imgs/uml-iter.png)


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



*  Definisce *operazioni base* valide per tutte le collezioni
*  Assume implicitamente che ogni collezione abbia *due costruttori*

      *  *Senza argomenti*, che genera una collezione vuota
      *  *Che accetta una `Collection`*, dal quale prende tutti gli elementi
  
*  Le operazioni di *modifica* sono tutte *"opzionali"*
      *  potrebbero lanciare un `UnsupportedOperationException`
    
*  Tutte le operazioni di *ricerca* lavorano sulla base del metodo `Object.equals()` da chiamare sugli elementi
      *  questo metodo accetta un `Object`, influendo su alcuni metodi di `Collection`
    




---



## `Collection`


```java
{{% import-raw path="code/collections/short/Collection.java" %}}
```

---


## Usare le collezioni

* Nota: invocazione metodi dell'interfaccia `Collection`
* Interazione con array via ad es. `Arrays.asList()` e `Collection.toArray()`
  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/collection/UseCollection.java" %}}
```



---


## Creare collezioni (immutabili) -- Java 9+

- Metodi statici factory `.of(...)` e `.copyOf(c)` su `List`, `Set`, ...
  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/collection/UseFactories.java" %}}
```



---


## `Set` e `List`


  
### `Set`



*  Rappresenta collezioni *senza duplicati*
      *  nessuna coppia di elementi porta `Object.equals()` a dare `true`
      *  non vi sono due elementi `null`
    
*  Non aggiunge metodi rispetto a `Collection`
*  I metodi di modifica devono rispettare la non duplicazione
  


  
### `List`



*  Rappresenta *sequenze di elementi*
*  Ha metodi per accedere ad un elemento per *posizione* (0-based)
*  *Andrebbe scandito via iteratore/foreach*, non con indici incrementali
*  Fornisce un list-iterator che consente varie operazioni aggiuntive
  


  
La scelta fra queste due tipologie non dipende da motivi di performance, ma da quale modello di collezione serva!



---


## `Set` e `List`

```java
{{% import-raw path="code/collections/short/Set.java" %}}
```

```java
{{% import-raw path="code/collections/short/List.java" %}}
```


---


## `ListIterator`


```java
{{% import-raw path="code/collections/short/ListIterator.java" %}}
```

---


## `UseListIterator`


  
```java
{{% import-raw from=4 to=100 path="pss-code/src/main/java/it/unibo/collections/collection/UseListIterator.java" %}}
```



---


## Implementazione collezioni -- UML


![](imgs/uml-abs.png)


---


## Implementazione collezioni: linee guida generali


    
### Una modalità di progettazione da ricordare



*  *Interfacce*: riportano le funzionalità definitorie del concetto
*  *Classi astratte*: fattorizzano codice comune alle varie implementazioni
*  *Classi concrete*: realizzano le varie implementazioni
    


    
### Nel codice cliente..



*  *In variabili, argomenti, tipi di ritorno, si usano le interfacce*
*  *Le classi concrete solo in fase di istanziazione*, nella `new`, a parte casi molto particolari
*  *Le classi astratte solo per costruire nuove implementazioni* <!-- non si menzionano praticamente mai, solo eventualmente per chi volesse costruire una nuova implementazione -->
    




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


# Implementazioni di `Set`

---



## Implementazioni di `Set`


  
### Caratteristiche dei set



*  Nessun elemento duplicato (nel senso di `Object.equals()`)
* $\rightarrow$ Il problema fondamentale è il metodo `contains()`, nelle soluzioni più naive (con iteratore) potrebbe applicare una ricerca sequenziale, e invece si richiedono performance migliori
  


  
### Approccio 1: `HashSet`


   Si usa il metodo `Object.hashCode()` come funzione di *__hash__*, usata per posizionare gli elementi in uno store di elevate dimensioni
  

  
### Approccio 2: `TreeSet`


   Specializzazione di `SortedSet` e di `NavigableSet`. Gli elementi sono ordinati, e quindi organizzabili in un albero (*red-black tree*, un albero binario auto-bilanciante) per avere accesso in tempo logaritmico
  



---


## `HashSet`


  
### Idea di base: tecnica di hashing (via `Object.hashCode()`)



*  Si crea un array di elementi più grande del necessario (p.e. almeno il 25% in più), di dimensione `size`
*  Aggiunta di un elemento `e`

      *  lo si inserisce in posizione `e.hashCode() % size`
      *  se la posizione è già occupata, lo si inserisce nella prima disponibile
      *  se l'array si riempie va espanso e si deve fare il rehashing
    

*  Ricerca di un elemento `f`
 
      *  si guarda a partire da `f.hashCode() % size`, usando `Object.equals()`
      *  La funzione di hashing deve evitare il più possibile le collisioni
    

*  Risultato: scritture/letture sono $O(1)$ ammortizzato
  


  
### Dettagli interni



*  Realizzata tramite `HashMap`, che approfondiremo in futuro
  




---


## Costruttori di `HashSet`


```java
{{% import-raw path="code/collections/short/HashSet.java" %}}
```

---


## `equals()` e `hashCode()`


  
### La loro corretta implementazione è cruciale



*  Le classi di libreria di Java sono già OK
*  `Object` uguaglia lo stesso oggetto e l'hashing restituisce la posizione in memoria..
*  .. quindi nuove classi devono ridefinire `equals()` e `hashCode()` opportunamente
  


  
### Quale funzione di hashing?



*  oggetti `equals` devono avere lo stesso `hashCode`
*  non è detto il viceversa, ma è opportuno per avere buone performance di `HashSet`
*  si veda ad esempio: [https://en.bitcoinwiki.org/wiki/Java_hashCode()](https://en.bitcoinwiki.org/wiki/Java_hashCode())
*  Alcuni IDE forniscono la generazione di un `hashCode` ragionevole (ma tipicamente ce ne sono di migliori: `djb2`, `murmur3`)
  




---


## Esempio: `Persona` pt.1


{{% smaller %}}

```java
{{% import-raw from=3 to=34 path="pss-code/src/main/java/it/unibo/collections/set/Persona.java" %}}
```

{{% /smaller %}}


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



*  Assume che esista un *ordine totale* fra gli elementi
*  Quindi ogni elemento ha una sua *posizione* nell'elenco
*  Questo consente l'approccio dicotomico alla ricerca
*  Consente funzioni addizionali, come le iterazioni in un intervallo

  
### Realizzazione ordinamento: due approcci (interno o esterno)



*  O con elementi che implementano direttamente `Comparable`

      *  Nota che, p.e., `Integer` implementa `Comparable<Integer>`
    
*  O attraverso un `Comparator` esterno fornito alla `new`
  


  
### Implementazione `TreeSet`



*  Basata su red-black tree (albero binario bilanciato)
*  Tempo logaritmico per inserimento, cancellazione, e ricerca
  




---


## Comparazione "interna" agli elementi


```java
{{% import-raw path="code/collections/short/Comparable.java" %}}
```

```java
{{% import-raw path="code/collections/Wrappers.java" %}}
```
```java
{{% import-raw path="code/collections/SortedPersona.java" %}}
```



---


## Esempi di comparazione interna


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/sortedset/UseComparison.java" %}}
```



---


## Interfacce `SortedSet` e `NavigableSet`

{{% smaller %}}

- `SortedSet`: un set con ordinamento totale degli elementi, e quindi può rispondere a messaggi come `first()`, `last()`, `subset(from,to)`, `headSet(e)`/`tailSet(e)` che restituiscono una vista del set con gli elementi più piccoli/grandi di `e`
- `NavigableSet`: un `SortedSet` con metodi di "navigazione" (che riportano l'elemento più vicino, dal basso o dall'alto, a uno dato; ad es: `ceiling(e)`, `floor(e)`, `higher(e)`, `lower(e)`), ed `descendingSet()` che inverte l'ordine


```java
{{% import-raw path="code/collections/short/SortedSet.java" %}}
```

```java
{{% import-raw path="code/collections/short/NavigableSet.java" %}}
```

{{% smaller %}}

---



## `UseTreeSetPersona`: comparazione interna


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/collections/sortedset/UseTreeSetPersona.java" %}}
```



---


## Costruttori di `TreeSet`, e comparatore "esterno"


```java
{{% import-raw path="code/collections/short/TreeSet.java" %}}
```

```java
{{% import-raw path="code/collections/short/Comparator.java" %}}
```

---


## Definizione di un comparatore esterno


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/sortedset/PersonaComparator.java" %}}
```

```java
// Attenzione sull'uso della sottrazione per la compareTo fra interi
Integer.MAX_VALUE - Integer.MIN_VALUE // -1
Integer.valueOf(Integer.MAX_VALUE).compareTo(Integer.MIN_VALUE) // 1
```


---


## `UseTreeSetPersona2`: comparazione esterna


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/collections/sortedset/UseTreeSetPersona2.java" %}}
```

---


## Perché il tipo `Comparator<? super E>` (Approfondimento)

Data una classe `SortedSet<E>` il suo comparatore ha tipo `Comparator<? super E>`, perché non semplicemente `Comparator<E>`?

  
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


# Implementazioni di `List`

---

## Implementazione collezioni -- UML


![](imgs/uml-abs.png)


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


---

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

---

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

