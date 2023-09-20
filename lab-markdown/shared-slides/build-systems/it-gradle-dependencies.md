
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
