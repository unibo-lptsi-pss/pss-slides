
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = [  ]

+++

{{< slide class="deck-index" >}}

## Progettazione e Sviluppo del Software

<div class="deck-index-subtitle">

C.d.L. in Tecnologie dei Sistemi Informatici &nbsp;&middot;&nbsp; Indice dei contenuti

</div>

{{% menu %}}

{{% menu-group title="Fondamenti" icon="fa-solid fa-graduation-cap" %}}

* [<i class="fa-solid fa-flag-checkered"></i> 1. Introduzione al corso](intro/)
* [<i class="fa-solid fa-shapes"></i> 2. Astrazione orientata agli oggetti](oo-abstraction/)
* [<i class="fa-brands fa-java"></i> 3. Introduzione al linguaggio Java](basics/)
* [<i class="fa-solid fa-cube"></i> 4. Oggetti e classi (parte 1/2)](objects/)
* [<i class="fa-solid fa-cubes"></i> 5. Oggetti e classi (parte 2/2)](objects-2/)
* [<i class="fa-solid fa-lock"></i> 6. Incapsulamento](encapsulation/)

{{% /menu-group %}}

{{% menu-group title="Progettazione OO" icon="fa-solid fa-diagram-project" %}}

* [<i class="fa-solid fa-plug"></i> 7. Interfacce e composizione](interfaces/)
* [<i class="fa-solid fa-sitemap"></i> 8. Ereditarietà](inheritance/)
* [<i class="fa-solid fa-masks-theater"></i> 10. Polimorfismo e tipi a runtime](polymorphism/)
* [<i class="fa-solid fa-puzzle-piece"></i> 15. Classi astratte e template method](abstract-classes/)
* [<i class="fa-solid fa-list-ol"></i> 16. Enumerazioni](enums/)
* [<i class="fa-solid fa-box-open"></i> 17. Classi innestate e anonime](nesting/)
<!--
* [<i class="fa-solid fa-compass-drafting"></i> Progettazione efficace ed agile del software](intro-agile-sw-design-patterns/)
-->

{{% /menu-group %}}

{{% menu-group title="Librerie e linguaggio" icon="fa-solid fa-book-open" %}}

* [<i class="fa-solid fa-diamond"></i> 11. Generici](generics/)
* [<i class="fa-solid fa-layer-group"></i> 12. Collezioni](collections/)
* [<i class="fa-solid fa-triangle-exclamation"></i> 14. Eccezioni](exceptions/)
* [<i class="fa-solid fa-arrow-right-long"></i> 18. Functional Java con Lambda e Stream](lambdas/)
* [<i class="fa-solid fa-file-arrow-down"></i> 21. Input/Output](io/)
* [<i class="fa-solid fa-shuffle"></i> 22. Introduzione al multi-threading](multithread/)
<!--
* [<i class="fa-solid fa-water"></i> Stream e manipolazione di flussi di dati](stream/)
* [<i class="fa-solid fa-shapes"></i> Collezioni generiche, erasure, e wildcard](generic-collections-advanced/)
-->

{{% /menu-group %}}

<!-- {{% menu-group title="Strumenti e pratiche" icon="fa-solid fa-screwdriver-wrench" %}} -->

<!-- * <span class="deck-menu-label"><i class="fa-brands fa-git-alt"></i> 9. Controllo di versione (DVCS) con Git</span>
    * [<i class="fa-solid fa-code-commit"></i> Introduzione](https://unibo-oop.github.io/lab-slides/dvcs-basics/#/)
    * [<i class="fa-solid fa-code-merge"></i> Merging e branching](https://unibo-oop.github.io/lab-slides/dvcs-branching/#/)
    * [<i class="fa-solid fa-cloud-arrow-up"></i> Collaborazione remota](https://unibo-oop.github.io/lab-slides/dvcs-remote/#/)
* [<i class="fa-solid fa-camera-retro"></i> 13. Interfacce grafiche (GUI) con JavaFX](guis-javafx/)
* [<i class="fa-solid fa-cubes-stacked"></i> 19. Dipendenze e librerie](dependencies/)
* [<i class="fa-solid fa-vial-circle-check"></i> 20. Unit Testing e TDD con JUnit 5](junit-tdd/)
* [<i class="fa-solid fa-flask"></i> Slide di laboratorio](#/lab) -->

<!-- * [<i class="fa-solid fa-flask"></i> 1. Strumenti di base](lab) -->
<!--
* [<i class="fa-solid fa-gears"></i> Build system (Gradle), costruzione del software, e librerie](build-systems/)
* [<i class="fa-solid fa-window-maximize"></i> Sviluppo di interfacce grafiche (GUI) con Swing](guis-swing/)
-->

<!-- {{% /menu-group %}} -->

{{% /menu %}}

<div class="deck-index-note">

⚠️ Le slide con il simbolo 🚧 sono da considerarsi in costruzione, potrebbero essere incomplete, e saranno soggette a modifiche

</div>

<div class="deck-cover-actions">

[<i class="fa-solid fa-arrow-right"></i> slides di laboratorio](#/lab)

</div>


---

{{< slide id="lab" class="deck-index" >}}

## Laboratorio di Progettazione e Sviluppo del Software

<div class="deck-index-subtitle">

C.d.L. in Tecnologie dei Sistemi Informatici &nbsp;&middot;&nbsp; Indice dei contenuti

</div>

{{% menu %}}

{{% menu-group title="Strumenti di base" icon="fa-solid fa-toolbox" %}}

* [<i class="fa-solid fa-download"></i> 1. Installazione di IntelliJ Idea](lab/00-install-intellij/)
* [<i class="fa-brands fa-java"></i> 2. Strumenti del JDK](lab/01-basic-tools/)
* [<i class="fa-solid fa-terminal"></i> 3. Compilazione avanzata](lab/02-advanced-tooling-gradle/)

{{% /menu-group %}}

{{% menu-group title="Build automation" icon="fa-solid fa-gear" %}}

* [<i class="fa-solid fa-gears"></i> 4. Build Systems](lab/03-build-systems/)
* [<i class="fa-solid fa-play"></i> 5. Esecuzione di applicazioni Java tramite Gradle](lab/04-execution/)
* [<i class="fa-solid fa-magnifying-glass-chart"></i> 6. Analisi statica e checkstyle](lab/05-checkstyle/)
* [<i class="fa-solid fa-cubes"></i> 7. Dipendenze e Librerie in Gradle](lab/06-dependencies/)
* [<i class="fa-solid fa-box"></i> 8. Costruzione degli artefatti](lab/08-jar/)

{{% /menu-group %}}

{{% /menu %}}

<div class="deck-index-note">

⚠️ Le slide con il simbolo 🚧 sono da considerarsi in costruzione, potrebbero essere incomplete, e saranno soggette a modifiche

</div>

<div class="deck-cover-actions">

[<i class="fa-solid fa-arrow-left"></i> slides di teoria](#/)

</div>
