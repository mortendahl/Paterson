package paterson.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FlattenIterator<T> implements Iterator<T> {

	private Iterator<Iterator<T>> its;
	private Iterator<T> currentIterator;
	
	public FlattenIterator(Iterator<Iterator<T>> its) {
		this.its = its;
	}
	
	@Override
	public boolean hasNext() {
		if (currentIterator == null || !currentIterator.hasNext()) {
			while (its.hasNext()) {
				currentIterator = its.next();
				if (currentIterator.hasNext())
					return true;
			}
			return false;
		}
		return true;
	}

	@Override
	public T next() {
		if (currentIterator == null || !currentIterator.hasNext()) {
			while (its.hasNext()) {
				currentIterator = its.next();
				if (currentIterator.hasNext())
					return currentIterator.next();
			}
			throw new NoSuchElementException();
		}
		return currentIterator.next();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
