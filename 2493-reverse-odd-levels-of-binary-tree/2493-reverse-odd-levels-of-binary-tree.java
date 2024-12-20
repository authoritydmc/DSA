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
    public TreeNode reverseOddLevels(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int lvl = 0;
        while (!q.isEmpty()) {

            int n = q.size();
            ArrayList<TreeNode> nodes = new ArrayList<>();
            while (n > 0) {
                TreeNode node = q.poll();
                nodes.add(node);
                if(node.left!=null)
                q.add(node.left);
                if(node.right!=null)
                q.add(node.right);
                n--;
            }
            
            if((lvl&1)!=0)
            {
                // System.out.println("Odd lvl reverse it brp"+lvl);
                int start=0;
                int end=nodes.size()-1;
                while(start<=end)
                {
                    int t=nodes.get(start).val;
                    nodes.get(start).val=nodes.get(end).val;
                    nodes.get(end).val=t;
                    start++;
                    end--;
                }
            }

            lvl++;
        
        }
        return root;
    }
}