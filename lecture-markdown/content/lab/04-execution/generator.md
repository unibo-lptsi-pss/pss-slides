
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/compilers/"]

+++

# Esecuzione di applicazioni Java tramite Gradle
{{% import path="cover.md" %}}
---

## Lanciare applicazioni Java da Gradle
Gradle offre supporto all'esecuzione dell'applicazione,
oltre che alla sua compilazione,
utilizzando il task `run` che viene aggiunto dal plugin `application`.

Per eseguire ci servono due cose:

{{% fragment %}}
1. il *nome qualificato* della classe da eseguire <br>
   {{% /fragment %}}

{{% fragment %}}
2. il *classpath* da cui caricare tutte le classi
   {{% /fragment %}}

{{% fragment %}}
Il classpath è noto perché specificato (in questo caso grazie a **Convention over Configuration**);

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

## Verso una gestione NEXT LEVEL del software

![Meme del tizio che dice stonks ma invece dice tech](tech.jpg)

Abbiamo sempre più elementi che ci permettono di creare software di qualità:

- Grazie a **git** possiamo tenere traccia delle modifiche che apportiamo al software;
- Grazie a **Gradle** possiamo automatizzare la compilazione e l'esecuzione del software;
    - Inoltre esistono numerosi plugin che ci aiutano ad automatizzare altri aspetti come la qualità del codice (vedi **Checkstyle**);
