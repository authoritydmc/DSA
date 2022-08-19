package DSA.Heap;

public class heapNode {
    int val;
    heapNode parent;
    heapNode left;
    heapNode right;

    public heapNode(int val,heapNode parent) {
        this.val = val;
        this.parent=parent;
    }
    public heapNode(int val)
    {
        this.val=val;
    }

    @Override
    public String toString() {
        return "HeapNode{val="+this.val+" }";
    }
}
