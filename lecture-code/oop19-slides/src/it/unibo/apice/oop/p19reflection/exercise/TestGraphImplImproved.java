package it.unibo.apice.oop.p19reflection.exercise;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestGraphImplImproved {

    private Graph<String> g;

    @Before     // initalisation code executed prior to each test
    public void initialise() {
        //g = new GraphImpl<>();
        g.addNode("a");
        g.addNode("b");
        g.addNode("c"); 
        g.addNode("d");
        g.addNode("e");
        g.addEdge("a", "b");
        g.addEdge("b", "c");
        g.addEdge("c", "d");
        g.addEdge("d", "e");
        g.addEdge("c", "a");
    }

    @Test
    public void testNodeSetSize() {
        assertEquals(5, g.nodeSet().size());
    }

    @Test
    public void testNodeSetElements() {
        assertThat(g.nodeSet(), hasItems("a", "b", "c", "d", "e"));
    }

    @Test
    public void testLinkedNodes() {
        assertEquals(2, g.linkedNodes("c").size());
        assertThat(g.linkedNodes("c"), hasItems("a", "d"));
    }

    @Test
    public void testGetPath() {
        assertEquals(Arrays.asList("b", "c", "a"), g.getPath("b", "a"));
    }
}
