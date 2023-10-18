
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/intro-agile-sw-design-patterns/"]

+++

# Introduzione alla progettazione efficace ed agile del software

{{% import path="front-page.md" %}}

## Outline


  
### Goal della lezione



* Riassumere i concetti, principi, meccanismi visti in precedenza
* Introdurre le basi della *progettazione del software*
* Introdurre le basi dell'*agile*
* Mostrare alcune applicazioni notevoli (*pattern*) dei concetti, principi, e meccanismi OO visti in precedenza
  

### Argomenti


* Introduzione ai *design pattern*
* *Architettura* e *design di dettaglio*
* *Agile software development*: cos'è, manifesto, principi
* Pattern *Strategy*
  

---


## Riassunto delle puntate precedenti

### Elementi di progettazione di sistemi software (OO)

- Programma vs. sistema software
- Fasi processo di sviluppo: analisi $\to$ design $\to$ implementazione $\to$ collaudo $\to$ deployment
- Problem space (dominio/logica business) vs. solution space (scelte realizzative)
    - concetto di *astrazione* e di "livello di astrazione"
- Riuso mediante
    - utilizzo di altri oggetti (*composizione*) 
    - estensione dei servizi offerti da altri oggetti (*ereditarietà*)
- Concetti di modularità, dipendenza, accoppiamento, coesione
- Metodologie
    - *test-driven development*

---

### Strumenti

- Java 17
    - *write once, run everywhere*
    - **JDK**: JRE (JVM [`java`] + JCL) + strumenti di sviluppo (`javac`, `jshell` ...)
- *Terminali* per l'accesso al file system e ai programmi da linea di comando
- Strumenti JDK: compilazione con `javac` ed esecuzione con `java`
    - concetto di *classpath*
- `gradle`: build system
    - plugin `java`, e blocco `dependencies`
- `git`: version control system
- `JUnit`: framework per lo unit testing
- *Visual Studio Code*: ambiente di sviluppo integrato (IDE)

---

### Java: elementi di base

 - Elementi di base
    - programmazione strutturata/imperativa (C-like)
    - *programma*: metodo pubblico statico `main` in classe pubblica
    - *tipi primitivi vs. tipi oggetto* (classi/interfacce)
    - variabili contengono i *riferimenti* ad oggetti (allocati nello *heap*)
        - assegnamento per copia del riferimento
    - oggetti allocati in memoria dinamica (heap) $\to$ lifetime di oggetti va oltre lo scope
        - no deallocazione manuale (cf. *GC*)

---

### Basi dell'OOP in Java

- Astrazione object-oriented
    - *oggetto = stato + comportamento + identità* (cf. *incapsulamento*)
        - interazione attraverso "scambio di messaggi" (in realtà: chiamate sincrone a metodi)
    - *classe* come "tipo" di oggetti e come "template" di costruzione di oggetti simili (*istanze*)
    - *interfaccia* vs. implementazione (cf. *information-hiding*)
 - Costrutti
    - dichiarazione `class`: contiene dichiarazione *campi*, *metodi* (statici o d'istanza), e costruttori
    - uso di oggetti: accesso a proprietà (metodi/campi) mediante _dot notation_
        - concetto di *receiver* di una *method call* e variabile speciale `this`
    - dichiarazione `interface`
    - modificatore `static` per codice *statico* (metodi/campi *di classe*)
    - *costruttori* e inizializzazione di oggetti
    - *overloading* di metodi e costruttori
    - *package* come namespace e contenitori di classi (cf. dichiarazione `package`) organizzati gerarchicamente
        - *FQCN (Fully-Qualified Class Name)*
        - `import` per importare i nomi delle classi in scope 
    - *controllo di accesso*: `public`, package-private, `private`
    - modificatore `final` per campi e variabili *costanti* (non modificabili)

---

### OOP efficace

- *Linee guida stilistiche* di formattazione di sorgenti Java (spaziature, nomi, etc.)
- **Incapsulamento**
    1. impacchettamento *dati* e *funzioni* per la loro manipolazione
    2. *information hiding*: interfaccia pubblica stabile (*contratto*) e dettagli implementativi privati 
- Uso **interfacce** per catturare astrazioni e contratti
- Varie
    - metodi getter e setter
    - oggetti *immutabili*

Competenza attuale attesa: costruzione di piccoli progetti software Java/Gradle, tracciati con controllo di versione (git), che realizzano ed esercitano (mediante programmi e test JUnit) semplici sistemi ad oggetti ben incapsulati


---

# Introduzione alla progettazione del software

---

## Richiamo: qualità interna vs. esterna



### Qualità *esterna* -- aspetti *funzionali*


* Realizza correttamente il suo compito
* In termini di quali funzionalità fornisce

### Qualità *esterna* -- aspetti *non-funzionali*

*  Performance adeguate (alle specifiche)
*  Uso efficiente/adeguato delle risorse del sistema (memoria, CPU)
*  Caratteristiche di sicurezza, affidabilità, usabilità, etc..


### Qualità *interna* -- software ben costruito

*  Facilmente manutenibile (leggibile, flessibile, riusabile)
    * quindi: meno "costoso", a breve-/medio-/lungo-termine

---

### Come promuovere la qualità interna del software?

- Regole di stile e formattazione dei sorgenti
- Principi e tecniche di programmazione/progettazione efficace
- Uso di pratiche come il TDD

### Il problema della **progettazione**

* Come organizzare in modo efficace un sistema OO (classi, interfacce, e relazioni tra queste) per ottenere la funzionalità e la qualità esterna desiderate?


---

## Progettazione del software

### Architettura

- **Architettura del software**: descrizione dei componenti principali e delle relazioni importanti tra questi
- esempio:
    - una applicazione `Calcolatrice` consiste in 3 componenti principali:
        1. interfaccia grafica (GUI)
        2. componente che realizza i calcoli matematici
        3. controller: parte che richiede i calcoli a fronte delle azioni dell'utente e chiede alla GUI di visualizzare il risultato
- approfondiremo questa parte più avanti

### Progettazione di dettaglio



* La **progettazione di dettaglio** descrive relazioni fra un insieme coeso di (tipi di) oggetti
    * le relazioni più significative di un particolare sottosistema
    * non descrive ogni singola classe/interfaccia del sistema
*  documentata da più diagrammi UML di 5-10 classi ognuno

---



# Agile software development

## Introduzione

Il software è il risultato di un *processo di sviluppo*

* Processi, pratiche, e strumenti incidono sulla qualità del software

Qui introduciamo una famiglia di processi e pratiche nota con il termine **agile**

---

## Agile software development (sviluppo agile del software)

- Lo **sviluppo agile del software** è un insieme di principi, pratiche, e metodi volti a *rispondere al cambiamento* 
    * cambiamento della comprensione del problema, dei requisiti, delle risorse...
- Si basa su approcci *iterativi/incrementali* a *cicli brevi* per *feedback frequente*, con focus su *qualità* attraverso pratiche/strumenti quali refactoring, pattern, ...

### Manifesto

[https://agilemanifesto.org/](https://agilemanifesto.org/)

"Stiamo scoprendo modi migliori di creare software,
sviluppandolo e aiutando gli altri a fare lo stesso.
Grazie a questa attività siamo arrivati a considerare importanti:

1. Gli **individui e le interazioni** più che i *processi e gli strumenti*
2. Il **software funzionante** più che la *documentazione esaustiva*
3. La **collaborazione col cliente** più che la *negoziazione dei contratti*
4. **Rispondere al cambiamento** più che *seguire un piano*

Ovvero, fermo restando il valore delle voci a destra,
consideriamo più importanti le voci a sinistra."

---

### Agile: principi 1-12

1. La nostra massima priorità è soddisfare il cliente
rilasciando software di valore, fin da subito
e in maniera continua.
2. *Accogliamo i cambiamenti nei requisiti,
anche a stadi avanzati dello sviluppo.
I processi agili sfruttano il cambiamento
a favore del vantaggio competitivo del cliente.*
3. Consegnamo frequentemente software funzionante,
con cadenza variabile da un paio di settimane a un paio di mesi,
preferendo i periodi brevi.
4. Committenti e sviluppatori devono lavorare insieme
quotidianamente per tutta la durata del progetto.
5. Fondiamo i progetti su individui motivati.
Diamo loro l'ambiente e il supporto di cui hanno bisogno
e confidiamo nella loro capacità di portare il lavoro a termine.
6. Una conversazione faccia a faccia
è il modo più efficiente e più efficace per comunicare
con il team ed all'interno del team.
7. *Il software funzionante è il principale metro di misura di progresso.*
8. I processi agili promuovono uno sviluppo sostenibile.
Gli sponsor, gli sviluppatori e gli utenti dovrebbero essere in grado
di mantenere indefinitamente un ritmo costante.
9. *La continua attenzione all'eccellenza tecnica
e alla buona progettazione esaltano l'agilità.*
10. La semplicità - l'arte di massimizzare la quantità
di lavoro non svolto - è essenziale.
11. Le architetture, i requisiti e la progettazione
migliori emergono da team che si auto-organizzano.
12. A intervalli regolari il team riflette su come
diventare più efficace, dopodiché regola e adatta
il proprio comportamento di conseguenza.

---



# Design Pattern e Progettazione di Dettaglio



---

## Come progettare una buona classe o gruppo di classi?



* buona conoscenza della *programmazione OO* 
    * incapsulamento, information hiding
    * polimorfismo
    * ereditarietà (che vedremo)
* buona conoscenza di *principi e pratiche di progettazione/programmazione efficace*
    * DRY (Don't Repeat Yourself), ...
    * astrazione attraverso interfacce, tecniche di riuso (composizione), ...
* utilizzo di cataloghi noti di pattern di progettazione (*design pattern*)





---





## Design Pattern


  
### I Pattern di progettazione

*  Un **pattern** è una *soluzione notevole a problemi ricorrenti di design object-oriented*  
    <!-- elementi riusabili (semplici ed eleganti) di progettazione OO -->
    * I problemi di "design" sono spesso ricorrenti
    * Progettisti esperti hanno nel tempo affrontato tali problemi, provato diverse soluzioni, fino ad ottenere soluzioni efficaci con chiara analisi di costi/benefici 
    * Tale "esperienza" è stata codificata in forma generica/riusabile in "pattern" che possono essere applicati in contesti simili
*  Alcuni sono particolarmente famosi, come quelli della *"Gang of Four"* (detti anche *Pattern GoF*)
    *  Testo famosissimo (in C++): *Design Patterns: Elements of Reusable Object-Oriented Software* di *E. Gamma, R. Helm, R. Johnson, J. Vlissides*
    *  23 in tutto. Esempi: Strategy, Decorator, Singleton, Template Method, Observer
    *  (Cit. "SW di grosse dimensioni li usano praticamente tutti")
* Benefici
    *  Il loro uso migliora molto il codice
        *  Rende il codice più flessibile (nascono per questo)
        *  Portano più direttamente ad una buona organizzazione (delle responsabilità, delle dipendenze, etc.)
    *  Fanno parte di un "vocabolario" per la comunicazione fra programmatori/progettisti

---


## Design Pattern in questa sede
  

  
### Nel corso

*  E' importante imparare quelli che introdurremo
*  E' opportuno applicarli nel progetto d'esame (e documentarli nella relazione)
    
### Per il vostro futuro

*  Noi porremo le basi per uno loro studio in autonomia
*  Un ottimo progettista li conosce e usa (ove opportuno) *__tutti__*




---


## Motivazione: qualità interna, refactoring, agilità

* E' importante conoscere e cercare di applicare i pattern in quanto:
    * promuovono la *qualità interna* del software
    * promuovono l'*agilità* attraverso software di qualità 
    * permettono di velocizzare l'attività di *refactoring*
    
---

### Rifattorizzazione (**refactoring**)

*  Operazione di modifica del codice che *non aggiunge funzionalità*
*  Ha lo scopo di *migliorare la qualità interna del SW*
    * la sua formattazione, la sua espressività semantica (cf. nomenclatura), la sua struttura
* Ha lo scopo di attrezzare il codice a possibili cambiamenti futuri (cf. *agilità*)
    * Può/deve quindi comportare una riprogettazione di alcune parti
* Il refactoring è una pratica necessaria
    *  Una buona progettazione non la si ottiene al primo "colpo", ma richiede vari refactoring
    *  Brian Foote identifica tre fasi nello sviluppo di un sistema: "prototyping", "expansionary", "consolidating"; nel consolidamento si rifattorizza

### Il refactoring è supportato da test e pattern

* I *test automatici* permettono di verificare se un refactoring ha introdotto regressioni
* I *design pattern* forniscono direttamente "ricette" di buona costruzione o rifattorizzazione del SW


<!--

### Agilità

* Si vuole rendere il software *agile*, ovvero in grado di rispondere facilmente al cambiamento (nuovi requisiti, ...)
*  Nell'*agile programming*, ogni ciclo di sviluppo non parte se non si è rifattorizzato il codice del ciclo precedente (sia in cicli corti che lunghi) 

-->

---



## Struttura di un "pattern"


    
### Un Pattern ha quattro elementi fondamentali



1.  Un **nome**. 
    * È un aspetto fondamentale! Entra a far parte di un *vocabolario*
2.  Un **problema** che risolve.
    * La causa che porta al suo uso
    * Include il *contesto* di applicazione del pattern
3.  La **soluzione** che propone. 
    * gli *elementi* del design e le loro *responsabilità*, *relazioni* con altri elementi, e *collaborazioni*
4.  La **conseguenza** che porta. 
    * *risultati* e *vincoli* (ad es. in termini di riuso, variabilità, performance, ...)
    * il risultato è spesso un *trade-off*
    * la scelta di applicare un pattern è questione di *costi-benefici*
    

<!--
    
### Granularità

*  Gruppo ristretto di (1-5) oggetti/classi generali dipendenti fra loro
*  Sistemi più specifici o più complessi sono utili, ma non propriamente dei "Pattern"
    *  Non singole classi riusabili (liste, hash-table)
    *  Non "pattern architetturali" (come MVC)
    *  Non framework complessi (gerarchia Swing, Reflection)
	
-->
    




---








## Classificazione dei Pattern: categorie


    
### Livello "proposito del Pattern"



*  **Creazionali**: Riguardano la creazione degli oggetti
*  **Strutturali**: Riguardano la composizione di classi/oggetti
*  **Comportamentali**: Riguardano la interazione e distribuzione di responsabilità fra classi/oggetti
    


    
### Livello "scope"



*  **Classi**: Il Pattern riguarda primariamente le relazioni fra classi (e sottoclassi), e quindi tratta aspetti *statici* (compile-time)
*  **Oggetti**: Il Pattern riguarda primariamente le relazioni fra oggetti (l'esistenza di riferimenti fra oggetti), e quindi tratta aspetti *dinamici* (run-time)
    




---


## I 23 Pattern GoF


    
### Creazionali



*  A livello di classe: *__Factory Method__*
*  A livello di oggetto: *__Abstract Factory__*, *__Builder__*, Prototype, *__Singleton__*
    


    
### Strutturali



*  A livello di classe: *__Adapter__*
*  A livello di oggetto: *__Adapter__*, Bridge, Composite, *__Decorator__*, Facade, Proxy
    


    
### Comportamentali



*  A livello di classe: Interpreter, *__Template Method__*
*  A livello di oggetto: Chain of Responsibility, Command, *__Iterator__*, Mediator, Memento, Flyweight, *__Observer__*, State, *__Strategy__*, *__Visitor__*
    




---


## Schema di descrizione per ogni pattern


    
Aderiremo al seguente schema, che è una semplificazione di quello proposto alla GoF

    
### Ingredienti



*  Descrizione in prosa (nome, motivazione, esempi, soluzione)
*  Rappresentazione grafica (diagramma delle classi generale)
*  Esempio (già visto/nuovo)
    


<!--

## I pattern nel corso

    
### Esami di progetto


*  Identificarne/usarne "pochi" è considerato poco soddisfacente
*  Scegliere di usarli non è arbitario, ma è indice di buona progettazione e/o di buona rifattorizzazione
*  Gli argomenti: "in questo progetto non servivano" e "non c'è stato tempo" sono pessimi
*  Argomento di probabile discussione all'esame

    
### Di conseguenza



*  I pattern qui presentati vanno conosciuti
*  Gli altri pattern sono facoltativi, e importanti per il vostro futuro
    

-->


---


# Alcuni pattern iniziali


---


## Strategy: comportamentale, su oggetti


    
### Intento/motivazione


Definisce una famiglia di algoritmi, e li rende interscambiabili, ossia usabili in modo trasparente dai loro clienti
    

    
### Esempi


*  Strategie di confronto fra due elementi per sorting (`Comparable`)
*  Strategia di disposizione di componenti in una GUI (`LayoutManager`)
*  Strategie di `map`, `filter`, etc.. negli `Stream`
    


    
### Soluzione



*  Gli algoritmi sono realizzati tramite specializzazioni di una classe/interfaccia base
*  Ai clienti passo un oggetto (di una specializzazione) dell'interfaccia base
<!-- *  Se la strategia è funzionale si usano facilmente le lambda (e viceversa) -->

*__È probabilmente uno dei pattern più importanti (assieme al Factory Methods)__*
    




---


## Strategy: UML


<!-- ![](imgs/strategy.jpg) -->

![](imgs/pattern-strategy.png)


---


## Strategy: Sorting con comparatori


<!--    \sizedrangedcode{\ssmall}{5}{100}{\ecl/strategy/UseComparator.java} -->

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/strategy/person/PersonCompareStrategy.java" %}}
```

---

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/strategy/person/PersonComparatorByAge.java" %}}
```


```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/strategy/person/PersonComparatorByFullName.java" %}}
```

---

{{% smaller %}}

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/strategy/person/UsePersons.java" %}}
```

{{% /smaller %}}

---

### Esempio: UML

<div class="container">
<div class="col">

![](imgs/pattern-strategy.png)

</div>
<div class="col">

![](imgs/pattern-strategy-example.png)

</div>
</div>


---

### Analisi

<div class="container">
<div class="col">

![](imgs/pattern-strategy-example.png)

</div>
<div class="col">

* `UsePersons` è il *contesto* della strategia
* `UsePersons` vuole ordinare un array di `Person`, ma *astrae* dalla strategia impiegata per il confronto
* `UsePersons` si occupa di fornire il *sotto-contesto* alla strategia, che in questo caso è dato da una coppia di `Person` da confrontare
* Le diverse implementazioni della strategia usano il sotto-contesto diversamente: `PersonComparatorByFullName` si basa su nome/cognome, mentre `PersonComparatorByAge` si basa sull'anno di nascita
* Il design è *aperto* all'introduzione di altre strategie (ad esempio: in base a tratti fisici come l'altezza), ma *il contesto rimarrà invariato*!

</div>
</div>

---

## I pattern "factory"

- I pattern **"factory"** caratterizzano delle organizzazioni di codice OO al fine di gestire il modo con cui viene stabilito *quali classi istanziare*
    - 2 pattern semplici: **Static Factory** e **Simple Factory**
    - 2 pattern GOF: **Abstract Factory**, **Factory Method**
    - Varie varianti sono possibili...
    - ...Noi ne illustreremo una che è a metà tra Abstract Factory e Factory Method
    - ...Che può essere anche vista come un'applicazione dello **Strategy** dove strategie concrete stabiliscono quali classi istanziare

---

### Esempio motivante: `SimpleLamp`, `AdvancedLamp`, `TwoLampsDevice`

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/Lamp.java" %}}
```

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/AdvancedLamp.java" %}}
```

```java
public class TwoLampsDevice {
    Lamp lamp1, lamp2;
    public TwoLampsDevice() {
        lamp1 = /* ??? */;
        lamp2 = /* ??? */;
    }
}
```

---

{{% smaller %}}

<div class="container">
<div class="col">

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/SimpleLampImpl.java" %}}
```

</div>
<div class="col">

```java
{{% import-raw from=3 to=42 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/AdvancedLampImpl.java" %}}
```

</div>
</div>

{{% /smaller %}}

---

<div class="container">
<div class="col">

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/TwoLampsDeviceNaive.java" %}}
```

</div>
<div class="col">

* In questo esempio, `TwoLampsDeviceNaive` prende subito una decisione sulle `Lamp` concrete da comporre 
* Idealmente però, la nostra `TwoLampsDevice` dovrebbe astrarre dall'implementazione concreta delle `Lamp`
    * potrebbe consistere di due `SimpleLamp`, di due `AdvancedLamp`, o di un mix delle due..
* Obiettivo: rifattorizzare per 
    1. rendere `TwoLampsDevice` più **generale** (*supportare varie composizioni*)
    2. *eliminare la **dipendenza** dalle classi concrete*
    3. *rimuovere (spostare altrove) la **responsabilità** di scegliere le implementazioni concrete* 

</div>
</div>

---


### Static Factory


{{% smaller %}}

<div class="container">
<div class="col">

```java
{{% import-raw from=3 to=26 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/TwoLampsDeviceWithStaticFactory.java" %}}
```

</div>
<div class="col">

```java
{{% import-raw from=3 to=42 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/LampFactoryModule.java" %}}
```

```java
{{% import-raw from=3 to=42 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/UseTwoLampsDeviceWithStaticFactory.java" %}}
```

</div>
</div>

{{% /smaller %}}


Benefici dei *metodi factory statici* (rispetto ad uso diretto dei costruttori)

* possono restituire oggetti di qualunque sottotipo del tipo di ritorno
* la classe da istanziare può variare a seconda dei parametri
* possono avere nomi espressivi a piacere
* permettono di superare la limitazione di poter avere un solo costruttore per una data signature

---

### Simple Factory

* Come Static Factory, ma il metodo è non statico e in una classe separata (anche chiamata *classe factory*)


### Altra soluzione

- Elementi della soluzione
    - Si introduce un'*interfaccia* per le possibili *factory*
    - Si inietta la factory concreta in un *contesto* ove occorre
    - Il contesto diventa riusabile rispetto a diverse factory (e quindi diversi prodotti istanziabili)

---



```java
{{% import-raw from=3 to=20 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/LampFactory.java" %}}
```

```java
{{% import-raw from=3 to=42 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/SimpleLampFactory.java" %}}
```

```java
{{% import-raw from=3 to=42 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/AdvancedLampFactory.java" %}}
```


---


<div class="container">
<div class="col">

```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/TwoLampsDevice.java" %}}
```

</div>
<div class="col">

```java
{{% import-raw from=3 to=42 path="pss-code/src/main/java/it/unibo/patterns/factory/domo/UseTwoLampsDevice.java" %}}
```

</div>
</div>


---

- Benefici
    - `TwoLampsDevice` può comporsi con diverse coppie di lampadine e lavorare con esse in modo uniforme senza dover variare il proprio codice (cf. polimorfismo)
    - `TwoLampsDevice` non dipende più da classi concrete, ma da oggetti di contratto `LampFactory`
- Un pattern tra Abstract Factory e Factory Method
    - Propriamente, Abstract Factory dovrebbe supportare una *famiglia di prodotti*
    - Propriamente, Factory Method richiederebbe che le classi che specializzano il metodo factory riusino il contesto

---

## Preview del prossimo laboratorio

- Consolidare l'uso di interfacce e composizione
- Sperimentare con pattern Strategy e Factory