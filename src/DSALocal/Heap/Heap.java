package DSA.Heap;

import java.util.LinkedList;
import java.util.Queue;

public class Heap {

    private heapNode root;
    private Queue<heapNode> queue=new LinkedList<>();
    public void insert(int data)
    {
//        insert it
        if (root==null)
        {
            root=new heapNode(data);
            queue.offer(root);

        }
        else
        {
            heapNode nodeToInsrt=queue.peek();
            if (nodeToInsrt.left==null)
            {
                nodeToInsrt.left=new heapNode(data,nodeToInsrt);
                heapify(nodeToInsrt.left);


            }else if (nodeToInsrt.right==null)
            {
                nodeToInsrt.right=new heapNode(data,nodeToInsrt);
                heapify(nodeToInsrt.right);

            }
            else
            {
              heapNode node=  queue.poll();
                queue.offer(node.left);
                queue.offer(node.right);
                insert(data);
            }

        }

    }

    public int peekMin()
    {
        return root.val;
    }
    private void heapify(heapNode node)
    {
//        heapify it

        heapNode temp=node;
        while (temp!=null && temp.parent!=null)
        {
            if (temp.val< temp.parent.val)
            {
              int tempval=  temp.val;
              temp.val=temp.parent.val;
              temp.parent.val=tempval;
              temp=temp.parent;
            }else {
                break;
            }
        }
    }
    public int extract_min()
    {
        int temp= root.val;
//        now remove it

        return temp;
    }
    public void printQueue()
    {
        for (heapNode node:queue)
            System.out.println(node);
    }
    public void print()
    {

        Queue<heapNode> q=new LinkedList<>();

        q.offer(root);
        q.offer(null);
        while (!q.isEmpty())
        {

            heapNode node=q.poll();
//            System.out.println("Extracted "+node+q.size()+q);
            if (node==null)
            {
                System.out.println();
                if (q.size()>0)
                    q.offer(null);
            }
            else
            {
                System.out.print(node.val+" ->");
                if (node.left!=null)
                q.offer(node.left);
                if (node.right!=null)
                q.offer(node.right);
            }
        }



    }
    public void inOrder()
    {
        inOrder(root);
    }

    private void inOrder(heapNode root) {

        if (root==null)
            return;
        inOrder(root.left);
        System.out.println(root.val+" ");
        inOrder(root.right);
    }
    public void preOrder()
    {
        preOrder(root);
    }

    private void preOrder(heapNode root) {

        if (root==null)
            return;
        System.out.println(root.val+" ");

        inOrder(root.left);
        inOrder(root.right);
    }
}
