
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/generic-collections-advanced/"]

+++

# Collezioni generiche (avanzate)

{{% import path="front-page.md" %}}

---

## Outline

### Goal della lezione
* Approfondire alcuni concetti sui generici

### Argomenti
* Il problema della type-erasure
* Polimorfismo vincolato
* Approfondimento sulle Wildcards

---

# Il problema della **type-erasure**

---

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


## Terminologia, ed elementi essenziali

### Data una classe generica `C<X,Y>`..
* `C` è detta **tipo parametrico**
* `X` e `Y` sono dette le sue *__type-variable__* o **parametri di tipo**
* `X` e `Y` possono essere usati come un qualunque tipo dentro la classe (con alcune limitazioni che vedremo)

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


## Limitazioni all'uso dei generici


  
### Una type-variable (`X`) non è usabile in istruzioni del tipo:



*  `new X()`, `new X[] {...}`, `new X[10]`, `instanceof X`
*  Il compilatore segnala un errore
*  errore anche l'`instanceof` su un tipo generico: `o instanceof C<String>`
  


  
### Type-variable, e tipi generici danno warning se usati in situazioni "borderline"



* ... `(X)o`, `(C<String>)o`
*  il compilatore segnala un "unchecked warning"
  


  
### Perché queste limitazioni? <!-- (Odersky \& Runne \& Wadler, 1998) -->



*  Derivano dallo schema di supporto *"ad erasure"*
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

---

## Polimorfismo vincolato


  
### Negli esempi visti finora..



*  Data una classe `C<X>`, il type-parameter `X` può essere istanziato a qualunque sottotipo di `Object`
*  In effetti la definizione `class C<X> { ... }` equivale a `class C <X extends Object> { ... }`
  


  
### Polimorfismo *vincolato* <!-- (Igarashi \& Pierce \& Wadler, 2000) -->



*  In generale invece, può essere opportuno *vincolare* in qualche modo *le possibili istanziazioni di `X`*, ad essere sottotipo di un tipo più specifico di `Object`
*  `class C<X extends D> { ... }`
    *  In tal caso, *dentro `C`, si potrà assumere che gli oggetti di tipo `X` rispondano ai metodi della classe `D`*
  




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


  
<!-- ### 3 tipi di wildcard (Igarashi \& Viroli, 2002) -->

  
### 3 tipi di wildcard



*  Bounded (covariante): `C<? extends T>`

    *  accetta un qualunque `C<S>` con `S <: T`

*  Bounded (controvariante): `C<? super T>`

    *  accetta un qualunque `C<S>` con `S >: T`
    
*  Unbounded: `C<?>`

    *  accetta un qualunque `C<S>`
  
 

  
### *Uso* delle librerie che dichiarano tipi wildcard



*  Piuttosto semplice: basta passare un argomento compatibile o si ha un errore a tempo di compilazione
  


  
### *Progettazione* di librerie che usano tipi wildcard



*  Molto avanzato: le wildcard pongono limiti alle operazioni che uno può eseguire, derivanti dal principio di sostituibilità (!)




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


Def. semplificata: un linguaggio OO è **safe** nessuna combinazione di istruzioni porta a poter invocare un metodo su un oggetto la cui classe non lo definisce

*  È necessario che il subtyping segua il principio di sostituibilità
*  Nell'esempio precedente: su un `Vector<Integer>` non possiamo invocare `addElement(String)`
    *  Quindi, non è vero che `Vector<Integer> <: Vector<Object>`

Più in generale, se non possono accadere errori a tempo di esecuzione..
  

  
### Java



*  Si pone dove possibile l'obiettivo della safety
  


  
### Generici e safety


*In generale, istanziazioni diverse di una classe generica sono scollegate*    

*  non c'è *__covarianza__*: non è vero che `C<T> <: C<S>` con `T <: S`
*  non c'è *__controvarianza__*: non è vero che `C<S> <: C<T>` con `T <: S`
  




---


## Unsafety con gli array di Java


  
### Gli *array di Java* sono trattati come *covarianti*!



*  Gli array assomigliano moltissimo ad un tipo generico
    *  `Integer[]` $\sim$ `Array<Integer>`, `T[]` $\sim$ `Array<T>`
*  E quindi sappiamo che non sarebbe safe gestirli con covarianza..
*  Ma invece in Java è esattamente così!! P.e. `Integer[] <: Object[]`
    * Perché? Le prime versioni di Java non avevano i generici; e dunque trattare gli array da invarianti (come i generici) avrebbe ridotto le possibilità di scrivere codice riusabile mediante polimorfismo (ad es. funzionalità su `Object[]` da applicare ad `Integer[]` etc.) 
    *  Quindi ogni scrittura su array potrebbe potenzialmente fallire....lanciando un `ArrayStoreException`
  


```java
{{% import-raw path="code/generics/Arrays.java" %}}
```


---


## Covarianza e operazioni di accesso

{{% smaller %}}
  
### La covarianza (`C<T> <: C<S>` con `T <: S`) sarebbe ammissibile se:



*  La classe `C<X>` non avesse operazioni che ricevono oggetti `X`
*  Ossia, ha solo campi privati e nessun metodo con argomento `X`
*  Esempio di non ammissibilità: `Vector<X>` con metodo `addElement(X)` .. in quanto per poter sostituire a un `Vector<Number>` un `Vector<Integer>` dovremmo supportare l'aggiunta di `Number` qualsiasi al vettore di interi
  


  
### La controvarianza (`C<S> <: C<T>` con `T <: S`) sarebbe ammissibile se:



*  La classe `C<X>` non avesse operazioni che producono oggetti `X`
*  Ossia, ha solo campi privati e nessun metodo con tipo di ritorno `X`
*  Esempio di non ammissibilità: `Vector<X>` con metodo `X first()` .. in quanto per poter sostituire un `Vector<Number>` a un `Vector<Integer>` dovremmo supportare la restituzione di un `Integer` anche per vettori di `Double`
  


  
### In pratica:



*  La maggior parte delle classi generiche `C<X>` hanno campi di tipo `X` (composizione) e operazioni getter e setter, e quindi per loro covarianza e controvarianza non funzionano
    * Come nel caso di `Vector<X>`
*  Con le wildcard si aumenta il riuso dei metodi che non usano tutte le funzioni (che collettivamente porterebbero a invarianza) del tipo generico in input
  

{{% /smaller %}}


---



## Esempio Wildcard Bounded covariante: `C<? extends T>`

* Visto che `printAll(Vector<X extends Number>)` usa solo `X getElementAt(int)`, l'input può essere covariante

```java
{{% import-raw path="code/generics/variance/Cov.java" %}}
```


---


## Esempio Wildcard Bounded controvariante: `C<? super T>`

* Visto che `addStrings(Vector<X super String>)` usa solo `addElement(X)`, l'input può essere controvariante


```java
{{% import-raw path="code/generics/variance/Contra.java" %}}
```


---


## Esempio Wildcard Unbounded: `C<?>`

* Visto che `printLength(Vector<X>)` usa solo `int getLength()`, l'input può essere bivariante <!-- covariante rispetto `Vector<Object>` -->

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

# Collezioni generiche (avanzate)

{{% import path="front-page.md" %}}
