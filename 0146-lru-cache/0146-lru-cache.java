class LRUCache {
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    DoubleLinkedList lst;

    public LRUCache(int capacity) {
        System.out.println("Init with cap "+capacity);
        this.capacity = capacity;
        this.lst = new DoubleLinkedList();
    }

    public int get(int key) {
        System.out.println("getting val for key " + key);
        Node found = map.getOrDefault(key, null);
        if (found != null) {
            // key exist and is recently used so removed it and put it at front marking
            // latest use
            int val = found.value;
            lst.remove(found);
            map.put(key, lst.push_front(key, val));
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        // System.out.println("inserting " + key + " with " + value);
        Node found = map.getOrDefault(key, null);
        if (found != null) {
           lst.remove(found);
           map.put(key,lst.push_front(key,value));
        } else {
            if (capacity > 0) {
                // we can simply put it front ////
                map.put(key, lst.push_front(key, value));
                capacity--;
            } else {
                // we need to evict least recently used .. by definition its the tail node...
                // also remove the key ...

                Node lru = lst.getLastNode();
                // System.out.println("capacity breachead .. " + capacity + "first removing " + lru.key);
                // lst.printList();
                lst.remove(lru);
                map.remove(lru.key);
                map.put(key, lst.push_front(key, value));

            }

        }
        // System.out.println("insertion done  " + key + " with " + value);

    }
}

class DoubleLinkedList {
    // special nodes to maintain strucuture
    private Node head;
    private Node tail;

    public Node getLastNode() {
        return tail.prev;
    }

    public void printList() {
        Node temp = head;
        Node back=tail;
        while (temp != null) {
            System.out.print(temp.key + "->");
            temp = temp.next;
        }
        System.out.println();
           while (back != null) {
            System.out.print(back.key + "<-");
            back = back.prev;
        }
        System.out.println();
    }

    public DoubleLinkedList() {
        // initialise it
        this.head = new Node(-999, -1);
        this.tail = new Node(-999, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public Node push_front(int key, int value) {
        Node temp = new Node(key, value);
        // this node will be inserted at front ...
        // new nodes next should be what head next was
        temp.next = head.next;
        // new node prev is now head
        temp.prev = head;
        head.next.prev=temp;

        // head next is new Node
        head.next = temp;
        return temp;
    }

    public Node push_back(int key, int value) {
        Node temp = new Node(key, value);
        // inserting at the back before tail so we need to
        // 1 . mark tail prev next to temp
        tail.prev.next = temp;
        // now we make sure temp prev and next is marked properly

        temp.prev = tail.prev;
        temp.next = tail;
        // also tail's prev should now be temp
        tail.prev = temp;

        return temp;
    }

    // node deleted
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    int value;
    int key;
    Node prev = null;
    Node next = null;

    public Node() {

    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node(int key, int value, Node prev, Node next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */