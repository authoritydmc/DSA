package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    Node root;
    public Node getRoot()
    {
        return root;
    }
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public static BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        return bt;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            // ... code to delete the node will go here
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }
    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }


    public void inOrderRec(Node root)
    {
        if (root==null) return;

        inOrderRec(root.left);
        System.out.println(root.value);
        inOrderRec(root.right);

    }


    public void inorder()
    {

        Stack<Node> stack=new Stack<>();

//        add root

        Node curr=root;
        while (!stack.isEmpty() || curr!=null)
        {

         while (curr!=null)
         {
             stack.add(curr);
             curr=curr.left;
         }


            curr=stack.pop();
            System.out.print(curr.value+"|");
            curr=curr.right;


        }

        System.out.println("done !!Inorder");


    }


    public void preOrder()
    {

        Stack<Node> stack=new Stack<>();

//        add root
        stack.add(root);

        while (!stack.isEmpty())
        {

            Node temp=stack.pop();

            System.out.print(temp.value+"|");
            if (!(temp.right==null))

                stack.add(temp.right);
        if (!(temp.left==null))
            stack.add(temp.left);



        }
        System.out.println("done !!PreOrder");



    }
    public void levelOrder()
    {
        Queue<Node> queue=new LinkedList<>();
        System.out.println("Start !!LevelOrder");

        queue.add(root);

        queue.add(null);
        int cnt=0;
        StringBuilder builder=new StringBuilder();
        builder.append("Level "+cnt+": [");
        while (!queue.isEmpty())
        {
            Node q=queue.poll();
            if (q==null)
            {
                builder.setLength(builder.length()-1);
                builder.append("]");
                System.out.println(builder.toString());
//                make new string from beginning
                builder.setLength(0);
                builder.append("Level "+ ++cnt +": [");

                if (queue.size()>0)
                    queue.add(null);
                continue;
            }

            builder.append(q.value+",");
            if (q.left!=null)
            {
                queue.add(q.left);
            }
            if (q.right!=null)
            {
                queue.add(q.right);
            }


        }
        System.out.println("done !!levelOrder");

    }
    public void postOrder()
    {


        Stack<Node> stack=new Stack<>();

//        add root
        stack.add(root);

        while (!stack.isEmpty())
        {

            Node temp=stack.pop();


            if (!(temp.right==null)) {
                stack.add(temp.right);

            }
            if (!(temp.left==null)) {
                stack.add(temp.left);
            continue;
            }

            System.out.print(temp.value+"|");




        }

        System.out.println("done !!postOrder");

    }


}