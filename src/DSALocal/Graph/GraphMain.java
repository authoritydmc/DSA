package DSA.Graph;

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
        graph.addEdge("W","R",false);
        graph.addEdge("R","A");
        graph.addEdge("A","J");
//        graph.addEdge("J","S");


        System.out.println(graph);

        graph.BFSTraversal("D");
        graph.DFSTraversal("D");

       boolean isPaththere= graph.isPathExist("S","D");
        System.out.println("Is path Exist "+isPaththere);


        System.out.println(graph.isPathExist("S","D",true));

//        without any extra thing printed
        System.out.println(graph.isPathExist_DFS("S","D",false));


//        new Graph

        Graph<String> ng=new Graph<>(false);
        ng.addEdge("A","G");
        ng.addEdge("G","Z");
        ng.addEdge("A","Z");
        ng.addEdge("Z","D");
        ng.addEdge("G","D");

        ng.BFSTraversal("A");
        ng.topoLogicalTraversal();

        System.out.println("Now checking for topsort");

        Graph<Integer> gg=new Graph<>(false);
//https://practice.geeksforgeeks.org/problems/topological-sort/1 q2
        gg.addEdge(4,0);
        gg.addEdge(5,0);
        gg.addEdge(5,2);
        gg.addEdge(2,3);
        gg.addEdge(1,3);
        gg.addEdge(4,1);

        gg.topoLogicalTraversal();

    }
}
