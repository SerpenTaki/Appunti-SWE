![[Screenshot 2024-12-02 alle 15.36.56.png]]
- **Scopo**
	- Separazione del comportamento di una componente dalla risoluzione delle sue dipendenze
- **Motivazione**
	- Collegare 2 componenti in modo esplicito ne aumenta l'accoppiamento
		- Progettazione *unit-test* difficoltosa
		- Riutilizzo scarso della componente
		- Scarsa manutenibilità
	- Le dipendenze vanno minimizzate!!!
![[Screenshot 2024-12-02 alle 16.03.47.png]]
![[Screenshot 2024-12-02 alle 16.04.04.png]]
## Struttura
- **_Inversion of Control_**
	- Il *ciclo di vita* degli oggetti è gestito da una entità *esterna* (container)
		- Tutti i *framework* moderni implementano la IoC
- **_Dependency Injection_** con IoC
	- Le *dipendenze* sono "iniettate" dal *container*
	- La componente dichiara solo le sue *dipendenze*
		- *Minimizzazione* del livello di accoppiamento
	- Diversi tipi di _Injection_
		- _Constructor injection_
		- _Setter injection_
	- `Assembler`risolve le dipendenze delle componenti
		- Il ciclo di vita degli oggetti è deciso dal *container*
		- **Configurazione:** meta-linguaggio (XML) o programmatica
			- Cambio di *movie finder* -> cambio di configurazione
![[Screenshot 2024-12-02 alle 16.08.39.png]]
