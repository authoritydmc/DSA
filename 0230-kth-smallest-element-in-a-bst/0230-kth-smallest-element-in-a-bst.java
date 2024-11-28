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
    private void inOrder(TreeNode root, List<Integer> lst) {
        if (root == null)
            return;

        inOrder(root.left,lst);
        lst.add(root.val);
        inOrder(root.right,lst);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> lst=new ArrayList<>();
        inOrder(root,lst);

        return lst.get(k-1);
    }
}