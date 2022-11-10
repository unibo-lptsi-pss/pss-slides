
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



*  Illustrare il *problema delle collezioni polimorfiche*
*  Discutere il concetto di *polimorfismo parametrico*
*  Illustrare i *Generici* di Java e alcuni loro vari dettagli
  


  
### Argomenti



*  Collezioni con polimorfismo inclusivo
*  Classi generiche
*  Interfacce generiche
*  Metodi generici
  




---

# Collezioni con polimorfismo inclusivo


## Forme di **riuso** nella programmazione OO


  
### Composizione (e come caso particolare, delegazione)


Un oggetto è ottenuto per composizione di oggetti di altre classi
  

  
### Estensione (ereditarietà)


Una nuova classe è ottenuta riusando il codice di una classe pre-esistente
  

  
### Polimorfismo inclusivo (subtyping)


Una funzionalità realizzata per lavorare su valori/oggetti del tipo `A`, può lavorare con qualunque valore/oggetto del sottotipo `B` (p.e., se `B` estende la classe `A`, o se `B` implementa l'interfaccia `A`)
  

  
### Polimorfismo parametrico (Java/C\# generics, C++ templates,..)


Una funzionalità (classe o metodo) generica è costruita in modo tale da lavorare uniformemente su valori/oggetti indipendentemente dal loro tipo: tale tipo diventa quindi una sorta di parametro addizionale
  



---


## Astrazioni uniformi con le classi


  
### Astrazioni uniformi per problemi ricorrenti

* Si consideri il *problema specifico* del controllo dell'accensione di varie tipologie di dispositivi
    * Tale funzionalità si può fattorizzare ad esempio in una classe astratta `Device`
* Durante lo sviluppo di vari sistemi si incontrano *problemi generali/ricorrenti* che possono trovare una soluzione comune
* Spesso tali soluzioni sono *fattorizzabili in una o più interfacce/classi altamente riusabili* (per astrazione)
    * **Fattorizzare = mettere a fattor comune**, si pensi alla matematica $AB + AC = A(B + C)$
  
  
### Un caso fondamentale: le *__collection__*


*  Una *collection* è un *oggetto* il cui compito è quello di immagazzinare i *riferimenti* ad un numero (tipicamente non precisato) di altri oggetti 
    *  Fra i suoi compiti c'è quello di consentire *modifiche ed accessi veloci* all'insieme di elementi di tale collezioni
    *  Varie strategie possono essere utilizzate, seguendo la *teoria/pratica degli algoritmi e delle strutture dati*
  




---


## Un esempio: `IntVector`


  
### Collection `IntVector`



  *  Contiene *serie numeriche (**vettori**)* di dimensione non nota a priori, ossia, a *lunghezza variabile*..
  


  ![](imgs/uml-int-vector-abstracted.png)


---


## `UseIntVector`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/abstractions/UseIntVector.java" %}}
```



---


## `IntVector` -- implementazione


  
### Collection `IntVector`



  *  Contiene serie numeriche (vettori) di dimensione non nota a priori
  *  Realizzata *componendo un array che viene espanso all'occorrenza*
  


  ![](imgs/uml-int-vector.png)


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



  *  L'esperienza porterebbe subito alla necessità di progettare vettori di `float`, `double`, `boolean`, ... ossia di ogni tipo primitivo
  *  E poi, anche vettori di `String`, `Date`, eccetera
  *  L'implementazione sarebbe analoga, ma senza possibilità di riuso..
  


  
### Collection uniformi "monomorfiche"



  *  Una prima soluzione del problema la si ottiene sfruttando il polimorfismo inclusivo e la filosofia "everything is an object" (incluso l'uso dell'autoboxing dei tipi primitivi)
  *  Si realizza unicamente un `ObjectVector`, semplicemente sostituendo `int` con `Object`
  *  Si inserisce qualunque elemento (via upcast implicito)
      * `ObjectVector` è *monomorfica* in quanto "vede" un solo tipo, `Object` (sebbene i riferimenti agli `Object` siano *polimorfici*)
  *  Quando si riottiene un valore serve un downcast esplicito




---


## Da `IntVector` a `ObjectVector`


  ![](imgs/uml-obj-vector.png)


---


## `UseObjectVector`

* NOTA: **necessità di downcast espliciti**
  

{{% smaller %}}

```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/abstractions/UseObjectVector.java" %}}
```

{{% /smaller %}}

---


## Un altro caso di collection, la list linkata `ObjectList`

* Una *lista* è una struttura dati ricorsivamente definita: 
    * caso base: lista vuota
    * caso ricorsivo: ha una *testa* (elemento), e una *coda* (che è una *lista* a sua volta)
  
{{% smaller %}}

```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/abstractions/ObjectList.java" %}}
```

{{% /smaller %}}



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
*  Si perdeva molto facilmente traccia di quale fosse il contenuto..
    *  contenevano oggetti vari? solo degli `Integer`? solo delle `String`?
*  Il codice conteneva spesso dei downcast sbagliati, e quindi molte applicazioni Java fallivano generando dei `ClassCastException`
  


  
### Più in generale


Il problema si manifesta ogni volta che voglio collezionare oggetti il cui tipo non è noto a priori, ma potrebbe essere soggetto a polimorfismo inclusivo
  



---







## Polimorfismo parametrico


### Idea di base


  *  Dato un frammento di codice `F` che lavora su un certo tipo, diciamo `String`, se può lavorare *in modo uniforme* su altri tipi...
  *  ... allora lo si rende parametrico, sostituendo a `String` una sorta di variabile o parametro `X` (chiamata *__type variable__* o *__type parameter__*, ossia una variabile/parametro che denota un tipo)
      *  A questo punto, quando serve il frammento di codice istanziato sulle stringhe, si usa `F<String>`, ossia si richiede che `X` diventi `String`
      *  Quando serve il frammento di codice istanziato sugli Integer, si usa `F<Integer>`
      * Il codice che usa tale **polimorfismo parametrico** è *uniforme* (cioè non cambia) indipendentemente dalle istanziazioni dei tipi 
  
### Java Generics


*  I **generici** sono un meccanismo *compile-time* basato su *parametri di tipo* per implementare *polimorfismo parametrico*
*  *Classi/interfacce/metodi generici*: classi/interfacce/metodi parametrizzate su tipi, cioè che accettano tipi come parametri
*  Nessun impatto a run-time, per via dell'implementazione a "erasure"
    *  `javac` "compila via i generici", quindi la JVM non li vede





---


# Classi generiche

---



## La classe generica `List`

* `List` si dice che è un **tipo parametrico** (in quanto accetta il "parametro di tipo" `X`)

```java
{{% import-raw path="code/generics/List.java" %}}
```

---


## Uso di una classe generica

* Si istanzia il **parametro di tipo** generico `X` in un tipo specifico (**argomento di tipo**), ad es. `Integer`
  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/generics/UseList.java" %}}
```



---


## Terminologia, e elementi essenziali


  
### Data una classe generica `C<X,Y>`..

  *  `C` è detta **tipo parametrico**
  *  `X` e `Y` sono dette le sue *__type-variable__* o **parametri di tipo**
  *  `X` e `Y` possono essere usati come un qualunque tipo dentro la classe (con alcune limitazioni che vedremo)
  


  
### I clienti delle classi generiche



*  Devono usare *tipi specifici* ottenuti dai *__tipi generici__*, ovvero versioni "istanziate" delle classi generiche
    *  `C<String,Integer>`, `C<C<Object,Object>,Object>`
    *  Non `C` senza parametri, altrimenti vengono segnalati dei warning
*  Ogni type-variable va sostituita con un tipo effettivo, ossia con un *__argomento di tipo__*, che può essere
    *  una classe (non-generica), p.e. `Object`, `String`,..
    *  una type-variable definita, p.e. `X,Y` (usate dentro la classe `C<X,Y>`)
    *  un tipo generico completamente istanziato, p.e. `C<Object,Object>`
    *  ..o  parzialmente istanziato, p.e. `C<Object,X>` (in `C<X,Y>`)
    *  *NON con un tipo primitivo*




---



## La classe generica `Vector`


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

* Nota: in Java NON si può istanziare un array di tipo generico: `new X[10]` (errore statico)

```java
{{% import-raw path="code/generics/VectorA.java" %}}
```

---


## Implementazione di `Vector` pt 2


```java
{{% import-raw path="code/generics/VectorB.java" %}}
```

---




## La classe generica `Pair<X,Y>`


```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/generics/Pair.java" %}}
```


---


## Uso di `Pair<X,Y>`

{{% smaller %}}

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/generics/generics/UsePair.java" %}}
```

{{% /smaller %}}

---


## Inferenza dei parametri


  
### Un problema sintattico dei generici



  *  Tendono a rendere il codice più pesante ("verbose")
  *  Obbligano a scrivere i parametri anche dove ovvi, con ripetizioni
  


  
### L'algoritmo di *type-inference* nel compilatore



  *  Nella `new` si possono tentare di omettere i parametri (istanziazione delle type-variable), indicando il *"diamond symbol"* `<>`
  *  Il compilatore cerca di capire quali siano questi parametri guardando gli argomenti della `new` e l'eventuale contesto dentro il quale la `new` è posizionata, per esempio, se assegnata ad una variabile
  *  Nel raro caso in cui non ci riuscisse, segnalerebbe un errore a tempo di compilazione.. quindi tanto vale provare!
  *  Ricordarsi `<>`, altrimenti viene confuso con un *__raw type__*, un meccanismo usato per gestire il legacy con le versioni precedenti di Java
    


  
### La local variable type inference (`var`)

  *  in genere è alternativa al simbolo `<>`
  


  


---


## Esempi di inferenza

{{% smaller %}}

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/generics/generics/UsePair2.java" %}}
```

{{% /smaller %}}

---


## I vantaggi dei generici


  
Coi generici, Java diventa un linguaggio molto più espressivo!

  
### Svantaggi



  *  Il linguaggio risulta più sofisticato, e quindi complesso
  *  Se non ben usati, possono minare la comprensibilità del software
      *  Non vanno abusati!!
  *  Gli aspetti più avanzati dei generici (covarianza etc.), che NON vedremo, sono considerati troppo complessi
  


  
### Vantaggi -- se ben usati



  *  Codice più comprensibile
  *  *Maggiore riusabilità* (quasi d'obbligo oramai)
  *  Codice più sicuro (safe) -- il compilatore segnala errori difficili da trovare altrimenti
  




---


# Interfacce generiche

---



## Interfacce generiche


  
### Cosa è una interfaccia generica



  *  È una interfaccia che dichiara parametri di tipo: `interface I<X,Y> { ... }`
  *  I parametri di tipo compaiono nei metodi definiti dall'interfaccia
  *  Quando una classe la implementa deve istanziare i parametri di tipo <!-- (o assegnarle ad altre type-variable se essa stessa è generica) -->

  
### Utilizzi


Per creare *contratti uniformi rispetto ai tipi utilizzati*
  

  
### Un esempio notevole, gli **iteratori**

  *  Un *iteratore* è un oggetto usato per accedere ad una sequenza di elementi
      *  Ne vedremo ora una versione semplificata -- diversa da quella delle librerie Java
  




---


## L'interfaccia `Iterator`



```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/iterators/Iterator.java" %}}
```

---


## Implementazione 1: `IntRangeIterator`


```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/iterators/IntRangeIterator.java" %}}
```

---


## Implementazione 2: `ListIterator`



```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/iterators/ListIterator.java" %}}
```

---


## Implementazione 3: `VectorIterator`



```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/iterators/VectorIterator.java" %}}
```

---


## `UseIterators`: nota l'accesso uniforme!


```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/generics/iterators/UseIterators.java" %}}
```

---


# Metodi generici

---



## Metodi generici


  
### Metodo generico


Un metodo che lavora su qualche argomento e/o valore di ritorno in modo independente dal suo tipo effettivo. Tale tipo viene quindi astratto in una type-variable del metodo.
  

  
### Sintassi



  *  def: `<X1,..,Xn> ret-type nome-metodo(formal-args) { ... }`
  *  call: `receiver.<X1,..,Xn>nome-metodo(actual-args) { ... }`
  *  call con inferenza, stessa sintassi delle call standard, ossia senza `<>`
  


  
### Due casi principali, con medesima gestione



  *  Metodo generico (statico o non-statico) in una classe non generica
  *  Metodo generico (non-statico) in una classe generica
  * $\Rightarrow$ Il primo dei due molto più comune..
  




---


## Definizione di un metodo generico



```java
{{% import-raw path="code/generics/UseIterators2A.java" %}}
```

---


## Chiamata a metodo generico


```java
{{% import-raw path="code/generics/UseIterators2B.java" %}}
```

---


## Esempio di metodo generico in classe generica


```java
{{% import-raw path="code/generics/UseGenMeth.java" %}}
```

---


## Notazione UML (non del tutto standard)


![](imgs/uml-generics.png)


---


# Java Wildcards

---



## Java Wildcards


  
### Osservazione



  *  Esistono situazioni in cui un metodo debba accettare come argomento non solo oggetti di un tipo `C<T>`, ma di ogni `C<S>` dove `S <: T`
  *  Esempio: un metodo statico `printAll()` che prende in ingresso un iteratore e ne stampa gli elementi
  *  È realizzabile con un metodo generico, ma ci sono casi in cui si vorrebbe esprimere *un tipo che raccolga istanziazioni diverse di una classe generica*
  


  
### Java Wildcards



 <!--  *  Un meccanismo avanzato, quello inventato più di recente (2004-2006)
     *  (Igarashi \& Viroli) + (Bracha \& Gafter) + (Torgersen \& Hansen \& von der Ahé) -->

  *  Un meccanismo che fornisce dei nuovi tipi, chiamati Wildcards 
  *  Simili a interfacce (non generano oggetti, descrivono solo contratti)
  *  Generalmente usati come tipo dell'argomento di metodi
  




---



## Java Wildcards


```java
{{% import-raw path="code/generics/Numbers.java" %}}
```

```java
{{% import-raw path="code/generics/Wildcards.java" %}}
```

---


## Java Wildcards


  
### 3 tipi di wildcard



*  Bounded (covariante): `C<? extends T>`

    *  accetta un qualunque `C<S>` con `S <: T`

*  Bounded (controvariante): `C<? super T>`

    *  accetta un qualunque `C<S>` con `S >: T`
    
*  Unbounded: `C<?>`

    *  accetta un qualunque `C<S>`
  


  
### *Uso* delle librerie che dichiarano tipi wildcard



  *  Piuttosto semplice, basta passare un argomento compatibile o si ha un errore a tempo di compilazione
  


  
### *Progettazione* di librerie che usano tipi wildcard



  *  Molto avanzato: le wildcard pongono limiti alle operazioni che uno può eseguire, derivanti dal principio di sostituibilità
  




---


## Esempio Wildcard 1 (unbounded)


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/generics/wildcard/Wildcard.java" %}}
```

---

## Esempio Wildcard 2 (bounded)


  
```java
{{% import-raw from=5 path="pss-code/src/main/java/it/unibo/generics/wildcard/Wildcard2.java" %}}
```

---

## Esempio Wildcard 3 (bounded, limitazioni)

  
```java
{{% import-raw from=5 path="pss-code/src/main/java/it/unibo/generics/wildcard/Wildcard3.java" %}}
```

* `Vector<? extends Number>` si può leggere come "`Vector` che può fornire ma non accettare `Number`" (cf. in C# dove la keyword `out` è usata per specificare parametri di tipo covarianti)
* `Vector<? super Number>` si può leggere come "`Vector` che può accettare ma non fornire `Number`" (cf. in C# dove la keyword `in` è usata per specificare parametri di tipo controvarianti)
