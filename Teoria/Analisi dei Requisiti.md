### Requisito
1. Capacità necessaria ad un utente per raggiungere un obiettivo: *lato bisogno*
2. Capacità necessaria ad un sistema per rispondere ad un'aspettativa
*Stesso nome per 2 significati diversi*
**Il capitolato riflette il punto di vista di lato _bisogno_**
- Le aspettative del proponente: *requisiti utente*
- Che a volte si addentrano anche in raccomandazioni tecniche
**L'analisi dei requisiti esplora però il punto di vista di _lato soluzione_**
- Ciò che il prodotto deve fare per soddisfare i bisogni **requisiti software**
### Acquisizione e fornitura
- Nel <u>processo di acquisizione</u>, il committente studia un problema di proprio interesse e fissa le proprie aspettative su un prodotto che lo risolva
	- Lo documenta in un **capitolato** che specifica i "**requisiti utente**"
- Nel <u>processo di fornitura</u>, il fornitore studia come soddisfare quelle richieste
	- Valutandone la fattibilità tecnico-economica, insieme al proprio interesse strategico
- La prima *milestone* del calendario di progetto è la revisione RTB, nella quale committente e fornitore raffinano il loro accordo su
	- La capacità della soluzione (**analisi dei requisiti**), i tempi e i costi dello sviluppo (**piano di progetto**), gli obiettivi di qualità (**piano di qualifica**)
- Nel mondo reale, questa *milestone* coincide con l'aggiudicazione, che invece noi anticipiamo per ragioni organizzativa
- Il contratto termina con la valutazione del committente sul prodotto (*fine del progetto*)
	- Accettazione condizionata a buon esito di collaudo
## Avvertenze
*Il punto di partenza della nostra commissione è l'aspettativa utente*
- I requisiti riflettono la prospettiva dell'utente nel passaggio dalla situazione *senza* a quella *con* il prodotto
	- Da *AS-IS* a *TO-BE*: cosa voglio poter fare che prima non potevo
	- Capire il "senza" (*prima*) per capire il "con" (*dopo*)
	- Nel dominio di interesse (*esempio tullio con l'anagrafe gente ignorante che non sa usare la linea di comando, non colpa dell'utente ma interfaccia inadeguata*)
- **L'analisi dei requisiti riflette la struttura funzionale del prodotto atteso**
	- Studia <u>cosa</u> deve succedere, non come farlo
	- Procede *gerarchicamente*, dal fuori del sistema verso l'interno, attraverso scenari d'uso
		- *approfondire come le richieste dall'esterno si ramifichino in tanti piccoli cosa, quindi scendiamo in quanto più dettaglio possibile per raccogliere tutte le esigenze da portare in progettazione ed implementazione __in questo senso gerarchico__*
	- Con la prospettiva del bisogno (**Attore UML**) nei confronti del sistema su cui agisce
- La risposta al <u>come</u> viene dalla progettazione (*design*)
- L'analisi dei requisiti deve comprendere a fondo i bisogni
	- Cosa deve succedere per rispondere alle richieste fatte al prodotto
- I [[Diagrammi Dei Casi D'uso]] hanno questa prospettiva
	- Relazione tra *attore* chi ha l'aspettativa e *sistema* chi ha le risposte all'aspettativa (*o parte del prodotto su cui ho aspettativa*)
	- Cosa posso chiedere, cosa deve succedere-> *che cosa deve succedere sul quale agire*
	- Le *user story* ne sono il corrispondente agile (*dialogo con un verbale tra utilizzatore utente e destinatario*, quindi catturiamo scenari d'uso)
	- L'analisi <u>non</u> deve costruire l'algoritmo di soluzione
		- Questo spetta alla progettazione
	- L'analisi <u>deve</u> essere consapevole della fattibilità tecnologica
- *alla base di uml e userstory ci sono scenari (__mettersi nei panni di...__) quindi ragiono su quello che succede ovvero le aspettative, e risposte alle situazioni*
## Fattori di rischio progettuale
- Le principali cause di abbandono di un progetto
	- Requisiti incompleti
	- Insufficiente coinvolgimento del *cliente/utente*
	- Attese irrealistiche
	- Scarsità di risorse rispetto all'ampiezza del problema
	- Volatilità di specifiche e requisiti
	- Insufficiente competenza del fornitore
- Molte di queste cause originano da analisi dei requisiti difettose
## Punto di arrivo
- Il culmine del progetto è il collaudo del prodotto (**validazione**)
	- In esso, il fornitore dimostra che tutti i requisiti utente siano soddisfatti
	- Accertando (*verifica*) progressivamente che lo sviluppo abbia preso in carico tutti i requisiti di lato soluzione, senza dimenticarne alcuno
- Il "**Tracciamento** _dei requisiti_" è la tecnica chiave per assicurarlo
	- non dimentico niente
	- So sempre dove ogni singolo requisito è soddisfatto
- L'analisi dei requisiti deve facilitare tracciamento e verifica
- Chi fissa un requisito di lato soluzione deve anche stabilire come accertarne il soddisfacimento
	- Facendo attenzione al costo e complessità della verifica
- Il metodo **Test-Driven Development** porta all'estremo il principio che l'aspettativa e la sua verifica stanno al principio di tutto
# Glossario
- **Verifica**
	- Accertare che lo svolgimento delle attività di sviluppo non introduce errori
	- *Did I build the system right?*- Attenzione rivolta al *way of working*
	- Ho fatto le cose giuste
- **Validazione**
	- Accertare che il prodotto finale corrisponda alle attese
	- *Did I build the right system*? - Attenzione rivolta al prodotto finale
	- Ho fatto le cose nel modo giusto?
- **Piano di Qualifica** (*prodotto nella RTB*)
	- Dire come svolgeremo le attività di **V&V** nel progetto
	- E con quali obiettivi di qualità
	- **V&V** = Qualifica
![[Screenshot 2024-10-30 alle 08.40.45.png]]
in un progetto tutte le attività sono collegate e ognuna di esse certifica il lavoro svolto.
È inutile non chiedersi se ciò che stiamo facendo è giusto dopo che abbiamo fatto mille passi in avanti. Bisogna piuttosto fare le cose in modo giusto evitando di sbagliare.
![[Screenshot 2024-10-30 alle 08.43.02.png]]
**Necessità**: tutto ciò che porto nel design e implementation ci deve essere per una ragione
**Sufficienza**: garantisce che noi finiamo con il minimo necessario, (*keyword* PB->MVP *minimum viable product* cioè io fornitore mi fermo nel primo punto in cui finisco i miei requisiti obbligatori).
# Attività di analisi dei requisiti
- Studio dei bisogni e del dominio d'uso
- Comprensione del problema dal lato dei bisogni
	- Approfondimento tramite *scenari* di caso d'uso
- Raggruppamento degli scenari per affinità
	- Entro "*parti del sistema*" verso le quali agiscono specifici bisogni
	- Approfondendo quelle parti gerarchicamente
- Valutazione di fattibilità tecnologica -> che impatto ha la tecnologia sui miei requisiti questa è anche vincolo
	- Noi la chiamiamo **_Technology Baseline_** (*Mark Zuchemberg che reinventa il modello cliente servente per facebook*)
- Classificazione e tracciamento dei requisiti
	- In dialogo con proponente e committente (*stakeholder*)
## Processi di supporto all'analisi
- **Documentazione**
	- Per raccogliere i risultati dell'analisi: **AdR**
	- Per dialogare con il committente
	- Per avviare consapevolmente la progettazione(*design*) -> *Quanta sovrapposizione mettere tra analisi dei requisiti e design*
- **Verifica di adesione al _way of working_** -> Costruire un evidenza che ci aiuti ad arrivare a Validazione senza nessun problema
	- Cruscotto di verifica della qualità: **PdQ**
- **Gestione e manutenzione dei prodotti dell'analisi**
	- Tracciamento dei requisiti
	- Gestione di verbale e configurazione
	- Gestione dei cambiamenti
### Per una buona analisi
- La specifica dei requisiti deve essere: *specifica parola tecnica per la parola descrizione, prevalentemente la specifica nel nostro mondo è narrativa ma questo può essere un problema*
	- Priva di ambiguità (*gli altri la devono capire come la capisco io*, rischio di ambiguita sia super attenuato e non travisi il significato)
	- Corretta 
	- Completa 
	- Verificabile (*come faremo a dire che è soddisfatta*) 
	- Consistente
	- Modificabile 
	- Tracciabile (*Identificatori, tipo requisito di sicurezza 3*)
	- Ordinata per rilevanza
- Per questo conviene ridurre i requisiti a *grana di fine*
	- Affinando e suddividendo i requisiti utente
	- Aggiungendone, ampliando lo sguardo sul problema
### Tecniche di analisi
- Dominio d'uso come fonte di requisiti impliciti
	- A quali bisogni risponde il prodotto atteso?
	- Per che tipo di utenti, con quali aspettative?
- Vi sono molti requisiti *nascosti*
	- La *classificazione dei requisiti* aiuta a scovarli
- Acquisizione di conoscenze: interviste al committente
	- Costruzione, analisi e discussione di scenari: decisioni riassunte in verbali
- Acquisizione di conoscenze: *brainstorming* (*da fare quando non abbiamo una risposta ma tanti frammenti di risposta* MOLTO UTILE)
	- Paritario
	- Arbitrato
	- E con lo scriba
- Consolidamento delle conoscenze di dominio **glossario** *in modo da unificare le definizioni e rendere le cose che diciamo uniformi a tutti*
- Valutazione di fattibilità tecnologica (*milestone* **TB**)
### Classificazione dei requisiti
![[Screenshot 2024-10-30 alle 09.36.57.png]]
- I requisiti hanno diversa rilevanza e utilià, che va negoziata e concordata con il committente
	- **Obbligatori** (*non ci si può presentare a PB senza questi*)
		- Irrinunciabili per qualcuno degli *stakeholder*
	- **Desiderabili**
		- Non strettamente necessari ma a valore aggiunto riconoscibile
	- **Opzionali**
		- Relativamente utili oppure contrattabili più avanti nel progetto
- **NON devono essere tra loro contraddittori**
![[Screenshot 2024-11-20 alle 08.42.25.png]]
![[Screenshot 2024-11-20 alle 08.42.37.png]]
- Separazione netta tra analisi e *design* si ha solo con lo sviluppo sequenziale
- In ogni altro caso le 2 attività evolvono in parziale sovrapposizione e dialogo tra loro
	- Noi le facciamo avvicinare nel convergere verso la *milestone __RTB__*
- La prassi XP suggerisce che il *design* evolva per fattorizzazioni successive
- Perseguendo sempre semplicità nella soluzione
	- Un *design* semplice richiede poco codice *il meno possibile*
	- Questo è un ottimo indicatore di *assenza di* semplicità
### Documentazione dell'analisi
- La documentazione in linguaggio naturale genera rischi di ambiguità interpretativa
	- Servono norme redazionali per evitare espressioni ambigue
	- Glossario per garantire terminologia consistente
- Uso di metodi *semi-formali* aiuta a ridurre gli errori di interpretazione
	- Diagrammi e formule (**UML**) invece di testo e disegni in stile libero
	- **_User story_** strutturate
![[Screenshot 2024-11-20 alle 08.49.02.png]]
- **Ricercare chiarezza espressiva**
	- L'uso del linguaggio naturale rende difficile coniugare chiarezza con facilità di lettura
- **Ricercare chiarezza strutturale**
	- Separazione tra requisiti funzionali e non-funzionali
	- Classificazione precisa, uniforme e accurata
- **Ricercare atomicità e aggregazione**
	- Requisiti elementari
	- Correlazioni chiare ed esplicite
### Verifica dell'analisi
- Eseguita su un documento organizzato
	- Non ripete il lavoro di analisi, ma si accerta che esso sia stato svolto in modo conforme alle attese
- Tramite **walkthrough**
	- Lettura a largo spettro
- Oppure **ispezione**
	- Lettura mirata a struttura basata su liste di controllo (**_checklist_**)
- Accertando necessità e sufficienza dei requisiti specificati
	- Esaminando la matrice delle dipendenze (*documentazione di tracciamento*)
# Stadi di progresso per SEMAT
- **Conceived**
	- Il committente è identificato e gli *stakeholder* vedono sufficienti opportunità per il progetto
- **Bounded**
	- I bisogni macro sono chiari, i meccanismi di gestione dei requisiti (configurazione e cambiamento) sono fissati
- **Coherent**
	- I requisiti sono classificati e quelli essenziali (*obbligatori*) sono chiari e ben definiti
- **Acceptable**
	- I requisiti fissati definiscono un sistema soddisfacente per gli *stakeholder*
- **Addressed**
	- Il prodotto soddisfa i principali requisiti al punto da poter meritare rilascio e rischio
- **Fulfilled**
	- Il prodotto soddisfa abbastanza requisiti da meritare la piena approvazione degli *stakeholder*

[[Progettazione software]]

