 
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/objects/"]

+++

# Oggetti e classi

{{% import path="cover.md" %}}


## Outline
  
### Goal della lezione
*  Illustrare i concetti base del paradigma object-oriented
*  Mostrare un primo semplice programma Java
*  Fornire una panoramica di alcuni meccanismi Java
  
### Argomenti
*  Oggetti e riferimenti
*  Tipi primitivi
*  Classi, metodi e campi
*  Accenno a package e librerie
*  Stampe a video
*  Primo semplice programma Java
  
---

# Elementi base dei tipi di Java

---

> Everything is an object

### Riferimenti ad oggetti
*  Nessun meccanismo per accedere ai dati per valore o puntatore!
*  Le variabili conterranno dei riferimenti agli oggetti veri e propri, sono quindi dei nomi "locali" utilizzabili per denotare l'oggetto
  
```java
// Creo un oggetto String, e lo assegno al nome s
// questo oggetto stringa rappresenta la sequenza 
// vuota di caratteri
String s = new String();

// In generale si crea un oggetto con l'operatore <new>
// Accetta 0,1 o più argomenti, a seconda del tipo:
// valori primitivi (numeri), string literals, o oggetti
String s2 = new String("prova");
Point2D p = new Point2D(10.5,20.3);
Object o = new Object();
```

---


## Variabili, oggetti, e valori primitivi


  
### Concetti base



  *  Variabile: un contenitore con nome (come in C), usabile per denotare un oggetto
  *  Valore primitivo: p.e. un numero, anche assegnabile ad una variabile
  


  \sizedcode{\footnotesize}{code/references2.java}


---



## "(Almost) Everything is an object"


  
### Tipi primitivi: tipi speciali usati per valori atomici



  *  Assomigliano molto a quelli del C, ma hanno dimensioni fissate
  *  I \cil{boolean} possono valere \cil{true} o \cil{false}
  %*  Sono assegnabili a variabili, ma in questo caso lo sono "per valore"
  %*  Ognuno ha una corrispondente classe chiamata *__wrapper__*
  *  Altre classi di libreria (\cil{BigDecimal}, \cil{BigInteger}) gestiscono numeri di dimensione/precisione arbitraria
  


  ![](img/primitive.png)


---


## Una prima classificazione dei tipi


  ![](img/types0.pdf)


---


## Variabili e tipi


  \sizedcode{\footnotesize}{code/vars0.java}


---


## Costrutto \Cil{var}: "local variable type inference" (da Java 10)


  
### Costrutto \cil{var}



    *  usabile nelle variabili locali (a funzioni/metodi) per avere maggiore concisione
    *  il compilatore capisce (inferisce) il tipo della varibile dall'espressione assegnata
    *  non abusarne, e comunque noi non lo useremo molto all'inizio del corso
  


  \sizedcode{\footnotesize}{code/vars1.java}


---



## Oggetti e memoria


  
### Gestione della memoria -- entriamo nella JVM solo temporanemante



    *  tutti gli oggetti sono allocati nella memoria *__heap__*
    *  le variabili allocate nello stack, nei rispettivi record di attivazione
    *  le variabili di tipi primitivi contengono direttamente il valore
    *  le variabili che contengono oggetti in realtà hanno un riferimento verso lo heap
    *  nota: ancora non sappiamo cosa contiene un oggetto
  


  
### Situazione relativa al codice della slide precedente



    *  le variabili \cil{i}, \cil{d}, \cil{b}, \cil{other} contengono valori
    *  tutte le altre contengono un riferimento ad un oggetto, nello heap
    *  solo \cil{p} e \cil{q} "(si) riferiscono (al)lo stesso oggetto"
    *  \cil{on} contiene un riferimento speciale, \cil{null}
  




---


## Visibilità


  
### "Scope" delle variabili



    *  È simile a quello del C
    *  variabili dentro un blocco non sono visibili fuori
    *  differenza rispetto al C: variabili non inizializzate non sono utilizzabili!
  


  
### Tempo di vita degli oggetti



    *  finito lo scope di una variabile, l'oggetto continua a esistere
    *  verrà deallocato automaticamente dal sistema se non più usato{

	*  se, direttamente o indirettamente, nessuna variabile lo può raggiungere
	*  un componente della JVM, il *__garbage collector__*, è preposto a questo compito
	*  ne vedremo il funzionamento a breve..
    
}
  




---

\section[Costrutti OOP]{Principali costrutti dell'object-orientation}


## Costruire classi


  
### Premesse



    *  la *__classe__* è l'unità fondamentale di programmazione OO
    *  progettare e costruire classi correttamente sarà l'obbiettivo del corso
    *  incominciamo descrivendo la loro struttura generale
    *  solo nelle prossime lezioni daremo linee guida definitive
  


  
### Cos'è una classe



    *  è un template (stampino) per generare oggetti di una certa forma
    *  ne definisce tipo, struttura in memoria e comportamento
  


  
### Classe vs. oggetto



    *  classe: è una descrizione (parte di programma)
    *  oggetto: è una entità a tempo di esecuzione, è *__istanza__* di una classe
  


  


---



## Struttura di una classe


  
### Nome della classe


  è anche il nome del tipo
  

  
### Proprietà della classe


    *__Campi__* (o membri, o fields){

      *  descrivono la struttura/stato dell'oggetto in memoria
    
}
    *__Metodi__* della classe{

      *  descrivono i messaggi accettati e il comportamento corrispondente
    
}
    (altri elementi che vedremo..)
   



---


## Classi: un po' di codice


  \titledcode{Costruzione classi}{code/classes1.java}
  \titledcode{Uso}{code/classes2.java}


---


## Campi


  
### Elementi costitutivi dei campi



    *  i campi di una classe assomigliano ai membri di una struct del C
    *  ognuno è una sorta di variabile (nome + tipo)<br> (per i campi non è usabile il costrutto \cil{var})
    *  ve ne possono essere 0,1, molti
    *  lo stato di un oggetto è l'attuale valore associato ai campi
    *  potrebbero essere valori primitivi, o altri oggetti
  


  
### Valore di un campo



    *  impostabile al momento della sua dichiarazione
    *  se non inizializzato vale:
    {

      *  \cil{0} per i tipi numerici
      *  \cil{false} per i booleani
      *  \cil{null} per le classi
    
}
    *  accessibile da codice cliente con notazione *__obj.field__*
  


  

---
  

## Campi: Un semplice esempio (toy)


  \titledcode{Classe}{code/fields1.java}
  \titledcode{Uso}{code/fields2.java}


---


## Campi: l'esempio Point3D


  \titledcode{Classe}{code/fields_p3d_1.java}
  \titledcode{Uso}{code/fields_p3d_2.java}


---


## Metodi


  
### Elementi costitutivi dei metodi



    *  i metodi di una classe assomigliano a funzioni (del C)
    *  ognuno ha una *__intestazione__* (o signature) e un corpo{

     *  a sua volta l'intestazione ha il nome, tipo di ritorno, argomenti
    
}
    *  di metodi ve ne possono essere 0,1, molti
    *  definiscono il comportamento dell'oggetto
  


  
### Significato di un metodo



    *  codice cliente richiama un metodo con notazione *__obj.meth(args)__*
    *  ciò corrisponde a inviargli un messaggio
    *  \cil{obj} è chiamato il *__receiver__* del messaggio (o della invocazione)
    *  il comportamento conseguente è dato dall'esecuzione del corpo
    *  il corpo può leggere/scrivere il valore dei campi
  


  

---
  

## Metodi: Un esempio "giocattolo" (toy example)


  \titledcode{Classe}{code/methods1.java}
  \titledcode{Uso}{code/methods2.java}


---


## La variabile speciale \Cil{this}


  
### \cil{this}



    *  dentro ad un metodo si può accedere agli argomenti o ai campi
    *  per rendere meno ambigua la sintassi, Java fornisce una variabile speciale denotata con \cil{this}, che contiene il riferimento all'oggetto che sta gestendo il messaggio
    *  per motivi di leggibilità, è opportuno usarla sempre
  


  \sizedcode{\scriptsize}{code/methods1this.java}


---



## Metodi: altro esempio Point3D


  \sizedcode{\scriptsize}{code/methods_p3d_1.java}
  %\titledcode{Uso}{code/methods_p3d_2.java}


---


# Programmi Java

---



## Programmi Java


  
### Elementi costitutivi dei programmi Java



    *  librerie di classi del Java Development Kit
    *  librerie esterne (nostre o di altri)
    *  un insieme di classi che costituiscono l'applicazione
    *  almeno una di tali classi ha un metodo speciale \cil{main}
    *  un \cil{main} è il punto d'accesso di un programma
  


  
### Il main

Il \cil{main} deve avere la seguente dichiarazione:{

  *  \cil{public static void main(String[] args)\{..\}}
}
  tre concetti che spiegheremo in dettaglio nel prosieguo:

  *  \cil{public} indica il fatto che debba essere visibile "a tutti"
  *  \cil{static} indica che non è un metodo dell'oggetto, ma della classe
  *  \cil{String[]} indica il tipo "array di stringhe"
  




---


## Package e librerie Java: organizzazione


  
### Librerie di Java



    *  Documentazione auto-generata, consultabile offline, o online: <br> https://docs.oracle.com/en/java/javase/11/docs/api/ <br> (google search "`javadoc 11`")
    *  contano più di 4000 classi, raggruppate in 200+ *__package__* (e 50+ *__moduli__*)
  


  
### Package



    *  un package è un contenitore di classi con uno scopo comune, di alto livello
    *  tipicamente un package contiene qualche decina di classi
    *  i package sono organizzati ad albero, con notazione \cil{nome1.nome2.nome3}
    *  Package principali: \cil{java.lang}, \cil{java.util}, \cil{java.io}
  




---


## Package, moduli e librerie Java: moduli


  
### Moduli (Java 9+)



    *  un modulo definisce un frammento di codice "autonomo":{

    *  testabile, distribuibile, con chiara interfaccia e dipendenze da altri
    
}
    *  p.e., \cil{java.base}, \cil{java.desktop}, \cil{java.sql}, \cil{java.xml}
    *  librerie esterne compatibili con Java 9+ sono distribuite in uno o più moduli
    *  un modulo è costituito internamente da uno o più package
    *  p.e., \cil{java.base} contiene i package principali che useremo    
  


  
### Impatto sulla programmazione "base"



    *  il concetto di modulo *__non impatta__* i sorgenti, ma solo il "project management": per il momento non ce ne occuperemo perché il JDK fornisce "di default" accesso a tutti i moduli che ci servono (\cil{java.*})
    *  il concetto di package *__invece impatta__* i sorgenti: il nome completo di una classe dipende dal package in cui si trova 
  




---



## Package, moduli e librerie Java: uso


  
### Importare una classe di "libreria"



    *  per usare le classi di una libreria prima le si importa
    *  lo si fa con la clausola \cil{import}, da usare all'inizio del sorgente
    {

      *  importo la singola classe: \cil{import java.util.Date;}
      *  importo l'intero package: \cil{import java.util.*;}
      *  importazione di default: \cil{import java.lang.*;}
    
}
    *  senza importazioni, ogni classe andrebbe sempre qualificata indicandone anche il package completo: \cil{java.util.Date obj = new java.util.Date();}
    *  importare evita quindi solo di dover indicare ogni volta il package
  


  
### Classi (e funzionalità) "deprecate"



    *  dichiarate come "scadute", ossia preferibilmente "da non usare più" (legacy)
    *  noi le utilizzeremo per scopi didattici
    *  p.e. \cil{java.util.Date}
  




---


## Stampe su schermo


  
### La procedura di stampa \cil{System.out.println}



    *  \cil{System} è una classe nel package \cil{java.lang}
    *  \cil{out} è un suo campo statico, rappresenta lo standard output
    *  \cil{println} è un metodo che accetta una stringa e la stampa
    *  l'operatore \cil{+} concatena stringhe a valori
    %*  \cil{format} è un analogo metodo usabile in stile "\cil{printf}"
  


  \code{code/print.java}


---


## "Hello world" Java Program


  \titledcode{Hello.java}{exec/Hello.java}
  
### Compilazione ed esecuzione



    *  con un editor di testo si scrive la classe in un file \cil{Hello.java}
    *  si compila la classe col comando: \cil{javac Hello.java}
    *  se non ci sono errori, viene generato il *__bytecode__* \cil{Hello.class}
    *  si esegua il programma con: \cil{java Hello}
    *  la JVM cerca la classe \cil{Hello}, e ne esegue il \cil{main}
    
  




---


## Librerie, oggetti, e stampe


  \sizedcode{\scriptsize}{exec/PrintingObjects.java}


---


## Il caso delle classi Wrapper dei tipi primitivi


   
### Le classi Wrapper



      *  ce ne è una per tipo primitivo, nel package \cil{java.lang}{

         *  \cil{Integer}, \cil{Double}, \cil{Boolean},...
      
}
      *  hanno qualche metodo utile per fare conversioni
      *  poco usate per il momento
   


   \srcode{\ssmall}{3}{100}{\ecl/Wrappers.java}


---


## Una nuova classificazione dei tipi


  ![](img/types.pdf)


---


## Costruire e provare classi


  \sizedcode{\scriptsize}{exec/Point3D.java}


---


## Classi, e classi clienti


  \sizedcode{\tiny}{code/Point3D_a.java}
  \sizedcode{\tiny}{exec/UsePoint3D.java}
  \vspace{-10pt}


  *  si compilano separatamente, o con: \cil{javac *.java}
  *  si esegue a partire dalla classe col \cil{main}: \cil{java UsePoint3D}
  




---


## Preview del prossimo laboratorio


  
### Obbiettivi



    *  familiarizzare con la compilazione da linea di comando in Java
    *  fare qualche esercizio con la costruzione e uso di classi
  




---





\end{document}
