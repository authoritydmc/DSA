package DSA.Heap;

public class HeapRunner {
    public static void main(String[] args) {
        Heap heap=new Heap();
        heap.insert(5);
        heap.insert(4);
        heap.insert(6);
        heap.insert(1);
        heap.insert(54);
        heap.insert(434);
        heap.insert(14);

        heap.insert(-14);




        heap.print();
        System.out.println("Minimum is "+heap.peekMin());
    }
}
