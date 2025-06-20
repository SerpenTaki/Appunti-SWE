package Behaviour.Observer;
 //Observable interface //Il bro qui lo faceva con l'interfaccia ma andrebbe la classe astratta è il nostro Subject
public abstract class Observable {
    public abstract void attach(Observer observer);
    public abstract void detach(Observer observer);
    public abstract void notifyObservers(JobPost job);
}
