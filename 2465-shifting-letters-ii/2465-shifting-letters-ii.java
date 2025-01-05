class Solution {

    //failed TLE ::: O(s*r)
    //where s is no of shift queries and r is range per query
    private String bruteSolve(String s, int[][] shifts) {
        char[] ch = s.toCharArray();

        for (int[] shift : shifts)
            for (int i = shift[0]; i <= shift[1]; i++) {
                if (shift[2] == 0) {
                    // shift backwards care for a to z
                    if (ch[i] == 'a')
                        ch[i] = 'z';
                    else
                        ch[i] -= 1;
                } else {
                    // shift forward care for z to a
                    if (ch[i] == 'z')
                        ch[i] = 'a';
                    else
                        ch[i] += 1;
                }

            }
        return new String(ch);
    }

    public String shiftingLetters(String s, int[][] shifts) {
        // return bruteSolve(s, shifts);
        return solveDiffArray(s, shifts);
    }

    private String solveDiffArray(String s, int[][] shifts) {
        char[] ch = s.toCharArray();
        int[] diffArray = new int[s.length()];

        // Build the difference array
        for (int[] shift : shifts) {
            diffArray[shift[0]] += shift[2] == 1 ? 1 : -1;
            if (shift[1] + 1 < diffArray.length)
                diffArray[shift[1] + 1] -= shift[2] == 1 ? 1 : -1;
        }

        int cumShift = 0;
        for (int i = 0; i < diffArray.length; i++) {
            cumShift += diffArray[i];
            cumShift = cumShift % 26; // Normalize shift within -25 to 25

            // Apply cumulative shift using if cases for wrap-around logic
            ch[i] += cumShift;
            if (ch[i] > 'z') {
                ch[i] = (char) ('a' + (ch[i] - 'z' - 1));
            } else if (ch[i] < 'a') {
                ch[i] = (char) ('z' - ('a' - ch[i] - 1));
            }
        }

        return new String(ch);
    }

    private String solveSegmentWay(String s,int [] [] shifts)
    {
       return new SegmentTree(s.length()).solve(s,shifts);
    }

}

public class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int size) {
        n = size;
        tree = new int[4 * n];
    }

    // Build segment tree (not necessary as we're updating directly)
    private void build(char[] arr, int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start] - 'a'; // Store character as an integer (0-25)
            return;
        }
        int mid = (start + end) / 2;
        build(arr, start, mid, 2 * node + 1);
        build(arr, mid + 1, end, 2 * node + 2);
    }

    // Update the range [l, r] with shift
    public void updateRange(int l, int r, int shift, int start, int end, int node) {
        if (start > r || end < l) // No overlap
            return;
        
        if (start == end) { // Leaf node, apply shift directly
            tree[node] = (tree[node] + shift) % 26;
            if (tree[node] < 0) tree[node] += 26; // Ensure non-negative values
            return;
        }

        int mid = (start + end) / 2;
        updateRange(l, r, shift, start, mid, 2 * node + 1);
        updateRange(l, r, shift, mid + 1, end, 2 * node + 2);
    }

    // Query to get the value at position idx
    public int query(int idx, int start, int end, int node) {
        if (start == end) { // Leaf node
            return tree[node];
        }

        int mid = (start + end) / 2;
        if (idx <= mid) {
            return query(idx, start, mid, 2 * node + 1);
        } else {
            return query(idx, mid + 1, end, 2 * node + 2);
        }
    }

    public String solve(String s, int[][] shifts) {
        char[] ch = s.toCharArray();
        n = ch.length;

        // Build the segment tree
        build(ch, 0, n - 1, 0);

        // Apply all shifts directly
        for (int[] shift : shifts) {
            int direction = shift[2] == 1 ? 1 : -1;
            updateRange(shift[0], shift[1], direction, 0, n - 1, 0);
        }

        // Build the result from the segment tree
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int shiftedValue = query(i, 0, n - 1, 0);
            result.append((char) ('a' + shiftedValue));
        }

        return result.toString();
    }
}
