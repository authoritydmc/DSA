package DSA.SumTree;

public class StreeMain {

    public static void main(String[] args) {
        SumTree sumTree=new SumTree();
        sumTree.addNode();
        System.out.println("Printing inOrder");
        sumTree.inOrder();
        System.out.println("Printing level Order");
        sumTree.levelOrder();
       boolean res= sumTree.isSumTree();
        System.out.println("Is it SumTree "+res);

//        Input to test
        //    valid Sum Tree
//        25 22 13 2 -1 -1 11 -1 -1 9 -1 -1 3 2 -1 -1 1 -1 -1


// 5 1 2 -1 -1 -1 8 -1 -1
//    Invalid Sum Tree
//    5 1 -1 -1 7 -1 -1
    }
}
