package com.company.Graph;

import com.company.Main;

import java.util.*;

public class Graph <T>{
    private final boolean enableBiDirectionInsertion;

    public Graph(boolean enableBiDirectionInsertion) {
        this.enableBiDirectionInsertion = enableBiDirectionInsertion;
    }

    private final HashMap<T, HashSet<T>> map=new HashMap<>();

    public boolean addVertex(T vertex)
    {
        if (!map.containsKey(vertex))
        {
            map.put(vertex,new HashSet<T>());
        return  true;
        }
        return  false;

    }
    public boolean addEdge(T source,T destination)
    {
       return addEdge(source,destination,enableBiDirectionInsertion);
    }

    public boolean isVertexExist(T vertex)
    {
        return map.containsKey(vertex);
    }

    public boolean isEdgeExist(T source,T destination)
    {

        if (!isVertexExist(source) || !isVertexExist(destination))
            return false;
        if (!map.get(source).contains(destination))
            return false;
        else return true;

    }
    public boolean addEdge(T source,T destination,boolean bidirection)
    {
//    create both vertex
        if (!isVertexExist(source))
            addVertex(source);

        if (!isVertexExist(destination));
            addVertex(destination);

            map.get(source).add(destination);

            if (bidirection)
                map.get(destination).add(source);
        return true;
    }
    public void BFSTraversal(T source)
    {
        BFSTraversal(source,false);
    }
    public void BFSTraversal(T source,boolean verbose)
    {
        if (verbose)
            BFSTraversalVerbose(source);
        else
            BFSTraversalWithoutVerbose(source);
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
}
