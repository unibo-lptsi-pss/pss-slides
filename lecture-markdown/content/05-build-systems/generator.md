 
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/build-systems/"]

+++

## Riconoscimenti

* Questo materiale è ampiamente basato su quello realizzato dal Prof.
Danilo Pianini, che ringrazio.

* Ogni errore riscontratovi è esclusiva responsabilità degli autori di questo documento.

---

# Build system (Gradle), costruzione del software, e librerie

{{% import path="front-page.md" %}}

# Build systems

---

<!-- write-here "shared-slides/build-systems/it-gradle-basics.md" -->

<!-- end-write -->

---

<!-- write-here "shared-slides/build-systems/it-gradle-dependencies.md" -->

<!-- end-write -->


---

Ora sappiamo compilare sorgenti che usano qualunque libreria
* ma se ci sono *dipendenze transitive* (e ci sono quasi sempre) dobbiamo cercare dove Gradle ha scaricato le librerie che ci servono per poter lanciare il programma

{{% fragment %}}
![bello](https://i.imgflip.com/6ux8rp.jpg)
{{% /fragment %}}

{{% fragment %}}
* vorremmo usare Gradle anche per *lanciare* l'applicazione...
{{% /fragment %}}

---

# Lancio di applicazioni Java tramite Gradle

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
repositories { mavenCentral() } // Configura Gradle per cercare e scaricare da Maven Central
dependencies { // Elenco di librerie che ci servono
  implementation("com.omertron:API-OMDB:1.5")
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
