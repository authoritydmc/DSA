/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int convert(TreeNode root,int sum) {
        if(root==null)
        return sum;
        sum=convert(root.right,sum);
        root.val+=sum;
        sum=root.val;
        return convert(root.left,sum);
        
    }

    public TreeNode convertBST(TreeNode root) {
        convert(root,0);
        return root;
    }
}