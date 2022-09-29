
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/junit/"]

+++

# Testing in Java con JUnit 5

{{% import path="front-page.md" %}}


## Outline


  
### Goal della lezione

* Introdurre il tema del *testing* del software 
* Introdurre *strumenti* e *processi* per il testing di progetti Java
  
### Argomenti


* *Testing* del software
* *JUnit 5*
* Il meccanismo delle *Annotazioni* in Java
* Sviluppo guidato dai test (*Test-Driven Development*)


---

# Introduzione al testing

---

## Problema: verifica della correttezza dei programmi

* Si consideri la seguente funzionalità: trovare il *più piccolo* *__e__* il *più grande* elemento in un array di interi 

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/test/BuggyNumFinder.java" %}}
```

* Domanda: è *corretto* (ovvero, privo di difetti o *bug*)?

---

## Un primo test

* Scriviamo un programma che ci permetta di *esercitare la funzionalità*

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/test/BuggyNumFinderProgram.java" %}}
```

* Ogni esecuzione sarebbe un *test manuale*
* Vari *test case* possono essere verificati

---

## Proviamo ad *automatizzare* i test

* Scriviamo un programma che *eserciti la funzionalità*

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/test/BuggyNumFinderProgram2.java" %}}
```

* Il controllo dei risultati è ancora manuale

---

## Proviamo ad *automatizzare ulteriormente* i test

* Scriviamo un programma che *testi la funzionalità*

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/test/BuggyNumFinderTest.java" %}}
```

* Controllo *automatico* attraverso confronto di *risultato atteso* vs. *risultato effettivo*
    * ma il codice ha ancora vari problemi di qualità (no isolamento, ripetizioni...)

---

## Introduzione al testing: concetti preliminari

### Errore vs. fallimento vs. difetto/bug

- *__Fallimento__ (__problema__, __anomalia__)*: differenza osservata fra un *risultato attuale* rispetto a un *risultato atteso*
- *__Falla__ (__difetto__, __bug__)*: *causa* di un'anomalia
	* Un fallimento può essere causato da *più bug*
	* Un singolo bug può causare varie anomalie
    * Un bug potrebbe rimanere *latente*, se non osserviamo anomalie
- *__Errore__*: l'azione che ha causato una falla 
    - ad esempio, una distrazione del programmatore
- Quindi la progressione è *Errore $\to$ Difetto/Bug $\to$ Fallimento*

### Una prima definizione di *testing*

- Il *__testing del software__* è quell'attività di *ricerca di anomalie* al fine di *localizzare e rimuovere i difetti* nel software

---

### Verifica vs. validazione

- __Verifica__: controllo di *correttezza* del software rispetto a *specifiche*
    - "Have we build the *thing right*?" (abbiamo costruito [il software] nel modo giusto?)
    - "Un progetto senza specifiche non può essere giusto o sbagliato, ma solo sorprendente!"
    - Tuttavia, le specifiche potrebbero essere incomplete o sbagliate
- __Validazione__: controllo dell'*adeguatezza* del software rispetto alle *aspettative degli stakeholder*
    - "Have we build the *right thing*?"(abbiamo costruito [il software] giusto?)

---

## Definizione di "software testing"

### Definizioni di *software testing* in letteratura

- "An *investigation* conducted to provide stakeholders with information about the *quality* of the software product or service under test" (Cem Kaner/Wikipedia)
 * "*Activity* in which a system or component is executed
under specified conditions, the results are observed or recorded, and an evaluation is made of some aspect of the system or component" (ISO/IEC/IEEE 24765:2010 Systems and software engineering -- Vocabulary)
 * "The process consisting of *all lifecycle activities*, both static and dynamic, concerned with planning, preparation and evaluation of software products and related work products to determine that they *satisfy specified requirements*, to demonstrate that they are *fit for purpose* and to *detect defects*." (ISTQB--International Software Testing Qualifications Board) 
 * "The *overall process* of planning, preparing, and carrying out a suite of *different types of tests* designed to validate a system under development, in order to achieve an acceptable level of *quality* and to avoid unacceptable *risks*"

---

 ### Elementi chiave

 * Attività/processo
    - raccolta dei requisiti, preparazione dei test, esecuzione dei test, ...
 * Varietà di tipologie
    - testing manuale, testing automatico, testing di unità, testing di integrazione, ...
 * Verifica *e* validazione
    - si possono formalizzare dei "criteri di accettazione"
 * Riduzione dei rischi
    - il testing porta ad evitare problemi in futuro
 * Vari stakeholder
    - diversi ruoli coinvolti (programmatore, tester, cliente, integrator, ...)

---

# Testing in pratica

---

## JUnit 5

- Scriviamo un test per la classe `BuggyNumFinder`

<div class="container">
<div class="col">
<div class="smaller">

```java
{{% import-raw from=3 path="pss-code/src/test/java/it/unibo/test/BuggyNumFinderJUnitTest.java" %}}
```

</div>
</div>
<div class="col">

* La classe è una *test suite* che raccoglie *test case* associati all'*unit under test (UUT)* `BuggyNumFinder`
* La classe usa l'API della libreria __JUnit 5__
    - cf. import `org.junit.jupiter.api.*`
* Ogni metodo annotato con `@Test` denota uno (o più) *test case*
* Il metodo annotato con `@BeforeEach` viene eseguito *prima di ogni test case*
    * Serve pr gestire il contesto
* `org.junit.jupiter.api.Assertions` è una classe che fornisce vari metodi per esprimere *asserzioni*
    * `Assertions.assertEquals(e, a)` ha successo se l'oggetto atteso `e` è uguale all'oggetto attuale `a`
</div>
</div>

---

## Annotazioni

- Diciture come `@Test` e `@BeforeEach` sono delle *annotazioni*
- Le **annotazione** sono un meccanismo di Java per fornire informazioni aggiuntive ai costrutti del programma
    - Possono essere analizzate a tempo di compilazione (ad es., dal compilatore di Java) o a tempo d'esecuzione da altri componenti software
- Un'annotazione ha formato `@NomeAnnotazione`
    - Alcune annotazioni possono avere dei parametri
    ```java
    @SomeAnnotation(field1 = 88, field2 = "someString")
    ```
- Quali costrutti del linguaggio Java si possono annotare?
    - dichiarazioni di classe
    - dichiarazioni di campi, metodi
    - ... in vari altri posti ...
- Non vediamo come implementare nuove annotazioni e come processarle, al momento
    - Ma sappiamo che esistono e che si possono usare

---

## Separazione tra sorgenti di test e sorgenti dell'applicazione "principale"

- E' buona prassi tenere i sorgenti di test e i sorgenti dell'applicazione "principale" separati
    - Sorgenti dell'applicazione principale sotto `src/main/java/`
    - Sorgenti di test sotto `src/test/java`
- Questa prassi è così consolidata che è diventata una *convenzione* di organizzazione di sorgenti in progetti Java
    - Strumenti di build come Maven e Gradle utilizzano tale convenzione: dunque, se mettiamo i sorgenti (di test e dell'applicazione principale) nel posto giusto, le cose funzioneranno senza bisogno di configurazione (principio *convention over configuration*)

---

## JUnit 5 e Gradle

- `build.gradle.kts`: supporto per i test 
[<i class="fa-solid fa-link"></i>](https://github.com/junit-team/junit5-samples/junit5-jupiter-starter-gradle)
[<i class="fa-solid fa-link"></i>](https://docs.gradle.org/current/userguide/java_testing.html#java_testing)


```kotlin
plugins {
    java // JavaPlugin aggiunge un source set "test" e un task "test"
}

repositories {
    mavenCentral() // occorre per risolvere le dipendenze di JUnit
}

val junitPlatformVersion = "5.9.1"

dependencies {
    // Dipendenza per scrivere i test
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitPlatformVersion")
    // Dipendenza per eseguire i test
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitPlatformVersion")
}

tasks.test {
    useJUnitPlatform() // configura il task "test" per usare la JUnit Platform
    testLogging { events("passed", "skipped", "failed") }
}
```

```bash
$ ./gradlew test 
$ ./gradlew test --rerun-tasks --tests it.unibo.test.Buggy*Test
```

---

## JUnit 5: architettura

- __JUnit Platform__: piattaforma comune per l'*esecuzione* dei test attraverso l'astrazione di *engine*
    - `org.junit.platform:junit-platform-engine:_`
    - `org.junit.platform:junit-platform-launcher:_` API usata dai build tool e dagli IDE
        - i task Gradle interagiranno con tale componente 
- vari librerie di testing consentono di scrivere test per l'esecuzione sulla JUnit Platform 
    - __JUnit Jupiter__ (JUnit 5):
        - `org.junit.jupiter:junit-jupiter-api:_` API per *scrivere* test
        - `org.junit.jupiter:junit-jupiter-engine:_` engine corrispondente
    - __JUnit Vintage__ (JUnit 4):
        - `org.junit.vintage:junit-vintage-engine:_` engine per test JUnit 4

---

## Unit testing

- Lo **unit testing** è la pratica di testare una unità funzionale in isolamento
- In pratica, facciamo unit testing quando testiamo *una singola classe*
    - cioè, la *classe* è l'unità
- Se abbiamo una classe `SomeClass`, scriveremo un'altra classe `SomeClassTest` che conterrà metodi di test per esercitare la funzionalità offerta da `SomeClass`
- Lo unit testing si distingue dall'**integration testing** che invece è volto a verificare la correttezza dell'integrazione di diverse unità

---

## Esempio

- Supponiamo di voler testare la funzionalità della classe `String`
- Possiamo definire una classe di test `StringTest`
    - sorgente sotto `src/test/java/`

```java
public class StringTest {

}
```

- E' una classe normale.
- All'interno, possiamo aggiungere dei *metodi di test*

---

## Pattern AAA (Arrange - Act - Assert)