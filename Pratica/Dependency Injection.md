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
1. __*Constructor Injection*__
	- **Dipendenze** dichiarate come *parametri* del costruttore
	- *Vantaggi*
		- Permette di costruire oggetti *validi* sin dalla loro *istanziazione*
		- Favorisce la costruzione di oggetti *immutabili*
	- *Svantaggi*
		- *Telescoping*
		- A volte è difficile comprendere il significato dei parametri
```Java
public class MovieLister{
	private MovieFinder finder;
	public MovieLister(MovieFinder finder){ //dichiarazione dip.
		this.finder = finder;
	} //...
}
```
2. **_Setter Injection_**
	- **Dipendenze** dichiarate come metodi *setter*
	- *Vantaggi*
		- Individuazione precisa delle dipendenze e dei loro nomi
		- Lavora meglio con le *gerarchie* di classi
	- *Svantaggi*
		- La componente è costruita per passi
		- Non è abilitante all'immutabilità
```Java
public class MovieLister{
	private MovieFinder finder;
	public void setFinder(MovieFinder finder){
		this.finder = finder;
	} //...
}
```
### Google Guice
- *Lightweight di framework*
	- *Class injection* (`@Inject-JSR-330`)
	- Configurazione Java estendendo `AbstractModule`
```Java
public class MovieModule extends AbstractModule{
	@Override
	protected void configure() {
		//istruisce il container su come risolvere la dipendenza
		bind(MovieFinder.class).to(ColonMovieFinder.class);
	}
}

public class MovieLister{
	//L'annotazione istruisce il container di risolvere automaticamente le dipendenze dichiarate
	@Inject
	public MovieLister(MovieFinder finder){
		this.finder = finder;
	} //...
}
```
- Metod (*setter*) injection
```Java
public class MovieLister{
	//L'annotazione istruisce il container su come risolvere automaticamente le dipendenze dichiarate
	@Inject
	public setFinder(MovieFinder finder){
		this.finder = finder;
	} //...
}
```
- Field *injection*
```Java
public class MovieLister{
	//Risolta automaticamente dall'injector. Più conciso ma meno verificabile
	@Inject MovieFinder = finder;
}
```
- Container è una struttura `Map<class<?>. Object>
- Non è possibile avere due oggetti dello stesso tipo
	- È possibile utilizzare qualificatori ulteriori per questo caso
- Si integra con AOP, Servlet spec., DAO,...
	- @Named, @Singleton, @SessionScorped, @RequestScoped
```Java
public static void main(String[] args){
	//Guice.createInjector() takes your Modules, and returns a new Injector instance. Most application will call this method exactly once, in their main() method.
	Injector injector = Guice.createInjector(new MovieModule());
	//Now that we've got the injector, we can build objects.
	MovieLister lister = injector.getInstance(MovieLister.class);
}
```
# Spring
> A lightweight inversion of control and aspect oriented container framework
- Lightweight
	- Non è intrusivo, gli *oggetti* sviluppati *non dipendono* da classi del *framework*
- Framework/Container
	- La configurazione utilizza *XML*, o *annotazioni*, o *Java*
		- Lo sviluppatore può concentrarsi sulla logica di *business*
	- Container è una struttura `Map<String, Object>`
- Utilizza semplici POJO: *Bean*
	- Supporta sia constructor, che setter injection
- Configurazione XML //Slide 14 di 27