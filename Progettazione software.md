![[Screenshot 2024-11-20 alle 09.11.31.png]]
![[Screenshot 2024-11-20 alle 09.12.03.png]]
- L'attività di analisi risponde alla domanda
	- *Qual'è il problema, qual è la cosa giusta da fare?*
	- Comprensione del dominio e discernimento di obiettivi vincoli e requisiti tecnici e funzionali
- L'attività di progettazione risponde alla domanda
	- *Come fare la cosa giusta (quella di cui c'è bisogno)?*
	- Ricerca di una soluzione realizzativa soddisfacente per tutti gli *stakeholder*
	- Individuazione e specifica dell'**architettura** del prodotto da cui discenderà la sua codifica
> The task of "making a thing satisfying our needs", as a single responsibility, is split into two parts:
> 1. Stating the properties of a thing, by virtue of which, it would satisfy our needs and
> 2. Making a thing that is guaranteed to have the stated properties
> *Edsger W.Dijkstra "On the role of scientic thought*
- La parte 1 di tale responsabilità è dell'analisi
- La parte 2 è di progettazione e codifica
### Progettare prima di produrre
- La progettazione (*design*) precede la codifica
	- Perseguendo **correttezza per costruzione**
	- In luogo di **correttezza per correzione**
- La progettazione (*design*) serve a:
	- Dominare la complessita del prodotto *"divide et impera, D&C"*
	- Organizzare e ripartire le responsabilità di realizzazione
	- Produrre in economia (*efficienza*)
	- Garantire qualità (*efficacia*)
## Obiettivi della progettazione
- Realizzare un prodotto SW di qualità capace di soddisfare tutti i requisiti attesi
- Definendo l'**architettura logica** (*design*) del prodotto
	- Individuando parti compatibili coerenti con i requisiti, e dotate di specifica chiara e coesa
	- Realizzabili con risorse sostenibili e costi contenuti
	- Organizzate in modo da facilitare cambiamenti futuri
- La scelta di una buona architettura è determinante al successo del progetto
	- Perchè da certezze sulla codifica sa di soddisfare tutti i requisiti e sa di possedere qualità attese e desiderabili
- Dominare la complessità del sistema
- Spingendo il *design* in profondità, attraverso **Progettazione di dettagli**
	- Decidere cosa deve succedere, quando, e dove
	- Suddividendo il sistema fino a che ciascuna sua parte abbia bassa complessità individuale
	- In modo che la codifica di ogni singola parte diventi compito individuale, fattibile, rapido e facilemente verificabile
	- Fermando la decomposizione quando il costo organizzativo di coordinamento delle parti ne supera il beneficio
##### Glossario
- ISO/IEC/IEEE 42010:2011 *System and software engineering - __Architecture description__*
- Decomposizione del sistema in parti componibili: componenti
- Organizzazione di tali componenti
	- Ruoli, responsabilità, iterazioni (chi fa cosa e come)
- Interfacce necessarie all'iterazione tra le componenti tra loro e con l'ambiente di esecuzione
	- Come le componenti collaborano e interagiscono
- Paradigmi di composizione delle componenti
	- Regole, criteri, limiti, vincoli (*anche a fini di manutentibilità*)
## Progettazione di dettaglio
- Le *parti* della progettazione di dettaglio sono chiamate **unità** architetturali
	- Unità funzionali (*fanno cose*) o di controllo ben definite, realizzabili da un singolo programmatore
- A una singola unità architetturale possono corrispondere uno o più **moduli** di codice
- La corrispondenza *Unità-Modulo* è determinata dalle caratteristiche del linguaggio utilizzato per la realizzazione
	- *Es: una classe Java, modulo sintattico del linguaggio, può ben corrispondere a una unità archittetturale*
- Le unità architetturali realizzano le componenti dell’architettura logica
	- La decomposizione delle componenti architetturali in unità ne facilità la realizzazione
- **Tracciare l'architettura nel codice** porta 2 benefici
	- Aiuta la verifica di copertura dei requisiti, rendendola più diretta e circoscritta
	- Guida l'integrazione delle prodotto SW, dalle sue singole parti al tutto
- La specifica di ogni unità architetturale deve essere ben documentata affinchè la sua programmazione possa svolgersi in modo autonomo e disciplinato 
	- Assicurando tracciamento di requisiti dall'architettura logica verso le singole unità
- La responsabilità di realizzare singole unità ne include la verifica
	- Per questo il SW si misura in termini di *delivered source lines of code*
![[Screenshot 2024-11-20 alle 09.55.58.png]]
# Approcci di progettazione
- Procedimento *Top-down*
	- Studio il prodotto immaginando le parti in cui può essere <u>decomposto</u>
	- Senza elementi preconcetti: esplorazione funzionale (*cosa deve succedere e cosa mi serve per farlo succedere*)
- Procedimento *Bottom-up*
	- Concepisco il prodotto ipotizzando le parti che possono <u>comporlo</u> (*cosa certe singole parti possono fare di utile*)
	- Tipico dell'OOP, fortemente orientato a riuso e specializzazione 
- Procedimento *Agile*
	- Perseguendo consolidamento progressivo (Ciclo *feedback - refactoring*) contando su una architettura base che non si rompa a seguito di aggiunte o rimozioni
	- Utile anche alla cattura di requisiti resi più chiari e concreti dall'avanzamento della realizzazione.
