package com.company.narryTree;

public class Tree {

    private final Node root;

    public Tree(Node root) {
        this.root=root;
    }
    public boolean lock(int id,int uid)
    {
        return  false;
    }

    public boolean unlock(int id,int uid)
    {


        return false;
    }
    public void addNode(int id,int childId)
    {

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
        System.out.print(root);
        for (Node child:root.children)
        {
            preOrderRec(child);
        }
    }



    public static void main(String[] args) {

        Node root=new Node();
        root.id=-1;
        root.isLocked=false;
        root.parent=null;
        root.children.add(new Node(123));
//        a node node
        Node c1=new Node(5);
        c1.children.add(new Node(4545));
        root.children.add(c1);

        Tree tree=new Tree(root);
        tree.preOrder();

    }
}
