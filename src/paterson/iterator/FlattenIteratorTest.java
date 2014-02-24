package paterson.iterator;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

public class FlattenIteratorTest {

	@Test
	public void testABC() {
		ArrayList<Iterator<String>> its = new ArrayList<Iterator<String>>(); 
		ArrayList<String> list0 = new ArrayList<String>();
			its.add(list0.iterator());
		ArrayList<String> list1 = new ArrayList<String>();
			list1.add("A");
			list1.add("B");
			its.add(list1.iterator());
		ArrayList<String> list2 = new ArrayList<String>();
			its.add(list2.iterator());
		ArrayList<String> list3 = new ArrayList<String>();
			list3.add("C");
			its.add(list3.iterator());
						
		FlattenIterator<String> it = new FlattenIterator<String>(its.iterator());
		
		String output = "";
		while (it.hasNext())
			output = output.concat(it.next());
		
		assertTrue(output.equals("ABC"));
	}
	
	@Test
	public void testEmpty() {
		ArrayList<Iterator<String>> its = new ArrayList<Iterator<String>>(); 
						
		FlattenIterator<String> it = new FlattenIterator<String>(its.iterator());
		
		String output = "";
		while (it.hasNext())
			output = output.concat(it.next());
		
		assertTrue(output.equals(""));
	}

}
