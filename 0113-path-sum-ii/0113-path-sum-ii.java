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
    private void solve(TreeNode root, int targetSum, List<Integer> cur,List<List<Integer>> res) {
            if(root==null)
            {
                return ;
            }
            cur.add(root.val);
            if(root.left==null && root.right==null)
            {
                if(root.val==targetSum)
                    res.add(new ArrayList<>(cur));
            }
            int newTarget=targetSum-root.val;
            
            solve(root.left,newTarget,cur,res);
            solve(root.right,newTarget,cur,res);
            cur.remove(cur.size()-1);
           

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        solve(root,targetSum,new ArrayList<>(),res);
        return res;
    }
}