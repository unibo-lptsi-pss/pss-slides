package it.unibo.apice.oop.p19reflection.classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class CounterTest {

	@Test
	public void test1() {
		Counter c = new Counter();
		c.increment();
		c.increment();
		assertTrue("Increment does not work wrt getValue", c.getValue()==1);
	}
	
	@Test
	public void test2() {
		Counter c = new Counter();
		assertTrue("getValue is not initially zero", c.getValue()==0);
	}
	

}
