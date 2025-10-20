
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/codestyle/"]

+++

# Stile e formattazione del codice

{{% import path="front-page.md" %}}


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
*  *Lughezza linee*: non più di 130 caratteri -- spezzare in modo coerente
   * storicamente 80 caratteri, ma oggi si usano monitor più larghi

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
        System.out.println("Questa è una stringa veramente lunga che potrebbe portare ad infrangere la regola, quindi la spezziamo");
}

// OK
void m() {
    for(int i : new int[] {1, 2, 3}) {
        if(i % 2 == 0){
            System.out.println(i);
        }
    }
    System.out.println(
        "Questa è una stringa veramente lunga "
            + "che potrebbe portare ad infrangere la regola"
            + " quindi la spezziamo"
    );
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



*  Definizione di variabile: una per linea, immediatamente prima dell'uso
*  Meglio inizializzare sempre le variabili!
*  Una sola istruzione per riga 
  
```java
// MIGLIORABILE
int a, b, c;
b = c = 5;
if(a > b) { System.out.println("a = " + a + ", c = " + c); } else { System.out.println("b = " + b); }

// OK
int a = 0;
int b = 5;
if(a > b) {
    int c = 5;
    System.out.println("a = " + a + ", c = " + c); 
} else { 
    System.out.println("b = " + b); 
}
```



---



  
### Costrutti vari


* Blocchi e parentesi graffe; **K&R**, applicato anche alle funzioni
    *  Apertura graffa: a fine linea della dichiarazione
    *  Chiusura graffa: in linea a sè, dove inizia la linea che la apre
    *  Usare graffe anche con blocchi ad uno statement!
* Espressioni
    * Non usare assegnamenti dentro a espressioni
* Spaziature di diverse "sezioni" del codice
    * Metodi separati da una linea vuota (e non più di 1)
    * Internamente ai metodi, separare sezioni logiche con commenti, evitando linee vuote

{{% smaller %}}

```java
// MIGLIORABILE
void m() // Allman style, da evitare in Java (si usa invece in C#)
{
    if (this.disabled ? true : this.unavailable ? true : this.urgent) return; 
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
    * Usare `PascalCase`
*  **Metodi, campi, variabili**: iniziano con *minuscola*
    * Usare `camelCase`
* **Package**: interamente in *minuscolo* (anche se parole consecutive), solo lettere
* **Campi costanti**: tutte *maiuscole* con eventuale separatore `_`
    * Usare `SCREAMING_SNAKE_CASE`

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

1.  Campi statici
2.  Campi istanza
3.  Costruttori
4.  Metodi
  
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


## Esempio di buona formattazione: `Point3D`


<div class="container">
<div class="col">

```java
{{% import-raw from=3 to=34 path="pss-code/src/main/java/it/unibo/formatting/Point3D.java" %}}
```

</div>
<div class="col">

```java
{{% import-raw from=35 path="pss-code/src/main/java/it/unibo/formatting/Point3D.java" %}}
```

</div></div>

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

# Stile e formattazione del codice

{{% import path="front-page.md" %}}
