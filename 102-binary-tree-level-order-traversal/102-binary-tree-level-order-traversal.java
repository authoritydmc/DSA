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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        
        List<List<Integer>> res=new LinkedList<>();
        
        TreeNode seperator=new TreeNode(-123);
        if(root==null)
            return res;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(seperator);
        
        List<Integer> temp=new LinkedList<>();
        
        while(!q.isEmpty())
        {
            TreeNode tnode=q.poll();
            System.out.println("Q now "+q);
            if(tnode==seperator)
            {
            
                res.add(temp);
                temp=new LinkedList<>();
                if(q.size()>0)
                q.add(seperator);
                
                
            }else
            {
                
                temp.add(tnode.val);
                
                if (tnode.left!=null)
                    q.add(tnode.left);
                if(tnode.right!=null)
                    q.add(tnode.right);
                
                
            }
            
            
        }
        
        
        
        return res;
        
    }
}