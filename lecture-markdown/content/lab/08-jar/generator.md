 
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/build-systems/"]

+++

# Costruzione degli artefatti

{{% import path="cover.md" %}}

---

## Build lifecycle

La costruzione dei "deliverable" *è parte integrante* del processo di costruzione del software:

* *compilazione* $\Leftarrow$ la conosciamo
* *compilazione dei test* $\Leftarrow$ altro lab
* *verifica statica della qualità dei sorgenti* $\Leftarrow$ altro lab
* *esecuzione dei test* $\Leftarrow$ altro lab
* *generazione della documentazione* $\Leftarrow$ altro lab
* *costruzione degli artefatti "deliverable"* $\Leftarrow$ **ci occupiamo di questo**
* *pubblicazione* $\Leftarrow$
* *messa in produzione* $\Leftarrow$

```mermaid
flowchart RL

compile(compilazione)
compileTest(compilazione dei test):::test
staticAnalysis(analisi statica):::staticAnalysis
test(esecuzione dei test):::test
docs(generazione della documentazione):::docs
jar(costruzione dei deliverable):::jar
delivery(pubblicazione)
deploy(messa in produzione)
staticAnalysis --> compileTest --> compile
test --> compileTest
docs --> compile
jar --> compile
delivery --> test
delivery --> jar
delivery --> docs
deploy --> delivery --> staticAnalysis

classDef jar fill:#f9f,stroke:#333,stroke-width:4px
```

---

## Build lifecycle in Gradle

Gradle *mappa* con i task il processo di costruzione del software

```mermaid
flowchart RL

compile(compileJava)
compileTest(compileTestJava):::test
checkstyle(verifica di stile):::staticAnalysis
pmd(verifica di uso di buone pratiche di programmazione):::staticAnalysis
spotbugs(analisi del bytecode):::staticAnalysis
check(check):::check
test(test):::test
assemble(assemble):::jar
jar(jar):::jar
javadoc(javadoc):::docs
build(build):::build
assemble --> jar --> compile
spotbugs --> compile
check --> test --> compileTest --> compile
check --> checkstyle
check --> pmd
check --> spotbugs
javadoc --> compile
build --> check
build --> assemble
classDef jar fill:#f9f,stroke:#333,stroke-width:4px
classDef assemble fill:#f9f,stroke:#333,stroke-width:4px
classDef build fill:#f9f,stroke:#333,stroke-width:4px
```

L'esecuzione di un task implica l'esecuzione di tutti i precedenti!

* `jar` (implica `compileJava`): costruisce un deliverable del progetto corrente
* `assemble` (implica `jar`): costruisce gli artefatti "deliverable"
* `build`: esegue sia `check` che `assemble`

Un buon modo per eseguire l'intero ciclo di vita è `./gradlew build javadoc`!

---

## Packaging di applicazioni Java

* Finora, abbiamo visto che un’applicazione Java è composta di un
insieme di classi: noi vorremmo distribuirla come singolo file!

* Normalmente, le applicazioni Java vengono confezionate in file JAR
(Java ARchive)

### File JAR

* Un JAR è un archivio compresso con algoritmo ZIP che contiene le classi, le risorse (e.g. icone)
e un file descrittivo detto *Manifest*.

* Il Manifest viene creato sempre in `META-INF/MANIFEST.MF`, e
contiene informazioni sull’applicazione, ad esempio su quale classe
contenga il main del programma.

* È possibile associare (a livello di sistema operativo) l’esecuzione del
JAR file al comando Java, in modo che l’applicazione si avvii
automaticamente “col doppio click” (avviando automaticamente la
classe scritta nel Manifest)

* È possibile utilizzare i file JAR come componenti di altre applicazioni (librerie)

---

## Il comando `jar`

Per creare un file JAR, si può utilizzare direttamente il comando `jar`
* Normalmente, tuttavia, ci si avvale del supporto di strumenti di build automation (Gradle, Maven...)

### Opzioni importanti del comando jar
* `c` — Specifica l’intenzione di creare un JAR file
* `f` — Specifica un file di output (se non presente, l’output è rediretto su
standard output)
* `m` — Specifica l’intenzione di allegare un manifest file personalizzato (se non
presente, ne viene creato uno di default, che non specifica alcuna classe da
eseguire)

### Esempi

* `jar cf jar-file.jar file1 file2 directory1`
    * Crea un nuovo JAR file di nome `jar-file.jar` contenente `file1`,
    `file2`, e `directory1`. Include un Manifest di default.
* `jar cf jar-file.jar *`
    * Crea un nuovo JAR file di nome `jar-file.jar` contenente tutti i file
    e le directory nel path corrente. Include un Manifest di default.
* `jar cfm jar-file.jar MYMANIFEST it/unibo/*`
    * Crea un nuovo JAR file, di nome `jar-file.jar`, contenente tutti i
    file e le directory nel path `it/unibo`, con manifest dato dal file
    `MYMANIFEST` nella cartella corrente.

---

## Esecuzione di JAR file tramite command line

`java` ha un'opzione che consente l’esecuzione di file jar: `-jar`

Quando si lancia `java -jar nomefile.jar`,
la Java Virtual Machine automaticamente legge il file *Manifest*,
cerca una descrizione della *Main Class* da eseguire e *tenta di eseguirla*.

---

## Costruzione di file Jar in Gradle

Il plugin `java` include un task chiamato `jar` che si occupa di creare un jar dell'applicazione corrente
* **Non è eseguibile!**
* Il task è pensato per chi costruisce *librerie*
    * Include tutti i compilati (`*.class`) e le risorse del source set `main`
        * Ossia, il risultato della costruzione di tutto quello che si trova in `src/main`
        * Non include i test! (giustamente...)
* Genera un jar che **non** include le *dipendenze*
    * Ossia le librerie che il nostro software usa
* Non specifica alcuna *main class* nel *Manifest*!

---

## (fat/uber/shadow)-jars

Perché un Jar sia eseguibile, deve includere:
1. Una main class nel Manifest
2. Tutti i compilati e le risorse dell'applicazione
    * Tutto quello che deriva da `src/main`
3. Tutte le **librerie** che servono al software
    * Altrimenti, avremo dei `NoClassDefFoundError` o delle `ClassNotFoundException` (in reflection)

Un Jar file con queste caratteristiche viene definito anche fat-jar (o uber-jar, o shadow-jar)

---

## Fat-jar in Gradle

Il plugin `java` non ha dei task preconfigurati per generare dei fat-jar.
Possiamo però sfruttare una coppia di altri plugin:

* `application`: un plugin incluso in Gradle che configura una classe come "main class" per il software
    * Aggiunge il task `run` che compila il progetto e la esegue
* `com.gradleup.shadow`: un plugin *di terze parti*
    (ossia, costruito da una persona che non fa parte del team di Gradle)
    * Aggiunge il task `shadowJar`, che costruisce un `jar` con tutte le dipendenze specificate in Gradle
    * Se presente `application`, cattura anche la *main class* e scrive il relativo file

Nota: è sempre possibile costruire i propri task personalizzati, ma non è argomento di questo corso

---

## Utilizzo di `application` e `com.gradleup.shadow`

```kotlin
plugins {
    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building a CLI application
    // You can run your app via task "run": ./gradlew run
    application

    /*
     * Adds tasks to export a runnable jar.
     * In order to create it, launch the "shadowJar" task.
     * The runnable jar will be found in build/libs/projectname-all.jar
     */
    id("com.gradleup.shadow") version "9.2.2"
    id("org.danilopianini.gradle-java-qa") version "1.157.0"
}

application {
    // Define the main class for the application.
    mainClass.set("it.unibo.sampleapp.RateAMovie")
}
```

* `./gradlew run` lancia `your.mainclass.qualified.Name`
* `./gradlew shadowJar` crea un fat-jar il cui nome termina in `-all.jar` dentro `build/libs`

---

## Utilizzo di `application` con multipli `main` tramite proprietà di progetto

Nel caso in cui vi fossero più classi con un main, è possibile passare a Gradle il nome di classe da lanciare.

Per farlo, sfruttiamo il concetto di *proprietà* del progetto.

Le proprietà sono associazioni chiave-valore fra due stringhe che possono essere:
* fornite come configurazione del sistema **$\leftarrow$ non lo vediamo**
* fornite come variabile d'ambiente **$\leftarrow$ non lo vediamo**
* scritte in un file `gradle.properties` *$\leftarrow$ per OOP cambia poco rispetto a scriverlo nel `build.gradle.kts`*
* passate da terminale in formato `-Pnome=valore` *$\leftarrow$ utile se si hanno più main*

Scrivendo quanto segue nel `build.gradle.kts`

```kotlin
val myMainClass: String by project // prende la main class dalle proprietà di  progetto
application {
    mainClass.set(myMainClass)
}
```

È possibile poi scegliere la main class da avviare usando:
* `./gradlew run -PmyMainClass=...`
    * (sostuendo ai `...` il nome qualificato della main class)

Ad esempio, se abbiamo due classi con main `it.unibo.oop.Pluto` e `it.unibo.oop.Paperino` nel nostro progetto, possiamo lanciare:
* `./gradlew run -PmyMainClass=it.unibo.oop.Pluto`
    * per eseguire `Pluto`
* `./gradlew run -PmyMainClass=it.unibo.oop.Paperino`
    * per eseguire `Paperino`

---

# Costruzione degli artefatti

{{% import path="cover.md" %}}

