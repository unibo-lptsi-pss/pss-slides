## Risorse caricate dal classpath

* Abbiamo visto finora il *classpath* come l'insieme dei *percorsi* dove la virtual machine va a cercare le classi da caricare
    * Come abbiamo visto usando l'opzione `-cp` di `java` e `javac`, il classpath può contenere indifferentemente dei path o dei JAR (o anche degli zip)
* Esso includerà tipicamente anche le risorse del progetto, i JAR delle dipendenze importate, etc.
* Come possiamo accedere a queste risorse in modo uniforme?

    * Ossia caricarle sia che si trovino sul file system, sia che si trovino nel JAR eseguibile, sia che vengano incluse in un JAR di risorse separato.

* Java fornisce un'utilità per caricare risorse dal **classpath**
    * Approccio **location-independent**: non importa dove il codice venga eseguito fin tanto che l'ambiente viene correttamente impostato per trovare le risorse.


---

### `ClassLoader.getSystemResource`(`AsStream`)`(String)`

```java
public abstract class ClassLoader {
  public static ClassLoader getSystemClassLoader();
  public static URL getSystemResource(String name);
  public static InputStream getSystemResourceAsStream(String name);
  public URL getResource(String name);
  // ...
```

* Un **class loader** (istanza di `ClassLoader`) è un'oggetto responsabile del *caricamento di classi e risorse*
    * ogni class loader ha un class loader padre, per sfruttare un meccanismo di delega
    * il parent di default è il **system class loader** che carica classi e risorse *dal classpath*
* Una **risorsa di sistema** (system resource) è una risorsa "built-in" del sistema software, oppure disponibile nel sistema host (ad es. nel filesystem locale)
    * Per esempio, l'implementazione di base ricerca nel `CLASSPATH`
* L'argomento di `getSystemResource` e `getSystemResourceAsStream` è il **nome di una risorsa** (**non un percorso del filesystem!**), che è una stringa separata da `/` che identifica la risorsa
    * L'interpretazione del nome della risorsa dipende dall'implementazione
    * Il system class loader usa il nome come un path per cercare la risorsa a partire dalle entry del classpath
* `ClassLoader.getSystemResource()` equivale a `ClassLoader.getSystemClassLoader().getResource()`



---

### Risorse caricate dal classpath -- Esempi

#### Caricamento di File

```java
final InputStream in = ClassLoader.getSystemResourceAsStream("/settings/settings");
final BufferedReader br = new BufferedReader(new InputStreamReader(in));
final String line = br.readLine();
in.close();
```

#### Caricamento di Immagini

```java
final URL imgURL = ClassLoader.getSystemResource("/images/gandalf.jpg");
final ImageIcon icon = new ImageIcon(imgURL);
final JLabel lab1 = new JLabel(icon);
```

Progetto di esempio:
https://github.com/unibo-oop/example-with-get-resources

---

## Installazione delle impostazioni per-utente

#### Motivazione

Spesso un software ha necessità di caricare al primo avvio delle *impostazioni di default*, quindi lasciare l'utente libero di modificarle e, se avviato successivamente caricare quelle scelte dall'utente. In caso di sistema multiutente, le impostazioni saranno diverse per ciascuno.

#### Strategia

* Si sceglie una cartella nella **home folder dell'utente** dove salvare le impostazioni.
    * È norma consolidata creare una cartella `.nomeprogramma`.
* Al primo avvio, si verifica se tale cartella esista e se contenga i file di configurazione previsti.
    * Se non è presente, o se non sono presenti e leggibili alcuni i file, si procede a caricare nella cartella di destinazione i file di default dal JAR usando `getResource()`.
