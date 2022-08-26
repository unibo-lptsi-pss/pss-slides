package it.unibo.apice.oop.p19reflection.exercise;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

import org.junit.Test;

public class TestGraphImpl {

	@Test
	public void testNodeSet() {
		final Graph<String> g = null; //new GraphImpl<>();
		assertEquals(g.nodeSet().size(),0);
		
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		assertEquals(g.nodeSet().size(),5);
		assertThat(g.nodeSet(),hasItems("a","b","c","d","e"));
		assertEquals(g.linkedNodes("c").size(),0);
		
		g.addEdge("a","b");
		g.addEdge("b","c");
		g.addEdge("c","d");
		g.addEdge("d","e");
		g.addEdge("c","a");
		assertEquals(g.linkedNodes("c").size(),2);
		assertThat(g.linkedNodes("c"),hasItems("a","d"));
		
		assertEquals(g.getPath("b", "a"),Arrays.asList("b","c","a"));
	}

}
