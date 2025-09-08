 
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/intro/"]

+++

# Introduzione al corso *Progettazione e Sviluppo del Software (PSS)*

{{% import path="front-page.md" %}}

---

# Docenti

* Titolare del corso: Prof. Danilo Pianini
  * e-mail: [`danilo.pianini@unibo.it`](mailto:danilo.pianini@unibo.it)
  * homepage: [`https://www.unibo.it/sitoweb/danilo.pianini`](https://www.unibo.it/sitoweb/danilo.pianini)
* Modulo 2: Prof. Gianluca Aguzzi
  * e-mail: [`gianluca.aguzzi@unibo.it`](mailto:gianluca.aguzzi@unibo.it)
  * homepage: [`https://www.unibo.it/sitoweb/gianluca.aguzzi`](https://www.unibo.it/sitoweb/gianluca.aguzzi)
* Modulo 3 (Lab): Prof. Angelo Filaseta
  * e-mail: [`angelo.filaseta@unibo.it`](mailto:angelo.filaseta@unibo.it)
  * homepage: [`https://www.unibo.it/sitoweb/angelo.filaseta/`](https://www.unibo.it/sitoweb/angelo.filaseta/)

* Tutor: Dott. Luca Deluigi
  * e-mail: [`luca.deluigi5@unibo.it`](mailto:luca.deluigi5@unibo.it)
  * homepage: [`https://www.unibo.it/sitoweb/luca.deluigi5/`](https://www.unibo.it/sitoweb/luca.deluigi5/)
  

---

# Sito del corso su `virtuale.unibo.it`

* URL: [https://virtuale.unibo.it/course/view.php?id=65701](https://virtuale.unibo.it/course/view.php?id=65701) TODO
  * sarà il luogo degli avvisi (e notifiche), forum di discussione, e della pubblicazione del materiale
  * tutti gli studenti che seguono il corso si iscrivano, e lo tengano d'occhio

---

# Contatti

### Come contattare

* Attraverso il **Forum Studenti** per domande la cui risposta è di interesse generale
  * URL: [https://virtuale.unibo.it/mod/forum/view.php?id=1628532](https://virtuale.unibo.it/mod/forum/view.php?id=1628532)
  * tutte le domande tecniche
  * tutte le domande sull'organizzazione del corso
* Via **email** *tenendo in copia tutti i docenti*
  * Per questioni personali
  * Si usi e-mail istituzionale `@studio.unibo.it`
  * Si usi prefisso `[LPTSI-PSS]` nel subject della mail
* **Ricevimento**
  * Si vedano le pagine web dei docenti

---



# Organizzazione generale del corso

## Lezioni aula (giovedì 15-18, venerdì 9-12)

* Illustrano i concetti teorici, metodologici, e pratici
* Basate su slide proiettate (ma non solo)

## Laboratorio (martedì 9-12)

* Illustra aspetti metodologici e pratici
* Con esercizi (da svolgere in autonomia) necessari alla comprensione e alla sperimentazione
    * Con l'aiuto del docente e del tutor per dubbi, problemi, e *correzioni*
* *È parte integrante del corso*, è **fondamentale per riuscire a sostenere l'esame**

## Studio a casa
* Rilettura slide
* Completamento di tutti gli esercizi presentati in laboratorio
* È praticamente obbligatorio se volete rimanere in pari...

---

# Contenuti

## Programma (di massima) del corso

* Elementi base di programmazione *object-oriented (OO)*
    * Incapsulamento, Ereditarietà, Polimorfismo
* Conoscenza del linguaggio Java
    * Vi sarà utile anche per capire il linguaggio Kotlin a Sistemi Mobile
* Aspetti avanzati dei linguaggi OO
    * Generici e varianza
    * Reflection
    * Lambda expressions, stream, e programmazione ibrida OO/funzionale
* Librerie (incluse interfacce grafiche)
* Testing
* Pattern e *buone pratiche di programmazione*
* Organizzazione di un progetto software
    * Version control (`git`)
    * Build automation (`gradle`)

---

# Materiale

- Slide (e codice sorgente) a cura dei docenti
  - messi a disposizione sul sito del corso su Virtuale
  - necessari e sufficienti per acquisire le competenze e superare l'esame

## Testi di riferimento (non necessario l'acquisto)
  ### Programmazione in Java
  * B.Eckel. Thinking in Java, 4th edition.
  * J.Block. Effective Java, 2nd edition.
  * R.Warburton. Java 8 Lambdas.

<!--  ### Programmazione in C\#
  * Jon Skeet. C\# in depth, 3rd edition.
-->

  ### Altri riferimenti
  * E.Gamma et al. Design Patterns Elements of Reusable Object-Oriented Software.
  * R.Martin. Clean Code: A Handbook of Agile Software Craftsmanship
  * Java e C\# online documentation (tutorials, Language Specification, APIs)

---

# Software
## Java
* OpenJDK 25 (Open Java Development KIT) https://jdk.java.net/25/
* IntelliJ Idea https://www.jetbrains.com/idea/
* Gradle https://gradle.org/
* Git https://git-scm.com/

## Istruzioni sull'installazione (sul PC di casa)
* https://unibo-lptsi-pss.github.io/software-installation/
* **Molto importante rendersi operativi prima del primo laboratorio!**
  * $\Rightarrow$ è consigliato l'uso del sistema operativo Linux

---

# Sul ruolo di questo corso
## Elementi essenziali
* Costruzione del software, e quindi di sistemi
* Analisi problemi, e organizzazione di soluzioni
* Tecniche base ed (alcune) avanzate di programmazione ad oggetti
* Introduzione al trend della programmazione moderna
* Gestione del progetto
* Utilizzo di strumenti integrati di sviluppo

## L'importanza nel vostro percorso
* Enfasi sull'approccio metodologico
* Competenze a curriculum
* Target di qualità piuttosto elevato
* È cruciale dedicargli subito il tempo necessario

---

# Esame

## Sviluppo + Discussione progetto

* *Progetto sviluppato in gruppo (3-4 studenti)* <!-- ; 60-70 ore a testa -->
    * Potete formare i gruppi anche prima del progetto, e aiutarvi per i laboratori
    * Il progetto vero e proprio andrà iniziato dopo la fine delle lezioni, perché solo allora avrete tutti gli elementi necessari
* Concordato col docente prima di iniziare
* Esempi di progetti del passato:
    * Tutti i progetti passati
        * https://github.com/orgs/unibo-oop-projects/repositories
    * Progetti "carini" (notare che non significa che siano ben progettati!)
        * https://unibo-oop.github.io/showcase/
* Da relazionare con qualità, poi *discusso oralmente* (su appuntamento)
    * I dettagli (cf. consegna, relazione etc.) discussi durante il corso

---

# Prerequisiti

## Buona conoscenza
* tecniche di programmazione imperativa/strutturata
* costruzione e comprensione di semplici algoritmi e strutture dati

## Attenzione a chi è già "fluente" in linguaggi ad oggetti
* Java o C#
* è difficile disimparare le cattive abitudini!

---



# Introduzione al corso *Progettazione e Sviluppo del Software (PSS)*

{{% import path="front-page.md" %}}