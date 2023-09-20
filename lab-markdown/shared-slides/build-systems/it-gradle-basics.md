## La costruzione del software

Costruire sistemi software non è solo *programmare*.
Dipendentemente dal sistema in esame, potrebbero servire:
* Manipolazione e pre-processing del sorgente (inclusa generazione)
* Verifica della qualità del sorgente
* Gestione delle dipendenze
  * Ricerca, scaricamento, e importazione delle librerie
* Compilazione
* Manipolazione del binario compilato
* Esecuzione dei test
* Misurazione della qualità dei test (e.g., coverage)
* Generazione della documentazione

In principio, si può anche fare a mano
* ma richiederebbe **molto tempo**...
* ...e gli umani si stancano presto di lavori noiosi e ripetitivi

---

## Build automation

Automatizzazione del processo di costruzione del software
* Di fatto, scrivere software che di lavoro fa manutenzione di altro software

### Stili

* **Imperativo**/**Personalizzato**
  * Tipicamente realizzato tramite script in qualche linguaggio di programmazione
  * *Flessibile* e *configurabile*
  * Difficile da adattare e *riusare*
* **Dichiarativo**/**Standardizzato**
  * Tipicamente realizzato tramite un file di configurazione di un software dedicato alla build automation
  * *Portabile* e di semplice comprensione
  * *Limitato* dalle opzioni di configurazioni disponibili, e quindi poco flessibile

---

## Convention over configuration

Principio per cui un certo sistema software ha una configurazione "ragionevole" di default,
che può essere sovrascritta in caso di necessità

* Induce la creazione di *standard di fatto*
  * La convenzione tende a diventare il modo "normale" di fare le cose per minimizzare la configurazione
* Riduce le *ripetizioni*
* Aumenta la portabilità!

---

## Automatori ibridi

Sono sistemi che cercano di unire il meglio dei sistemi dichiarativi e imperativi
* Il file di configurazione è in realtà uno *script* in un linguaggio di programmazione vero e proprio
* Aprendolo sembra un file di testo con la configurazione
* In realtà è uno script valido!
* Quanto non specificato si assume come da convenzione
* Quando si vuole personalizzare qualcosa, si ha a disposizione la "potenza di fuoco" di un linguaggio di programmazione vero e proprio

### Esempi

* Sbt, che si appoggia su Scala
* Gradle, che si appoggia su Kotlin o Groovy

Il linguaggio host deve consentire di costruire dei **Domain-Specific languages**
* ossia, essere così flessibile da permettere di costruire un "linguaggio nel linguaggio"

---

## Gradle

* Un **moderno** build system ibrido
  * Pilotato in Kotlin (preferibile) o in Groovy
* Supporta Java (oltre a C/C++, Scala, Kotlin...)
  * In tutto l'ecosistema, che include Android
* Ne vedremo solo le basi di utilizzo
  * Per noi è strumentale a costruire software Java
  * Impareremo come sfruttarlo per automatizzare le operazioni di cui sopra

---

## Gradle è in espansione: Google trends

{{< import path="shared-slides/build-systems/gradle-trends.md" >}}

---

## Concetti base in Gradle: **task**, **progetto**, **plugin**

### Progetto

Una directory contenente il file speciale `build.gradle.kts` e/o `settings.gradle.kts`,
detti *build file*.
La loro presenza segnala a Gradle che la cartella rappresenta un **progetto**

### Plugin

Componente software contentente **task** pronti all'uso.
Gradle contiene diversi plugin pronti all'uso
(per i linguaggi più comuni, come Java).

### Task

Un **task** in Gradle rappresenta una *singola operazione atomica* del processo di costruzione del sofware
* *singola* $\rightarrow$ un task fa una sola cosa (Single Responsibility Principle)
* *atomica* $\rightarrow$ indivisibile: un task comincia e finisce senza interruzione

Qualunque esecuzione di Gradle richiede di specificare uno o più **task**, ad esempio:
* `gradle tasks` (elenca i task disponibili, escludendo quelli non categorizzati)
* `gradle tasks --all` (elenca tutti i task disponibili)
* `gradle compileJava` (compila i sorgenti java)

Gradle è in grado capire le *dipendenze* fra task ed eseguirli nell'ordine corretto.

---

## Gradle: configurazione minimale per Java

* Gradle viene pilotato con due file:
  * `settings.gradle.kts`
    * Per i nostri scopi, serve solo a dare un nome al progetto
  * `build.gradle.kts`
    * Conterrà tutta la logica di costruzione del software
    * Ma noi sfrutteremo le convenzioni, configurando ben poco!
* Al momento, ci basta una sola riga di codice per ciascuno!

`settings.gradle.kts`
```kotlin
{{% import-raw path="shared-slides/PPS-ci-examples/00-minimal/settings.gradle.kts" %}}
```

`build.gradle.kts`
```kotlin
{{% import-raw path="shared-slides/PPS-ci-examples/00-minimal/build.gradle.kts" %}}
```

Così configurato, Gradle autonomamente:
* cerca e compila i sorgenti java dalla cartella: `src/main/java`
* produce i binari dentro: `build/classes/java/main`

Vogliamo percorsi diversi?
Va configurato.

---

## Gradle: Hello World in Java, struttura

```text
├── build.gradle.kts
├── settings.gradle.kts
└── src
    └── main
        └── java
            └── HelloWorld.java
```

`build.gradle.kts`
```kotlin
plugins { java }
```

`settings.gradle.kts` (opzionale)
```kotlin
rootProject.name = "hello-world"
```

`HelloWorld.java`
```java
{{% import-raw path="shared-slides/PPS-ci-examples/00-minimal/src/main/java/HelloWorld.java" %}}
```

---

## Gradle: Hello World in Java, task e loro utilizzo

* elencare i task disponibili:
  * `gradle tasks --all`
* compilazione:
  * `gradle compileJava`
* pulizia (cancellazione della directory `build` dove Gradle lavora):
  * `gradle clean`
* esecuzione (non responsabilità di Gradle):
  * `java -cp build/classes/java/main HelloWorld`
