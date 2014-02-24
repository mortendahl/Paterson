package dk.mortendahl.paterson.singleton;

public class ThreadSafeLazy {

	// NOTE: see Java Puzzlers if singleton object can be serialised 
	
	// lazy
	private static Object winner = null;
	
	// thread safe (but more expensive)
	public static synchronized Object getWinner() {
		if (null == winner) {
			winner = new Object();
		}
		
		return winner;
	}
	
}
