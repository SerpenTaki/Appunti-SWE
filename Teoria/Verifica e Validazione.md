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
# Walkthrough
### Definizione
- 