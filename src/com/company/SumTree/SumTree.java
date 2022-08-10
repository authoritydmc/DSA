package com.company.SumTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SumTree {

    private  Node root;
    Scanner in=new Scanner(System.in);

    public SumTree() {

    }
    public void addNode()
    {
       root= addNodeRec(root);
    }
    private Node addNodeRec(Node root)
    {
       int data=in.nextInt();

       if (data==-1) return null;
       root=new Node(data);
        System.out.println("Enter left of "+data);
        root.left=addNodeRec(root.left);
        System.out.println("Enter right of "+data);
        root.right=addNodeRec(root.right);


       return root;
    }

    public void inOrder()
    {
        inOrderRec(root);

    }
    public boolean isSumTree()
    {
        return isSumTreeRec(root);
    }

    private boolean isSumTreeRec(Node root) {
        if (root==null || (root.left==null && root.right==null))
            return true;

        if ((root.val==sumOfTree(root.left)+sumOfTree(root.right)) && isSumTreeRec(root.left) && isSumTreeRec(root.right) )
        {
            return  true;
        }
        else return false;

    }

    public int sumOfTree(Node node) {

        if (node==null)
            return 0;

        else if (node.left==null && node.right==null)
            return node.val;

        return sumOfTree(node.left)+sumOfTree(node.right);


    }

    private void inOrderRec(Node root)
    {
        if (root==null)
            return;

        inOrderRec(root.left);
        System.out.println(root.val);
        inOrderRec(root.right);
    }
//    valid Sum Tree
// 5 1 2 -1 -1 -1 8 -1 -1
//    Invalid Sum Tree
//    5 1 -1 -1 7 -1 -1
    public void levelOrder()
    {

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty())
        {
            Node temp=queue.poll();

            if (temp==null)
            {
                System.out.println();
                if (!queue.isEmpty())
                    queue.add(null);
            }else
            {
                System.out.print(temp.val+"\t");
                if (temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
        }
    }
}
