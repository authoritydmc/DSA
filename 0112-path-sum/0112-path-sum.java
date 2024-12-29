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
    private boolean solve(TreeNode root, int target) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return root.val == target;
        int modifiedTarget = target - root.val;
        return  solve(root.left, modifiedTarget) || solve(root.right, modifiedTarget);

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum);
    }
}