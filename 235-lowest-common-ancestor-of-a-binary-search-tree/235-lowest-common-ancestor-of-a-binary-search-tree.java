/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    private TreeNode solve(TreeNode root,TreeNode p,TreeNode q)
    {
//         condition  case either of them is root
        if(p==root || q==root)
            return root;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int minVal=0,bigVal=0;
        while(!queue.isEmpty()){
            
            TreeNode cur=queue.poll();
            minVal=Math.min(p.val,q.val); 
            bigVal=Math.max(p.val,q.val);
// condition check 
//             1.  if values are left and right of cur node obviosly cur node is answer
            if(minVal<cur.val && cur.val<bigVal)
                return cur;

//             now mark current node as parent 
            

//             if any matching node occured it is answer as we are basically one way traversing , either left child of node or right child of node
            
            if(cur==p || cur==q)
                return cur;
            
//             now we have decide which child value to traverse i.e whether to go left or right based on p and q as they both occur in same side 
             
            if(minVal<cur.val)
                queue.add(cur.left);
            else
                queue.add(cur.right);
            

        }
        return null;
        
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q);
    }
}