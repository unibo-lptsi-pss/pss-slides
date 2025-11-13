
+++

title = "Laboratorio di Programmazione ad Oggetti"
description = "Laboratorio di Programmazione ad Oggetti, Ingegneria e Scienze Informatiche"
outputs = ["Reveal"]
aliases = ["/dependencies/"]

+++
# Dipendenze e librerie

{{% import path="front-page.md" %}}

---

## Outline

- Cos'è una libreria?
- Gestione delle dipendenze con Gradle
- Librerie Java particolarmente utili

## Obiettivi
- Comprendere il concetto di libreria software
- Saper utilizzare un build system per la gestione delle dipendenze
- Conoscere alcune librerie Java comunemente usate

---

<!-- write-here "shared-slides/build-systems/it-gradle-dependencies.md" -->

<!-- end-write -->

---

### Librerie particolarmente utili

* **Google Guava** ([https://github.com/google/guava](https://github.com/google/guava))

    * Il progetto Guava di Google raccoglie diverse librerie core sviluppate da Google che possono essere utilizzate per lo sviluppo di applicazioni.
    * Ad esempio, sono disponibili librerie per Collections Management, Concurrency, I/O, String Processing, ...

* **Apache Commons** ([https://commons.apache.org](https://commons.apache.org))

    * Estensioni al linguaggio (Commons Lang3)
    * Libreria matematica estesa (Commons Math3)
    * Accesso semplificato all'I/O (Commons IO)
    * Costruzione semi automatica di una command line (Commons CLI)
    * Encoding e crittazione (Commons Codec), compressione (Commons Compress)

* **Static Logger Facade for Java (SLF4J)** ([http://www.slf4j.org](http://www.slf4j.org))

    * Backend-independent logging (addio `println`)



---

### Top 20 Java Library

[
![](imgs/top-20-java-libraries.png)
](http://blog.takipi.com/we-analyzed-60678-libraries-on-github-here-are-the-top-100)

---

### Awesome Java

Esiste una lista, costantemente manutenuta, che elenca le più comuni, diffuse e stabili librerie per una pletora di usi: [https://bit.ly/awesome-java](https://bit.ly/awesome-java)

#### USATELE!

* **Usare librerie e non reinventare la ruota è IMPORTANTE** e valutato
positivamente.
*  Attenzione però a scegliere le librerie dopo aver fatto il **modello del dominio**
dell'applicazione: **PRIMA** si studia il problema, **DOPO** si implementa una soluzione:
siete aspiranti ingegneri, cercate di lavorare sempre top-down quando possibile, non partite dalla libreria per costruirci sopra un software, ma partite dai requisiti e - se utile - sfruttate le librerie per soddisfarli.

#### Attenzione ai framework!

Alcune librerie sono costruite come *Framework*,
ossia come ossature di applicazioni,
pensate per velocizzare la costruzione di un certo tipo di software
* Esempio tipico: l'engine per videogames [libGDX](`https://libgdx.com/`)

Uno degli scopi del progetto di OOP è quello di misurare se siate bravi designer,
ma per farlo è necessario che il design della vostra applicazione l'abbiate fatto voi e non chi ha costruito il framework.

Vi raccomandiamo quindi di **evitare i framework**!
O, al più, usarli solo *dopo che il progetto è avviato* come semplice libreria
(non semplice e non sempre possibile)

---

# Dipendenze e librerie

{{% import path="front-page.md" %}}
