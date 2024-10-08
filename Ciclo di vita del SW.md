*Sistematico*: non importa chi fa le cose l'importante è che ognuno le faccia allo stesso modo, in questo caso seguendo un *way of working*. Tutti fanno le cose in modo deciso
*Disciplinato*:  Tutti fanno le cose allo *stato dell'arte*
*Quantificabile*: Dobbiamo fare le cose e averne un dato 
##### Il concetto di ciclo di vita
- *Concezione* -> *sviluppo* -> Utilizzo -> Ritiro
- La transizione tra stati avviene per azione di processi di ciclo di vita
- Compito di un progetto è far progredire lo stato di avanzamento di un prodotto SW lungo il suo ciclo di vita
- Per farlo il progetto mobilità delle attività di specifici processi
	- Attività che ordiniamo in funzione delle dipendenze tra i loro ingressi e le loro uscite
	- Fissando così i criteri di loro attivazione e di completamento
- Chiamiamo **fase** il tempo di stazionamento in un singolo stato di ciclo di vita o in una singola transizione tra stati.
	- Essa designa uno stato consistente, entro un dato segmento temporale
	- Per questo *fase* non è vero sinonimo di *attività*
- Esistono molteplici cicli di vita che differiscono tra loro per transizioni tra stati e regole di attivazione
	- Per distinguere tra loro ne idealizziamo le caratteristiche in *modelli* di ciclo di vita
- Aderire a un particolare modello di ciclo di vita comporta vincoli sulla pianificazione e gestione del corrispondente progetto
	- Questo influenza il proprio *way of working* e i suoi strumenti di supporto
- In questo corso, ci occupiamo di **modelli di sviluppo** SW
### Modello
- Insieme di specifiche che descrivono un fenomeno di interesse (*astratto o concreto*)
	- In modo che non dipende dall'osservatore
	- Dimostrato corretto, empiricamente o per teorema
- I modelli aiutano a studiare, comprendere, misurare e trasformare l'oggetto di interesse
	- Il modello specifica *cosa* quell'oggetto sia
	- L'architettura (*design*) specifica <u>come</u> esso funzioni
	- L'analisi (*del modello*) spiega <u>perchè</u> quell'oggetto fa quel che fa nel modo in cui lo fa
*Esempio modello SDLC* -> un modello che non contempla il *ritiro*
- Lo stadio di *evoluzione* innesca nuovi attraversamenti di ciclo
##### Modelli di sviluppo
- Alle origini vi fu solo il *non-modello* Code-'n-fix 
	- *Cowboy coding*
- Attività senza organizzazione comprensibile dall'esterno
	- L'esatto contrario di sistematico, disciplinato, quantificabile, che sono le quantità distintive dell'applicazione dell'Ingegneria del Software
- Questo porto la crisi del SW, che porto alla nascita di SWE
- Ne nacque una successione di modelli organizzati

| **Modello**  | **Tratti caratteristici**                                         |
| ------------ | ----------------------------------------------------------------- |
| Cascata      | Rigide fasi sequenziali                                           |
| Incrementale | realizzazione in più passi                                        |
| A componenti | Orientato al riuso                                                |
| Agile        | Altamente dinamico, fatto di brevi cicli iterativi e incrementali |
- **Iterazione**: raffinamenti o rivisitazione (*distruttivo*)
	- *come la pittura che aggiunge o copre*
- **Incremento**: aggiunte successive ad un impianto base (*costruttivo*)
	- *come la scultura, che opera per sottrazione, in una sola direzione*
- **Prototipo**: provare a scegliere soluzioni
	- *Usa e getta o per incrementi*
- **Riuso** *Se voglio usare cose mi devo piegare io non il codice altrimenti mi conviene rifare*
	- Copia-incolla opportunistico (_occasionale_)
		- *basso costo, scarso impatto*
	- Sistematico (*per progetto / famiglia di prodotti / ogni prodotto*)
		- *Maggior costo di adozione, maggior impatto*
# Modello sequenziale (a cascata)
*centrato sull'idea di <u>processi ripetibili</u>*
- Successioni di *fasi* <u>rigidamente sequenziali</u>
	- Non ammette ritorno a fasi precedenti: eventi eccezionali riportano all'inizio
	- Le iterazioni costano troppo: non sono viste come buon mezzo di mitigazione delle incertezze di sviluppo
	- Qui e solo qui possiamo parlare compiutamente di *fasi*
- Prodotti
	- Principalmente <u>documenti</u>, fino poi a includere il software
- L'ingresso in uno stato di avanzamento è vincolato da <u>pre-condizioni</u> (_gate_)
	- Che devono essere soddisfatte dalle <u>post-condizioni</u>  delle transizioni di ingresso
- In questo modello il progetto è una successione di fasi distinte, non sovrapposte nel tempo
- È stato usato per lo sviluppo di sistemi complessi, organizzati in *catene di fornitura*
	- E quindi sopratutto per ragioni organizzative
- Ogni fase (*stato/transizione*) viene definita da:
	- Attività previste e prodotti attesi in ingresso e in uscita
	- Contenuti e struttura di documenti che descrivono lo stato raggiunto e le attività svolte
	- Responsabilità e ruoli coinvolti nelle attività
	- Scadenze di consegna dei prodotti
- Entrare, uscire, stazionare in una fase comporta lo svolgimento di determinate azioni
	- Realizzate come attività di specifici processi
![[Screenshot 2024-10-08 alle 11.47.15.png]]
Cr