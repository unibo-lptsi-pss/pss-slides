
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/io/"]

+++

# Input/Output

{{% import path="cover.md" %}}

---

## Outline

### Goal della lezione
* Illustrare le API fornite da Java per l'I/O
* Descrivere alcune scelte progettuali e pattern
* Mostrare esempi di applicazione

### Argomenti
* Classi per gestire file
* Classi per gestire Stream (di input/output)
* Classi per gestire file di testo
* Pattern Decorator

---

## Il problema dell'Input/Output

### Uno dei problemi fondamentali per un sistema operativo
*  Gestire le comunicazioni fra CPU e dispositivi affacciati sul BUS
  * Console, tastiera, mouse, dischi, rete, sensori, schermo
* Vi sono varie modalità di interazione possibili
  * sequenziale, random-access, buffered, per carattere/linea/byte/oggetto
* I sistemi operativi offrono vari meccanismi
  * file, I/O control interface, socket per il networking, video driver

### La libreria `java.io.*`
*  Fornisce i concetti di File e Stream di dati
*  Consente una gestione flessibile dei vari aspetti
*  È estesa con la libreria `java.nio`
*  È la base di librerie avanzate (networking,..), anche di terze parti (Jackson, Gson, ...)
*  I/O con l'utente in ambiente a finestre è realizzato con le GUI

---

# File e loro proprietà

---

## I File

### File system
* Il file system è un modulo del S.O. che gestisce la memoria secondaria
* Maschera le diversità di dispositivi fisici (HD, CD, DVD, BR, SSD,..)
* Maschera le diversità di contenuti informativi (testi, filmati, archivi,..)
* Fornisce meccanismi per fornire prestazioni, concorrenza, robustezza

### File
* Un file system contiene un insieme di *__file__*
* Un file ha un contenuto informativo che si esprime come sequenza di byte
  * interpretabili in vario modo (testi, programmi, strutture dati)
  * potrebbe essere un file virtuale, che mappa un dispositivo
  * un caso particolare è la **directory** (ossia una tabella di ID di file)
  * può avere specifici diritti di accesso (sola lettura, lettura/scrittura, eseguibilità...)
* Le **directory** consentono un'organizzazione gerarchica (ogni file ha un percorso o *path*)

---

## La classe `java.io.File`

### Usi
* Serve a *identificare* un preciso file su file systems
* Permette di ottenere *informazioni* varie sul file
* Permette di effettuare alcune operazioni sull'intero file
  * cancellazione
  * spostamento (rinominazione)
* Permette di impostare alcune proprietà (se eseguibile, se scrivibile)
* Permette di ottenere informazioni generali sul file system
* Permette di creare cartelle
* $\Rightarrow$ *non include operazioni per accedere al suo contenuto*, ma vi si potrà agganciare uno *stream*

---

## Classe `java.io.File`: pt1

```java
{{% import-raw from=1 to=28 path="code/io/File.java" %}}
```
---

## Classe `java.io.File`: pt2

```java
{{% import-raw from=30 to=100 path="code/io/File.java" %}}
```

---

## Esempio di utilizzo di File: cercare file con una certa enstensione dentro una directory

```java
{{% import-raw path="pss-code/src/main/java/it/unibo/io/files/FileUtil.java" %}}
```

---

## Accedere al contenuto di un file

### Come fare?
* Un file ha un contenuto informativo (potenzialmente di grosse dimensioni)
* Lo si potrebbe leggere (in vari modi)
* Lo si potrebbe scrivere (in vari modi)
* Il suo contenuto potrebbe essere interpretabile in vari modi

### Alcuni di tali concetti sono condivisi con altri meccanismi
* Risorse interne al classpath Java
* Networking e file di rete
* Archivi su database
* Depositi di informazione in memoria


#### Il concetto di *__input/output-stream__* è usato come astrazione unificante

---

# Input/OutputStream

---

## Overview sugli `InputStream` e `OutputStream` in Java

### `InputStream` e `OutputStream`
* Stream = flusso (di dati)
* Di base, gestiscono flussi binari (di `byte`) leggibili vs. scrivibili
* Sono classi astratte (e non interfacce..)
* Possono essere specializzate da "sottoclassi" e "decorazioni", tra cui
  * Per diverse sorgenti e destinazioni di informazione
    * su file (`File`(`In`|`Out`)`putStream`)
    * su memoria (`ByteArray`(`In`|`Out`)`putStream`)
  * Per tipo di informazione:
    * valori primitivi (`Data`(`In`|`Out`)`putStream`)
    * interi oggetti Java (`Object`(`In`|`Out`)`putStream`)
    * archivi compressi (`Zip`(`In`|`Out`)`putStream`)

### Tipicamente usati per alimentare altre classi

*  File di testo (`Reader`, `Writer`, e specializzazioni)
  *  Librerie avanzate comunemente usate per l'accesso al file system tipicamente hanno metodi che accettano (`In`|`Out`)`putStream`

---

## La classe `java.io.InputStream`

```java
public abstract class InputStream implements Closeable {
    // Reads the next byte (0 to 255, -1 is end-of-stream)
    public abstract int read() throws IOException;

    public int read(byte b[]) throws IOException {...}

    public int read(byte b[], int off, int len) throws IOException {...}

    public long skip(long n) throws IOException {...}

    public int available() throws IOException {...}

    public void close() throws IOException {...}

    public synchronized void mark(int readlimit) {...}

    public synchronized void reset() throws IOException {...}

    public boolean markSupported() {...}
}
```

---


## `FileInputStream` e `ByteArrayInputStream`

```mermaid
classDiagram
class InputStream {
  read() int
  read(byte b[]) int
  read(byte b[], int off, int len) int
  skip(long n) long
  available() int
  close() void
}
class FileInputStream {
  getChannel() FileChannel
  getFD() FileDescriptor
}
class ByteArrayInputStream {
  readAllBytes() byte[]
  readNBytes(byte[] b, int off, int len) int
}
InputStream <|-- FileInputStream
InputStream <|-- ByteArrayInputStream
```

---

## Uso di `ByteArrayInputStream`
### `ByteArrayInputStream`
* crea un `InputStream` a partire da un `byte[]`

```java
{{% import-raw path="pss-code/src/main/java/it/unibo/io/files/UseByteArrayStream.java" %}}
```

---

## Il costrutto `try-with-resources`
* vuole la creazione di un `java.lang.AutoCloseable` come primo argomento
* ne assicura la chiusura
* si possono opzionalmente aggiungere delle `catch` di eccezioni
* è il modo preferibile di utilizzare risorse in Java!

```java
{{% import-raw path="pss-code/src/main/java/it/unibo/io/files/UseTryWithResources.java" %}}
```

---

## Esempio `StreamDumper`

```java
{{% import-raw path="pss-code/src/main/java/it/unibo/io/files/StreamDumper.java" %}}
```

---

## `UseStreamDumper` -- uso uniforme di vari `InputStream`

```java
{{% import-raw from=1 to=2 path="pss-code/src/main/java/it/unibo/io/files/UseStreamDumper.java" %}}
import ...

{{% import-raw from=12 to=100 path="pss-code/src/main/java/it/unibo/io/files/UseStreamDumper.java" %}}
```

---

## La classe `java.io.OutputStream`

```java
public abstract class OutputStream implements Closeable, Flushable{
    /**
     * ..The byte to be written is the eight
     * low-order bits of the argument <code>b</code>. The 24
     * high-order bits of <code>b</code> are ignored.
     */
    public abstract void write(int b) throws IOException;

    public void write(byte b[]) throws IOException {...}

    public void write(byte b[], int off, int len) throws IOException {...}

    public void flush() throws IOException {...}

    public void close() throws IOException {...}
}
```

### Stream di uscita -- Duale all'`InputStream`

*  Esistono anche le analoghe specializzazioni `ByteArrayOutputStream` e `FileOutputStream`

---





## `UseOutputStream`

```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/io/files/UseOutputStream.java" %}}
```



---


## `UseOutputStream2` -- qualche variante



```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/io/files/UseOutputStream2.java" %}}
```



---



## Salvataggio di strutture dati: `List<Byte>`



```java
{{% import-raw from=6 to=100 path="pss-code/src/main/java/it/unibo/io/files/ListOnFile.java" %}}
```



---


## Solo `byte`?



### Problema...



	*  Poter leggere e scrivere da uno `Stream` anche `int`, `long`, eccetera

	%*  Nel caso nuove esigenze simili si debbano creare, non devono esserci interferenze o esplosione di classi




### Il concetto di decoratore



	*  Si definisce `DataInputStream` che estende `InputStream`{

	    *  e similmente `DataOutputStream` che estende `OutputStream`

}
	*  Tale nuova classe comunque fa da wrapper per un `InputStream`, al quale delega le varie operazioni
	*  Un oggetto di tale nuova classe è un decoratore per quello interno.. visto che ne modifica il funzionamento
	*  Con questa tecnica è possibile decorare sia un `FileInputStream` che un `ByteArrayInputStream` -- o altri





---


## Decorazione, in generale


    ![](img/decorator.png)


---


## Decorazione, il caso di `DataInputStream`


    ![](img/dec.png)


---


## `DataInputStream`



```java
{{% import-raw from=1 to=100 path="code/io/DataInputStream.java" %}}
```



---


## `DataOutputStream`



```java
{{% import-raw from=1 to=100 path="code/io/DataOutputStream.java" %}}
```



---


## `UseDataStream`



```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/io/files/UseDataStream.java" %}}
```



---


## Altra decorazione: `BufferedInputStream`, `BufferedOutputStream`



### Esigenza



	*  fornire una diversa implementazione interna dello stream
	*  non legge un byte alla volta, ma riempie un buffer
	*  questo aumenta le performance nell'accesso a file e rete
	*  come fornire la funzionalità in modo ortogonale al resto della gestione degli stream?




### `BufferedInputStream`, `BufferedOutputStream`



	*  sono ulteriori decoratori, della stessa forma dei precedenti
	*  non aggiungono altri metodi
	*  per come sono fatti i decoratori, possono essere usati in "cascata" a `DataInputStream` e `DataOutputStream`





---


## `UseBufferedDataStream`



```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/io/files/UseBufferedDataStream.java" %}}
```



---


## `UseBufferedDataStream2` -- chaining dei costruttori



```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/io/files/UseBufferedDataStream2.java" %}}
```



---



## Decorazione, una visione complessiva


    ![](img/dec-all.png)


---


## Altri decoratori di `InputStream` (..e `OutputStream`)



### Sono molteplici, tutti usabili in combinazione



      *  `CheckedInputStream`: mantiene un "checksum" per verifica integrità
      *  `CipherInputStream`: legge dati poi processati dopo una cifratura
      *  `DeflateInputStream`: legge dati e li comprime in formato "deflate"
      *  `InflaterInputStream`: legge dati e li scompatta dal formato "deflate"
      *  `ProgressMonitorInputStream`: legge dati con possibilità di "unread"





---



## Ancora sui decoratori



### Pro e contro



	*  Sono un mix di polimorfismo e incapsulamento
	*  Consentono di comporre funzionalità in modo piuttosto flessibile
	*  Danno luogo a più flessibilità rispetto all'ereditarietà
	*  Più complicati da usare e comprendere




### Con gli stream, è possibile comporre:



	*  Uno stream di sorgente dati: `FileInputStream`, `ByteArrayInputStream`, ..
	*  Uno (o più) stream di gestione interna: `BufferInputStream`, ..
	*  Uno stream di presentazione dati: `DataInputStream`, `ObjectInputStream`, ..





---

\section[De/serializzazione]{De/Serializzazione di oggetti}


## File ed encoding



### Il contenuto dei file


      Supponiamo utilizziate un `DataOutputStream` per scrivere in sequenza i numeri da 0 a 20 (escluso)


            *  Che cosa avete realmente scritto?
            *  avete scritto i byte da zero a 19
            *  In esadecimale, `0x000102030405060708090A0B0C0D0E0F10111213`
            *  **Non** avete scritto il testo `012345678910111213141516171819`






        *  I file sono sequenze di byte
        *  Per fare input/output occorre stabilire:


          *  Una conversione dalla struttura dati che stiamo manipolando a sequenza di byte (encoding)
          *  Una conversione da sequenza di byte a struttura dati (decoding)


        *  I `Data-Stream` offrono encoding e decoding per tipi primitivi
        *  Come trattare strutture dati più articolate?




---


## Serializzazione di oggetti



### Motivazioni



	*  Rendere gli oggetti persistenti, e trasferibili a istanze di JVM diverse
	*  Esempio: memorizzarli su file, su array di byte, trasferirli via rete
	*  Java Serialization{

	    *  serializza con relativa semplicità strutture di oggetti anche complicate
	    *  a volte è fondamentale apportarvi correzioni ad-hoc

}





### Ingredienti Serialization



	    *  Interfaccia "tag" `java.io.Serializable`
	    *  Classi `ObjectInputStream` e `ObjectOutputStream`
	    *  Keyword `transient` per campi che non devono essere serializzati
	    *  Metodi `readObject` e `writeObject` (e altri) per modificare la serializzazione di default per un oggetto, o per motivi di sicurezza
	    *  Meccanismo `UID` per gestire versioni diverse delle classi





---


## Diagramma UML con `ObjectInputStream`


    ![](img/object.png)


---


## Classe `Person` e l'interfaccia "tag" `Serializable`



```java
{{% import-raw from=3 to=100 path="pss-code/src/main/java/it/unibo/io/files/Persona.java" %}}
```


### `Serializable` -- implementata già da molte classi, non `Object`



	*  da implementare per avere oggetti "automaticamente" serializzabili
	*  ciò non comporta alcun contratto da ottemperare





---


## Classe `UseObjectStream`



```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/io/files/UseObjectStream.java" %}}
```



---


## Classe `UseObjectStream`: note



### Note



	*  la `writeObject()`/`readObject()` fallisce se l'oggetto non è serializzabile{

	  *  se la classe dell'oggetto non implementa `Serializable`
	  *  la la classe dell'oggetto ha un campo che sia un oggetto non serializzabile

}
	*  la `readObject()` fallisce se la classe dell'oggetto non è disponibile
	*  la `readObject()` fallisce se la classe dell'oggetto è una versione diversa






---


## Come funzionano `writeObject()`/`readObject()`



### `ObjectOutputStream.writeObject()`



	*  Lancia una eccezione se l'oggetto non è serializzabile
	*  Scrive sullo stream i campi dell'oggetto uno a uno <br> (di tipi primitivi o serializzabili a loro volta)
	*  Si evitano i campi con modificatore `transient`
	*  In questo processo, si evita di scrivere due volte uno stesso oggetto




### `ObjectInputStream.readObject()`



	*  Lancia una eccezione se non trova la classe o non è *__compatibile__*
	*  Chiama il costruttore senza argomenti della prima sopra-classe non serializzabile, e da lì in giù non chiama altri costruttori
	*  Ripristina il valore dei campi leggendoli dallo stream
	*  Lascia inalterati i campi `transient`





---


## Il problema delle versioni di una classe: `serialVersionUID`



### Problema



	*  Si serializza un oggetto, la classe viene modificata e ricompilata, e quindi si ritira su l'oggetto..  i dati sarebbero facilmente "corrupted"




### Soluzione: ogni classe che implementa `Serializable`...



	*  .. deve fornire una costante "`long serialVersionUID`" che contiene un numero univoco per quella versione della classe
	*  Se non corrisponde a quello dell'oggetto caricato si ha eccezione




### Fatti



	*  Se mancante Eclipse segnala warning. Può generarne uno a richiesta.
	*  Se mancante la JVM ne calcola uno suo ma è sconsigliato.
	*  Molti lasciano il campo al valore $1$, non preoccupandosene.





---


## I campi `transient`



### I campi `transient` non vengono serializzati. In quali casi servono?



	*  Campi aggiunti per motivi di performance (p.e., caching di un calcolo), e che quindi possono essere ricostruiti a partire dagli altri campi
	*  Campi che contengono info specifiche sul run corrente della JVM (p.e., logs), e che quindi non avrebbero più senso quando l'oggetto viene recuperato dallo stream
	*  Campi che contengono oggetti comunque non serializzabili (p.e., `Object`), e che quindi porterebbero ad una eccezione
	*  Campi per i quali si vuole prevedere un meccanismo di serializzazione diverso





---


## `CPersona` con caching `toString`, pt1



```java
{{% import-raw from=3 to=29 path="pss-code/src/main/java/it/unibo/io/trans/CPersona.java" %}}
```



---


## `CPersona` con caching `toString`, pt2



```java
{{% import-raw from=31 to=100 path="pss-code/src/main/java/it/unibo/io/trans/CPersona.java" %}}
```



---


## `UseTransient`



```java
{{% import-raw from=6 to=100 path="pss-code/src/main/java/it/unibo/io/trans/UseTransient.java" %}}
```



---


## Progettazione di una serializzazione ad-hoc



### Serializzazione ad-hoc



	*  Il modello transient/non-transient a volte non è sufficiente
	*  A volte serve serializzare in modo diverso certi campi
	*  È possibile definire per la classe serializzabile i metodi "`void readObject(ObjectInputStream in)`" e "`void writeObject(ObjectOutputStream out)`"
	*  Se definiti, `ObjectInputStream` e `ObjectOutputStream` chiamano quelli




### Dettagli



	*  Tali metodi possono cominciare con la chiamata a `defaultReadObject()`/`defaultWriteObject()`, per leggere i campi non-statici e non-transienti
	*  Si può quindi proseguire scrivendo/leggendo negli stream in input quello che si vuole





---


## `APersona`: serializzazione ad-hoc per una data



```java
{{% import-raw from=6 to=35 path="pss-code/src/main/java/it/unibo/io/trans/APersona.java" %}}
```



---



## `UseAdHocSerialization`



```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/io/trans/UseAdHocSerialization.java" %}}
```



---


## Serializzazione ad-hoc per `java.util.ArrayList`, pt1



```java
{{% import-raw from=1 to=23 path="code/io/ArrayList.java" %}}
```



---


## Serializzazione ad-hoc per `java.util.ArrayList`, pt2



```java
{{% import-raw from=25 to=100 path="code/io/ArrayList.java" %}}
```



---


## Note sulla serializzazione Java



### Raramente utilizzata in applicazioni "vere"


        Applicazioni vere tendono a non utilizzare `Object`(`In`/`Out`)`putStream`:


            *  Nessuna standardizzazione
            *  Poco efficiente in termini di spazio
            *  Dispendiosa in termini di performance
            *  Scarsa portabilità (solo da/a software Java)
            *  `readObject` / `writeObject` in qualche modo violano il linguaggio





### Importanza di `Serializable`


        Approcci diversi alla serializzazione spesso:


            *  Serializzano oggetti `Serializable` con campi `Serializable` e non `transient` (deve valere ricorsivamente)
            *  Prevedono sistemi custom per la serializzazione di oggetti diversi
            *  Non fanno uso di `readObject` / `writeObject`






---



# `RandomAccessFile

---
`


## Classe `RandomAccessFile`



### Motivazioni



	*  Alcuni file sono di grosse dimensioni, e non vengo letti/scritti per intero come nei casi visti finora
	*  Bensì si modifica qualche elemento "a metà", o se ne aggiungono in fondo, o si legge un elemento in una data posizione




### Classe `RandomAccessFile`



	*  Non è usata tramite `InputStream` o `OutputStream`
	*  Fornisce i metodi di `DataInput` e `DataOutput`
	*  Fornisce metodi aggiuntivi:{

	    *  `getFilePointer`: torna la posizione corrente nel file
	    *  `seek`: imposta la nuova posizione nel file
	    *  `length`: torna la lunghezza del file
	    *  `setLength`: imposta la lunghezza del file

}





---


## Classe `RandomAccessFile`


    ![](img/random.png)


---


## `UseRandomAccessFile`



```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/io/files/UseRandomAccessFile.java" %}}
```



---




# File di testo

---



## Limitazione degli stream binari visti finora


  Finora abbiamo visto stream binari, ed in particolare di oggetti Java


    *  Non esiste uno standard documentato


      *  Gli standard descrivono in modo inequivoco un protocollo (in questo caso di de/serializzazione)
      *  Difficile scrivere librerie per leggere e scrivere in quel formato
      *  Bassa **standardizzazione**


    *  Non comprensibili da applicazioni non-Java


      *  Oggetti serializzati non apribili da applicazioni in Javascript, Python, eccetera
      *  Non adatti e.g., per applicazioni web
      *  Bassa **portabilità**


    *  Non comprensibili se aperti in formato testuale


      *  Non modificabili da umani
      *  Non adatti e.g., per file di configurazione
      *  Bassa **leggibilità** e quindi **intelligibilità**






---


## Limitazione degli stream binari visti



### Standardizzazione e portabilità




      *  Non direttamente ascrivibili al formato binario
      *  (che comunque non aiuta...)
      *  Esistono standard portabili binari, come ProtocolBuffers





### Leggibilità e intelligibilità




      *  Problema comune a tutti i meccanismi finora visti
      *  Esistono standard per scrivere oggetti in formato testuale
      *  Problema da risolvere in due fasi:


        *  Conversione da oggetto a stringa di testo e viceversa
        *  Conversione da stringa di testo a file e viceversa








---


## Conversione da oggetto a stringa di testo e viceversa




    *  Banale nel caso in cui l'oggetto sia una stringa
    *  Molto più complicato per strutture dati arbitrarie
    *  Passo necessario verso l'interoperabilità fra linguaggi



### (Alcuni) Formati standard per la conversione di oggetti in testo




      *  JavaScript Object Notation -- JSON (RFC 7159)


        *  Nato in seno a JavaScript (che non c'entra nulla con Java)
        *  Molto usato nel web


      *  Tom's Obvious, Minimal Language -- TOML


        *  Particolarmente indicato per file di configurazione


      *  YAML Ain't Markup Language -- YAML


        *  Superset di JSON dalla versione 1.2
        *  Supporto per funzioni avanzate (e.g. anchoring)
        *  Molto usato per file di configurazione complessi








---


## Conversione stringa a file di testo


  Problema risolto con tabelle di conversione (text encoding)

  Nota: importante anche per la rappr. **in memoria** dei caratteri

### Text Encoding




        *  ASCII (RFC 20)


          *  l'encoding che usa il linguaggio C per i `char`
          *  1 byte per carattere (massimo 256 caratteri)


        *  UTF-8 (RFC 3629)


          *  Standard di fatto sul web, encoding di default in Linux
          *  encoding da usare per i sorgenti di codice
          *  da 1 a 4 byte per carattere
          *  Codifica 1.112.064 simboli


        *  UTF-16 (RFC 2781)


          *  Encoding in memoria delle `String` in Java
          *  2 o 4 byte per carattere
          *  Codifica 1.112.064 simboli


        *  ISO Latin (ISO/IEC 8859-1:1998)


          *  Encoding di default del testo in Windows








---





























## File di testo



### File binari vs file di testo



	*  Gli stream binari sono quelli visti, sono costituiti da sequenze di byte e il modo col quale si ottengono da questi altri tipi primitivi è standard
	*  Gli "stream di testo" hanno problematiche diverse:{

	    *  sono sequenze di caratteri
	    *  la codifica (UTF-8, UTF-16, ASCII) potrebbe variare
	    *  la codifica potrebbe dettare anche i codici speciali di "a capo" etc.

}
	*  Questa gestione richiede classi specifiche




### `Reader` (e `Writer)`



	*  `Reader`: la radice, con metodi per leggere caratteri, e linee di testo
	*  `StringReader`: decoratore per prelevare da `String`
	*  `BufferedReader`: decoratore per ottimizzare gli accessi
	*  `InputStreamReader`: decoratore che incapsula un `InputStream`
	*  `FileReader`: sua estensione per leggere da file via `FileInputStream`





---


## UML classi relative ai reader (writer analoghi)


    ![](img/text.png)


---


## Esempio: `UseReadersWriters`



```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/io/files/UseReadersWriters.java" %}}
```



---


## Esempio: `UseStreamReadersWriters`



```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/io/files/UseStreamReadersWriters.java" %}}
```



---


## Il caso di: `System.in` e `System.out`



```java
{{% import-raw from=5 to=100 path="pss-code/src/main/java/it/unibo/io/files/SystemInOut.java" %}}
```



---


## Riassunto classi



### Identificazione di un file (o directory)



    *  `File`




### Accesso random



    *  `RandomAccessFile`




### Lettura di file dati (scrittura duale)



    *  `FileInputStream` + `BufferedInputStream` + `DataInputStream`
    *  `FileInputStream` + `BufferedInputStream` + `ObjectInputStream`




### Lettura di file di testo (scrittura duale)



    *  `FileReader` + `BufferedReader`
    *  `FileInputStream` + `InputStreamReader` + `BufferedReader`





---
