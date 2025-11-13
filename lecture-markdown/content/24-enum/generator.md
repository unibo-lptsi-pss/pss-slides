
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/advanced-mechanisms-enums/", "enum", "enums"]

+++

# Enumerazioni

{{% import path="front-page.md" %}}

---


## Outline


  
### Goal della lezione



*  Illustrare il concetto di enumerazione e le sue implementazioni in Java

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


# Enumerazioni

{{% import path="front-page.md" %}}
