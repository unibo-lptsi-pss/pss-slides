
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/guis-javafx/"]

+++

# Interfacce utente grafiche (GUI) con JavaFX

{{% import path="front-page.md" %}}

<!-- {{% import path="cover.md" %}} -->


## Introduzione a JavaFX

---

### JavaFX

* Libreria Java per la creazione di GUI per Rich Applications multi-piattaforma

    * Disponibile dal 2008 (v. 1.0 -- 2.2) come libreria stand-alone
    * Presente "*stabilmente*" nel JDK da Java 8 (v. JavaFX 8)
    * ~~Introdotto ufficialmente in Java con l'idea di sostituire (gradualmente) Swing~~
    * Torna ad essere una *libreria stand-alone da Java 11*:
    è opensource e parte del progetto OpenJDK -- [https://openjfx.io](https://openjfx.io)

* Propone un look-and-feel personalizzabile

    * La descrizione dello stile/aspetto dei componenti della GUI è separato dalla relativa implementazione
    * Fornisce costrutti che promuovono il pattern MVC

* Consente la creazione di GUI moderne, di qualità e ben adattabili a qualunque piattaforma e supporto hardware




---

## JavaFX: funzionalità principali

### Java APIs



* Libreria che include classi e interfacce scritte in Java <!-- e compilato con retro compatibilità fino a Java 7 -->
* Nel 2022, la versione più recente, *JavaFX 19*, richiede *JDK >= 11*


### FXML (e CSS per lo stile)



* **FXML** è un linguaggio dichiarativo per definire la GUI di un'applicazione JavaFX-based
* Il suo impiego non è indispensabile, ma fortemente consigliato per una buona *separazione dei concern*



### Interoperabilità bidirezionale con la libreria Java built-in per GUI *Swing*



* GUI Swing esistenti possono includere componenti JavaFX (cf. `JFXPanel`)
* E' possibile inserire componenti Swing in interfacce JavaFX (cf. `SwingNode`)




---


### Graphics API



* Supporto nativo per la grafica 3D (geometrie, camere, luci)
* Abilita la possibilità di disegnare direttamente sulla superficie (canvas) dell'applicazione



### Supporto per schermi Multi-touch e Hi-DPI



* Fornisce il supporto per funzionalità  multi-touch (cf. `SwipeEvent`), in funzione della piattaforma in cui l'applicazione è in esecuzione
* Garantisce una buona visualizzazione della GUI anche su schermi ad alta densità di pixel





---

## Astrazioni fondamentali


### Stage



* Il contenitore (esterno) dove la GUI sarà visualizzata

    * es. una finestra del S.O.
    * Equivalente al `JFrame` di Swing
    * Non è compito del programmatore creare una sua istanza.

* [https://openjfx.io/javadoc/15/javafx.graphics/javafx/stage/Stage.html](https://openjfx.io/javadoc/15/javafx.graphics/javafx/stage/Stage.html)



### Scene



* Una **scene** rappresenta un contenuto (una *pagina* della GUI) visualizzabile sullo Stage

* ogni Stage può avere più istanze diverse di Scene

* Di fatto, è un container di Node(s)
* [https://openjfx.io/javadoc/15/javafx.graphics/javafx/scene/Scene.html](https://openjfx.io/javadoc/15/javafx.graphics/javafx/scene/Scene.html)




---


### Application



* `Application`: entry point di un'applicazione JavaFX application
* Consente di definire metodi hook sul ciclo di vita dell'applicazione (`init`, `start`, `stop`, ...)
* [https://openjfx.io/javadoc/15/javafx.graphics/javafx/application/Application.html](https://openjfx.io/javadoc/15/javafx.graphics/javafx/application/Application.html)



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
2. Istanziazione di `App` (la classe specificata che estende `Application`) 
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
* Sottoclassi di `Node`: `SwingNode`, `Canvas`, `Parent`
* Sottoclassi di `Parent`: 
  * `Group` (gestisce un insieme di figli; ogni trasformazione/effetto è applicata su ogni figlio)
  * `Region` (classe base per tutti i controlli UI e i layout)
* [https://openjfx.io/javadoc/15/javafx.graphics/javafx/scene/Node.html](https://openjfx.io/javadoc/15/javafx.graphics/javafx/scene/Node.html)




---

### Sommario


![](imgs/javafx-app.png)



---

### Struttura di un'applicazione JavaFX-based


![](imgs/javafx-app-structure.png)

---

### Linee guida

- Si faccia riferimento al repository di esempio: 
[https://github.com/APICe-at-DISI/sample-javafx-project](https://github.com/APICe-at-DISI/sample-javafx-project)


0. Build Gradle
```kotlin
val javaFXModules = listOf("base", "controls", "fxml", "swing", "graphics" )
val supportedPlatforms = listOf("linux", "mac", "win") // All required for OOP
val javaFxVersion = 17
dependencies {
  for (platform in supportedPlatforms) {
    for (module in javaFXModules) {
      implementation("org.openjfx:javafx-$module:$javaFxVersion:$platform")
} } }
```
1. La classe principale di un'applicazione JavaFX deve estendere la classe `javafx.application.Application`
2. Una classe definisce il `main()` dell'applicazione Java, che deve chiamare `Application.launch()`
3. Il metodo `void start(Stage primaryStage)` è, di fatto, l'entry point dell'applicazione JavaFX (lo stage primario è creato dalla piattaforma)
4. Sullo stage is imposta la scena (`setScene()`)

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



* Per **binding** si intende il meccanismo che consente di collegare due proprietà fra loro, in modo unidirezionale o bidirezionale
* Una `Property<T>` è un `ObservableValue<T>` che può essere collegato/scollegato ad altri osservabili o proprietà attraverso

* `bind(ObservableValue<? extends T> observable)`
* `bindBidirectional(Property<T> other)`
* `unbind()`
* `unbindBidirectional(Property<T> other)`



```java
final TextField input = new TextField();
final Label mirror = new Label();
// connette la label con il valore del textfield
mirror.textProperty()
    .bindBidirectional(input.textProperty());
```



---

### Layouts (1/3)

#### Group



* Non impone nessun posizionamento per i componenti figli
* Da utilizzare per posizionare i componenti figli in posizioni fisse



#### Region



* Tutte le sue specializzazioni forniscono diversi layout general purpose
* Sono simili a quelli offerti da Swing



#### Control



* Costituisce l'insieme dei layout personalizzabili
* Ciascun layout di questo tipo fornisce specifiche API per l'aggiunta dei componenti figli


[https://openjfx.io/javadoc/13/javafx.graphics/javafx/scene/layout/package-summary.html](https://openjfx.io/javadoc/13/javafx.graphics/javafx/scene/layout/package-summary.html)


---

### Layouts (2/3)


![](imgs/layouts.png)


#### Aggiungere componenti ad un layout



* Il metodo `ObservableList<Node> getChildren()` restituisce la lista di nodi figli di un qualunque nodo/layout
* Alla lista possono essere aggiunti (`boolean add(Node e)`) e gestiti i componenti figli




---

### Layouts (3/3)



\centering
![](imgs/javafx-layouts.drawio.png)




---

### Eventi


* Possono essere generati in relazione nodi e alle scene

* Fanno riferimento alla classe `javafx.event.Event`

* Come in swing, si generano in funzione di azioni dell'utente sulla GUI
* Possono essere gestiti attraverso *event handlers* (devono implementare l'interfaccia `EventHandler`)
* Ogni nodo può registrare uno o più event handlers

* In generale, attraverso i metodi `setOn...`()
* Ogni event handler deve implementare il metodo `void handle(ActionEvent e)`



#### Es. Gestione del click su un Button Node


```java
btn.setOnMouseClicked(event -> {
    lbl.setText("Hello, JavaFX World!");
});
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



* Similarmente a Swing, JavaFX
 ha un singolo thread che gestisce il processing degli eventi: **JavaFX Application Thread** (JFXAT)
* Tutte le modifiche allo *scene graph* devono essere effettuate su JFXAT
* Nota: è opportuno conoscere quali metodi hook dell'`Application` sono eseguiti (ad es. `start`) oppure no (ad es. `init`) su JFXAT
* **Platform.runLater(Runnable)**
 accoda il runnable nella coda degli eventi del JFXAT





\section{FXML}

---

### Separazioni di ruoli e contenuti


* In JavaFX è possibile separare il design della GUI dal codice sorgente che la riguarda
* Il design della GUI può essere descritto attraverso un linguaggio di markup denominato FXML


![](imgs/soc.png)



---

### FXML

*sep20pt
* Linguaggio di markup basato su XML
* Descrive la struttura della GUI

* Tutti i componenti della GUI sono specificati mediante tag specifici
* Le proprietà sono specificate come attributi su ciascun tag, nella forma chiave-valore

* Ogni file FXML (con estensione `.fxml`) deve essere un file XML valido

* Deve iniziare con il tag: `<?xml version="1.0" encoding="UTF-8"?>`




---

### Esempio di GUI in FXML

```java
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox xmlns="http://javafx.com/javafx" 
      xmlns:fx="http://javafx.com/fxml">
  <children>
    <Button fx:id="btn"
    	alignment="CENTER"
    	text="Say Hello!"
    	textAlignment="CENTER" />

    <Label fx:id="lbl"
    	alignment="CENTER_LEFT"
    	text="Label Text Here!"
    	textAlignment="LEFT" />
  </children>
</VBox>
```


---

### Esempio di GUI in FXML -- Note

\begin{enumerate}*sep15pt
* Attraverso il tag `<?import ... ?>` è possibile specificare i package in cui recuperare le classi dei componenti d'interesse

* E' equivalente all'`import` di Java

* Il container principale (unico per il singolo file) \underline{deve} specificare gli attributi `xmlns` e `xmlns:fx`

* \begin{verbatim}xmlns="http://javafx.com/javafx"\end{verbatim}
* \begin{verbatim}xmlns:fx="http://javafx.com/fxml"\end{verbatim}

* Ogni container deve specificare i nodi figli all'interno dei tag `$<$children$>$` e `$<$/children$>$`
* Ogni nodo deve definire il proprio ID mediante l'attributo `fx:id`

* Es. `$<$TextField fx:id="textField1"/$>$`

\end{enumerate}


---

### Collegare il design della GUI al codice Java


* La GUI descritta nel file FXML deve essere collegata alla scena agganciata allo stage dell'applicazione
* Si può utilizzare il componente `javafx.fxml.FXMLLoader`

* Il metodo statico `load(URL location)`

* Nota: occorre dichiarare il modulo `javafx.fxml` (si veda ad es. la build Gradle più avanti)

#### FXMLLoader (esempio)



* Si suppone che nel progetto sia presente il file `main.fxml` contenente una descrizione valida per la GUI da caricare

```java
Parent root = FXMLLoader.load(
  ClassLoader.getSystemResource("layouts/main.fxml"));
```



---

### FXMLLoader (esempio completo)

```java
public class Example3 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
	    Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/main.fxml"));

		Scene scene = new Scene(root, 500, 250);

		stage.setTitle("JavaFX - Example 3");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
```


---

### Lookup dei componenti della GUI


* Il riferimento ai componenti (nodi) inseriti nella GUI definita nel file FXML può essere recuperato tramite la scena a cui la GUI è stata collegata

* Metodo `Node lookup(String id)`


#### Node Lookup (esempio)


```java
Label lbl = (Label) scene.lookup("#lbl");

Button btn = (Button) scene.lookup("#btn");
btn.setOnMouseClicked(handler -> {
	lbl.setText("Hello, FXML!");
});
```

* **Attenzione**: il metodo `lookup` richiede come parametro l'id specificato per il componente (attributo `fx:id` nel file FXML) preceduto dal simbolo \#



---

### GUI Controller e Node Injection

*sep20pt
* Per una corretta separazione dei contenuti (e una buona implementazione del pattern MVC in JavaFX) è opportuno specificare un oggetto *controller* per ciascuna GUI

* Il parent component della GUI deve definire l'attributo `fx:controller` con valore riferito al nome pienamente qualificato della classe che fungerà da controller

* Mediante l'annotazione `@FXML` è possibile recuperare:

* I riferimenti ai vari nodi
	\iz{
	* senza utilizzare esplicitamente il meccanismo di lookup---usando la corrispondenza tra l'ID del nodo nel file FXML e il nome della variabile d'istanza annotata nella classe controller
	}
* Associare gli event handler ai vari eventi dei componenti




---

### Esempio Completo (1/3) -- Application

```java
public class CompleteExample extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		VBox root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/main.fxml"));

		Scene scene = new Scene(root, 500, 250);

		stage.setTitle("JavaFX - Complete Example");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
```


---

### Esempio Completo (2/3) -- GUI (FXML file)

```java
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox
    xmlns="http://javafx.com/javafx"
    xmlns:fx="http://javafx.com/fxml"
	fx:controller="it.unibo.oop.lab.javafx.UIController">
  <children>
    <Button fx:id="btn"
    	alignment="CENTER"
    	text="Say Hello!"
    	onMouseClicked="#btnOnClickHandler" />

    <Label fx:id="lbl"
    	alignment="CENTER_LEFT"
    	text="Label Text Here!" />
  </children>
</VBox>
```


---

### Esempio Completo (3/3) -- GUI Controller

```java
public class UIController {

	@FXML
	private Label lbl;

	@FXML
	private Button btn;

	@FXML
	public void btnOnClickHandler() {
		lbl.setText("Hello, World!");
	}
}
```


\section{Integrazione JavaFX e Swing}

---

### Integrare JavaFX e Swing


* L'integrazione può avvenire nelle due direzioni
	\iz{
	* Si possono includere elementi Swing in applicazioni JavaFX attraverso `SwingNode`
	* Si possono includere elementi JavaFX in applicazioni Swing attraverso `JFXPanel`
	* Nota: `SwingNode` e `JFXPanel` si trovano nel modulo `javafx.swing`
	}
%* In Java, un'applicazione può contenere sia GUI programmate in Swing, sia altre programmate in JavaFX
%
%* La Main UI deve essere in Swing
%* Si integrano Scene di JavaFX in JFrame avvalendosi di componenti che sono istanze di `JFXPanel`, eseguite nel thread specifico di JavaFX
%
* Va prestata particolare attenzione a dove viene eseguito il codice che gestisce la GUI

* `javafx.application.Platform.runLater()`, per eseguire codice nel thread dedicato a JavaFX
* `javax.swing.SwingUtilities.invokeLater()`, per eseguire codice nel thread dedicato a Swing




---

### Usare JavaFX in applicazioni Swing: esempio


```java
public static void main(final String[] args){
  initMainJFrame(new JFrame("JFrame GUI"));
}
```

```java
private static void initMainJFrame(final JFrame frame) {
  final JButton button = new JButton();
  button.setText("Launch JavaFX Scene");
  button.addActionListener(event -> {
    final JFXPanel jfxPanel = new JFXPanel();
    Platform.runLater(() -> {
      jfxPanel.setScene(new Scene(initJavaFXSceneUI(), 300, 300));
      SwingUtilities.invokeLater(() -> {
        final JFrame frameWithJavaFX = new JFrame("JFrame with JavaFX embedded!");
        frameWithJavaFX.add(jfxPanel);
        frameWithJavaFX.pack();
        frameWithJavaFX.setVisible(true);
  }); }); });

  final JPanel panel = new JPanel();
  panel.setLayout(new FlowLayout());
  panel.add(button);

  frame.setContentPane(panel);
  frame.setSize(300, 300);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
}
```

```java
private static Parent initJavaFXSceneUI() {
  final Label lbl = new Label();
  lbl.setText("Hello, JavaFX World!");

  final Button btn = new Button();
  btn.setText("Say Hello");
  btn.setOnMouseClicked(event -> {
    lbl.setText("Hello from Button!");
  });

  final VBox root = new VBox();
  root.getChildren().add(lbl);
  root.getChildren().add(btn);

  return root;
}
```



---

### Usare Swing in applicazioni JavaFX


```java
public final class JavaFXAppWithSwing extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        final SwingNode msg = new SwingNode();
        SwingUtilities.invokeLater(() ->
            msg.setContent(new JLabel("Hello by Swing JLabel")));
        HBox pane = new HBox();
        pane.getChildren().add(msg);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
    
    // ...
}
```



\section{Utilizzo di JavaFX con Eclipse e Gradle}

%---
## JavaFX con JDK 8

%
%---

### JavaFX in Eclipse (JDK 8)

%*sep20pt
%* La libreria JavaFX è presente unicamente nel JDK 8
%
%* Distribuita attraverso il file `jfxrt.jar` presente nella directory `/lib/ext` della propria installazione del JDK
%
%* Tutti le librerire *esterne* \underline{non} sono automaticamente accessibili da tutti i progetti aperti nell'IDE Eclipse
%
%* In realtà dipende dalla versione di Eclipse...
%
%* Deve essere definita una regola d'accesso per JavaFX in relazione allo specifico progetto Java aperto in Eclipse
%
%
%
%---

### Configurazione del progetto (1/2)

%
%* (tasto DX sul progetto) $>$ Properties $>$ Java Build Path
%* (tab Libraries) $>$ Click sul JRE System Library $>$ Selezionare \textit{Access rules} $>$ Click su Edit
%
%
%![](imgs/conf01.png)
%
%
%
%---

### Configurazione del progetto (2/2)

%
%* Click su Add $>$ Aggiungere una regola con:
%
%* Resolution: **Accessible**
%* Rule pattern: **javafx/****
%
%* OK $>$ OK $>$ Apply and Close
%
%
%![](imgs/conf02.png)
%
%

%---
## Esecuzione di applicazioni JavaFX


---

### JavaFX in Eclipse via Gradle ed esportazione runnable JAR


* Da Java 11, JavaFX deve essere importato nel progetto come **libreria esterna**
* Due alternative:
\begin{enumerate}
* Si aggiungono tutti i JAR della libreria direttamente nel progetto

* Scaricabili da [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/)

* Si specificano le dipendenze via **Gradle**
\end{enumerate}
* Oggigiorno, è preferibile optare per la seconda alternativa
	\iz{
	* NOTA: l'export di un Runnable JAR con Eclipse non consente di impacchettare librerie esterne (come quelle configurate quando si importa un progetto Gradle)
	* Per creare il runnable JAR comprendente tutte le dipendenze dell'applicazione, si usi il plugin Gradle **shadow** e il relativo task **shadowJar**
	}
* Si faccia riferimento a 
[https://github.com/APICe-at-DISI/sample-javafx-project](https://github.com/APICe-at-DISI/sample-javafx-project)





---

### \texttt{build.gradle.kts
 (completo -- sintassi Kotlin)}
```java
plugins {
    java // add support for Java
    // Apply the application plugin to add support for building a CLI application
    // You can run your app via task "run": ./gradlew run
    application
    // Adds task 'shadowJar' to export a runnable jar.
    // The runnable jar will be found in build/libs/projectname-all.jar
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

repositories { mavenCentral() }

val javaFXModules = listOf( "base", "controls", "fxml", "swing", "graphics")
val supportedPlatforms = listOf("linux", "mac", "win") // All required for OOP
val javaFxVersion = 15

dependencies {
    for (platform in supportedPlatforms) {
        for (module in javaFXModules) {
            implementation("org.openjfx:javafx-$module:$javaFxVersion:$platform")
        }
    }
    // JUnit API and testing engine
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
}

tasks.withType<Test> { useJUnitPlatform() } // Enables JUnit 5 Jupiter module 

application { mainClassName = "it.unibo.samplejavafx.App" }
```
%java {
%    sourceCompatibility = JavaVersion.VERSION_11
%    targetCompatibility = JavaVersion.VERSION_11
%}



%---

### \texttt{build.gradle
 (completo -- sintassi Groovy)}
%```java
%plugins {
%  id 'application'
%  id 'org.openjfx.javafxplugin' version '0.0.9'
%}
%
%repositories {
%  mavenCentral()
%}
%
%dependencies {
%  /* for cross-platform jar: */
%  runtimeOnly "org.openjfx:javafx-graphics:$javafx.version:win"
%  runtimeOnly "org.openjfx:javafx-graphics:$javafx.version:linux"
%  runtimeOnly "org.openjfx:javafx-graphics:$javafx.version:mac"
%}
%
%javafx {
%  version = "14"
%  modules = [ 'javafx.controls', 'javafx.fxml' ]
%}
%
%mainClassName = 'application.Main'
%
%jar {
%  manifest {
%    attributes 'Main-Class': 'application.Main'
%  }
%
%  from {
%    configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it) }
%  }
%}
%```
%


\section{Scene Builder}

---

### Scene Builder 2.0


* Strumento per la creazione di GUI JavaFX-based in modalità drag-n-drop (GUI Builder)
* Consente di esportare il file FXML relativo alla GUI disegnata
* Distribuito come strumento esterno al JDK, non integrato (direttamente) in Eclipse
* [https://gluonhq.com/products/scene-builder/](https://gluonhq.com/products/scene-builder/)



---

### Scene Builder 2.0


![](imgs/scenebuilder.png)

