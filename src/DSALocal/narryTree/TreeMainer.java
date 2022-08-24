package DSA.narryTree;
//@Author :Raj Dubey
public class TreeMainer {
    public static void main(String[] args) {

        String rootNodeId="INDIA";
         Tree tree=Tree.getTreeInstance(rootNodeId);



            tree.addNode(rootNodeId,"5");
            tree.addNode(rootNodeId,"10");
            tree.addNode(rootNodeId,"15");
            tree.addNode("10","101");
            tree.addNode("10","102");
            tree.addNode("101","00254");
            tree.addNode("15","244");
            tree.addNode("244","567");



            System.out.println("\nlevel order of N ary Tree\n");

            tree.levelOrder();
//            locking check
//            tree.lock("10","901");
            tree.lock("102","902");
            tree.lock("101","KILLER");
            tree.lock("15","900");
            tree.lock("567","444");
        System.out.println("After Locking Traversal");
        tree.levelOrder();
//        now some unlocsk

        tree.unlock("567","123");
        tree.unlock("10","901");
        tree.unlock("1","452");
        tree.unlock("567","444");
        tree.unlock("15","900");


        System.out.println("After unLocking Traversal");
        tree.levelOrder();

        System.out.println(" upgrading lock ");
        tree.upgrade("10","SUPERVILLAIN");
        System.out.println("After upgrading lock traversal");
        tree.levelOrder();



    }

}
