package paterson.observer;

import java.util.*;

public abstract class AsynchronousSubject implements Subject, Runnable {

	// using a list allows for observer duplications, may or may not be an issue 
	private List<Observer> observers = new ArrayList<Observer>();
	
	private Object lock = new Object();
	
	private boolean pendingUpdates = false;  // no need for volatile as all threads will access from synchronized block
	
	private Thread updator = new Thread(new Runnable() {
		@Override
		public void run() {
			List<Observer> copyOfObservers = null;
			while (true) {
				synchronized (lock) {
					while (!pendingUpdates) {
						try {
							lock.wait();
						} catch (InterruptedException e) {}
					}

					// there is a pending update, prepare for the next
					pendingUpdates = false;

					// make copy of observers so we can release lock while
					// invoking updates
					copyOfObservers = new ArrayList<Observer>(observers);
				}

				for (Observer observer : copyOfObservers) {
					observer.update(AsynchronousSubject.this);
				}
			}
		}
	});
	
	public AsynchronousSubject() {
		updator.start();
	}
	
	public void addObserver(Observer observer) {
		synchronized (lock) {
			observers.add(observer);
		}
	}
	
	public void removeObserver(Observer observer) {
		synchronized (lock) {
			observers.remove(observer);
		}
	}
	
	public void updateObservers() {
		synchronized (lock) {
			pendingUpdates = true;
			lock.notify();
		}
	}			
}
