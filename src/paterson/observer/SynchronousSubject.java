package paterson.observer;

import java.util.*;

public abstract class SynchronousSubject implements Subject {
	
	// using a list allows for observer duplications, may or may not be an issue 
	protected List<Observer> observers = new ArrayList<Observer>();
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void updateObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

}
