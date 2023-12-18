
+++

title = "Progettazione e Sviluppo del Software"
description = "Progettazione e Sviluppo del Software, Tecnologie dei Sistemi Informatici"
outputs = ["Reveal"]
aliases = ["/uml-crash/"]

+++

# UML crash course 

<!-- {{% import path="front-page.md" %}} -->

{{% import path="cover.md" %}}

---

## Outline


  
### Goal della lezione

* Riassunto dei concetti fondamentali di UML

  
### Argomenti

* UML Class Diagrams
* Mermaid Syntax
  
---

## Introduzione ai Diagrammi di Classe UML

- Diagramma di Classe UML: Una rappresentazione visiva delle classi, dei loro attributi, metodi e relazioni.
- Usi Principali: Design orientato agli oggetti e comprensione dell'architettura del sistema.
- Componenti Base:
  - Classi: Rappresentano entità con proprietà comuni.
  - Relazioni: Mostrano come le classi interagiscono tra loro.

[![](https://mermaid.ink/img/pako:eNpFjjsOwjAQRK-y2hIlEr_KogucgNbNyt6AJX8ifwoIuQt34WI4kgXdzOiNZmZUQTMKVJZSOhu6RXLSAwyr3-7g9Or7ZvYg4BJZm0zRcP68_9wBNj_sWLEhuCkk8zTBM3boODoyus7Ma0divrNjiaJKzSMVmyVKv1SUSg7Xh1coRrKJOyyTpsztWUuXL6ibPVA?type=png)](https://mermaid.live/edit#pako:eNpFjjsOwjAQRK-y2hIlEr_KogucgNbNyt6AJX8ifwoIuQt34WI4kgXdzOiNZmZUQTMKVJZSOhu6RXLSAwyr3-7g9Or7ZvYg4BJZm0zRcP68_9wBNj_sWLEhuCkk8zTBM3boODoyus7Ma0divrNjiaJKzSMVmyVKv1SUSg7Xh1coRrKJOyyTpsztWUuXL6ibPVA)

---
## Strumenti principali
- Mermaid: https://mermaid-js.github.io/mermaid/#/
  - Permette di creare diagrammi di classe, ma anche di sequenza, di flusso, ecc.
- star
---

## Struttura Base di una Classe

- Anatomia di una Classe UML:
  - **Nome della Classe**: Tipicamente maiuscolo, rappresenta l'entità.
  - **Attributi**: Variabili o proprietà della classe.
  - **Metodi**: Funzioni o operazioni che la classe può eseguire.
- Indicatori di Visibilità:
  - `+` per pubblico, `-` per privato, `#` per protetto.
- Esempio:

[![](https://mermaid.ink/img/pako:eNpdzzsKwzAMBuCrCHVpaXoBz107BTp5EbaSGmw52EqghNy9SZqhdNP_IfSY0WXPaNBFqvUeqC-UrADsGZ4cXI4Z5o0Abq2WID0kKo7-aB0TY_7iKYgCiRzxStMU6JE1Fz5fDqsD9xJ-ccEGE5dEwa8H7Sst6osTWzRr6bmjMapFK1srjZrbtzg0WkZucBw8KR8voOkoVl4-fGRKiQ?type=png)](https://mermaid.live/edit#pako:eNpdzzsKwzAMBuCrCHVpaXoBz107BTp5EbaSGmw52EqghNy9SZqhdNP_IfSY0WXPaNBFqvUeqC-UrADsGZ4cXI4Z5o0Abq2WID0kKo7-aB0TY_7iKYgCiRzxStMU6JE1Fz5fDqsD9xJ-ccEGE5dEwa8H7Sst6osTWzRr6bmjMapFK1srjZrbtzg0WkZucBw8KR8voOkoVl4-fGRKiQ)

---

## Relazioni tra Classi - Associazione

- **Associazione**: Rappresenta una gamma di relazioni tra classi (ad es., uno-a-uno, uno-a-molti).
- **Molteplicità**: Indica quante istanze di una classe possono essere associate con un'istanza di un'altra classe.
- Esempio: Uno `Studente` può iscriversi a molti `Corsi` e un `Corso` può avere molti `Studenti`.

[![](https://mermaid.ink/img/pako:eNotjTsOwjAQBa-yeiVKLuAWbpB2m5W9AUv-IHtdQJS7Y6R0U7x5c8DXoHDwSXp_RHk2yVyINhtBiykxbgxa1wvutfVKjmL3LX5jLRELsrYsMcyb4-8y7KVZGW5i0F1GMgaXc05lWN0-xcNZG7pgvIOYXmG4XVLX8wdcaTHw?type=png)](https://mermaid.live/edit#pako:eNotjTsOwjAQBa-yeiVKLuAWbpB2m5W9AUv-IHtdQJS7Y6R0U7x5c8DXoHDwSXp_RHk2yVyINhtBiykxbgxa1wvutfVKjmL3LX5jLRELsrYsMcyb4-8y7KVZGW5i0F1GMgaXc05lWN0-xcNZG7pgvIOYXmG4XVLX8wdcaTHw)

---
## Relazioni tra Classi - Aggregazione

- **Aggregazione**: Una forma speciale di associazione che rappresenta una relazione "intero-parte".
- **Caratteristiche**:
  - La 'parte' può esistere indipendentemente dall' 'intero'.
  - Rappresenta una relazione di 'possesso'.
- Esempio: Un `Dipartimento` ha molti `Professori`, ma i `Professori` possono esistere indipendentemente.


[![](https://mermaid.ink/img/pako:eNotjTEKAyEQRa8iU-9ewHoPEEhrM-g3EdRZxrEIy949BtK94j3eRVESyFOsPMZR-KXcQnfuKCerlYZu4mTf3UMlYwxR0EYN2rik1V0_OZC90RDIL0zIPKsFCv1eKk-T56dH8qYTG80zseF_Ip-5DtxfWggu3A?type=png)](https://mermaid.live/edit#pako:eNotjTEKAyEQRa8iU-9ewHoPEEhrM-g3EdRZxrEIy949BtK94j3eRVESyFOsPMZR-KXcQnfuKCerlYZu4mTf3UMlYwxR0EYN2rik1V0_OZC90RDIL0zIPKsFCv1eKk-T56dH8qYTG80zseF_Ip-5DtxfWggu3A)

---
## Relazioni tra Classi - Composizione

- **Composizione**: Una forma più restrittiva di aggregazione.
- **Differenze Chiave**:
  - La 'parte' non può esistere indipendentemente dall' 'intero'.
  - Indica una forte dipendenza nel ciclo di vita.
- Esempio: Un `Automobile` è composta da un `Motore`. Se l'`Automobile` viene distrutta, lo è anche il `Motore`.

[![](https://mermaid.ink/img/pako:eNotjTEOwjAQBL9ibYmSD7hDoqWiveawL2DJ9iH7XKAof4-R6KaY2d0RNAo8Qubeb4lfjQtV567DtOgzZXGXdXV3NW3isKBIK5ziTPafR7C3FCH4iVE2HtkIVI-p8tx4fGuAtzZkwfhENvmfwG-cuxwnGnwsJg?type=png)](https://mermaid.live/edit#pako:eNotjTEOwjAQBL9ibYmSD7hDoqWiveawL2DJ9iH7XKAof4-R6KaY2d0RNAo8Qubeb4lfjQtV567DtOgzZXGXdXV3NW3isKBIK5ziTPafR7C3FCH4iVE2HtkIVI-p8tx4fGuAtzZkwfhENvmfwG-cuxwnGnwsJg)

---
## Ereditarietà nei Diagrammi di Classe

- **Ereditarietà**: Rappresenta una relazione genitore-figlio tra classi, dove il figlio eredita attributi e metodi del genitore.
- **Vantaggi**:
  - Riutilizzo del codice.
  - Organizzazione gerarchica.
- Esempio: Un `AutomobileElettrica` eredita da `Automobile`.

[![](https://mermaid.ink/img/pako:eNpNjTEOwyAQBL-CtrY_gNJESl6QluYCZwfpgAiOIrL99xAphbsdaWd3gy-BYeGFWrtFWisll425di2pPKOwuezzfOK7sGqNnjAhcU0Uw_C3n-SgL07sYEcMvFAXdXD5GFUaA49P9rBaO0_o70DK_0fYhaTx8QXrFjHM?type=png)](https://mermaid.live/edit#pako:eNpNjTEOwyAQBL-CtrY_gNJESl6QluYCZwfpgAiOIrL99xAphbsdaWd3gy-BYeGFWrtFWisll425di2pPKOwuezzfOK7sGqNnjAhcU0Uw_C3n-SgL07sYEcMvFAXdXD5GFUaA49P9rBaO0_o70DK_0fYhaTx8QXrFjHM)

---

## Interfacce e Implementazioni

- **Interfaccia**: Un contratto che le classi possono implementare. Definisce i metodi ma non la loro implementazione.
- **Implementazione**: Una classe che si impegna ad implementare tutti i metodi dichiarati da un'interfaccia.
- Esempio: `InterfacciaVeicolo` implementata da `Automobile`.

[![](https://mermaid.ink/img/pako:eNptTjsKwzAMvYrQHHIAYwKFLp0Lnbyottwa_Cn-DCHN3WuHjJ0kvY_e21AnwyhQeyrl6uiVKagIcNxwi5WzJa0dPdjp5BNsgwWQ0p0cL8uAdhXH-OOQ33mGS6sppKfzjBMGzoGc6bHHN4X1zYEVir4attR8Vaji3qXUffc1ahQ1N56wfQxVPouisOQL7z-eT0SP?type=png)](https://mermaid.live/edit#pako:eNptTjsKwzAMvYrQHHIAYwKFLp0Lnbyottwa_Cn-DCHN3WuHjJ0kvY_e21AnwyhQeyrl6uiVKagIcNxwi5WzJa0dPdjp5BNsgwWQ0p0cL8uAdhXH-OOQ33mGS6sppKfzjBMGzoGc6bHHN4X1zYEVir4attR8Vaji3qXUffc1ahQ1N56wfQxVPouisOQL7z-eT0SP)

---

## Classi e Metodi Astratti

- **Classe Astratta**: Una classe che non può essere istanziata da sola ed è destinata ad essere subclassificata.
- **Metodi Astratti**: Metodi dichiarati in una classe astratta che devono essere implementati dalle sottoclassi.
- **Utilizzo**: Utile nel definire un modello base per altre classi.
- Esempio: `Forma` con un metodo astratto `disegna()`.

[![](https://mermaid.ink/img/pako:eNotjkkKwzAMRa8itOqQXMBk19ILdOuNsJXE4KF4WJTUd6-dZPPRfzwJbaiCZhSoLKX0NLREctID7B1eITqCrQOAuzaJF0-X662D2uMQpt84woOjWk3AAR03aHS7um9KzCs7lijaqHmmYrNE6WtTqeTw_nqFYiabeMDy0ZT5fOSk9Q-wCzcs?type=png)](https://mermaid.live/edit#pako:eNotjkkKwzAMRa8itOqQXMBk19ILdOuNsJXE4KF4WJTUd6-dZPPRfzwJbaiCZhSoLKX0NLREctID7B1eITqCrQOAuzaJF0-X662D2uMQpt84woOjWk3AAR03aHS7um9KzCs7lijaqHmmYrNE6WtTqeTw_nqFYiabeMDy0ZT5fOSk9Q-wCzcs)

---

## Relazioni di Dipendenza

- **Dipendenza**: Una relazione in cui un cambiamento in una classe può influenzare un'altra classe.
- **Casi d'Uso**: Spesso usati in scenari come parametri di metodi o variabili locali.
- **Notazione**: Rappresentata da una freccia tratteggiata.
- Esempio: Una classe `ProcessorePagamenti` che utilizza un oggetto `CartaDiCredito`.
[![](https://mermaid.ink/img/pako:eNotjjsKwzAQBa8itjY-gIo09gEMadU8pLWzoE-QVkVsfHc74O4xDMM7yJfAZMlHtDYLtorksjFLLZ5bK5UXbEicVcw4vsyEqphlqhxEi7Gmq0TZd9BAiWuChLt2_BOO9MOJHdl7Bl7Rozpy-bxVdC3vX_ZkV8TGA_VvgPJz4KHnBQh4NvM?type=png)](https://mermaid.live/edit#pako:eNotjjsKwzAQBa8itjY-gIo09gEMadU8pLWzoE-QVkVsfHc74O4xDMM7yJfAZMlHtDYLtorksjFLLZ5bK5UXbEicVcw4vsyEqphlqhxEi7Gmq0TZd9BAiWuChLt2_BOO9MOJHdl7Bl7Rozpy-bxVdC3vX_ZkV8TGA_VvgPJz4KHnBQh4NvM)

---

## Molteplicità nelle Relazioni

- **Molteplicità**: Definisce quante istanze di una classe possono essere collegate a una singola istanza di un'altra classe.
- **Notazione**: Espressa come numeri (ad es., 1, 0..*, 1..n).

Esempio**: In un sistema di shopping online, un `Ordine` può contenere più `Prodotti`.

[![](https://mermaid.ink/img/pako:eNotzT0LwjAQBuC_Et5R2qJrZncF11uO5KqBJCfpZZDS_24Et2d4P3YEjQKPkHnbromfjQtV524tpiqOcCG4eR44L8tp-N40qpk674JWS1IFE4q0wimOof3XJthLihD8YJSVezYC1WNEuZs-PjXAW-syob8jm_yv4VfOmxxfeT4x_w?type=png)](https://mermaid.live/edit#pako:eNotzT0LwjAQBuC_Et5R2qJrZncF11uO5KqBJCfpZZDS_24Et2d4P3YEjQKPkHnbromfjQtV524tpiqOcCG4eR44L8tp-N40qpk674JWS1IFE4q0wimOof3XJthLihD8YJSVezYC1WNEuZs-PjXAW-syob8jm_yv4VfOmxxfeT4x_w)

---

## Associazione vs Aggregazione vs Composizione

- **Analisi Comparativa**:
  - **Associazione**: Collegamento generale tra due classi.
  - **Aggregazione**: Relazione "intero-parte" con cicli di vita indipendenti.
  - **Composizione**: Relazione "intero-parte" più forte con cicli di vita dipendenti.
- **Scegliere la Relazione Giusta**:
  - Basato sul grado di dipendenza e ciclo di vita.
- **Esempi**: `Persona` associata con `Indirizzo`, `Squadra` aggrega `Giocatore`, `Casa` composta da `Stanza`.

[![](https://mermaid.ink/img/pako:eNpFzr0KwjAUhuFbCWeU9gaySQVxE7pm-UhOa6DJ0fwMtvTeTUVwe4dneDey4pg02QU5XzzmhGCiUndOWSJU36tbdD75dRWl1TlnsR6rl8gHG18VLkFJc1cvFkUSH26eE89_NyBDnRoaC-KKJgYJT8n-K6ijwCnAu3ayHd5QeXBgQ7ql4wl1KYZM3BtFLTK-oyVdUuWO6tOh8O-d9IQl8_4BhHpKTw?type=png)](https://mermaid.live/edit#pako:eNpFzr0KwjAUhuFbCWeU9gaySQVxE7pm-UhOa6DJ0fwMtvTeTUVwe4dneDey4pg02QU5XzzmhGCiUndOWSJU36tbdD75dRWl1TlnsR6rl8gHG18VLkFJc1cvFkUSH26eE89_NyBDnRoaC-KKJgYJT8n-K6ijwCnAu3ayHd5QeXBgQ7ql4wl1KYZM3BtFLTK-oyVdUuWO6tOh8O-d9IQl8_4BhHpKTw)

---

## Creazione di un Esempio Completo di Diagramma di Classe

- **Costruzione Passo Dopo Passo**:
  - Identificare classi e i loro attributi/metodi.
  - Determinare relazioni e la loro molteplicità.
  - Applicare le notazioni appropriate.
- **Integrazione di Diversi Elementi**: Mix di associazioni, ereditarietà e composizioni.
- **Esempio**: Un diagramma semplificato di un sistema di biblioteca.

[![](https://mermaid.ink/img/pako:eNpdj8sKwjAQRX8lzFLaHwiuxKWC4DabaTKtA3mUdLKQ2n83AQUrs7lzOXceK9jkCDRYj8tyZpwyBhOVOvHgOQlZVMdX3__0tzJUafGPOlTowkNOzb9SqEp9LaXVnCk6UhybWoSlcq12M9JuUeYW5DAzTQgdBMoB2dVj15YzIA8KZEBX6WjE4sWAiVtFsUi6P6MFLblQB2V2KPR5D_SIfqHtDYTOVmk?type=png)](https://mermaid.live/edit#pako:eNpdj8sKwjAQRX8lzFLaHwiuxKWC4DabaTKtA3mUdLKQ2n83AQUrs7lzOXceK9jkCDRYj8tyZpwyBhOVOvHgOQlZVMdX3__0tzJUafGPOlTowkNOzb9SqEp9LaXVnCk6UhybWoSlcq12M9JuUeYW5DAzTQgdBMoB2dVj15YzIA8KZEBX6WjE4sWAiVtFsUi6P6MFLblQB2V2KPR5D_SIfqHtDYTOVmk)

---

## Errori Comuni nei Diagrammi di Classe

- **Complicare Troppo i Diagrammi**: Includere troppi dettagli che rendono il diagramma confuso.
- **Abuso delle Relazioni**: Uso errato di associazione, aggregazione o composizione.
- **Tralasciare Molteplicità e Vincoli**: Non definire chiaramente le relazioni tra le classi.
- **Ignorare la Logica del Mondo Reale**: Non riflettere le relazioni reali nel sistema modellato.
