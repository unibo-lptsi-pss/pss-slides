 
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/build-systems/"]

+++

# Costruzione del software e librerie

{{% import path="cover.md" %}}

# Build systems

---

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

## Gradle: configurazione minimale per Java

* Gradle viene pilotato con due file:
  * `settings.gradle.kts`
    * Per il momento, ci serve solo a dare un nome al progetto
  * `build.gradle.kts`
    * Conterrà tutta la logica di costruzione del software
    * Ma noi sfrutteremo le convenzioni, configurando ben poco!
* Al momento, ci basta una sola riga di codice per ciascuno!

`settings.gradle.kts`
```kotlin
rootProject.name = "name-of-our-project"
```

`build.gradle.kts`
```kotlin
plugins { java }
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
class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello, World");
  }
}
```

---

## Gradle: Hello World in Java, utilizzo

* compilazione:
  * `gradle compileJava`
* esecuzione (non responsabilità di Gradle):
  * `java -cp build/classes/java/main HelloWorld`

---

# Dipendenze e librerie

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

#### Continueremo a *lanciare* i nostri eseguibili *a mano* dal terminale!
`java -cp build/classes/java/main nome.qualificato.della.ClasseDaEseguire`
```
├── build.gradle.kts
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── sources
│   └── it
│       └── unibo
│           └── compilation
│               ├── ComplexNum.java
│               └── math
└── src
    └── main
        └── java
            └── HelloWorld.java
```
