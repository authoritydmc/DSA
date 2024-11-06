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

    private TreeNode invertRec(TreeNode root)
    {

        if(root==null) return null ;
        TreeNode temp=root.left;

        root.left=root.right;
        root.right=temp;

        invertRec(root.left);
        invertRec(root.right);
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        
        return invertRec(root);
    }
}