>La qualità o lo stato di essere influenzato o determinato da un altro o di esserne soggetto.
   ad un altro.
- **Cambiamento** di un componente potrebbe influenzare le sue dipendenze questo avviene per:
	- _Cambiamenti interni_: modifica all'*implementazione*
	- _Cambiamenti esterni_: interfaccia o comportamento estrinseco
- La dipendenza è una misura della _probabilità_ di _cambiamenti_ tra componenti dipendenti
	- Più forte è la dipendenza più è alta la probabilità
**Dipendenza**: quando cambia un oggetto A allora c'è una possibilità che anche l'oggetto B cambi
Questo concetto ci interessa perchè il primo rilascio di un software avviene all'inizio del suo ciclo di vita. 
> Dopo il primo rilascio iniziano i problemi
> - Cardin

**NON** esiste SW privo di BUG!
2 tipi di manutenzione:
- *Correttiva*
- *Aggiuntiva*-> aggiunge feature
**Obiettivo**: creare un SW meno modificabile possibile quindi privo di dipendenze, per evitare un grosso **Debito Tecnico**: ovvero un debito da saldare noto da errori e scelte non ottimali nella progettazione del software che prima o poi dovranno essere corrette.

Ricorda che le specifiche iniziali di un software sono sempre diverse dalle specifiche finali
### Accoppiamento
- Una *misura* del grado di *dipendenza*
	- **Tightly-coupled**: molta probabilità di cambiamenti
	- **Loosely-coupled**: minore probabilità di cambiamenti
>La dipendenza tra i componenti deve essere ridotta al minimo, rendendo i componenti componenti accoppiati in modo lasco.
   -Gruppo di quattro
- Libertà di introdurre cambiamenti senza introdurre bug
	- Cambiamenti _interni/esterni_
	- le architetture sono dinamiche ed evolvono con il tempo
## Dipendenze nella OOP
- Dipendenze tra tipi
	- Classi concrete e astratte, interfacce

| **Nome**       | **Descrizione**                                                                                                   |
| -------------- | ----------------------------------------------------------------------------------------------------------------- |
| *Dipendenza*   | Quando gli oggetti di una classe *lavorano brevemente con*<br>oggetti di un'altra classe                          |
| *Associazione* | Quando gli oggetti di una classe *lavorano con oggetti* di<br>un'altra classe per un periodo di tempo prolungato. |
| *Aggregazione* | Quando una classe *possiede ma condivide un riferimento* a<br>oggetti di un'altra classe                          |
| *Composizione* | Quando una classe *contiene* un oggetto di un altra classe                                                        |
| *Ereditarietà* | Quando una classe *è tipo* di un altra classe                                                                     |
### Dipendenza (o Relazione)
- La forma di dipendenza più *Debole*
	- Limitato nel tempo: esecuzione di un solo metodo
	- Limitato nel codice condiviso: solo interfaccia
```Java
class A{
	public A() {/*...*/}
	public void methodA() {}
} //methidA -> firma della funzione

class B{
	public void methodWithAParam(A param){
		a.methodA();
	}
	public A methodThatReturnsA(){
		return new A();
	}
}
```
### Associazione
- Una classe che contiene un riferimento ad un'oggetto
	- Si estende per tutta la durata di vita di un oggetto: *permanente*
		- Impatta anche sulla costruzione degli oggetti
	- Tutti i comportamenti di una classe sono virtualmente condivisi
```Java
class A{
	private B b;
	public A(B b) {this.b = b; }
	//altri metodi di A
}

class B{
	public void method1() {}
	public void method2() {}
	public void method3() {}
}
```
### Aggregazione e Composizione
- Un tipo possiede un altro tipo
	- Aggiunta di responsabilità di creazione e cancellazione
	- La creazione non è una cosa semplice...
- Composizione: evitare la condivisibilità dei componenti
```Java
class A{
	private B b;
	public A() {
		//A deve conoscere come costruire un B
		this.b = new B ("par1", "par2");
	}
	//altri metodi di A
	static class B{
		//resto delle classi
		public B(String par1, String Par2) {} //Anche il processo di costruzione è condiviso
	}
}
```
### Ereditarietà
- Il tipo di dipendenza più forte
	- Ereditarietà e riutilizzo del codice non privato
		- (Ereditarietà dell'implementazione, non sottotipizzazione)
	- Qualsiasi modifica al genitore può disturbare i suoi figli
```Java
class A{
	public A() {}
	//altri metodi di A
}

class B extends A{
	public B(){
		super();
		//...
	}
	//altri metodi di B
}
```
# Grado di dipendenza
Maggiore è il *codice condiviso*, più forte è la dipendenza
- Inoltre, più ampio è l'ambito di applicazione, ...
Possiamo formalizzare la *misura dell'accoppiamento*, $\delta_{A\rightarrow B}$?
$$
\delta_{A \rightarrow B} = \frac{\phi_{S_{A|B}}}{\phi_{S_{tot_{B}}}}\epsilon_{A\rightarrow B} \in \{x \in \mathbb{R}^{+} | 0 \le x \le 1 \} 
$$
- $\phi_{S_{A|B}}$ : SLOC shared between A and B
- $\phi_{S_{tot_{B}}}$: Total SLOC of class B
- $\epsilon_{A\rightarrow B}$ : A factor $[0,1]$ the measures the scope
L'accoppiamento è *proporzionale* alla *probabilità* di *cambiamento reciproco* tra componenti
$$
\delta_{A\rightarrow B} \propto P(B_{mod}|A_{mod})
$$
Misura dell'accoppiamento totale per un componente:
$$
\delta^{A}_{tot} = \frac{1}{n} \sum_{C_j \in C_1,...,C_n} \delta_{A\rightarrow C_j}
$$
$C_j$ è la j-esima classe che dipende da A
La misura è la media di tutte le misure di accoppiamento
#### Information Hiding
- immagina la classe `Rettangolo`
	- Immagina che `altezza`e `larghezza`abbiano il loro tipo
	- Sono *strettamente collegate*
	- The $\delta^C_{tot}$ of a client C would be very high
		- it would use always all 3 types
	- $\delta^{Rectangle}_{tot}$ would be high too
- The given solution probably obtains the *minimization* of $\delta^C_{tot}$
