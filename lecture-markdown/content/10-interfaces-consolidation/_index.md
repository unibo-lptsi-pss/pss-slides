
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/interfaces-consolidation/"]

+++

# Consolidamento su incapsulamento e interfacce

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
- Varie
    - metodi getter e setter
    - oggetti *immutabili*

Competenza attuale attesa: costruzione di piccoli progetti software Java/Gradle, tracciati con controllo di versione (git), che realizzano ed esercitano (mediante programmi e test JUnit) semplici sistemi ad oggetti ben incapsulati


---

# Introduzione alla progettazione del software


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

### Il problema della progettazione

* Come organizzare efficaciemente un sistema OO (classi, interfacce, e relazioni tra queste) per ottenere la funzionalità e la qualità esterna desiderate?


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


# Design Pattern e Progettazione di Dettaglio



---

## Come progettare una buona classe o gruppo di classi?



* buona conoscenza della programmazione OO 
    * incapsulamento, information hiding
    * polimorfismo
    * ereditarietà (che vedremo)
* buona conoscenza di principi e pratiche di progettazione/programmazione efficace
    * DRY (Don't Repeat Yourself), ...
    * astrazione attraverso interfacce, tecniche di riuso (composizione), ...
* utilizzo di cataloghi noti di pattern di progettazione (design pattern)





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
*  E' opportuno applicarli nel progetto d'esame (e nella relazione)
    
### Per il vostro futuro

*  Noi porremo le basi per uno loro studio in autonomia
*  Un ottimo progettista li conosce e usa (ove opportuno) *__tutti__*




---


## Motivazione: qualità interna, refactoring, agilità

* E' importante conoscere e cercare di applicare i pattern in quanto:
    * promuovono la *qualità interna* del software
    * permettono di velocizzare l'attività di *refactoring*
    
### Rifattorizzazione (**refactoring**)

*  Operazione di modifica del codice che *non aggiunge funzionalità*
*  Ha lo scopo di *migliorare la qualità interna del SW*
    * la sua formattazione, la sua espressività semantica (cf. nomenclatura), la sua struttura
* Ha lo scopo di attrezzare il codice a possibili cambiamenti futuri (cf. *agilità*)
    * Può/deve quindi comportare una riprogettazione di alcune parti
* Il refactoring è una pratica necessaria
    *  Una buona progettazione non la si ottiene al primo "colpo", ma richiede vari refactoring
    *  Brian Foote identifica tre fasi nello sviluppo di un sistem: "prototyping", "expansionary", "consolidating"; nel consolidamento si rifattorizza

### Agilità

*  Si vuole rendere il software *agile*, ovvero in grado di rispondere facilmente al cambiamento
*  Nell'*agile programming*, ogni ciclo di sviluppo non parte se non si è rifattorizzato il codice del ciclo precedente (sia in cicli corti che lunghi)


I design pattern forniscono direttamente "ricette" di buona costruzione o rifattorizzazione del SW
    
---

## Agile software development (sviluppo agile del software)

### Manifesto

[https://agilemanifesto.org/](https://agilemanifesto.org/)

Stiamo scoprendo modi migliori di creare software,
sviluppandolo e aiutando gli altri a fare lo stesso.
Grazie a questa attività siamo arrivati a considerare importanti:

1. Gli **individui e le interazioni** più che i *processi e gli strumenti*
2. Il **software funzionante** più che la *documentazione esaustiva*
3. La **collaborazione col cliente** più che la *negoziazione dei contratti*
4. **Rispondere al cambiamento** più che *seguire un piano*

Ovvero, fermo restando il valore delle voci a destra,
consideriamo più importanti le voci a sinistra.

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



*  *Creazionali*: Riguardano la creazione degli oggetti
*  *Strutturali*: Riguardano la composizione di classi/oggetti
*  *Comportamentali*: Riguardano la interazione e distribuzione di responsabilità fra classi/oggetti
    


    
### Livello "scope"



*  *Classi*: Il Pattern riguarda primariamente le relazioni fra classi (e sottoclassi), e quindi tratta aspetti *statici* (compile-time)
*  *Oggetti*: Il Pattern riguarda primariamente le relazioni fra oggetti (l'esistenza di riferimenti fra oggetti), e quindi tratta aspetti *dinamici* (run-time)
    




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



<!--

## Singleton: creazionale, su oggetti


    
### Intento/motivazione


	Garantire che una classe abbia una unica istanza, accessibile globalmente e facilmente a molteplici classi, senza doversi preoccupare di fornirne il riferimento a chi lo richiede (ad esempio passandolo al costruttore)
    

    
### Esempi



*  Un unico gestore di stampanti in un sistema
*  Un unico gestore del "log"
*  `java.lang.Runtime`
    


    
### Soluzione



*  La classe sia responsabile di tenere traccia di tale unica istanza
*  La classe impedisca la creazione di altri oggetti
*  La classe fornisca l'accesso a tale oggetto staticamente
*  Attenzione: singleton accoppia clienti e implementazione
    




---


## Singleton: UML


![](img/singleton.jpg)


---


## Singleton: Il caso di `java.lang.Runtime`


    \sizedrangedcode{\scriptsize}{3}{100}{\ecl/singleton/UseRuntime.java}


---


## Singleton: Il caso di una classe `Log`


    \sizedrangedcode{\scriptsize}{3}{100}{\ecl/singleton/Log.java}
    \sizedrangedcode{\scriptsize}{3}{100}{\ecl/singleton/UseLog.java}


---


## Singleton: conseguenze


    
### Effetti benefici



*  C'è un controllo "incapsulato" di chi vi accede
*  Evita di dover portare i riferimenti all'oggetto nei campi di tutti le classi che lo usano
*  È facile raffinare l'implementazione del singleton (via subclassing)
*  Può gestire la creazione by-need (detta anche *lazy*) dell'oggetto
*  Più flessibile dei metodi statici (che non hanno overriding)
    


    
### Critiche



*  Il Singleton può essere problematico col multi-threading
*  Crea dipendenze nascoste, gli user dipendono dal nome della classe
*  Difficile tornare indietro dalla scelta di usare il singleton
*  Incapsula due responsabilità distinte (creazione + aspetti interni)
*  Rende meno estendibile il codice della classe (è meno "OOP")
* $\Rightarrow$ *__Da usare quando portare "in giro" il riferimento all'oggetto sarebbe complesso__*
    




---


## Singleton con "lazy initialization" (non thread-safe)


    \sizedrangedcode{\scriptsize}{3}{100}{\ecl/singleton/LogLazy.java}


---


## Singleton con "lazy initialization" e "thread-safe"


    \sizedrangedcode{\ssmall}{3}{100}{\ecl/singleton/LogLazyTS.java}


---



## Template Method: comportamentale, su classi


    
### Intento/motivazione


	Definisce lo scheletro (template) di un algoritmo (o comportamento), lasciando l'indicazione di alcuni suoi aspetti alle sottoclassi.
    

    
### Esempi



*  In un input stream (`InputStream`), i vari metodi di lettura sono dei Template Method: dipendono dall'implementazione del solo concetto di lettura di un `int`
	%*  Similmente, i metodi di `AbstractSet` tranne `size()` e `iterator()`
*  Le interfacce funzionali con metodi di default che chiamano l'astratto
    


    
### Soluzione



*  L'algoritmo è realizzato attraverso un metodo non astratto (il template method) di una classe astratta
*  Questo realizza l'algoritmo, chiamando metodi astratti quando servono gli aspetti non noti a priori
*  Una sottoclasse fornisce l'implementazione dei metodi astratti
    




---


## Template Method: UML


    ![](img/template_method.jpg)


---


## Template Method: Una estensione di `InputStream`


    \sizedrangedcode{\ssmall}{3}{100}{\ecl/tmethod/UseRandomInputStream.java}


---


## Template Method: esempio `BankAccount`


    \sizedrangedcode{\ssmall}{3}{100}{\ecl/tmethod/BankAccount.java}


---


## Template Method: esempio con i metodi `default`


    \sizedrangedcode{\ssmall}{5}{100}{\ecllambda/interfaces/SimpleIterator.java}
    \sizedrangedcode{\ssmall}{3}{100}{\ecllambda/interfaces/UseSimpleIterator.java}


---

-->

---

## Strategy: comportamentale, su oggetti


    
### Intento/motivazione


Definisce una famiglia di algoritmi, e li rende interscambiabili, ossia usabili in modo trasparente dai loro clienti
    

    
### Esempi



*  Strategia di disposizione di componenti in una GUI (`LayoutManager`)
*  Strategie di confronto fra due elementi per sorting (`Comparable`)
*  Strategie di `map`, `filter`, etc.. negli `Stream`
    


    
### Soluzione



*  Gli algoritmi sono realizzati tramite specializzazioni di una classe/interfaccia base
*  Ai clienti passo un oggetto (di una specializzazione) della classe base
*  Se la strategia è funzionale si usano facilmente le lambda (e viceversa)
* $\Rightarrow$ *__È probabilmente uno dei pattern più importanti (assieme al Factory Methods)__*
    




---


## Strategy: UML


![](imgs/strategy.jpg)


---


## Strategy: Sorting con comparatori


    \sizedrangedcode{\ssmall}{5}{100}{\ecl/strategy/UseComparator.java}


---


## Strategy: Caso del BankAccount


    \sizedrangedcode{\ssmall}{3}{100}{\ecl/strategy/BankOperationFees.java}
    \sizedrangedcode{\ssmall}{3}{100}{\ecl/strategy/StandardBankOperationFees.java}


---


## Strategy: Caso del BankAccount


    \sizedrangedcode{\ssmall}{3}{100}{\ecl/strategy/BankAccount.java}


<!--

---


## Strategy vs Template Method


  
### In comune



*  Entrambi li si ottengono dall'esigenza di scorporare da una classe la gestione di una strategia o specializzazione
*  Entrambi richiedono un behaviour aggiuntivo da realizzare
  


  
### Differenze



*  Strategy è più flessibile, perché gli oggetti che rappresentano la specializzazione sono liberi dal dover estendere una certa classe, e quindi sono più facilmente riusabili (p.e. un `Comparator` è usabile con collection diverse)
*  Template Method si integra con il subtyping, e quindi va usato quando a strategie specializzate devono corrispondere classi specializzate
  


  
### Altre note



*  Negli `InputStream` le limitazioni del Template Method sono mitigate dal Decorator
*  Con le lambda, l'approccio a Strategy diventa più naturale
*  Valutare di usare il Template Method insieme a Strategy, ossia per definire gerarchie di strategie 
  

-->



## Factory Method e Abstract Factory


  ![](img/fac3.png)
  ![](img/fac4.png)


---



## Factory Method: creazionale, su oggetti


    
### Intento/motivazione


	Definisce una interfaccia per creare oggetti, lasciando alle sottoclassi il compito di decidere quale classe istanziare e come
    

    
### Esempi



	*  Un framework deve creare oggetti, ma sue specializzazioni devono crearne versioni specializzate
    


    
### Soluzione



	*  Una interfaccia creatrice fornisce il metodo factory col compito di creare e ritornare l'oggetto
	*  Tale interfaccia viene poi specializzata, e incapsula la logica di creazione dell'oggetto
	* $\Rightarrow$ ..spesso frainteso con static o simple factory
    




---


## Factory Method: UML


![](imgs/factorymethod.png)


---


## Factory Method: Esempio `Persona` e `FactoryPersona`


    \sizedrangedcode{\ssmall}{3}{100}{\ecl/factory/person/Person.java}
    \sizedrangedcode{\ssmall}{3}{100}{\ecl/factory/person/PersonFactory.java}


---
