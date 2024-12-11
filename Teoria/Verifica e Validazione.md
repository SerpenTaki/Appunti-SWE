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
