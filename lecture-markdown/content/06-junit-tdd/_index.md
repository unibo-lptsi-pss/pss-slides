
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/junit-tdd/"]

+++

# Unit Testing e Test-Driven Development in Java con JUnit 5

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
- Altra prassi è quella di dichiarare le classi di test *nello stesso package* delle classi di produzione
    - In questo modo, i test possono accedere ai membri package-private

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

## Esempio: classe di test

- Supponiamo di voler testare la funzionalità della classe `String`
- Possiamo definire una *classe di test* `StringTest`
    - sorgente sotto `src/test/java/`

```java
public class StringTest {

}
```

- E' una classe normale.
    - Nel contesto di tale classe, `String` è la nostra *Unit Under Test (UUT)*
- All'interno, possiamo aggiungere dei *metodi di test* (con opportune annotazioni)
    - Quindi, una classe modella una suite di test (case) correlati (ovvero una *test suite*)

---

## Esempio: metodi di test

```java
{{% import-raw from=5 path="pss-code/src/test/java/it/unibo/test/StringTest.java" %}}
```


---

## Test case (casi di test) e metodi di test

### Test case

[(ISTQB Glossary)](https://glossary.istqb.org/en/term/test-case-3) Un **test case** è 

- un insieme di (1) valori di input; (2) precondizioni e postcondizioni d'esecuzione
- sviluppato per un particolare obiettivo o "condizione di test",
  come ad esempio per esercitare un percorso d'esecuzione di un programma
  o verificare la conformità con uno specifico requisito.

### Metodi di test vs. test case

- un metodo di test (ovvero, un metodo void annotato con `@Test`) può esprimere uno *o più* test case

```java
    @Test public void checkContains(){
      String s = "hello world";
      Assertions.assertTrue(s.contains("hello") && !s.contains("bar"));
    } // questo metodo di test copre due test case
```

- cf. *test parametrizzati* (nb: richiedono la dipendenza `junit-jupiter-params`)

```java
@ParameterizedTest @ValueSource(strings = {"hello", "world", " ", ""})
public void checkContainsParameterized(String substr){
    String s = "hello world";
    Assertions.assertTrue(s.contains(substr));
}
```

---

## Pattern AAA (Arrange - Act - Assert)

- E' il tipico pattern di organizzazione dei metodi di test

```java
// Arrange: imposta la UUT (unit under test) e il contesto del test
String s = "hello world";
String substring = "world";
// Act: esercita la funzionalità
boolean contained = s.contains(substring);
// Assert: asserisce l'aspettativa rispetto al risultato effettivo
Assertions.assertTrue(contained);
```

---

## Asserzioni

```java
{{% import-raw from=5 path="pss-code/src/test/java/it/unibo/test/OnAssertions.java" %}}
```

- Note
    - `import static C.m;` consente di importare nello scope il metodo statico `m` della classe `C`
    - E' possibile importare tutti i membri statici con istruzione `import static C.*;`

---

## Ciclo di vita dei test

- Di default, JUnit crea una nuova istanza della classe di test prima di invocare ogni metodo di test
- Esistono delle annotazioni per agganciarci alle varie fasi del ciclo di vita di nostri test
    - `@BeforeAll`, `@AfterAll`: da applicare a un metodo `static`; tale metodo verrà eseguito una sola volta prima o dopo l'esecuzione di tutti i test della classe di test
    - `@BeforeEach`, `@AfterEach`: da applicare a un metodo d'istanza; tale metodo verrà eseguito prima o dopo ogni test case


---

# Introduzione allo sviluppo guidato dai test

---

### Test-Driven Development (TDD)

- Il testing non è da pensare solo come attività da svolgersi *dopo* la fase di sviluppo
- I test possono essere usati per *guidare* l'attività di *progettazione (design)*
    - ovvero, *prima* dell'implementazione effettiva
- Come funziona? Si segue il processo **RED-GREEN-REFACTOR**
    1. **RED**: si scrive un test per catturare la funzionalità che si vuole realizzare (visto che è ancora da implementare, questa fallirà)
    2. **GREEN**: si implementa la funzionalità fino a che il test passa
    3. **REFACTOR**: eventualmente, si migliora l'implementazione
        - rieseguendo i test, saremo sicuri che questi interventi non causano *regressioni*

---

### Esempio TDD: step 1 (RED)

- Si supponga di voler progettare/implementare la funzionalità di un televisore (diciamo, una classe `Tv`)
    - ad es. che modelli accensione/spegnimento e switch del canale
- Prima di implementare la classe `Tv`, scriviamo un test associato
    ```java
    public class TvTest {
        @Test
        public void testTurnOnWhenOff() {
            Tv tv = new Tv();
            Assumptions.assumeTrue(!tv.isOn());
            tv.turnOn();
            Assertions.assertTrue(tv.isOn());
        }
    }
    ```
    - Nota: `Assumptions.assumeTrue(x)` esprime una *assunzione* sul test, ovvero una precondizione che, se non verificata, farà sì che il test venga saltato (*SKIPPED*) dall'esecutore dei test

- Assicuriamoci che tale test compili. Per farlo, dobbiamo inizializzare la classe `Tv`

```java
public class Tv {
    public void turnOn(){  }
    public boolean isOn(){ return false; }
}
```

- Ora *dobbiamo lanciare i test*: dobbiamo vedere **RED** (fallimento)

---

### Esempio TDD: step 2 (GREEN)

- Dopo che abbiamo implementato e visto fallire il test, procediamo ad implementare la funzionalità
    - scriviamo *just enough code* che consenta il test di passare

```java
public class Tv {
    boolean acceso;

    public void turnOn(){ 
        this.acceso = true;
    }

    public boolean isOn(){ 
        return acceso;
    }
}
```

- Eseguiamo i test per assicurarci che la funzionalità è stata implementata correttamente: dobbiamo vedere **GREEN** (cioè devono passare tutti i test)

---

### Esempio TDD: step 3 (REFACTOR)

- Dopo che la funzionalità è stata implementata correttamente, possiamo valutare di applicare miglioramenti al codice
    - sia della UUT, sia del test stesso
- *Per ogni modifica, rieseguiamo i test* per assicurarci di non aver introdotto regressioni
    - Una **regressione** si ha quando si introduce un difetto su un componente che prima non presentava tale difetto

<div class="container">
<div class="col">

```java
public class Tv {
    boolean on;

    public Tv(){
        this.on = false;
    }

    public void turnOn(){ 
        this.on = true;
    }

    public boolean isOn(){ 
        return on;
    }
}
```

</div>
<div class="col">

```java
    public class TvTest {
        Tv tv;

        @BeforeEach
        public void setUp(){ tv = new Tv(); }

        @Test
        public void testTurnOnWhenOff() {
            Assumptions.assumeTrue(!tv.isOn());
            tv.turnOn();
            Assertions.assertTrue(tv.isOn());
        }
    }
```

</div>
</div>

---

### Esempio TDD: dopo REFACTOR?

- Terminata un'iterazione RED-GREEN-REFACTOR, si può procedere a un'altra iterazione, ovvero alla realizzazione di un incremento di funzionalità
- Potete provare voi stessi
    - funzionalità di spegnimento: `turnOff()`
    - modellazione del canale `Channel` e dello switch dei canali `switch(Channel)`

---

## E ora?

### Un nuovo strumento nella vostra "toolbox" di sviluppatori software

- Consolideremo la vostra familiarità con lo *unit testing* già in laboratorio

### Tanto altro ...

- Il tema del testing del software è molto ampio
- Esistono *figure professionali* specializzate nel testing
    - cf. Google *Test Engineer (TE)*
- Esistono tanti altri concetti importanti
    - *test double*, *ispezione*, ...
- Esistono tantissime *tecniche* di testing
    - *property-based testing*, *mutation testing*, ...
- Esistono tantissimi *strumenti* a supporto di varie tipologie di test
    - *Cucumber*, *Mountebank*, *Akka TestKit* ...
- C'è molta letturatura sul testing
    - *pattern* per il testing, ...
