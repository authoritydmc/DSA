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
    private int traverse(TreeNode root)
    {
        if(root==null)
        return 0;
        int level=1+Math.max(traverse(root.left),traverse(root.right));

        return level;
    }
    public int maxDepth(TreeNode root) {
        return traverse(root);
    }
}