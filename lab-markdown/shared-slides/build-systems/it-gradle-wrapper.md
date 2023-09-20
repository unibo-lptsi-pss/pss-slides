
## Il build system come dipendenza

**Problema**: come tutti i software _anche il build system **cambia**_

Se da una versione all'altra di Gradle dovesse cambiare la convenzione,
cosa succederebbe?
* Il nostro software smette di funzionare se aggiorniamo il build system!

E se avessimo *progetti diversi* che richiedono *versioni diverse* di Gradle?

#### Ci serve un modo per:

1. avere sempre *la giusta versione* di Gradle
    * Potenzialmente ogni progetto ha la sua
2. fare in modo che più versioni di Gradle coesistano senza "darsi fastidio"
    * Non vogliamo certo scaricare e installare versioni diverse a seconda del progetto su cui stiamo lavorando
3. già che ci siamo, sarebbe carino se questo sistema sapesse scaricare e installare Gradle, senza richiedere multiple installazioni manuali all'utente

---

## Gradle wrapper

Un insieme di script con un software minimale che:
1. Scarica la versione di Gradle indicata in un file di configurazione
    * se non già disponibile nel sistema
2. Usa quella versione per costruire il nostro sistema software!

Il wrapper può (deve) esser copiato in ogni progetto che gestiamo con Gradle

Dato che il wrapper sa come scaricare ed installare Gradle, non occorre scaricare ed installare gradle manualmente
* Anche se è comodo, la versione di Gradle installata può generare le versioni wrapper

---

## Progetti Gradle con wrapper

1. Script bash eseguibile (<i class="fab fa-linux"></i>/<i class="fab fa-apple"></i>): `gradlew`
2. Script batch eseguibile (<i class="fab fa-windows"></i>): `gradlew.bat`
3. File di configurazione con indicata la versione di Gradle:<br>
`gradle/wrapper/gradle-wrapper.properties`
4. Software Java che scarica la versione di Gradle descritta nel file di configurazione: <br>
`gradle/wrapper/gradle-wrapper.jar`

Wrapper pronto per esser scaricato:
* https://github.com/DanySK/Gradle-Wrapper/archive/refs/heads/master.zip
* **Attenzione**: su <i class="fab fa-linux"></i> e <i class="fab fa-apple"></i>,
eseguire anche il comando `chmod +x gradlew` per rendere eseguibile lo script
 * setta i permessi Unix per eseguire, il cui valore viene resettato dalla compressione in formato zip
 * alternativamente, lo script va eseguito chiedendo all'interprete della linea di comando di interpretarlo
  * `sh gradlew`

---

## Utilizzo di Gradle con wrapper

Se abbiamo il Gradle wrapper configurato in un progetto,
possiamo usarlo attraverso uno dei due script:
* `gradlew` (<i class="fab fa-linux"></i>/<i class="fab fa-apple"></i>)
  o `gradlew.bat` (<i class="fab fa-windows"></i>),
  a seconda della nostra piattaforma 
* seguito dall'elenco dei **task**

#### **Nota**

Su sistemi <i class="fab fa-linux"></i> e <i class="fab fa-apple"></i>
per eseguire lo script occorre anche includere il percorso corrente:
* `./gradlew`

o, in alternativa, chiedere all'interprete dei comandi di eseguire
  * `sh gradlew`
  * `bash gradlew`
