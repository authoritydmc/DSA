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
        if (root.val == target && root.left==null && root.right==null)
            return true;

            boolean leftSide=false;
            boolean rightSide=false;
            int modifiedTarget=target-root.val;
            System.out.println("now find for "+modifiedTarget +" cur root val "+root.val);
            if(root.left!=null)
            {
                leftSide=solve(root.left,modifiedTarget);
            }
            if(root.right!=null)
            {
              rightSide=  solve(root.right,modifiedTarget);
            }
            return leftSide||rightSide;
           
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum);
    }
}