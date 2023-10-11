
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/codestyle/"]

+++

# Stile e formattazione del codice

{{% import path="cover.md" %}}


---

## Outline


  
### Goal della lezione



  * Evidenziare l'importanza di uno stile uniforme, consistente, e "standard"
  * Apprendere la scrittura di codice Java ben formattato

  
### Argomenti


  * Convenzioni su *formattazione* di codice sorgente Java
  * Ulteriori convenzioni (cf. getter/setter)
  * *CheckStyle* come strumento di verifica dello stile del codice

---




# Formattazione del codice



## Convenzioni sulla formattazione


  
### Formattazione generale



*  *Indentazione* di 4 caratteri (comunque non 1, non 10..)
*  *Lughezza linee*: non più di 90 caratteri -- spezzare in modo coerente

{{% smaller %}}

```java
// MIGLIORABILE
void m() {
        // indentazione di 8 caratteri, da evitare, in quanto i sorgenti crescono facilmente orizzontalmente
        for(int i : new int[] {1, 2, 3}) {
                if(i % 2 == 0){
                        System.out.println(i);
                }
        }
        System.out.println("Questa è una stringa veramente lunga che potrebbe portare ad infrangere la regola")
}

// OK
void m() {
    for(int i : new int[] {1, 2, 3}) {
        if(i % 2 == 0){
            System.out.println(i);
        }
    }
    System.out.println("Questa è una stringa veramente lunga " + 
        "che potrebbe portare ad infrangere la regola")
}
```

{{% /smaller %}}

---
  
### Commenti nel codice



*  `// ...` su una linea
*  `/* ... */` su più linee per commentare sezioni
*  `/** ... */` su più linee per commenti che generano documentazione

```java
/**
 * (Commento di documentazione)
 * Questa classe modella un generico dispositivo elettronico.
 */
class Device {
    /*
     * Campi di istanza per modellare lo stato del dispositivo.
     */
    boolean on;

    /*
     * Metodi per accensione e spegnimento.
     */
    void switchOn() {
        if(!this.on){
            // Se non acceso, allora accendiamo 
            this.on = true;
        }
    }
    void switchOff() { ... }
}
```

---
  
### Istruzioni



*  Definizione di variabile: una per linea, meglio se a inizio del metodo
*  Meglio inizializzare sempre le variabili!
*  Una sola istruzione per riga 
  
```java
// MIGLIORABILE
int a, b, c;
b = c = 5;
if(a > b) { System.out.println("a = " + a); } else { System.out.println("b = " + b); }

// OK
int a = 0;
int b = 5;
int c = 5;
if(a > b) { 
    System.out.println("a = " + a); 
} else { 
    System.out.println("b = " + b); 
}
```



---



  
### Costrutti vari


* Blocchi e parentesi graffe
    *  Apertura graffa: a fine linea della dichiarazione
    *  Chiusura graffa: in linea a sè, dove inizia la linea che la apre
    *  Usare graffe anche con blocchi ad uno statement
* Espressioni
    * Non usare assegnamenti dentro a espressioni
    *  Disambiguare priorità operatori con parentesi
* Spaziature di diverse "sezioni" del codice
    * Metodi separati da una linea vuota (e non più di 1)

{{% smaller %}}

```java
// MIGLIORABILE
void m()
{
    if(this.disabled ? true : this.unavailable ? true : this.urgent) return; 
}
void f() 
{
    // ...
}

// OK
void m() {
    if(this.disabled ? true : (this.unavailable ? true : this.urgent)) { 
      return; 
    }
}

void f() {
    // ...
}
```

{{% /smaller %}}

---

 
### Nomi



*  **Classi (e interface)**: iniziano con *maiuscola*
    *  Se nome strutturato usare `CamelCasing`
*  **Metodi, campi, variabili**: iniziano con *minuscola*
    *  Se nome strutturato usare `camelCasing`
*  **Package**: interamente in *minuscolo* (anche se parole consecutive), solo lettere
*  **Campi costanti**: tutte *maiuscole* con eventuale separatore `_`

```java
// MIGLIORABILE
package IT.UNIBO.some_package;
class some_class {
    static final int someConstant = 100;

    void Some_Method() { /* ... */ }
}

// OK
package it.unibo.somepackage;

class SomeClass {
    static final int SOME_CONSTANT = 100;
    
    void someMethod() { /* ... */ }
}
```


---

  
### Ordine degli elementi della classe <!-- (`protected` descritto in seguito) -->

1.  Campi statici (pubblici, <!-- poi protetti, --> poi privati -- ovvero, dal più aperto al più chiuso)
2.  Campi istanza (pubblici, <!-- poi protetti, --> poi privati)
3.  Costruttori (pubblici, <!-- poi protetti, --> poi privati)
4.  Metodi (*raggruppati per ruolo*, NON per visibilità, NON alfabeticamente)
  
```java
// MIGLIORABILE
class SomeClass {
    void someMethod() { /* ... */ }

    private static final int SOME_CONSTANT1 = 100;
    public static final int SOME_CONSTANT2 = 100;

    private int someField;
}

// OK
class SomeClass {
    // Campi statici
    public static final int SOME_CONSTANT1 = 100;
    private static final int SOME_CONSTANT2 = 100;

    // Campi d'istanza
    private int someField;
    
    // Metodi d'istanza
    void someMethod() { /* ... */ }
}
```

---
  
### Nota finale

*  L'uso delle corrette convenzioni rende il codice molto più leggibile, ma anche meno conciso
*  Nelle slide è impossibile mostrarlo sempre in questo modo
*  Quindi useremo in futuro solo alcune convenzioni..


---


## Esempio di buona formattazione: `Point3D`

{{% smaller %}}


<div class="container">
<div class="col">

{{% smaller %}}


```java
{{% import-raw from=3 to=35 path="pss-code/src/main/java/it/unibo/formatting/Point3D.java" %}}
```

{{% /smaller %}}

</div>
<div class="col">

{{% smaller %}}

```java
{{% import-raw from=36 path="pss-code/src/main/java/it/unibo/formatting/Point3D.java" %}}
```

{{% /smaller %}}


</div></div>

{{% /smaller %}}


---




# Ulteriori convenzioni e linee guida


## Convenzione Java sui nomi di metodi getter/setter


  
### Metodi getter/setter



*  Un metodo *__getter__* è un metodo che senza input restituisce un valore, una proprietà dell'oggetto
*  Un metodo *__setter__* è un metodo che restituisce `void` e accetta un valore che modifica una proprietà dell'oggetto
*  (Tali proprietà sono spesso campi, ma ciò non è necessario)
*  In `Lamp`, `getIntensity` e `isSwitchedOn` sono getter, `setIntensity` è un setter
  


  
### Convenzione sul nome del metodo: sia data la proprietà `XYZ` di tipo `T`



*  Getter non booleano: `T getXYZ(){...}`
*  Getter booleano: `boolean getXYZ(){...}` o anche `boolean isXYZ() {...}`
*  Setter: `void setXYZ() {...}`
  




---


## Getter/setter in Lamp

```java
public class Lamp {
    ...
    
    // Setter per proprieta' Intensity di tipo double 
    public void setIntensity(double value) {
    	...
    }
    
    // Getter per proprieta' Intensity di tipo double
    public double getIntensity() {
    	...
    }
    
    // Getter per proprieta' SwitchedOn di tipo boolean
    public boolean isSwitchedOn() {
    	...
    }
} 
```

---

## LampUtilities


```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/encapsulation/LampUtilities.java" %}}
```

---

# Strumenti per la qualità

* Vedremo diversi strumenti automatici finalizzati al controllo qualità o *quality assurance (QA)*

---

## Checkstyle

### Cos'è

Checkstyle si occupa di trovare errori di stile:
		
* Mancanza di commento Javadoc, Spaziature non corrette, Parentesi assenti, Magic numbers...
* Altri check: [http://checkstyle.sourceforge.net/checks.html](http://checkstyle.sourceforge.net/checks.html)

### Come funziona

- Si dichiara lo stile desiderato in un file `checkstyle.xml` (un [esempio](https://github.com/DanySK/gradle-java-qa/blob/master/src/main/resources/org/danilopianini/javaqa/checkstyle.xml))
```xml
<?xml version="1.0"?>
<!DOCTYPE module PUBLIC
        "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN"
        "https://checkstyle.org/dtds/configuration_1_3.dtd">
<module name="Checker">
    <property name="charset" value="UTF-8"/>
    <module name="NewlineAtEndOfFile">
        <property name="lineSeparator" value="lf"/>
    </module>
    <module name="LineLength">
      <property name="max" value="85"/>
    </module>
    <!-- ... -->
</module>

```
- Si utilizza il tool `checkstyle` per analizzare codice rispetto allo stile configurato

---

### Integrazione con Gradle

- Plugin [`checkstyle`](https://docs.gradle.org/current/userguide/checkstyle_plugin.html), da dichiarare in `build.gradle.kts`:
```kotlin
plugins {
  java
  checkstyle
}

repositories {
  mavenCentral()
}
```
- Di default, il plugin si aspetta i seguenti file
```txt
<root>
└── config
    └── checkstyle           
        └── checkstyle.xml   
        └── suppressions.xml
```
- Il plugin fornisce il task `check` (che include `checkstyleMain` e `checkstyleTest`)
- L'output dell'analisi viene riportato sotto `build/reports/checkstyle`

---

- Di default, *fallisce la build* se le regole di stile non sono rispettate
```txt
$ ./gradlew check

> Task :checkstyleMain
[ant:checkstyle] [ERROR] /<PATH-TO-PROJ>/src/main/java/.../File.java:4: 
                         Line is longer than 85 characters (found 102). [LineLength]

> Task :checkstyleMain FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':checkstyleMain'.
> A failure occurred while executing org.gradle.api.plugins.quality.internal.CheckstyleAction
   > Checkstyle rule violations were found. See the report at: file:///<PATH-TO-PROJ>/build/reports/checkstyle/main.html
     Checkstyle files with violations: 1
     Checkstyle violations by severity: [error:1]
```
