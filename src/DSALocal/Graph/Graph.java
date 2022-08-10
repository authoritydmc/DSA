package DSA.Graph;

import java.util.*;

public class Graph <T>{

    private final boolean enableBiDirectionInsertion;

    public Graph(boolean enableBiDirectionInsertion) {
        this.enableBiDirectionInsertion = enableBiDirectionInsertion;
    }

    private final HashMap<T, HashSet<T>> map=new HashMap<>();

    public void addVertex(T vertex)
    {
        if (!map.containsKey(vertex))
        {
            map.put(vertex,new HashSet<>());
        }

    }
    public void addEdge(T source,T destination)
    {
        addEdge(source,destination,enableBiDirectionInsertion);
    }

    public boolean isVertexExist(T vertex)
    {
        return map.containsKey(vertex);
    }
    public boolean isElementExist(T element)
    {
        return isVertexExist(element);
    }

    public boolean isEdgeExist(T source,T destination)
    {

        if (!isVertexExist(source) || !isVertexExist(destination))
            return false;
        return map.get(source).contains(destination);

    }
    public void addEdge(T source,T destination,boolean bidirection)
    {
//    create both vertex
        if (!isVertexExist(source))
            addVertex(source);

        if (!isVertexExist(destination))
            addVertex(destination);

            map.get(source).add(destination);

            if (bidirection)
                map.get(destination).add(source);

    }
    public void BFSTraversal(T source)
    {
        System.out.println("Showing BFS Traversal for "+source);
        BFSTraversal(source,false);

    }
    public void BFSTraversal(T source,boolean verbose)
    {
        if (verbose)
            BFSTraversalVerbose(source);
        else
            BFSTraversalWithoutVerbose(source);
        System.out.println();
    }

    private void BFSTraversalWithoutVerbose(T source) {
        Queue<T> queue=new LinkedList<>();
        HashSet<T> visited=new HashSet<>();
        queue.add(source);

        while (!queue.isEmpty())
        {
//            get all child nodes ;
            T vertex=queue.poll();
            System.out.print(" "+vertex+" ->");
            visited.add(vertex);
            HashSet<T> childs=map.get(vertex);
            for ( T child:childs)
            {
                if (!visited.contains(child) && !queue.contains(child))
                {
                    queue.add(child);
                }

            }

        }

    }

    private void BFSTraversalVerbose(T source)
    {
        Queue<T> queue=new LinkedList<>();
        HashSet<T> visited=new HashSet<>();
        queue.add(source);

        while (!queue.isEmpty())
        {
//            get all child nodes ;
                T vertex=queue.poll();
//            System.out.print(" "+vertex+" ->");
            System.out.println("Visiting "+vertex);
            visited.add(vertex);
            System.out.println(vertex+ " is added to visited list | visited= "+visited);
            HashSet<T> childs=map.get(vertex);
            System.out.println("Childs of "+vertex+" are "+childs);
            for ( T child:childs)
            {
                if (!visited.contains(child) )
                {
                    if ( !queue.contains(child))
                    {
                        queue.add(child);
                        System.out.println(child+" is not visited so adding to queue | queue="+queue);
                    }else
                        System.out.println(child+" is already in queue to be processed | queue="+queue);

                }else
                    System.out.println(child+" is already visited ERR");

            }

        }
    }
    public boolean isPathExist(T source,T destination)
    {
        return isPathExist(source,destination,false);
    }
        public  boolean isPathExist(T source,T destination,boolean byDFS)
        {
            System.out.println("Checking path Existence between " +source+" to "+destination);
            if (byDFS)
                return isPathExist_DFS(source,destination,true);
                else
            return isPathExist_BFS(source,destination,true);

        }

    public boolean isPathExist_DFS(T source, T destination, boolean showTraversal) {

        if (!basicCheck(source, destination))
            return false;
        if (showTraversal)
        {
            DFSTraversal(source);

        }
        HashSet<T> visited=new HashSet<>();
        return isPathExistByDFSUtil(source,destination,visited);
    }

    private boolean isPathExistByDFSUtil(T source, T destination, HashSet<T> visited) {

        if (source==destination)
            return true;
        visited.add(source);
        HashSet<T> children=map.get(source);
        for (T child:children)
        {
            if (!visited.contains(child))

            {
                boolean res=isPathExistByDFSUtil(child,destination,visited);
                if (res)
                    return true;
            }


        }
        return false;
    }

    public  boolean isPathExist_BFS(T source,T destination,boolean showTraversal)
    {


//        if both Vertex Exist then only we can try to check na
           if (!basicCheck(source, destination))
               return  false;

           if (showTraversal)
           {
               BFSTraversal(source);

           }

           Queue<T> queue=new LinkedList<>();
           HashSet<T> visited=new HashSet<>();
           queue.add(source);
           while (!queue.isEmpty())
           {
               T curr=queue.poll();
               visited.add(curr);
               if (curr==destination)
                   return true;

               HashSet<T> childs=map.get(curr);
              for (T child:childs)
              {
                  if (!visited.contains(child) && !queue.contains(child))
                      queue.add(child);
              }



           }


        return false;
    }

    private boolean basicCheck(T s,T d) {
        return isVertexExist(s) && isVertexExist(d);
    }

    @Override
    public String toString() {
//        print adjency list
        StringBuilder stringBuilder=new StringBuilder();
        for (Map.Entry<T,HashSet<T>> it:map.entrySet())
        {

            stringBuilder.append("Vertex "+it.getKey()+" : ");

            for (T connection:it.getValue()) {
                stringBuilder.append(connection+" ");
            }
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();
    }
    public void DFSTraversal(T source)
    {
        System.out.println("Printing DFS traversal for "+source);
         final HashSet<T> visitedforDFS=new HashSet<>();
         DFSTraversalUtil(source,visitedforDFS);
        System.out.println();

    }
    public void DFSTraversalUtil(T source,HashSet<T> visited) {


            System.out.print(" "+source+" ->");

            visited.add(source);


        HashSet<T> children=map.get(source);
        for (T child:children)
        {
            if (!visited.contains(child))
            DFSTraversalUtil(child,visited);
        }

    }
}
