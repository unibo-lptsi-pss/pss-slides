
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/compilers/"]

+++

# Esecuzione di applicazioni Java tramite Gradle

---

## Lanciare applicazioni Java da Gradle

Gradle offre supporto all'esecuzione dell'applicazione,
oltre che alla sua compilazione,
utilizzando il task `run` che viene aggiunto dal plugin `application`.

Per eseguire ci servono due cose:
1. {{% fragment %}} il *nome qualificato* della classe da eseguire {{% /fragment %}}
2. {{% fragment %}} il *classpath* da cui caricare tutte le classi {{% /fragment %}}

{{% fragment %}}
Il classpath è noto, perché lo specifichiamo nelle dipendenze

Il nome della classe, invece, va specificato manualmente

```kotlin
plugins {
  java // Carica il necessario per la compilazione di Java
  application // Carica il necessario per l'esecuzione di classi con la JVM
}
application { // Configurazione dell'esecuzione, la main class è sufficiente
    mainClass.set("it.unibo.sampleapp.SimplerRateAMovie")
}
```

Possiamo ora lanciare la nostra applicazione tramite:
* `gradle run`

{{% /fragment %}}

---

<!-- write-here "shared-slides/build-systems/it-gradle-wrapper.md" -->

<!-- end-write -->

---

# Esecuzioni di programmi java con argomenti

---

## Passaggio di argomenti ad un programma Java
La maggior parte dei comandi supporta degli argomenti

Ad esempio, quando eseguite `javac -d bin MyClass.java` gli argomenti sono:

1. `-d`
2. `bin`
3. `MyClass.java`


In C, questi vengono passati al metodo `main()` come coppia di `char **` e `int`, rappresentanti rispettivamente un riferimento all'area di memoria dove sono salvati i parametri ed il numero dei suddetti.

Anche in Java ovviamente è possibile passare degli argomenti ad un programma!

* La gestione in Java è un po' più semplice che in C:
    * gli array hanno l'informazione circa la loro dimensione
    * la signature del metodo `main()` è una sola:
        * `public static void main(String [])` è l'unica signature valida
        * In C sia `int main(void)` che `int main(char **, int)` sono ugualmente accettabili
* Gli argomenti con cui un programma Java viene invocato vengono passati come parametri attraverso l'array (`String[] args`) che il metodo `main()` prende in ingresso
* Nonostante sia un parametro del *metodo principale* di qualunque programma Java, si tratta di un comune array senza alcuna particolarità.
