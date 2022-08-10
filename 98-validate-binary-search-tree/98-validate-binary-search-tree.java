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
    
    private boolean isValidBSTRec(TreeNode node,int minRange,int maxRange)
    {
       if (node == null)
        return true;
   
        if (node.val<=minRange || node.val>=maxRange)
            return false;
        
        return (isValidBSTRec(node.left,minRange,node.val) && isValidBSTRec(node.right,node.val,maxRange));
        
    }
    TreeNode prev=null;
    private boolean isValidScnd(TreeNode node)
    {
     if (node!=null)
     {
         
         if(!isValidScnd(node.left))
             return false;
         if(prev!=null && node.val<=prev.val)
             return false;
         prev=node;
         
         return isValidScnd(node.right);
         
     }
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        
        // return isValidBSTRec(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return isValidScnd(root);
        
    }
}