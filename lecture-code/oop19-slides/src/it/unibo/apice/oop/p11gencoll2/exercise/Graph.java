package it.unibo.apice.oop.p11gencoll2.exercise;

import java.util.*;

public interface Graph<N> {

	// Adds a node: nothing happens if node is null or already there
	void addNode(N node);
	
	// Adds an edge: nothing happens if source or target are null
	void addEdge(N source, N target);
	
	// Returns all the nodes
	Set<N> nodeSet();
	
	// Returns all the nodes directly targeted from node
	Set<N> linkedNodes(N node);
		
	// Gets one sequence of nodes connecting source to path
	List<N> getPath(N source, N target);

}
