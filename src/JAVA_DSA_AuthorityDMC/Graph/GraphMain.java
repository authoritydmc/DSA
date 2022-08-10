package JAVA_DSA_AuthorityDMC.Graph;

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

    }
}
