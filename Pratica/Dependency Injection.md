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
- Configurazione XML 
	- `org.springframework.beans.factory.BeanFactory`
		- Implementazione del pattern _factory_, costruisce e *risolve le dipendenze*
	- `org.springframework.context.ApplicationContext`
		- Costruita sulla bean factory, fornisce ulteriori funzionalità
			- AOP, transazionalità,...
```Java
ApplicationContext ctx = new ClassPathXmlApplicationContext("com/sringinaction/springidol/filename.xml");
//...
MovieLister ml = (MovieLister) ctx.getBean("movieLister");
```
- Configurazione XML
	- *Dependenncy injection* attraverso _proprietà_
		- Utilizzo di metodi *setter* e *getter*
```XML
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">

<beans>
	<bean id="movieLister" class="MovieLister">
		<!-- La classe ha come proprietà finder -->
		<property name="finder" ref="movieFinder"/>
	</bean>
	<bean id="movieLister" class="MovieLister">
		<property name="file" value="movies.csv"/>
	</bean>
</beans>
```
- Configurazione XML
	- *Dependency injection* attraverso *costruttori*
		- Spring risolve automaticamente la scelta del costruttore
	- Oppure factory methods, init, destroy methods
```XML
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">

<beans>
	<bean id="movieLister" class="MovieLister">
		<!-- La classe ha come proprietà finder -->
		<constructor-arg ref="movieFinder"/>
	</bean>
	<bean id="movieLister" class="MovieLister">
		<constructor-arg value="movies.csv"/>
	</bean>
</beans>
```
- Configurazione Java
	- `@Configuration` dichiara una classe configurazione
	- `@Bean` dichiara un *Bean*
````Java
@Configuration
public class MovieConfig{
	@Bean
	public MovieLister lister(){
		return new MovieLister (finder()); //Constructor Injection
	}
	@Bean
	public MovieFinder finder(){
		return new ColonMovieFinder("movies.csv");
	}
}
ApplicationContext ctx = new AnnotationConfigApplicationContext(MovieConfig.class);
````
- **Wiring** utilizzando *annotazioni*
	- Permette una gestione migliore della configurazione in *progetti grandi*
	- Introduce una *dipendenza* da *framework* esterni
		- `@Autowired`
		- `@Inject`, annotazione JSR-330
		- `@Resource`, annotazione JSR-250
````XML
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
</beans>
	<context:annotation-config/>
	<context:component-scan base-package="org.example"/>
````
- **Wiring** utilizzando *annotazioni*
	- `@Inject/@Autowired`
		- Ricerca per *tipo* il *bean* della proprietà e lo usa come *id*
		- Si utilizza su costruttori, proprietà,...
		- Il bean *non* deve essere *ambiguo*
			- Disambiguazione tramite `@Named` per l'ID
````Java
@Inject
private Instrument instrument;

@Inject
@Named("guitar") //Fornisce nome differente dal tipo
private Instrument instrument2;
````
- **_Autodiscovery_**
	- `@Component, @Controller, @Service,...`
## JavaScript
- **_Dependency injection in JavaScript_**
	- *Container* è una mappa `[string, function]`
		- Linguaggio non tipizzato staticamente
		- Non ha interfacce esplicite
	- JS è strutturato a moduli (*module pattern*)
		- *Injection* di oggetti o interi moduli
	- Esistono diverse librerie (*API*) per la DI
		-  RequireJS/AMD - http://requirejs.org/
		- Inject.js - http://www.injectjs.com/
		- AngularJS (framework) - https://angularjs.org/
### AngularJS 1.6
- JavaScript *framework*
	- *Client-side*
	- *Model-View-Whatever*
		- MVC per alcuni aspetti (controller)
		- MVVM per altri (two-way data binding)
	- Utilizza **HTML** come linguaggio di *templating*
		- Non richiede operazioni di DOM *refresh*
			- Controlla attivamente le azioni utente, eventi del *browser*
	- *Dependence Injection*
		- Fornisce ottimi strumenti di test
- Dependency injection
	- `$provide`: risolve le *dipendenze* fra le componenti
		- Viene invocato direttamente da Angular al *bootstrap*
````JavaScript
//provide the wiring information in a module
angular.module('myModule', []).
	//Teach the injector how to build a 'greeter'
	//Notice that greeter itself is dependent on '$window'
	factory('greeter', function($window){
	// This is a factory functionn, and is responsible for creating the 'greet' service.
	return{
		greet: function(text){
			$window.alert(text);
		}
	};
	});

//Request any dependency from the $injector
angular.injector(['myModule', 'ng']).get('greeter');
````
![[Pasted image 20241210215429.png]]
- Dependency Injection
	- Factory methods: *costruiscono* le componenti
		- Utilizzano *recipe* (*ricette*)
````JavaScript
angular.module('myModule', []).
	config(['depProvider', function(depProvider){
	...
	}]);
	factory('serviceId', ['depService', function(depService){
	...
	}]);
	directive('directiveName', ['depService', function(depService){
	...
	}]);
	filter('filterName', ['depService' , function(depService){
	...
	}]);
	run(['depService', function(depService){
	...
	}]);
````
## Scala
- Cake Pattern
	- Utilizzo di una notazione dedicata (*self-type annotation*) e dei trait per dichiarazione delle dipendenze e la loro risoluzione
````Scala
trait FooAble{
	def foo() = "I am a foo!"
}
class BarAble { this: FooAble => //self-type annotation
	def bar = "I am a bar and " + foo()	   
}
val barWithFoo = new BarAble with FooAble //mixin
````
- Utilizzo di contenitori dedicati per risolvere le dipendenze
	- Divisione dei concetti di *business* dai dettagli tecnici
````Scala
// Declares a repository
trait UserRepositoryComponent {
	val userRepository: UserRepository
	class UserRepository {
		def findAll() = Array[User]() // fake implementation
		def save(user: User) = "Saving a user..." // fake implementation
	}
}
// Declares a service that needs a repository
trait UserServiceComponent { this: UserRepositoryComponent =>
	val userService: UserService
	class UserService {
		def findAll() = userRepository.findAll
		def save(user: User) = userRepository.save(user)
	}
}
// Configuration object that binds dependencies
object ComponentRegistry extends
	UserServiceComponent with UserRepositoryComponent {
	// Dependency injection
	val userRepository = new UserRepository
	val userService = new UserService
}
````

> Dependency Injection means giving an object its own instance variables. Really. That's it.
>Dependency Injection significa dare a un oggetto le proprie variabili di istanza. Davvero. Tutto qui.
>-- James Shore
- Vantaggi
	- Migliora la fase di testing
		- Isolamento delle componenti -> *Maggior riuso*
	- Migliora la *resilienza* del codice
		- Manutenzione e correzioni componenti specifiche
	- Migliora la *flessibilità*
		- La disponibilità di più componenti simili permette di scegliere a *runtime* la migliore
