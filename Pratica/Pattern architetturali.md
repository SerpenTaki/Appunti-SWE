Le applicazioni prive di un'architettura formale sono generalmente accoppiate, fragili, difficili da modificare.
- I moduli danno luogo a una collezione non organizzata.
- *Big ball of mud* Antipattern
- Problemi di distribuzione e manutenzione
	- L'architettura è scalabile? come risponde ai cambiamenti? Quali sono le caratteristiche di distribuzione?
*Modelli di architettura*
- Aiuta a gestire questi aspetti, conoscendone le caratteristiche, i punti di forza e di debolezza
# Layered Architecture
- La più comune
	- *N-tier* architecture pattern
	- Standard *de facto* per la maggior parte delle applicazioni JEE
		- Conosciuta dalla maggior parte degli architetti e sviluppatori
	- Riflette l'*organizzazione* e la struttura di molte aziende
- I componenti sono organizzati in *layer orizzontali*
	- Ogni livello svolge un ruolo singolo e specifico.
	- Di solito i livelli sono 4
		- *Presentation, Business, Persistence, Database*
![[Screenshot 2024-12-02 alle 11.14.46.png]]
## Separation of Concerns
- Ogni livello costituisce un'*astrazione* su una particolare richiesta aziendale
	- I componenti all' interno di uno specifico livello si occupano solo di logica che riguarda quel livello
- La classificazione dei componenti semplifica la costruzione di modelli di ruoli e responsabilità efficaci
	- Gli ambiti limitati dei componenti facilitano lo sviluppo, il test e la gestione, il governo e la manutentibilità di tali applicazioni
- Interfacce dei componenti ben definite
### Concetti chiave
- I livelli devono essere chiusi (*layer isolation*)
	- Una richiesta di spostamento da un livello ad un altro livello immediatamente sotto di esso
	- Le modifiche apportate in un livello generalmente non hanno impatto o componenti di altri livelli
- Anche i livelli possono essere apreti
	- Immaginate un livello di servizio sotto il livello business dovrebbe passare attraverso il livello di servizio per accedere al livello di persistenza
		- I livelli aperti dovrebbero essere ben documentati
![[Screenshot 2024-12-02 alle 12.25.51.png]]
![[Screenshot 2024-12-02 alle 12.26.06.png]]
- Un buon punto di partenza per molte applicazioni
	- È un solido modello per uso generale
- **L'architettura _sinkhole anti-pattern_**
	- le richieste fluiscono attraverso più livelli come semplici pass-throug
	- Proporzione di 80-20 di percorsi buoni rispetto a *wrt sinkhole path*
- Tende a prestarsi ad applicazioni *monolitiche*
	- Potrebbe essere un problema in termini di distribuzione, robustezza e affidabilità.
![[Screenshot 2024-12-02 alle 12.31.17.png]]
# Microservices Architecture
- Un pattern in continua evoluzione
	- Un alternativa valida al *monolite* ed architetture *service-oriented*
	- Unità distribuita separatamente
		- Distribuzione più semplice, maggiore scalabilità, elevato grado di disaccoppiamento.
- Componenti di un servizio
	- Da un singolo modulo a una grande porzione di applicazione
		- Scegliere il giusto livello di granularità dei componenti del servizio è una delle maggiori sfide
	- **Distribuito:** _remote access protocol_
		- `JMS, AMQP, REST, SOAP, RMI,..`
## EVOLUTIONARTY PATHS
- Evoluto da problemi associati ad altre architetture
	- Dal *monolitico*: aperto a *continous delivery*
		- Evitare i cicli di *deployment mensili* a causa dello stretto accoppiamento tra i componenti 
		- Ogni componente del servizio è sviluppato, testato e distribuito in modo indipendente e distribuito
	- Da SOA: *semplificazione* della nozione di servizio
	- La SOA è un modello potente, che promette di allineare gli obiettivi di business obiettivi aziendali con le capacità IT
	- Costoso, onnipresente, difficile da comprendere/implementare
	- Elimina le esigenze di orchestrazione, limitandosi alla connettività
![[Screenshot 2024-12-02 alle 15.05.55.png]]
![[Screenshot 2024-12-02 alle 15.06.09.png]]
![[Screenshot 2024-12-02 alle 15.06.17.png]]
![[Screenshot 2024-12-02 alle 15.06.36.png]]
## API REST-Based Topology
- Utile per is siti web che offrono piccoli servizi
	- I componenti del servizio sono a grana fine
		- Funzione aziendale specifica, indipendente dal resto
			- Uno o 2 moduli
		- *Microservizi*
- Questi servizi sono acceduti tramite API
	- REST-based interface
		- Livello API basato sul web distribuito separatamente
		- Google, Amazon, Yahoo cloud-based RESTful web service
![[Screenshot 2024-12-02 alle 15.11.38.png]]
- Accesso diretto da client fat / web based
	- L'interfaccia utente viene distribuita separatamente
	- Interfaccia basata su REST
		- Non è necessario uno strato API intermedio
- Più grandi e a grana grossa
	- Rappresentano una piccola parte dell'applicazione aziendale complessiva
		- Comune per le applicazioni aziendali di piccole e medie dimensioni
![[Screenshot 2024-12-02 alle 15.13.25.png]]
## Centralized Message Topology
- Broker di messaggi centralizzato e leggeto
	- Nessuna trasformazione orchestrazione o instradamento complesso
		- Da non confondere con le applicazioni orientate ai servizi
	- Non è richiesto un accesso basato su REST
	- Si trova nelle applicazioni aziendali  più grandi
- Controllo sofisticato del livello di trasporto
	- Meccanismi avanzati di accodamento, messaggistica asincrona, monitoraggio, gestione degli errori...
		- Evitare il singolo punto di guasto e il collo di bottiglia architettonico
![[Screenshot 2024-12-02 alle 15.25.46.png]]
### Services Granularity
- La sfida principale consiste nel definire la giusta *granularità* dei componenti del servizio
	- Servizi a grana grossa 
		- non sono facili da distribuire, scalare, testare e non sono a coppia libera
	- Servizi a grana troppo-fine
		- Richiedono un'orchestrazione trasformandosi in un'applicazione SOA
		- Richiedono una comunicazione interservizi per elaborare una singola richiesta
- Usare la comunicazione con il *database*
	- Evitare la comunicazione `service-to-service`
- Violazione del principio DRY
	- Replicare alcune funzionalità per mantenere l'indipendenza tra i vari servizi
		- Nessuna condivisione della logica di business
- È il pattern giusto per la vostra architettura?
	- NO, se non riuscite a evitare l'orchestrazione dei componenti dei servizi.
	- Nessuna definizione di unità di lavoro transazionale
		- A causa della natura distribuita del pattern
		- L'uso del framework delle transazioni aggiunge troppa complessità
##### Considerazioni
- Robustezza, migliore scalabilità, fornitura continua
	- Componente applicativo di dimensioni ridotte, distribuito separatamente
		- Risolve molti problemi delle architetture monolitiche e SOA
- Distribuzioni di produzione in tempo reale
	- È possibile distribuire solo i componenti di servizio modificati
		- Reindirizzamento a una pagina di errore/di attesa
		- Disponibilità continua (*hotdeploy*)
- Problemi di architettura distribuita
	- Creazione e manutenzione di contratti, disponibilità del sistema remoto, autenticazione dell'accesso remoto, ...
![[Screenshot 2024-12-02 alle 15.33.39.png]]
![[Screenshot 2024-12-02 alle 15.33.51.png]]
![[Screenshot 2024-12-02 alle 15.34.17.png]]
