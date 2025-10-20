
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/codestyle/"]

+++

# Checkstyle

{{% import path="front-page.md" %}}

---

### Cos'è Checkstyle

Checkstyle si occupa di trovare errori di stile:
		
* Mancanza di commento Javadoc, Spaziature non corrette, Parentesi assenti, Magic numbers...
* Altri check: [http://checkstyle.sourceforge.net/checks.html](http://checkstyle.sourceforge.net/checks.html)

### Come funziona

- Si dichiara lo stile desiderato in un file `checkstyle.xml` (un [esempio](https://github.com/DanySK/gradle-java-qa/blob/master/src/main/resources/org/danilopianini/javaqa/checkstyle.xml))
```xml
<?xml version="1.0"?>
<!DOCTYPE module PUBLIC
        "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN"
        "https://checkstyle.org/dtds/configuration_1_3.dtd">
<module name="Checker">
    <property name="charset" value="UTF-8"/>
    <module name="NewlineAtEndOfFile">
        <property name="lineSeparator" value="lf"/>
    </module>
    <module name="LineLength">
      <property name="max" value="85"/>
    </module>
    <!-- ... -->
</module>

```
- Si utilizza il tool `checkstyle` per analizzare codice rispetto allo stile configurato

---

### Integrazione con Gradle

- Plugin [`checkstyle`](https://docs.gradle.org/current/userguide/checkstyle_plugin.html), da dichiarare in `build.gradle.kts`:
```kotlin
plugins {
  java
  checkstyle
}

repositories {
  mavenCentral()
}
```
- Di default, il plugin si aspetta i seguenti file
```txt
<root>
└── config
    └── checkstyle           
        └── checkstyle.xml   
        └── suppressions.xml
```
- Il plugin fornisce il task `check` (che include `checkstyleMain` e `checkstyleTest`)
- L'output dell'analisi viene riportato sotto `build/reports/checkstyle`

---

- Di default, *fallisce la build* se le regole di stile non sono rispettate
```txt
$ ./gradlew check

> Task :checkstyleMain
[ant:checkstyle] [ERROR] /<PATH-TO-PROJ>/src/main/java/.../File.java:4: 
                         Line is longer than 85 characters (found 102). [LineLength]

> Task :checkstyleMain FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':checkstyleMain'.
> A failure occurred while executing org.gradle.api.plugins.quality.internal.CheckstyleAction
   > Checkstyle rule violations were found. See the report at: file:///<PATH-TO-PROJ>/build/reports/checkstyle/main.html
     Checkstyle files with violations: 1
     Checkstyle violations by severity: [error:1]
```
---

# Stile e formattazione del codice

{{% import path="front-page.md" %}}