- Rendere un sistema indipendente dall'implementazione concreta delle sue componenti
	- Si nascondono i tipi concreti delle classi realmente utilizzate
	- Si nascondono i dettagli sulla composizione e creazione
	- *Riduzione accoppiamento* e flessibilità
- Ampio uso dell'*astrazione*/Interfacce
# Singleton
- Scopo
	- Assicurare l'*esistenza* di un'*unica istanza* di una classe
	- ... ed avere un punto di accesso *globale* a questa
- Motivazione
	- Alcune entità NON DEVONO avere più di un'istanza
		- Non è possibile utilizzare una variabile globale (C++)
	- La classe deve tenere traccia della sua unica istanza
- Applicabilità
	- Deve esistere *una e una sola istanza* di una classe in tutta l'applicazione
		- L'istanza deve essere accessibile dai *client* in modo noto
	- L'istanza deve essere *estendibile* con ereditarietà
		- I *client* non devono modificare il proprio codice
![[Screenshot 2025-01-14 alle 20.19.03.png]]
- Conseguenze
	- *Controllo* completo di come e quando i *client accedono* all'interfaccia
	- Evita il proliferare di variabili globali (C++)
	- Permette la ridefinizione delle operazioni definite nel Singleton
	- Può permettere un *numero massimo* e preciso di *istanze* attive
	- Più flessibile delle operazioni di classe
		- Utilizzo del *polimorfismo*
![[Screenshot 2025-01-14 alle 20.21.36.png]]
![[Screenshot 2025-01-14 alle 20.22.02.png]]
- Implementazione
	- Assicurare un'unica istanza attiva (*lazy initialization*)
		- Si rende il/i *costruttore/i privato/i* (non accessibili)
		- Si rende disponibile un'operazione di classe di "recupero"
	- Non è possibile utilizzare variabili globali (C++)
		- Non garantisce l'unicità dell'istanza
		- L'istanza è generata durante l'inizializzazione "statica"
		- Tutti i *singleton* sarebbero costruiti sempre anche se mai utilizzati
![[Screenshot 2025-01-14 alle 20.24.26.png]]
![[Screenshot 2025-01-14 alle 20.24.37.png]]
![[Screenshot 2025-01-14 alle 20.24.46.png]]
![[Screenshot 2025-01-14 alle 20.24.54.png]]
![[Screenshot 2025-01-14 alle 20.25.04.png]]
### Builder
- Scopo
	- Separa la *costruzione* di un oggetto complesso dalla sua *rappresentazione*
- Motivazione
	- Necessità di *riutilizzare* un medesimo algoritmo di costruzione per più oggetti di tipo *differente*
	- Processo di costruzione *step-by-step*
![[Screenshot 2025-01-14 alle 20.27.08.png]]
- Applicabilità
	- La procedura di *creazione* di un oggetto complesso deve essere *indipendente* dalle *parti* che compongono l'oggetto
	- Il processo di *costruzione* deve permettere *diverse rappresentazioni* per l'oggetto da costruire
![[Screenshot 2025-01-14 alle 20.34.57.png]]
![[Screenshot 2025-01-14 alle 20.35.07.png]]
- Conseguenze
	- Facilita le modifiche alla rappresentazione interna di un prodotto
		- È sufficiente costruire un nuovo builder: NO telescoping!
	- Isola il codice dedicato alla costruzione di un prodotto dalla sua rappresentazione
		- Il client non conosce le componenti interne di un prodotto
			- *Encapsulation*
		- L'orchestrazione dei processi di costruzione è unica
	- Consente un controllo migliore del processo di costruzione
		- Costruzione *step-by-step*
		- Accentramento logica di validazione
![[Screenshot 2025-01-14 alle 20.45.10.png]]
![[Screenshot 2025-01-14 alle 20.45.24.png]]
- Implementazione
	- Il *buildier* definisce un'interfaccia per ogni parte che il director può richiedere di costruire
		- Abbastanza *generale* per la costruzione di prodotti differenti
		- Appending process
	- Nessuna classe astratta comune per i prodotti?
		- Differiscono notevolmente fra loro
			- Se simili, valutare l'utilizzo di un Abstract Factory Pattern
	- Fornire metodi vuoti come *default*
		- I buildere concreti ridefiniscono solo i metodi necessari
![[Screenshot 2025-01-14 alle 20.49.05.png]]
![[Screenshot 2025-01-14 alle 20.49.24.png]]
![[Screenshot 2025-01-14 alle 20.49.33.png]]
![[Screenshot 2025-01-14 alle 20.49.41.png]]
# Abstract Factory
- Scopo
	- Fornire un'interfaccia per creare famiglie di prodotti senza specificare classi concrete
- Motivazione
	- Applicazione configurabile con diverse famiglie di componenti
	- Si definisce una classe astratta *factory* che definisce le interfacce di creazione
		- I client non costruiscono direttamente i prodotti
	- Si definiscono le interfacce degli oggetti da creare
	- Le classi che concretizzano *factory* vengono *costruite* una *sola volta*
- Applicabilità
	- Un sistema *indipendente* da come i *componenti* sono creati, composti e rappresentati
	- Un sistema *configurabile* con più famiglie prodotti
	- Le *componenti* di una famiglia DEVONO essere *utilizzate insieme*
	- Si vuole fornire una libreria di classi prodotto senza rivelarne l'implementazione
![[Screenshot 2025-01-14 alle 20.56.14.png]]
- Conseguenza
	- Isolamento dei tipi concreti
		- I client manipolano unicamente interfacce, i nomi dei prodotti sono nascosti
	- Semplicità maggiore nell'utilizzo di una diversa famiglia di prodotti
		- La factory concreta appare solo una volta nel programma
	- Promuove la consistenza fra prodotti
	- Difficoltà nel supportare nuovi prodotti
		- Modificare l'interfaccia della factory astratta costringe il cambiamento di tutte le sotto classi
![[Screenshot 2025-01-14 alle 20.58.27.png]]
![[Screenshot 2025-01-14 alle 20.58.42.png]]
![[Screenshot 2025-01-14 alle 20.59.21.png]]
![[Screenshot 2025-01-14 alle 20.59.30.png]]
- Implementazione
	- Solitamente si necessita di una sola istanza della factory (singleton design pattern)
	- Definizione di factory estendibili
		- Aggiungere un parametro ai metodi di creazione dei prodotti
			- Il parametro specifica il tipo di prodotto
			- Nei linguaggi tipizzati staticamente è possibile solo se tutti i prodotti condividono la stessa interfaccia
			- Può obbligare a *down cast* pericolosi...
