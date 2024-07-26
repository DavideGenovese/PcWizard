# PcWizard

## Descrizione del Progetto

Il PCWizard è un'applicazione Java progettata per gestire l'inventario di un negozio di computer. Gli utenti possono inserire il nome del PC, il prezzo e le varie componenti hardware, come la CPU, la memoria di massa e la RAM. L'applicazione permette di salvare i dettagli del PC in un database SQLite.

## Struttura del Progetto

Il progetto è organizzato come segue:

- **Main**: Punto di ingresso dell'applicazione.
- **Classi Modello**: Rappresentano le entità principali del sistema.
  - `PC`
  - `CPU`
  - `MMA` (Memoria di Massa)
  - `RAM`
- **Repository**: Gestiscono le operazioni di persistenza dei dati nel database.
- **Database**: Utilizzato per memorizzare i dettagli dei PC creati.

## Prerequisiti

Prima di iniziare, assicurati di avere installato i seguenti strumenti:

- [SQLite](https://www.sqlite.org/download.html)
- Un ambiente di sviluppo integrato (IDE) come [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) o [Eclipse](https://www.eclipse.org/downloads/)

## Configurazione del Progetto

1. **Clona il repository**

   ```bash
   git clone
   cd pcWizard
2. **Configura il database SQLite**

   Assicurati che SQLite sia installato e configura il percorso del database nel file di configurazione dell'applicazione.

3. **Compila ed esegui il progetto**

   Apri il progetto nel tuo IDE preferito, compila il codice ed esegui l'applicazione dal file PCAssembler.java.

## Esempio di Utilizzo

Esegui l'applicazione e segui le istruzioni per inserire i dettagli del PC:

1. Inserisci il nome del PC.
2. Inserisci il prezzo del PC.
3. Inserisci i dettagli delle componenti hardware (CPU, MMA, RAM).
4. Salva i dettagli nel database.

## Struttura delle Classi

- **PCAssembler.java**: Contiene il metodo `main` che avvia l'applicazione.
- **PC.java**: Modello per rappresentare un PC.
- **CPU.java**: Modello per rappresentare una CPU.
- **MMA.java**: Modello per rappresentare la memoria di massa.
- **RAM.java**: Modello per rappresentare la RAM.
- **PCRepository.java**: Gestisce le operazioni CRUD per i PC nel database.

## Tecnologie Utilizzate

- **Java**: Linguaggio di programmazione principale.
- **SQLite**: Sistema di gestione di database utilizzato per memorizzare i dettagli dei PC.
- **JDBC**: Utilizzato per interfacciarsi con il database SQLite.


