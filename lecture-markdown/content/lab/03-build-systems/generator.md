
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/compilers/"]

+++

# Build Systems

### Esercizi e soluzioni: https://github.com/unibo-lptsi-pss/pss-lab/releases/latest/

{{% import path="cover.md" %}}

---

## Quando il gioco si fa duro, i duri *automatizzano*

La gestione della compilazione potrebbe diventare complicata:
* Sorgenti in molte cartelle
* Divisi in molti package
* Alcune librerie binarie di cui non abbiamo il sorgente

Comandi **molto lunghi!** Facile sbagliarsi, tedioso da fare a mano!

Soluzione: costruire degli script!

---

## Script per compilare?

In fin dei conti, è solo software che, di mestiere, compila software

...a sua volta, da compilare o interpretare.

Fare uno script personalizzato è molto flessibile, ma se abbiamo *molti progetti*?
* Copiarlo da tutte le parti vuol dire doverlo modificare in molti posti in caso di errore!
* Viola un principio importante: **Don't Repeat Yourself** (**DRY**)

#### La compilazione è **ripetitiva**!

Potremmo costruire un sistema che:
1. Si aspetta che i sorgenti siano in un posto standard
    * Se li trova, allora compila, mettendo il risultato in un posto standard
2. Se sono in un posto non standard, si *configura* per funzionare

#### Principio **convention over configuration**

---

## Build systems

Sono software che si occupano di aiutare con le varie fasi della costruzione del software:
* Ricerca e scaricamento di librerie (vediamo in futuro)
* Compilazione (vediamo oggi)
* Testing (vediamo in futuro)
* Packaging (vediamo in futuro)
* Generazione di documentazione (vediamo in futuro)
* Delivery degli artefatti (non oggetto del corso)

## Gradle

* Un **moderno** build system
* Supporta Java (oltre a C/C++, Scala, Kotlin...)
    * In tutto l'ecosistema, che include Android
* Ne vedremo solo i rudimenti
    * Per noi è strumentale a costruire software Java
    * Impareremo come sfruttarlo per automatizzare le operazioni di cui sopra

---

<!-- write-here "shared-slides/build-systems/it-gradle-basics.md" -->

<!-- end-write -->

---

# Gradle wrapper

---

## (Non) installare Gradle: il wrapper

Se da una versione all'altra di Gradle dovesse cambiare la convenzione,
cosa succederebbe?
* Il nostro software smette di funzionare se aggiorniamo il build system!

E se avessimo *progetti diversi* che richiedono *versioni diverse* di Gradle?

#### Ci serve un modo per portarci dietro la versione di Gradle che ci serve

### Gradle wrapper

Un insieme di script con un software minimale che:
1. Scarica la versione di Gradle indicata in un file di configurazione
    * se non già disponibile nel sistema
2. Usa quella versione per costruire il nostro sistema!

Il wrapper può (deve) esser copiato in ogni progetto che gestiamo con Gradle

Dato che si auto-scarica, non occorre installare Gradle!
* Anche se è comodo, la versione di Gradle installata può generare le versioni wrapper

---

## Progetti Gradle con wrapper

1. Script bash eseguibile (<i class="fab fa-linux"></i>/<i class="fab fa-apple"></i>): `gradlew`
2. Script batch eseguibile (<i class="fab fa-windows"></i>): `gradlew.bat`
3. File di configurazione con indicata la versione di Gradle:<br>
   `gradle/wrapper/gradle-wrapper.properties`
4. Software Java che scarica la versione di Gradle descritta nel file di configurazione: <br>
   `gradle/wrapper/gradle-wrapper.jar`

Wrapper pronto per esser scaricato:
* https://github.com/DanySK/Gradle-Wrapper/archive/refs/heads/master.zip

---

## Utilizzo di Gradle in un progetto Java

Se abbiamo il Gradle wrapper configurato in un progetto,
possiamo usarlo attraverso uno dei due script:
* `gradlew` (<i class="fab fa-linux"></i>/<i class="fab fa-apple"></i>)
  o `gradlew.bat` (<i class="fab fa-windows"></i>),
  a seconda della nostra piattaforma
* seguito da un elenco di comandi detti **task**

In Gradle, un **task** è una particolare *attività* del processo di costruzione del software

Esiste un task che elenca i task, chiamato `tasks`.

Quando configurato per compilare Java fra i vari task troviamo anche `compileJava`

### Ottenere l'elenco dei task disponibili

* `./gradlew tasks` (sistemi <i class="fab fa-linux"></i> e <i class="fab fa-apple"></i>)
* `gradlew.bat tasks` (sistemi <i class="fab fa-windows"></i>)

### Compilazione Java

* `./gradlew compileJava` (sistemi <i class="fab fa-linux"></i> e <i class="fab fa-apple"></i>)
* `gradlew.bat compileJava` (sistemi <i class="fab fa-windows"></i>)

#### È sempre comunque possibile *lanciare* i nostri eseguibili *a mano* dal terminale!
`java -cp build/classes/java/main nome.qualificato.della.ClasseDaEseguire`

---

## Appendice -- Varianza

## Formula per il calcolo della varianza

Sia $n$ il numero di elementi dell'array ed $x_i$ l'elemento all'indice $i$ dell'array, e $\mu$ la media dei valori del suddetto array. La varianza $\sigma^2$ può essere calcolata come:

$$\sigma^2 = \frac{\displaystyle\sum_{i=0}^{n-1}(x_i - \mu)^2} {n}$$

---

# Build Systems

### Esercizi e soluzioni: https://github.com/unibo-lptsi-pss/pss-lab/releases/latest/

{{% import path="cover.md" %}}