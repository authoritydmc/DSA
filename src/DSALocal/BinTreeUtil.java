package DSA;

public class BinTreeUtil {

    private static BinaryTree root;
    public static void main(String[] args) {

    root=BinaryTree.createBinaryTree();


    root.add(123);
    root.add(20);
    root.add(-3);
    root.add(7845);

    root.inorder();
//    root.inOrderRec(root.getRoot());
    root.preOrder();
    root.postOrder();
    root.levelOrder();

    }
}
