package com.company.narryTree;

import java.util.ArrayList;

public class Node {

    int id;
    boolean isLocked;
    Node parent;
    int lockCount;
    ArrayList<Node> children=new ArrayList<>();
    int uid;

    public Node(int id) {
        this.id = id;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "[id="+id+" locked="+isLocked+" uid="+uid+"]";
    }
}
