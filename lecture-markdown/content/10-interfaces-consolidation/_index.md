
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
* Mostrare alcune applicazioni notevoli (pattern) di questi concetti, principi, e meccanismi
  

### Argomenti


* Introduzione ai *design pattern*
* Pattern *Strategy*
  

---

## Riassunto di quanto visto finora

---


# Design Pattern e Progettazione di Dettaglio


## Progettazione di dettaglio



### Elementi



*  Non descrive ogni singola classe/interfaccia del sistema
*  Descrive relazioni fra oggetti, quelle ritenute più importanti per capire come il sistema è organizzato
*  Quelle che nascondono elementi non banali
*  Documentata da più diagrammi UML sempre di 5-10 classi ognuno




### Come progettare una buona classe o gruppo di classi?



*  buona conoscenza della programmazione OO e delle linee guida di buona programmazione/progettazione note e discusse
*  utilizzo di cataloghi noti di pattern di progettazione (design pattern)





---


## Design Pattern


  
### I Pattern di progettazione



*  Idea: trasmettere esperienze (positive) e ore di lavoro (di identificazione, rifattorizzazione) ad altri per essere usate *tout court*
*  Sono elementi riusabili (semplici ed eleganti) di progettazione OO
*  Sono stati ottenuti in passato (e tuttora) dall'analisi di soluzioni ricorrenti in progetti diversi
*  Alcuni sono particolarmente famosi, come quelli della "Gang of Four" (detti anche Pattern della GoF, o Pattern di Gamma)
*  Testo famosissimo (in C++): "Design Patterns: Elements of Reusable Object-Oriented Software" di E. Gamma, R. Helm, R. Johnson, J. Vlissides
*  23 in tutto. Esempi: Decorator, Singleton, Template Method, Observer
*  (Cit. "SW di grosse dimensioni li usano praticamente tutti")
*  Il loro uso migliora molto il codice
*  Ne favorisce la comprensione se li si indicano nella documentazione
*  Rende il codice più flessibile (nascono per questo)
*  Portano più direttamente ad una buona organizzazione





---


## Design Pattern in questa sede
  

  
### Nel corso



*  Vari Pattern già stati utilizzati (es.: nelle librerie)
*  Vanno usati dove opportuno nel progetto d'esame (e nella relazione)
*  Possono essere tema dell'esame in laboratorio
*  Quelli visti a lezione sono da conoscere tassativamente
  
  
### Per il vostro futuro


*  Noi porremo le basi per uno loro studio in autonomia
*  Un ottimo progettista li conosce e usa (ove opportuno) *__tutti__*
  




---


## Motivazioni


    
### Rifattorizzazione (refactoring)



*  Operazione di modifica del codice che non aggiunge funzionalità
*  Ha lo scopo di migliorare programmazione e struttura del SW
*  Ha lo scopo di attrezzare il codice a possibili cambiamenti futuri
*  Può/deve quindi comportare una riprogettazione di alcune parti
    


    
### La necessità del refactoring



*  Una buona progettazione non la si ottiene al primo "colpo", ma richiede vari refactoring
*  Brian Foote identifica tre fasi nello sviluppo di un sistem: prototyping, expansionary, consolidating; nel consolidamento si rifattorizza
*  Nell'agile programming, ogni ciclo di sviluppo non parte se non si è rifattorizzato il codice del ciclo precedente (sia in cicli corti che lunghi)
    


    
### I pattern



*  L'esperienza pregressa risulta fondamentale per velocizzare il processo di rifattorizzazione
*  I Pattern di progettazione forniscono direttamente "ricette" di buona costruzione o rifattorizzazione del SW
    




---



## Struttura


    
### Un Pattern ha quattro elementi fondamentali



*  Un nome. (È un aspetto fondamentale!)
*  Un problema che risolve. (La causa che porta al suo uso)
*  La soluzione che propone. (Gli elementi del progetto)
*  La conseguenza che porta. (Riuso, variabilità, performance,..)
    


    
### Granularità



*  Gruppo ristretto di (1-5) oggetti/classi generali dipendenti fra loro
*  Sistemi più specifici o più complessi sono utili, ma non propriamente dei "Pattern"

*  Non singole classi riusabili (liste, hash-table)
*  Non "pattern architetturali" (come MVC)
*  Non framework complessi (gerarchia Swing, Reflection)
	

    




---








## Classificazione dei Pattern: categorie


    
### Livello "proposito del Pattern"



*  *Creazionali*: Riguardano la creazione degli oggetti
*  *Strutturali*: Riguardano la composizione di classi/oggetti
*  *Comportamentali*: Riguardano la interazione e distribuzione di responsabilità fra classi/oggetti
    


    
### Livello "scope"



*  Classi: Il Pattern riguarda primariamente le relazioni fra classi (e sottoclassi), e quindi tratta aspetti statici (compile-time)
*  Oggetti: Il Pattern riguarda primariamente le relazioni fra oggetti (l'esistenza di riferimenti fra oggetti), e quindi tratta aspetti dinamici (run-time)
    




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
    



## I pattern nel corso

    
### Esami di progetto


*  Identificarne/usarne "pochi" è considerato poco soddisfacente
*  Scegliere di usarli non è arbitario, ma è indice di buona progettazione e/o di buona rifattorizzazione
*  Gli argomenti: "in questo progetto non servivano" e "non c'è stato tempo" sono pessimi
*  Argomento di probabile discussione all'esame

    
### Di conseguenza



*  I pattern qui presentati vanno conosciuti
*  Gli altri pattern sono facoltativi, e importanti per il vostro futuro
    




---


# Alcuni pattern iniziali


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


    ![](img/strategy.jpg)


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
  


  


---



---

## Pattern Strategy

