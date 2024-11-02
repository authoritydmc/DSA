/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean validate(TreeNode node,Long min,Long max)
    {
     if(node==null)
         return true;
        if(node.val>=max)
            return false;
        if(node.val<=min)
            return false;
        
        return validate(node.left,min,Long.valueOf(node.val))&&validate(node.right,Long.valueOf(node.val),max);
         
    }
    public boolean isValidBST(TreeNode root) {
        
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}