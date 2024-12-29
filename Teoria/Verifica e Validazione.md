- **_Software Verification_**
	- Provides objective evidence that the outputs of *a particular segment* of the software development meet all the requirements specified for it
	- Looks for consistency, completeness, and correctness of those output
	- *Provides support for subsequent conclusion that software is validated*
- **_Software Validation_**
	- Confirmation by examination and provision of objective evidence that
	1. The SW specifications conform to user needs and intended uses
	2. The requirements implemented through SW can be consistently fulfilled
**In pratica**
- La **verifica** agisce su singoli segmenti di sviluppo accertando che l'esecuzione in essi (*segmenti*) non abbia introdotto errori
	- Approvando la *baseline* associate alle *milestone* di progetto
- La **validazione** agisce a fine progetto, accertando che il prodotto finale sia pienamente conforme alle aspettative
- La verifica prepara il successo della validazione
![[Screenshot 2024-12-03 alle 11.31.48.png]]
- Una *milestone* è una data di calendario che fissa un punto di avanzamento atteso
- Il raggiungimento di quegli specifici obiettivi di avanzamento va sostanziato da una *baseline*
- Una *baseline* è la versione approvata di un prodotto di lavoro (parte di un progetto) che può essere modificato solo attraverso procedure formali di controllo delle modifiche
- Il prodotto di un progetto è un aggregato di SW e di documentazione
## La verifica ha 2 forme
- **Analisi statica** **AS**
	- Non richiede esecuzione dell'oggetto di verifica
	- Studia documentazione e codice (sorgente, oggetto)
	- Accerta conformità a regole, assenza di difetti, presenza di proprietà desiderate
	- Può essere usata nella validazione
- **Analisi dinamica AD**
	- Richiede esecuzione dell'oggetto di verifica (quando questo è eseguibile, cioè è SW)
	- Viene effettuata tramite prove (*test*)
	- Viene usata anche nella validazione
### Analisi statica
- Non richiedono esecuzione dell'oggetto di verifica, è applicabile a ogni prodotto di processo
	- Per tutti i processi attivati nel progetto
- Può usare **metodi di lettura** *(desk check)*
	- Impiegati solo per prodotti semplici
- Oppure **metodi formali** (p.es. algebrici)
	- Basati su prova assistita di proprietà, utile sopratutto quando la dimostrazione empirica ha un costo proibitivo
## Metodi di lettura
- **Walkthrough** e **Inspection**
	- Attraverso lettura - umana o automatizzata - dell'oggetto di verifica
- La loro efficacia dipende dall'esperienza dei verificatori o l'accuratezza degli strumenti automatici
	- Nell'organizzare le attività da svolgere
	- Nel garantire esaustività
	- Nel documentare le risultanze
- Modalità relativamente complementari tra loro
---
# Walkthrough
### Definizione
- **Atteggiamento**
	- Non sappiamo (*ancora*) dove è più probabile che vi siano difetti
- **Obiettivo**
	- Rilevare difetti attraverso lettura critica <u>ad ampio spettro</u> dell'oggetto in esame
- **Attori**
	- Gruppi misti autori/sviluppatori, con ruoli distinti tra loro
- **Strategia**
	- Esame privo di assunzioni o presupposti
- **Modalità**
	- Percorrere il codice simulandone possibili esecuzioni
	- Studiare ogni parte di documento, come farebbe un compilatore
### Attività
1. **Pianificazione**
	- Autori e verificatori
2. **Lettura**
	- Solo verificatori
3. **Discussione**
	- Autori e verificatori
4. **Correzione dei difetti**
	- Solo autori
- **Ogni passo verbalizza attività svolte e risultanze**
---
# Inspection
### Definizione
### Definizione
- **Atteggiamento**
	- Sappiamo cosa cercare
- **Obiettivo**
	- Rilevare La presenza di difetti eseguendo lettura <u>mirata</u> dell'oggetto di verifica
- **Attori**
	- Verificatori
- **Strategia**
	- Esame focalizzato su presupposti (*error guessing*)
- **Modalità**
	- Sapendo cosa cercare permette maggiore automazione della ricerca
### Attività
1. **Pianificazione**
2. **Definizione _Lista di controllo_**
	- Cosa vada verificato selettivamente
3. **Lettura**
4. **Correzione dei difetti**
	- A carico degli autori
- **Ogni passo documenta attività svolte e risultanze**
---
[[Testing Mtss]]
## Ambiente di prova
- I *Test* devono essere **ripetibili**: per questo specificano
	- Ambiente d'esecuzione: HW/SW, stato iniziale
	- Attese: Ingressi richiesti, uscite ed effetti attesi
	- Procedure: esecuzione, analisi dei risultati
- I *Test* vanno **automatizzati:** perciò usano strumentazione
	- *Driver* Componente attiva fittizia per pilotare il test
	- *Stub* Componente passiva fittizia per simulare parti del sistema utili al test ma non oggetto di test
	- *Logger* Componente non intrusivo di registrazione dei dati di esecuzione per analisi dei risultati
![[Screenshot 2024-12-11 alle 16.55.09.png]]
---
**Glossario**
- **Unità**
	- La più piccola quantità di SW che sia utilmente sottoponibile a verifica come oggetto singolo
	- Tipicamente prodotta da un singolo programmatore
	- In senso architetturale: non linee di codice ma entità di organizzazione logica
		- Singola procedura, singola classe, piccolo aggregato (*package*) coeso
- Il **modulo** (come determinato dal linguaggio di programmazione) è una frazione dell'unità
- Il **componente** integra più unità correlate e coese
---
![[Screenshot 2024-12-11 alle 16.58.33.png]]
![[Screenshot 2024-12-11 alle 16.58.46.png]]![[Screenshot 2024-12-11 alle 16.59.01.png]]
## Test di unità
[[Unit Testing]]
- È agevolato da attività mirate di analisi statica
	- Limiti di iterazioni, flusso di esecuzione, valori di variabili,....
- Consente altro grado di parallelismo e automazione nello svolgimento
- Per le unità più semplici, può essere assegnato ai loro rispettivi autore
	- Altrimenti meglio assegnarlo a verificatore indipendente
- Accerta la correttezza del codice <<**as implemented**>>
	- Mai modificare il sorgente del codice cui si esegue test
### La risoluzione dei problemi
- Per scovare problemi e risolverli tempestivamente
- La soluzione dei problemi attiene al processo di supporto <<**_Problem resolution_**>> di ISO/IEC 122017, che si occupa di
	- Sviluppare una strategia di gestione dei problemi
	- Registrare ogni problema rilevato e classificarlo in uno storico così da ricordarne l'occorrenza e la risoluzione
	- Analizzare ogni problema e determinare soluzioni accettabili
	- Realizzare la soluzione scelta
	- Verificare l'esito della correzione
	- Assicurare che tutti i problemi già emersi siano sotto gestione
## Test Di Regressione
- Modifiche effettuate per aggiunta, correzione o rimozione, non devono pregiudicare le funzionalità già verificate,
- Se lo fanno, causano **regressione**
	- Il rischio di regressione aumenta all'aumentare dell'accoppiamento e al diminuire dell'incapsulazione
- I *Test* di regressione comprende tutti i test necessari ad accertare che la modifica di una parte $P$, $S$ o in ogni altra parte $X$ del sistema che sia in relazione con $S$
	- Ripetendo *test* già specificati e già eseguiti
## Test Di Integrazione
- Per costruzione e verifica incrementale del sistema
	- Quando l'integrazione incrementale di componenti sviluppati in parallelo realizza funzionalità di livello sistema
	- La *build* incrementale è totalmente automatizzabile
	- In condizioni ottimali l'integrazione è priva di problemi
- Quali problemi rileva
	- Errori residui nella realizzazione dei componenti
	- Modifica delle interfacce o cambiamenti nei requisiti
	- Riuso di componenti dal comportamento oscuro o inadatto
	- Integrazione con altre applicazioni non ben conosciute 
![[Screenshot 2024-12-11 alle 17.14.16.png]][[Integrazione Continua]]
---
## Test di sistema e collaudo
- **Validazione**
	- Test di sistema come attività interna del fornitore
		- Per accettarne la copertura dei requisiti SW in preparazione al collaudo
	- Collaudo come attività supervisionata dal committente
		- Per dimostrare conformità del prodotto alle attese attraverso casi di prova implicati dal capitolato
- **Collaudo**
	- Attività formale di fronte al committente
	- Al suo buon esito consegue rilascio finale del prodotto
![[Screenshot 2024-12-11 alle 17.19.35.png]]
![[Screenshot 2024-12-11 alle 17.19.46.png]]

---

# Analisi Statica
- Un SW di qualità deve possedere
	- Tutte le capacità **funzionali** attese, che specificano **cosa** il sistema debba fare
	- Tutte le caratteristiche **non-funzionali** necessarie affinchè il sistema lavori sempre **come** previsto
- Dimostrarlo richiede accertare il possesso di svariate proprietà
	- **Di costruzione**: architettura, codifica, integrazione
	- **D'uso:** esperienza utente, precisione, affidabilità
	- **Di funzionamento:** prestazioni, robustezza, sicurezza
![[Screenshot 2024-12-29 alle 13.53.20.png]]
![[Screenshot 2024-12-29 alle 13.54.16.png]]
![[Screenshot 2024-12-29 alle 13.54.25.png]]
![[Screenshot 2024-12-29 alle 13.54.46.png]]
- La codifica deve *aiutare* la verifica, non ostacolarla
	- Pochi linguaggi di programmazione la facilitano davvero
	- Per questo serve imporre disciplina di programmazione
- L'uso di funzionalità *oscure* ostacola l'accertamento di **integrità**
	- L'integrità è la qualità di fare quanto atteso nel modo atteso, sempre
	- La programmazione non può essere ottimistica *(non sono sicuro ma spero che funzioni...)*
- Le norme di codifica devono bilanciare la ricchezza di funzionalità con le garanzie di integrità
## Scrivere programmi verificabili
- Dotarsi di norme di codifica coerenti con le esigenze di verifica
	- Promuovendo buone prassi e ponendo vincoli sui costrutti di programmazione inappropriati
	- Verificandone attivamente il rispetto
- La verifica retrospettiva è <u>insufficiente</u>
- **Il costo di rilevazione e correzione di errori cresce con l'avanzare dello sviluppo**
![[Screenshot 2024-12-29 alle 14.03.37.png]]
- L'approccio reattivo alla verifica è ingenuo, pigro e ottimistico
	- *Hoping for correctness by correction*
- È più saggio sostenere lo sviluppo con scelte consapevoli e verifica sistematica: approccio costruttivo
	- *Pursuing correctness by construction*
- Regolamentare l'uso del linguaggio di programmazione tramite principi da riflettere nelle Norme di Progetto
	1. Per assicurare <u>comportamento predicibile</u>
	2. Per usare buoni <u>principi di programmazione</u>
	3. Per <u>ragioni pragmatiche</u>
- Vediamo ciascuna di queste 3 dimensioni
### 1. Comportamento predicibile
- Codice sorgente senza ambiguità
	- Effetti laterali (*p.es. di sottoprogrammi*)
		- Invocazioni della <u>stessa</u> azione che producano effetti <u>diversi</u>
	- Ordine di elaborazione e inizializzazione
		- L'effetto del programma può dipendere dall'ordine di **elaborazione** o l'ordine di **esecuzione** delle sue parti
		- *Esempio:* impredicibilità nell'attivazione di *thread*
	- Modalità di passaggio dei parametri
		- La scelta di una modalità di passaggio (per valore, per riferimento) può influenzare l'esito dell'esecuzione
```Java
class Swapper{
	public static void swap(int Left, int Right){
		int tmp = Left;
		Left = Right;
		Right = tmp;
	}

	public static void main(String args[]){
		int Source = 1;
		int Destination = 3;
		swap(Source, Destination);
	}
}
//In Java, in nomi sono riferimenti, ma le chiamate sono per valore
```
### 2. Principi di Programmazione 
- ==Riflettere l'architettura (*design*) nel codice==
	- Usare programmazione strutturata per esprimere componenti, moduli, unità come da progettazione, e facilitare l'integrazione
- ==Separare le interfacce dall'implementazione==
	- Fissare bene le interfacce a partire dall'architettura logica
	- Esporre le interfacce, nascondere l'implementazione
- ==Massimizzare l'incapsulazione (*information hiding*)==
	- Usare membri privati e metodi pubblici per l'accesso ai dati
- ==Usare tipi specializzati per specificare dati==
	- La composizione e la specializzazione aumentano il potere espressivo del sistema di tipi del programma
### 3. Considerazioni pragmatiche
- L'efficacia dei metodi di verifica è funzione della qualità di strutturazione del codice
	- **Esempio:** una procedura con <u>un solo</u> punto di uscita facilita l'analisi del suo effetto sullo stato del sistema
- La verifica di un programma mette in relazione segmenti di codice con porzioni di specifica
	- La verificabilità dipende inversamente dall'ampiezza del contesto oggetto di verifica
		- *Più è ampio il contesto, più è difficile e costoso verificare: confinare __scope__ e visibilità*
	- Una buona architettura facilita la verifica
		- P.es. Tramite incapsulazione dello stato e controllo di accesso
## Tracciamento
- Dimostra completezza ed economicità del prodotto
	- Nessun requisito dimenticato
	- Nessuna funzionalità superflua
- Va applicato
	- Su ogni passaggio della specifica (*ramo discendente*)
	- A ogni passo di implementazione (*ramo ascendente*)
- Va automatizzato il più possibile
	- Per limitarne il costo all'aumentare della sua intensità
![[Screenshot 2024-12-29 alle 14.39.13.png]]
- Tracciare i requisiti su progettazione di dettaglio e codifica aiuta a valutare il costo di verifica
	- Assegnare $N$ requisiti elementari a 1 singolo modulo SW richiede almeno $N$ procedure di prova per quel modulo (1 prova per 1 requisito aiuta a rendere le prove decidibili)
	- Al crescere di $N$ crescono la criticità e il costo di quel modulo
- Maggiore il potere espressivo di un costrutto, maggiore la sua complessità di esecuzione, maggiore il costo di dimostrarlo corretto
	- Basso potere espressivo: addizione tra interi, ..
	- Alto potere espressivo: attivazione di *thread*, invocazione di API esterne,...
# Tipi di Analisi statica del Codice
- Flusso di controllo
- Flusso dei dati
- Verifica di limite
- Uso dello *stack*
- Comportamento temporale
#### Analisi di flusso di controllo
- Per accertare 
	- Logica: l'esecuzione avverrà nella sequenza specificata
	- Visibilità e propagazione: il codice è ben strutturato
- Per localizzare codice non raggiungibile
- Per identificarre rischi di non terminazione
	- L'analisi dell'albero delle chiamate (*call-tree analysis*) mostra se l'ordine di chiamata corrisponda alla specifica
	- E segnala la presenza di ricorsione diretta o indiretta
	- La modifica di variabili di controllo delle iterazioni è fonte di vulnerabilità rispetto alla terminazione
#### Analisi di flusso dei dati
- Per accertare che nessun cammino d'esecuzione del programma acceda a variabili non valorizzate 
	- Concentrando l'analisi di flusso di controllo sulla sequenza di accesso alle variabili e sue modalità (lettura, scrittura)
- Per rilevare possibili anomalie
	- Scritture successive senza lettura intermedie
	- Letture che precedano scritture
- Per accertare l'assenza di variabili globali
	- E di altre violazioni al principio di incapsulazione
#### Analisi di limite
- Per verificare che i valori del programma restino sempre entro i limiti del loro tipo e della precisione desiderata
- L'**_overflow_** produce valori maggiori del massimo rappresentabile
	- Può causare eccezioni o silenziosamente produrre valori errati
- L'**_underflow_** produce valori più piccoli del minimo rappresentabile
	- Può causare eccezioni o grande perdita di precisione
- Rispetto dei limiti nell'accesso a strutture dati (*range checking*)
- Alcuni linguaggi permettono di assegnare limiti statici a tipi discreti per facilitare verifica sulle corrispondenti variabili
	- Più difficile farlo con tipi enumerati e reali
#### Analisi d'uso di *stack*
- Per determinare la massima domanda di *stack* richiesta a tempo d'esecuzione in relazione con la dimensione della memoria assegnata all'esecuzione del programma
- Per verificare che non vi sia rischio di collisione tra *stack* e *heap* per qualche esecuzione
##### Stack & Heap
- Lo *stack* è la memoria usata per ospitare dati locali e indirizzi di ritorno generati dal compilatore alla chiamata di sottoprogrammi
	- Ogni flusso di controllo (*main, thread*) ha il suo *stack*
	- La sua dimensione cresce con l'annidamento di chiamate
	- I dati in esso hanno chiare regole di visibilità e ciclo di vita
- L'*heap* è la memoria usata per tutto il resto (globale)
	- Dimensione fissata prima dell'avvio del programma
	- Contenuto determinato dalla quantità di oggetti globali creati durante l'esecuzione del programma
	- Regole di visibilità e ciclo di vita difficili da controllare
![[Screenshot 2024-12-29 alle 17.02.23.png]]
#### Analisi Temporale
- Per studiare le dipendenze temporale (latenza) tra le uscite del programma e i suoi ingressi
	- Per verificare che il valore giusto sia prodotto al momento giusto
- Limiti espressivi dei linguaggi e delle tecniche di programmazione complicano questa analisi
	- Iterazioni prive di limite statico (*while*)
	- Creazione dinamica di entità (*new*)