 
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/intro/"]

+++

# Strumenti di compilazione avanzati

{{% import path="cover.md" %}}

## Pre-requisiti

* Rudimenti di programmazione e codifica
* Nozioni di base dei filesystem
  * percorsi assoluti e relativi
* Utilizzo del terminale
  * interazione con il file system attraverso terminale (navigazione; concetto di working directory; etc.)
* Compilazione ed esecuzione di base di programmi Java
  * uso basilare dei comandi `javac` e `java`
  * distinzione tra file sorgenti (`.java`) e file di classi compilate (`.class`)
  * concetto di **programma/applicazione** in Java
* Il concetto di **package** in Java
  * contenitore (organizzato gerarchicamente) di tipi (ad es. classi) che funge da namespace e permette controllo degli accessi ai tipi contenuti

---

# Stili e Convenzioni per il codice sorgente

---

## Stili e Convenzioni
* Il codice sorgente che un programmatore scrive, generalmente è condiviso con altre persone (del proprio team, ma anche persone esterne al team o la community)
  * è importante scrivere software immediatamente comprensibile
  * il fatto che un software "giri" (rispetti i requisiti e/o produca i risultati attesi) non è una sufficente metrica di qualità
* è importante, fondamentale, adottare uno stile e seguirlo
  * chiaro
  * condiviso
  * consistente

> Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live. Code for readability.
<cite>John Woods [disputed]}</cite>

---

## Ogni linguaggio ha le sue prassi...

* Quelle Java di riferimento sono disponibili qui:
  * http://bit.ly/java-style-guide
  * http://bit.ly/java-code-conventions
  * http://bit.ly/oracle-java-code-conventions

## Ogni azienda poi è libera di darsi altre regole interne

* Ad esempio:
  * Google: http://archive.is/a0Jhz
  * Twitter: http://archive.is/aa1tE
  * Mozilla: http://archive.is/rs3Ns
* Notare che sono sempre **consistenti**!

* E che sono tipicamente restrizioni delle convenzioni, non modifiche!
**Nel corso faremo riferimento alle Java Code Conventions (con qualche vincolo in più)**

---

## Java Code Conventions (un estratto)
    
### Usare sempre le parentesi per if, else, for, while, anche se segue una sola istruzione
* Aumentano la manutenibilità del codice
* È facile che nella fretta si modifichi il codice in modo sbagliato
* È facile che alcuni tool automatici sbaglino quando "uniscono" pezzi di codice scritti da diverse persone
* Apple iOS soffrì di un grave bug a SSL/TLS causato da questa cattiva pratica http://archive.is/KQp8E

### Le parentesi graffe vanno sempre "all'egiziana" (Egyptian brackets)
* La graffa che apre va in linea con lo statement di apertura
* La graffa che chiude va in a capo, nella stessa colonna dello statement di apertura
    
### Naming conventions - **molto importanti!**
* I nomi di `package` usano sempre e solo lettere minuscole
* Usare sempre `camelCase`, evitare gli underscore (_)
* I nomi di classe cominciano sempre per maiuscola ed usano `PascalCase`
* I nomi di campi, metodi e variabili locali iniziano sempre per minuscola
* I campi `static final` (costanti di classe) sono interamente maiuscoli e possono usare underscore

---

# Compilazione ed esecuzione avanzata in Java

---

## Nuova opzione per `javac`
* Abbiamo già visto come compilare file sorgenti Java (file `.java`), generando classi in bytecode, che prendono la forma di file `.class` nella medesima directory
* Tuttavia è uso comune e **buona pratica** nella gestione di progetti articolati, **separare le classi sorgenti dal bytecode**, ad esempio:
  * cartella `src`, per i file sorgenti (`.java`)
  * cartella `bin`, contenente le classi compilate (`.class`)
    * Come si fa?
    
### Nuova opzione del comando `javac`
* `-d`: consente di specificare la cartella destinazione in cui compilare i file `.java`
* Si tratta di un'opzione che dovete obbligatoriamente saper usare

---

## Compilazione di più file da qualunque directory verso una qualunque directory

### Compilazione in directory arbitrarie
* `javac -d <CARTELLA DESTINAZIONE> <FILE JAVA>`
* **OVVIAMENTE** vanno sostituite le variabili fra parentesi angolari con le
directory che andranno usate.
  
### Compilazione di più file in una singola passata
* `javac -d <CARTELLA DESTINAZIONE> <ELENCO DI FILE JAVA>`
* **OVVIAMENTE** vanno sostituite le variabili fra parentesi angolari con le
directory che andranno usate.

È possibile anche utilizzare la wildcard (`*`) invece di elencare tutti i file!
* Su Unix si possono usare wildcard in più punti del path, ad esempio
`progetti/*/src/*.java` elenca tutti i file con estensione java dentro ciascuna cartella
`src` di ciascuna cartella dentro `progetti`
 
---

## Il classpath in Java
* Il risultato della compilazione di sorgenti Java sono una o più **classi**
* Quando si va ad eseguire (comando `java`), si eseguono **classi**, non files
  * Infatti la virtual machine si aspetta il nome completo di una classe, il **Fully-Qualified Class Name (FQCN)**, in input
    * Non il file dov'è scritta
    * Né il file dov'è compilata
    
### Come fa la JVM a risolvere le classi?
* Possiede un elenco di percorsi che contengono i file compilati
  * All'interno di questi percorsi, i file devono essere opportunamente organizzati
  * Ad esempio, la struttura delle cartelle deve replicare quella dei package
* Cerca (in ordine) nei suddetti percorsi la classe che gli serve
* I percorsi possono essere directory, file compressi, o indirizzi di rete
* Per approfondire: http://archive.is/0ziau
       
L'insieme *ordinato* dei percorsi prende il nome di **classpath**

---

## Default classpath
Se non specificato, il classpath di Java include automaticamente:
* I file jar del Java Runtime Environment
  * `rt.jar` ed altri file importanti
  * Contengono ad esempio `java.lang.Math`
* La directory corrente

---
    
## Aggiungere directory al classpath
Possono essere aggiunte directory al classpath
* Si usa l'opzione `-cp` (o, equivalentemente, `-classpath`), seguita da un elenco di percorsi
  * separati dal simbolo `:` (Unix)
  * o dal simbolo `;` (Windows)
  * Per evitare problemi con simboli e percorsi, conviene circondare l'intero classpath con doppi apici (simbolo `"`)

---

## Più cartelle nel classpath
Il classpath non è composto da una sola cartella, ma può contenere più cartelle, oltre a file compressi contenenti bytecode e risorse, come zip o jar (li vedremo in futuro).

Si possono specificare più cartelle utilizzando come separatore il simbolo "`:`" (per sistemi Unix) oppure "`;`" (per sistemi Windows)
* `javac -d bin -cp "lib1:lib2:lib3" src/*.java`
  * Compila tutti i file con estensione java che si trovano nella cartella `src`, mettendo i compilati dentro `bin`. In compilazione, potrà linkare tutte le classi che si trovano nelle cartelle `lib1`, `lib2` e `lib3`: nel caso in cui alcuni sorgenti in src stiano usando delle classi definite dentro queste cartelle, la compilazione avrà successo.
    * Equivalente Windows: `javac -d bin -cp "lib1;lib2;lib3" src/*.java`
* `java -cp "bin:lib1:lib2:lib3" MyClass`
  * Esegue il main della classe `MyClass`. Cercherà questa classe e tutte quelle collegate all'interno delle cartelle `bin`, `lib1`, `lib2` e `lib3`.
  * Equivalente Windows: `java -cp "bin;lib1;lib2;lib3" MyClass`

---

## Organizzazione dei sorgenti in presenza di package

È buona norma organizzare i sorgenti in modo da rappresentare su filesystem la struttura
dei package. Si noti però che (dato che il compilatore lavora su *__file__*) questa scelta
**non è \underline{teoricamente} obbligatoria**!
* Lo è di fatto in questo corso, perché le cose van fatte bene
* Lo sarà nel mondo del lavoro, perché è prassi assolutamente comune
   
### Risultato della compilazione

Quando ad essere compilata è una classe dichiarata in un package, il compilatore
**riproduce la struttura dei package usando delle directory**

Dato che l'interprete non lavora con file ma con *__classi__*, il loro layout
sul file system **non può essere modificato!**
    
## Esecuzione


        L'esecuzione è identica al caso precedente, si faccia solo attenzione ad
usare l'intero nome della classe, che in Java include anche il nome del package!
   


---


## Uso del classpath in fase di compilazione

   Supponiamo di avere in mano la seguente classe:
    \sizedcode{\tiny}{../../workspace/lab02/02-classpathcompilation/src/oop/lab02/math/UseComplex.java}
    
## Comprensione degli errori


        Se provassimo a compilarla, otterremmo degli errori
        \sizedcode{\tiny}{code/esempio3/src/oop/lab02/math/error.txt}
        
        * Il compilatore ha bisogno di conoscere la classe `ComplexNum` per poterla
linkare e per poter compilare una classe che la riferisce
        * Il compilatore cerca nel classpath il bytecode della classe `ComplexNum`
        * Come risolviamo?
       

   

    
## Utilizzo di `-cp` in fase di compilazione


        
            * Supponiamo di avere solo la versione compilata di `ComplexNum` (ovvero non il sorgente)
            
                * Notate che questa è la *norma* quando si usano delle librerie: vengono
                fornite già compilate!
           

            * Basterà mettere il percorso in cui `ComplexNum` è stata compilata nel
            classpath di `javac`!
            * Supponiamo di avere `UseComplex.java` nel percorso
            `src/oop/lab02/math/`
            * Supponiamo di aver `ComplexNum` compilato dentro `lib/`
            * Possiamo usare:
       

        *__{javac -d bin -cp lib src/oop/lab02/math/UseComplex.java}__*
   

    
## Spiegazione del comando


        `javac -d bin -cp lib src/oop/lab02/math/UseComplex.java`
        
            * `javac` $\Rightarrow$ Invocazione del compilatore
            * `-d bin` $\Rightarrow$ `-d` determina la **destinazione**.
Vogliamo compilare dentro la cartella `bin`
            * `-cp lib` $\Rightarrow$ `-cp` consente di aggiungere percorsi al
            **classpath**. Noi vogliamo cercare le classi che ci servono, oltre che nella
            posizione corrente e nelle librerie java, anche dentro `lib`
            * `src/oop/lab02/math/UseComplex.java` $\Rightarrow$ Il *file* che
vogliamo compilare
       

   


---


## Passare più percorsi al classpath

    Avendo come riferimento l'esempio precedente, proviamo ad eseguire.
    
    * Per eseguire correttamente `UseComplex` dobbiamo dire alla JVM, tramite
**-cp**, dove trovare:
    
        * `ComplexNum`
        * `UseComplex`
   

        * Si trovano in *due percorsi diversi*!
        * Dobbiamo specificare come argomento di `-cp` due percorsi, usando il
**separatore**:
        
            * **`:`** su sistemi UNIX (Linux, Mac OSX, BSD)
            * **`;`** su sistemi Windows
       

        * Useremo quindi:
        
            * `java -cp bin:lib oop.lab02.math.UseComplex` (Unix)
            * `java -cp bin;lib oop.lab02.math.UseComplex` (Windows)
       

   


---


## Consiglio finale

  Visto che all'esame il loro utilizzo è richiesto, è necessario imparare **a memoria** le opzioni di `java` e `javac`?
  \begin{center}
    **NO**
  \end{center}
  Entrambi i comandi (e praticamente tutti i comandi Unix) hanno con loro un'opzione che consente di stampare a video un help. Provate
  


}
    
      * java -help
      * javac -help
   

 

  \vspace{10pt}

  Gli help stampano abbondante testo con le relative istruzioni e a me serve una riga, davvero devo imparare a leggere e capire un help?
  \begin{center}
    **SÌ**
  \end{center}
  È molto facile dimenticarsi la sintassi delle opzioni di comandi che non si usano spesso. È molto più facile imparare a destreggiarsi in un help che andare a tentativi o ricordare cose a memoria.

---


# Esecuzioni di programmi java con argomenti

---



## Passaggio di argomenti ad un programma Java

    
itemsep10pt
        * La maggior parte dei comandi supporta degli argomenti
        
            * Ad esempio, quando eseguite `javac -d bin MyClass.java` gli argomenti sono:
            \begin{enumerate}
             * `-d`
             * `bin`
             * `MyClass.java`
            \end{enumerate}
       

        * In C, questi vengono passati al metodo `main()` come coppia di `char **` e `int`, rappresentanti rispettivamente un riferimento all'area di memoria dove sono salvati i parametri ed il numero dei suddetti.
        * Anche in Java ovviamente è possibile passare degli argomenti ad un programma
       


\framebreak

    
itemsep10pt
    * La gestione è un po' più semplice che in C, grazie al fatto che gli array si portano dietro l'informazione circa la loro dimensione
        * E grazie al fatto che la signature del metodo `main()` è una sola in Java
        
            * `public static void main(String [])` è l'unica signature valida
            * Mentre in C sia `int main(void)` che `int main(char **, int)` sono ugualmente accettabili
       



        * Gli argomenti con cui un programma Java viene invocato vengono passati come parametri attraverso l'array (`String[] args`) che il metodo `main()` prende in ingresso
        
        * Nonostante sia un parametro del *metodo principale* di qualunque programma Java, si tratta di un comune array senza alcuna particolarità.
       


   


---


# Laboratorio

---




## Preparazione ambiente di lavoro



itemsep10pt
* Accedere al PC di laboratorio con le proprie credenziali istituzionali
        * Accedere al sito del corso



    * Scaricare il materiale dell'esercitazione odierna
    * Spostare il file scaricato sul Desktop
    * Decomprimere il file e aprire con Visual Studio Code la directory ottenuta (File $\to$ Open Folder...)
    * Puntare il terminale alla directory con i sorgenti dell'esercitazione odierna



---


\subsection{Appendice: richiami utili per gli esercizi del {\lab}}


## A1 -- Varianza



## Formula per il calcolo della varianza


Sia $n$ il numero di elementi dell'array ed $x_i$ l'elemento all'indice $i$ dell'array, e $\mu$ la media dei valori del suddetto array. La varianza $\sigma^2$ può essere calcolata come:

\centering
\huge
$\sigma^2 = \frac{\displaystyle\sum_{i=0}^{n-1}(x_i - \mu)^2} {n}$


---







