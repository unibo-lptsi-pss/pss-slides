
+++

title = "Laboratorio di Progettazione e Sviluppo del Software"
description = "Laboratorio di Progettazione e Sviluppo del Software, Ingegneria e Scienze Informatiche"
outputs = ["Reveal"]
aliases = ["/git-cheatsheet/"]

+++

# Git cheatsheet

{{% import path="cover.md" %}}

---

#### Inizializzazione e Configurazione

| Operazione | Comando |
| --- | --- |
| Inizializzazione della cartella corrente come repository | `git init` |
| Clonazione di un repository | `git clone <url>` |
| Configurazione globale del nome utente | `git config --global user.name "<Nome> <Cognome>"` |
| Configurazione globale dell'email | `git config --global user.email "<email>"` |
| Configurazione globale dell'editor | `git config --global core.editor <comando>` |
| Configurazione globale del nome del branch principale | `git config --global init.defaultBranch <nome>` |
| Configurazione locale del nome utente | `git config user.name "<Nome> <Cognome>"` |
| Configurazione locale dell'email | `git config user.email "<email>"` |

---

#### Osservazione

| Operazione | Comando |
| --- | --- |
| Osservazione dello stato del repository | `git status` |
| Osservazione della cronologia dei commit sul branch corrente | `git log` |
| Osservazione della cronologia dei commit compatta sul branch corrente | `git log --oneline` |
| Osservazione della cronologia dei commit su ogni branch | `git log --all` |
| Osservazione della cronologia dei commit con grafico | `git log --graph --all` |
| Osservazione della cronologia dei commit compatta con grafico | `git log --graph --all --oneline` |
| Osservazione delle differenze tra il working directory e lo stage | `git diff` |
| Osservazione delle differenze tra lo stage e il repository | `git diff --staged` |
| Osservazione delle differenze tra due `<tree-ish>` | `git diff <tree-ish1> <tree-ish2>` |
| Elenco dei remote associati al repository | `git remote -v` |
| Informazioni sul remote `<remote>` | `git remote show <remote>` |

---

#### Stage e Modifica

| Operazione | Comando |
| --- | --- |
| Aggiunta allo stage delle *modifiche* di un file (inclusa cancellazione) | `git add <file>` |
| Aggiunta forzata delle modifiche di un file allo stage anche se il file sarebbe normalmente ignorato | `git add -f <file>` |
| Rimozione dallo stage delle *modifiche* di un file | `git reset <file>` |
| Registrazione di un file rinominato | `git add <vecchio> <nuovo>` |
| Creazione di un commit con le modifiche nello stage | `git commit -m <messaggio>` |
| Recupero dello stato di un file dal commit `<tree-ish>` | `git checkout <tree-ish> -- <file>` |
| Creazione di un commit accettando il messaggio di default (**solo in caso di merge!**) | `git commit --no-edit` |

---

#### Branching

| Operazione | Comando |
| --- | --- |
| Spostamento di `HEAD` ad uno specifico `<tree-ish>` | `git checkout <tree-ish>` |
| Creazione di un nuovo branch | `git branch <nome>` |
| Creazione di un nuovo branch e spostamento di `HEAD` | `git checkout -b <nome>` |
| Creazione di un nuovo branch a partire da un branch esistente su un remote (import di branch remoti) | `git checkout -b <nome> <remote>/<branch>` |
| Merge di un branch locale in quello corrente | `git merge <nome del branch da mergere>` |
| Configurazione di un upstream branch | `git branch -u <remote>/<branch>` |

---

#### Operazioni su remote

| Operazione | Comando |
| --- | --- |
| Aggiunta di un remote | `git remote add <nome> <url>` |
| Rimozione di un remote | `git remote remove <nome>` |
| Aggiornamento del remote che ospita l'upstream branch corrente (o di `origin`, se presente) | `git fetch` |
| Aggiornamento di un remote | `git fetch <nome>` |
| Aggiornamento del remote che ospita l'upstream branch corrente (o di `origin`, se presente) e merge del branch corrente con il branch corrispondente sul remote | `git pull` |
| Invio delle modifiche sull'upstream branch corrente | `git push` |
| Invio delle modifiche su un nuovo branch su `<remote>` e registrazione del nuovo branch come upstream | `git push -u <remote> <branch>` |

#### SSH

| Operazione | Comando |
| --- | --- |
| Generazione di una chiave SSH | `ssh-keygen` |


---

# Git cheatsheet

{{% import path="cover.md" %}}
