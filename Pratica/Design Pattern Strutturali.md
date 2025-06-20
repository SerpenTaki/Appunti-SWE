Mo- Affrontare problemi che riguardano la *composizione* di *classi* e *oggetti*
- Consentire il *ri-utilizzo* degli *oggetti esistenti* fornendo agli utilizzatori un'interfaccia più adatta
	- Integrazioni fra librerie/componenti diverse
- Sfruttano l'*ereditarietà* e l'*aggregazione*
## Adapter
**Scopo**-> *Convertire* l'interfaccia di una classe in un'altra
Motivazione:
- Spesso i toolkit non sono riusabili
	- Non è corretto (e possibile) modificare i toolkit!
- Definiamo una *classe* (adapter) che *adatti* le *interfacce*
	- Per ereditarietà o per composizione
	- La classe *adapter* può fornire funzionalità che la classe adattata non possiede
**Applicabilità**
- *Riutilizzo di una classe esistente*, non è conforme all'interfaccia target
- Creazione di classi *riusabili* anche con classi non ancora analizzate o viste
- Non è possibile adattare l'interfaccia attraverso ereditarietà (*Object adapter*)
![[Screenshot 2025-01-15 alle 12.27.55.png]]
**Conseguenze**
- Class adapter
	- *Non funziona* quando bisogna adattare una classe e le sue *sottoclassi*
	- Permette all'Adapter di modificare alcune caratteristiche dell'Adaptee
- Object adapter
	- Permette ad un Adapter di *adattare più tipi* (Adaptee e le sue sottoclassi)
	- Non permette di modificare le caratteristiche dell'Adaptee
	- Un oggetto *adapter* non è sottotipo dell'*adaptee*
![[Screenshot 2025-01-15 alle 12.30.40.png]]
![[Screenshot 2025-01-15 alle 12.31.00.png]]
![[Screenshot 2025-01-15 alle 12.31.13.png]]
![[Screenshot 2025-01-15 alle 12.31.36.png]]
![[Screenshot 2025-01-15 alle 12.31.46.png]]
**Implementazione**
- Individuare *l'insieme minimo di funzioni (narrow)* da adattare
	- Più semplice da implementare e manutenere
	- Utilizzo di operazioni astratte
- Diverse varianti strutturali alternative
	- (Client - Target) + Adapter
	- Client + Target + Adapter
## Decorator
**Scopo**
- Aggiungere responsabilità ad un <u>oggetto</u> *dinamicamente*
**Motivazione**
- Il *__Decorator__ ingloba* un componente in un altro oggetto che *aggiunge* la funzionalità
	- Il *subclassing* non può essere sempre utilizzato
	- Funzionalità aggiunte *prima* o *dopo* l'originale
**Applicabilità**
- Aggiungere funzionalità *dinamicamente* ad un oggetto in modo *trasparente*
- Funzionalità possono essere circoscritte
- Estensione via *subclassing* non è possibile
	- Eslosione del numero di sottoclassi
	- Non disponibilità della classe al *subclassing*
![[Screenshot 2025-01-15 alle 13.20.37.png]]
![[Screenshot 2025-01-15 alle 13.24.15.png]]
**Conseguenze**
- Maggiore *flessibilità* della derivazione statica
- *Evita* classi "*agglomerati* di  funzionalità" in posizioni alte della gerarchia
	- Le classi componenti diventano più semplici
	- *Software as a Service* (SaaS)
- Il decoratore e le componenti non sono uguali
	- Non usare nel caso in cui la funzionalità si basi sull'identità
- *Proliferazione* di *piccole classi* simili
	- Facili da personalizzare, ma difficili da comprendere e testare
![[Screenshot 2025-01-15 alle 13.29.13.png]]
![[Screenshot 2025-01-15 alle 13.29.52.png]]
![[Screenshot 2025-01-15 alle 13.30.07.png]]
![[Screenshot 2025-01-15 alle 13.30.16.png]]
**Implementazione**
- Interfaccia del decoratore DEVE essere conforme a quella del componente
- Omissione della classe astratta del decoratore
- Mantenere "*leggera*" (stateless) l'*implementazione* del Component
- Modifica della "pelle" o della "pancia"?
	- Decorator: quando le componenti sono "leggere"
	- Strategy: quando le componenti hanno una corposa implementazione
		- Evita decoratori troppo "costosi" da manutenere
## Facade
**Scopo**
- Fornire un'interfaccia unica e semplice per un sottosistema complesso
**Motivazione**
- Strutturazione di un sistema in sottosistemi
	- Diminuisce la complessità del sistema, ma aumenta le dipendenze tra sottosistemi
- L'utilizzo di un *Facade semplifica* queste *dipendenze*
	- Ma non nasconde le funzionalità *low-level*
![[Screenshot 2025-01-15 alle 13.38.02.png]]
**Applicabilità**
- Necessità di una singola interfaccia semplice
	- Design pattern tendono a generare tante piccole classi
	- Vista di default di un sottosistema
- *Disaccoppiamento tra sottosistemi e client*
	- Nasconde i livelli fra l'astrazione e l'implementazione
- *Stratificazione di un sistema*
	- Architettura *Three tier*
![[Screenshot 2025-01-15 alle 13.40.06.png]]
![[Screenshot 2025-01-15 alle 13.40.15.png]]
**Conseguenze**
- *Riduce* il *numero* di classi del sottosistema con cui il client deve *interagire*
- Realizza un *accoppiamento lasco* tra i sottoinsiemie i client
	- Eliminazione delle dipendenze circolari
	- Aiuta a *ridurre i tempi di compilazione* e di building
- Non nasconde completamente le componenti di un sottosistema
- *Single point of failure*
- *Sovradimensionamento* della classe Facade
![[Screenshot 2025-01-15 alle 13.43.35.png]]
![[Screenshot 2025-01-15 alle 13.43.48.png]]
![[Screenshot 2025-01-15 alle 13.43.57.png]]
**Implementazione**
- Classe Facade come classe astratta
	- Una classe concreta per ogni "vista" (implementazione) del sottosistema
- Gestione di classi da più sottosistemi
- Definizione d'*interfacce "pubbliche"* e *"private"*
	- Facade nasconde l'interfaccia "privata"
		- Module *pattern* in JavaScript
- *Singleton pattern*: una sola istanza del Facade
## Proxy
**Scopo**
- Fornire un *surrogato* di un altro oggetto di cui si vuole controllare l'accesso
**Motivazione**
- Rinviare il costo di creazione di un oggetto all'effettivo utilizzo (*on demand*)
- Il proxy agisce come l'oggetto che ingloba
	- Stessa interfaccia
- Le *funzionalità* dell'oggetto "inglobato" vengono accedute *attraverso il proxy*
	- ... o senza l'accesso vero e proprio (virtual proxy)
**Applicabilità**
- Remote Proxy
	- *Rappresentazione locale* di un oggetto che si trova in uno spazio di indirizzi differente
		- Classi stub in Java RMI
- Virtual Proxy
	- Creazione di oggetti complessi *on-demand*
- Protection proxy
	- *Controllo degli accessi* (diritti) all'oggetto originale
- Puntatore "intelligente"
	- Gestione della memoria in Objective-C
![[Screenshot 2025-01-15 alle 14.09.59.png]]
**Conseguenze**
- Introduce un *livello di indirezione* che può essere "farcito"
- *Copy-on-write*
	- La copia di un oggetto viene eseguita unicamente quando la copia viene modificata

| Remote Proxy     | nasconde dove un oggetto risiede             |
| ---------------- | -------------------------------------------- |
| Virtual Proxy    | Effettua delle ottimizzazioni                |
| Protection Proxy | Definisce ruoli di accesso alle informazioni |
![[Screenshot 2025-01-15 alle 14.13.54.png]]
**Implementazione**
- Implementazione "a puntatore"
	- Overload operatore `->` e `*` in C++
- Alcuni proxy, invece, agiscono in modo differente rispetto alle operazioni
	- In Java costruzione tramite *reflection*
- Proxy per più tipi...
	- ... *subject* è una classe astratta ...
	- ... ma non se il proxy deve istanziare il tipo concreto
- Rappresentazione del *subject* nel *proxy*
