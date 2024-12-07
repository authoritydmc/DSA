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
    private void flattenRec(TreeNode root,Queue<TreeNode> q)
    {
        // best case in whole world
        if(root==null)
        return;
        
        q.add(root);

        flattenRec(root.left,q);
        flattenRec(root.right,q);
    }
    private void rebuildTree(TreeNode root,Queue<TreeNode> q)
    {
        TreeNode cur=root;
        //remove the first item as its the root
        q.poll();

        while(!q.isEmpty())
        {
            cur.right=q.poll();
            cur.left=null;
            cur=cur.right;

        }
    }

    public void flatten(TreeNode root) {
        TreeNode lstRoot = null;
        Queue<TreeNode> q=new LinkedList<>();
        flattenRec(root, q);
        rebuildTree(root,q);
    }
}