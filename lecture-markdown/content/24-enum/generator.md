
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/advanced-mechanisms-enums/", "enum", "enums"]

+++

# Enumerazioni e gerarchie sealed

{{% import path="front-page.md" %}}

---


## Outline


  
### Goal della lezione



*  Illustrare il concetto di enumerazione e le sue implementazioni in Java
*  Modellare famiglie di sottotipi con interfacce e classi `sealed`
*  Distinguere un insieme chiuso di valori da una gerarchia con sottotipi controllati

---

## Enumerazioni


  
### Motivazioni



*  in alcune situazioni occorre definire dei tipi che possono assumere solo un numero fissato e limitato di possibili valori
*  Esempi:
	  * le regioni d'Italia, il sesso di un individuo, i 6 pezzi negli scacchi, i giorni della settimana, le tipologie di camere di un hotel, le scuole di un ateneo, eccetera


  
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
{{% import-raw from=1 to=100 path="code/advanced-mechanisms/enums/PersonaBis_2.java" %}}
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
    


    
### Altri approcci: uso di classi diverse per ogni valore



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



*  Andrebbero usate *per insiemi di valori che difficilmente cambieranno in futuro*
    *  Difficile modificare il codice successivamente (!)  




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


## Dalle enumerazioni alle gerarchie `sealed`

* Una `enum` definisce un insieme fissato di **oggetti**, come i giorni della settimana
* Talvolta sono fissate le **varianti** del dominio, ma ogni variante ha molte istanze
    * Una figura può essere un cerchio o un rettangolo, ciascuno con dimensioni diverse
* Un'interfaccia ordinaria può essere implementata da nuove classi senza restrizioni
* Una `sealed interface` permette di stabilire quali siano i suoi sottotipi diretti

### Supporto del linguaggio

* Classi e interfacce `sealed` sono una funzionalità definitiva da **Java 17**

---

## Una `sealed interface`: `Figura`

```java
sealed interface Figura permits Cerchio, Rettangolo {
    double area();
}

final class Cerchio implements Figura {
    private final double raggio;

    Cerchio(double raggio) {
        this.raggio = raggio;
    }

    public double area() {
        return Math.PI * raggio * raggio;
    }
}
```

* `permits` elenca i soli sottotipi diretti ammessi
* `Cerchio` è `final`: nessuna classe può estenderlo

---

## L'altra variante e l'uso polimorfo

```java
final class Rettangolo implements Figura {
    private final double base;
    private final double altezza;

    Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double area() {
        return base * altezza;
    }
}
```

```java
Figura prima = new Cerchio(2);
Figura seconda = new Rettangolo(3, 4);
System.out.println(prima.area());   // circa 12.57
System.out.println(seconda.area()); // 12.0
```

---

## Le regole di una gerarchia `sealed`

* Ogni sottotipo elencato in `permits` deve estendere o implementare direttamente il tipo sigillato
* Una classe direttamente derivata deve dichiararsi:
    * `final`: termina il ramo della gerarchia
    * `sealed`: controlla a sua volta i propri sottotipi diretti
    * `non-sealed`: apre il ramo a ulteriori estensioni libere
* Una sottointerfaccia diretta deve essere `sealed` oppure `non-sealed`
* I sottotipi ammessi devono appartenere allo stesso package nel caso ordinario senza moduli
    * Con moduli nominati, devono appartenere allo stesso modulo
* `permits` può essere omesso se tutti i sottotipi diretti sono dichiarati nello stesso file

---

## Classi `sealed` e rami aperti

```java
sealed abstract class Messaggio permits Testo, Estensione {
    public abstract String contenuto();
}

final class Testo extends Messaggio {
    public String contenuto() {
        return "Ciao";
    }
}

non-sealed abstract class Estensione extends Messaggio { }
```

* Anche una classe, eventualmente astratta, può essere `sealed`
* Altre classi possono estendere `Estensione` e fornire `contenuto()`
* `sealed` controlla i **sottotipi diretti**; un ramo `non-sealed` resta aperto

---

## `enum`, gerarchie `sealed` e gerarchie aperte

| Meccanismo | Cosa viene fissato | Esempio |
| --- | --- | --- |
| `enum` | Le istanze dichiarate come costanti | Giorni della settimana |
| `sealed` con rami chiusi | Le varianti, ciascuna con più istanze | Figure con dimensioni diverse |
| Interfaccia ordinaria | Il contratto, con implementazioni estendibili liberamente | Nuove strategie di ordinamento |

* `sealed` esprime un vincolo sul modello del dominio
* I metodi si invocano con il consueto polimorfismo
* Una nuova variante richiede di rivedere il codice che considera tutti i casi

<!-- Fonti: https://openjdk.org/jeps/409 e https://docs.oracle.com/en/java/javase/17/language/sealed-classes-and-interfaces.html -->

---

# Enumerazioni e gerarchie sealed

{{% import path="front-page.md" %}}
