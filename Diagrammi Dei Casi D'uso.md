- **Rappresentazione grafica** dei casi d'uso
	- Mette in evidenza attori e servizi del sistema
	- Grafo i cui nodi sono
		- *Attori*
		- *Use case*
	- Archi del grafo rappresentano
		- La *comunicazione* tra gli attori e gli *use case*
		- I legami tra gli *use case*
			- Relazione di estensione 
			- Relazione di inclusione
			- Relazione di generalizzazione
	- Il diagramma individua i *confini del sistema* nello scenario
# Cosa sono gli Use Case
- **Tecniche** per individuare i *requisiti funzionali*
	- Descrivono *interazioni*
		- Sistema
		- Utenti (attori)/elementi esterni al sistema
	- Come il sistema deve essere utilizzato?
		- Che funzionalità espone?
- **Scenari**
	- Sequenza di passi che descrivono interazioni
		- Attori (utenti) e il sistema
	- Rappresentazione di una *possibilità*
		- Scenari *alternativi*
		- *esempio: la carta di credito non è accettata, il cliente è abituale e il suo profilo è già presente nel sistema...*
	- Tutti gli scenari (*principale e alternativo*) condividono uno *scopo*
- Definizione
	- Un **caso d'uso** è un insieme di **scenari** (*sequenze di azioni*) che hanno in comune uno scopo finale (*obiettivo*) per un utente (*attore*).
	- **Informale**
		- *Un caso d'uso è una situazione nella quale il sistema viene utilizzato per soddisfare uno o più bisogno dell'utente*
	- Descrivono l'insieme di funzionalità del sistema come sono percepite dagli utenti 
		- Visione esterna del sistema
		- Nessun dettaglio implementativo
- Attori
	- **Ruolo** dell'utente nell'interazione con il sistema
		- Utente: persona, altro sistema esterno
		- Utente "fisico" -> più ruoli (attori)
		- Più utenti -> medesimo ruolo (attore)
	- Svolgono il caso d'uso per raggiungere l'*obiettivo*
		- Stesso attore -> più casi d'uso
		- Un caso d'uso -> più attori
	- Buon mezzo di individuazione dei casi d'uso
		1. Individuare la lista degli attori
		2. Comprendere i loro obiettivi e come interagiscono con il sistema (*quale ruolo a quale funzionalità*)
	- Nessun dettaglio implementativo sui modi di interazione!
## Specifica Use Case
- *Use Case* sono puro TESTO
	- UML descrive solo gli *use case diagram*
		- Specificano l'interazione tra i casi d'uso
![[Screenshot 2024-10-21 alle 19.07.58.png]]
- Il valore aggiunto è nel *contenuto testuale*
	- *NOME/Identificatore*
	- scenario principale
	- scenari alternativi
		- D'eccezione o errore
	- Pre-condizioni
	- Effetti/Garanzia(*post-condizioni*)
	- Trigger
		- Evento scatenante del caso d'uso
	- Attori principali
	- Attori secondari
- Considerazioni
	- Un solo *scenario principale* per caso d'uso
	- Scenari alternativi $(0..*)$
		- Prendono in considerazioni solo la parte che differisce dallo scenario principale
	- **Granularità**
		- Soddisfa lo scopo di un attore(fare un ordine...)
			- Più piccolo di un processo di *business*
				- Non fornisce dettagli significativi, ma individua le funzionalità del sistema
				- *Kite level*
			- Più grande di una singola operazione su un componente
				- Dettaglio eccessivo allontana il focus dalll'obiettivo
				- *Sea level, Fish level*
# Componenti di un diagramma *use case*
![[Screenshot 2024-10-21 alle 19.17.43.png]]
![[Screenshot 2024-10-21 alle 19.17.56.png]]
![[Screenshot 2024-10-21 alle 19.18.46.png]]
## Use case: Inclusione
- Funzionalità *comune* fra più *use case*
![[Screenshot 2024-10-21 alle 19.19.36.png]]
- Ogni istanza di A esegue B
	- B è incodizionatamente incluso nell'esecuzione di A
		- A non conosce i dettagli di B, ma solo i suoi risultati
		- B non conosce di essere incluso da A
		- Responsabilità esecuzione di B è completamente di A
- Evita la ripetizione/Aumenta il *riutilizzo*
![[Screenshot 2024-10-21 alle 19.21.44.png]]
## Use Case: Estensione
- **Aumento** delle funzionalità di un *use case*
![[Screenshot 2024-10-21 alle 19.26.38.png]]
- Ogni istanza di A esegue B in modo *condizionato*
	- L'esecuzione di B <u>interrompe</u> A
	- La *responsabilità* dei casi di estensione è *di chi estende* B
- <u>Non rappresenta l'ereditarietà nei linguaggi di programmazione</u>
- Estensione
	- Condizione di estensione
		- Determina quando l'estensione deve essere utilizzata
		- Descrizione narrativa e/o icona dello *use case*
		- La condizione di estensione è verificata
	- Può esistere indipendentemente dagli *use case* estesi
		- Può estendere più *use case* base (**riuso**)
	- Attenzione al *perimetro* del caso d'uso esteso
		- Modifica scenario principale / post condizione
	- Esempio: gestione dei casi di eccezione.
![[Screenshot 2024-10-21 alle 19.42.30.png]]
# Inclusione e Estensione
- Aspetti in comune
	- **Fattorizzano** comportamenti più comuni a più *use case*
	- **Aumentano** il comportamento di un *use case* base
- Differenze
	- Estensione: l'attore può non eseguire tutte le estensioni
		- Condizioni non verificate
	- Inclusione: l'attore esegue sempre tutte le inclusioni
- Casi di utilizzo
	- Inclusione: una funzionalità si *ripete* in più *use case*
	- Estensione: si vogliono descrivere *variazioni* dalla funzionalità standard
## Generalizzazione
- *Aggiungere o modificare* caratteristiche base
	- Attori
		- A è generalizzazione di B se B *condivide alemno le funzionlità di A*
![[Screenshot 2024-10-21 alle 19.46.20.png]]
- **_Use case_** (raro)
	- I casi d'uso figli possono *aggiungere* funzionalità rispetto ai padri o modificarne il comportamento
		- Tutte le funzionalità non ridefinite nel figlio si mantengono in questo come definite nel padre
![[Screenshot 2024-10-21 alle 19.47.47.png]]
![[Screenshot 2024-10-21 alle 19.48.12.png]]
# Individuazione Use Case
- Definizione del contesto
	1. Identificazione *attori* e *responsabilità*
	2. Identificazione degli *obiettivi* da raggiungere per ciascun attore
		- Primi approssimazione _use case_
	3. Valutare attori e _use case_ e raffinarli
		- Divisione e accorpamento
	4. Trovare le relazioni di inclusione
	5. Trovare le relazioni di estensione
	6. Trovare le relazioni di generalizzazione
- Fino a che livello di dettaglio spingersi?
	- **Kite level**
		- Livello molto astratto, definisce *macro* funzionalità
	- **Sea level**
		- Livello intermedio, utile nella scoperta di funzionalità *nascoste*
	- **Fish level**
		- Livello di dettaglio, da esso si individuano direttamente i *requisiti* del sistema
