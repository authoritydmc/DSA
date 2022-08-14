package DSA.narryTree;

import java.util.ArrayList;
//@Author :Raj Dubey
public class Node <T>{
//ID  needed
    T id;
    boolean isLocked;
//    store parent Id needed while insertion
    Node parent;
    int lockCount;
    ArrayList<Node> children=new ArrayList<>();
//    id of user who locks andd unlocks it
    String uid=Node.getDefaultUID();

    public Node(T id) {
        this.id = id;
    }

    public Node() {
    }

    public Node(T id, Node parent) {
        this.id = id;
        this.parent = parent;
    }

    public Node(T id, ArrayList<Node> children) {
        this.id = id;
        this.children = children;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public static String  getDefaultUID()
    {
        return "NA";

    }

    @Override
    public String toString() {
        if (parent!=null)
        return "[id="+id+" locked="+isLocked+" uid="+uid+" parent id="+parent.getId()+" LockCount="+lockCount+" ]";
        else
            return "[id="+id+" locked="+isLocked+" uid="+uid+" LockCount="+lockCount+" parent =NO I AM ROOT ]";

    }
}
