
<!--

## Singleton: creazionale, su oggetti


    
### Intento/motivazione


	Garantire che una classe abbia una unica istanza, accessibile globalmente e facilmente a molteplici classi, senza doversi preoccupare di fornirne il riferimento a chi lo richiede (ad esempio passandolo al costruttore)
    

    
### Esempi



*  Un unico gestore di stampanti in un sistema
*  Un unico gestore del "log"
*  `java.lang.Runtime`
    


    
### Soluzione



*  La classe sia responsabile di tenere traccia di tale unica istanza
*  La classe impedisca la creazione di altri oggetti
*  La classe fornisca l'accesso a tale oggetto staticamente
*  Attenzione: singleton accoppia clienti e implementazione
    




---


## Singleton: UML


![](img/singleton.jpg)


---


## Singleton: Il caso di `java.lang.Runtime`


    \sizedrangedcode{\scriptsize}{3}{100}{\ecl/singleton/UseRuntime.java}


---


## Singleton: Il caso di una classe `Log`


    \sizedrangedcode{\scriptsize}{3}{100}{\ecl/singleton/Log.java}
    \sizedrangedcode{\scriptsize}{3}{100}{\ecl/singleton/UseLog.java}


---


## Singleton: conseguenze


    
### Effetti benefici



*  C'è un controllo "incapsulato" di chi vi accede
*  Evita di dover portare i riferimenti all'oggetto nei campi di tutti le classi che lo usano
*  È facile raffinare l'implementazione del singleton (via subclassing)
*  Può gestire la creazione by-need (detta anche *lazy*) dell'oggetto
*  Più flessibile dei metodi statici (che non hanno overriding)
    


    
### Critiche



*  Il Singleton può essere problematico col multi-threading
*  Crea dipendenze nascoste, gli user dipendono dal nome della classe
*  Difficile tornare indietro dalla scelta di usare il singleton
*  Incapsula due responsabilità distinte (creazione + aspetti interni)
*  Rende meno estendibile il codice della classe (è meno "OOP")
* $\Rightarrow$ *__Da usare quando portare "in giro" il riferimento all'oggetto sarebbe complesso__*
    




---


## Singleton con "lazy initialization" (non thread-safe)


    \sizedrangedcode{\scriptsize}{3}{100}{\ecl/singleton/LogLazy.java}


---


## Singleton con "lazy initialization" e "thread-safe"


    \sizedrangedcode{\ssmall}{3}{100}{\ecl/singleton/LogLazyTS.java}


---



## Template Method: comportamentale, su classi


    
### Intento/motivazione


	Definisce lo scheletro (template) di un algoritmo (o comportamento), lasciando l'indicazione di alcuni suoi aspetti alle sottoclassi.
    

    
### Esempi



*  In un input stream (`InputStream`), i vari metodi di lettura sono dei Template Method: dipendono dall'implementazione del solo concetto di lettura di un `int`
	%*  Similmente, i metodi di `AbstractSet` tranne `size()` e `iterator()`
*  Le interfacce funzionali con metodi di default che chiamano l'astratto
    


    
### Soluzione



*  L'algoritmo è realizzato attraverso un metodo non astratto (il template method) di una classe astratta
*  Questo realizza l'algoritmo, chiamando metodi astratti quando servono gli aspetti non noti a priori
*  Una sottoclasse fornisce l'implementazione dei metodi astratti
    




---


## Template Method: UML


    ![](img/template_method.jpg)


---


## Template Method: Una estensione di `InputStream`


    \sizedrangedcode{\ssmall}{3}{100}{\ecl/tmethod/UseRandomInputStream.java}


---


## Template Method: esempio `BankAccount`


    \sizedrangedcode{\ssmall}{3}{100}{\ecl/tmethod/BankAccount.java}


---


## Template Method: esempio con i metodi `default`


    \sizedrangedcode{\ssmall}{5}{100}{\ecllambda/interfaces/SimpleIterator.java}
    \sizedrangedcode{\ssmall}{3}{100}{\ecllambda/interfaces/UseSimpleIterator.java}


---



# Factory Method

## Factory Method: creazionale, su oggetti


    
### Intento/motivazione


Definisce una interfaccia per creare oggetti, lasciando alle implementazioni il compito di decidere quale classe istanziare e come
    

    
### Esempi


* Un framework deve creare oggetti, ma sue specializzazioni devono crearne versioni specializzate
    
### Soluzione

*  Una interfaccia creatrice fornisce il metodo factory col compito di creare e ritornare l'oggetto
*  Tale interfaccia viene poi specializzata, e incapsula la logica di creazione dell'oggetto
* ..spesso frainteso con static o simple factory
    




---


## Factory Method: UML

![](imgs/factorymethod.png)



---


## Factory Method: Esempio `Person` e `PersonFactory`


```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/factorymethod/persona/Person.java" %}}
```

{{% smaller %}}

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/factorymethod/persona/PersonImpl.java" %}}
```

{{% /smaller %}}

---

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/factorymethod/persona/PersonFactory.java" %}}
```

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/factorymethod/persona/PersonFactoryImpl.java" %}}
```

---

```java
{{% import-raw from=3 path="pss-code/src/main/java/it/unibo/patterns/factorymethod/persona/UsePerson.java" %}}
```

---

## Abstract Factory

### Abstract Factory: UML


```mermaid
classDiagram

class Product {
    <<interface>>
}

class ConcreteProduct1 { }

class ConcreteProduct2 { }

Product <|-- ConcreteProduct1
Product <|-- ConcreteProduct2

class Factory {
    <<interface>>
    factoryMethod() Product
}

class Context { }

Context *-- Factory
Product <-- Context


class FactoryImpl1 { }

class FactoryImpl2 { }

ConcreteProduct1 <-- FactoryImpl1 
ConcreteProduct2 <-- FactoryImpl2 

Factory <|-- FactoryImpl1
Factory <|-- FactoryImpl2
```

-->


