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
- 
