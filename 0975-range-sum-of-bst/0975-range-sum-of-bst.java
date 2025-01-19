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
    private int solve(TreeNode root,int low,int high)
    {
        //base case : if root is null or leaf :::
        int curSum=0;
        if(root==null)
        return 0;
        int cur=root.val;
        if(cur>=low && cur<=high)
        curSum+=cur;
       curSum+= solve(root.left,low,high);
      curSum+=   solve(root.right,low,high);
        return curSum;
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        return solve(root,low,high);
    }
}