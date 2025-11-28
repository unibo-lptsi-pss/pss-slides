
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/build-systems/"]

+++

# Dipendenze e Librerie in Gradle
{{% import path="cover.md" %}}

---

<!-- write-here "shared-slides/build-systems/it-gradle-dependencies.md" -->

<!-- end-write -->

---

## JUnit 5 e Gradle

- `build.gradle.kts`: supporto per i test
  [<i class="fa-solid fa-link"></i>](https://github.com/junit-team/junit5-samples/junit5-jupiter-starter-gradle)
  [<i class="fa-solid fa-link"></i>](https://docs.gradle.org/current/userguide/java_testing.html#java_testing)


```kotlin
plugins {
    java // JavaPlugin aggiunge un source set "test" e un task "test"
}

repositories {
    mavenCentral() // occorre per risolvere le dipendenze di JUnit
}

dependencies {
    // Dipendenza per scrivere i test
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    // Dipendenza per eseguire i test
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.1")
}

tasks.test {
    useJUnitPlatform() // configura il task "test" per usare la JUnit Platform
    testLogging { events("passed", "skipped", "failed") } // per stampare l'esito di ogni test
}
```

```bash
$ ./gradlew test 
$ ./gradlew test --tests it.unibo.*.Buggy*Test # filtra i test da eseguire
```

---

# Dipendenze e Librerie in Gradle
{{% import path="cover.md" %}}

