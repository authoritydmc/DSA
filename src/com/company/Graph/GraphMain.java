package com.company.Graph;

public class GraphMain {

    public static void main(String[] args) {
        Graph<String> graph=new Graph<>(true);
        graph.addVertex("G");
        graph.addEdge("S","M",false);
        graph.addEdge("M","G",false);
        graph.addEdge("G","T");
        graph.addEdge("G","W");
        graph.addEdge("D","W",false);
        graph.addEdge("M","D");
        graph.addEdge("T","D");

        System.out.println(graph);

        graph.BFSTraversal("S");
    }
}
