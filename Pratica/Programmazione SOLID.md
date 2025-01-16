*Per l'esame sono richiesti solo S, O e L*
- Programmazione strutturata e programmazione orientata agli oggetti
	- Due delle più importanti rivoluzioni dell'industria informatica
		- Tutti usano linguaggi OO, ma...
	- I programmatori di oggi non conoscono i principi che sono alla base dell'Orientamento agli Oggetti
- Dependency management
	- L'arte di rendere il codice flessibile, robusto e riutilizzabile
	- **SOLID** *principles*
		- Un set di classi progettate per gestire le dipendenze
# SOLID
- **S**ingle Responsibility principle
	- Una classe dovrebbe avere una, e una sola, ragione per cambiare
- **O**pen Closed Principle
	- Si dovrebbe essere in grado di estendere il comportamento di una classe, senza modificarlo
- **L**iskov Substitution Principle
	- Le classi derivate devono essere sostituibili con le loro classi base. *//sono richieste fin qui all'esame*
- **I**nterface Segregation Principle
	- Creare interfacce a grana fine che siano specifiche per il cliente
- **D**ependency Inversion Principle
	- Dipendere da astrazioni, non da concretizzazioni
## Single Responsibility Principle
**Conosciuta anche come _coesione_**
- Correlazione funzionale degli elementi di un modulo
- Un modulo deve avere una sola ragione di cambiamento
	- Chiamiamo questa ragione di cambiamento responsabilità
**Responsabilità accoppiate**
- Le modifiche a una responsabilità possono compromettere o inibire la capacità della classe di soddisfare le altre
- Progetti fragili che si rompono in modi inaspettati
	- Ricompilazione, test, distribuzione, ...
![[Screenshot 2025-01-16 alle 17.44.41.png]]
![[Screenshot 2025-01-16 alle 17.44.18.png]]
- Che cos'è una *responsabilità*?
	- Un asse di cambiamento è un asse di cambiamento solo se i cambiamenti si verificano effettivamente
	- Anche il contesto dell'applicazione è importante
		- Complessità inutile
```Java
public interface Modem{
	//Connection management
	public void dial(String pno);
	public void hangup();
	//Data communication
	public void send(char c);
	public char recv();
}
// queste 2 responsabilità dovrebbero essere separate? -> questo dipende da come l'applicazione cambierà
```
![[Screenshot 2025-01-16 alle 17.50.03.png]]
- Separare responsabilità evita rigidità
	- Sono ancora accoppiati in `ModemImplementation`, ma i client non devono preoccuparsi delle implementazioni delle interfacce.
## Open-Close Principle
Ci sono molte euristiche nella OOD
>“Tutte le variabili membro dovrebbero essere private”, ”Le variabili globali dovrebbero essere evitate”, ”L'uso dell'identificazione del tipo a tempo di esecuzione (RTTI) è pericoloso”.
- Le entità software devono essere aperte all'estensione, ma chiuse alle modifiche
	- Si estende il comportamento aggiungendo nuovo codice, non modificando il vecchio.
- Il principio di apertura-chiusura sottolinea queste euristiche
L'astrazione è la chiave
- I tipi astratti sono la parte fissa, le classi derivate punti di estensione
![[Screenshot 2025-01-16 alle 17.57.27.png]]
![[Screenshot 2025-01-16 alle 17.59.07.png]]
![[Screenshot 2025-01-16 alle 17.59.19.png]]
- Nessun programma può essere chiuso al 100%
	- La chiusura deve essere strategica
- La chiusura può essere guadagnata attraverso l'astrazione
	- Usando interfacce e polimorfismo
		- Il metodo astratto `draw` nella classe `shape`
- ... oppure può essere guadagnata in stile *data-driven*
	- A volte l'utilizzo di informazioni configurate in strutture esterne può essere l'unica soluzione
		- E se volessimo disegnare le forme in un ordine specifico che dipende dal tipo?
- Convenzioni e euristiche derivano dall'OCP
	- Rendere tutti i metodi delle variabili privati
		- Quando i membri delle variabili di una classe cambiano, ogni funzione che dipende da loro deve essere cambiato *Encapsulation*
	- Non usare variabili globali
		- Nessun modulo che dipenda da una variabile globale può essere chiuso contro qualsiasi altro modulo che potrebbe scrivere su quella variabile.
			- Ovviamente ci sono esclusioni `cin, cout....`
	- RTTI è pericolosa
		- L'esempio `shape`mostra un cattivo uso di RTTI
		- Ma ci sono anche casi buoni
## Liskov Substitution Principle
- Astrazione e Polimorfismo
	- Alla base di OOD e OCP
		- Quali sono le caratteristiche e le migliori gerarchie? quali sono le trappole?
- **Liskov Substitution Principle**
>Le funzioni che utilizzano puntatori o riferimenti a classi base devono essere in grado di utilizzare oggetti di classi derivate senza saperlo.

- Violare questo principio significa violare OCP (*Open Compute Project*)
	- Una funzione che utilizza un puntatore o un riferimento a una classe di base, deve conoscere tutti i derivati di quella classe base.
![[Screenshot 2025-01-16 alle 18.16.49.png]]
![[Screenshot 2025-01-16 alle 18.17.21.png]]
- Che cosa è andato storto?
	- Ciò che conta è il comportamento estrinseco del pubblico
		- Comportamento da cui dipendono i clienti
		- La relazione tra `Square` e `Rectangle` non è una relazione IS-A in OOD
- **_Design by contract_**
>...quando si ridefinisce una routine [in una derivata], si può solo sostituire la sua precondizione con una più debole e la sua postcondizione con una più forte.
- I metodi delle classi dichiarano precondizioni e postcondizioni (invarianti)
```Java
// Rectangle.setWidth(double w) postconditions
assert((width == w) && (height == old.height));
```
- In una classe derivata le precondizioni non devono essere più forti rispetto alla classe base
	- Utilizzando l'interfaccia della classe base, un cliente conosce solo le precondizioni della classe base
- In una classe derivata le postcondizioni devono essere più forti rispetto alla classe base
	- La classe derivata deve essere conforme a tutte le condizioni della classe base. I comportamenti e gli output non devono violare alcuno dei vincoli stabiliti per la classe base
- I linguaggi di base Java e JVM dispongono della primitiva assert. Il C++ non ha nulla di simile
*//Fin qui per lo studio per l'esame*

---
