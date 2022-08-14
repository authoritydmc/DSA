package DSA.narryTree;

import java.util.ArrayList;
//@Author :Raj Dubey
public class Node {
//ID  needed
    int id;
    boolean isLocked;
//    store parent Id needed while insertion
    Node parent;
    int lockCount;
    ArrayList<Node> children=new ArrayList<>();
//    id of user who locks andd unlocks it
    int uid=Node.getDefaultUID();

    public Node(int id) {
        this.id = id;
    }

    public Node() {
    }

    public Node(int id, Node parent) {
        this.id = id;
        this.parent = parent;
    }

    public Node(int id, ArrayList<Node> children) {
        this.id = id;
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getLockCount() {
        return lockCount;
    }

    public void setLockCount(int lockCount) {
        this.lockCount = lockCount;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public static int getDefaultUID()
    {
        return Integer.MIN_VALUE;
    }

    @Override
    public String toString() {
        if (parent!=null)
        return "[id="+id+" locked="+isLocked+" uid="+uid+" parent id="+parent.getId()+" LockCount="+lockCount+" ]";
        else
            return "[id="+id+" locked="+isLocked+" uid="+uid+" LockCount="+lockCount+" parent =NO I AM ROOT ]";

    }
}
