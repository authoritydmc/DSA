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
    private boolean validate(TreeNode root,Long leftVal,Long rightVal) {
        if (root == null)
            return true;


        return root.val>leftVal && root.val < rightVal && validate(root.left,leftVal,(long)root.val) && validate(root.right,(long)root.val,rightVal);

    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}