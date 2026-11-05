
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/stream/"]

+++

# Stream

{{% import path="front-page.md" %}}


---


## Outline


  
### Goal della lezione



*  Mostrare la gestione funzionale degli Stream
*  Discutere altri aspetti relativi alle novità di Java 8
*  Riprendere i record per rappresentare dati negli esempi


---


# Stream

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



*  Data una `List<Person>` con proprietà reddito e città, ottenere la somma dei redditi di tutte le persone di Cesena
*  Come lo realizziamo tramite una pipeline?
    *  Sorgente: la lista
    *  Trasformazione 1: filtro sulle persone di Cesena
    *  Trasformazione 2: si mappa ogni persona sul suo reddito
    *  Terminazione: sommo
*  Aspetto cruciale: le fasi intermedie (dopo le trasformazioni), non generano collezioni temporanee
  




---


## Record: ripasso

* Un **record** è una classe pensata per rappresentare un insieme di valori
* È disponibile in forma stabile da Java 16
* I componenti si dichiarano nell'intestazione:

```java
record Person(String name, String city, double income, Set<String> jobs) {}

var person = new Person("Mario", "Cesena", 20000, Set.of("Teacher"));
IO.println(person.name()); // Mario
```

* Gli accessor si chiamano come i componenti: `name()`, `city()`, `income()`, `jobs()`
* `List` e `Set` appartengono al package `java.util`

---

## Cosa fornisce un record

Per il record `Person` Java genera:

* Un campo privato `final` e un accessor pubblico per ogni componente
* Un costruttore con tutti i componenti, nell'ordine dichiarato
* `equals`, `hashCode` e `toString` basati sui componenti

```java
var a = new Person("Mario", "Cesena", 20000, Set.of("Teacher"));
var b = new Person("Mario", "Cesena", 20000, Set.of("Teacher"));
IO.println(a.equals(b)); // true
```

---

## Record: validazione e immutabilità

Un **costruttore compatto** può verificare i valori:

```java
record Person(String name, String city, double income, Set<String> jobs) {
    Person {
        if (income < 0) {
            throw new IllegalArgumentException("Reddito negativo");
        }
        jobs = Set.copyOf(jobs);
    }
}
```

* I riferimenti ai componenti non cambiano, ma gli oggetti riferiti possono essere mutabili
* `Set.copyOf` crea una copia immutabile delle professioni

---

## Record e Stream: i dati

Usiamo il record `Person` per rappresentare le persone della pipeline:

```java
List<Person> people = List.of(
    new Person("Mario", "Cesena", 20000, Set.of("Teacher")),
    new Person("Rino", "Forlì", 50000, Set.of("Professor")),
    new Person("Lino", "Cesena", 110000, Set.of("Professor", "Dean")),
    new Person("Ugo", "Cesena", 20000, Set.of("Secretary")),
    new Person("Marco", null, 4000, Set.of("Contractor"))
);
```

---

## Record e Stream: la pipeline

```java
double totalIncome = people.stream()
    .filter(p -> "Cesena".equals(p.city()))
    .mapToDouble(Person::income)
    .sum();

IO.println(totalIncome); // 150000.0
```

* `filter` seleziona le persone di Cesena
* `mapToDouble` estrae il reddito usando l'accessor del record
* `sum` termina la pipeline sommando i redditi



---


## La libreria degli Stream


  
### Struttura



*  Package `java.util.stream`: interfacce e classi per gli stream
*  Interfaccia `Stream<X>`: stream e metodi statici di "factory"
*  Interfaccia `BaseStream<X,B>`: sopra-interfaccia di `Stream` con i metodi base
*  Interfaccia `DoubleStream`: stream di `double`, con metodi base e specifici
*  Interfacce `IntStream`, `LongStream`: simili
*  Interfaccia `Collector<T,A,R>`: rappresenta una operazione di riduzione
*  Classe `Collectors`: fornisce una serie di collettori
*  ..altre classi di Java creano degli stream
  




---


## Le collection generano Stream!


    
```java
{{% import-raw from=1 to=100 path="code/streams/Collection.java" %}}
```



---


## L'interfaccia `java.util.BaseStream`


    
```java
{{% import-raw from=1 to=100 path="code/streams/BaseStream.java" %}}
```



---


## Riassunto delle funzionalità di una pipeline per `Stream<X>`


    
### Creazione



*  `empty`, `of`, `iterate`, `generate`, `concat`
    


    
### Trasformazione



*  `filter`, `map`, `flatMap`, `distinct`, `sorted`, `peek`, `limit`, `skip`, `mapToXYZ`,..
    


    
### Terminazione



*  `forEach`, `forEachOrdered`, `toArray`, `reduce`, `collect`, `min`, `max`, `count`, `anyMatch`, `allMatch`, `noneMatch`, `findFirst`, `findAny`,..
    


    
### Una nota sulle classi `DoubleStream` e simili



*  sono più specializzate e performanti, non avendo il boxing
*  non hanno tutte le funzionalità di cui sopra, se vi servono vi dovete riportare ad un `Stream<X>` con un trasformatore `mapToObj()` o `boxed()`
*  ne hanno qualcuna in più specifica, ad esempio `sum`
    




---



## `java.util.Stream`: costruzione stream, 1/3


    
```java
{{% import-raw from=1 to=26 path="code/streams/Stream.java" %}}
```



---


## `java.util.Stream`: trasformazione stream, 2/3


    
```java
{{% import-raw from=26 to=45 path="code/streams/Stream.java" %}}
```



---


## `java.util.Stream`: terminazione stream, 3/3


    
```java
{{% import-raw from=46 to=100 path="code/streams/Stream.java" %}}
```



---


## Trasformazioni di Stream: esempi


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/streams/UseTransformations.java" %}}
```



---


## Trasformazioni di Stream: esempi pt.2


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/streams/UseTransformations2.java" %}}
```



---


## Creazione di Stream: esempi


    
```java
{{% import-raw from=6 to=100 path="pss-code/src/main/java/it/unibo/streams/UseFactories.java" %}}
```



---


## Creazione di Stream: esempi pt.2


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/streams/UseFactories2.java" %}}
```



---


## Creazione di Stream: file di testo e stringhe


    
```java
{{% import-raw from=6 to=100 path="pss-code/src/main/java/it/unibo/streams/UseOtherFactories.java" %}}
```



---


## Terminazioni ad-hoc di Stream: esempi


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/streams/UseTerminations.java" %}}
```



---


## Terminazione generalizzata con `Stream.collect`


    
```java
{{% import-raw from=6 to=100 path="pss-code/src/main/java/it/unibo/streams/UseGeneralizedCollectors.java" %}}
```



---


## Collettori di libreria: la classe `Collectors`


    
```java
{{% import-raw from=1 to=100 path="code/streams/Collectors.java" %}}
```



---


## `UseCollectors`: collettori di base


    
```java
{{% import-raw from=4 to=100 path="pss-code/src/main/java/it/unibo/streams/UseCollectors.java" %}}
```



---


## `UseCollectors`: collettori di base pt 2


    
```java
{{% import-raw from=4 to=100 path="pss-code/src/main/java/it/unibo/streams/UseCollectors2.java" %}}
```



---


## Esempi avanzati su `Person`

```java
String jobsInCesena = people.stream()
    .filter(p -> "Cesena".equals(p.city()))
    .flatMap(p -> p.jobs().stream())
    .distinct()
    .collect(Collectors.joining("|", "[[", "]]"));
IO.println(jobsInCesena);
```

---

## Esempi avanzati su `Person`: media

```java
double average = people.stream()
    .filter(p -> p.jobs().contains("Professor"))
    .mapToDouble(Person::income)
    .average()
    .orElseThrow();
IO.println(average); // 80000.0
```



---

  
## Algoritmi funzionali -- cosa realizzano?


    
```java
{{% import-raw from=7 to=100 path="pss-code/src/main/java/it/unibo/streams/UseStreamsForAlgorithms.java" %}}
```

---

# Stream

{{% import path="front-page.md" %}}
