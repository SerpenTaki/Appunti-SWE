- Il concetto di **qualità** correla con quello di **valutazione**
- Si valuta per fare confronti
- O per determinare il grado di conformità alle attese
- Con destinatari diversi e punti di vista diversi
	- Chi fa
	- Chi usa
	- Chi valuta come terza parte
- Qui parliamo di <u>qualità di prodotto</u> (*software*)
### Glossario ragionato
**Qualità**: Insieme delle caratteristiche di un'entità, che ne determinano la capacità di soddisfare esigenze sia espresse che implicite
- Visioni della qualità
	- **Intrinseca:** conformità ai requisiti, idoneità all'uso
	- **Relativa:** soddisfazione del cliente
	- **Quantitativa:** misurazione oggettiva, per confronto
- Poste in carico al <u>Sistema Qualità</u> del fornitore
**Sistema Qualità:** Struttura organizzativa, responsabilità, procedure, risorse, atte al perseguimento della qualità
- Si riassume in 3 elementi
	1. Piano della Qualità
	2. Controllo di Qualità
	3. Miglioramento continuo
- Il nostro **Piano di Qualifica** li comprende tutti
**Piano della Qualità:** Le attività del Sistema Qualità mirate a fissare gli obiettivi di qualità, insieme con i processi e le risorse necessarie per conseguirli
- Visione orizzontale, trasversale all'intera organizzazione
	- Fissare le politiche aziendali per il perseguimento della qualità
- Visione verticale, specifica di prodotto/servizio
	- Fissare gli obiettivi di qualità del singolo progetto
- Basate sull'adozione di uno specifico *way of working*
	- Grado di conformità riflesso nel corrispondente cruscotto di controllo
**Controllo di Qualità:** Le attività del Sistema pianificate e attuate per assicurare che il prodotto soddisfi le attese
- Prevenire è meglio che curare...
	- Assicurare conformità passo-passo invece che solo a fine corsa
	- Attuare il *way of working*
	- Controllarne gli effetti tramite il cruscotto di controllo (modo non invasivo sulle attività)
- Questo è **_Quality Assurance_** (*accertamento di qualità*)
![[Screenshot 2024-11-29 alle 12.00.47.png]]
### Modelli della qualità SW
- Servono per uniformare punti di vista diversi
- **Sviluppo:** prospettiva del progetto
- **Uso:** prospettiva utente
- **Direzione:** costi/benefici del *way of working*
- Servono per favorire valutazione oggettiva
![[Screenshot 2024-11-29 alle 12.03.38.png]]
![[Screenshot 2024-11-29 alle 12.04.02.png]]
![[Screenshot 2024-11-29 alle 12.04.21.png]]
![[Screenshot 2024-11-29 alle 12.04.32.png]]
### Software metrics
- Any type of measurement that relates to a software system, process or documentation

| **Entity** | **Metric**           |
| ---------- | -------------------- |
| *Program*  | SLOC                 |
| *Effort*   | Person/days          |
| *Text*     | Guinning's Fog index |
- Allow quantifying  product and process attributes
- May be used to predict product attributes or to control the software process
- Product metrics can be used for general predictions or identify anomalous components.
### Assumptions on metrics
- A software property or attribute can be measured
- A relationship exists between what we can measure and what we want to know
- We only know how to measure <u>internal</u> attributes
	- *Product quality*
- But we are often more interested in <u>external</u> attributes
	- *Quality in use*
- It may be difficult to relate what can be measured to desirable external quality attributes
![[Screenshot 2024-11-29 alle 12.14.59.png]]
![[Screenshot 2024-11-29 alle 12.15.12.png]]
![[Screenshot 2024-11-29 alle 12.15.28.png]]
# Qualità di Progettazione
- Non tutti i problemi hanno una *buona* soluzione
	- Conviene essere prudenti
- A ogni scelta progettuale devono corrispondere
	- Obiettivi (della scelta)
	- Vincoli (nella scelta)
	- Alternative (alla scelta)
	- Come la soluzione risponde al problema
- Fattibilità e verificabilità sono qualità cardine della progettazione
## Qualità da ricercare
- La decomposizione modulare deve individuare componenti architetturali dotate di
	- Minimo accoppiamento
	- Massima coesione funzionale (*autosufficienza*)
- L'incapsulazione (*information hiding*) permette di nascondere il dettaglio realizzativo
	- Solo l'interfaccia è pubblica
	- Il dettaglio realizzativo è noto solo all'interno
### Controllare accoppiamento e coesione
- L'accoppiamento è indicatore dell'intensità di relazione tra parti distinte
	- La modifica di una comporta modifiche nell'altra
	- Forte accoppiamento indica cattiva modularità
- La coesione è indicatore dell'intensità di relazione all'interno di una singola parte
	- Forte coesione indica buona modularità
### Ricercare integrità concettuale
- Facilmente riconoscibile nelle architetture fisiche
	- Suggerisce adesione a uno stile uniforme
	- Coerente in tutte le parti del sistema e nelle loro interazioni
- Bilancia ricchezza funzionale con semplicità d'uso
- Desiderabile in ogni architettura di sistema
	- Anche nel *software*
- Richiede osservanza e vigilanza
	- Facilità parallelismo nella realizzazione
#### Avvertenze
- L'**astrazione** omette informazione per poter applicare operazioni simili a entità diverse
	- Ciò che è caratteristico dell'intera gerarchia è fissato in radice
	- Ciò che differenzia si aggiunge per specializzazione allontanandosi dalla radice
- L'astrazione è usabile solo tramite concretizzazione
	- Per parametrizzazione (*da template a entità concreta C++*)
	- Per specializzazione (*da interfaccia a classe in Java e C++*)
	- Per valorizzazione (*da classe a oggetto tramite costruttore in OOP*)
- La *concorrenza* di una buona qualità aiuta a decomporre il sistema in più entità autonome garantendo
	- Efficienza di esecuzione
	- Atomicità di azione
	- Consistenza e integrità dei dati condivisi
	- Semantica precisa di comunicazione e serializzazione
	- Predicibilità di ordinamento temporale
- La **distribuzione** di buona qualità ripartisce il sistema in programmi disseminati su nodi distinti garantendo
	- Bilanciamento di carico
	- Frugalità nelle comunicazioni (*buon grado di autonomia*)
- Eventi ed errori critici emergono più facilmente in presenza di concorrenza o distribuzione
	- Per evitarli servono alcune accortezze
- In relazione al flusso di controllo
	- Saper determinare l'ingresso in un particolare stato
- In relazione al trascorrere del tempo
	- Saper determinare l'arrivo di un certo istante temporale
- Mai fare assunzioni ottimistiche
# Dalla Progettazione alla Codifica
**Enforce intensions**
- Rendere chiaro *nel codice* il confine tra esterno e interno dei moduli
- Decidere chiaramente e codificare coerentemente ciò che può essere specializzato
	- Rendere il resto immodificabile (`final, const...`)
- Proteggere tutto ciò che non deve essere visto acceduto dall'esterno
	- `private, protected...`
- Decidere quali classi possono produrre istanze e quali no
	- Usare il *pattern* **Singleton** per le classi a istanza singola

>Il singleton è un [design pattern creazionale](https://it.wikipedia.org/wiki/Design_pattern#Pattern_creazionali "Design pattern") che ha lo scopo di garantire che di una determinata classe venga creata _una e una sola_ istanza, e di fornire un punto di accesso globale a tale istanza.

**Defensive programming**
- Programmare esplicitamente il trattamento dei possibili errori
- Nei dati in ingresso
	- Verificarne la legalità prima di usarli
- Nella logica funzionale
	- Preservarne proprietà (*invarianti, pre/post-condizioni,...*)
- Definire la strategia di trattamento degli errori (*error handling*) è compito della progettazione
### Gestire gli errori nei dati in ingresso
- Possibili tecniche di trattamento
	- Attendere fino all'arrivo di un valore legale
	- Assegnare un valore predefinito (*default*)
	- Usare un valore precedente
	- Registrare un valore precedente
	- Registrare l'errore in un *log* persistente
	- Sollevare una eccezione gestita
	- Abbandonare il programma

