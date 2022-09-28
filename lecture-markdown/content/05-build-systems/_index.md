 
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


<!-- this file includes generated content. Do not edit. Edit content/05-build-systems/generator.md, instead. -->

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
* `gradle tasks` (elenca i task disponibili)
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
  * `gradle tasks`
* compilazione:
  * `gradle compileJava`
* pulizia (cancellazione della directory `build` dove Gradle lavora):
  * `gradle clean`
* esecuzione (non responsabilità di Gradle):
  * `java -cp build/classes/java/main HelloWorld`

---

# Dipendenze e librerie

---

## Dipendenze nel software

> nos esse quasi nanos gigantium humeris insidentes
<cite>Bernardo di Chartres</cite>

Tutto il software moderno dipende da altro software!
* il sistema operativo
* il *runtime environment* (la Java Virtual Machine)
* le librerie di basa (tutto quello che sta in `java.*` e `javax.*`)
* librerie di terze parti (fra poco)
* risorse esterne (icone, suoni, dati applicativi)

Tutto il software che costruiamo e usiamo dipende da *altro sofware*
* Che dipende da *altro software*
  * Che dipende da *altro software*
    * Che dipende da *altro software*
      * Che dipende da *altro software*
        * Che dipende da *altro software*
          * Che dipende da *altro software*
            * Che dipende da *altro software*
              * ...

$\Rightarrow$ Le applicazioni hanno un **albero** di dipendenze!

---

## Un semplice esempio: rate a movie

Proviamo a costruire una *semplice applicazione* che:
1. Richiede come parametro il nome di un film o serie TV
2. Si connette ad Internet e cerca informazioni sul dato prodotto cinematografico<br>
(per esempio, andando a cercare su IMDb.org o rottentomatoes)
3. Cerca il film che abbiamo fornito come ingresso
4. Stampa tutte le informazioni disponibili su questo film!<br>
(anno, regista, attori, trama, media voti...)

#### **Quanto codice potrebbe servire?**

---

Una possibile soluzione:
https://github.com/APICe-at-DISI/sample-gradle-project/blob/master/src/main/java/it/unibo/sampleapp/SimplerRateAMovie.java

---

## Il trucco: usare librerie

* È stata sfruttata una libreria per OMDB
  * Data una chiave, interroga un database di film
  * Nasconde tutta la parte di comunicazione di rete via HTTP, il parsing, eccetera

* Ma a sua volta, questa libreria usa librerie che usano librerie...

{{% fragment %}}
```text
+--- com.omertron:API-OMDB:1.5
|    +--- commons-codec:commons-codec:1.10
|    +--- org.apache.commons:commons-lang3:3.4
|    +--- com.fasterxml.jackson.core:jackson-core:2.8.7
|    +--- com.fasterxml.jackson.core:jackson-annotations:2.8.7
|    +--- com.fasterxml.jackson.core:jackson-databind:2.8.7
|    |    +--- com.fasterxml.jackson.core:jackson-annotations:2.8.0
|    |    \--- com.fasterxml.jackson.core:jackson-core:2.8.7
|    +--- org.slf4j:slf4j-api:1.7.24
|    \--- org.yamj:api-common:2.1
|         +--- org.apache.httpcomponents:httpclient:4.5.3
|         |    +--- org.apache.httpcomponents:httpcore:4.4.6
|         |    +--- commons-logging:commons-logging:1.2
|         |    \--- commons-codec:commons-codec:1.9
|         \--- org.slf4j:slf4j-api:1.7.24
```
{{% /fragment %}}

---

## Dipendenze *transitive*

Le dipendenze *indirette* (dipendenze di dipendenze) sono dette *transitive*

In progetti non giocattolo, le dipendenze transitive sono la *maggioranza*
* Si fa molto, molto presto ad avere più di 50 dipendenze

Gestire il classpath diventa molto difficile! Ogni libreria va:
* trovata su Internet
* scaricata
* installata
* aggiunta al classpath di compilazione e di esecuzione

L'applicazione di prima viene lanciata con:

`java -cp "build/classes/java/main:lib/API-OMDB-1.5.jar:lib/jool-0.9.14.jar:lib/logback-classic-1.4.1.jar:lib/api-common-2.1.jar:lib/slf4j-api-2.0.2.jar:lib/httpclient-4.5.3.jar:lib/commons-codec-1.10.jar:lib/commons-lang3-3.4.jar:lib/jackson-databind-2.8.7.jar:lib/jackson-core-2.8.7.jar:lib/jackson-annotations-2.8.7.jar:lib/logback-core-1.4.1.jar:lib/httpcore-4.4.6.jar:lib/commons-logging-1.2.jar"
it.unibo.sampleapp.SimplerRateAMovie`

#### *La complessità sfugge presto di mano!*

---

## La gestione delle dipendenze

Ci servirebbe uno strumento capace di:
* *Cercare* (magari in archivi noti) le librerie di cui abbiamo bisogno
* *Scaricare* le suddette (se le trova)
* Costruire il *classpath* e lanciare la *compilazione*
* E magari anche *lanciare l'applicazione*...

Per farlo, però,
abbiamo bisogno di conoscere qualche archivio ("*repository*") di librerie,
e di sapere come reperirle, ossia conoscere il loro *nome* e *versione*...

---

## Librerie "di terze parti" in Java

### Java non definisce alcuno standard per i nomi di libreria

Al compilatore Java e alla JVM
(a differenza di quello che accade con altri linguaggi)
è *ignoto* il concetto di "libreria".
L'unica astrazione che abbiamo in mano è quella di **classpath**,
ma è troppo grezza!
* Usare il solo classpath ci costringerebbe a cercare, scaricare, ed elencare le librerie a mano!

### Standard di fatto: Maven naming convention

Quando Java ha preso piede, è stato necessario sopperire a questa mancanza.
Un particolare build system,
**Apache Maven**,
ha elaborato una propria *convenzione* per i nomi,
divenuta oggi *sostanzialmente standard*
(qualunque build system per Java la adotta).

---

## Maven naming convention

Una libreria Java in formato compatibile con Maven si compone di:
* **groupId**: identifica un (sotto-)progetto o un gruppo di lavoro
  * Segue lo schema di nomi dei package Java, ossia, tipicamente,
  è un URL invertito
    * ad esempio: `it.unibo`, `com.google`, `io.github`
* **artifactId**: identifica una specifica *libreria* o *modulo di progetto*
  * È un nome semplice in kebab-case
    * ad esempio: `commons-math`, `guava`, `junit-jupiter-assertions-jvm`
* **version**: identifica una specifica *versione* di una libreria
  * possono essere numeri o lettere separati da `.`, `-`, o `+` (solitamente numeri e punti)
    * ad esempio: `1.0`, `1.0.1`, `2.3.5-beta4`, `28ae10dd`, `4.0.2-alpha+28ae10dd`
    * tipicamente (ma non sempre) le versioni con soli numeri e punti sono *stabili*

Per riferirsi ad una libreria specifica, si usa la sintassi: `groupId:artifactId:version`
* `com.google.guava:guava:32-jre`
* `it.unibo.alchemist:alchemist-api:25.0.1`

Ora sappiamo come si chiamano, ma non dove trovarle...

---

## The Maven Central Repository (a.k.a. Sonatype OSSRH)

Assieme alla convenzione per i nomi,
Maven definì un *repository* (archivio) dove i creatori di software Java *open source* potessero:
* *pubblicare* le proprie librerie
* *utilizzare* quelle prodotte da sé e da altri $\Leftarrow$ vedremo come!

La disponibilità e la possibilità di **riuso** ha consentito la nascita dell'"ecosistema" Java,
rendendolo uno dei linguaggi/piattaforme di più ampio successo di sempre.

### https://central.sonatype.dev/ (storicamente: https://search.maven.org/)

* È possibile trovare moltissime librerie!
* Oltre a scaricarle, sono documentate le *dipendenze*, che andranno a loro volta scaricate...

Sappiamo *dove* trovare le librerie e *come* riferirle, ma ci serve ancora uno strumento per:
* *scaricarle* in automatico
* scaricare anche tutte le *dipendenze transitive*
  * ricorsivamente!
* gestire i classpath che diventano lunghi e complicati

---

# Dipendenze e Gradle

---

## Gestione delle dipendenze in Gradle

Gradle consente di gestire le dipendenze, specificando:
* Dove andarle a reperire (i cosiddetti "*repository*")
* Qual è il loro *nome*
* Qual è la loro *versione*
* Qual è il loro *scopo* (applicazione o testing, compilazione e/o esecuzione)
  * Infatti, potremmo avere delle librerie che ci servono solo per dei test,
  ma di cui possiamo fare a meno una volta che l'applicazione è testata
    * I produttori di automobili provano il motore sui banchi prova,
    ma quando comprate la macchina non ve lo danno:
    col software è analogo...

---

## Specificare i repository in Gradle

In Gradle è possibile "puntare" ad archivi di librerie specificandolo in un blocco `repositories`
* Maven Central è un membro speciale, e la sua configurazione è semplificata.

Per dire a Gradle di:
1. Preparare il necessario per gestire un progetto Java
2. Configurare Maven Central come *repository* per le eventuali liberie

è sufficiente configurare `build.gradle.kts` come segue:

```kotlin
plugins { java } // Carica il necessario per Java
repositories { mavenCentral() } // Configura Gradle per cercare e scaricare da Maven Central

```

---

## Dipendenze in Gradle: preparazione

Siamo pronti per importare le librerie che vogliamo!
Dobbiamo solo:
1. Trovare su Maven Central la libreria che intendiamo usare e annotare `groupId`, `artifactId`, e `version`
    * per questo esempio: la libreria OMDB di "Omertron"
      * https://central.sonatype.dev/artifact/com.omertron/API-OMDB/1.5
      * `com.omertron:API-OMDB:1.5`
2. Capire quale sia il suo *scope*

### Scopo delle dipendenze in Gradle

Gradle consente di (costringe a) dire chiaramente "a cosa serve" una certa libreria. Noi vedremo solo alcuni degli scope disponibili:
* `implementation`: la libreria ci serve sia per compilare che per eseguire la nostra applicazione
  * è la scelta *più comune*
  * in questa lezione useremo solo questo scope
* `testImplementation`: la libreria ci serve per compilare ed eseguire i test
  * ma non deve essere usabile quando si scrive l'applicazione vera e propria
    * Sarebbe come costruire un motore che richiede pezzi del banco prova per funzionare...
* `testRuntimeOnly`: la libreria ci serve per eseguire i test (sarà nel `-cp` di `java`), ma non per compilarli (*non* sarà nel `-cp` di `javac`)

---

## Dipendenze in Gradle: specifica

Una volta identificata la libreria
* `com.omertron:API-OMDB:1.5`

e scelto lo scope che vogliamo usare
* `implementation`

Possiamo semplicemente configurare Gradle per importarla dentro il blocco `dependencies`:

```kotlin
plugins { java } // Carica il necessario per Java
repositories { mavenCentral() } // Configura Gradle per cercare e scaricare da Maven Central
dependencies {
  implementation("com.omertron:API-OMDB:1.5")
}
```

Quando lanceremo il task `compileJava`, Gradle si occuperà di:
* scaricare la libreria
* salvarla nella cartella dell'utente per uso futuro
* includerla nel classpath di compilazione!

---

Ora sappiamo compilare sorgenti che usano qualunque libreria
* ma se ci sono *dipendenze transitive* (e ci sono quasi sempre) dobbiamo cercare dove Gradle ha scaricato le librerie che ci servono per poter lanciare il programma

{{% fragment %}}
![bello](https://i.imgflip.com/6ux8rp.jpg)
{{% /fragment %}}

{{% fragment %}}
* vorremmo usare Gradle anche per *lanciare* l'applicazione...
{{% /fragment %}}

---

# Lancio di applicazioni Java tramite Gradle

---

## Lanciare applicazioni Java da Gradle

Gradle offre supporto all'esecuzione dell'applicazione,
oltre che alla sua compilazione,
utilizzando il task `run` che viene aggiunto dal plugin `application`.

Per eseguire ci servono due cose:
1. {{% fragment %}} il *nome qualificato* della classe da eseguire {{% /fragment %}}
2. {{% fragment %}} il *classpath* da cui caricare tutte le classi {{% /fragment %}}

{{% fragment %}}
Il classpath è noto, perché lo specifichiamo nelle dipendenze

Il nome della classe, invece, va specificato manualmente

```kotlin
plugins {
  java // Carica il necessario per la compilazione di Java
  application // Carica il necessario per l'esecuzione di classi con la JVM
}
repositories { mavenCentral() } // Configura Gradle per cercare e scaricare da Maven Central
dependencies { // Elenco di librerie che ci servono
  implementation("com.omertron:API-OMDB:1.5")
}
application { // Configurazione dell'esecuzione, la main class è sufficiente
    mainClass.set("it.unibo.sampleapp.SimplerRateAMovie")
}
```

Possiamo ora lanciare la nostra applicazione tramite:
* `gradle run`

{{% /fragment %}}

---

## Il build system come dipendenza

**Problema**: come tutti i software _anche il build system **cambia**_

Se da una versione all'altra di Gradle dovesse cambiare la convenzione,
cosa succederebbe?
* Il nostro software smette di funzionare se aggiorniamo il build system!

E se avessimo *progetti diversi* che richiedono *versioni diverse* di Gradle?

#### Ci serve un modo per:

1. avere sempre *la giusta versione* di Gradle
    * Potenzialmente ogni progetto ha la sua
2. fare in modo che più versioni di Gradle coesistano senza "darsi fastidio"
    * Non vogliamo certo scaricare e installare versioni diverse a seconda del progetto su cui stiamo lavorando
3. già che ci siamo, sarebbe carino se questo sistema sapesse scaricare e installare Gradle, senza richiedere multiple installazioni manuali all'utente

---

## Gradle wrapper

Un insieme di script con un software minimale che:
1. Scarica la versione di Gradle indicata in un file di configurazione
    * se non già disponibile nel sistema
2. Usa quella versione per costruire il nostro sistema software!

Il wrapper può (deve) esser copiato in ogni progetto che gestiamo con Gradle

Dato che il wrapper sa come scaricare ed installare Gradle, non occorre scaricare ed installare gradle manualmente
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

## Utilizzo di Gradle con wrapper

Se abbiamo il Gradle wrapper configurato in un progetto,
possiamo usarlo attraverso uno dei due script:
* `gradlew` (<i class="fab fa-linux"></i>/<i class="fab fa-apple"></i>)
  o `gradlew.bat` (<i class="fab fa-windows"></i>),
  a seconda della nostra piattaforma 
* seguito dall'elenco dei **task**

#### **Nota**

Su sistemi <i class="fab fa-linux"></i> e <i class="fab fa-apple"></i>
per eseguire lo script occorre anche elencare il percorso corrente:
* `./gradlew`

o, in alternativa, chiedere all'interprete dei comandi di eseguire
  * `sh gradlew`
  * `bash gradlew`


