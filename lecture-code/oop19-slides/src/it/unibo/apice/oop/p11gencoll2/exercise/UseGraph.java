package it.unibo.apice.oop.p11gencoll2.exercise;

public class UseGraph{
 
public static void main(String[] args){
	Graph<String> g = null; //new GraphImpl<>();
	
	g.addNode("a");
	g.addNode("b");
	g.addNode("c");
	g.addNode("d");
	g.addNode("e");
	
	g.addEdge("a","b");
	g.addEdge("b","c");
	g.addEdge("c","d");
	g.addEdge("d","e");
	g.addEdge("c","a");
	
	System.out.println(g.nodeSet()); 
	// ["a","b","c","d","e"].. in any order
	System.out.println(g.linkedNodes("c")); 
	// ["d","a"].. in any order
	System.out.println(g.getPath("b","a")); 
	// either the path b,c,a or b,c,d,e,a
	
	
	}
}
