package fastLinkedList;

import static org.junit.Assert.*;
import org.junit.Test;

public class FastLinkedListTest {

	/* Tests the constructor of FastLinkedList class */
	@Test
	public void testConstructor() {
		FastLinkedList<String> lst = new FastLinkedList<String>();
		// Expect that new list is empty
		assertTrue(lst.isEmpty());
		// Expect that cursor in zero position
		assertEquals(0, lst.getCurrentPos());
	}

	@Test
	public void testInsert() {
		FastLinkedList<String> lst = new FastLinkedList<String>();
		lst.insert("A");
		assertEquals(1, lst.length());
		assertEquals(1, lst.getCurrentPos());
		assertEquals("A", lst.getData());
		lst.insert("B");
		lst.insert("C");
		assertEquals(3, lst.length());
		assertEquals(3, lst.getCurrentPos());
		assertEquals("C", lst.getData());
		

		lst.setCurrentPos(0);
		lst.insert("D");
		assertEquals(4, lst.length());
		assertEquals(1, lst.getCurrentPos());
		assertEquals("D", lst.getData());

		lst.setCurrentPos(3);
		lst.insert("E");
		assertEquals(5, lst.length());
		assertEquals(4, lst.getCurrentPos());
		assertEquals("E", lst.getData());
		lst.setCurrentPos(3);
		assertEquals("B", lst.getData());
		lst.setCurrentPos(5);
		assertEquals("C", lst.getData());
	}

	@Test
	public void testRemove() {
		FastLinkedList<String> lst = new FastLinkedList<String>();
		lst.insert("A");
		lst.insert("B");
		lst.insert("C");
		lst.remove();
		assertEquals(2, lst.length());
		assertEquals(2, lst.getCurrentPos());
		lst.setCurrentPos(0);
		lst.remove();
		assertEquals(2, lst.length());
		assertEquals(0, lst.getCurrentPos());
		lst.setCurrentPos(1);
		lst.remove();
		assertEquals(1, lst.length());
		assertEquals(0, lst.getCurrentPos());
		lst.setCurrentPos(1);
		assertEquals("B", lst.getData());
	}

	public static void main(String[] args) {
		jh61b.junit.textui.runClasses(FastLinkedListTest.class);
	}

}