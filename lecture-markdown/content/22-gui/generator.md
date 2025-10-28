
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/guis-javafx/"]

+++

# Interfacce utente grafiche (GUI) con JavaFX

{{% import path="front-page.md" %}}

---

## Premessa

### Obiettivi della lezione

- Introdurre la libreria *JavaFX*
- Attraverso essa, introdurre allo sviluppo di interfacce grafiche utente, *Graphical User Interface (GUI)*
- Gettare le basi per la possibilità di un approfondimento autonomo

### Argomenti

- Elementi principali di applicazioni JavaFX (applicazione, stage, scene, layout, nodi)
- Elementi avanzati: data binding, FXML, CSS

### Riferimenti

- [https://github.com/unibo-lptsi-pss/pss-javafx](https://github.com/unibo-lptsi-pss/pss-javafx)
- *Learn JavaFX 17. Kishori Sharan and Peter Späth (Apress, 2022)* ([repo](https://github.com/Apress/learn-javafx17))
- [JavaFX JavaDoc](https://openjfx.io/javadoc/17/)

---

## Introduzione a JavaFX

---

### JavaFX

* Libreria Java per la creazione di GUI per Rich Applications multi-piattaforma

    * Disponibile dal 2008 (v. 1.0 -- 2.2) come libreria stand-alone
    * Presente "*stabilmente*" nel JDK da Java 8 (v. JavaFX 8)
    * ~~Introdotto ufficialmente in Java con l'idea di sostituire (gradualmente) Swing~~
    * Torna ad essere una *libreria stand-alone da Java 11*:
    è opensource e parte del progetto OpenJDK -- [https://openjfx.io](https://openjfx.io)

<!-- 
* Propone un look-and-feel personalizzabile

    * La descrizione dello stile/aspetto dei componenti della GUI è separato dalla relativa implementazione
    * Fornisce costrutti che promuovono il pattern MVC

-->

* Consente la creazione di GUI moderne, di qualità e ben adattabili a qualunque piattaforma e supporto hardware




---

## JavaFX: funzionalità principali

### Java APIs

* Libreria che include classi e interfacce scritte in Java <!-- e compilato con retro compatibilità fino a Java 7 -->
* Nel 2022, la versione più recente, *JavaFX 19*, richiede *JDK >= 11*


### FXML (e CSS per lo stile)

* **FXML** è un linguaggio dichiarativo per definire la GUI di un'applicazione JavaFX-based
* **CSS** è un linguaggio flessibile per specificare lo stile di elementi della GUI
* Il loro impiego non è indispensabile, ma fortemente consigliato per una buona *separazione dei concern*


### MVC-friendly

* Attraverso FXML/CSS, ma anche attraverso *proprietà osservabili* e *data binding*




---


### Graphics API



* Supporto nativo per la grafica 3D (geometrie, camere, luci)
* Abilita la possibilità di disegnare direttamente sulla superficie (canvas) dell'applicazione



### Supporto per schermi Multi-touch e Hi-DPI



* Fornisce il supporto per funzionalità  multi-touch (cf. `SwipeEvent`), in funzione della piattaforma in cui l'applicazione è in esecuzione
* Garantisce una buona visualizzazione della GUI anche su schermi ad alta densità di pixel



### Interoperabilità bidirezionale con la libreria Java built-in per GUI *Swing*



* GUI Swing esistenti possono includere componenti JavaFX (cf. `JFXPanel`)
* E' possibile inserire componenti Swing in interfacce JavaFX (cf. `SwingNode`)



---

## Astrazioni fondamentali


### Stage



* Il contenitore (esterno) dove la GUI sarà visualizzata (ad es., una finestra del S.O.)
    * Corrisponde al `JFrame` di Swing
* [javafx.stage.Stage](https://openjfx.io/javadoc/15/javafx.graphics/javafx/stage/Stage.html), sottoclasse di `Window` 



### Scene



* Una **scene** rappresenta un contenuto (una *pagina* della GUI) visualizzabile sullo `Stage`
    * ogni `Stage` può mostrare una sola `Scene` alla volta: si imposta via `Stage#setScene(Scene)`
* [javafx.scene.Scene](https://openjfx.io/javadoc/15/javafx.graphics/javafx/scene/Scene.html) contiene il cosiddetto *scene graph*, impostabile attraverso `Scene#setRoot(Parent)`




---


### Application



* Un'**applicazione JavaFX** si definisce estendendo [javafx.application.Application](https://openjfx.io/javadoc/15/javafx.graphics/javafx/application/Application.html)
    * Consente di definire metodi hook sul ciclo di vita dell'applicazione (`init`, `start`, `stop`, ...)
    * Tipicamente, si opera ridefinendo `start(Stage)` che riceve lo stage primario



#### Esempio: GUI vuota

```java
public class App extends javafx.application.Application {
	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 300);
		stage.setTitle("JavaFX Demo");
		stage.setScene(scene);
		stage.show();
	}
}
```


---

### Applicazione JavaFX: runner


```java
import javafx.application.Application;

public class Main {
	public static void main(String[] args) { 
	    // App è la classe definita nella slide precedente
	    Application.launch(App.class, args); 
	}   
}
```

* ATTENZIONE: per motivi tecnici che non approfondiremo, definire il metodo `main()` dentro la classe `App` (che estende `Application`) può risultare nel seguente errore: *"Error: JavaFX runtime components are missing, and are required to run this application"* (richiederebbe l'aggiunta di JavaFX al module path all'avvio dell'applicazione)
* Di conseguenza, si consiglia di definire `main` in una *classe separata da quella dell'applicazione JavaFX*



---

### Ciclo di vita di applicazioni JavaFX


L'avvio mediante `Application.launch(App.class)` comporta:


1. Avvio del runtime JavaFX <!-- %(se necessario) -->
    - comporta la creazione di vari thread, tra cui il *JavaFX Application Thread*
2. Istanziazione di `App` (la classe specificata che estende `Application`) 
3. Invocazione metodo `init()`
3. Invocazione metodo `start(javafx.stage.Stage)` dell'applicazione
4. Attesa terminazione applicazione 
	  - (a) mediante `Platform.exit()` 
	  - (b) chiusura dell'ultima finestra (e `Platform.isImplicitExit()` è true)
5. Invocazione metodo `stop()` dell'applicazione

---

### `Node`



* Un **nodo** è un elemento/componente della scena
    * Ciascun nodo ha sia la parte di view (aspetto) sia la parte di controller (comportamento)
    * Hanno **proprietà** (con supporto al *binding*) e possono generare **eventi**
    * Possono essere organizzati gerarchicamente
        * La sottoclasse `Parent` rappresenta nodi che possono avere figli (recuperabili via `getChildren()`)
    * Un nodo ha un ID univoco, coordinate locali, può subire trasformazioni (ad es. rotazione), ha un bounding rectangle associato, e può essere stilizzato via CSS
* Sottoclassi di [`Node`](https://openjfx.io/javadoc/15/javafx.graphics/javafx/scene/Node.html): `SwingNode`, `Canvas`, `Parent`



---

### Sommario


![](imgs/javafx-app-summary.png)



---

### Struttura di un'applicazione JavaFX-based


![](imgs/javafx-app-structure.png)

---

### Build Gradle ed esempi

- Si faccia riferimento al repository di esempio: 
[https://github.com/unibo-lptsi-pss/pss-javafx](https://github.com/unibo-lptsi-pss/pss-javafx)


```kotlin
plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

repositories {
    mavenCentral()
}

val javaFXModules = listOf("base", "controls", "fxml", "swing", "graphics" )
val supportedPlatforms = listOf("linux", "mac", "win") // All required for OOP
val javaFxVersion = 17

dependencies {
  for (platform in supportedPlatforms) {
    for (module in javaFXModules) {
      implementation("org.openjfx:javafx-$module:$javaFxVersion:$platform")
    } 
  } 
}

application {
    mainClass.set("it.unibo.samplejavafx.App")
}
```

---

### Creazione di un'applicazione JavaFX: linee guida

1. La classe principale di un'applicazione JavaFX (chiamiamola `App`) deve estendere la classe `javafx.application.Application`
3. Si effettua l'override di `void start(Stage primaryStage)` che è, di fatto, l'entry point dell'applicazione JavaFX (lo stage primario è creato dalla piattaforma)
4. Sullo stage is imposta la scena (`setScene()`)
5. Lo stage va mostrato invocando `show()`
2. Una *classe separata* definisce il `main()` dell'applicazione Java, che deve chiamare `Application.launch(App.class)`

<!-- La scena definita per lo stage (vedi metodo `setScene()`) costituisce il container principale per tutti i componenti della GUI -->



---

### Nodi e Proprietà


* Ogni scena ha un *root node* relativo a una *gerarchia di nodi* descrivente la GUI
* Ciascun nodo (componente) espone diverse *proprietà osservabili* (classe `Property<T>`)
    * relative all'aspetto (es. `size`, `posizion`, `color`, ...)
    * relative al contenuto (es. `text`, `value`, ...)
    * relative al comportamento (es. *event handler*, `controller`, ...)

* Ciascun nodo genera *eventi* in relazione ad azioni dell'utente



---

### GUI con bottone e label

```java
public class Example1 extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		final Label lbl = new Label();
		lbl.setText("Label text here...");

		final Button btn = new Button();
		btn.setText("Click me");

		final HBox root = new HBox();
		root.getChildren().add(btn);
		root.getChildren().add(lbl);

		stage.setTitle("JavaFX - Example 1");
		stage.setScene(new Scene(root, 300, 250));
		stage.show();
	}
}
```

---

### Binding e proprietà



* Per *binding* si intende il meccanismo che consente di collegare due proprietà fra loro, in modo unidirezionale o bidirezionale
* Una *proprietà JavaFX* `Property<T>` è un `ObservableValue<T>` (un valore ottenibile con `getValue()` a cui possono essere associati dei `ChangeListener` via `remove/addListener`) *scrivibile* che può essere collegato/scollegato ad altri osservabili o proprietà attraverso
    * `bind(ObservableValue<? extends T> observable)` / `bindBidirectional(Property<T> other)`
    * `unbind()` / `unbindBidirectional(Property<T> other)`
* Una proprietà JavaFX `xxx` di tipo `T` ha (opzionalmente) getter/setter `getXxx()` e `setXxx()`, e un metodo `xxxProperty()` che restituisce un oggetto `Property<T>`
    * Ad esempio, un `TextField` offre `getText():String`, `setText(String)`, e `textProperty():Property<String>`


```java
final TextField input = new TextField();
final Label mirror = new Label();
// connette la label con il valore del textfield
mirror.textProperty().bindBidirectional(input.textProperty());
mirror.setText("default");
```



---

## I layout (cf. package [javafx.scene.layout](https://openjfx.io/javadoc/13/javafx.graphics/javafx/scene/layout/package-summary.html))

* Sottoclassi di `Parent` (nodo che può avere nodi figli -- cf. proprietà protected `children`): 
    * `Group` (gestisce un insieme di figli; ogni trasformazione/effetto è applicata su ogni figlio)
    * `Region` (classe base per tutti i controlli UI e i layout)
        * `Control` (classe base per tutti i controlli UI)
* Ogni **layout** è un contenitore che regola il *posizionamento e il dimensionamento* dei nodi figli

### Group

* Da utilizzare per posizionare i componenti figli in posizioni fisse (cf. proprietà `layoutX` e `layoutY` dei `Node`)
* Ogni trasformazione/effetto applicato al gruppo è applicato su ogni figlio


### Region

* Classe base per tutti i layout general purpose (simili a quelli offerti da Swing):
    * `BorderPane`, `HBox`/`VBox`, `TilePane`, `GridPane`, `FLowPane`, `AnchorPane`, `StackPane`


---


![](imgs/layouts.png)

---


### Aggiungere componenti ad un layout



* Il metodo `ObservableList<Node> getChildren()` restituisce la lista di nodi figli di un qualunque nodo/layout
    * Alla lista possono essere aggiunti (`add(Node)` e `addAll(Node...)`) e gestiti i componenti figli

```java
Group g = new Group();
Label l1 = new Label("label");
Button b1 = new Button("a larger button");
Button b2 = new Button("small button");
g.getChildren().addAll(l1, b2, b3);
// Use binding to suitable place the components
b1.layoutXProperty().bind(l1.widthProperty().add(10));
b2.layoutXProperty().bind(b1.layoutXProperty()
    .add(b1.widthProperty()).add(10));
g.setTranslateX(-5); // applies translation to all children
g.setEffect(new DropShadow()); // applies effect to all children
```

---

- Layout pane forniscono metodi d'istanza/statici per dettagliare i posizionamenti

```java
Text center = new Text("Center"); // ...
BorderPane bpane = new BorderPane(center, top, right, bottom, left);
bpane.setCenter(new Text("NewCenter"));
```

```java
Button topLeft = new Button("Top Left");
AnchorPane.setTopAnchor(topLeft, 10.0); // 10px from the top edge
AnchorPane.setLeftAnchor(topLeft, 10.0); // 10px from the left edge
AnchorPane root = new AnchorPane(topLeft);
```

```java
// An empty vertical TilePane with 5px horiz / 10px vertical spacing
TilePane tp2 = new TilePane(Orientation.VERTICAL, 5, 10);
tp2.setPrefRows(3);
tp.setPrefTileHeight(100);
for(Month m : Month.values()) { tp2.getChildren().add(new Label(m.name())); }
```

```java
GridPane gp = new GridPane();
gp.setGridLinesVisible(true);
for(Month m : Month.values()) {
    Label l = new Label(m.name());
    gp.getChildren().add(l);
    int columnIndex = (m.getValue()-1) / 4; int rowIndex = (m.getValue()-1) % 4;
    GridPane.setConstraints(l, columnIndex, rowIndex);
    // OR ALSO: gp.add(l, columnIndex, rowIndex);
}
```



---

### Layout pane: sommario



![](imgs/javafx-layouts.drawio.png)


---

### Una nota sul posizionamento e dimensionamento delle GUI

- I *bound* di un nodo/scena/stage/schermi ne definiscono:
    - (1) *posizione* (position)
    - (2) *dimensione* (size)
- Essi sono definiti in termini di un cosiddetto *bounding rectangle*, rappresentato da un'istanza di `javafx.geometry.Bounds` che espone:
    - (1) le coordinate del punto in alto a sinistra: `getMinX()`, `getMinY()`, `getMinZ()`
    - (2) le dimensioni: `getWidth()`, `getHeight()`, `getDepth()`
    - Di conseguenza si definisce un default anche per `getMaxX()`... come `getMinX()+getWidth()`...
- Sul dimensionamento di una `Scene`
    - Se dimensione non è specificata, sarà calcolata automaticamente in base alla dimensione preferita dal contenuto
    - Se il nodo radice di una scene è ridimensionabile (ad es. `Region` ma non un `Group`), allora il ridimensionamento della scena causerà un aggiustamento del layout
- Sul dimensionamento di uno `Stage`
    - Se non ha una scena associata o la scena è vuota, la dimensione è specificata dalla piattaforma. Altrimenti, la dimensione sarà data dalla scena.
- Un `Node` può essere "gestito" (*managed*) o meno: nel primo caso, il parent ne gestirà il posizionamento/dimensionamento (in base alla *preferred size* del nodo)
- Se ci sono più `Screen` (si veda slide più avanti), i bound degli schermi non-primari saranno relativi a quelli dello schermo primario

---

## Eventi


* Gli **eventi** (`javafx.event.Event`) possono essere generati dall'interazione dell'utente con gli elementi grafici 
    * ogni evento ha un *event source*, *event target*, ed *event type*  e può essere consumato (`consume()`)
* GLi eventi possono essere gestiti attraverso *event handlers*
    * Per ogni tipo `T` che implementa `Event`, `EventHandler<T>` deve implementare il metodo `void handle(T)`
* Ogni nodo può registrare uno o più event handler
    * In generale, attraverso i metodi `setOn...()`
* Processamento degli eventi
    1. selezione dell'*event target* (ad es., il nodo su cui si è clickato)
    2. costruzione dell'*event route* (tipicamente dallo `Stage` all'event target)
    3. percorrimento dell'event route
        - (A) *capture phase*: esecuzione degli *event filter* dalla testa alla coda della route
        - (B) *event bubbling*: esecuzione degli *event handler* dalla coda alla testa della route

---

### Es. Gestione del click su un `Button`


```java
btn.setOnMouseClicked(event -> {
    lbl.setText("Hello, JavaFX World!");
});
// same as
btn.addEventHandler(ActionEvent.ACTION, e -> lbl.setText("Hello, JavaFX World!"));
```



---

### Esempio con più Stage (1/2)

```java
public class App extends Application {

  @Override
  public final void start(final Stage mainStage) {
    final Scene scene = new Scene(initSceneUI());
    mainStage.setScene(scene);
    mainStage.setTitle("JavaFX Example");
    mainStage.show();
  }

  private Parent initSceneUI() {
    final Label inputLbl = new Label("Input: ");
    final TextField inputArea = new TextField();
    final Button okBtn = new Button("Open a new Stage with the input data!");

    okBtn.setOnMouseClicked(event -> {
      new SecondStage(inputArea.getText()).show();
    });

    final BorderPane root = new BorderPane();
    root.setRight(okBtn);
    root.setLeft(inputLbl);
    root.setCenter(inputArea);

    BorderPane.setAlignment(inputLbl, Pos.CENTER_LEFT);
    BorderPane.setAlignment(okBtn, Pos.CENTER_RIGHT);

    return root;
  }
}
```


---

### Esempio con più Stage (2/2)

```java
public class SecondStage extends Stage {
    private Label lbl;

    public SecondStage(final String message) {
        super();
	    setTitle("New Window...");
	    setScene(new Scene(initSceneUI(), 400, 200));
	    lbl.setText(message);
    }

    private Parent initSceneUI() {
        lbl = new Label();
	    FlowPane root = new FlowPane();
	    root.setAlignment(Pos.CENTER);
	    root.getChildren().add(lbl);
	    return root;
    }
}

public class Main {
    public static void main(final String[] args) {
        Application.launch(App.class, args); 
    }
}
```

---

### JavaFX e concorrenza

* JavaFX ha un singolo thread che gestisce il processing degli eventi: **JavaFX Application Thread** (JFXAT)
* Tutte le modifiche allo *scene graph* devono essere effettuate su JFXAT
* Nota: è opportuno conoscere quali metodi hook dell'`Application` sono eseguiti (ad es. `start`) oppure no (ad es. `init`) su JFXAT
* **Platform.runLater(Runnable)**
 accoda il runnable nella coda degli eventi del JFXAT

---

### Conoscere dettagli degli schermi in uso

```java
Screen s = Screen.getPrimary();
double dpi = s.getDpi();
Rectangle2D sb = s.getBounds();
Ractangle2D svb = s.getVisualBounds();

ObservableList<Screen> screenList = Screen.getScreens();
```

Ad es., per dimensionare lo stage

```java
stage.xProperty().addListener(x -> {
    Screen s = Screen.getScreensForRectangle(
        new Rectangle2D(stage.getX(), stage.getY(), stage.getWidth(), stage.getHeight())
    ).get(0);
    stage.setMinHeight(...);
    stage.setMinWidth(...);
    stage.setMaxHeight(s.getVisualBounds().getHeight()/2);
    stage.setMaxWidth(s.getVisualBounds().getWidth()/2);
});
```

---

## MVC: descrizione sintetica del pattern

### MVC -- divide l'applicazione in 3 parti

*  `Model`: modello OO del dominio applicativo del sistema
*  `View`: gestisce le interazioni con l'utente (input e output)
*  `Controller`: gestisce il coordinamento fra Model e View

---

## Applicazione del MVC

### Sulla costruzione di applicazioni con GUI

*  Specialmente se non esperti, possono essere alquanto laboriose
*  Usare un approccio strutturato sembra richiedere più tempo nel complesso, ma in realtà porta a soluzione più facilmente modificabili e controllabili

### Alcune linee guida
 
* Usare il pattern MVC per la struttura generale
* Identificate le varie "interazioni", e quindi costruire le interfacce dei vari componenti bene fin dall'inizio
* Cercare massima indipendenza fra i vari componenti (interfacce con meno metodi possibile)
* Costruire e testare modello e GUI separatamente (M e V), poi collegare il tutto col controllore (C) che risulterà particolarmente esile

---


## MVC con le GUI: un esempio di struttura


![](imgs/MVC-abstract.png)


---


## Componenti e loro interazioni


    
### MVC



*  `Model`: incapsula dati e logica relativi al dominio della applicazione
*  `View`: incapsula la GUI, le sue sottoparti, e la logica di notifica
*  `Controller`: intercetta gli eventi della View, comanda le modifiche al modello, cambia di conseguenza la View



    
### Interfacce -- nomi da modificare in una applicazione concreta



*  `ModelInterface`: letture/modifiche da parte del Controller
*  `ViewObserver`: comandi inviati dalla view al controller (`void`)
*  `ViewInterface`: comandi per settare la view, notifiche a fronte dei comandi (errori..)





---


## Un esempio di applicazione: `DrawNumber`


---


## Interfaccia del model: `DrawNumber`



```java
public interface DrawNumber {
    void reset();
    DrawResult attempt(int n);
}

```


```java
public enum DrawResult {
    YOURS_LOW("Your number is too small"),
    YOURS_HIGH("Your number is too big"),
    YOU_WON("You won"),
    YOU_LOST("You lost");

    private final String message;
    
    DrawResult(final String message) {
        this.message = message;
    }

    public String getDescription() {
        return message;
    }
}

```

---
## Interfaccia del Modello: `DrawNumberObservable`
```java
public interface DrawNumberObservable extends DrawNumber {
    Property<Integer> minProperty();

    Property<Integer> maxProperty();

    Property<Optional<Integer>> lastGuessProperty();

    Property<Optional<DrawResult>> lastGuessResult();

    Property<Integer> attemptsProperty();

    Property<Integer> remainingAttemptsProperty();
}
```

---

## Implementazione del model (1/3): `DrawNumberImpl`

{{% smaller %}}

```java
public final class DrawNumberImpl implements DrawNumberObservable {

    private final Property<Integer> choice;
    private final Property<Integer> min;
    private final Property<Integer> max;
    private final Property<Integer> attempts;
    private final Property<Integer> remainingAttempts;
    private final Property<Optional<Integer>> lastGuess;
    private final Property<Optional<DrawResult>> lastGuessResult;
    private final Random random = new Random();

    public DrawNumberImpl(final Configuration configuration) {
        lastGuess = new SimpleObjectProperty<>(Optional.empty());
        lastGuessResult = new SimpleObjectProperty<>(Optional.empty());
        if (!configuration.isConsistent()) {
            throw new IllegalArgumentException("The game requires a valid configuration");
        }
        this.min = new SimpleObjectProperty<>(configuration.getMin());
        this.max = new SimpleObjectProperty<>(configuration.getMax());
        this.attempts = new SimpleObjectProperty<>(configuration.getAttempts());
        this.remainingAttempts = new SimpleObjectProperty<>(configuration.getAttempts());
        this.choice = new SimpleObjectProperty<>(configuration.getAttempts());
        this.reset();
    }

    ...
```

{{% /smaller %}}

---
## Implementazione del model (2/3): `DrawNumberImpl`
{{% smaller %}}
```java
public final class DrawNumberImpl implements DrawNumberObservable {
    ...
    @Override
    public void reset() {
        this.remainingAttempts.setValue(this.attempts.getValue());
        this.choice.setValue(this.min.getValue() + random.nextInt(this.max.getValue() - this.min.getValue() + 1));
    }

    @Override
    public DrawResult attempt(final int guess) {
        lastGuess.setValue(Optional.of(guess));
        DrawResult result = lastGuessResult.getValue().orElse(DrawResult.YOU_LOST);
        if (this.remainingAttempts.getValue() <= 0) {
            result = DrawResult.YOU_LOST;
        }
        if (guess < this.min.getValue() || guess > this.max.getValue()) {
            throw new IllegalArgumentException("The number is outside boundaries");
        }
        remainingAttempts.setValue(remainingAttempts.getValue() - 1);
        if (guess > this.choice.getValue()) {
            result = DrawResult.YOURS_HIGH;
        }
        if (guess < this.choice.getValue()) {
            result = DrawResult.YOURS_LOW;
        }
        if (guess == this.choice.getValue()) {
            result = DrawResult.YOU_WON;
        }
        lastGuessResult.setValue(Optional.of(result));
        return result;
    }
    ...
}
```

{{% /smaller %}}

---
## Implementazione del model (3/3): `DrawNumberImpl`
{{% smaller %}}
```java
public final class DrawNumberImpl implements DrawNumberObservable {
    @Override
    public Property<Integer> minProperty() {
        return min;
    }

    @Override
    public Property<Integer> maxProperty() {
        return max;
    }

    @Override
    public Property<Integer> remainingAttemptsProperty() {
        return remainingAttempts;
    }

    @Override
    public Property<Integer> attemptsProperty() {
        return attempts;
    }

    @Override
    public Property<Optional<Integer>> lastGuessProperty() {
        return lastGuess;
    }

    @Override
    public Property<Optional<DrawResult>> lastGuessResult() {
        return lastGuessResult;
    }
```
{{% /smaller %}}

---

## Interfacce della view: `DrawNumberView`



```java
public interface DrawNumberView {
    void setObserver(DrawNumberViewObserver observer);

    void start();

    void numberIncorrect();

    void result(DrawResult res);

    void displayError(String message);
}
```


```java
public interface DrawNumberViewObserver {
    void newAttempt(int n);

    void resetGame();

    void quit();
}

```

---


## Implementazione della view (1/3): `DrawNumberViewImpl`

{{% smaller %}}

```java
public final class DrawNumberViewImpl implements DrawNumberView {

    private static final String FRAME_NAME = "Draw Number App";
    private static final String QUIT = "Quit";
    private static final String RESET = "Reset";
    private static final String GO = "Go";
    private static final String NEW_GAME = ": a new game starts!";

    private DrawNumberViewObserver observer;
    private Stage frame;
    private Label message;
    private final DrawNumberObservable model;
    private final Bounds initialBounds;

    /**
     * Initialises a view implementation for a drawnumber game.
     * @param model
     * @param initialBounds
     */
    public DrawNumberViewImpl(final DrawNumberObservable model, final Bounds initialBounds) {
        this.model = model;
        this.initialBounds = initialBounds;
    }

    ...
}
```

{{% /smaller %}}

---

## Implementazione della view (2/3): `DrawNumberViewImpl`

{{% smaller %}}

```java
public final class DrawNumberViewImpl implements DrawNumberView {
    ...
    public void start() {
        frame = new Stage();
        frame.setTitle(FRAME_NAME);
        if (initialBounds != null) { frame.setX(initialBounds.getMinX()); frame.setY(initialBounds.getMinY()); }
        final VBox vbox = new VBox();
        final HBox playControlsLayout = new HBox();
        final TextField inputNumber = new TextField();
        final Button goButton = new Button(GO);
        messageLabel = new Label();
        
        final HBox gameControlsLayout = new HBox();
        final Button resetButton = new Button(RESET);
        final Button quitButton = new Button(QUIT);
        
        final Label stateMessage = new Label();        
        setUpStateMessage(stateMessage.textProperty(), model);

        goButton.setOnAction(e -> {
            try { observer.newAttempt(Integer.parseInt(inputNumber.getText())); } 
            catch (NumberFormatException exception) {
                MessageDialog.showMessageDialog(frame, "Validation error",
                        "You entered " + inputNumber.getText() + ". Provide an integer please...");
            }
        });
        quitButton.setOnAction(e -> observer.quit());
        resetButton.setOnAction(e -> observer.resetGame());

        playControlsLayout.getChildren().addAll(inputNumber, goButton, messageLabel);
        gameControlsLayout.getChildren().addAll(resetButton, quitButton);
        vbox.getChildren().addAll(playControlsLayout, gameControlsLayout, stateMessage);
        final int sceneWidth = 600;
        final int sceneHeight = 200;
        final Scene scene = new Scene(vbox, sceneWidth, sceneHeight);
        this.frame.setScene(scene);
        this.frame.show();
    }
    ...
}
```

{{% /smaller %}}

---


## Implementazione della view (2/3): `DrawNumberViewImpl`

{{% smaller %}}

```java
public final class DrawNumberViewImpl implements DrawNumberView {
    ...
    public void setObserver(final DrawNumberViewObserver observer) { this.observer = observer; }
    public void numberIncorrect() { displayError("Incorrect Number... try again"); }
    public void result(final DrawResult result) {
        switch (result) {
            case YOURS_HIGH:
                plainMessage(result.getDescription());
                return;
            case YOURS_LOW:
                plainMessage(result.getDescription());
                return;
            case YOU_WON:
                plainMessage(result.getDescription() + NEW_GAME);
                break;
            case YOU_LOST:
                plainMessage(result.getDescription() + NEW_GAME);
                break;
            default:
                throw new IllegalStateException("Unexpected result: " + result);
        }
        observer.resetGame();
    }
    private void plainMessage(final String message) { this.messageLabel.setText(message); }
    public void displayError(final String message) { this.messageLabel.setText(message); }
    private void setUpStateMessage(Property<String> stateMessage, DrawNumberObservable model) {
        stateMessage.bind(new SimpleStringProperty("Min=").concat(model.minProperty())
            .concat("; Max=").concat(model.maxProperty())
            .concat("\nMaxAttempts=").concat(model.attemptsProperty())
            .concat("; Remaining attempts=").concat(model.remainingAttemptsProperty())
            .concat("\nLast guess:").concat(model.lastGuessProperty())
            .concat("; Last outcome:").concat(model.lastGuessResult())
        );
    }
}
```

{{% /smaller %}}

---

## Implementazione del controller (1/2): `DrawNumberApp` 

{{% smaller %}}

```java
public final class DrawNumberFXApplication extends Application implements DrawNumberViewObserver {
    private DrawNumberObservable model;
    private List<DrawNumberView> views;

    public void init() {
        final Parameters params = getParameters();
        final String configFile = params.getRaw().stream().findFirst().orElseGet(() -> "examplemvc/config.yml");
        final Configuration.Builder configurationBuilder = new Configuration.Builder();
        // load from config ...
        
        final Configuration configuration = configurationBuilder.build();
        if (configuration.isConsistent()) {
            this.model = new DrawNumberImpl(configuration);
        } else {
            displayError(".....");
            this.model = new DrawNumberImpl(new Configuration.Builder().build());
        }

        views = Arrays.asList(
                new DrawNumberViewImpl(model, new BoundingBox(0, 0, 0, 0)),
                new DrawNumberViewImpl(model, null),
                new PrintStreamView(System.out)
        );
        try {
            views.add(new PrintStreamView("output.log"));
        } catch (FileNotFoundException fnfe) {
            System.out.println("Cannot find output file: " + fnfe.getMessage());
        }
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        for (final DrawNumberView view : views) {
            view.setObserver(this);
            view.start();
        }
    }

}

```

{{% /smaller %}}

---

## Implementazione del controller (1/2): `DrawNumberApp` 

{{% smaller %}}

```java
public final class DrawNumberFXApplication extends Application implements DrawNumberViewObserver {
    ....
    @Override
    public void start(final Stage primaryStage) throws Exception {
        for (final DrawNumberView view : views) {
            view.setObserver(this);
            view.start();
        }
    }

    private void displayError(final String err) {
        views.forEach(view -> view.displayError(err));
    }

    @Override
    public void newAttempt(final int n) {
        try {
            final DrawResult result = model.attempt(n);
            views.forEach(view -> view.result(result));
        } catch (IllegalArgumentException e) {
            for (final DrawNumberView view : views) {
                view.numberIncorrect();
            }
        }
    }

    @Override
    public void resetGame() {
        this.model.reset();
    }

    @Override
    public void quit() {
        Platform.exit();
    }
}

```

{{% /smaller %}}

---


## Linee guida generali consigliate su MVC


   
### Metodologia proposta



*  progettare le 3 interfacce

    *  M: metodi di "dominio", chiamati da C
    *  C: metodi (`void`) chiamati da V, esprimono "azioni utente"
    *  V: metodi (`void`) chiamati da C, esprimono richieste di visualizzazione


*  la tecnologia scelta per le GUI sia interna a V, e mai menzionata altrove o nelle interfacce
*  implementare separatamente M, V e C, poi comporre e testare
*  in progetti reali, M, V e C si compongono di varie parti



   
### Aspetti



*  MVC è implementato in vari modi, o esiste in diverse varianti
    - Model-View-ViewModel (MVVM), Model-View-Presenter (MVP), ...
*  l'approccio proposto è particolarmente indicato per la sua semplicità
*  si usino altri approcci se non peggiorativi

---


# Interfacce utente grafiche (GUI) con JavaFX

{{% import path="front-page.md" %}}