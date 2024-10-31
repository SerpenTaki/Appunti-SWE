Indicano la **Specifica Tecnica** e di conseguenza *definiscono un prodotto*
![[Screenshot 2024-10-30 alle 17.36.40.png]]
- Descrizione del *tipo degli oggetti* che fa parte di un sistema
	- *Relazioni statiche* fra i tipi degli oggetti
![[Screenshot 2024-10-30 alle 17.37.38.png]]
# proprietà di una classe
- Caratteristiche *strutturali*
	- Attributo
		- Visibilità `+` pubblica, `-` privata, `#` protetta
`Visibilità nome : tipo [molteplicità] = default {proprietà aggiuntive}` *definizione* 

- Associazione
	- *linea continua* e orientata fra 2 classi
	- Molteplicità
		- Quanti oggetti possono far parte dell'associazione
			- 1, 0...1, 0...* , * , ...
	- Spesso *interscambiabile* con un attributo
![[Screenshot 2024-10-30 alle 17.42.07.png]]
![[Screenshot 2024-10-30 alle 17.42.26.png]]
![[Screenshot 2024-10-30 alle 17.42.42.png]]
### Nei linguaggi di programmazione
- **Attributi**
	- *Membri di classe* (privati, se possibili)
	- Proprietà aggiuntive
		- Se *ordered*: Array o vettori
		- Se *unordered*: insiemi
	- Convenzioni dei gruppi di programmazione
		- Esempio: *Getter e Setter* per ogni attributo
- **Associazioni**
	- Anche se etichettata con verbo, meglio *renderla* con un *nome*
	- *Evitare* le associazioni *bidirezionali*
		- Di chi è la responsabilità di aggiornare la relazione?
![[Screenshot 2024-10-30 alle 17.48.44.png]]
# Operazioni
- Le *azioni* che la classe "sa *eseguire*"
	- Aspetto *comportamentale*
	- *Servizio* che può essere richiesto ad ogni istanza della classe
	- Direzione: **in, out, inout** (default **in**)
	- Visibilità: `+` pubblica, `-` privata, `#` protected
- Query
- Modificatori
- Operazione != metodo
	- Concetti differenti presenza di *polimorfismo*
![[Pasted image 20241031192711.png]]
##### Commenti e Note
- Informazioni *aggiuntive*
	- Singole e solitarie
	- Legate a qualsiasi elemento grafico
		- *Linea tratteggiata*
# Relazione di Dipendenza
> Si ha *dipendenza* tra 2 elementi di un diagramma se la *modifica alla definizione* del *primo* (fornitore) può *cambiare la definizione del secondo* (client)

- UML permette di modellare ogni sorta di dipendenza
	- Non è una proprietà transitiva!
- Le dipendenze vanno *minimizzate*!
	- *Loose coupling*
- Da inserire solo quando danno valore aggiunto
	- Troppe dipendenze creano confusione nel diagramma
![[Pasted image 20241031193322.png]]
> Maggiore è la quantità di *codice condiviso* fra 2 tipi, maggiore è la *dipendenza* fra essi

- La dipendenza tra 2 tipi è direttamente proporzionale alla probabilità di *modificare* entrambi
$$
\delta_{A\rightarrow B} \propto P(B_{mod}|A_{mod})
$$
- La dipendenza è quindi una funzione di numero *SLOC* condivise e di *ampiezza dello scope* del codice condiviso
$$
\delta_{A\rightarrow B} = \frac{\phi S_{A|B}}{\phi_{S_{tot_{B}}}}
$$
![[Pasted image 20241031194031.png]]
![[Pasted image 20241031194051.png]]
# Aggregazione e Composizione
**Aggregazione**
- Relazione di tipo "_parte di_"
	- Gli *aggregati* possono essere *condivisi*
![[Pasted image 20241031194201.png]]
**Composizione**
- Come aggregazione, ma:
	- Gli aggregati appartengono ad un *solo aggregato*
	- Solo l'oggetto intero può *creare* e distruggere le sue *parti*
![[Pasted image 20241031194339.png]]
![[Pasted image 20241031194415.png]]
- Aggiungono *attributi* e *operazioni* alle associazioni
	- Esiste *solo una* istanza della classe associazione fra i 2 oggetti
![[Pasted image 20241031200428.png]]
# Classi di Associazione
28/43