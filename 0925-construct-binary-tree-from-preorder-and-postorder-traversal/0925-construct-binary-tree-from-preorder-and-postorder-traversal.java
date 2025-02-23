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
    Map<Integer,Integer> idxMap;
    private TreeNode build(int [] pre,int [] post,int i1,int i2,int j1,int j2)
    {
        if(i1>i2 || j1>j2)
        return null;

        TreeNode node=new TreeNode(pre[i1]);

        if(i1!=i2)
        {
            int left_child_val=pre[i1+1];
            int mid_idx=idxMap.get(left_child_val);
            int size=mid_idx-j1+1;
            node.left=build(pre,post,i1+1,i1+size,j1,mid_idx);

            node.right=build(pre,post,i1+size+1,i2,mid_idx+1,j2-1);
        }

        return node;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        //pre order :
        //root left right

        //post order : left right root
        idxMap=new HashMap<>();
        for(int i=0;i<postorder.length;i++)
            idxMap.put(postorder[i],i);
        
        return build(preorder,postorder,0,preorder.length-1,0,postorder.length-1);
    }
}