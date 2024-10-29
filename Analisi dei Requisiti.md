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
- I **diagrammi dei casi d'uso** hanno questa prospettiva
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