> OOP is a programming paradigm based on the concept of "*objects*", which may contain data, in the form of fields; and code, in the form of procedures. A feature of objects is that an object's procedures can access and often modify the data fields of the object which they are associated
---
#### **3 principi**
- Encapsulation (information hiding)
- Inheritance
- Polymorphism
### Procedural Programming
- Procedures need the struct as input
	- Very verbose, hard to *maintain*, a lot of parameters
`List<Double> scale(double height, double width, double factor)`
- Lack of *information hiding*
	- *No restriction*, no authorization process
	- Testing is a hell
```C
Retangle r = new Rectangle(2.0, 4.0);
r.height = 6.0;
printf(area(r)); // ci aspettiamo 8.0, ma viene ritornato 24.0
```
### Object Oriented Programming
- Binding data with *behaviours*
> The aim of OOP is not modeling reality using abstract representations of its component, accidentally called "*objects*". OOP aims to organize behaviors and data together in structures, minimizing dependencies among them

- The internal state is hidden from outside
```Java
interface Shape{
	double area();
	Shape scale(double factor);
}
class Rectangle implements Shape {
	private double height;
	private double width;
	/*Definition of functions declared in shape interface*/
}
```
#### Information hiding
- How to build a type using information hiding?
	1. Find procedures sharing the *same inputs*
	2. Get the minimum set of common inputs
		- Avoid tighly coupling
	3. Create a structure using those inputs
		- Nope! data is accessible from everywhere
	4. Bind the structure with procedures, forming a type
- Clients must depend only on behaviour
	- Hide data behind a *private* scope
- Use *interfaces* to hide implementation
#### Inheritance
- Class (*implementation*)
	- Internal state and method implementation
- Type
	- The set of requests to which it can respond
> *Inheritance* is a language feature that allows new objects to be defined from existing ones
- Class inheritance (code reuse)
	- Reuse of object's implementation
- Interface inheritance (subtyping)
	- reuse of object's behaviour
- Code reuse example
```Java
class AlgorithmThatReadFromCsvAndWriteOnMongo(filePath: String,
mongoUri: String) {
	def read(): List[String] = { /* ... */ }
	def write(lines: List[String]): Unit = { /* ... */ }
}
class AlgorithmThatReadFromKafkaAndWriteOnMongo(broker: String, topic: String, mongoUri: String) extends AlgorithmThatReadFromCsvAndWriteOnMongo(null, mongoUri) {
	def read(): List[String] = { /* ... */ }
}
class AlgorithmThatReadFromKafkaAndWriteOnMongoAndLogs(brk: String,topic: String, mongoUri: String, logFile: String)
extends AlgorithmThatReadFromKafkaAndWriteOnMongo(broker, topic,
mongoUri) {
	def write(lines: List[String]): Unit = { /* ... */ }
}
```
- The banana, monkey, jungle problem
> The problem with object-oriented language is they've got all this implicit environment that they carry around with them. You wanted a banana but what you got was a gorilla holding the banana and the entire jungle
 -Joe Armstrong
- Using a class adds a *strong dependency* also to parent classes
- Tight coupling
- One class, one responsibility
	- Single Responsibility Principle
	- Inheritance only from abstract types
- Does class inheritance break *encapsulation*?
	- Classes expose two different interfaces
		- Subclasses can access internal state of base classes
		- Public and protected
- More and more clients for a class!!!
	- Increasing of the dependency degree of a class
	- The higher the dependency the higher the *coupling*
- So, try to *avoid* class inheritance
> Class inheritance defines an object's implementation in terms of another object's implementation. In short, it's a mechanism for code and representation sharing. In contrast, interface inheritance (*or subtyping*) describes when an object can be used in place of another

- Inherit only from interfaces and abstract classes
	- *Do not override* methods
	- Do not hide operation of a parent class
- Loose coupling
	- Clients remain unaware of the specific type
	- *Polymorphism* depends on subtyping
### Composition Over Inheritance
- Black box reuse
	- Assembling functionalities into new features
	- No internal details
```Java
trait Reader{
	det read(): List[String];
}
trait Writer{
	def write(lines: List[String]): Unit
}
class CsvReader(filePath: String) extends Reader{}
class MongoWriter(mongoUrl: String) extends Writer{}

class Migrator(reader: Reader, writers: List[Writer]){
	val lines = reader.read()
	writers.foreach(_.write(lines))
}
```
> Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it
> - Liskov Substitution Principle

- Do not override pre- and post-condition of base class
	- Preconditions must be weaker, post conditions must be stronger than in the base class
- Design by contract
	- Avoid redefinition of extrinsic public behaviour
#