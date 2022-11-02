
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/advanced-mechanisms-nested-enums/"]

+++

# Meccanismi avanzati: classi innestate, enum ...

<!-- {{% import path="front-page.md" %}} -->

{{% import path="cover.md" %}}

---


## Outline


  
### Goal della lezione



*  Illustrare meccanismi avanzati della programmazione OO
*  Dare linee guida sul loro utilizzo
  


  
### Argomenti



*  Enumerazioni
*  Classi innestate statiche
*  Inner class
*  Classi locali
*  Classi anonime
*  Mappe del Collection Framework
  




---


# Classi innestate statiche

---




frametitle{Classi innestate statiche -- idea e terminologia}
  
### Principali elementi



    *  Dentro una classe `A`, chiamata *__outer__* è possibile innestare la definizione di un'altra classe `B`, chiamata *__innestata (statica)__* -- in inglese, *__static nested__*
    *  `B` viene quindi vista come se fosse una proprietà `statica` di `A` (richiamabile via `A`, come: tipo, per le `new` e le chiamate statiche)
  


```java
// situazione di partenza
class A {...}
class B {...}
\end{lstlisting}
\begin{lstlisting}
// modifica, usando le inner class
class A {
    ...
    static class B { .. }
}
```

---


## Classi innestate statiche -- casistica

### Possibilità di innestamento



    *  Anche una interfaccia può fungere da `Outer`
    *  Si possono innestare anche interfacce
    *  Il nesting può essere multiplo e/o multilivello
    *  L'accesso alle classi/interfacce innestate statiche avviene con sintassi `Outer.A`, `Outer.B`, `Outer.I`, `Outer.A.C`
  

```java
class Outer {
    ...
    static class A { .. static class C{..} ..}
    static class B {..}
    interface I {..} // static è implicito
}
```


---



## Classi innestate statiche -- accesso

### Uso

*  L'accesso alle classi/interfacce innestate statiche avviene con sintassi `Outer.StaticNested`
*  Da dentro `Outer` si può accedere anche direttamente con `StaticNested`
*  L'accesso da fuori `Outer` di `StaticNested` segue le regole del suo modificatore d'accesso
*  Esterna e interna si vedono a vicenda anche le proprietà `private`
  

```java
class Outer {
    ...
    static class StaticNested { 
       ...
    }
}
..
Outer.StaticNested obj = new Outer.StaticNested(...);
```

---



## Motivazioni

### Una necessità generale


Vi sono situazioni in cui per risolvere un singolo problema è opportuno generare più classi, e non si vuole affiancarle solo come classi dello stesso package
  

  
### Almeno tre motivazioni (non necessariamente contemporanee)



*  Evitare il proliferare di classi in un package, specialmente quando solo una di queste debba essere pubblica
*  Migliorare l'incapsulamento, con un meccanismo per consentire un accesso locale anche a proprietà `private`
*  Migliorare la leggibilità, inserendo classi là dove serve (con nomi qualificati, quindi più espressivi)
*  ..meglio comunque non abusare di questo meccanismo
  



---


## Caso 1


    
### Specializzazioni come classi innestate



*  La classe astratta, o comunque base, è la outer
*  Alcune specializzazioni ritenute frequenti e ovvie vengono innestate, ma comunque rese pubbliche
*  due implicazioni: 
	  *  schema di nome delle inner class
	  *  possibilità di accedere alle proprietà statiche
    


    
### Esempio



*  `Counter`, `Counter.Bidirectional`, `Counter.Multi`
    


    
### Note


Un sintomo della possibilità di usare le classi nested per questo caso è quando ci si trova a costruire classi diverse costuite da un nome composto con una parte comune (`Counter`, `BiCounter`, `MultiCounter`)
    



---


## Classe `Counter` e specializzazioni innestate (1/2)

```java
{{% import-raw from=1 to=100 path="code/advanced-mechanisms/nested/Counter_.java" %}}
```


---


## Classe `Counter` e specializzazioni innestate (2/2)



```java
{{% import-raw from=1 to=100 path="code/advanced-mechanisms/nested/Counter_2.java" %}}
```

---


## Uso di `Counter` e specializzazioni innestate


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/nested/UseCounter.java" %}}
```



---


## Caso 2


    
### Necessità di una classe separata ai fini di ereditaerità


In una classe potrebbero servire sotto-comportamenti che debbano:
    

*  implementare una data interfaccia
*  estendere una data classe
    


    
### Esempio



*  `Range`, `Range.Iterator`
    


    
### Nota


In tal caso spesso tale classe separata non deve essere visibile dall'esterno, quindi viene indicata come `private`
    



---


## Classe `Range` e suo iteratore (1/2)



```java
{{% import-raw from=1 to=100 path="code/advanced-mechanisms/nested/Range_.java" %}}
```

---


## Classe `Range` e suo iteratore (2/2)


```java
{{% import-raw from=1 to=100 path="code/advanced-mechanisms/nested/Range_2.java" %}}
```

---


## Uso di `Range`


```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/advancedmechanisms/nested/UseRange.java" %}}
```

---


## Caso 3


    
### Necessità di comporre una o più classi diverse



*  Ognuna realizzi un sotto-comportamento
*  Per suddividere lo stato dell'oggetto
*  Tali classi non utilizzabili indipendentemente dalla outer
    


    
### Esempio tratto dal Collection Framework



*  `Map`, `Map.Entry`
*  (una mappa è "osservabile" come set di entry)
    




---


## Riassunto classi innestate statiche


    
### Principali aspetti



*  Da fuori (se pubblica) vi si accede con nome `Outer.StaticNested`
*  `Outer` e `StaticNested` sono co-locate: si vedono le proprietà `private`
    


    
### Motivazione generale



*  Voglio evitare la proliferazione di classi nel package
*  Voglio sfruttare l'incapsulamento
    


    
### Motivazione per il caso `public`



*  Voglio enfatizzare i nomi `Out.C1`, `Out.C2`,..
    


    
### Motivazione per il caso `private` -- è il caso più frequente



*  Voglio realizzare una classe a solo uso della outer, invisibile alle altre classi del package
    




---




# Il caso delle `java.util.Map`



## JCF -- struttura semplificata


![](imgs/tax.png)



---


## `Map`



```java
{{% import-raw from=1 to=100 path="code/advanced-mechanisms/short/Map_.java" %}}
```

---






## Implementazione mappe -- UML


![](imgs/uml-abs.png)


---


## `Map.Entry`



### Ruolo di `Map.Entry`



    *  Una mappa può essere vista come una collezione di coppie chiave-valore, ognuna incapsulata in un `Map.Entry`
    *  Quindi, una mappa è composta da un set di `Map.Entry`



```java
{{% import-raw from=1 to=100 path="code/advanced-mechanisms/short/Map_2.java" %}}
```

---



## Uso di `Map.Entry`


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/map/UseMap2.java" %}}
```



---


## La classe `AbstractMap`


  
### In modo simile a `AbstractSet`



*  Fornisce una implementazione scheletro per una mappa
*  Necessita di un solo metodo da implementare: `entrySet()`
*  Così facendo si ottiene una mappa iterabile e non modificabile
*  Per fare modifiche è necessario ridefinire altri metodi..
  




---


## Una semplice specializzazione di `AbstractMap`


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/map/CapitalsMap.java" %}}
```



---


## `UseCapitalsMap`


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/map/UseCapitalsMap.java" %}}
```



---


# Inner Class

---



## Inner Class -- idea

### Principali elementi



*  Dentro una classe `Outer`, è possibile innestare la definizione di un'altra classe `InnerClass`, senza indicazione `static`!
*  `InnerClass` è vista come se fosse una proprietà *__non-statica__* di `Outer` al pari di altri campi o metodi
*  L'effetto è che una istanza di `InnerClass` ha sempre un riferimento ad una istanza di `Outer` (enclosing instance) che ne rappresenta il *__contesto__*, accessibile con la sintassi `Outer.this`, e ai suoi campi (privati) 
  

```java
class Outer {
    ...
    class InnerClass { // Nota.. non è static!
        ...
        // ogni oggetto di InnerClass avrà un riferimento ad
        // un oggetto di Outer, denominato Outer.this
    }
}
```


---


## Un semplice esempio


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/nested/Outer.java" %}}
```



---


## Uso di `Inner` e `Outer`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/nested/UseOuter.java" %}}
```



---


## Enclosing instance -- istanza esterna


    
### Gli oggetti delle inner class



*  Sono creati con espressioni: `<obj-outer>.new <classe-inner>(<args>)`
*  (la parte `<obj-outer>` è omettibile quando sarebbe `this`)
*  Possono accedere all'enclosing instance con notazione `<classe-outer>.this`
    


    
### Motivazioni: quelle relative alle classi innestate statiche, più..



*  ...quando è necessario che ogni oggetto inner tenga un riferimento all'oggetto outer
*  pragmaticamente: usato quasi esclusivamente il caso `private`
    


    
### Esempio



*  La classe `Range` già vista usa una static nested class, che però ben usufruirebbe del riferimento all'oggetto di `Range` che l'ha generata
    




---


## Una variante di `Range`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/nested/Range2.java" %}}
```



---


# Classi locali

---




## Classi locali -- idea

### Principali elementi



*  Dentro un metodo di una classe `Outer`, è possibile innestare la definizione di un'altra classe `LocalClass`, senza indicazione `static`!
*  La `LocalClass` è a tutti gli effetti una inner class (e quindi ha enclosing instance)
*  In più, la `LocalClass` "vede" anche le variabili nello scope del metodo in cui è definita, *__usabili solo se final__*, o se "di fatto finali"
  


```java
class Outer {
    // ...
    void m(final int x){
        final String s=..;
        class LocalClass { // Nota.. non è static!
        // ... // può usare Outer.this, s e x
        }
        LocalClass c=new LocalClass(...);
    }
}
```

---


## `Range` tramite classe locale


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/nested/Range3.java" %}}
```



---


## Classi locali -- motivazioni


    
### Perché usare una classe locale invece di una inner class



*  Tale classe è necessaria solo dentro ad un metodo, e lì la si vuole confinare
*  È eventualmente utile accedere anche alle variabili del metodo
    


    
### Pragmaticamente



*  Mai viste usarle.. si usano invece le classi anonime..
    




---


# Classi anonime

---



## Classi anonime -- idea
  
### Principali elementi



    *  Con una variante dell'istruzione `new`, è possibile innestare la definizione di un'altra classe senza indicarne il nome
    *  In tale definizione non possono comparire costruttori
    *  Viene creata al volo una classe locale, e da lì se ne crea un oggetto
    *  Tale oggetto, come per le classi locali, ha enclosing instance e "vede" anche le variabili *__final__* (o di fatto finali) nello scope del metodo in cui è definita
  


```java
class C {
    // ...
    Object m(final int x){
        return new Object(){
             public String toString(){ return "Valgo "+x; }
        }
    }
}
```

---


## `Range` tramite classe anonima -- la soluzione ottimale


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/nested/Range4.java" %}}
```



---


## Classi anonime -- motivazioni


    
### Perchè usare una classe anonima?



*  Se ne deve creare un solo oggetto, quindi è inutile anche solo nominarla
*  Si vuole evitare la proliferazione di classi
*  Tipicamente: per implementare "al volo" una interfaccia
    




---


## Altro esempio: classe anonima da  `Comparable`


   
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/nested/UseSort.java" %}}
```



---


## Riassunto e linee guida


    
### Inner class (e varianti)


Utili quando si vuole isolare un sotto-comportamento in una classe a sé, senza dichiararne una nuova che si affianchi alla lista di quelle fornite dal package, ma stia "dentro" una classe più importante
    

    
### Se deve essere visibile alle altre classi



*  Quasi sicuramente, una static nested class
    


    
### Se deve essere invisibile da fuori



*  Si sceglie uno dei quattro casi a seconda della visibilità che la inner class deve avere/dare{
    *  static nested class: solo parte statica
    *  inner class: anche enclosing class, accessibile ovunque dall'outer
    *  local class: anche argomenti/variabili, accessibile da un solo metodo
    *  anonymous class: per creare un oggetto, senza un nuovo costruttore


---


## Preview lambda expressions


    
### Un pattern molto ricorrente



*  Avere classi anonime usate per incapsulare metodi "funzionali"
*  Java 8 introduce le lambda come notazione semplificata
*  È il punto di partenza per la combinazione OO + funzionale
    


    
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/nested/UseSortLambda.java" %}}
```



---


# Enumerazioni


## Enumerazioni


  
### Motivazioni



*  in alcune situazioni occorre definire dei tipi che possono assumere solo un numero fissato e limitato di possibili valori
*  Esempi:
	  *  le cifre da 0 a 9, le regioni d'Italia, il sesso di un individuo, i 6 pezzi negli scacchi, i giorni della settimana, le tipologie di camere di un hotel, le scuole di un ateneo, eccetera


  
### Possibili realizzazioni in Java



*  usare delle `String` rappresentando il loro nome: quasi assurdo
*  usare degli `int` per codificarli (come in C): poco leggibile
*  usare delle classi astratte, e una concreta per valore: prolisso
  


  
### Enumerazioni: `enum E { ... }`


*  consentono di elencare i valori, associando ad ognuno un nome
*  è possibile collegare metodi e campi ad ogni "valore"
  

---


## Esempio classe `Persona`: 1/2


  
```java
{{% import-raw from=5 to=19 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en/Persona.java" %}}
```



---


## Esempio classe `Persona`: 2/2


  
```java
{{% import-raw from=19 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en/Persona.java" %}}
```



---


## `UsePersona`


  
```java
{{% import-raw from=6 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en/UsePersona.java" %}}
```



---


## Soluzione alternativa, `Persona`: 1/2



```java
{{% import-raw from=3 to=100 path="code/advanced-mechanisms/enums/PersonaBis_1.java" %}}
```

---


## Soluzione alternativa `Persona`: 2/2



```java
{{% import-raw from=3 to=100 path="code/advanced-mechanisms/enums/PersonaBis_2.java" %}}
```

---


## Soluzione alternativa `UsePersona`


  
```java
{{% import-raw from=3 to=100 path="code/advanced-mechanisms/enums/UsePersonaBis.java" %}}
```



---


## Discussione


    
### Approccio a stringhe



*  Penalizza molto le performance spazio-tempo
*  Può comportare errori gravi per scorrette digitazioni
*  Difficile intercettare gli errori
    


    
### Approccio a interi -- soluzione pre-enumerazioni



*  Buone performance ma cattiva leggibilità
*  Può comportare comunque errori, anche se più difficilmente
*  L'uso delle costante è un poco dispersivo
    


    
### altri approcci: uso di classi diverse per ogni valore



*  Impraticabile con un numero molto elevato di valori
*  Comunque molto prolisso in termini di quantità di codice
*  Tuttavia:
	  *  Previene gli errori che si possono commettere
	  *  Consente facilmente di aggiungere nuovi elementi
    




---


## Soluzione via costanti e costruttore privato


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en/Regione.java" %}}
```



---


## `UseRegione`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en/UseRegione.java" %}}
```



---


## `enum` in Java


    
### Un nuovo tipo di dato



*  Simile ad una classe
*  Realizza l'approccio a costanti e costruttore privato
*  Ottime performance, l'oggetto è già disponibile
*  Impedisce interamente errori di programmazione
*  Il codice aggiuntivo da produrre non è elevato
    


    
### Unica precauzione



*  Andrebbero usate per insiemi di valori che difficilmente cambieranno in futuro
*  Difficile modificare il codice successivamente
    




---


## `enum Regione`

  
```java
{{% import-raw from=1 to=100 path="code/advanced-mechanisms/enums2/Regione.java" %}}
```

```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en2/UseEnum.java" %}}
```



---


## `Persona` con uso della `enum`


  
```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en2/Persona.java" %}}
```



---



## `UsePersona` con uso della `enum`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en2/UsePersona.java" %}}
```



---


## `UsePersona` con *__import static__*


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en2/UsePersona2.java" %}}
```



---


## Metodi di default per ogni `enum`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en2/UseRegione.java" %}}
```



---



## `enum` negli `switch`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en2/UseRegione2.java" %}}
```



---



## Metodi aggiuntivi nelle `enum`: `Zona`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en3/Zona.java" %}}
```



---


## Metodi e campi aggiuntivi nelle `enum`: `Regione` (1/2)


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en3/Regione.java" %}}
```



---


## Metodi e campi aggiuntivi nelle `enum`: `Regione` (2/2)


  
```java
{{% import-raw from=20 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en3/Regione.java" %}}
```



---



## Metodi e campi aggiuntivi nelle `enum`: `UseZona`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en3/UseZona.java" %}}
```



---


## Meccanismi per le `enum`


    
### Riassunto



*  Esistono metodi istanza e statici disponibili per `Enum`
*  Si possono aggiungere metodi
*  Si possono aggiungere campi e costruttori
    


    
### Riguardando la `enum Regione`



*  È una classe standard, con l'indicazioni di alcuni oggetti predefiniti
*  I 20 oggetti corrispondenti alle regioni italiane
    


    
### Quindi



*  È possibile intuirne la realizzazione interna
*  E quindi capire meglio quando e come usarli
* $\Rightarrow$ In caso in cui i valori sono "molti e sono noti", oppure..
* $\Rightarrow$ Anche se i valori sono pochi, ma senza aggiungere troppi altri metodi..
    




---


## `enum` innestate


    
### Motivazione



*  Anche le `enum` (statiche) possono essere innestate in una classe o interfaccia o enum
*  Questo è utile quando il loro uso è reputato essere confinato nel funzionamento della classe outer
    


    
### Esempio



*  `enum Regione` potrebbe essere inserita dentro `Persona`
*  `enum Zona` potrebbe essere inserita dentro `Regione`
    

   