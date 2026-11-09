
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


## Esempio classe `Person`: 1/2


  
```java
{{% import-raw from=5 to=19 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en/Person.java" %}}
```



---


## Esempio classe `Person`: 2/2


  
```java
{{% import-raw from=19 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en/Person.java" %}}
```



---


## `UsePerson`


  
```java
{{% import-raw from=6 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en/UsePerson.java" %}}
```



---


## Soluzione alternativa, `Person`: 1/2



```java
{{% import-raw from=3 to=100 path="code/advanced-mechanisms/enums/PersonaBis_1.java" %}}
```

---


## Soluzione alternativa `Person`: 2/2



```java
{{% import-raw from=1 to=100 path="code/advanced-mechanisms/enums/PersonaBis_2.java" %}}
```

---


## Soluzione alternativa `UsePerson`


  
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
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en/Region.java" %}}
```



---


## `UseRegion`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en/UseRegion.java" %}}
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


## `enum Region`

  
```java
{{% import-raw from=1 to=100 path="code/advanced-mechanisms/enums2/Regione.java" %}}
```

```java
{{% import-raw from=3 to=30 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en2/UseEnum.java" %}}
```



---


## `Person` con uso della `enum`


  
{{% smaller %}}

```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en2/Person.java" %}}
```

{{% /smaller %}}



---



## `UsePerson` con uso della `enum`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en2/UsePerson.java" %}}
```



---


## `UsePerson` con *__import static__*


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en2/UsePerson2.java" %}}
```



---


## Metodi di default per ogni `enum`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en2/UseRegion.java" %}}
```



---



## `enum` negli `switch`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en2/UseRegion2.java" %}}
```

---

## Lo `switch` con la freccia `->`

Lo stesso switch di `UseRegion2`, nella forma introdotta da **Java 14**:

```java
switch (r) {
    case LOMBARDIA -> IO.println("Lombardia");
    case EMILIA_ROMAGNA -> IO.println("Emilia Romagna");
    default -> IO.println("Altre..");
}
```

* Con `->` si esegue **solo** il ramo scelto: niente `break`
    * nessun rischio di "cadere" per sbaglio nel caso successivo (*fall-through*)
* Un caso può elencare più costanti: `case SARDEGNA, SICILIA -> ...`

---

## Lo `switch` come espressione

Uno switch può anche **calcolare un valore**:

```java
boolean island = switch (r) {
    case SARDEGNA, SICILIA -> true;
    default -> false;
};
```

* Il ramo scelto fornisce il valore dell'intera espressione
* Un'espressione deve sempre produrre un valore, quindi lo switch deve essere **esaustivo**:
    * o elenca **tutte** le costanti della `enum` (es. `NORTH`, `CENTER`, `SOUTH`: nessun `default`)
    * o usa `default` per "tutti gli altri casi"
* Se manca un caso, il codice **non compila**
* ⇒ Ritroveremo l'esaustività con le gerarchie `sealed`



---



## Metodi aggiuntivi nelle `enum`: `Zone`


  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en3/Zone.java" %}}
```



---


## Metodi e campi aggiuntivi nelle `enum`: `Region` (1/2)

  
```java
{{% import-raw from=3 to=25 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en3/Region.java" %}}
```

---


## Metodi e campi aggiuntivi nelle `enum`: `Region` (2/2)
  
```java
{{% import-raw from=20 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en3/Region.java" %}}
```

---


## Metodi e campi aggiuntivi nelle `enum`: `UseZone`
  
```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/advancedmechanisms/enums/en3/UseZone.java" %}}
```

---


## Meccanismi per le `enum`
    
### Riassunto

*  Esistono metodi istanza e statici disponibili per `Enum`
*  Si possono aggiungere metodi
*  Si possono aggiungere campi e costruttori
    
### Riguardando la `enum Region`

*  È una classe standard, con l'indicazioni di alcuni oggetti predefiniti
*  I 20 oggetti corrispondenti alle regioni italiane
    
### Quindi

*  È possibile intuirne la realizzazione interna
*  E quindi capire meglio quando e come usarli
* ⇒ In caso in cui i valori sono "molti e sono noti", oppure..
* ⇒ Anche se i valori sono pochi, ma senza aggiungere troppi altri metodi..

---


## Dalle enumerazioni alle gerarchie `sealed`

* Una `enum` definisce un insieme fissato di **oggetti**, come i giorni della settimana
* Talvolta sono fissate le **varianti** del dominio, ma ogni variante ha molte istanze
    * Una figura può essere un cerchio o un rettangolo, ciascuno con dimensioni diverse
* Un'interfaccia ordinaria può essere implementata da nuove classi senza restrizioni
* Una `sealed interface` **chiude** la gerarchia: con `permits` elenca *tutti* i suoi **sottotipi diretti**
    * sottotipi diretti: le classi che la implementano (o le interfacce che la estendono) senza intermediari
    * ogni altra classe che provi a implementarla causa un **errore di compilazione**
* **Esempio**: descriviamo le figure geometriche con il concetto di "figura"
    * una figura potrà essere **solo** un cerchio o un rettangolo: nessun'altra figura è ammessa
    * quindi, se passo una figura a un metodo, questa sarà per forza un cerchio o un rettangolo

### Supporto del linguaggio

* Classi e interfacce `sealed` sono una funzionalità definitiva da **Java 17**

---

## Una `sealed interface`: `Figure`

```java
sealed interface Figure permits Circle, Rectangle {
    double area();
}

final class Circle implements Figure {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}
```

* `permits` elenca i soli sottotipi diretti ammessi
* `Circle` è `final`: nessuna classe può estenderlo

---

## L'altra variante e l'uso polimorfo

```java
final class Rectangle implements Figure {
    private final double width;
    private final double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}
```

```java
Figure first = new Circle(2);
Figure second = new Rectangle(3, 4);
IO.println(first.area());  // circa 12.57
IO.println(second.area()); // 12.0
```

---

## Le regole di una gerarchia `sealed`

* Ogni sottotipo elencato in `permits` deve estendere o implementare direttamente il tipo sigillato
* Una classe direttamente derivata deve dichiararsi:
    * `final`: termina il ramo della gerarchia
    * `sealed`: controlla a sua volta i propri sottotipi diretti
    * `non-sealed`: apre il ramo a ulteriori estensioni libere
* Una sottointerfaccia diretta deve essere `sealed` oppure `non-sealed`
* **Dove** stanno i sottotipi ammessi?
    * Basta che stiano nello **stesso package** (o nello stesso modulo, se si usano i moduli), anche in file diversi
    * Di norma ognuno ha il proprio file, come ogni classe `public`
    * Solo se sono **tutti nello stesso file** si può omettere `permits`: il compilatore lo deduce

---

## Una classe `sealed`: `Payment`

{{% smaller %}}

<div class="container">
<div class="col">

```java
sealed abstract class Payment permits Cash, Card {
    private final double amount;

    protected Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }
}
```

</div>
<div class="col">

```java
final class Cash extends Payment {
    Cash(double amount) {
        super(amount);
    }
}

final class Card extends Payment {
    private final boolean foreign; // carta estera?

    Card(double amount, boolean foreign) {
        super(amount);
        this.foreign = foreign;
    }

    public boolean isForeign() {
        return this.foreign;
    }
}
```

</div>
</div>

{{% /smaller %}}

* Anche una classe, eventualmente astratta, può essere `sealed`

---

## Lo `switch` sui tipi

Le commissioni sono una scelta del negozio: le calcoliamo **fuori** dalla gerarchia, senza modificare `Payment`

```java
static final double CARD_FEE = 0.015;        // 1,5% dell'importo
static final double FOREIGN_CARD_FEE = 0.03; // 3% dell'importo

static double fee(Payment p) {
    return switch (p) {
        case Cash c -> 0;
        case Card c when c.isForeign() -> c.getAmount() * FOREIGN_CARD_FEE;
        case Card c -> c.getAmount() * CARD_FEE;
    };
}
```

* `case Card c` funziona come `p instanceof Card c`: verifica il tipo e introduce `c`
* `when` aggiunge una condizione (**guardia**); va **prima** di `case Card c`, altrimenti non compila (caso "dominato")
* Niente `default`: `Payment` è `sealed`, quindi il compilatore sa che `Cash` e `Card` sono **tutti** i casi
* Pattern nello `switch`: da **Java 21**

---

## E se usassimo `default`?

```java
static double fee(Payment p) {
    return switch (p) {
        case Card c -> c.getAmount() * CARD_FEE;
        default -> 0; // Cash... e qualunque variante futura!
    };
}
```

Compila ed è più corto. Ma un giorno arrivano i buoni pasto: `permits Cash, Card, Voucher`

* **Senza** `default`: errore di compilazione in ogni switch che non considera `Voucher`
    * *"the switch expression does not cover all possible input values"*
    * è il compilatore a indicarci tutti i punti da aggiornare
* **Con** `default`: compila senza avvisi, e i buoni pasto ottengono in silenzio commissione 0
* ⇒ Con una gerarchia `sealed` conviene **elencare tutti i casi**: il `default` spegne il controllo di esaustività
* `default` resta utile se il tipo non è `sealed`, o se "tutto il resto" ha davvero sempre lo stesso significato (es. `SARDEGNA, SICILIA` contro tutte le altre regioni)

---

## Rami aperti: `non-sealed`

I pagamenti online cambiano spesso, e nuovi provider arrivano di continuo: chiudiamo `Payment`, ma lasciamo **aperto** un ramo

{{% smaller %}}

```java
public sealed abstract class Payment permits Cash, Card, OnlinePayment {
    ...
}
```

<div class="container">
<div class="col">

```java
public non-sealed abstract class OnlinePayment
        extends Payment {

    protected OnlinePayment(double amount) {
        super(amount);
    }

    public abstract String getProvider();
}
```

</div>
<div class="col">

```java
package ext; // anche in un altro package!

public final class PayPal extends OnlinePayment {
    public PayPal(double amount) {
        super(amount);
    }

    public String getProvider() {
        return "PayPal";
    }
}
```

</div>
</div>

{{% /smaller %}}

* I sottotipi **diretti** di `Payment` restano tre: `Cash`, `Card`, `OnlinePayment`
* Sotto `OnlinePayment` chiunque può aggiungere sottoclassi, ovunque, senza modificare `Payment`

---

## `non-sealed` e lo `switch`

```java
static final double ONLINE_FEE = 0.35; // costo fisso per transazione

static double fee(Payment p) {
    return switch (p) {
        case Cash c -> 0;
        case Card c -> c.getAmount() * CARD_FEE;
        case OnlinePayment o -> ONLINE_FEE; // PayPal e qualunque provider futuro
    };
}
```

* Ancora **nessun `default`**: `case OnlinePayment o` copre tutte le sue sottoclassi, anche quelle che non esistono ancora
* Uno switch sui *singoli provider* (`case PayPal pp -> ...`) richiede invece `default`
    * quel ramo è aperto: il compilatore non può conoscere tutti i provider
* ⇒ `non-sealed` stabilisce **dove** la gerarchia può crescere, senza perdere i controlli sul resto

---

## `enum`, gerarchie `sealed` e gerarchie aperte

| Meccanismo | Cosa viene fissato | Esempio |
| --- | --- | --- |
| `enum` | Le istanze dichiarate come costanti | Giorni della settimana |
| `sealed` con rami chiusi | Le varianti, ciascuna con più istanze | Figure con dimensioni diverse |
| Interfaccia ordinaria | Il contratto, con implementazioni estendibili liberamente | Nuove strategie di ordinamento |

* `sealed` esprime un vincolo sul modello del dominio
* Le operazioni si scrivono con il consueto polimorfismo, oppure **fuori** dalla gerarchia con uno `switch` esaustivo
* Una nuova variante richiede di rivedere il codice che considera tutti i casi: senza `default`, è il compilatore a indicarlo

<!-- Fonti: https://openjdk.org/jeps/409, https://openjdk.org/jeps/361, https://openjdk.org/jeps/441 e https://docs.oracle.com/en/java/javase/17/language/sealed-classes-and-interfaces.html -->

---

# Enumerazioni e gerarchie sealed

{{% import path="front-page.md" %}}
