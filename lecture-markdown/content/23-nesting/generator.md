
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/advanced-mechanisms-nesting/", "nesting"]

+++

# Classi innestate

{{% import path="front-page.md" %}}

---

# Classi innestate statiche

---

## Classi innestate statiche -- idea e terminologia

  
### Principali elementi



*  Dentro una classe `A`, chiamata *__outer__* è possibile innestare la definizione di un'altra classe `B`, chiamata *__innestata (statica)__* -- in inglese, *__static nested__*
*  `B` viene quindi vista come se fosse una proprietà `statica` di `A`
    * richiamabile via `A`, come le `new` e le chiamate statiche



```java
// situazione di partenza
class A {...}
class B {...}
```

```java
// modifica, usando le inner class
class A {
    ...
    static class B { .. }
}
```

---

## Classi innestate statiche -- casistica

### Possibilità di innestamento

*  Anche una interfaccia può fungere da `Outer`
*  Si possono innestare anche interfacce
*  Il nesting può essere multiplo e/o *multilivello*
*  L'accesso alle classi/interfacce innestate statiche avviene con sintassi `Outer.A`, `Outer.B`, `Outer.I`, `Outer.A.C`

```java
class Outer {
    ...
    static class A { ... static class C { ... } ... }
    static class B { ... }
    interface I { ... } // static è implicito nelle interfacce
}
```

---

## Classi innestate statiche -- accesso

### Uso

*  L'accesso alle classi/interfacce innestate statiche avviene con sintassi `Outer.StaticNested`
    * ovvero, come se fosse un membro statico della classe
*  Da dentro `Outer` si può accedere anche direttamente con `StaticNested`
*  L'accesso da fuori `Outer` di `StaticNested` segue le regole del suo modificatore d'accesso
*  *Esterna e interna si vedono a vicenda anche le proprietà `private`*
  

```java
class Outer {
    ...
    static class StaticNested { 
       ...
    }
}
..
Outer.StaticNested obj = new Outer.StaticNested(...);
```

---

## Motivazioni

### Una necessità generale

Vi sono situazioni in cui per risolvere un singolo problema è opportuno generare più classi, e non si vuole affiancarle solo come classi dello stesso package

### Almeno tre motivazioni (non necessariamente contemporanee)

1.  *Evitare il proliferare di classi* in un package, specialmente quando solo una di queste debba essere pubblica
2.  Migliorare l'*incapsulamento*, con un meccanismo per consentire un accesso locale anche a proprietà `private`
3.  Migliorare la *leggibilità*, inserendo classi là dove serve (con *nomi qualificati*, quindi più espressivi)

---

## Esempio: specializzazioni come classi innestate

* La classe astratta, o comunque base, è la outer
* Alcune specializzazioni ritenute frequenti e ovvie vengono innestate, ma comunque rese pubbliche
* due implicazioni: 
    * schema di nome delle inner class
    * possibilità di accedere alle proprietà statiche

### Note

* Un'indicazione che sia opportuno usare classi innestate è la presenza di nomi composti da una parte comune
* Ad esempio:
    * `Counter` che modella un contatore
    * `BidirectionalCounter`, sempre un contatore, ma che può incrementare di più step alla volta
    * `MultiCounter`, sempre un contatore, ma che conta anche all'indietro

---

## Classe `Counter` e specializzazioni innestate

```java
{{% import-raw from=1 to=100 path="pss-code/src/main/java/it/unibo/nested/Counter.java" %}}
```

---

## Uso di `Counter` e specializzazioni innestate


```java
{{% import-raw path="pss-code/src/main/java/it/unibo/nested/UseCounter.java" %}}
```

---

## Esempio: implementazione interna di una classe separata

In una classe potrebbero servire sotto-comportamenti che debbano:
implementare una data interfaccia o estendere una data classe,
ma che *non vogliamo esporre come classi esterne*

* Per esempio, il concetto di `Range`, un `Iterable` che deve quindi produrre un  `Iterator`
    * Non vogliamo esporre il nostro concetto di `RangeIterator` pubblicamente
    * Vogliamo che sia incapsulato dentro `Range`

Spesso classi di questo tipo non devono essere visibili dall'esterno, quindi vengono indicate come `private`

---

## Classe `Range` e suo `RangeIterator` innestato

```java
{{% import-raw from=5 path="pss-code/src/main/java/it/unibo/nested/RangeNested.java" %}}
```

---

## Esempio tratto dal Collection Framework

* `Map`, `Map.Entry`
* una mappa è "osservabile" come set di entry, ossia come collezione di coppie chiave-valore

```java
{{% import-raw from=1 to=100 path="code/advanced-mechanisms/short/Map_.java" %}}
```

---

## Riassunto classi innestate statiche

### Principali aspetti

*  Da fuori (se pubblica) vi si accede con nome `Outer.StaticNested`
*  `Outer` e `StaticNested` sono co-locate: si vedono le proprietà `private`

### Motivazione generale
*  
* Voglio evitare la proliferazione di classi nel package
*  Voglio sfruttare l'incapsulamento

### Motivazione per il caso `public`

* Voglio enfatizzare i nomi `Out.C1`, `Out.C2`,..

### Motivazione per il caso `private` -- è il caso più frequente

*  Voglio realizzare una classe a solo uso della outer, invisibile all'esterno (incapsulato)

---

## `Map.Entry`

### Ruolo di `Map.Entry`
*  
* Una mappa può essere vista come una collezione di coppie chiave-valore, ognuna incapsulata in un `Map.Entry`
*  Quindi, una mappa è composta da un set di `Map.Entry`

```java
{{% import-raw from=1 to=100 path="code/advanced-mechanisms/short/Map_2.java" %}}
```

---


# Inner Class

---

## Inner Class -- idea

### Principali elementi

*  Dentro una classe `Outer`, è possibile innestare la definizione di un'altra classe `InnerClass`, senza indicazione `static`
*  `InnerClass` è vista come se fosse una proprietà *__non-statica__* di `Outer` al pari di altri campi o metodi
*  L'effetto è che una istanza di `InnerClass` ha sempre un riferimento ad una istanza di `Outer` (enclosing instance) che ne rappresenta il *__contesto__*, accessibile con la sintassi `Outer.this`, e ai suoi campi (privati) 
  

```java
class Outer {
    ...
    class InnerClass { // Nota.. non è static!
        ...
        // ogni oggetto di InnerClass avrà un riferimento ad
        // un oggetto di Outer, denominato Outer.this
    }
}
```


---

## Un semplice esempio

  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/nested/Outer.java" %}}
```

---

## Uso di `Inner` e `Outer`

```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/nested/UseOuter.java" %}}
```

---

## Enclosing instance -- istanza esterna

### Gli oggetti delle inner class

*  Sono creati con espressioni: `<obj-outer>.new <classe-inner>(<args>)`
*  (la parte `<obj-outer>` è omettibile quando sarebbe `this`)
*  Possono accedere all'enclosing instance con notazione `<classe-outer>.this`
* 
### Motivazioni: quelle relative alle classi innestate statiche, ma:
*  è necessario che ogni oggetto inner tenga un riferimento all'oggetto outer
*  pragmaticamente: usato quasi esclusivamente il caso `private`

### Esempio

* La classe `Range` già vista usa una static nested class
    * Se fosse inner, avrebbe accesso diretto a `start` e `stop` tramite l'*enclosing instance*!

---

## Una variante di `Range`

```java
{{% import-raw from=5 path="pss-code/src/main/java/it/unibo/nested/RangeInner.java" %}}
```

---

# Classi locali

---

## Classi locali -- idea

### Principali elementi

* *Dentro un metodo* di una classe `Outer`, è possibile innestare la definizione di un'altra classe `LocalClass`
* La `LocalClass` è a tutti gli effetti una inner class (e quindi ha enclosing instance)
    * Non è possibile creare classi `static` locali (innestate in un metodo)
* In più, la `LocalClass` "vede" anche le variabili nello scope del metodo in cui è definita, *__usabili solo se `final`__*
    * o se "effectively final", ossia il compilatore può verificare che non vengano mai modificate dopo l'inizializzazione

```java
class Outer {
    // ...
    void m(final int x){
        final String s = /* ... */;
        class LocalClass { // Nota.. non è static!
            // ... può usare Outer.this, s e x
        }
        LocalClass c = new LocalClass(...);
    }
}
```

---

## `Range` tramite classe locale

```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/nested/RangeLocalClass.java" %}}
```

---

## Classi locali -- motivazioni

### Perché usare una classe locale invece di una inner class

* Tale classe è *necessaria solo dentro ad un metodo, e lì la si vuole confinare*
* È eventualmente utile accedere anche alle variabili del metodo

### Pragmaticamente
* Spesso usate "spot" in un solo punto
* Difatti, il nome praticamente viene usato solo per invocare una volta il costruttore
* Sarebbe comodo poter evitare di assegnare un nome da usare una sola volta, costruendo direttamente l'oggetto

---

# Classi anonime

---

## Classi anonime -- idea
  
### Principali elementi
* Con una variante dell'istruzione `new`, è possibile innestare la definizione di un'altra classe senza indicarne il nome
    * In tale definizione non possono comparire costruttori
* Viene creata al volo una classe locale, e da lì se ne crea un oggetto
    * Tale oggetto, come per le classi locali, ha enclosing instance e "vede" anche le variabili `final` (o di fatto finali) nello scope del metodo in cui è definita

```java
class C {
    // ...
    Object m(final int x) {
        return new Object() {
             public String toString() { return "Valgo " + x; }
        }
    }
}
```

* In pratica, una local class, ma senza nome, e con un solo oggetto istanziato.

---

## `Range` tramite classe anonima -- la soluzione ottimale
  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/nested/RangeAnonymous.java" %}}
```

---

## Altro esempio: classe anonima da  `Comparable`

```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/nested/UseSort.java" %}}
```

---

## Classi anonime -- motivazioni

### Perchè usare una classe anonima?
*  Se ne deve creare un solo oggetto, quindi è inutile anche solo nominarla
*  Si vuole evitare la proliferazione di classi
*  Tipicamente: per implementare "al volo" una interfaccia

### Pragmaticamente

* Spesso queste classi anonime hanno un solo metodo astratto!
* Di fatto, è come se implementassimo solo quel metodo "al volo"
* Tutta la struttura di contorno è solo "cerimonia"

---

# Espressioni Lambda

---

- Una **lambda expression** è una *funzione anonima*, creata "al volo"
    - internamente implementata come *istanza* di un'**interfaccia funzionale** (un'interfaccia che definisce un solo metodo astratto)
    - di fatto, è una sintassi più compatta per creare istanze di classi anonime con un solo metodo astratto


```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/nested/UseSortLambda.java" %}}
```

---

## Riassunto e linee guida

### Inner class (e varianti)


Utili quando si vuole isolare un sotto-comportamento in una classe a sé, senza dichiararne una nuova che si affianchi alla lista di quelle fornite dal package, ma stia "dentro" una classe più importante
    

    
### Se deve essere visibile alle altre classi



*  Quasi sicuramente, una static nested class
    


    
### Se deve essere invisibile da fuori



*  Si sceglie uno dei quattro casi a seconda della visibilità che la inner class deve avere/dare
    1.  *static nested class*: solo parte statica
    2.  *inner class*: anche enclosing class, accessibile ovunque dall'outer
    3.  *local class*: anche argomenti/variabili, accessibile da un solo metodo
    4.  *anonymous class*: per creare un oggetto, senza un nuovo costruttore

---

# Classi innestate

{{% import path="front-page.md" %}}