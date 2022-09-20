/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    void solve(Node node,List<Integer> lst)
    {
        if(node==null)
            return ;
         lst.add(node.val);
        
        for(Node child:node.children)
        {
            
            solve(child,lst);
            
        }
       
        
        
    }
    
    public List<Integer> preorder(Node root) {
        
        List<Integer> lst=new ArrayList<>();
       solve(root,lst);
        return lst;
        
    }
}