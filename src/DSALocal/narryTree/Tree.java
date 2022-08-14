package DSA.narryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

//@Author :Raj Dubey

public class Tree {

    private final Node root;
    //not recommended to use directly
    public Tree(Node root) {
        this.root=root;
    }
    public static Tree getTreeInstance()
    {
        Node rootCr=new Node();
        rootCr.id=-1;
        rootCr.isLocked=false;
        rootCr.parent=null;
      Tree tree= new Tree(rootCr);
      return tree;
    }
    public boolean lock(int id,int uid)
    {
        System.out.println("locking Id with "+id+"with uid "+uid);
//        Rules for locking
//        A vertex cannot be locked if it has any locked ancestors or descendants, by any ID.
        Node node=findNode(id);
        if (node==null)
        {
            System.out.println("Can not lock as this node does not exist");
            return false;

        }
//        if node is locked or has any descendent locked
        if (node.isLocked()==true || node.getLockCount()>0)
        {
            System.out.println("This node is already locked or has some locked child node");
            return false;

        }
//        now check parents ..
        boolean isParentsLocked=false;
        Node temp=node.parent;
        while (temp!=null)
        {
            if (temp.isLocked())
            {
                System.out.println("Parent "+temp.id+" is locked so can not lock node "+id);
                isParentsLocked=true;
                return false;
            }
            temp=temp.parent;
        }
//        all check passed so lock it
        node.setLocked(true);
        node.uid=uid;
//        increase parents lock counts;
        temp=node.parent;
        while (temp!=null)
        {
            temp.lockCount+=1;
            temp=temp.parent;
        }
        System.out.println("successfully locked the node"+node+" and updated parents lock count");
        return  true;
    }

    public boolean unlock(int id,int uid)
    {

//        An unlock operation is only possible if the vertex is already locked and locked by the same id

        Node node=findNode(id);
        if (node==null)
        {
            System.out.println("can not find node ");
            return false;
        }
        if (!node.isLocked())
        {
            System.out.println("This node is not locked returning");
            return false;
        }
    if (node.uid!=uid)
    {
        System.out.println("This node is locked by "+node.uid +" so cant unlock by "+uid);
        return false;
    }
//    all condition check done
//        now decease parents lock count
        Node temp=node.parent;;
        while (temp!=null)
        {
            temp.lockCount-=1;
            temp=temp.parent;

        }
//        now unllock it

        node.setLocked(false);
        node.uid=Node.getDefaultUID();
//        return true cause its unlocked now
        System.out.println("Successfully unlocked "+node);
        return true;
    }
    public boolean upgrade(int id,int uid)
    {
        //        When a vertex is upgraded, it's locked descendants are automatically unlocked.
//        An upgrade operation is not possible if the vertex is already locked or has any locked ancestors

        Node node=findNode(id);
        if (node==null)
        {
            System.out.println("cant find node ");
            return false;
        }
        if (node.isLocked())
        {
            System.out.println("Cant upgrade its already locked ");
            return false;

        }

//        now check for ancestors.
        Node temp=node.parent;
        while (temp!=null)
        {
            if (temp.isLocked())
            {
                System.out.println("parent "+temp.id+" is locked so cant upgrade");
                return false;
            }
            temp=temp.parent;
        }
//        now upgrade process starts

//        now unlock all its childs ;

        Queue<Node> queue=new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty())
        {
            Node itr=queue.poll();
            if (itr.isLocked)
            System.out.println("Unlocking node "+itr+" to upgrade lock to "+node);
            itr.lockCount=0;
            itr.uid=Node.getDefaultUID();
            itr.isLocked=false;
            for (Node child: itr.children)
            {

                queue.add(child);
            }
        }
        node.lockCount=0;
        node.setLocked(true);
        node.uid=uid;
        System.out.println("Successfully upgraded lock to "+node);

        return true;
    }

    public void addNode(int id,int childId)
    {
//        use it to add a node to a node's children for this first find the node
        Node node=findNode(id);
        if (node==null)
        {
            System.out.println("No node exist with ID "+id);

        }
        else
        {
//            insertion start make a new node
            Node child=new Node(childId);
            child.parent=node;
            node.children.add(child);
//            done
            System.out.println("\nSuccessFully Inserted the child with id "+child+" to node "+node);

        }

    }

    public Node findNode(int id)
    {
        Queue<Node> queue=new LinkedBlockingDeque<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            Node temp=queue.poll();
             if (temp.id==id)
             {
                 return temp;
             }
             for (Node child:temp.children)
                    queue.add(child);

        }
        return null;
    }
    public void levelOrder()
    {
        Queue<Node> queue=new LinkedBlockingDeque<>();
        Node seperator=new Node(-123);
        queue.offer(root);
        queue.offer(seperator);
        while (!queue.isEmpty())
        {
            Node temp=queue.poll();
            if (temp==seperator)
            {
                System.out.println("\nendl");
                if (queue.size()>0)
                    queue.offer(seperator);
            }else
            {
                System.out.println(temp);
                for (Node child:temp.children)
                    queue.add(child);
            }
        }
    }
    public void preOrder()
    {
        System.out.println("Requesting preorder traversal ");
        preOrderRec(root);
    }
    private void preOrderRec(Node root)
    {
        if (root==null)
            return;
        System.out.print(root+"->");
        for (Node child:root.children)
        {
            preOrderRec(child);
        }
    }






}
