- Pattern *architetturale*
	- Inizialmente utilizzato per GUI Smalltalk-80
- Contesto di utilizzo
	- *Applicazioni* che devono *presentare* attraverso una UI un insieme di *informazioni*
		- Le informazioni devono essere costantemente aggiornate
	- *Separation of concerns*
		- Le persone responsabili dello *sviluppo* hanno. *competenze* differenti
### Problema
- Supporto a diverse *tipologie* di utenti con diverse *interfacce*
	- Rischio di duplicazione del codice ("*cut and paste*")
![[Screenshot 2025-01-14 alle 19.02.49.png]]
## Necessità
- **Accesso** ai dati attraverso "*viste*" differenti
- I *dati* devono poter essere *modificati* attraverso interazioni differenti con i client
- Il supporto a diverse viste non deve influire sulle componenti che forniscono le funzionalità base.
### Soluzione e Struttura
- *Disaccoppiamento* (separation of concerns)
	- **model**: dati di business e regole di accesso
	- **view**: rappresentazione grafica
	- **controller**: reazione della UI agli *input* utente (*application logic*)
![[Screenshot 2025-01-14 alle 19.12.28.png]]
##### Model
- Definisce il modello dati
	- Realizza la *business logic*
	- Dati e le operazioni su questi
- Progettato mediante tecniche *object oriented*
	- Design pattern
- Notifica alla *view* aggiornamenti del modello dati
	- *Observer pattern*
	- *View* deve visualizzare sempre dati aggiornati!
##### View
- Gestisce la *logica di presentazione* verso i vari utenti
	- Metodi di interazione con l'applicazione
- Cattura gli input utente e *delega* al *controller* l'elaborazione
- Aggiornamento
	- "**push model**"
		- La view deve essere *costantemente* aggiornata
			- Utilizzo *design pattern Observer*
			- MVC in un solo ambiente di esecuzione
	- "**pull model**"
		- La *view* richiede *aggiornamenti* solo quando è *opportuno*
		- MVC su diversi ambienti di esecuzione
			- Strategia JEE (JSP, Servlet) classico, Spring, Play!,....
##### Controller
- *Trasforma* le interazioni utente (*view*) in azioni sui dati (*model*)
	- Realizza l'*application logic*
	- Esiste un Controller per ogni view
	- Design pattern *Strategy*
		- Modifica degli algoritmi che permettono l'interazione utente con il *model*
### Strategie
- Nativo (*push model*)
	- *Web based (single page application)*
		- View: Javascript e template
		- Controller: Javascript (routing)
		- Model: Javascript
			- Sincronizzazione con backend tramite API REST/SOAP
- Web based (*server, pull model*)
	- View: JSP, ASP,...
	- Controller: Servlet
		- Una sola servlet come controller (Front Controller pattern)
	- Model: EJB / Hibernate / MyBatis
![[Screenshot 2025-01-14 alle 19.24.23.png]]
![[Screenshot 2025-01-14 alle 19.24.33.png]]
![[Screenshot 2025-01-14 alle 19.24.44.png]]
# Conseguenze
- Riuso dei componenti dei model
	- Riutilizzo dello stesso model da parte di differenti view
	- Miglior manutenzione e processo di test
- Supporto più semplice per nuovi tipi di client
	- Creazione nuova view e controller
- Maggiore complessità di progettazione
	- Introduzione molte classi per garantire la separazione
#### Esempio Pull Model: SPRING MVC
- Componente per lo sviluppo di applicazione *web*
	- Model
		- *service* classes: layer della logica di business del sistema
	- View
		- Layer di visualizzazione/presentazione dati
		- Utilizza la tecnologia JSP e Tag library
	- Controller
		- Layer che gestisce/controlla flussi e comunicazione
			- Dispacher delle richieste (Front controller)
			- Controller che implementano la logica applicativa
	- <u>Pull model</u> MVC
![[Screenshot 2025-01-14 alle 19.31.01.png]]
![[Screenshot 2025-01-14 alle 19.31.12.png]]
![[Screenshot 2025-01-14 alle 19.31.21.png]]
![[Screenshot 2025-01-14 alle 19.31.29.png]]
![[Screenshot 2025-01-14 alle 19.31.39.png]]
![[Screenshot 2025-01-14 alle 19.31.52.png]]
![[Screenshot 2025-01-14 alle 19.32.01.png]]
![[Screenshot 2025-01-14 alle 19.32.10.png]]
### Esempio Push Model: BACKBONE
![[Screenshot 2025-01-14 alle 19.32.37.png]]
![[Screenshot 2025-01-14 alle 19.32.46.png]]
![[Screenshot 2025-01-14 alle 19.32.57.png]]
## Model View Presenter
- Presenter (*passive view*)
	- Man in the middle
	- Osserva il modello
	- View business logic
	- Aggiorna e osserva la vista (*dumb*)
		- Interfaccia di comunicazione
			- Metodi *setter* e *getter* per il recupero dei dati
- View
	- Si riduce ad un *template* di visualizzazione e ad un'*interfaccia* di comunicazione
		- Può essere sostituita da un *mock* in fase di test
		- In JS si espone un *protocollo*
![[Screenshot 2025-01-14 alle 19.49.26.png]]
- Separazione sviluppo UI della *business logic*
- ViewModel
	- *Proiezione* del modello per una vista
		- Solamente la validazione rimane nel modello
	- *Binding* con la vista e il modello
		- Dati e operazioni che possono essere eseguiti su una UI
- View
	- *Dichiarativa* (utilizzando linguaggi di markup)
	- *Two-way data-binding* con proprietà del ViewModel
	- Non possiede più lo *stato* dell'applicazione
![[Screenshot 2025-01-14 alle 19.54.06.png]]
![[Screenshot 2025-01-14 alle 19.54.38.png]]
![[Screenshot 2025-01-14 alle 19.54.48.png]]
![[Screenshot 2025-01-14 alle 19.54.57.png]]
![[Screenshot 2025-01-14 alle 19.55.06.png]]
![[Screenshot 2025-01-14 alle 19.55.16.png]]
![[Screenshot 2025-01-14 alle 19.55.26.png]]
![[Screenshot 2025-01-14 alle 19.55.35.png]]
![[Screenshot 2025-01-14 alle 19.55.43.png]]
![[Screenshot 2025-01-14 alle 19.55.52.png]]
![[Screenshot 2025-01-14 alle 19.56.02.png]]
