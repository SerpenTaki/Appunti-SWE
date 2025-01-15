> In che modo un oggetto svolge la sua funzione?
> In che modo diversi oggetti collaborano tra loro?

## Command
**Scopo**
- *Incapsulare* una *richiesta* in un oggetto cosicchè i client sia indipendenti dalle richieste
**Motivazione**
- Necessità di gestire richieste di cui non si conoscono i particolari
	- Toolkit associano ai propri elementi, richieste da eseguire
- Una classe astratta, *Command*, definisce l'*interfaccia per eseguire* la richiesta
	- La richiesta è un semplice oggetto
**Applicabilità**
- *Parametrizzazione* di oggetti sull'azione da eseguire
	- *Callback function*
- Specificare, accodare ed eseguire richieste molteplici volte
- *Supporto* ad operazione `Undo` e `Redo`
- Supporto a *transazione*
	- Un comando equivale ad una operazione atomica
![[Screenshot 2025-01-15 alle 14.30.51.png]]
![[Screenshot 2025-01-15 alle 14.31.25.png]]**Conseguenze**
- *Accoppiamento "lasco"* tra oggetto invocante e quello che porta a termine l'operazione
- I *command* possono essere estesi
- I comandi possono essere composti e innestati
- E' facile aggiungere nuovi comandi
	- Le classi esistenti non devono essere modificate
![[Screenshot 2025-01-15 alle 14.38.09.png]]
![[Screenshot 2025-01-15 alle 14.38.22.png]]
![[Screenshot 2025-01-15 alle 14.38.30.png]]
![[Screenshot 2025-01-15 alle 14.38.40.png]]
**Implementazione**
- Quanto deve essere *intelligente* un comando?
	- Semplice *binding* fra il *receiver* e l'azione da eseguire
	- Comandi agnostici, autoconsistenti
- Supporto all' *undo* e *redo*
	- Attenti allo *stato del sistema* da mantenere
	- *History list*
- Accumulo di errori durante l'esecuzione di più comandi successivi
- Utilizzo dei *template* C++ o dei Generics Java
## Iterator
**Scopo**
- Fornisce l'*accesso sequenziale* agli elementi di un aggregato
	- Senza esporre l'implementazione dell'aggregato
**Motivazione**
- "Per scorrere non è necessario conoscere"
	- Devono essere disponibili *diverse politiche* di *attraversamento*
- Iterator pattern sposta la responsabilità di attraversamento in un oggetto iteratore
	- Tiene traccia dell'elemento corrente
**Applicabilità**
- Accedere il contenuto di un aggregato *senza esporre* la *rappresentazione interna*
- Supportare diverse politiche di attraversamento
- Fornire un'*interfaccia unica* di attraversamento su diversi aggregati
	- *Polymorphic iteration*
![[Screenshot 2025-01-15 alle 16.58.28.png]]
**Conseguenze**
- Supporto a *variazioni* nelle politiche di *attraversamento* di un aggregato
- *Semplificazione* dell'interfaccia dell'*aggregato*
- Attraversamento contemporaneo di più iteratori sul medesimo aggregato
![[Screenshot 2025-01-15 alle 16.59.53.png]]
![[Screenshot 2025-01-15 alle 17.00.08.png]]
**Implementazione**
- Chi controlla l'iterazione?
	- *External (active) iterator:* il client controlla l'iterazione
	- *Internal (passive) iterator:* l'iteratore controlla l'iterazione
- Chi definisce l'algoritmo di attraversamento?
	- Aggregato: iteratore viene definito "cursore"
		- Il client invoca Next sull'aggregato, fornendo il cursore
	- Iteratore: viene violata l'encapsulation dell'aggregato
- Iteratori robusti
	- Assicurarsi che l'inserimento e la cancellazione di elementi dall'aggregato non creino interferenze
- Operazione aggiuntive
- *Polymorphic iterator*
	- Utilizzo del ProxyPattern per deallocazione del'iteratore
- Accoppiamento stretto tra iteratore e aggregato
	- C++, dichiarare friend l'iteratore
- Null iterator
	- Iteratore degenere che implementa `IsDone`con il ritorno di `true`
	- Utile per scorrere strutture ricorsive
## Observer
**Scopo**
- Definisce una *dipendenza (1...n)* fra oggetti, riflettendo la *modifica* di un oggetto sui dipendenti
**Motivazione**
- Mantenere la *consistenza* fra oggetti
	- Modello e viste ad esso collegate
- Observer pattern definisce come *implementare* la relazione di dipendenza
	- *Subject*: effettua le notifiche
	- *Observer:* si aggiorna in risposta ad una notifica
- "*Publish-Subscribe*"
![[Screenshot 2025-01-15 alle 17.09.26.png]]
**Applicabilità**
- Associare più "*viste*" differenti ad una astrazione
	- Aumento del grado di riuso dei singoli tipi
- Il *cambiamento* di un oggetto richiede il cambiamento di altri oggetti
	- Non si conosce quanti oggetti devono cambiare
- *Notificare* oggetti senza fare assunzioni su quali siano questi oggetti
	- Evita l'accoppiamento "forte"
![[Screenshot 2025-01-15 alle 17.11.41.png]]
![[Screenshot 2025-01-15 alle 17.11.49.png]]
**Conseguenze**
- *Accoppiamento "astratto"* tra soggetti e osservatori
	- I soggetti non conoscono il tipo concreto degli osservatori
- Comunicazione broadcast
	- Libertà di *aggiungere* osservatori *dinamicamente*
- Aggiornamenti non voluti
	- Un operazione "innocua" sul soggetto può provocare una *cascata* "pesante" di *aggiornamenti*
		- Gli osservatori *non sanno cosa* è cambiato nel soggetto
![[Screenshot 2025-01-15 alle 17.19.08.png]]
![[Screenshot 2025-01-15 alle 17.19.22.png]]
**Implementazione**
- Utilizzo di sistemi di *lookup* per gli osservatori
	- Nessuno spreco di memoria nel soggetto
- Osservare più di un soggetto alla volta
	- Estendere l'interfaccia di aggiornamento con il soggetto che ha notificato
- Chi deve attivare l'aggiornamento delle "visite"?
	- Il soggetto, dopo ogni cambiamento di stato
	- Il *client*, a termine del processo di interazione con il soggetto
- Evitare puntatori "pendenti" (*dangling*)
- Notificare solo in stati consistenti
	- Utilizzo del *Template Method pattern*
- Evitare protocolli di aggiornamento con assunzioni
	- *Push model:* Il soggetto conosce i suoi osservatori
	- *Pull model:* Il soggetto invia solo la notifica
- Notifica delle modifiche sullo stato del soggetto
	- Gli osservatori si registrano su un particolare evento
```C++
void Subject::Attach(Observer*, Aspect& interest)
void Observer::Update(Subject*, Aspect& interest)
```
- Unificare le interfacce di soggetto e osservatore
	- Linguaggi che non consentono l'ereditarietà multipla
		- Smalltalk, ad esempio...
## Strategy
**Scopo**
- Definisce una famiglia di algoritmi, rendendoli interscambiabili
	- Indipendenti dal *client*
**Motivazione**
- Esistono diversi algoritmi (*strategie*) che non possono essere inserite direttamente nel *client*
	- I *client* rischiano di essere troppo *complessi*
	- Differenti strategie sono appropriate in casi differenti
	- È difficile aggiungere nuovi algoritmi e modificare gli esistenti
**Applicabilità**
- Diverse classi *differiscono* solo per il *comportamento*
- Si necessita di *varianti* dello stesso algoritmo
- Un algoritmo utilizza dati di cui i *client* non devono occuparsi
- Una classe definisce differenti *comportamenti* tradotti in una serie di *statement* condizionali
![[Screenshot 2025-01-15 alle 17.30.02.png]]
**Conseguenze**
- Definizione di famiglie di algoritmi per il *riuso* del contesto
- Alternativa all'ereditarietà dei *client*
	- Evita di effettuare *subclassing* direttamente dei contesti
- Eliminazione degli statement condizionali
![[Screenshot 2025-01-15 alle 17.31.42.png]]
- Differenti implementazioni dello stesso comportamento
- I client a volte devono conoscere dettagli implementativi
- Comunicazione tra contesto e algoritmo
	- Alcuni algoritmi non utilizzano tutti gli *input*
- *Incremento* del *numero* di *oggetti* nell'applicazione
![[Screenshot 2025-01-15 alle 17.33.22.png]]
![[Screenshot 2025-01-15 alle 17.33.36.png]]
![[Screenshot 2025-01-15 alle 17.33.51.png]]
**Implementazione**
- Definire le interfacce di strategie e contesti
	- Fornisce singolarmente i dati alle strategie
	- Fornisce l'intero contesto alle strategie
	- Inserire un puntamento al contesto nelle strategie
- Implementazione strategie
	- C++: Template, Java:Generics
	- Solo se l'algoritmo può essere determinato a *compile time* e non può variare dinamicamente
- Utilizzo strategia opzionali
	- Definisce una strategia di *default*
## Template Method
**Scopo**
- Definisce lo scheletro di un algoritmo, lasciando l'implementazione di alcuni passi alle sottoclassi
	- Nessuna modifica all'algoritmo originale
**Motivazione**
- Definire un algoritmo in termini di operazioni astratte
	- Viene fissato solo l'ordine delle operazioni
- Le sottoclassi forniscono il comportamento concreto
**Applicabilità**
- Implementare le *parti invarianti* di un algoritmo una sola volta
- Evitare la duplicazione del codice
- Controllare le possibili estensioni di una classe
	- Fornire sia operazioni astratte sia operazioni hook (*wrapper*)
![[Screenshot 2025-01-15 alle 17.41.19.png]]
**Conseguenze**
- Tecnica per il riuso del codice
	- Fattorizzazione delle responsabilità
- *"The Hollywood principle"*
- Tipi di operazioni possibili
	- Operazioni concrete della classe astratta
	- Operazioni primitive (astratte)
	- Operazioni hook
		- Forniscono operazioni che di *default* non fanno nulla, ma rappresentano punti di estensione
- Documentare bene quali sono operazioni primitive e quali *hook*
![[Screenshot 2025-01-15 alle 17.43.58.png]]
![[Screenshot 2025-01-15 alle 17.44.09.png]]
![[Screenshot 2025-01-15 alle 17.44.18.png]]
![[Screenshot 2025-01-15 alle 17.44.27.png]]
![[Screenshot 2025-01-15 alle 17.44.39.png]]
**Implementazione**
- Le operazioni *primitive* dovrebbero essere membri *protetti*
- Il template `method`non dovrebbe essere ridefinito
- Minimizzare il numero di operazioni *primitive*
- Definire una *naming convention* per i nomi delle operazioni di cui effettuare *override*
