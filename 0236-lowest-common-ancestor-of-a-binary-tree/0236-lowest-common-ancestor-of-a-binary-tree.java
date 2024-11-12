/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private boolean getStack(TreeNode root, TreeNode search, List<TreeNode> stack) {
        if(root==null)
        return false;
        stack.add(root);

        if (root == search)
            return true;
        if (getStack(root.left, search, stack)|| getStack(root.right, search, stack))
        return true;
        
        stack.remove(stack.size()-1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pq = new LinkedList<>();
        List<TreeNode> qq = new LinkedList<>();
        getStack(root, p, pq);
        getStack(root, q, qq);




        int maxCheck=Math.min(pq.size(),qq.size());
        TreeNode rslt=null;
        for(int i =0;i<maxCheck;i++)
        {
            TreeNode phead=pq.get(i);
            TreeNode qhead=qq.get(i);
            System.out.println("Removed "+phead.val+" compare "+qhead.val);
            if(phead==qhead)
            rslt=phead;

        }


        return rslt;
    }
}