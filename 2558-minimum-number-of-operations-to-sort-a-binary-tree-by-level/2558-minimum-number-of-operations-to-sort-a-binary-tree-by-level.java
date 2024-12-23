
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
    private int makeSorted(int[] arr) {
        int swaps = 0;
        int[] target = arr.clone();
        Arrays.sort(target);

        // Map to track current positions of values
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            pos.put(arr[i], i);
        }

        // For each position, swap until correct value is placed
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                swaps++;

                // Update position of swapped values
                int curPos = pos.get(target[i]);
                pos.put(arr[i], curPos);
                arr[curPos] = arr[i];
            }
        }
        return swaps;
    }

 

    public int minimumOperations(TreeNode root) {
        int count = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int s = q.size();
            int[] vals = new int[s];
            int cnt = 0;
            while (cnt < s) {
                TreeNode node = q.poll();
                vals[cnt++] = node.val;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            int swaps = makeSorted(vals);
            // System.out.println(" for lvl " + vals + " swaps requires is " + swaps);
            count += swaps;
        }

        return count;
    }
}