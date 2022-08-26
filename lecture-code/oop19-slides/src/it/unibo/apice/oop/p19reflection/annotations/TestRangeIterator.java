package it.unibo.apice.oop.p19reflection.annotations;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class TestRangeIterator {

	@Test
	public void testStandardBehaviour() {
		final Iterator<Integer> it = new RangeIterator(5,7);
		assertTrue(it.hasNext());
		assertEquals(5,it.next().intValue());
		assertTrue(it.hasNext());
		assertEquals(6,it.next().intValue());
		assertTrue(it.hasNext());
		assertEquals(7,it.next().intValue());
		assertFalse(it.hasNext());
	}
	
	@Test
	public void testStartEqualsStop() {
		Iterator<Integer> it = new RangeIterator(5,5);
		assertTrue(it.hasNext());
		assertEquals(5,it.next().intValue());
		assertFalse(it.hasNext());
	}
	
	@Test
	public void testRemoveRaisesException() {
		Iterator<Integer> it = new RangeIterator(5,10);
		try {
			it.remove();
			fail();
		} catch (UnsupportedOperationException e) {
		}
	}
	
	// Variante migliorativa
	@Test(expected = UnsupportedOperationException.class)
	public void testRemoveRaisesException2() {
		Iterator<Integer> it = new RangeIterator(5,10);
		it.remove();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testNoSuchElement() {
		Iterator<Integer> it = new RangeIterator(5,6);
		it.next();
		it.next();
		it.next();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArguments() {
		new RangeIterator(6,4);
	}
}
